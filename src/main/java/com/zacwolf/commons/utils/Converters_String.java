/* com.zacwolf.commons.utils.Converters_String.java
 *
 * Utility class for converting between Strings and List/Set/Array objects
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 * This is a Utility class which contains methods for converting
 * string objects
 *
 * @author Zac Morris
 * @version 2.0
 * @since Java1.8
 */
public class Converters_String {

	public final	static 	SORT	SORT_NONE	=	new SORT(0);
	public final	static	SORT	SORT_ASC	=	new SORT(1);
	public final	static	SORT	SORT_DESC	=	new SORT(-1);

	/**
     * The value of this constant is {@value}.
     */
	public final	static	String	DELIMITERS	=	"[-\\t,;.?!:@\\[\\](){}_*/]";


	/**
	 * Private constructor to prevent this otherwise static class from being instantiated.
	 **/
	private Converters_String(){
		super();
	}


	public final static class SORT{
		int	val;
		SORT(final int val){
			this.val	=	val;
		}
	}

	/**
	  * Converts a delimited string into an array of strings.
	  *
	  * @param	str	The delimited string to convert
	  * @return	String array
	  *
	  * @see	String
	  * @see	StringTokenizer
	  * @see	#DELIMITERS
	  */
	public final static String[] stringToArray(final String str) throws NullPointerException {
		return stringToArray(str, DELIMITERS, -1, SORT_NONE);
	}

	/**
	  * Converts a delimited string into an array of strings.
	  *
	  * @param	str	The delimited string to convert
	  * @param	sort	The SORT enum value representing whether to sort the array values, and if so, which direction.
	  * 				After the creation of the array, sort order is not automagically maintained.
	  *
	  * @return	String array
	  *
	  * @see	String
	  * @see	StringTokenizer
	  * @see	#DELIMITERS
	  */
	public final static String[] StringToArray(final String str, final SORT sort) throws NullPointerException{
		return stringToArray(str, DELIMITERS, -1, sort);
	}

	/**
	  * Converts a delimited string into an array of strings with size specified by the setsize param.
	  *
	  * @param	str		The delimited string to convert
	  * @param	setsize	Sets a specific size for the array to be returned.
	  *					If str is tokenized greater than setsize only sizesize elements will be returned.
	  *					If str is tokenized less then setsize remaining values will be populated with "" string.
	  *					Any size less than 1 will set the size based on the number of delimiters
	  *
	  * @return	String array
	  *
	  * @see	String
	  * @see	StringTokenizer
	  * @see	#DELIMITERS
	  * @see	Arrays#sort
	  */
	public final static String[] stringToArray(final String str,final int setsize) throws NullPointerException {
		return stringToArray(str, DELIMITERS, setsize, SORT_NONE);
	}

	/**
	  * Converts a delimited string into a sorted array of int with size specified by the setsize param.
	  *
	  * @param	str		The delimited string to convert
	  * @param	setsize	Sets a specific size for the array to be returned.
	  * 				If str is tokenized greater than setsize only sizesize elements will be returned.
	  * 				If str is tokenized less then setsize remaining values will be populated with "" string.
	  *					Any size less than 1 will set the size based on the number of delimiters
	  * @param	sort	The SORT enum value representing whether to sort the array values, and if so, which direction.
	  * 				After the creation of the array, sort order is not automagically maintained.
	  *
	  * @return			String array
	  *
	  * @see	String
	  * @see	StringTokenizer
	  * @see	#DELIMITERS
	  * @see	Arrays#sort
	  */
	public final static String[] stringToArray(final String str, final int setsize, final SORT sort) throws NullPointerException {
		return stringToArray(str, DELIMITERS, setsize, sort);
	}

