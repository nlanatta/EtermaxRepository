package com.etermax.rpg.utils;

import java.util.List;

public class Utils {

	public static boolean containSomeElement(List<String> a, List<String> b) {
		for (String value1 : a) {
			for (String value2 : b) {
				if (value1.equals(value2)) {
					return true;
				}
			}
		}

		return false;
	}
}
