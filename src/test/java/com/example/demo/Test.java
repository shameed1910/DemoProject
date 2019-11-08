package com.example.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat dateformat3 = new SimpleDateFormat("yyyy-MM-dd");
		Date date = dateformat3.parse("2018-09-09");

		 System.out.println(date);
	}
}
