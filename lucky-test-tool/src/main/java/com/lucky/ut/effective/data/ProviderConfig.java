package com.lucky.ut.effective.data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhourj
 * @date 2020/9/18 10:54
 * 数据供给器的配置
 */
public class ProviderConfig {
	private byte[] byteRange = {0, 127};
	private boolean[] booleanSeed = {true, false};
	private short[] shortRange = {0, 1000};
	private int[] intRange = {0, 10000};
	private Integer stringSize =32;
	private float[] floatRange = {0.0f, 10000.00f};
	private double[] doubleRange = {0.0, 10000.00};
	private int decimalScale = 2;
	private long[] longRange = {0L, 10000L};
	private String[] dateRange = {"1970-01-01", "2100-12-31"};
	private int[] timeRange = {0,24,0,60,0,60};
	private int[] sizeRange = {1, 10};

	/**
	 * enum缓存
	 */
	private Map<String, Enum[]> enumCache = new HashMap<>();

	private char[] charSeed =
			{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
					'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F',
					'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
	private String[] stringSeed =
			{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k",
					"l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F",
					"G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};


	public int[] intRange() {
		return this.intRange;
	}

	public Integer stringSize(){
		return this.stringSize;
	}

	public String[] stringSeed() {
		return this.stringSeed;
	}
	public int[] sizeRange() {
		return this.sizeRange;
	}

	public void cacheEnum(String name, Enum[] enums) {
		enumCache.put(name, enums);
	}

	public Enum[] getcacheEnum(String enumClassName) {
		return enumCache.get(enumClassName);
	}
}
