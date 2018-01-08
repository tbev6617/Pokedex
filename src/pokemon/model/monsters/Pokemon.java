package pokemon.model.monsters;

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
		Class<?> [] types = getClass().getInterfaces();
		String [] pokeTypes = new String[types.length];
		
		for(int i = 0; i < types.length; i++)
		{
			String currentInterface = types[i].getCanonicalName();
			currentInterface = currentInterface.replace(this.getClass().getPackage().getName() + ".", "");
			pokeTypes[i] = currentInterface;
		}
		
		return pokeTypes;
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
