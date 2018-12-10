/** fun_endless@163.com  2018年11月26日 */
package org.aimbin.commons.javas;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**Tools for date.
 * @author aimbin
 * @verison 1.0.0 2018年11月26日
 */
public class TimeUtils {
	/** yyyy-MM-dd HH:mm:ss SSS */
	private static final DateFormat _full = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
	private static final String _TightPattern = "yyyyMMddHHmmssSSS";
	/** yyyyMMddHHmmssSSS */
	private static final DateFormat _fullTight = new SimpleDateFormat(_TightPattern);
	
	/**To yyyy-MM-dd HH:mm:ss SSS. */
	public static String toStrFull(Date date) {
		return _full.format(date);
	}
	
	/**To yyyyMMddHHmmssSSS. */
	public static String toStrFullTight(Date date) {
		return _fullTight.format(date);
	}
	
	/**To date for yyyy-MM-dd HH:mm:ss SSS. */
	public static Date toDateAsFull(String full) {
		try {
			return _full.parse(full);
		} catch (ParseException e) {
			throw new IllegalArgumentException(e);
		}
	}
	
	/**To date for yyyyMMddHHmmssSSS. */
	public static Date toDateFullTight(String fullTight) {
		try {
			return _fullTight.parse(fullTight);
		} catch (ParseException e) {
			throw new IllegalArgumentException(e);
		}
	}
	
	/** Eliminate the tail value of last digits as format of yyyyMMddHHmmssSSS. */
	public static Date eliminateTail(Date date, int tailLength) {
		if(tailLength > _TightPattern.length()) {
			throw new IllegalArgumentException("tailLength must less than lenth of yyyyMMddHHmmssSSS");
		}
		String full = toStrFullTight(date);
		full = full.substring(0, _TightPattern.length() - tailLength) + StrUtils.repeat("0", tailLength);
		return toDateFullTight(full);
	}
}
