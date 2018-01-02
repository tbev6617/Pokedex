package pokemon.model.monsters;

import pokemon.model.types.*;

public class Pikachu extends Pokemon implements ElectricType
{
	public Pikachu()
	{
		super(25, "Pikachu");
		setup();
	}
	public Pikachu(String name)
	{
		super(25, name);
		setup();
	}
	public Pikachu(int number, String name) 
	{
		super(number, name);
		setup();
	}
	public void zap()
	{
		System.out.println("You done been zapped");
	}
	public void thunderBolt()
	{
		System.out.println("You were hit by a flipping bolt of lightning. Realistically you are dead");
	}
	public void thunderWave()
	{
		System.out.println("You done been hit by a thunder wave");
	}
	protected void setup()
	{
		this.setAtk(100);
		this.setHp(1000);
		this.setCanEvolve(true);
		this.setEnhancementModifier(1);
	}
}
