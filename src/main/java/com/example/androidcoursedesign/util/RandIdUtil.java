package com.example.androidcoursedesign.util;

import java.util.UUID;

public class RandIdUtil {

	public static String rangId() {
		Long id=(long)Math.abs(UUID.randomUUID().toString().replace("-", "").substring(0,10).hashCode());
		return id.toString();
	}

	public static String rangOrderId() {
		return UUID.randomUUID().toString().replace("-", "").toString();
	}
}
