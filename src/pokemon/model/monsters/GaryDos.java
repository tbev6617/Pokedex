package pokemon.model.monsters;

import pokemon.model.types.*;

public class GaryDos extends Magikarp implements PunType
{
	public GaryDos(int number)
	{
		super(number, "GaryDos");
	}
	public GaryDos(int number, String name)
	{
		super(number, name);
	}
	public void makeAPun()
	{
		System.out.println(getName() + " makes a pun. \"Whale, Whale, Whale. What do we have here\"");
	}
	public void wave()
	{
		System.out.println("You done been hit by a wave");
	}
}
