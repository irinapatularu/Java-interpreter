package Elements;

import homeworkPP.Context;
import homeworkPP.Visitor;

public class Value extends Node{

	public Value(String content) {
		super(content);
	}

	/**
	 * @param c - reprezinta contextul in care se lucreaza(mai exact
	 * ce variabile sunt in scope la acel moment si valorile lor)
	 * Se va returna efectiv valoarea ca Integer.
	 */
	@Override
	public int evaluate(Context c) {
		int i = Integer.parseInt(content);
		return i;
	}

	@Override
	public void accept(Visitor v, Context c) {
		v.visit(this, c);

	}
}
