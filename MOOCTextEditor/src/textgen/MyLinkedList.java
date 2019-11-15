package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		size = 0;
		head = new LLNode<E>(null);
		tail = new LLNode<E>(null);

		// Link the head and tail nodes properly together
		head.next = tail;
		tail.prev = head;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		// TODO: Implement this method
		if (element == null)
			throw new NullPointerException("Element added cannot be null");

		LLNode<E> newElement = new LLNode<E>(element);
		LLNode<E> last = tail.prev; // last -> tail
		
		// last <-> newElement <-> tail
		newElement.next = tail; // newElement -> tail
		newElement.prev = last; // last <- newElement
		tail.prev = newElement; // newElement <- tail
		last.next = newElement; // last -> newElement
		
		// If this is the first element, update the head to point to the new element
		// Note: the data in the tail is always null.
		if (size == 0) {
			head = newElement;
		}
		
		size++;
		return true;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		// TODO: Implement this method.
		if (index >= size || index < 0 || size <= 0) {
			throw new IndexOutOfBoundsException("Element out of bounds of LinkedList.");
		}

		LLNode<E> current = head;
		for (int i = 0; i < index; i++) {
			current = current.next;
		}
		return current.data;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
		if (index > size || index < 0)
			throw new IndexOutOfBoundsException("Invalid index.");
		if (element == null)
			throw new NullPointerException("Element added cannot be null.");

		// Special case: index is the size of the list. Add to the end.
		if (index == size) {
			this.add(element);
			return;
		}

		LLNode<E> newElement = new LLNode<E>(element);
		LLNode<E> current = head;
		for (int i = 0; i <= index; i++) {
			// add the element before the current node
			if (i == index) {
				newElement.next = current;
				newElement.prev = current.prev;

				// update the current's previous to point to the new element
				// make sure the current's previous is not null (only happens if
				// adding the first element to the list)
				if (current.prev != null) {
					current.prev.next = newElement;
					current.prev = newElement;
				}
				size++;
			}
			current = current.next;
		}

		if (index == 0) {
			head = newElement;
		}
	
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return this.size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		// TODO: Implement this method
		LLNode<E> node = this.head;
		while (node.next != null) {
			System.out.println(node);
			node = node.next;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		// TODO: Implement this method
		if (index < 0 || index >= this.size) {
			throw new IndexOutOfBoundsException("Index outside of the bounds of the list");
		}

		E removedElement = get(index);

		// removing the head 
		if (index == 0) {
			if (head.next.next != null) {
				head = head.next;
				head.prev = null;
			} 
			// In case the list has a single element, just clear the head node's data to remove it.
			else {
				head.data = null; // clear data
			}
			size--;
			return removedElement;
		}

		// removing the tail
		if (index == size - 1) {
			// new last node is the second last node
			LLNode<E> newLast = tail.prev.prev;
			newLast.next = tail;
			tail.prev = newLast;
			size--;
			return removedElement;
		}

		// removing any other node between head and tail
		LLNode<E> current = head;
		for (int i = 0; i <= index; i++) {
			if (i == index) {
				current.prev.next = current.next;
				current.next.prev = current.prev;
				size--;
			}
			current = current.next;
		}

		return removedElement;
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}

}
