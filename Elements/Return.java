package Elements;

import homeworkPP.Context;
import homeworkPP.Visitor;

public class Return extends Node{

	public Return(String content) {
		super(content);
	}

	public Return(Node left, Node right, String content){
		super(left, right, content);
	}
	
	/**
	 * @param c - reprezinta contextul in care se lucreaza(mai exact
	 * ce variabile sunt in scope la acel moment si valorile lor)
	 * Se evalueaza expresia din subarborele stang si se va returna.
	 */
	@Override
	public int evaluate(Context c) {
		int res = this.left.evaluate(c);
		return res;
	}

	@Override
	public void accept(Visitor v, Context c) {
		v.visit(this, c);
	}
}
