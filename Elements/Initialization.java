package Elements;

import homeworkPP.Context;
import homeworkPP.Visitor;

public class Initialization extends Node{

	public Initialization(String content){
		super(content);
	}
	public Initialization(Node left, Node right, String content) {
		super(left, right, content);
	}

	/**
	 * @param c - reprezinta contextul in care se lucreaza(mai exact
	 * ce variabile sunt in scope la acel moment si valorile lor)
	 * In momentul intalnirii semnului "=" este clar ca in partea stanga
	 * se afla numele unei variabile ce urmeaza a se initializa iar in dreapta
	 * o expresie ce va da valoarea. Se evalueaza subarborele drept dupa care
	 * variabila din dreapta se adauga la context impreuna cu valoarea
	 * corespunzatoare.
	 */
	@Override
	public int evaluate(Context c) {
		int res = this.right.evaluate(c);
		c.add(this.left.content, res);
		return 0;
	}

	@Override
	public void accept(Visitor v, Context c) {
		v.visit(this, c);
	}

}
