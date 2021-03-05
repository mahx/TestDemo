package com.mahx;

public class MaxSamePreString14 {

	public static void main(String[] args) {
		String[] input = { "abcd111", "a", "abcd333", "abcd222" };
		MaxSamePreString14 m = new MaxSamePreString14();
		System.out.println(m.getMaxSameStr(input));
	}

	public String getMaxSameStr(String[] input) {
		if (input == null) {
			return "";
		}
		int minLen = Integer.MAX_VALUE;
		for (int i = 0; i < input.length; i++) {
			if (input[i] == null || input[i].length() == 0) {
				return "";
			}
			if (input[i].length() < minLen) {
				minLen = input[i].length();
			}
		}
		for (int i = 1; i < minLen; i++) {
			char c = input[0].charAt(i);
			for (int j = 0; j < input.length; j++) {
				if (input[j].charAt(i) != c) {
					return input[0].substring(0, i);
				}
			}
		}
		return input[0].substring(0, minLen);
	}
}
