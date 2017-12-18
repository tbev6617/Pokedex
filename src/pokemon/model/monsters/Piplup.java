package pokemon.model.monsters;

import pokemon.model.types.*;

public class Piplup extends Pokemon implements WaterType
{
	public Piplup(int number)
	{
		super(number, "Piplup");
	}
	public Piplup(int number, String name)
	{
		super(number, name);
	}
	
	public void splash()
	{
		System.out.println("You done been splashed");
	}
	
	public void bubble()
	{
		System.out.println("You done been hit by a bubble");
	}
	
	public void wave()
	{
		System.out.println("You done been hit by a wave");
	}
}
