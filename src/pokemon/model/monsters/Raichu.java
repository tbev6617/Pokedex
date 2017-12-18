package pokemon.model.monsters;

import pokemon.model.types.*;

public class Raichu extends Pikachu implements PunType
{
	public Raichu(int number)
	{
		super(number, "Raichu");
	}
	public Raichu(int number, String name)
	{
		super(number, name);
	}
	public void makeAPun()
	{
		System.out.println(getName() + " makes a pun. \"I hope this hertz\"");
	}
}
