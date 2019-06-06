package utils;

import java.lang.ArrayIndexOutOfBoundsException;

public class MyArrayList<E> {
	
	private static final int DEFAULT_CAPACITY = 10;
	private Object[] elements;
	private int size;
	
	public MyArrayList() {
		this.size = 0;
		elements = new Object[DEFAULT_CAPACITY];
	}
	
	public int size() {
		return this.size;
	}
	
	public void add(E element) {
		if (size >= elements.length) {
			Object[] temp = new Object[elements.length + (elements.length >> 1)];
			System.arraycopy(elements, 0, temp, 0, elements.length);
			elements = temp;
		}
		elements[size++] = element;
	}
	
	public void add(int index, E element) {
		if (index < -1 || index > size)
			throw new ArrayIndexOutOfBoundsException();
		
		Object[] temp = null;
		if (size >= elements.length) 
			temp = new Object[elements.length + (elements.length >> 1)];
		else
			temp = new Object[elements.length];
		System.arraycopy(elements, 0, temp, 0, index);
		temp[index] = element;
		System.arraycopy(elements, index, temp, index+1, size-index);
		size++;
		elements = temp;
	}
	
	public void delete(E element) {
		for (int i=0; i<size-1; i++) {
			if (elements[i].equals(element)){
				delete(i);
			}
		}
	}
	
	public void delete(int index) {
		if (index < -1 || index > size)
			throw new ArrayIndexOutOfBoundsException();
		System.arraycopy(elements, index+1, elements, index, elements.length-index-1);
		elements[--size] = null;
	}
	
	@SuppressWarnings("unchecked")
	public E get(int index) {
		if (index < -1 || index > size)
			throw new ArrayIndexOutOfBoundsException();
		
		return (E)elements[index];
	}
	
	@SuppressWarnings("unchecked")
	public boolean contains(E element) {
		for (int i=0; i<size; i++) {
			if (((E)elements[i]).equals(element))
				return true;
		}
		return false;
	}
	
	@SuppressWarnings("unchecked")
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (int i=0; i<size; i++) {
			sb.append((E)elements[i].toString());
			
			if (i < size-1) 
				sb.append(", ");
		}
		sb.append("]");
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		MyArrayList<String> myList = new MyArrayList<>();
		myList.add("a");
		myList.add("b");
		myList.add("c");
		System.out.println(myList.size());
		System.out.println(myList);
		myList.add(0, "c");
		System.out.println(myList);
		myList.add(1, "d");
		System.out.println(myList);
		myList.add(myList.size(), "e");
		System.out.println(myList);
		myList.delete("d");
		System.out.println(myList);
		myList.delete(0);
		System.out.println(myList);
		myList.delete(myList.size()-1);
		System.out.println(myList);
		System.out.println(myList.contains("a"));
	}
	
	
	
}
