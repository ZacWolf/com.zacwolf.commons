/* com.zacwolf.commons.utils.UTF8Encoding.java
 *
 * Utility class for converting/standardizing around UTF-8 encoding
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

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @author Zac Morris
 * @version 2.0
 * @since Java1.8
 */
public class UTF8_Encoding{

	public	static	final	String	UTF8	=	"UTF-8";

	/**
	 * Private constructor to prevent this otherwise static class from being instantiated.
	 **/
	private UTF8_Encoding(){
		super();
	}

	/**
	 * Decodes the passed UTF-8 String using an algorithm that's compatible with
	 * JavaScript's <code>decodeURIComponent</code> function. Returns
	 * <code>null</code> if the String is <code>null</code>.
	 *
	 * @param s The UTF-8 encoded String to be decoded
	 * @return the decoded String
	 */
	public static String decodeURIComponent(final String s)  {
		if (s == null) {
			return null;
		}
		try {
			return	URLDecoder.decode(s, "UTF-8");
		} catch (final UnsupportedEncodingException e){// This exception should never occur.
			return e.getMessage();
		}
	}

	/**
	 * Encodes the passed String as UTF-8 using an algorithm that's compatible
	 * with JavaScript's <code>encodeURIComponent</code> function. Returns
	 * <code>null</code> if the String is <code>null</code>.
	 *
	 * @param s The String to be encoded
	 * @return the encoded String
	 */
	public static String encodeURIComponent(final String s){
		if (s == null) {
			return null;
		}
		try {
			return	URLEncoder	.encode(s, "UTF-8")
								.replaceAll("\\+", "%20")
								.replaceAll("\\%21", "!")
								.replaceAll("\\%27", "'")
								.replaceAll("\\%28", "(")
								.replaceAll("\\%29", ")")
								.replaceAll("\\%7E", "~");
		} catch (final UnsupportedEncodingException e){// This exception should never occur.
			return e.getMessage();
		}
	}
}
