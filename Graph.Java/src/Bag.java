//------------------------------------------------------------------------------------------------------------------------------------
// Title: Bag class
// Author: Hüseyin Ufuk Yýlmaz
// ID: 21826286904
// Section: 02
// Assignment: 1
// Description: This class is similar with stack (Generally same function).
//-------------------------------------------------------------------------------------------------------------------------------------
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Bag<Item> implements Iterable<Item> {
	public Node<Item> first;
	public int size;

	public Bag() {
		first = null;
		size = 0;
	}

	public boolean isEmpty() 
	     //--------------------------------------------------------
	 	 // Summary: checking first node
		 // Precondition: -
		 // Postcondition: checked first node
		 //--------------------------------------------------------
	{  
		return first == null;
	}

	public int size() 
	//--------------------------------------------------------
		 // Summary: it returns size of node
		 // Precondition: varName is a char and varValue is an
		 // integer
		 // Postcondition: returned size of node.
		 //--------------------------------------------------------
	{                                                                              // This class is a similar with linked list but there is no remove operation.
		return size;                                                               // Also this class implements the iterable interface to can iterate in array which is created in graph class.
	}                                                                              //This class has LinkedIterator class and implements the iterator interface.

	public void add(Item item) 
	  //--------------------------------------------------------
	  // Summary: Adding item into the node
	  // Precondition: item is a generic type.
	  // Postcondition: Added item into the node
	  //--------------------------------------------------------
	{  

		Node<Item> current = first;
		first = new Node<Item>();
		first.item = item;
		first.next = current;
		size++;
	}

	public Iterator<Item> iterator()
	//--------------------------------------------------------
	  // Summary:calls LinkedIterator class.
	  // Precondition: -
	  // Postcondition: called LinkedIterator class.
	  //--------------------------------------------------------
	{
		return new LinkedIterator(first);
	}

	public class LinkedIterator implements Iterator<Item> {
		public Node<Item> current;

		public LinkedIterator(Node<Item> first) {
			current = first;
		}

		public boolean hasNext() 
		//--------------------------------------------------------
		  // Summary:checking next node
		  // Precondition: -
		  // Postcondition: checked next node
		  //--------------------------------------------------------
		{
			return current != null;
		}

		public void remove() 
		//--------------------------------------------------------
		  // Summary:prevents to remove operation.
		  // Precondition: -
		  // Postcondition: prevents to remove operation.
		  //--------------------------------------------------------
		{
			throw new UnsupportedOperationException();
		}

		public Item next() 
		 //--------------------------------------------------------
		  // Summary: provides to go next node
		  // Precondition: -
		  // Postcondition: provided to go next node
		  //--------------------------------------------------------
		{
			if (!hasNext())
				throw new NoSuchElementException();
			Item item = current.item;
			current = current.next;
			return item;
		}
	}
}
