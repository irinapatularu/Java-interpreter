package Elements;
import homeworkPP.*;

public abstract class Node implements Elem {
	public Node left, right;
	public String content;
	
	//constructor pentru frunza
	public Node(String content){
		this.content = content;
		left = null;
		right = null;
	}
	
	//constructor pentru un nod intern(cand se cunosc fiii)
	public Node(Node left, Node right, String content){
		this.left = left;
		this.right = right;
		this.content = content;
	}
	
	@Override
	public String toString(){
		return content;
	}
	
	public Boolean equals(String s){
		return s.equals(this.content);
	}	
}