public class BST<T extends Comparable<T>>{

	private Node<T> root;

	public BST(){
		root=null;
	}

	public boolean find(T value){
		return find(root, value);
	}

	private boolean find(Node<T> root, T value){
		if (root==null)
			return false;
		if (value.compareTo(root.getData())==0)
			return true;
		if (value.compareTo(root.getData())<0)
			return find(root.left, value);
		else
			return find(root.right, value);
	}

	public void insert(T value){
		root = insert(this.root, value);
	}

	private Node<T> insert(Node<T> root, T value){
		if (root==null)
			return new Node<T>(value);
		if (value.compareTo(root.getData())<0)
			root.left= insert(root.left, value);
		else if(value.compareTo(root.getData())>0)
			root.right=insert(root.right, value);

		return root;
	}

	public void delete(T value) {
		root = delete(this.root, value);
	}

	private Node<T> delete(Node<T> root, T value) {
		if (root == null) {
			return null;
		}
		
		if (value.compareTo(root.getData()) == 0) {
			
			if (root.left == null) {
				return root.right;
			} else if (root.right == null) {
				return root.left;
			} 
			
			root.setData(findSmallestChild(root.right)); 
			delete(root.right, root.getData());
		}
		
		if (value.compareTo(root.getData()) < 0) {
			root.left = delete(root.left, value);
		} else {
			root.right = delete(root.right, value);
		}
		
		return root;
	}

	private T findSmallestChild(Node<T> root) {
		T min = root.getData();
		
		while (root.left != null) {
			if (root.left.getData().compareTo(min) < 0) {
				min = root.left.getData();
				root = root.left;
			}
		}
		
		return min;
	}

	public void print() {
		print(this.root);
	}

	private void print(Node<T> root) {
		if (root != null) {
			print(root.left);
			System.out.println(root.getData());
			print(root.right);
		}
	}
}