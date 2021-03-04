package com.mahx;

import java.util.HashMap;

public class MaxHuiwenStr5 {

	public static void main(String[] args) {
		MaxHuiwenStr5 hw = new MaxHuiwenStr5();
		String input = "aabacdefga";
		System.out.println(hw.getMaxStr(input));
	}

	public String getMaxStr(String input) {
		if (input == null || input.length() == 0) {
			return "";
		}
		HashMap<String, Integer> tmpMap = new HashMap<String, Integer>();
		int length = input.length();
		int maxLenth = -1;
		int maxLenghtStart = -1;
		int maxLenghtEnd = -1;
		for (int i = 0; i < length; i++) {
			String k = input.substring(i, i + 1);
			Integer v = tmpMap.get(k);
			if (v != null && (i - v.intValue()) > maxLenth) {
				maxLenth = i - v.intValue();
				maxLenghtStart = v.intValue();
				maxLenghtEnd = i;
			}
			tmpMap.put(k, i);
		}
		return maxLenth > 0 ? input.substring(maxLenghtStart, maxLenghtEnd + 1) : "";
	}
}
