public class Node<T extends Comparable<T>>{

	private T data;
	public Node<T> left;
	public Node<T> right;

	public Node(T data){
		this.data=data;
		this.left=null;
		this.right=null;
	}

	public T getData(){
		return this.data;
	}

	public void setData(T val){
		this.data=val;
	}

	
}