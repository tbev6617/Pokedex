package pokemon.model.monsters;

import pokemon.model.types.*;

public class CatJamal extends Pokemon implements PunType
{
	public CatJamal(int number)
	{
		super(number, "Cat Jamal");
	}
	public CatJamal(int number, String name)
	{
		super(number, name);
	}
	public void makeAPun()
	{
		System.out.println("The writer of the Pokemon theme song got this pokemon (Think about it)");
	}
}
