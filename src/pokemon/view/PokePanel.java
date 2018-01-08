package pokemon.view;

import java.awt.Color;
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
	//private JPanel thirdType;
	//private JPanel fourthType;
	
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
		
		//TODO Pokemon Panel 13
		
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
	
	public void setupComboBox()
	{
		
	}
	
	public void setupListeners()
	{
		
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