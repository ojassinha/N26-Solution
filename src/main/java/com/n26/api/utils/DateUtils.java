package com.n26.api.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateUtils {

	public static Date getCurrentUTCTime() {
		DateFormat formatNew = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date utcDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
		String localUTCTimeStr = dateFormat.format(utcDate);

		try {
			utcDate = formatNew.parse(localUTCTimeStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return utcDate;
	}

	public static Date epocUtctoDate(long epocTime) {
		
		Date date = new Date(epocTime);
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

		format.setTimeZone(TimeZone.getTimeZone("UTC"));
		String utcFormattedDateStr = format.format(date);

		Date utcFormattedDate = null;
		DateFormat formatNew = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

		try {
			utcFormattedDate = formatNew.parse(utcFormattedDateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return utcFormattedDate;
	}

	public static boolean dateIsOlderThanSixtySeconds(long date) {	
		Date dateFromInput = DateUtils.epocUtctoDate(date);
		Date currentDate = DateUtils.getCurrentUTCTime();

		if ((currentDate.getTime() - dateFromInput.getTime()) / 1000 > 60) {
			return true;
		}
		return false;
	}
}
