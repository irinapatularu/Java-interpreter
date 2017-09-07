package Elements;

import homeworkPP.Context;
import homeworkPP.Visitor;

public class Variable extends Node {

	public Variable(String content) {
		super(content);
	}

	/**
	 * @param c - reprezinta contextul in care se lucreaza(mai exact
	 * ce variabile sunt in scope la acel moment si valorile lor)
	 * Se va returna valoarea variabilei exact cum este ea data de context.
	 */
	@Override
	public int evaluate(Context c) {
		return c.valueOf(this.content);
	}

	@Override
	public void accept(Visitor v, Context c) {
		v.visit(this, c);
	}
}
