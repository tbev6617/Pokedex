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
		appLayout.putConstraint(SpringLayout.WEST, nameField, 373, SpringLayout.WEST, this);
		numberField = new JTextField("#");
		appLayout.putConstraint(SpringLayout.EAST, numberField, -59, SpringLayout.EAST, this);
		attackField = new JTextField("atk");
		appLayout.putConstraint(SpringLayout.WEST, evolvableBox, 0, SpringLayout.WEST, attackField);
		appLayout.putConstraint(SpringLayout.EAST, attackField, -10, SpringLayout.EAST, nameField);
		healthField = new JTextField("hp");
		appLayout.putConstraint(SpringLayout.NORTH, healthField, 6, SpringLayout.SOUTH, attackField);
		appLayout.putConstraint(SpringLayout.WEST, healthField, 0, SpringLayout.WEST, attackField);
		modifierField = new JTextField("mod");
		appLayout.putConstraint(SpringLayout.NORTH, evolvableBox, 6, SpringLayout.SOUTH, modifierField);
		appLayout.putConstraint(SpringLayout.EAST, modifierField, -10, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.NORTH, modifierField, 220, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.WEST, modifierField, 373, SpringLayout.WEST, this);
		
		iconLabel = new JLabel("Pokemon", new ImageIcon(getClass().getResource("/pokemon/view/images/Pokeball.png")), JLabel.CENTER);
		appLayout.putConstraint(SpringLayout.SOUTH, iconLabel, -27, SpringLayout.SOUTH, this);
		
		nameLabel = new JLabel("name");
		appLayout.putConstraint(SpringLayout.EAST, nameLabel, -16, SpringLayout.WEST, nameField);
		appLayout.putConstraint(SpringLayout.NORTH, nameField, -5, SpringLayout.NORTH, nameLabel);
		appLayout.putConstraint(SpringLayout.SOUTH, nameLabel, -154, SpringLayout.SOUTH, this);
		evolvableLabel = new JLabel("evolvable");
		appLayout.putConstraint(SpringLayout.SOUTH, evolvableLabel, 0, SpringLayout.SOUTH, iconLabel);
		appLayout.putConstraint(SpringLayout.EAST, evolvableLabel, -27, SpringLayout.WEST, evolvableBox);
		numberLabel = new JLabel("number");
		appLayout.putConstraint(SpringLayout.NORTH, numberField, 0, SpringLayout.NORTH, numberLabel);
		appLayout.putConstraint(SpringLayout.EAST, numberLabel, -93, SpringLayout.EAST, this);
		attackLabel = new JLabel("attack");
		appLayout.putConstraint(SpringLayout.NORTH, attackField, 0, SpringLayout.NORTH, attackLabel);
		appLayout.putConstraint(SpringLayout.NORTH, attackLabel, 6, SpringLayout.SOUTH, nameLabel);
		appLayout.putConstraint(SpringLayout.EAST, attackLabel, -93, SpringLayout.EAST, this);
		healthLabel = new JLabel("health");
		appLayout.putConstraint(SpringLayout.NORTH, healthLabel, 5, SpringLayout.NORTH, healthField);
		appLayout.putConstraint(SpringLayout.WEST, healthLabel, 0, SpringLayout.WEST, attackLabel);
		modifierLabel = new JLabel("modifier");
		appLayout.putConstraint(SpringLayout.SOUTH, modifierLabel, -59, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.EAST, modifierLabel, -16, SpringLayout.WEST, modifierField);
		pokedexDropdown = new JComboBox();
		appLayout.putConstraint(SpringLayout.EAST, iconLabel, -22, SpringLayout.WEST, pokedexDropdown);
		appLayout.putConstraint(SpringLayout.WEST, pokedexDropdown, 173, SpringLayout.WEST, this);
		clearButton = new JButton("clear");
		appLayout.putConstraint(SpringLayout.NORTH, pokedexDropdown, 5, SpringLayout.SOUTH, clearButton);
		appLayout.putConstraint(SpringLayout.SOUTH, clearButton, 0, SpringLayout.SOUTH, modifierLabel);
		appLayout.putConstraint(SpringLayout.EAST, clearButton, -42, SpringLayout.WEST, modifierLabel);
		saveButton = new JButton("save");
		appLayout.putConstraint(SpringLayout.EAST, saveButton, 0, SpringLayout.EAST, clearButton);
		
		descriptionArea = new JTextArea(5, 10);
		appLayout.putConstraint(SpringLayout.NORTH, descriptionArea, 28, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.WEST, descriptionArea, 0, SpringLayout.WEST, iconLabel);
		typeArea = new JTextArea(4, 15);
		appLayout.putConstraint(SpringLayout.NORTH, saveButton, 78, SpringLayout.SOUTH, typeArea);
		appLayout.putConstraint(SpringLayout.NORTH, numberLabel, 6, SpringLayout.SOUTH, typeArea);
		appLayout.putConstraint(SpringLayout.NORTH, typeArea, 0, SpringLayout.NORTH, descriptionArea);
		appLayout.putConstraint(SpringLayout.WEST, typeArea, 0, SpringLayout.WEST, clearButton);
		
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
		
		saveButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				if(appController.isValidInteger(attackField.getText()) && appController.isValidInteger(healthField.getText()) && appController.isValidDouble(modifierField.getText()))
				{
					int selected = pokedexDropdown.getSelectedIndex();
					int health = Integer.parseInt(healthField.getText());
					int attack = Integer.parseInt(attackField.getText());
					double modifier = Double.parseDouble(modifierField.getText());
					String name = nameField.getText();
					boolean evolvable = evolvableBox.isSelected();
					
					appController.updateSelected(selected, health, attack, evolvable, modifier, name);
					
				}
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