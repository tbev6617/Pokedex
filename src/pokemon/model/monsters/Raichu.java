package pokemon.model.monsters;

import pokemon.model.types.*;

public class Raichu extends Pikachu implements PunType
{
	public Raichu()
	{
		super(26, "Raichu");
	}
	public Raichu(String name)
	{
		super(26, name);
	}
	public Raichu(int number, String name)
	{
		super(number, name);
	}
	public void makeAPun()
	{
		System.out.println(getName() + " makes a pun. \"I'm ec-static\"");
	}
	@Override
	protected void setup()
	{
		super.setup();
		this.setAtk(200);
	}
}
