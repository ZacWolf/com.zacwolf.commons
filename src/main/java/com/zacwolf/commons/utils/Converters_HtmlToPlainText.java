/* com.zacwolf.commons.utils.HtmlToPlainText.java
 *
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

	based on work by: Jonathan Hedley, jonathan@hedley.net
 */
package com.zacwolf.commons.utils;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.helper.Validate;
import org.jsoup.internal.StringUtil;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.NodeTraversor;
import org.jsoup.select.NodeVisitor;

/**
 * HTML to plain-text. This example program demonstrates the use of jsoup to convert HTML input to lightly-formatted
 * plain-text. That is divergent from the general goal of jsoup's .text() methods, which is to get clean data from a
 * scrape.
 *
 * Note that this is a fairly simplistic formatter -- for real world use you'll want to embrace and extend.
 *
 * @author Zac Morris
 * @version 2.0
 * @since Java1.8
 */
public class Converters_HtmlToPlainText {

	/**
	 * Private constructor to prevent this otherwise static class from being instantiated.
	 **/
	private Converters_HtmlToPlainText(){
		super();
	}

	/**
	 * Format an Element to plain-text
	 *
	 * @param	element		the root element to format
	 * @return	formatted text
	 */
	public static String getPlainText(final Element element) {
		return getPlainText(element,72);
	}

	/**
	 * Format an Element to plain-text
	 *
	 * @param	element		the root element to format
	 * @param	columns		the number of characters per line
	 * @return	formatted text
	 */
	public static String getPlainText(final Element element, final int columns) {
final	FormattingVisitor	formatter	=	new FormattingVisitor(columns);
		NodeTraversor.traverse(formatter, element);
		return formatter.toString();
	}

	// the formatting rules, implemented in a breadth-first DOM traverse
	private static class FormattingVisitor implements NodeVisitor {
		private			final	int				maxWidth;
		private					int				width		=	0;
		private			final	StringBuilder	accum		=	new StringBuilder(); // holds the accumulated text

		FormattingVisitor(final int maxwidth){
			maxWidth	=	maxwidth;
		}

		// hit when the node is first seen
		@Override
		public void head(final Node node, final int depth) {
final	String name = node.nodeName();
			if (node instanceof TextNode) {
				append(((TextNode) node).text()); // TextNodes carry all user-readable text in the DOM.
			} else if (name.equals("li")) {
				append("\n * ");
			}
		}

		// hit when all of the node's children (if any) have been visited
		@Override
		public void tail(final Node node, final int depth) {
final	String	name	=	node.nodeName();
			if (name.equals("br")) {
				append("\n");
			} else if (StringUtil.in(name, "p", "h1", "h2", "h3", "h4", "h5")) {
				append("\n\n");
			} else if (name.equals("a")) {
				append(String.format(" <%s>", node.absUrl("href")));
			}
		}

		// appends text to the string builder with a simple word wrap method
		private void append(final String text) {
			if (text.startsWith("\n"))
			 {
				width = 0; // reset counter if starts with a newline. only from formats above, not in natural text
			}
			if (text.equals(" ") && (accum.length() == 0 || StringUtil.in(accum.substring(accum.length() - 1), " ", "\n")))
			 {
				return; // don't accumulate long runs of empty spaces
			}
			if (text.length() + width > maxWidth) { // won't fit, needs to wrap
final	String	words[]				=	text.split("\\s+");
				for (int i = 0; i < words.length; i++) {
		String	word				=	words[i];
					if (i != words.length - 1) {
						word		=	word + " ";
					}
					if (word.length() + width > maxWidth) { // wrap and reset counter
						accum.append("\n").append(word);
						width	=	word.length();
					} else {
						accum.append(word);
						width	+=	word.length();
					}
				}
			} else { // fits as is, without need to wrap text
				accum.append(text);
				width += text.length();
			}
		}

		@Override
		public String toString() {
			return accum.toString();
		}
	}

	public static void main(final String[] args) throws IOException {
		Validate.isTrue(args.length == 1, "usage: supply url to fetch");
final	String			url			=	args[0];
final	Document		doc			=	Jsoup.connect(url).get();
final	String			plainText	=	getPlainText(doc);
		System.out.println(plainText);
	}
}