	/**
	  * Converts a "token" delimited string into an array of string with size specified by the setsize param.
	  *
	  * @param	str		The "token" delimited string to convert
	  * @param	token	The delimiter to use as the token
	  * @param	setsize	Sets a specific size for the array to be returned.
	  * 				If str is tokenized greater than setsize only sizesize elements will be returned.
	  * 				If str is tokenized less then setsize remaining values will be populated with "" string.
	  *					Any size less than 1 will set the size based on the number of delimiters
	  *
	  * @return	Array of strings
	  *
	  * @see	String
	  * @see	StringTokenizer
	  */
	public final static String[] stringToArray(final String str, final String token, final int setsize) throws NullPointerException {
		return stringToArray(str, token, setsize, SORT_NONE);
	}

	/**
	  * Converts a "token" delimited string into an array of string with size specified by the setsize param.
	  *
	  * @param	str		The delimited string to convert
	  * @param	token	The delimiter value(s) to use as the token
	  * @param	sort	The SORT enum value representing whether to sort the array values, and if so, which direction.
	  * 				After the creation of the array, sort order is not automagically maintained.
	  *
	  * @return	String array
	  *
	  * @see	String
	  * @see	StringTokenizer
	  * @see	Arrays#sort
	  */
	public final static String[] stringToArray(final String str, final String token, final SORT sort) throws NullPointerException{
		return stringToArray(str,token,-1,sort);
	}

	/**
	  * Converts a "token" delimited string into a sorted array of strings with size specified by the setsize param.
	  *
	  * @param	str		The "token" delimited string to convert
	  * @param	token	The delimiter value(s) to use as the token
	  * @param	setsize	Sets a specific size for the array to be returned.
	  * 				If str is tokenized greater than setsize only sizesize elements will be returned.
	  * 				If str is tokenized less then setsize remaining values will be populated with "" string.
	  *					Any size less than 1 will set the size based on the number of delimiters
	  * @param sort		The SORT enum value representing whether to sort the array values, and if so, which direction.
	  * 				After the creation of the array, sort order is not automagically maintained.
	  *
	  * @return String array
	  *
	  * @see	String
	  * @see	StringTokenizer
	  * @see	#DELIMITERS
	  * @see	Arrays#sort
	  */
	public final static String[] stringToArray(final String str, final String token, final int setsize, final SORT sort) throws NullPointerException {
final	StringTokenizer	t			=	new StringTokenizer(str, token);
final	String[]		array		=	setsize<1?new String[t.countTokens()]:new String[setsize];
		if (t.countTokens()>0){
			for(int i=0; t.hasMoreTokens() && i<setsize; ++i) {
final	String			val			=	trim(t.nextToken());
				if (val.length()>0) {
					array[i]	=	val;
				}
			}
		} else {
						array[0]	=	str;
		}
		if (!sort.equals(SORT_NONE)){
			Arrays.sort(array);
			if (sort.equals(SORT_DESC)){
				for(int i=0,j=array.length-1; i < array.length/2; i++, j--) {
					// swap the elements
final	String			temp 		=	array[i];
						array[i] 	=	array[j];
						array[j] 	=	temp;
				}
			}
		}
		return array;
	}






	/**
	  * Converts a delimited string into an array of int values.
	  *
	  * @param	str	The delimited string to convert
	  * @return	Array of int values
	  *
	  * @see	String
	  * @see	StringTokenizer
	  * @see	#DELIMITERS
	  *
	  * @throws NumberFormatException If str contains non-delimiter, non-numeric values
	  */
	public final static int[] stringToIntArray(final String str) throws NumberFormatException {
		return stringToIntArray(str, DELIMITERS, -1, SORT_NONE);
	}

	/**
	  * Converts a delimited string into an array of int values.
	  *
	  * @param	str		The delimited string to convert
	  * @return	Array of int values
	  *
	  * @see	String
	  * @see	StringTokenizer
	  * @see	#DELIMITERS
	  * @see	Arrays#sort
	  *
	  * @throws NumberFormatException If str contains non-delimiter, non-numeric values
	  */
	public final static int[] StringToIntArray(final String str, final SORT sort) throws NumberFormatException{
		return stringToIntArray(str, DELIMITERS, -1, sort);
	}

