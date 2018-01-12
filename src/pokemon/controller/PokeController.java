package pokemon.controller;

import java.util.ArrayList;
import java.util.List;
import pokemon.model.monsters.*;
import pokemon.view.PokeFrame;


public class PokeController 
{
	private List<Pokemon> pokedex;
	private PokeFrame appFrame;
	
	public PokeController()
	{
		pokedex = new ArrayList<Pokemon>();
		buildPokedex();
		
		appFrame = new PokeFrame(this);
	}
	
	public void start()
	{
		
	}
	
	public void buildPokedex()
	{
		pokedex.add(new Magikarp("Garth"));
		pokedex.add(new Gyarados("GaryDos"));
		pokedex.add(new Pikachu());
		pokedex.add(new Raichu());
		pokedex.add(new Piplup());
		pokedex.add(new CatJamal());
	}
	
	public String[] convertPokedex()
	{
		String[] names = new String[pokedex.size()];
		
		for (int i = 0; i < pokedex.size(); i++)
		{
			names[i] = pokedex.get(i).getName();
		}
		
		return names;
	}		
	
	public List<Pokemon> getPokedex()
	{
		return pokedex;
	}
	//TODO
	//public void updateSelected(int selection, int health, int attack, boolean evolve, double modify)
	
	private boolean isValidInteger(String sample) 
	{
		boolean valid = false;
		try
		{
			Integer.parseInt(sample);
			valid = true;
		}
		catch(NumberFormatException error)
		{
			System.out.println("Only integer values are valid: " + sample + " is not a valid integer.");
		}
		return valid;
	}
	
	private boolean isValidDouble(String sample) 
	{
		boolean valid = false;
		try {
			Double.parseDouble(sample);
			valid = true;
		}
		catch(NumberFormatException error)
		{
			System.out.println("Only double (AKA number) values are valid: " + sample + " is not a valid double.");
		}
		return valid;
	}
}
