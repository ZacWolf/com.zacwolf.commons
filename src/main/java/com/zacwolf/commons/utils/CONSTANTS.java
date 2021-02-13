/* com.zacwolf.commons.utils.CountryCodes.java
 *
 * Defines iso3661 Country abbreviations
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

/**
 * @author Zac Morris
 * @version 2.0
 * @since Java1.8
 */
public class CONSTANTS{

	/**
	 * Private constructor to prevent this otherwise static class from being instantiated.
	 **/
	private CONSTANTS(){
		super();
	}

final	public	static	String		BLANK		=	"                                                     ";

	public static class CountryCodes {
		public static Map<String,String>	iso3661_1	=	new HashMap<String,String>();

		static{
			iso3661_1.put("AFGHANISTAN","AF");
			iso3661_1.put("ÅLAND ISLANDS","AX");
			iso3661_1.put("ALBANIA","AL");
			iso3661_1.put("ALGERIA","DZ");
			iso3661_1.put("AMERICAN SAMOA","AS");
			iso3661_1.put("ANDORRA","AD");
			iso3661_1.put("ANGOLA","AO");
			iso3661_1.put("ANGUILLA","AI");
			iso3661_1.put("ANTARCTICA","AQ");
			iso3661_1.put("ANTIGUA AND BARBUDA","AG");
			iso3661_1.put("ARGENTINA","AR");
			iso3661_1.put("ARMENIA","AM");
			iso3661_1.put("ARUBA","AW");
			iso3661_1.put("AUSTRALIA","AU");
			iso3661_1.put("AUSTRIA","AT");
			iso3661_1.put("AZERBAIJAN","AZ");
			iso3661_1.put("BAHAMAS","BS");
			iso3661_1.put("BAHRAIN","BH");
			iso3661_1.put("BANGLADESH","BD");
			iso3661_1.put("BARBADOS","BB");
			iso3661_1.put("BELARUS","BY");
			iso3661_1.put("BELGIUM","BE");
			iso3661_1.put("BELIZE","BZ");
			iso3661_1.put("BENIN","BJ");
			iso3661_1.put("BERMUDA","BM");
			iso3661_1.put("BHUTAN","BT");
			iso3661_1.put("BOLIVIA, PLURINATIONAL STATE OF","BO");
			iso3661_1.put("BONAIRE, SINT EUSTATIUS AND SABA","BQ");
			iso3661_1.put("BOSNIA AND HERZEGOVINA","BA");
			iso3661_1.put("BOTSWANA","BW");
			iso3661_1.put("BOUVET ISLAND","BV");
			iso3661_1.put("BRAZIL","BR");
			iso3661_1.put("BRITISH INDIAN OCEAN TERRITORY","IO");
			iso3661_1.put("BRUNEI DARUSSALAM","BN");
			iso3661_1.put("BULGARIA","BG");
			iso3661_1.put("BURKINA FASO","BF");
			iso3661_1.put("BURUNDI","BI");
			iso3661_1.put("CAMBODIA","KH");
			iso3661_1.put("CAMEROON","CM");
			iso3661_1.put("CANADA","CA");
			iso3661_1.put("CAPE VERDE","CV");
			iso3661_1.put("CAYMAN ISLANDS","KY");
			iso3661_1.put("CENTRAL AFRICAN REPUBLIC","CF");
			iso3661_1.put("CHAD","TD");
			iso3661_1.put("CHILE","CL");
			iso3661_1.put("CHINA","CN");
			iso3661_1.put("CHRISTMAS ISLAND","CX");
			iso3661_1.put("COCOS (KEELING) ISLANDS","CC");
			iso3661_1.put("COLOMBIA","CO");
			iso3661_1.put("COMOROS","KM");
			iso3661_1.put("CONGO","CG");
			iso3661_1.put("CONGO, THE DEMOCRATIC REPUBLIC OF THE","CD");
			iso3661_1.put("COOK ISLANDS","CK");
			iso3661_1.put("COSTA RICA","CR");
			iso3661_1.put("CÔTE D'IVOIRE","CI");
			iso3661_1.put("CROATIA","HR");
			iso3661_1.put("CUBA","CU");
			iso3661_1.put("CURAÇAO","CW");
			iso3661_1.put("CYPRUS","CY");
			iso3661_1.put("CZECH REPUBLIC","CZ");
			iso3661_1.put("DENMARK","DK");
			iso3661_1.put("DJIBOUTI","DJ");
			iso3661_1.put("DOMINICA","DM");
			iso3661_1.put("DOMINICAN REPUBLIC","DO");
			iso3661_1.put("ECUADOR","EC");
			iso3661_1.put("EGYPT","EG");
			iso3661_1.put("EL SALVADOR","SV");
			iso3661_1.put("EQUATORIAL GUINEA","GQ");
			iso3661_1.put("ERITREA","ER");
			iso3661_1.put("ESTONIA","EE");
			iso3661_1.put("ETHIOPIA","ET");
			iso3661_1.put("FALKLAND ISLANDS (MALVINAS)","FK");
			iso3661_1.put("FAROE ISLANDS","FO");
			iso3661_1.put("FIJI","FJ");
			iso3661_1.put("FINLAND","FI");
			iso3661_1.put("FRANCE","FR");
			iso3661_1.put("FRENCH GUIANA","GF");
			iso3661_1.put("FRENCH POLYNESIA","PF");
			iso3661_1.put("FRENCH SOUTHERN TERRITORIES","TF");
			iso3661_1.put("GABON","GA");
			iso3661_1.put("GAMBIA","GM");
			iso3661_1.put("GEORGIA","GE");
			iso3661_1.put("GERMANY","DE");
			iso3661_1.put("GHANA","GH");
			iso3661_1.put("GIBRALTAR","GI");
			iso3661_1.put("GREECE","GR");
			iso3661_1.put("GREENLAND","GL");
			iso3661_1.put("GRENADA","GD");
			iso3661_1.put("GUADELOUPE","GP");
			iso3661_1.put("GUAM","GU");
			iso3661_1.put("GUATEMALA","GT");
			iso3661_1.put("GUERNSEY","GG");
			iso3661_1.put("GUINEA","GN");
			iso3661_1.put("GUINEA-BISSAU","GW");
			iso3661_1.put("GUYANA","GY");
			iso3661_1.put("HAITI","HT");
			iso3661_1.put("HEARD ISLAND AND MCDONALD ISLANDS","HM");
			iso3661_1.put("HOLY SEE (VATICAN CITY STATE)","VA");
			iso3661_1.put("HONDURAS","HN");
			iso3661_1.put("HONG KONG","HK");
			iso3661_1.put("HUNGARY","HU");
			iso3661_1.put("ICELAND","IS");
			iso3661_1.put("INDIA","IN");
			iso3661_1.put("INDONESIA","ID");
			iso3661_1.put("IRAN, ISLAMIC REPUBLIC OF","IR");
			iso3661_1.put("IRAQ","IQ");
			iso3661_1.put("IRELAND","IE");
			iso3661_1.put("ISLE OF MAN","IM");
			iso3661_1.put("ISRAEL","IL");
			iso3661_1.put("ITALY","IT");
			iso3661_1.put("JAMAICA","JM");
			iso3661_1.put("JAPAN","JP");
			iso3661_1.put("JERSEY","JE");
			iso3661_1.put("JORDAN","JO");
			iso3661_1.put("KAZAKHSTAN","KZ");
			iso3661_1.put("KENYA","KE");
			iso3661_1.put("KIRIBATI","KI");
			iso3661_1.put("KOREA, DEMOCRATIC PEOPLE'S REPUBLIC OF","KP");
			iso3661_1.put("KOREA, REPUBLIC OF","KR");
			iso3661_1.put("KUWAIT","KW");
			iso3661_1.put("KYRGYZSTAN","KG");
			iso3661_1.put("LAO PEOPLE'S DEMOCRATIC REPUBLIC","LA");
			iso3661_1.put("LATVIA","LV");
			iso3661_1.put("LEBANON","LB");
			iso3661_1.put("LESOTHO","LS");
			iso3661_1.put("LIBERIA","LR");
			iso3661_1.put("LIBYA","LY");
			iso3661_1.put("LIECHTENSTEIN","LI");
			iso3661_1.put("LITHUANIA","LT");
			iso3661_1.put("LUXEMBOURG","LU");
			iso3661_1.put("MACAO","MO");
			iso3661_1.put("MACEDONIA, THE FORMER YUGOSLAV REPUBLIC OF","MK");
			iso3661_1.put("MADAGASCAR","MG");
			iso3661_1.put("MALAWI","MW");
			iso3661_1.put("MALAYSIA","MY");
			iso3661_1.put("MALDIVES","MV");
			iso3661_1.put("MALI","ML");
			iso3661_1.put("MALTA","MT");
			iso3661_1.put("MARSHALL ISLANDS","MH");
			iso3661_1.put("MARTINIQUE","MQ");
			iso3661_1.put("MAURITANIA","MR");
			iso3661_1.put("MAURITIUS","MU");
			iso3661_1.put("MAYOTTE","YT");
			iso3661_1.put("MEXICO","MX");
			iso3661_1.put("MICRONESIA, FEDERATED STATES OF","FM");
			iso3661_1.put("MOLDOVA, REPUBLIC OF","MD");
			iso3661_1.put("MONACO","MC");
			iso3661_1.put("MONGOLIA","MN");
			iso3661_1.put("MONTENEGRO","ME");
			iso3661_1.put("MONTSERRAT","MS");
			iso3661_1.put("MOROCCO","MA");
			iso3661_1.put("MOZAMBIQUE","MZ");
			iso3661_1.put("MYANMAR","MM");
			iso3661_1.put("NAMIBIA","NA");
			iso3661_1.put("NAURU","NR");
			iso3661_1.put("NEPAL","NP");
			iso3661_1.put("NETHERLANDS","NL");
			iso3661_1.put("NEW CALEDONIA","NC");
			iso3661_1.put("NEW ZEALAND","NZ");
			iso3661_1.put("NICARAGUA","NI");
			iso3661_1.put("NIGER","NE");
			iso3661_1.put("NIGERIA","NG");
			iso3661_1.put("NIUE","NU");
			iso3661_1.put("NORFOLK ISLAND","NF");
			iso3661_1.put("NORTHERN MARIANA ISLANDS","MP");
			iso3661_1.put("NORWAY","NO");
			iso3661_1.put("OMAN","OM");
			iso3661_1.put("PAKISTAN","PK");
			iso3661_1.put("PALAU","PW");
			iso3661_1.put("PALESTINIAN TERRITORY, OCCUPIED","PS");
			iso3661_1.put("PANAMA","PA");
			iso3661_1.put("PAPUA NEW GUINEA","PG");
			iso3661_1.put("PARAGUAY","PY");
			iso3661_1.put("PERU","PE");
			iso3661_1.put("PHILIPPINES","PH");
			iso3661_1.put("PITCAIRN","PN");
			iso3661_1.put("POLAND","PL");
			iso3661_1.put("PORTUGAL","PT");
			iso3661_1.put("PUERTO RICO","PR");
			iso3661_1.put("QATAR","QA");
			iso3661_1.put("RÉUNION","RE");
			iso3661_1.put("ROMANIA","RO");
			iso3661_1.put("RUSSIAN FEDERATION","RU");
			iso3661_1.put("RWANDA","RW");
			iso3661_1.put("SAINT BARTHÉLEMY","BL");
			iso3661_1.put("SAINT HELENA, ASCENSION AND TRISTAN DA CUNHA","SH");
			iso3661_1.put("SAINT KITTS AND NEVIS","KN");
			iso3661_1.put("SAINT LUCIA","LC");
			iso3661_1.put("SAINT MARTIN (FRENCH PART)","MF");
			iso3661_1.put("SAINT PIERRE AND MIQUELON","PM");
			iso3661_1.put("SAINT VINCENT AND THE GRENADINES","VC");
			iso3661_1.put("SAMOA","WS");
			iso3661_1.put("SAN MARINO","SM");
			iso3661_1.put("SAO TOME AND PRINCIPE","ST");
			iso3661_1.put("SAUDI ARABIA","SA");
			iso3661_1.put("SENEGAL","SN");
			iso3661_1.put("SERBIA","RS");
			iso3661_1.put("SEYCHELLES","SC");
			iso3661_1.put("SIERRA LEONE","SL");
			iso3661_1.put("SINGAPORE","SG");
			iso3661_1.put("SINT MAARTEN (DUTCH PART)","SX");
			iso3661_1.put("SLOVAKIA","SK");
			iso3661_1.put("SLOVENIA","SI");
			iso3661_1.put("SOLOMON ISLANDS","SB");
			iso3661_1.put("SOMALIA","SO");
			iso3661_1.put("SOUTH AFRICA","ZA");
			iso3661_1.put("SOUTH GEORGIA AND THE SOUTH SANDWICH ISLANDS","GS");
			iso3661_1.put("SOUTH SUDAN","SS");
			iso3661_1.put("SPAIN","ES");
			iso3661_1.put("SRI LANKA","LK");
			iso3661_1.put("SUDAN","SD");
			iso3661_1.put("SURINAME","SR");
			iso3661_1.put("SVALBARD AND JAN MAYEN","SJ");
			iso3661_1.put("SWAZILAND","SZ");
			iso3661_1.put("SWEDEN","SE");
			iso3661_1.put("SWITZERLAND","CH");
			iso3661_1.put("SYRIAN ARAB REPUBLIC","SY");
			iso3661_1.put("TAIWAN, PROVINCE OF CHINA","TW");
			iso3661_1.put("TAJIKISTAN","TJ");
			iso3661_1.put("TANZANIA, UNITED REPUBLIC OF","TZ");
			iso3661_1.put("THAILAND","TH");
			iso3661_1.put("TIMOR-LESTE","TL");
			iso3661_1.put("TOGO","TG");
			iso3661_1.put("TOKELAU","TK");
			iso3661_1.put("TONGA","TO");
			iso3661_1.put("TRINIDAD AND TOBAGO","TT");
			iso3661_1.put("TUNISIA","TN");
			iso3661_1.put("TURKEY","TR");
			iso3661_1.put("TURKMENISTAN","TM");
			iso3661_1.put("TURKS AND CAICOS ISLANDS","TC");
			iso3661_1.put("TUVALU","TV");
			iso3661_1.put("UGANDA","UG");
			iso3661_1.put("UKRAINE","UA");
			iso3661_1.put("UNITED ARAB EMIRATES","AE");
			iso3661_1.put("UNITED KINGDOM","GB");
			iso3661_1.put("UNITED STATES","US");
			iso3661_1.put("UNITED STATES MINOR OUTLYING ISLANDS","UM");
			iso3661_1.put("URUGUAY","UY");
			iso3661_1.put("UZBEKISTAN","UZ");
			iso3661_1.put("VANUATU","VU");
			iso3661_1.put("VENEZUELA, BOLIVARIAN REPUBLIC OF","VE");
			iso3661_1.put("VIET NAM","VN");
			iso3661_1.put("VIRGIN ISLANDS, BRITISH","VG");
			iso3661_1.put("VIRGIN ISLANDS, U.S.","VI");
			iso3661_1.put("WALLIS AND FUTUNA","WF");
			iso3661_1.put("WESTERN SAHARA","EH");
			iso3661_1.put("YEMEN","YE");
			iso3661_1.put("ZAMBIA","ZM");
			iso3661_1.put("ZIMBABWE","ZW");
		}
	}
	public static class USPSstateCode {
		public static final Map<String,String>	usState	=	new HashMap<String,String>();

