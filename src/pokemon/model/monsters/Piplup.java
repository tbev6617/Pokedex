package pokemon.model.monsters;

import pokemon.model.types.*;

public class Piplup extends Pokemon implements WaterType
{
	public Piplup()
	{
		super(393, "Piplup");
		setup();
	}
	public Piplup(String name)
	{
		super(393, name);
		setup();
	}
	public Piplup(int number, String name)
	{
		super(number, name);
		setup();
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
	protected void setup()
	{
		this.setAtk(100);
		this.setHp(1000);
		this.setCanEvolve(true);
		this.setEnhancementModifier(1);
	}
}
