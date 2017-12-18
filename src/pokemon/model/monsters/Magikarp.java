package pokemon.model.monsters;

import pokemon.model.types.*;

public class Magikarp extends Pokemon implements WaterType
{
	public Magikarp(int number)
	{
		super(number, "Magikarp");
	}
	public Magikarp(int number, String name)
	{
		super(number, name);
	}
	
	public void splash()
	{
		System.out.println("You done been splashed. It had no effect");
	}
	
	public void bubble()
	{
		System.out.println("You done been hit by a bubble. It had no effect");
	}
	
	public void wave()
	{
		System.out.println("You done been hit by a wave. It had no effect");
	}
}
