/* com.zacwolf.commons.email.JVM.java
 *
 * JVM Memory usage stats
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

import java.text.DecimalFormat;

/**
 * @author Zac Morris
 * @version 2.0
 * @since Java1.8
 */
public class JVM {

	public static String getMemoryStats(){
		return getMemoryStats(false);
	}

	public static String getMemoryStats(final boolean garbagecollect){
		if (garbagecollect) {
			System.gc();
		}
final	DecimalFormat	twoDForm	=	new DecimalFormat("#.##");
final	Runtime			rt			=	Runtime.getRuntime();
final	double			free		=	rt.freeMemory()/1048576d;
final	double			total		=	rt.totalMemory()/1048576d;
final	double			max			=	rt.maxMemory()/1048576d;
		return " JVM Memory - Max:"+twoDForm.format(max)+"MB Total:"+twoDForm.format(total)+"MB Free:"+twoDForm.format(free)+" Used:"+twoDForm.format(total-free)+"MB";
	}
}