	/**
	  * Converts a delimited string into an array of int with size specified by the setsize param.
	  *
	  * @param	str		The delimited string to convert
	  * @param	setsize	Sets a specific size for the array to be returned.
	  * 				If str is tokenized greater than setsize only sizesize elements will be returned.
	  * 				If str is tokenized less then setsize remaining values will be populated with 0 value.
	  *					Any size less than 1 will set the size based on the number of delimiters
	  * @return	Array of int values
	  *
	  * @see	String
	  * @see	StringTokenizer
	  * @see	#DELIMITERS
	  *
	  * @throws NumberFormatException If str contains non-delimiter, non-numeric values
	  */
	public final static int[] stringToIntArray(final String str,final int setsize) throws NumberFormatException {
		return stringToIntArray(str, DELIMITERS, setsize, SORT_NONE);
	}

	/**
	  * Converts a delimited string into a sorted array of int with size specified by the setsize param.
	  *
	  * @param	str		The delimited string to convert
	  * @param	setsize	Sets a specific size for the array to be returned.
	  * 				If str is tokenized greater than setsize only sizesize elements will be returned.
	  * 				If str is tokenized less then setsize remaining values will be populated with 0 value.
	  *					Any size less than 1 will set the size based on the number of delimiters
	  * @param	sort	The SORT value representing whether to sort the array values, and if so, in which order.
	  * 				After the creation of the array, sort order is not automagically maintained.
	  * @return	Array of int values
	  *
	  * @see	String
	  * @see	StringTokenizer
	  * @see	#DELIMITERS
	  * @see	Arrays#sort
	  *
	  * @throws NumberFormatException If str contains non-delimiter, non-numeric values
	  */
	public final static int[] stringToIntArray(final String str, final int setsize, final SORT sort) throws NumberFormatException {
		return stringToIntArray(str, DELIMITERS, setsize, sort);
	}

	/**
	  * Converts a "token" delimited string into an array of int with size specified by the setsize param.
	  *
	  * @param	str		The "token" delimited string to convert
	  * @param	token	The delimiter value(s) to use as the token
	  * @param	setsize	Sets a specific size for the array to be returned.
	  * 				If str is tokenized greater than setsize only sizesize elements will be returned.
	  * 				If str is tokenized less then setsize remaining values will be populated with 0 value.
	  *					Any size less than 1 will set the size based on the number of delimiters
	  * @return	Array of int values
	  *
	  * @see	String
	  * @see	StringTokenizer
	  *
	  * @throws NumberFormatException If str contains non-delimiter, non-numeric values
	  */
	public final static int[] stringToIntArray(final String str, final String token, final int setsize) throws NumberFormatException {
		return stringToIntArray(str, token, setsize, SORT_NONE);
	}

	/**
	  * Converts a "token" delimited string into a sorted array of strings with size specified by the setsize param.
	  *
	  * @param	str		The "token" delimited string to convert
	  * @param	token	The delimiter value(s) to use as the token
	  * @param	sort	The SORT value representing whether to sort the array values, and if so, in which order.
	  * 				After the creation of the array, sort order is not automagically maintained.
	  * @return	Array of int values
	  *
	  * @see	String
	  * @see	StringTokenizer
	  *
	  * @throws NumberFormatException If str contains non-delimiter, non-numeric values
	  */
	public final static int[] stringToIntArray(final String str, final String token, final SORT sort) throws NumberFormatException{
		return stringToIntArray(str,token,-1,sort);
	}

