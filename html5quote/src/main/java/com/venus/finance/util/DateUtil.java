package com.venus.finance.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	public static String getDateFormat(String patten)
	{
		Date date = Calendar.getInstance().getTime();
		SimpleDateFormat format0 = new SimpleDateFormat(patten);
        String dateStr = format0.format(date);
        return dateStr;
	}
}
