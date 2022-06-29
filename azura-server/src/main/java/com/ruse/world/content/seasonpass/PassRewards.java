package com.ruse.world.content.seasonpass;

import com.ruse.model.Item;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PassRewards {

	public static final String INFO_FILE_PATH = "./data/saves/seasonpass/info.txt";
	public static final String REWARDS_FILE_PATH = "./data/saves/seasonpass/goldRewards.txt";
	public static final String DEFAULT_REWARDS_FILE_PATH = "./data/saves/seasonpass/silverRewards.txt";
	public static Item[] silverRewards;
	public static Item[] goldRewards;
	public static int SEASON;
	public static int SEASONEND;

	public static void init() {
		loadInformation();
		loadDefaultRewards();
		loadMemberRewards();
	}

	public static void loadInformation() {
		try {
			BufferedReader r = new BufferedReader(new FileReader(INFO_FILE_PATH));

			SEASON = Integer.parseInt(r.readLine());
			SEASONEND = Integer.parseInt(r.readLine());

			r.close();
		} catch (IOException e) {
			System.err.println("Did not load '"+ INFO_FILE_PATH +"'");
		}
	}

	public static void loadDefaultRewards() {
		silverRewards = new Item[50];
		try {
			BufferedReader r = new BufferedReader(new FileReader(DEFAULT_REWARDS_FILE_PATH));
			int index = 0;
			while (true) {
				String line = r.readLine();
				if (line == null) {
					break;
				} else {
					line = line.trim();
				}
				String[] code = line.split(" : ");

				silverRewards[index] = new Item(Integer.parseInt(code[0]), Integer.parseInt(code[1]));
				index++;
			}
			r.close();
		} catch (IOException e) {
			System.err.println("Did not load '"+DEFAULT_REWARDS_FILE_PATH+"'");
		}
	}

	public static void loadMemberRewards() {
		goldRewards = new Item[50];
		try {
			BufferedReader r = new BufferedReader(new FileReader(REWARDS_FILE_PATH));
			int index = 0;
			while (true) {
				String line = r.readLine();
				if (line == null) {
					break;
				} else {
					line = line.trim();
				}
				String[] code = line.split(" : ");

				goldRewards[index] = new Item(Integer.parseInt(code[0]), Integer.parseInt(code[1]));
				index++;
			}
			r.close();
		} catch (IOException e) {
			System.err.println("Did not load '"+ REWARDS_FILE_PATH +"'.");
		}
	}

}
