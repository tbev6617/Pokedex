package pokemon.model.monsters;

import pokemon.model.types.*;

public class Gyarados extends Magikarp implements PunType
{
	public Gyarados()
	{
		super(-130, "GaryDos");
	}
	public Gyarados(String name)
	{
		super(-130, name);
	}
	public Gyarados(int number, String name)
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
	@Override
	protected void setup()
	{
		super.setup();
		this.setAtk(200);
	}
}
