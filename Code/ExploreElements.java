package homeworkPP;

import Elements.*;

public class ExploreElements implements Visitor{

	/**
	 * Va spune daca programul este invalid din cauza nerespectarii
	 * scope-ului unei variabile.
	 */
	Integer invalid = 0;
	
	/**
	 * Va spune daca programul este invalid din cauza lipsei de return
	 * la finalul programului.
	 */
	Integer ret = 0;

	/**
	 * 
	 * @param root - radacina arborelui ce contine programul.
	 * @return - daca programul este valid sau nu. Se creeaza un context,
	 * cel global, si se porneste vizitarea nodurilor arborelui.
	 */
	public Boolean check(Node root){
		Context c = new Context();
		root.accept(this, c);
		if(invalid == 0 && ret != 1)
			invalid = 1;
		
		if(invalid == 0)
			return true;
		return false;
	}

	/**
	 * 
	 * @param n - nodul curent 
	 * @param c - reprezinta contextul in care se lucreaza(mai exact
	 * ce variabile sunt in scope la acel moment si valorile lor)
	 * Se viziteaza subarborele stang si drept atat timp cat el exista.
	 */
	public void explore(Node n, Context c){
		if(n.left != null)
			n.left.accept(this, c);
		if(n.right != null)
			n.right.accept(this, c);
	}

	@Override
	public void visit(Value v, Context c){
		explore(v, c);
	}

	/**
	 * Daca vizitam o variabila trebuie sa verificam daca ea are asignata
	 * o valoare in contextul curent. Daca nu, atunci programul este invalid
	 * (variabila nu este in scope).
	 */
	@Override
	public void visit(Variable v, Context c){
		if(c.valueOf(v.content) == null)
			invalid = 1;
	}

	@Override
	public void visit(Addition op, Context c){
		explore(op, c);
	}

	@Override
	public void visit(Multiplication op, Context c){
		explore(op, c);
	}

	@Override
	public void visit(Equality op, Context c){
		explore(op, c);
	}

	@Override
	public void visit(Inequality op, Context c){
		explore(op, c);
	}

	/**
	 * Atunci cand se intalneste semnul "=" este clar ca in nodul
	 * stang se afla o variabila ce urmeaza a fi declarata. Se viziteaza
	 * subarborele drept pentru a vedea daca depinde de variabile din context
	 * (xistente deja), dupa care se adauga noua variabila in context(valoarea
	 * cu care se adauga este neimportanta asa ca s-a adaugat cu valoarea 0).
	 */
	@Override
	public void visit(Initialization i, Context c){
		i.right.accept(this, c);
		c.add(i.left.content, 0);
	}

	/**
	 * Daca s-a intalnit o instructiune if se creeaza mai intai un nou context
	 * pentru acesta; noul context, local, se va obtine din cel anterior la care 
	 * ii adaugam noi variabile pe parcursul executarii instructiunii. Se continua
	 * explorarea spatiului cu noul context, cel local.
	 */
	@Override
	public void visit(IfClause i, Context c){
		Context cLocal = new Context();
		cLocal = c.makeCopy(c);
		explore(i, cLocal);
	}

	@Override
	public void visit(End e, Context c){
		explore(e, c);
	}

	/**
	 * Daca s-a intalnit o instructiune while se creeaza mai intai un nou context
	 * pentru acesta; noul context, local, se va obtine din cel anterior la care 
	 * ii adaugam noi variabile pe parcursul executarii instructiunii. Se continua
	 * explorarea spatiului cu noul context, cel local.
	 */
	@Override
	public void visit(Repetitive r, Context c){
		Context cLocal = new Context();
		cLocal = c.makeCopy(c);
		explore(r, cLocal);
	}

	/**
	 * Cand am intalnit return marcam acest lucru si trecem mai departe la vizitarea
	 * nodurilor.
	 */
	@Override
	public void visit(Return r, Context c) {
		ret ++;
		r.left.accept(this, c);
	}
}