	/**
	  * Converts a "token" delimited string into a sorted array of strings with size specified by the setsize param.
	  *
	  * @param	str		The "token" delimited string to convert
	  * @param	token	The delimiter value(s) to use as the token
	  * @param	setsize	Sets a specific size for the array to be returned.
	  * 				If str is tokenized greater than setsize only sizesize elements will be returned.
	  * 				If str is tokenized less then setsize remaining values will be populated with 0 value.
	  *					Any size less than 1 will set the size based on the number of delimiters
	  * @param	sort	The SORT value representing whether to sort the array values, and if so, in which order.
	  * 				After the creation of the array, sort order is not automagically maintained.
	  * @return	Array of int values
	  *
	  * @see	String
	  * @see	StringTokenizer
	  *
	  * @throws NumberFormatException If str contains non-delimiter, non-numeric values
	  */
	public final static int[] stringToIntArray(final String str, final String token, final int setsize, final SORT sort) throws NumberFormatException {
final	StringTokenizer	t		=	new StringTokenizer(str, token);
final	int[]			array	=	setsize<1?new int[t.countTokens()]:new int[setsize];

		if (t.countTokens()>0){
			for(int i=0; t.hasMoreTokens() && i<setsize; ++i) {
final	String			val			= trim(t.nextToken());
				if (val.length()>0) {
					array[i]	= Integer.parseInt(val);
				}
			}
		} else {
					array[0]	= Integer.parseInt(str);
		}
		if (!sort.equals(SORT_NONE)){
			Arrays.sort(array);
			if (sort.equals(SORT_DESC)){
				for(int i=0,j=array.length-1; i < array.length/2; i++, j--) {
						// swap the elements
final	int				temp 		=	array[i];
						array[i] 	=	array[j];
						array[j] 	=	temp;
				}
			}
		}
		return array;
	}





	/**
	  * Converts a delimited string to a List object of String values
	  *
	  * @param	str	The delimited string to convert
	  * @return List object of strings
	  *
	  * @see	String
	  * @see	StringTokenizer
	  * @see	List
	  * @see	#DELIMITERS
	  */
	public final static List<String> stringToList(final String str) {
		return stringToList(str, DELIMITERS);
	}

	/**
	  * Converts a "token" delimited string to a List object of String values
	  *
	  * @param	str		The "token" delimited string to convert
	  * @param	token	The delimiter value(s) to use as the token
	  * @return List object of strings.
	  *
	  * @see	String
	  * @see	StringTokenizer
	  * @see	List
	  * @see	Collections#synchronizedList
	  */
	public final static List<String> stringToList(final String str, final String token) {
final	List<String>		list	=	Collections.synchronizedList(new ArrayList<String>());
		if (str!=null){
final	StringTokenizer		t		=	token==null?new StringTokenizer(str):new StringTokenizer(str, token);
			if (t.countTokens()>0){
				while(t.hasMoreTokens()) {
final	String		val		=	trim(t.nextToken());
					if (val.length()>0) {
						list.add(val);
					}
				}
			} else {
				list.add(trim(str));
			}
		}
		return list;
	}

	/**
	  * Converts a delimited string into a Set object of strings.
	  *
	  * @param	str	The delimited string to convert
	  * @return	Set object of String values
	  *
	  * @see	String
	  * @see	StringTokenizer
	  * @see	Set
	  * @see	Collections#synchronizedSet
	  * @see	#DELIMITERS
	  */
	public final static Set<String> stringToSet(final String str) {
		return stringToSet(str, DELIMITERS);
	}

	/**
	  * Converts a "token" delimited string into a Set object of strings.
	  *
	  * @param	str		The "token" delimited string to convert
	  * @param	token	The delimiter value(s) to use as the token
	  * @return	Set object of String values
	  *
	  * @see	String
	  * @see	StringTokenizer
	  * @see	Set
	  * @see	Collections#synchronizedSet
	  */
	public final static Set<String> stringToSet(final String str, final String token) {
final	Set<String>		set	= Collections.synchronizedSet(new HashSet<String>());
		if (str!=null){
final	StringTokenizer	t	= token==null?new StringTokenizer(str):new StringTokenizer(str, token);
			if (t.countTokens()>0) {
				while(t.hasMoreTokens()) {
final	String		val		=	trim(t.nextToken());
					if (val.length()>0) {
						set.add(val);
					}
				}
			} else {
				set.add(trim(str));
			}
		}
		return set;
	}

