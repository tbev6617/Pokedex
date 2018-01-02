package pokemon.model.monsters;

import pokemon.model.types.*;

public class Magikarp extends Pokemon implements WaterType
{
	public Magikarp()
	{
		super(129, "Magikarp");
		setup();
	}
	public Magikarp(String name)
	{
		super(129, name);
		setup();
	}
	public Magikarp(int number, String name)
	{
		super(number, name);
		setup();
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
	protected void setup()
	{
		this.setAtk(100);
		this.setHp(1000);
		this.setCanEvolve(true);
		this.setEnhancementModifier(1);
	}
}
