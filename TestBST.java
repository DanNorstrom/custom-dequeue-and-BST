
public class TestBST {
	
	
	public static void main(String[] args) throws Exception {
		
		// nonLeaves() test on filled (int)
		BST treeHouse = new BST();
		treeHouse.insert(50);
		for (int i=1; i<11; i++) {
			treeHouse.insert(i*10);
		}
		
		System.out.println("Looking for 8 None-LeafNodes: "+treeHouse.nonleaves());
		
		// depth() test on filled (int)
		System.out.println("Looking for 6 MaxDepth: "+treeHouse.depth());
		
		// nonLeaves() test on empty (0)
		BST treeEmpty = new BST();
		System.out.println("Empty BST should be 0: "+treeEmpty.nonleaves());
		
		// range() test on filled (int)
		System.out.println("Nodes between <40,70> should be 4: "+treeHouse.range(40,70));
		
		// range() illigal min max
		Thread.sleep(1);
		treeHouse.range(1,0);
	}
}