	/**
	  * Converts a delimited string into a SortedSet of String values.
	  *
	  * @param	str	The delimited string to convert
	  *
	  * @return	SortedSet of strings values
	  *
	  * @see	String
	  * @see	StringTokenizer
	  * @see	SortedSet
	  * @see	Collections#synchronizedSortedSet
	  */
	public final static SortedSet<String> stringToSortedSet(final String str) {
		return stringToSortedSet(str, DELIMITERS);
	}

	/**
	  * Converts a "token" delimited string into a SortedSet of String values
	  *
	  * @param	str		The "token" delimited string to convert
	  * @param	token	The delimiter value(s) to use as the token
	  *
	  * @return SortedSet of string values
	  *
	  * @see	String
	  * @see	StringTokenizer
	  * @see	SortedSet
	  * @see	Collections#synchronizedSortedSet
	  */
	public final static SortedSet<String> stringToSortedSet(final String str, final String token) {
		return stringToSortedSet(str,token,SORT_ASC);
	}

	/**
	  * Converts a "token" delimited string into a SortedSet of String values
	  *
	  * @param	str		The "token" delimited string to convert
	  * @param	token	The delimiter value(s) to use as the token
	  * @param	sort	The SORT value representing whether to sort the array values, and if so, in which order.
	  * 				After the creation of the array, sort order <b>IS</b> automagically maintained.
	  * @return	SortedSet of Strings
	  *
	  * @see	String
	  * @see	StringTokenizer
	  * @see	SortedSet
	  * @see	Collections#synchronizedSortedSet
	  * @see	Collections#reverseOrder
	  */
	public final static SortedSet<String> stringToSortedSet(final String str, final String token, final SORT sort) {
final	SortedSet<String>	set		=	sort==SORT_DESC
											?Collections.synchronizedSortedSet(new TreeSet<String>(Collections.reverseOrder()))
											:Collections.synchronizedSortedSet(new TreeSet<String>());
		if (str!=null){
final	StringTokenizer		t		=	token==null?new StringTokenizer(str):new StringTokenizer(str, token);
			if (t.countTokens()>0) {
				while(t.hasMoreTokens()) {
final	String				val		=	trim(t.nextToken());
					if (val.length()>0) {
						set.add(val);
					}
				}
			} else {
				set.add(trim(str));
			}
		}
		return set;
	}

	/**
	  * Converts a string value of:<br />
	  * <ol>
	  * 	<li>"false"</li>
	  * 	<li>"no"</li>
	  * 	<li>"n"</li>
	  * 	<li>"closed"</li>
	  * 	<li>"0"</li>
	  * </ol>
	  * to a boolean false<br />
	  * <b>Everything else returns true</b>
	  *
	  * @param	str		String to convert
	  * @return true/false
	  */
	public final static boolean stringToBoolean(final String str) {
		if (	str==null ||
			str.equals("0") ||
			str.equalsIgnoreCase("false") ||
			str.equalsIgnoreCase("no") ||
			str.equalsIgnoreCase("n") ||
			str.equalsIgnoreCase("closed")
		) {
			return false;
		}
		//if it's non false, it's true by definition
		return true;
	}

	/**
	 * Converts a Set object into a comma delimited string.
	 * @param	str		String Array to convert
	 *
	 * @return	Comma delimited String value
	 *
	 * @see	String
	 * @see	Set
	 */
	public final static String setToString(final Set<String> str){
		return setToString(str,",");
	}

