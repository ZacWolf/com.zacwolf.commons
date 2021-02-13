/* com.zacwolf.commons.utils.PasswordUtils.java
 *
 * Abstract class for specifying a specific type of Crypter
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

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.RandomUtils;

/**
 * @author Zac Morris
 * @version 2.0
 * @since Java1.8
 */
public class PasswordUtils {

final	public	static		String		LCaseChars		=	"abcdefgijkmnopqrstwxyz";
final	public	static		String		UCaseChars		=	"ABCDEFGHJKLMNPQRSTWXYZ";
final	public	static		String		NumericChars	=	"0123456789";
final	public	static		String		SpecialChars	=	"!\"#$%&'()*+,-./:;<=>?@[]^_`{|}~";
final	private	static		int			lcase			=	0;
final	private	static		int			ucase			=	1;
final	private	static		int			num				=	2;
final	private	static		int			special			=	3;

	public static String generateRandom(final int length) {
		return generateRandom(length,length,0,0,0,0);
	}

	public static String generateRandom(final int minLength, final int maxLength) {
		return generateRandom(minLength,maxLength,0,0,0,0);
	}

	public static String generateRandom(final int minLength, final int maxLength, final int minLCaseCount, final int minUCaseCount, final int minNumCount, final int minSpecialCount){
final	Map<Integer,Integer>	charGroupsUsed			=	new HashMap<Integer,Integer>();
								charGroupsUsed.put(lcase, minLCaseCount);
								charGroupsUsed.put(ucase, minUCaseCount);
								charGroupsUsed.put(num, minNumCount);
								charGroupsUsed.put(special, minSpecialCount);
final	char[] 					randomString;
		if (minLength < maxLength){
								randomString			=	new char[RandomUtils.nextInt(minLength, maxLength + 1)];
		} else {				randomString			=	new char[minLength];
		}
		int						requiredCharactersLeft	=	minLCaseCount + minUCaseCount + minNumCount + minSpecialCount;
		for (int i = 0; i < randomString.length; i++) {
final	StringBuilder			selectableChars			=	new StringBuilder();
			if (requiredCharactersLeft < randomString.length - i) {
								selectableChars.append(LCaseChars).append(UCaseChars).append(NumericChars).append(SpecialChars);
			} else {
				for (final Integer k :charGroupsUsed.keySet()) {
					if (charGroupsUsed.get(k)>0) {
						switch (k) {
							case lcase:
								selectableChars.append(LCaseChars);
								break;
							case ucase:
								selectableChars.append(UCaseChars);
								break;
							case num:
								selectableChars.append(NumericChars);
								break;
							case special:
								selectableChars.append(SpecialChars);
								break;
						}
					}
				}
			}
final	char					nextChar				=	selectableChars.charAt(RandomUtils.nextInt(0, selectableChars.length()));
								randomString[i]			=	nextChar;
			if (LCaseChars.contains(String.valueOf(nextChar))){
								charGroupsUsed.put(lcase, charGroupsUsed.get(lcase)-1);
				if (charGroupsUsed.get(lcase) >= 0) {
					requiredCharactersLeft--;
				}
			} else if (UCaseChars.contains(String.valueOf(nextChar))){
								charGroupsUsed.put(ucase,charGroupsUsed.get(ucase)-1);
				if (charGroupsUsed.get(ucase) >= 0) {
					requiredCharactersLeft--;
				}
			} else if (NumericChars.contains(String.valueOf(nextChar))){
								charGroupsUsed.put(num,charGroupsUsed.get(num)-1);
				if (charGroupsUsed.get(num) >= 0) {
					requiredCharactersLeft--;
				}
			} else if (SpecialChars.contains(String.valueOf(nextChar))){
								charGroupsUsed.put(special,charGroupsUsed.get(special)-1);
				if (charGroupsUsed.get(special) >= 0) {
					requiredCharactersLeft--;
				}
			}
		}
		return new String(randomString);
	}

	public static void main(final String[] args) {
		try{
			System.out.println(generateRandom(Integer.parseInt(args[0]),
											  Integer.parseInt(args[1]),
											  Integer.parseInt(args[2]),
											  Integer.parseInt(args[3]),
											  Integer.parseInt(args[4]),
											  Integer.parseInt(args[5])
											)
							  );
		} catch (final Exception e){
			System.err.println("Required Arguments: int minLength, int maxLength, int minLCaseCount, int minUCaseCount, int minNumCount, int minSpecialCount");
			e.printStackTrace();
		}
	}
}
