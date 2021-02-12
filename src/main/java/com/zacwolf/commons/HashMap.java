/* com.zacwolf.commons.utils.HashMap.java
 *
 * Copyright (C) 2021-2021 Zac Morris <a href="mailto:zac@zacwolf.com">zac@zacwolf.com</a>

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
package com.zacwolf.commons;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 *
 */
public class HashMap<K, V> implements Map<K, V>{

final	private	Map<K,V>	myMap;

	/**
	 *
	 */
	public HashMap() {
		this(false);
	}

	/**
	 *
	 */
	public HashMap(final boolean memoryFriendly){
		if (memoryFriendly) {
			myMap	=	new SoftHashMap<K,V>();
		} else {
			myMap	=	new java.util.HashMap<K,V>();
		}
	}

	@Override
	public int size(){
		return myMap.size();
	}

	@Override
	public boolean isEmpty(){
		return myMap.isEmpty();
	}

	@Override
	public boolean containsKey(final Object key){
		return myMap.containsKey(key);
	}

	@Override
	public boolean containsValue(final Object value){
		return myMap.containsValue(value);
	}

	@Override
	public V get(final Object key){
		return myMap.get(key);
	}

	@Override
	public V put(final K key, final V value){
		return myMap.put(key,value);
	}

	@Override
	public V remove(final Object key){
		return myMap.remove(key);
	}

	@Override
	public void putAll(final Map<? extends K, ? extends V> m){
		myMap.putAll(m);
	}

	@Override
	public void clear(){
		myMap.clear();
	}

	@Override
	public Set<K> keySet(){
		return myMap.keySet();
	}

	@Override
	public Collection<V> values(){
		return myMap.values();
	}

	@Override
	public Set<Entry<K, V>> entrySet(){
		return myMap.entrySet();
	}

}
