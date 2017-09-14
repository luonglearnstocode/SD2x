import org.junit.Test;
import static org.junit.Assert.*;

public class BinarySearchTreeTest {
	@Test
	public void testIsBalanced() {
		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
		
		bst.add(10);
		bst.add(6);
		bst.add(3);
		bst.add(11);
		
		assertTrue(bst.isBalanced());
	}
	
	@Test
	public void testIsBalanced2() {
		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
		
		bst.add(10);
		bst.add(6);
		bst.add(3);
		bst.add(2);
		bst.add(1);
		bst.add(11);
		
		assertFalse(bst.isBalanced());
	}
	
	@Test
	public void testIsBalanced3() { // balanced root 
		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
		
		bst.add(8);
		bst.add(6);
		bst.add(4);
		bst.add(2);
		bst.add(16);
		bst.add(10);
		bst.add(9);
		bst.add(12);
		bst.add(20);
		
		assertFalse(bst.isBalanced());
	}
	
	
	@Test
	public void testHeight() {
		BinarySearchTree<Integer> bst = new BinarySearchTree<>();

		bst.add(8);
		bst.add(6);
		bst.add(4);
		bst.add(2);
		bst.add(16);
		bst.add(10);
		bst.add(9);
		bst.add(12);
		bst.add(20);		
		
		assertEquals(3, bst.height(8));
		assertEquals(2, bst.height(6));
		assertEquals(1, bst.height(4));
		assertEquals(0, bst.height(2));
		assertEquals(0, bst.height(12));
	}
	
	
}
