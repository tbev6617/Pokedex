package pokemon.model.monsters;

import java.util.List;
import java.util.ArrayList;

public abstract class Pokemon 
{
	private String name;
	private boolean evolvable;
	private int number;
	private int hp;
	private int atk;
	private double enhancementModifier;
	
	public Pokemon(int number, String name)
	{
		this.number = number;
		this.name = name;
	}
	
	public final String[] getPokemonTypes()
	{
		String[] types = null;
		ArrayList<String> parentType = new ArrayList<String>();
		Class<?> currentClass = this.getClass();
		
		//add the interfaces one by one
		while(currentClass.getSuperclass() != null)
		{
			Class<?>[] pokeTypes = currentClass.getInterfaces();
			types = new String[pokeTypes.length];
			
			for(int i = 0; i < types.length; i++)
			{
				//get name
				String currentInterface = pokeTypes[i].getCanonicalName();
				//remove all the messy stuff
				currentInterface = currentInterface.replace(this.getClass().getPackage().getName() + ".", "");
				//add the name to my list if I don't have it
				if(!parentType.contains(currentInterface))
				{
					parentType.add(currentInterface);
				}
			}
			currentClass = currentClass.getSuperclass();
		}
		
		//convert list to a string
		types = new String [parentType.size()];
		
		for(int i = 0; i < parentType.size(); i++)
		{
			types[i] = parentType.get(i);
		}
		
		return types;
	}
	public String toString()
	{
		return name + ". HP: " + hp;
	}
	
	public String getPokeInfo()
	{
		return "";
	}

	public String getName() 
	{
		return name;
	}

	public boolean isEvolvable() 
	{
		return evolvable;
	}

	public int getNumber() 
	{
		return number;
	}

	public int getHp() 
	{
		return hp;
	}

	public int getAtk() 
	{
		return atk;
	}

	public double getEnhancementModifier() 
	{
		return enhancementModifier;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public void setCanEvolve(boolean canEvolve) 
	{
		this.evolvable = canEvolve;
	}

	public void setHp(int hp) 
	{
		this.hp = hp;
	}

	public void setAtk(int atk) 
	{
		this.atk = atk;
	}

	public void setEnhancementModifier(double enhancementModifier) 
	{
		this.enhancementModifier = enhancementModifier;
	}
	
}
