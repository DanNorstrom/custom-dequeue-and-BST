import java.util.ArrayList;

class BTNode<T>{
	T data;
	BTNode<T> left, right;

	BTNode(T o) {
		data = o; left = right = null;
	}
}

public class BST {
	private BTNode<Integer> root;

	public BST() {
		root = null;
	}
	
	public boolean find(Integer i) {
		BTNode<Integer> n = root;
		boolean found = false;
	
		while (n!=null && !found) {
			int comp = i.compareTo(n.data);
			if (comp==0) {
				found = true;
			}
			else if (comp<0) {
				n = n.left;
			}
			else {
				n = n.right;
			}
		}
	
	    return found;
	  }

	public boolean insert(Integer i) {
		BTNode<Integer> parent = root, child = root;
		boolean goneLeft = false;

		while (child!=null && i.compareTo(child.data)!=0) {
			parent = child;
			if (i.compareTo(child.data)<0) {
				child = child.left;
				goneLeft = true;
			}
			else {
				child = child.right;
				goneLeft = false;
			}
		}

	    if (child!=null) {
	    	return false;  // number already present
	    }
	    else {
	    	BTNode<Integer> leaf = new BTNode<Integer>(i);
	    	if (parent==null) {// tree was empty
		    		root = leaf;
		    	}
		    	else if (goneLeft) {
		    		parent.left = leaf;
		    	}
		    	else {
		    		parent.right = leaf;
		    	}
	    	return true;
	    }
	}
	
	
	/* The following Helper methods use a recursive structure to Depth-first traverse BST Nodes
		- e.g: traverses Leftmost until null, then checks Rightmost on the way back */
	
	
	private int countNonLeaves = 0;
	
	//helper recursive method for nonleaves()
	private void findLeaves(BTNode<Integer> node) {	
		// No action if node is empty
	    if (node == null) {
	      return;
	    }
	    
	    // Found LeafNode
	    if (node.left == null && node.right == null) {
	    	countNonLeaves -= 1;
	    }
	    
	    findLeaves(node.left);	    
	    countNonLeaves += 1; 	// per BTNode
	    findLeaves(node.right);  
	  }
	
	public int nonleaves() {	
		BTNode<Integer> node = this.root;
		findLeaves(node); 					// updates countLeaves
		int leaveHolder = countNonLeaves;	// stores value
		countNonLeaves = 0; 				// reset countLeaves
		return leaveHolder;
	}
	
	
	private int countDepth = 1;  	// initialize at one to count Orgin node
	private int MaxDepth = 0; 
	
	// helper recursive method for depth()
	private void findDepth(BTNode<Integer> node) {
		// No action if node is empty
	    if (node == null) {
	      return;
	    }
	    
	    // Found LeafNode, check if it's the deepest BTNode
	    if (node.left == null && node.right == null) {
	    	if (countDepth > MaxDepth) MaxDepth = countDepth;
	    }
	    
	    countDepth += 1; 		// moving down, add counter
	    findDepth(node.left);
	    findDepth(node.right);
	    countDepth -= 1; 		// moving up, decrease counter
	  }
	
	public int depth() {		
		BTNode<Integer> node = this.root;
		findDepth(node); 				// updates MaxDepth
		int depthHolder = MaxDepth; 	// stores value
		MaxDepth = 0; 					// reset MaxDepth
		return depthHolder;
	}
	
	
	private ArrayList<Integer> rangeList = new ArrayList<>(); // Used to find range with .size()
	
	// helper recursive method for range()
	private void findRange(BTNode<Integer> node, int min, int max) {
		// No action if node is empty
	    if (node == null) {
	      return;
	    }
	    	    
	    findRange(node.left, min, max);
	    // action per node:
	    if (node.data >= min && node.data <= max) rangeList.add(node.data);
	    findRange(node.right, min, max);
	  }
	
	public int range(int min, int max) {
		if (min > max) throw new IllegalArgumentException("Min cannot be higher then Max");
		else {
			BTNode<Integer> node = this.root;
			findRange(node,min,max);
			ArrayList<Integer> rangeHolder = rangeList;
			rangeList = new ArrayList<>();
			return rangeHolder.size();
		}
	}
}