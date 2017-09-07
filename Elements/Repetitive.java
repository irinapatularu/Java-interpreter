package Elements;

import homeworkPP.Context;
import homeworkPP.Visitor;

public class Repetitive extends Node{

	public Repetitive(String content) {
		super(content);
	}

	public Repetitive(Node left, Node right, String content) {
		super(left, right, content);
	}

	/**
	 * @param c - reprezinta contextul in care se lucreaza(mai exact
	 * ce variabile sunt in scope la acel moment si valorile lor)
	 * Initial se evalueaza conditia pentru while(din subarborele stang).
	 * Cat timp aceasta conditie este indeplinita se evalueaza subarborele
	 * drept(care este un program si va realiza anumite modificari asupra variabilelor)
	 * dupa care se reevalueaza conditia pentru while din subarborele stang.
	 */
	@Override
	public int evaluate(Context c) {
		int res = this.left.evaluate(c);
		while(res == 1){
			this.right.evaluate(c);
			res = this.left.evaluate(c);
		}
		return 0;
	}

	@Override
	public void accept(Visitor v, Context c) {
		v.visit(this, c);
	}
}