		static {
			usState.put("ALABAMA","AL");
			usState.put("ALASKA","AK");
			usState.put("AMERICAN SAMOA","AS");
			usState.put("ARIZONA","AZ");
			usState.put("ARKANSAS","AR");
			usState.put("CALIFORNIA","CA");
			usState.put("COLORADO","CO");
			usState.put("CONNECTICUT","CT");
			usState.put("DELAWARE","DE");
			usState.put("DISTRICT OF COLUMBIA","DC");
			usState.put("FEDERATED STATES OF MICRONESIA","FM");
			usState.put("FLORIDA","FL");
			usState.put("GEORGIA","GA");
			usState.put("GUAM","GU");
			usState.put("HAWAII","HI");
			usState.put("IDAHO","ID");
			usState.put("ILLINOIS","IL");
			usState.put("INDIANA","IN");
			usState.put("IOWA","IA");
			usState.put("KANSAS","KS");
			usState.put("KENTUCKY","KY");
			usState.put("LOUISIANA","LA");
			usState.put("MAINE","ME");
			usState.put("MARSHALL ISLANDS","MH");
			usState.put("MARYLAND","MD");
			usState.put("MASSACHUSETTS","MA");
			usState.put("MICHIGAN","MI");
			usState.put("MINNESOTA","MN");
			usState.put("MISSISSIPPI","MS");
			usState.put("MISSOURI","MO");
			usState.put("MONTANA","MT");
			usState.put("NEBRASKA","NE");
			usState.put("NEVADA","NV");
			usState.put("NEW HAMPSHIRE","NH");
			usState.put("NEW JERSEY","NJ");
			usState.put("NEW MEXICO","NM");
			usState.put("NEW YORK","NY");
			usState.put("NORTH CAROLINA","NC");
			usState.put("NORTH DAKOTA","ND");
			usState.put("NORTHERN MARIANA ISLANDS","MP");
			usState.put("OHIO","OH");
			usState.put("OKLAHOMA","OK");
			usState.put("OREGON","OR");
			usState.put("PALAU","PW");
			usState.put("PENNSYLVANIA","PA");
			usState.put("PUERTO RICO","PR");
			usState.put("RHODE ISLAND","RI");
			usState.put("SOUTH CAROLINA","SC");
			usState.put("SOUTH DAKOTA","SD");
			usState.put("TENNESSEE","TN");
			usState.put("TEXAS","TX");
			usState.put("UTAH","UT");
			usState.put("VERMONT","VT");
			usState.put("VIRGIN ISLANDS","VI");
			usState.put("VIRGINIA","VA");
			usState.put("WASHINGTON","WA");
			usState.put("WEST VIRGINIA","WV");
			usState.put("WISCONSIN","WI");
			usState.put("WYOMING","WY");
			usState.put("Armed Forces Africa","AE");
			usState.put("Armed Forces Americas","AA");
			usState.put("Armed Forces Canada","AE");
			usState.put("Armed Forces Europe","AE");
			usState.put("Armed Forces Middle East","AE");
			usState.put("Armed Forces Pacific","AP");
		}
	}

	public static class UI {

		public static final	Map<String,String>	image_mimetypes	=	new HashMap<String,String>();

		static{
			image_mimetypes.put("jpg","image/jpeg");
			image_mimetypes.put("jpeg","image/jpg");
			image_mimetypes.put("png","image/png");
			image_mimetypes.put("gif","image/gif");
			image_mimetypes.put("tif","image/tif");
		}
	}
}
