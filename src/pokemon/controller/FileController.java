package pokemon.controller;

import java.io.*;
import pokemon.model.monsters.Pokemon;
import java.util.ArrayList;
import java.util.Scanner;


public class FileController 
{
	public static void savePokemonToFile(ArrayList<Pokemon> pokedex)
	{
		File saveFile = new File("Saved pkemon.txt");
		try
		{
			PrintWriter writeToDisk = new PrintWriter(saveFile);
			
			for (int i = 0; i < pokedex.size(); i++)
			{
				String name = pokedex.get(i).getName();
				int number = pokedex.get(i).getNumber();
				int attack = pokedex.get(i).getAtk();
				int health = pokedex.get(i).getHp();
				boolean evolve = pokedex.get(i).isEvolvable();
				double modify = pokedex.get(i).getEnhancementModifier();
				
				String row = name + "," + number + "," + health + "," + attack + "," + modify + "," + evolve;
				
				writeToDisk.println(row);
			}
			writeToDisk.close();
		}
		catch (FileNotFoundException error)
		{
			System.out.println("THERE WAS AN ERROR: " + error.getMessage());
		}
	}
	
	public static String readPokemonFromFile()
	{
		String contents = "";
		String path = "Saved Podex.txt";
		try
		{
			Scanner fileScanner = new Scanner(new File(path));
			while (fileScanner.hasNextLine())
			{
				String row = fileScanner.nextLine();
				contents += row + "\n";
			}
			fileScanner.close();
		}
		catch (FileNotFoundException error)
		{
			System.out.println("THERE WAS AN ERROR: " + error.getMessage());
		}
		
		return contents;
	}
}
