/* com.zacwolf.commons.utils.TimeUtils.java
 *
 * Utility for formatting date/time into various formats
 *
 * Copyright (C) 2021 Zac Morris <a href="mailto:zac@zacwolf.com">zac@zacwolf.com</a>

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.zacwolf.commons.utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Hours;
import org.joda.time.Minutes;
import org.joda.time.Seconds;

/**
 * @author Zac Morris
 * @version 2.0
 * @since Java1.8
 */
public class TimeUtils {

	/**
	 * Private constructor to prevent this otherwise static class from being instantiated.
	 **/
	private TimeUtils(){
		super();
	}


	public static final long getGMTtime(){
		return new Now().getTimeInMillis();
	}

	public static final long getTime(final TimeZone tz){
		return new Now(tz).getTimeInMillis();
	}

	public static final Timestamp getGMTTimestamp(){
		return new Timestamp(getGMTtime());
	}

	public static final Timestamp getTimestamp(final TimeZone tz){
		return new Timestamp(getTime(tz));
	}

	public static final String getTimestampString(){
		return getTimestampString(getGMTtime());
	}

	public static final String getTimestampString(final long time){
		return getTimeString(time, "yyyyMMddHHmmss");
	}

	public static final String getTimeString(){
		return getTimeString(getGMTtime());
	}

	public static final String getTimeString(final String format){
		return getTimeString(new SimpleDateFormat(format));
	}

	public static final String getTimeString(final DateFormat format){
		return format.format(new Date(getGMTtime()));
	}

	public static final String getTimeString(final long time){
		return getTimeString(time, "yyyy-MMM-dd HH:mm:ss 'GMT'");
	}

	public static final String getTimeString(final long time, final String format){
		return getTimeString(time,new SimpleDateFormat(format));
	}

	public static final String getTimeString(final long time, final DateFormat format){
		return format.format(new Date(time));
	}

	public static final String getToTimestampString(){
		return getToTimestampString(getGMTtime());
	}
	public static final String getToTimestampString(final long time){
final	DateFormat	df		=	new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSSSS");
		return "to_timestamp('"+df.format(new Timestamp(time))+"', 'YYYY-MM-DD HH24:MI:SS:FF')";
	}

	public static class Now{

		private 	DateTime	time;

		public Now(){
			this(null);
		}

		public Now(final TimeZone tz){
final	Calendar	rightNow	= Calendar.getInstance();
			if (tz!=null) {
				rightNow.setTimeZone(tz);
			}
final	int			offset		=	rightNow.get(Calendar.ZONE_OFFSET)*-1;
final	int			dst			=	rightNow.get(Calendar.DST_OFFSET);
					time	=	new DateTime(rightNow.getTimeInMillis()+offset-dst);
		}

		public long getTimeInMillis(){
			return time.getMillis();
		}

		public final Timestamp getTimestamp(){
			return new Timestamp(time.getMillis());
		}

		public final long minusDays(final int days){
			time	=	time.minusDays(days);
			return time.getMillis();
		}

		public final long minusHours(final int hours){
			time	=	time.minusHours(hours);
			return time.getMillis();
		}

		public final long minusMinutes(final int minutes){
			time	=	time.minusMinutes(minutes);
			return time.getMillis();
		}

		public final long minusSeconds(final int seconds){
			time	=	time.minusSeconds(seconds);
			return time.getMillis();
		}

		public final long minus(final long millis){
			time	=	time.minus(millis);
			return time.getMillis();
		}
	}

	public static class Timer{

		DateTime	start;

		public Timer(){
			start	=	new DateTime();
		}

		public String getDurationString(){
final		DateTime	end		=	new DateTime();
			return getDurationString(end);
		}

		public String getDurationString(final DateTime end){
final		int		days	=	Days.daysBetween(start, end).getDays();
final		int		hours	=	Hours.hoursBetween(start.plusDays(days), end).getHours();
final		int		min		=	Minutes.minutesBetween(start.plusDays(days).plusHours(hours), end).getMinutes();
final		int		sec		=	Seconds.secondsBetween(start.plusDays(days).plusHours(hours).plusMinutes(min), end).getSeconds();
			return	(days>0?days+" days ":"")+
					(hours>0?hours+" hours ":"")+
					(min>0?min+" minutes ":"")+
					(sec>0?sec+" seconds":"<1sec");
		}
	}
}
