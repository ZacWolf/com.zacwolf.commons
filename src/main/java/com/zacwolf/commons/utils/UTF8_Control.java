/* com.zacwolf.commons.utils.UTF8Control.java
 *
 * Constants used to define the US State abbreviations
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

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;
import java.util.ResourceBundle.Control;

/**
 * @author Zac Morris
 * @version 2.0
 * @since Java1.8
 */
public class UTF8_Control extends Control {
	@Override
	public ResourceBundle newBundle (final String baseName, final Locale locale, final String format, final ClassLoader loader, final boolean reload) throws IllegalAccessException, InstantiationException, IOException {
	// The below is a copy of the default implementation.
final	String 			bundleName 		=	super.toBundleName(baseName, locale);
final	String 			resourceName 	=	super.toResourceName(bundleName, "properties");
		ResourceBundle 	bundle 			=	null;
		InputStream 	stream 			=	null;
		if (reload) {
final	URL 			url 			=	loader.getResource(resourceName);
			if (url != null) {
final	URLConnection 	connection 		=	url.openConnection();
				if (connection != null) {
					connection.setUseCaches(false);
					stream				=	connection.getInputStream();
				}
			}
		} else {	stream 				=	loader.getResourceAsStream(resourceName);
		}
		if (stream != null) {
			try {
				// Only this line is changed to make it to read properties files as UTF-8.
				bundle					=	new PropertyResourceBundle(new InputStreamReader(stream, "UTF-8"));
			} finally {
				stream.close();
			}
		}
		return bundle;
	}
}
