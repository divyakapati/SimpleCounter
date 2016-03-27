package com.example.counter.util;

import java.math.BigDecimal;

public enum Utilities {

	INSTANCE;

	public float round(float value, int decimals) {
		BigDecimal bigDecimal = new BigDecimal(Float.toString(value));
		bigDecimal = bigDecimal.setScale(decimals, BigDecimal.ROUND_HALF_UP);
		return bigDecimal.floatValue();
	}
}
