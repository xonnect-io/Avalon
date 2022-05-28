package com.ruse.world.content;

import com.ruse.util.Misc;

public class NephilimSpawnSystem {

	public static final int totalCount = 250;
	public static int sacrificedCount = 0;

	public static int getLeft() {
		return totalCount - sacrificedCount;
		}
	public static String getNephilimTokensLeft() {
		return Misc.insertCommasToNumber(String.valueOf(totalCount - sacrificedCount));
	}

}
