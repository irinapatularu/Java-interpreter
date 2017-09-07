package Elements;
import homeworkPP.Context;
import homeworkPP.Visitor;

public class Addition extends Node {

	public Addition(String content) {
		super(content);
	}

	public Addition(Node left, Node right, String content) {
		super(left, right, content);
	}

	/**
	 * @param c - reprezinta contextul in care se lucreaza(mai exact
	 * ce variabile sunt in scope la acel moment si valorile lor)
	 * Returneaza suma obtinuta intre rezultatul evaluarii subarborelui
	 * drept si a celui stang.
	 */
	@Override
	public int evaluate(Context c) {
		int res1, res2;
		res1 = this.left.evaluate(c);
		res2 = this.right.evaluate(c);
		return res1 + res2;
	}

	@Override
	public void accept(Visitor v, Context c) {
		v.visit(this, c);
	}
}
