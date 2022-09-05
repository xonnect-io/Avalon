package com.ruse.world.content.seasonpass;

import com.ruse.model.Item;
import com.ruse.world.World;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class PassRewards {
	/**
	 *  change this every month
	 */
	public static Calendar seasonEnd = new GregorianCalendar(World.getCalendar().getInstance().get(Calendar.YEAR), Calendar.OCTOBER, 30, 23, 30);
	public static Calendar seasonStart = new GregorianCalendar(World.getCalendar().getInstance().get(Calendar.YEAR), Calendar.SEPTEMBER, 4, 0, 30);

	public static final String INFO_FILE_PATH = "./data/saves/seasonpass/info.txt";
	public static final String REWARDS_FILE_PATH = "./data/saves/seasonpass/goldRewards.txt";
	public static final String DEFAULT_REWARDS_FILE_PATH = "./data/saves/seasonpass/silverRewards.txt";
	public static Item[] defaultRewards;
	public static Item[] memberRewards;
	public static int SEASON;
	public static int SEASONEND;
	public static long howlongyoumustbeloggedintoget1xp = 60*60_000;
	public static String theEndDate() {
		Calendar start = Calendar.getInstance();
		Calendar end = seasonEnd;
		Date startDate = start.getTime();
		Date endDate = end.getTime();
		long startTime = startDate.getTime();
		long endTime = endDate.getTime();
		long diffTime = endTime - startTime;
		long diffDays = diffTime / (1000 * 60 * 60 * 24);
		DateFormat dateFormat = DateFormat.getDateInstance();
		return dateFormat.format(endDate);
	}

	public static long differenceindays() {
		Calendar start = Calendar.getInstance();
		Calendar end = seasonEnd;
		Date startDate = start.getTime();
		Date endDate = end.getTime();
		long startTime = startDate.getTime();
		long endTime = endDate.getTime();
		long diffTime = endTime - startTime;
		long diffDays = diffTime / (1000 * 60 * 60 * 24);
		DateFormat dateFormat = DateFormat.getDateInstance();
		return diffDays;
	}
	public static boolean didSeasonEnd() {
		Calendar calendar = World.getCalendar().getInstance();

		return calendar.after(seasonEnd);
	}

	public static void init() {
		loadInformation();
		loadDefaultRewards();
		loadMemberRewards();
	}
	public static boolean isSeasonInProgress() {
		Calendar calendar = World.getCalendar().getInstance();

		return calendar.after(seasonStart)  && calendar.before(seasonEnd);
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
		defaultRewards = new Item[50];
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

				defaultRewards[index] = new Item(Integer.parseInt(code[0]), Integer.parseInt(code[1]));
				index++;
			}
			r.close();
		} catch (IOException e) {
			System.err.println("Did not load '"+DEFAULT_REWARDS_FILE_PATH+"'");
		}
	}

	public static void loadMemberRewards() {
		memberRewards = new Item[50];
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

				memberRewards[index] = new Item(Integer.parseInt(code[0]), Integer.parseInt(code[1]));
				index++;
			}
			r.close();
		} catch (IOException e) {
			System.err.println("Did not load '"+ REWARDS_FILE_PATH +"'.");
		}
	}

}
