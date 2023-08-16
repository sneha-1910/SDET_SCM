package com.crm.GenericUtility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtility {

	public int getRandomNo()
	{
		Random ran=new Random();
		int random=ran.nextInt(500);
		return random;
	}
	public String getSystemDate()
	{
		Date d=new Date();
		String date = d.toString();
		return date;
		
	}
	public String getSystemDateFormat()
	{
		SimpleDateFormat dateformat = new SimpleDateFormat("dd/mm/yyyy hh-MM-ss");
		Date date=new Date();
		String systemDateFormat = dateformat.format(date);
		return systemDateFormat;
	}
	
}
