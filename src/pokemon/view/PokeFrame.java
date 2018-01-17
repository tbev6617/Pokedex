package pokemon.view;

import javax.swing.JFrame;

import pokemon.controller.PokeController;

public class PokeFrame extends JFrame
{

	private PokeController appController;
	private PokePanel appPanel;
	
	public PokeFrame(PokeController appController)
	{
		super();
		this.appController = appController;
		appPanel = new PokePanel(appController);
		setupFrame();
	}
	private void setupFrame()
	{
		this.setContentPane(appPanel);
		this.setTitle("Pokedex Project");
		this.setSize(1000, 600);
		this.setResizable(true);
		this.setVisible(true);
	}
}

