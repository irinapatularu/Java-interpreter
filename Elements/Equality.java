package Elements;

import homeworkPP.Context;
import homeworkPP.Visitor;

public class Equality extends Node{

	public Equality(String content) {
		super(content);
	}

	public Equality(Node left, Node right, String content) {
		super(left, right, content);
	}

	/**
	 * @param c - reprezinta contextul in care se lucreaza(mai exact
	 * ce variabile sunt in scope la acel moment si valorile lor)
	 * Se evalueaza atat subarborele stang cat si cel drept si se
	 * verifica egalitatea intre cele 2 valori, afisandu-se 1 in caz
	 * de egalitate si 0 in caz contrar.
	 */
	@Override
	public int evaluate(Context c) {
		int res1, res2;
		res1 = this.left.evaluate(c);
		res2 = this.right.evaluate(c);
		if(res1 == res2)
			return 1;
		return 0;
	}

	@Override
	public void accept(Visitor v, Context c) {
		v.visit(this, c);
	}	
}