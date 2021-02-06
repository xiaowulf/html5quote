package com.venus.finance.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	public static long getLongDate(Calendar cal) {
		if (cal == null) {
			cal = Calendar.getInstance();
		}
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		String tempMonth = "";
		if (month < 10) {
			tempMonth = "0" + month;
		} else {
			tempMonth = new Integer(month).toString();
		}
		int day = cal.get(Calendar.DAY_OF_MONTH);
		String tempDay = "";
		if (day < 10) {
			tempDay = "0" + day;
		} else {
			tempDay = new Integer(day).toString();
		}
		String tempDate = new Integer(year).toString() + tempMonth + tempDay;
		return Long.parseLong(tempDate);
	}

	public static long getYearMonth(Calendar cal) {
		if (cal == null) {
			cal = Calendar.getInstance();
		}
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		String tempMonth = "";
		if (month < 10) {
			tempMonth = "0" + month;
		} else {
			tempMonth = new Integer(month).toString();
		}

		String tempDate = new Integer(year).toString() + tempMonth;
		return Long.parseLong(tempDate);
	}

	public static long getLongTime(Calendar cal) {
		if (cal == null) {
			cal = Calendar.getInstance();
		}
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		String tempHour = "";
		if (hour < 10) {
			tempHour = "0" + hour;
		} else {
			tempHour = new Integer(hour).toString();
		}
		String tempMinute = "";
		if (minute < 10) {
			tempMinute = "0" + minute;
		} else {
			tempMinute = new Integer(minute).toString();
		}
		String tempSecond = "";
		if (second < 10) {
			tempSecond = "0" + second;
		} else {
			tempSecond = new Integer(second).toString();
		}
		String tempTime = new Integer(tempHour).toString() + tempMinute + tempSecond;
		return Long.parseLong(tempTime);
	}

	public static String getStringDate(Calendar cal) {
		if (cal == null) {
			cal = Calendar.getInstance();
		}
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		String tempMonth = "";
		if (month < 10) {
			tempMonth = "0" + month;
		} else {
			tempMonth = new Integer(month).toString();
		}
		int day = cal.get(Calendar.DAY_OF_MONTH);
		String tempDay = "";
		if (day < 10) {
			tempDay = "0" + day;
		} else {
			tempDay = new Integer(day).toString();
		}
		String tempDate = new Integer(year).toString() + tempMonth + tempDay;
		return tempDate;
	}

	public static String getStringTime(Calendar cal) {
		if (cal == null) {
			cal = Calendar.getInstance();
		}
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		String tempHour = "";
		if (hour < 10) {
			tempHour = "0" + hour;
		} else {
			tempHour = new Integer(hour).toString();
		}
		String tempMinute = "";
		if (minute < 10) {
			tempMinute = "0" + minute;
		} else {
			tempMinute = new Integer(minute).toString();
		}
		String tempSecond = "";
		if (second < 10) {
			tempSecond = "0" + second;
		} else {
			tempSecond = new Integer(second).toString();
		}
		String tempTime = new Integer(tempHour).toString() + tempMinute + tempSecond;
		return tempTime;
	}

	public static long getLongDate4Date(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		String tempMonth = "";
		if (month < 10) {
			tempMonth = "0" + month;
		} else {
			tempMonth = new Integer(month).toString();
		}
		int day = cal.get(Calendar.DAY_OF_MONTH);
		String tempDay = "";
		if (day < 10) {
			tempDay = "0" + day;
		} else {
			tempDay = new Integer(day).toString();
		}
		String tempDate = new Integer(year).toString() + tempMonth + tempDay;
		return Long.parseLong(tempDate);
	}

	public static long getLongDate(String cal) {
		String[] tempArray = cal.split("-");
		String tempDate = tempArray[0] + tempArray[1] + tempArray[2];
		return Long.parseLong(tempDate);
	}

	public static Date getLongDate2Date(Long date) {
		String tmpStr = date.toString();
		if (tmpStr.length() < 8 || tmpStr.length() > 8) {
			return Calendar.getInstance().getTime();
		}
		String year = tmpStr.substring(0, 4);
		String month = tmpStr.substring(4, 6);
		String day = tmpStr.substring(6, tmpStr.length());
		String tempDate = year + "-" + month + "-" + day;
		Date rDate = parseDate(tempDate, "yyyy-MM-dd");
		return rDate;
	}

	public static boolean validDate(String cal) {
		if (cal.indexOf("-") < 0) {
			return false;
		} else {
			String[] tempArray = cal.split("-");
			if (tempArray == null || tempArray.length < 3) {
				return false;
			} else {
				String tempDate = tempArray[0] + tempArray[1] + tempArray[2];
				if (tempArray[0] == null || tempArray[1] == null || tempArray[2] == null) {
					return false;
				} else {
					if (tempArray[0].length() != 4 || Long.parseLong(tempArray[1]) > 12
							|| Long.parseLong(tempArray[1]) < 0 || Long.parseLong(tempArray[2]) > 31
							|| Long.parseLong(tempArray[2]) < 0) {
						return false;
					} else {
						return true;
					}
				}

			}

		}

	}

	public static String formatDate(Date date, String pattern) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		return simpleDateFormat.format(date);
	}

	public static Date parseDate(String date, String pattern) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		try {
			return simpleDateFormat.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return Calendar.getInstance().getTime();
	}

	public static void main(String[] args) {
		// System.out.println(getLongDate2Str(20150608L));
	}
}
