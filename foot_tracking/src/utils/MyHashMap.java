package utils;

class Entry{
	int hash;
	Object key;
	Object value;
	Entry next;
	
	public Entry(int hash, Object key, Object value) {
		this.hash = hash;
		this.key = key;
		this.value = value;
	}
}

public class MyHashMap<K, V> {
	private final static int DEFAULT_SIZE=16;
	private Entry[] entries;
	private int size=0;
	
	public MyHashMap() {
		entries = new Entry[DEFAULT_SIZE];
	}
	
	public int size() {
		return this.size;
	}
	
	public void put(K key, V value) {
		int hashcode = hash(key.hashCode());
		
		Entry temp = entries[hashcode];
		Entry last = null;
		boolean duplicated = false;
		if(temp == null) {
			Entry newEntry = new Entry(hashcode, key, value);
			entries[hashcode] = newEntry;
			size++;
		}
		else {
			while(temp != null) {
				if(temp.key.equals(key)) {
					temp.value = value;
					duplicated = true;
					break;
				}
				else {
					last = temp;
					temp = temp.next;
				}
			}
			
			if(!duplicated) {
				Entry newEntry = new Entry(hashcode, key, value);
				last.next = newEntry;
				size++;
			}
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public V get(K key) {
		int hashcode = hash(key.hashCode());
		
		Entry temp = entries[hashcode];
		
		if(temp==null)
			return null;
		else {
			while(temp != null) {
				if(temp.key.equals(key))
					return (V)temp.value;
			}
		}
		return null;
	}
	
	public void remove(K key) {
		int hashcode = hash(key.hashCode());
		
		Entry temp = entries[hashcode];
		Entry pre = null;
		while(temp != null) {
			if(temp.key.equals(key)) {
				if(pre == null) {
					entries[hashcode] = temp.next;
				}
				else {
					pre.next = temp.next;
				}
				size--;
				break;
			}
			else {
				pre = temp;
				temp = temp.next;
			}
		}
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		for(int i=0; i<entries.length; i++) {
			Entry temp = entries[i];
			
			while(temp != null) {
				sb.append(temp.key);
				sb.append(":");
				sb.append(temp.value);
				sb.append(",");
				
				temp = temp.next;
			}
		}
		if(sb.length() > 1)
			sb.deleteCharAt(sb.length()-1);
		sb.append("}");
		return sb.toString();
	}
	
	private static int hash(int hashcode) {
		return hashcode & DEFAULT_SIZE-1;
	}
	
	public static void main(String[] args) {
		MyHashMap<String, String> map = new MyHashMap<>();
		map.put("1", "a");
		map.put("2", "b");
		map.put("3", "c");
		System.out.println(map);
		System.out.println(map.get("1"));
		System.out.println(map.get("4"));
		map.remove("1");
		System.out.println(map);
		System.out.println(map.get("1"));
		
	}
	

}
