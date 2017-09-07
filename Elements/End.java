package Elements;

import homeworkPP.Context;
import homeworkPP.Visitor;

public class End extends Node{

	public End(Node left, Node right, String content) {
		super(left, right, content);
	}

	public End(String content) {
		super(content);
	}

	/**
	 * @param c - reprezinta contextul in care se lucreaza(mai exact
	 * ce variabile sunt in scope la acel moment si valorile lor)
	 * Se evalueaza partea stanga fara a se retine valoarea returnata
	 * si se evalueaza apoi si partea dreapta al carei rezultate se returneaza
	 * deoarece in drepta va exista mereu return-ul unui program
	 */
	@Override
	public int evaluate(Context c){
		this.left.evaluate(c);
		return this.right.evaluate(c);
	}

	@Override
	public void accept(Visitor v, Context c) {
		v.visit(this, c);
	}
}
