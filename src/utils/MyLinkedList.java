package utils;

class Node<E> {
	E element;
	Node<E> pre;
	Node<E> next;
	
	public Node(E element) {
		this.element = element;
	}
}

public class MyLinkedList<E> {
	private Node<E> first;
	private Node<E> last;
	private int size;
	
	public MyLinkedList() {
	}
	
	public int size() {
		return this.size;
	}
	
	public void addHead(Node<E> oldHead, Node<E> node) {
		node.next = oldHead;
		oldHead.pre = node;
	}
	
	public void addTail(Node<E> oldTail, Node<E> node) {
		oldTail.next = node;
		node.pre = oldTail;
	}
	
	public void add(E element) {
		Node<E> newNode = new Node<>(element);
		if (first == null) {
			first = newNode;
			last = newNode;
		}
		else {
			last.next = newNode;
			newNode.pre = last;
			last = newNode;
		}
		size++;
	}
	
	public void add(int index, E element) {
		if (index<0 || index>size)
			throw new ArrayIndexOutOfBoundsException();
		
		if (index==size)
			add(element);
		else {
			Node<E> newNode = new Node<>(element);
			
			Node<E> temp = first;
			for(int i=index; i>0; i--) {
				if (temp == null) {
					throw new ArrayIndexOutOfBoundsException();
				}
				temp = temp.next;
			}
			if(temp != first) {
				addTail(temp.pre, newNode);

			}
			else {
				first = newNode;
			}
			addHead(temp, newNode);
			size++;
		}
		
	}
	
	public void delete(E element) {
		Node<E> temp = first;
		
		if(size == 1) {
			first = null;
			last = null;
		}
		else {
			while(temp != null) {
				if(temp.element.equals(element)) {
					if(temp == first) {
						first = first.next;
						first.pre = null;
					}
					else if(temp == last) {
						last = last.pre;
						last.next = null;
					}
					else {
						temp.pre.next = temp.next;
						temp.next.pre = temp.pre;
					}
				}
				temp = temp.next;
			}
		}
		size--;
	}
	
	public void delete(int index) {
		if (index < -1 || index >= size)
			throw new ArrayIndexOutOfBoundsException();
		
		Node<E> temp = first;
		for(int i=0; i<index; i++) {
			temp = temp.next;
		}
		
		if(temp == first) {
			first = first.next;
			first.pre = null;
		}
		else if(temp == last) {
			last = last.pre;
			last.next = null;
		}
		else {
			temp.pre.next = temp.next;
			temp.next.pre = temp.pre;
		}
		size--;
	}
	
	public E get(int index) {
		if (index < -1 || index >= size)
			throw new ArrayIndexOutOfBoundsException();
		
		Node<E> temp = first;
		for(int i=index; i>0; i--) {
			temp=temp.next;
		}
		return temp.element;
	}
	
	public boolean contains(E element) {
		Node<E> temp = first;
		for (int i=0; i<size; i++) {
			if ((temp.element).equals(element))
				return true;
			temp = temp.next;
		}
		return false;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		
		Node<E> temp = first;
		for (int i=0; i<size; i++) {
			sb.append((temp.element).toString());
			temp = temp.next;
			if (i < size-1) 
				sb.append(", ");
		}
		sb.append("]");
		
		return sb.toString();
	}

	public static void main(String[] args) {
		MyLinkedList<String> myList = new MyLinkedList<>();
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
