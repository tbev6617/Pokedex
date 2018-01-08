package pokemon.controller;

import java.util.ArrayList;
import java.util.List;
import pokemon.model.monsters.*;


public class PokeController 
{
	private List<Pokemon> pokedex;
	
	public PokeController()
	{
		pokedex = new ArrayList<Pokemon>();
		buildPokedex();
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
		pokedex.add(new Piplup("Joshie"));
		pokedex.add(new CatJamal());
	}
	
	public List<Pokemon> getPokedex()
	{
		return pokedex;
	}
	
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
