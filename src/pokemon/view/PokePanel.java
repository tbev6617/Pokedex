package pokemon.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import pokemon.controller.PokeController;

public class PokePanel extends JPanel
{
	private PokeController appController;
	private SpringLayout appLayout;
	private JLabel healthLabel;
	private JLabel attackLabel;
	private JLabel nameLabel;
	private JLabel numberLabel;
	private JLabel evolvableLabel;
	private JLabel modifierLabel;
	private JLabel iconLabel;
	
	private JCheckBox evolvableBox;
	private JTextField nameField;
	private JTextField numberField;
	private JTextField attackField;
	private JTextField healthField;
	private JTextField modifierField;
	
	private JTextArea descriptionArea;
	private JTextArea typeArea;
	
	private JButton saveButton;
	private JButton clearButton;
	private JComboBox pokedexDropdown;
	
	private JPanel firstType;
	private JPanel secondType;
	
	public PokePanel(PokeController appController)
	{
		super();
		this.appController = appController;
		
		appLayout = new SpringLayout();
		
		evolvableBox = new JCheckBox();
		nameField = new JTextField("name");
		numberField = new JTextField("#");
		attackField = new JTextField("atk");
		healthField = new JTextField("hp");
		modifierField = new JTextField("mod");
		
		iconLabel = new JLabel("Pokemon", new ImageIcon(getClass().getResource("/pokemon.view.images.Pokeball.png")), JLabel.CENTER);
		
		nameLabel = new JLabel("name");
		evolvableLabel = new JLabel("evolvable");
		numberLabel = new JLabel("number");
		attackLabel = new JLabel("attack");
		healthLabel = new JLabel("health");
		modifierLabel = new JLabel("modifier");
		pokedexDropdown = new JComboBox();
		clearButton = new JButton("clear");
		saveButton = new JButton("save");
		
		descriptionArea = new JTextArea(5, 10);
		typeArea = new JTextArea(4, 15);
		
		firstType = new JPanel();
		secondType = new JPanel();
		
		setupComboBox();
		updateTypePanels();
		setupPanel();
		setupLayout();
		setupListeners();
	}
	private void setupPanel()
	{
		this.setLayout(appLayout);
		
		this.setBackground(Color.CYAN);
		this.add(iconLabel);
		this.add(attackLabel);
		this.add(attackField);
		this.add(healthLabel);
		this.add(healthField);
		this.add(modifierLabel);
		this.add(modifierField);
		this.add(nameLabel);
		this.add(nameField);
		this.add(numberLabel);
		this.add(numberField);
		this.add(evolvableLabel);
		this.add(evolvableBox);
		this.add(pokedexDropdown);
		this.add(clearButton);
		this.add(saveButton);
		
		this.add(descriptionArea);
		this.add(typeArea);
	}
	
	public void setupLayout()
	{
		//TODO
		appLayout.putConstraint(SpringLayout.NORTH, iconLabel, -50, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.WEST, iconLabel, 30, SpringLayout.WEST, this);
		
		appLayout.putConstraint(SpringLayout.NORTH, numberLabel, -125, SpringLayout.NORTH, iconLabel);
		appLayout.putConstraint(SpringLayout.EAST, numberLabel, 200, SpringLayout.EAST, iconLabel);
		
		appLayout.putConstraint(SpringLayout.NORTH, numberField, -125, SpringLayout.NORTH, iconLabel);
		appLayout.putConstraint(SpringLayout.WEST, numberField, 300, SpringLayout.EAST, numberLabel);
		
		appLayout.putConstraint(SpringLayout.NORTH, nameLabel, -100, SpringLayout.NORTH, iconLabel);
		appLayout.putConstraint(SpringLayout.EAST, nameLabel, 200, SpringLayout.EAST, iconLabel);
		
		appLayout.putConstraint(SpringLayout.NORTH, attackLabel, -75, SpringLayout.NORTH, iconLabel);
		appLayout.putConstraint(SpringLayout.EAST, attackLabel, 200, SpringLayout.EAST, iconLabel);
		
		appLayout.putConstraint(SpringLayout.NORTH, healthLabel, -50, SpringLayout.NORTH, iconLabel);
		appLayout.putConstraint(SpringLayout.EAST, healthLabel, 200, SpringLayout.EAST, iconLabel);
		
		appLayout.putConstraint(SpringLayout.NORTH, modifierLabel, -25, SpringLayout.NORTH, iconLabel);
		appLayout.putConstraint(SpringLayout.EAST, modifierLabel, 200, SpringLayout.EAST, iconLabel);
		
		appLayout.putConstraint(SpringLayout.NORTH, evolvableLabel, 0, SpringLayout.NORTH, iconLabel);
		appLayout.putConstraint(SpringLayout.EAST, evolvableLabel, 200, SpringLayout.EAST, iconLabel);
	}
	
	public void setupListeners()
	{
		pokedexDropdown.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent selection)
			{
				int selectedPokemonIndex = pokedexDropdown.getSelectedIndex();
				updatePokedexInfo(selectedPokemonIndex);
				updateImage(); 
				updateTypePanels();
				repaint();
			}
		});
	}
	
	public void updateTypePanels()
	{
		String[] types = appController.getPokedex().get(pokedexDropdown.getSelectedIndex()).getPokemonTypes();
		
		if (types[0].equals("ElectricType"))
		{
			firstType.setBackground(Color.YELLOW);
		}
		else if (types[0].equals("WaterType"))
		{
			firstType.setBackground(Color.BLUE);
		}
		else if (types[0].equals("PunType"))
		{
			firstType.setBackground(Color.PINK);
		}
		
		//TODO SECOND TYPE
	}
	private void updatePokedexInfo(int index)
	{
		//update basic fields
		nameField.setText(appController.getPokedex().get(index).getName());
		evolvableBox.setSelected(appController.getPokedex().get(index).isEvolvable());
		numberField.setText("#" + appController.getPokedex().get(index).getNumber());
		attackField.setText(appController.getPokedex().get(index).getAtk() + "");
		healthField.setText(appController.getPokedex().get(index).getHp() + "");
		modifierField.setText(appController.getPokedex().get(index).getEnhancementModifier() + "");
		
		//Update text areas
		descriptionArea.setText(appController.getPokedex().get(index).toString());
		typeArea.setText("");
		
		for (String current : appController.getPokedex().get(index).getPokemonTypes())
		{
			typeArea.append(current + "\n");
		}
	}
	private void setupComboBox()
	{
		DefaultComboBoxModel pokemonModel = new DefaultComboBoxModel(appController.convertPokedex());
		pokedexDropdown.setModel(pokemonModel);
	}
	private void updateImage()
	{
		String path = "/pokemon/view/images/";
		String defaultName = "Pokeball";
		String name = pokedexDropdown.getSelectedItem().toString();
		String extension = ".png";
		ImageIcon pokemonIcon;
		
		try
		{
			pokemonIcon = new ImageIcon(getClass().getResource(path + name + extension));
		}
		catch (NullPointerException missingImageFile)
		{
			pokemonIcon = new ImageIcon(getClass().getResource(path + defaultName + extension));
		}
		iconLabel.setIcon(pokemonIcon);
	}
	
}