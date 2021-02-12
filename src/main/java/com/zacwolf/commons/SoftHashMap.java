/* com.zacwolf.commons.utils.SoftHashMap.java
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

import java.io.Serializable;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.AbstractMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 */
public class SoftHashMap <K, V> extends AbstractMap<K, V> implements Serializable {
final	private	static	long				serialVersionUID=	2870536130329884077L;

final	private	Map<K, SoftReference<V>>	hash			=	new java.util.HashMap<K, SoftReference<V>>();
final	private Map<SoftReference<V>, K>	reverseLookup	=	new java.util.HashMap<SoftReference<V>, K>();
final	private	ReferenceQueue<V>			queue			=	new ReferenceQueue<V>();

	private void expungeStaleEntries() {
	Reference<? extends V>	sv;
		while ((sv = queue.poll()) != null) {
			hash.remove(reverseLookup.remove(sv));
		}
	}

	@Override
	public V get(final Object key) {
		expungeStaleEntries();
		V									result			=	null;
    // We get the SoftReference represented by that key
final	SoftReference<V>					soft_ref		=	hash.get(key);
		if (soft_ref != null) {
			// From the SoftReference we get the value, which can be
			// null if it has been garbage collected
    										result			=	soft_ref.get();
    		if (result == null) {
    			// If the value has been garbage collected, remove the
    			// entry from the HashMap.
    										hash.remove(key);
    										reverseLookup.remove(soft_ref);
    		}
		}
		return result;
	}

	@Override
	public V put(final K key, final V value) {
		expungeStaleEntries();
final	SoftReference<V>					soft_ref 		=	new SoftReference<V>(value, queue);
  		reverseLookup.put(soft_ref, key);
final	SoftReference<V>					result			=	hash.put(key, soft_ref);
  		if (result == null) {
			return null;
		}
  		reverseLookup.remove(result);
  		return result.get();
	}

	@Override
	public V remove(final Object key) {
		expungeStaleEntries();
final	SoftReference<V>					result			=	hash.remove(key);
		if (result == null) {
			return null;
		}
		return result.get();
	}

	@Override
	public void clear() {
		hash.clear();
		reverseLookup.clear();
	}

	@Override
	public int size() {
		expungeStaleEntries();
		return hash.size();
	}

	/**
	 * Returns a copy of the key/values in the map at the point of
	 * calling.  However, setValue still sets the value in the
	 * actual SoftHashMap.
	 */
	@Override
	public Set<Entry<K,V>> entrySet() {
		expungeStaleEntries();
final	Set<Entry<K,V>>							result			=	new LinkedHashSet<Entry<K, V>>();
		for (final Entry<K, SoftReference<V>> entry : hash.entrySet()) {
final	V										value			=	entry.getValue().get();
			if (value != null) {
		        result.add(new Entry<K, V>() {
		        	@Override
		        	public K getKey() {
		        		return entry.getKey();
		        	}
		        	@Override
		        	public V getValue() {
		        		return value;
		        	}
		        	@Override
		        	public V setValue(final V v) {
		        		entry.setValue(new SoftReference<V>(v, queue));
		        		return value;
		        	}
		        });
			}
		}
		return result;
	}

	@Override
	public boolean containsKey(final Object key) {
		expungeStaleEntries();
		return	hash.containsKey(key);
	}

	@Override
	public boolean containsValue(final Object value) {
		expungeStaleEntries();
		return hash.containsValue(value);
	}
}