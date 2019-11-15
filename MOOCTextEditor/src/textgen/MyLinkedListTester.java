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
		
		// 21, 42, 500
				int b = list1.remove(1);
				assertEquals("Remove: check b is correct ", 42, b);
				assertEquals("Remove: check element 0 is correct ", (Integer) 21, list1.get(0));
				assertEquals("Remove: check size is correct ", 2, list1.size());

				list1.add(3000);
				// 21, 500, 3000;
				int c = list1.remove(2);
				assertEquals("Remove: check c is correct ", 3000, c);
				assertEquals("Remove: check element 1 is correct ", (Integer) 500, list1.get(1));
				assertEquals("Remove: check size is correct ", 2, list1.size());
				
				try {
					list1.remove(45);
					fail("Check out of bounds");
				} catch (IndexOutOfBoundsException e) {
				}
				
				try {
					list1.remove(-1);
					fail("Check out of bounds");
				} catch (IndexOutOfBoundsException e) {
				}
				
				try {
					lst.remove(0);
					fail("Check out of bounds");
				} catch (IndexOutOfBoundsException e) {
				}

			}
		// TODO: Add more tests here
	}
	
	/** Test adding an element into the end of the list, specifically
	 *  public boolean add(E element)
	 * */
	@Test
	public void testAddEnd()
	{
        // TODO: implement this test
		endList = new MyLinkedList<Integer>();
		endList.add(30);
		assertEquals("Add 30", (Integer) 30, endList.get(0));
		endList.add(50);
		assertEquals("Add 50", (Integer) 50, endList.get(1));
		try {
			endList.add(null);
			fail("Check null");
		} catch (NullPointerException e) {

		}
		
	}

	
	/** Test the size of the list */
	@Test
	public void testSize()
	{
		// TODO: implement this test
		int shortListSize = shortList.size();
		assertEquals("Short list size is correct ", 2, shortListSize);
		assertEquals("Empty list size is correct ", 0, lst.size());
	}

	
	
	/** Test adding an element into the list at a specified index,
	 * specifically:
	 * public void add(int index, E element)
	 * */
	@Test
	public void testAddAtIndex()
	{
        // TODO: implement this test
		indexList = new MyLinkedList<Integer>();
		indexList.add(30);
		indexList.add(50);
		indexList.add(70);
		indexList.add(1, 31);
		indexList.add(2, 32);
		assertEquals("Add 31", (Integer) 31, indexList.get(1));
		assertEquals("Add 32", (Integer) 32, indexList.get(2));
		indexList.add(0, 1);
		assertEquals("Add 1 to index 0", (Integer) 1, indexList.get(0));
		indexList.add(6, 500);
		assertEquals("Add 500 to end of list", (Integer) 500, indexList.get(6));
		try {
			indexList.add(-1, -100);
			fail("Check invalid index");
		} catch (IndexOutOfBoundsException e) {

		}
		
		try {
			indexList.add(30000, 20);
			fail("Check invalid index");
		} catch (IndexOutOfBoundsException e) {

		}
		
	}
	
	/** Test setting an element in the list */
	@Test
	public void testSet()
	{
	    // TODO: implement this test
		list1.set(1, 123);
		// 21, 500, 3000;
		assertEquals("Set index 1 to 123 is correct ", (Integer) 123, list1.get(1));
		try {
			list1.set(20, 200);
			fail("Check invalid index");
		} catch (IndexOutOfBoundsException e) {

		}
		
		try {
			endList.set(2, null);
			fail("Check null");
		} catch (NullPointerException e) {

		}
	    
	}
	
	
	// TODO: Optionally add more test methods.
	
}
