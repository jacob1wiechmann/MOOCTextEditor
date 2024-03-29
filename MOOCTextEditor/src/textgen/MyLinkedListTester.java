/**
 * 
 */
package textgen;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

/**
 * @author UC San Diego MOOC team
 *
 */
public class MyLinkedListTester {

	private static final int LONG_LIST_LENGTH =10; 

	MyLinkedList<String> shortList;
	MyLinkedList<Integer> emptyList;
	MyLinkedList<Integer> longerList;
	MyLinkedList<Integer> list1;
	MyLinkedList<Integer> endList;
	MyLinkedList<Integer> indexList;
	MyLinkedList<Integer> lst;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Feel free to use these lists, or add your own
	    shortList = new MyLinkedList<String>();
		shortList.add("A");
		shortList.add("B");
		emptyList = new MyLinkedList<Integer>();
		longerList = new MyLinkedList<Integer>();
		for (int i = 0; i < LONG_LIST_LENGTH; i++)
		{
			longerList.add(i);
		}
		list1 = new MyLinkedList<Integer>();
		list1.add(65);
		list1.add(21);
		list1.add(42);
		
	}

	
	/** Test if the get method is working correctly.
	 */
	/*You should not need to add much to this method.
	 * We provide it as an example of a thorough test. */
	@Test
	public void testGet()
	{
		//test empty list, get should throw an exception
		try {
			emptyList.get(0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		// test short list, first contents, then out of bounds
		assertEquals("Check first", "A", shortList.get(0));
		assertEquals("Check second", "B", shortList.get(1));
		
		try {
			shortList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			shortList.get(2);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		// test longer list contents
		for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
			assertEquals("Check "+i+ " element", (Integer)i, longerList.get(i));
		}
		
		// test off the end of the longer array
		try {
			longerList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			longerList.get(LONG_LIST_LENGTH);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		
	}
	
	
	/** Test removing an element from the list.
	 * We've included the example from the concept challenge.
	 * You will want to add more tests.  */
	@Test
	public void testRemove()
	{
		int a = list1.remove(0);
		assertEquals("Remove: check a is correct ", 65, a);
		assertEquals("Remove: check element 0 is correct ", (Integer)21, list1.get(0));
		assertEquals("Remove: check size is correct ", 2, list1.size());
		
		int b = list1.remove(1);
		assertEquals("Remove: check b is correct ", 42, b);
		assertEquals("Remove: check element 0 is correct ", (Integer)21, list1.get(0));
		assertEquals("Remove: check size is correct ", 1, list1.size());
		
		try{
			list1.remove(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e){
		}
		
		try{
			list1.remove(2);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e){
		}
	}
		// TODO: Add more tests here
	
	
	/** Test adding an element into the end of the list, specifically
	 *  public boolean add(E element)
	 * */
	@Test
	public void testAddEnd()
	{
		list1.add(21);
		assertEquals("Add: Check whether element is added", (Integer)21, list1.get(3));
		assertEquals("Add: Check whether the element 0 is correct", (Integer)65, list1.get(0));
		assertEquals("Add: Check whether the size is correct", 4, list1.size());
		
	}

	
	/** Test the size of the list */
	@Test
	public void testSize()
	{
		list1.add(21);
		assertEquals("Add: Check whether the size is correct", 4, list1.size());
	}

	
	
	/** Test adding an element into the list at a specified index,
	 * specifically:
	 * public void add(int index, E element)
	 * */
	@Test
	public void testAddAtIndex()
	{
		list1.add(1, 32);
		assertEquals("Add: Check whether element is added", (Integer)32, list1.get(1));
		assertEquals("Add: Check whether the element 0 is correct", (Integer)65, list1.get(0));
		assertEquals("Add: Check whether the element 2 is correct", (Integer)21, list1.get(2));
		assertEquals("Add: Check whether the size is correct", 4, list1.size());
		
		list1.add(100);
		assertEquals("Add: Adding to the end of a list", (Integer)100, list1.get(4));
		assertEquals("Add: Check whether the size is correct", 5, list1.size());
		
		try{
			list1.add(-1, 20);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e){
		}
		
		try{
			list1.add(6, 67);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e){
		}
		
		try{
			list1.add(5, null);
			fail("Check for adding a null element");
		}
		catch (NullPointerException e){
		}
	}
	
	/** Test setting an element in the list */
	@Test
	public void testSet()
	{
	    shortList.set(1, "C");
	    assertEquals("Set: Check whether the set method works", "C", shortList.get(1));
	    
	    try {
			shortList.set(-1, "A");
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			shortList.set(2, "R");
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		
		try{
			shortList.set(1, null);
			fail("Check for setting a null element");
		}
		catch (NullPointerException e){
		}
	    
	    
	    list1.set(1, 100);
	    assertEquals("Set: Check whether the set method works", (Integer)100, list1.get(1));
	    assertEquals("Set: Check whether other elements are changed", (Integer)65, list1.get(0));
	    assertEquals("Set: Check whether other elements are changed", (Integer)42, list1.get(2));
	}	
}
	
	
	// TODO: Optionally add more test methods.
	

