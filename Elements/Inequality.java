package Elements;

import homeworkPP.Context;
import homeworkPP.Visitor;

public class Inequality extends Node {

	public Inequality(String content) {
		super(content);
	}

	public Inequality(Node left, Node right, String content) {
		super(left, right, content);
	}

	/**
	 * @param c - reprezinta contextul in care se lucreaza(mai exact
	 * ce variabile sunt in scope la acel moment si valorile lor)
	 * Se evalueaza subarborele stang respectiv cel drept dupa
	 * care se compara si se returneaza valoarea obtinuta in urma
	 * compararii, 0 sau 1.
	 */
	@Override
	public int evaluate(Context c) {
		int res1, res2;
		res1 = this.left.evaluate(c);
		res2 = this.right.evaluate(c);

		if(res1 < res2)
			return 1;
		return 0;
	}

	@Override
	public void accept(Visitor v, Context c) {
		v.visit(this, c);
	}
}
