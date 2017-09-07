package homeworkPP;
import Elements.*;

public class Tree {
	Node root;
	String prefix;
	
	public Tree(String prefix){
		this.prefix = prefix;
	}
	
	/**
	 * 
	 * @param str - numarul ca tip String
	 * @return - daca stringul trimis este nu numar sau altceva.
	 */
	private static boolean isNumeric(String str) {
	    try {
	        double d = Double.parseDouble(str);
	    } catch(NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}
	
	public Node construct(){
		root = createTree(prefix);
		return root;
	}
	
	/**
	 * 
	 * @param s - expresia/programul folosit pentru construirea arborelui
	 * @return - radacina arborelui creat
	 * Se parseaza Stringul si pentru fiecare element se va creea un nod corespunzator.
	 * Regula generala este ca se reapela functia de constructie pentru ce va fi in stanga
	 * apoi pentru dreapta. La final, se va creea nodul curent care ii va avea ca fii exact pe 
	 * subarborii calculati. De la aceasta regula se abate instructiunea de while, care retine
	 * in subarborle stang expresia de evaluat iar in cel drept programul care se va executa; 
	 * pentru if, in subarborele stang se retine expresia ce evaluat, in nodul drept va exista 
	 * un string "choose" pentru care in stanga lui avem expresia considerata daca conditia
	 * este adevarata, respectiv in cel drept cea pe care se intra in caz de else; pentru nodul
	 * return se va retine in stanga expresia returnata iar in dreapta va fi un nod null.
	 * 
	 */
	public Node createTree(String s){
		if(s.charAt(0) == '['){
			s = s.substring(1, s.length() - 1);
		}
		
		String[] list = Main.splitList(s);
		
		//daca este numar, va fi o valoare(Value)
		if(isNumeric(list[0])){
			return new Value(list[0]);
		}
		else{
			Node left, right;
			switch(list[0]){
				case "+" : 
					left = createTree(list[1]);
					right = createTree(list[2]);
					return new Addition(left, right, list[0]);
				case "*" :
					left = createTree(list[1]);
					right = createTree(list[2]);
					return new Multiplication(left, right, list[0]);
				case "==" :
					left = createTree(list[1]);
					right = createTree(list[2]);
					return new Equality(left, right, list[0]);
				case "<" :
					left = createTree(list[1]);
					right = createTree(list[2]);
					return new Inequality(left, right, list[0]);
				case "=" :
					left = createTree(list[1]);
					right = createTree(list[2]);
					return new Initialization(left, right, list[0]);
				case ";" :
					left = createTree(list[1]);
					right = createTree(list[2]);
					return new End(left, right, list[0]);
				case "if" :
					left = createTree(list[1]);
					right = new IfClause("choose");
					right.left = createTree(list[2]);
					right.right = createTree(list[3]);
					return new IfClause(left, right, list[0]);
				case "while" :
					left = createTree(list[1]);
					right = createTree(list[2]);
					return new Repetitive(left, right, list[0]);
				case "return" :
					left = createTree(list[1]);
					right = null;
					return new Return(left, right, list[0]);
				default:
					return new Variable(list[0]);
			}
		}
	}
}