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
		appLayout.putConstraint(SpringLayout.EAST, evolvableBox, 0, SpringLayout.EAST, attackField);
		appLayout.putConstraint(SpringLayout.WEST, numberField, 19, SpringLayout.EAST, attackField);
		appLayout.putConstraint(SpringLayout.WEST, attackField, 0, SpringLayout.WEST, nameField);
		healthField = new JTextField("hp");
		appLayout.putConstraint(SpringLayout.EAST, healthField, 0, SpringLayout.EAST, numberField);
		modifierField = new JTextField("mod");
		appLayout.putConstraint(SpringLayout.NORTH, evolvableBox, 6, SpringLayout.SOUTH, modifierField);
		appLayout.putConstraint(SpringLayout.WEST, modifierField, 0, SpringLayout.WEST, attackField);
		
		iconLabel = new JLabel("Pokemon", new ImageIcon(getClass().getResource("/pokemon.view.images.Pokeball.png")), JLabel.CENTER);
		appLayout.putConstraint(SpringLayout.WEST, iconLabel, 10, SpringLayout.WEST, this);
		
		nameLabel = new JLabel("name");
		appLayout.putConstraint(SpringLayout.NORTH, nameField, -5, SpringLayout.NORTH, nameLabel);
		appLayout.putConstraint(SpringLayout.WEST, nameField, 30, SpringLayout.EAST, nameLabel);
		evolvableLabel = new JLabel("evolvable");
		numberLabel = new JLabel("number");
		appLayout.putConstraint(SpringLayout.NORTH, numberField, -5, SpringLayout.NORTH, numberLabel);
		appLayout.putConstraint(SpringLayout.NORTH, numberLabel, 11, SpringLayout.SOUTH, nameLabel);
		appLayout.putConstraint(SpringLayout.WEST, numberLabel, 0, SpringLayout.WEST, nameLabel);
		attackLabel = new JLabel("attack");
		appLayout.putConstraint(SpringLayout.NORTH, attackField, -5, SpringLayout.NORTH, attackLabel);
		appLayout.putConstraint(SpringLayout.WEST, evolvableLabel, 0, SpringLayout.WEST, attackLabel);
		appLayout.putConstraint(SpringLayout.NORTH, attackLabel, 6, SpringLayout.SOUTH, numberLabel);
		appLayout.putConstraint(SpringLayout.WEST, attackLabel, 0, SpringLayout.WEST, nameLabel);
		healthLabel = new JLabel("health");
		appLayout.putConstraint(SpringLayout.NORTH, healthField, -5, SpringLayout.NORTH, healthLabel);
		appLayout.putConstraint(SpringLayout.WEST, healthLabel, 0, SpringLayout.WEST, attackLabel);
		modifierLabel = new JLabel("modifier");
		appLayout.putConstraint(SpringLayout.NORTH, modifierField, -5, SpringLayout.NORTH, modifierLabel);
		appLayout.putConstraint(SpringLayout.NORTH, modifierLabel, 162, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.SOUTH, healthLabel, -6, SpringLayout.NORTH, modifierLabel);
		appLayout.putConstraint(SpringLayout.NORTH, evolvableLabel, 6, SpringLayout.SOUTH, modifierLabel);
		appLayout.putConstraint(SpringLayout.WEST, modifierLabel, 0, SpringLayout.WEST, attackLabel);
		pokedexDropdown = new JComboBox();
		appLayout.putConstraint(SpringLayout.WEST, pokedexDropdown, 365, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, pokedexDropdown, -23, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.EAST, pokedexDropdown, -10, SpringLayout.EAST, this);
		clearButton = new JButton("clear");
		appLayout.putConstraint(SpringLayout.NORTH, nameLabel, 8, SpringLayout.SOUTH, clearButton);
		saveButton = new JButton("save");
		appLayout.putConstraint(SpringLayout.WEST, saveButton, 340, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.NORTH, clearButton, 0, SpringLayout.NORTH, saveButton);
		appLayout.putConstraint(SpringLayout.EAST, clearButton, -23, SpringLayout.WEST, saveButton);
		
		descriptionArea = new JTextArea(5, 10);
		appLayout.putConstraint(SpringLayout.NORTH, iconLabel, 49, SpringLayout.SOUTH, descriptionArea);
		appLayout.putConstraint(SpringLayout.WEST, descriptionArea, 0, SpringLayout.WEST, iconLabel);
		typeArea = new JTextArea(4, 15);
		appLayout.putConstraint(SpringLayout.WEST, nameLabel, 30, SpringLayout.EAST, typeArea);
		appLayout.putConstraint(SpringLayout.NORTH, saveButton, -5, SpringLayout.NORTH, typeArea);
		appLayout.putConstraint(SpringLayout.NORTH, descriptionArea, 6, SpringLayout.SOUTH, typeArea);
		appLayout.putConstraint(SpringLayout.NORTH, typeArea, 28, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.WEST, typeArea, 10, SpringLayout.WEST, this);
		
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
		nameField.setText(appController.getPokedex().get(index).getName());
		evolvableBox.setSelected(appController.getPokedex().get(index).isEvolvable());
		numberField.setText("#" + appController.getPokedex().get(index).getNumber());
		attackField.setText(appController.getPokedex().get(index).getAtk() + "");
		healthField.setText(appController.getPokedex().get(index).getHp() + "");
		modifierField.setText(appController.getPokedex().get(index).getEnhancementModifier() + "");
	}
	
}