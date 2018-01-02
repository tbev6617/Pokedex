package pokemon.model.monsters;

import pokemon.model.types.*;

public class CatJamal extends Pokemon implements PunType
{
	public CatJamal()
	{
		super(0, "Cat Jamal");
		setup();
	}
	public CatJamal(String name)
	{
		super(0, name);
		setup();
	}
	public CatJamal(int number, String name)
	{
		super(number, name);
		setup();
	}
	public void makeAPun()
	{
		System.out.println("The writer of the Pokemon theme song got this pokemon (Think about it)");
	}
	protected void setup()
	{
		this.setAtk(200);
		this.setHp(1000);
		this.setCanEvolve(true);
		this.setEnhancementModifier(1);
	}
}
