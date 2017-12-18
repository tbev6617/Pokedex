package pokemon.model.monsters;

import pokemon.model.types.*;

public class Pikachu extends Pokemon implements ElectricType
{
	public Pikachu(int number)
	{
		super(number, "Pikachu");
	}
	public Pikachu(int number, String name)
	{
		super(number, name);
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
}
