package lists;

import java.util.Iterator;


public class SinglyLinkedList<E> implements Iterable<E> { 

	private class Node<T> { 
		T data; 
		Node<T> next; 

		private Node(T data) { 
			this.data = data;
			this.next = null; 
		}

		@Override 
		public String toString() { 

			return data.toString(); 
		}
	}

	private Node<E> head; 
	private int size; 

	public SinglyLinkedList() { 
		this.head = null; 
	}

	public void add(E data) { 
		if (this.head == null) { 
			this.head = new Node<E>(data); 
			
		} else { 
			Node<E> curr = head; 
			while(curr.next != null) { 
				curr = curr.next;
			}
			curr.next = new Node<E>(data); 
		}
		this.size++; 
	}
	
	public boolean remove(E data) {
		if (head.data.equals(data)) { 
			this.head = this.head.next; 
			
		} else { 
			Node<E> curr = this.head; 
			while(curr != null) { 
				if (curr.next.data.equals(data)) { 
					curr.next = curr.next.next; 
					
					return true;
				}
			}
		}
		
		return false; 
	}	
	
	public E get(int index) { 
		E retval = null; 
		if (index > this.size - 1 || index < 0) { 
			throw new IllegalArgumentException("Index out of range"); 
		}
		int i = 0; 
		for(E e: this) { 
			if (i == index) {
				retval = e; 
				break; 
			}
			i++; 
		}
		
		return retval; 
	}

	public int size() { 

		return this.size; 
	}

	public Iterator<E> iterator() {
		return new Iterator<E>() {
			Node<E> curr = SinglyLinkedList.this.head; 
			E data; 

			@Override
			public boolean hasNext() {
				return curr != null;
			}

			@Override
			public E next() {
				data = curr.data; 
				curr = curr.next; 

				return data;
			} 
		};
	}

	@Override
	public String toString() { 
		Iterator<E> iter = this.iterator(); 
		String retval = "("; 
		while(iter.hasNext()) { 
			retval += iter.next(); 
			if (iter.hasNext()) retval += ", "; 
		}
		retval += ")"; 
		return retval; 
	}

	public static void main(String[] args) { 
		SinglyLinkedList<Integer> l = new SinglyLinkedList<>(); 
		for(int i = 0; i < 10; i++) { 
			Integer k = i; 
			l.add(k); 
		}
		System.out.println(l);
	}
}