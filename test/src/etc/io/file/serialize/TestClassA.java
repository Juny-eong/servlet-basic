package etc.io.file.serialize;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class TestClassA<K, V> implements Serializable {
	
	private static final long serialVersionUID = 1332806234356649955L;
	private K key;
	private V value;
	transient int transientField = 10;
	
	TestClassB classB = new TestClassB();
	
	
	
	public TestClassA(K k, V v) {
		this.setKey(k);
		this.setValue(v);
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}
	
	public Map<K, V> getEntry() {
		Map<K, V> map = new HashMap<>();
		map.put(this.key, this.value);
		return map;	
	}
	

}
