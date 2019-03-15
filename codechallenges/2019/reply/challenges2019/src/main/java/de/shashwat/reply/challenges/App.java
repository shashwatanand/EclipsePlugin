package de.shashwat.reply.challenges;

import de.shashwat.reply.challenges.utils.DataReader;

public class App {
	public static void main(String[] args) {
		DataReader reader = new DataReader();
		reader.readFromFile("1_victoria_lake.txt");
	}
}