	/**
	 * Converts a Set object into a "token" delimited string.
	 * @param	str		String Array to convert
	 * @param	token	The delimiter value to use as the token
	 *
	 * @return	"Token" delimited String value
	 *
	 * @see	String
	 * @see	Set
	 */
	public final static String setToString(final Set<String> str, final String token) {
final	StringBuilder		returnString	=	new StringBuilder();
final	Iterator<String>	values			=	str.iterator();
		while(values.hasNext()){
final	String				value			=	values.next();
			if (value!=null) {
				returnString.append(value+token);
			}
		}
		return returnString.length()==0?null:returnString.substring(0,returnString.length()-1);
	}

	/**
	 * Converts a Set object into a delimited string compatible with SQL IN select.
	 *
	 * @param	str		Set to convert
	 * @return			String
	 *
	 * @see	String
	 * @see	Set
	 */
	public final static String setToSQLinString(final Set<String> str) {
final	StringBuilder		returnString	=	new StringBuilder();
final	Iterator<String>	values			=	str.iterator();
		while(values.hasNext()){
final	String				value			=	values.next();
			if (value!=null) {
				returnString.append("'"+value+"',");
			}
		}
		return returnString.length()==0?null:"("+returnString.substring(0,returnString.length()-1)+")";
	}

	/**
	 * Converts a String[] array into a comma delimited string.
	 *
	 * @param	str		String Array to convert into string
	 * @return Comma delimited String value
	 *
	 * @see	String
	 */
	public final static String arrayToString(final String[] str) {
		return arrayToString(str, ",");
	}

	/**
	 * Converts a String[] array into a "token" delimited string.
	 * @param	str		String Array to convert
	 * @param	token	The delimiter value to use as the token
	 * @return	"Token" delimited String value
	 *
	 * @see	String
	 */
	public final static String arrayToString(final String[] str, final String token) {
final	StringBuilder	returnString	=	new StringBuilder();
		for (final String s:str) {
			returnString.append(s+token);
		}
		return returnString.length()==0?null:"("+returnString.substring(0,returnString.length()-1)+")";
	}

	/**
	 * Converts an int[] array into a comma delimited string.
	 *
	 * @param	ints	int array to convert into string
	 * @return Comma delimited String value
	 *
	 * @see String
	 */
	public final static String arrayToString(final int[] ints) {
		return arrayToString(ints, ",");
	}

	/**
	 * Converts an int[] array into a "token" delimited string.
	 * @param	ints	int array to convert
	 * @param	token	The delimiter to use as the token
	 * @return "Token" delimited String value
	 *
	 * @see String
	 */
	public final static String arrayToString(final int[] ints, final String token) {
final	StringBuilder	returnString	=	new StringBuilder();
		for (final int i:ints) {
			returnString.append(i+token);
		}
		return returnString.length()==0?null:"("+returnString.substring(0,returnString.length()-1)+")";
	}

	/**
	 * Converts a String into UTF8 String format
	 *
	 * @param	stringToConvert	The String to Convert
	 *
	 * @return String value converted in UTF8 format
	 *
	 * @see String
	 */
	public final static	String	toUTF8String(final String stringToConvert) {
		try {
final	byte ptext[]	=	stringToConvert.getBytes("ISO-8859-1");
			return new String(ptext, "UTF-8");
		} catch (final UnsupportedEncodingException uee) {
			return stringToConvert;
		}
	}


	/**
	 * @param stringToTrim The String value to trim of any whitespace or single/double quotation
	 *
	 * @return Trimmed value of the String
	 *
	 * @see String
	 */
	public final static String trim(String stringToTrim){
		if (stringToTrim==null) {
			return null;
		}
		try{
			stringToTrim		=	stringToTrim.trim();
			if (stringToTrim.startsWith("\"") && stringToTrim.endsWith("\"")){
				stringToTrim	=	stringToTrim.substring(1,stringToTrim.length()-1);
			}
			if (stringToTrim.startsWith("'") && stringToTrim.endsWith("'")){
				stringToTrim	=	stringToTrim.substring(1,stringToTrim.length()-1);
			}
		} catch (final Exception e){}
		return stringToTrim;
	}

}
