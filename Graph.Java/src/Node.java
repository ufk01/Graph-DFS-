//-------------------------------------------------------------------------------------
// Title: Node class
// Author: Hüseyin Ufuk Yýlmaz
// ID: 21826286904
// Section: 02
// Assignment: 1
// Description: This class provides to hold data and next method for other classes with using generic. 
//--------------------------------------------------------------------------------------
public class Node<Item> {
	public Item item;
	public Node<Item> next;

	public Node() {        // Constructor of Node class
		this.item = null;
	}

}
