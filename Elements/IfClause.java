package Elements;

import homeworkPP.Context;
import homeworkPP.Visitor;

public class IfClause extends Node {

	public IfClause(String content){
		super(content);
	}
	public IfClause(Node left, Node right, String content) {
		super(left, right, content);
	}

	/**
	 * @param c - reprezinta contextul in care se lucreaza(mai exact
	 * ce variabile sunt in scope la acel moment si valorile lor)
	 * Se evalueaza subarborele stang ce contine conditia pentru if;
	 * daca este adevarata atunci din nodul drept(ce contine optiunea
	 * "choose") se contiuna evaluarea pe subarborele stang, altfel, pe 
	 * cel drept.
	 */
	@Override
	public int evaluate(Context c) {
		int cond = this.left.evaluate(c);
		if(cond == 1)
			return this.right.left.evaluate(c);
		else
			return this.right.right.evaluate(c);
	}

	@Override
	public void accept(Visitor v, Context c) {
		v.visit(this, c);
	}
}
