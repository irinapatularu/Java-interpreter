/**
 * @author Patularu Ioana Irina
 */

package homeworkPP;
import Elements.*;
import java.util.LinkedList;
import java.util.List;

public class Main {

	/**
	 * IMPORTANT! Your solution will have to implement this method.
	 * @param exp - a string, which represents an expression (that
	 * follows the specification in the homework);
	 * @param c - the context (a one-to-one association between variables
	 * and values);
	 * @return - the result of the evaluation of the expression;
	 */
	public static Integer evalExpression(String exp, Context c){
		/* TO-DO */
		Tree tree = new Tree(exp);
		Node root = tree.construct();
		return new Integer(root.evaluate(c));
	}

	/**
	 * IMPORTANT! Your solution will have to implement this method.
	 * @param program - a string, which represents a program (that
	 * follows the specification in the homework);
	 * @return - the result of the evaluation of the expression;
	 */
	public static Integer evalProgram(String program) {
		/* TO-DO */
		Tree tree = new Tree(program);
		Node root = tree.construct();
		Context globalC = new Context();
		return root.evaluate(globalC);
	}

	/**
	 * IMPORTANT! Your solution will have to implement this method.
	 * @param program - a string, which represents a program (that
	 * follows the specification in the homework);
	 * @return - whether the given program follow the syntax rules
	 * specified in the homework (always return a value and always
	 * use variables that are "in scope");
	 */

	public static Boolean checkCorrectness(String program) {
		/* TO-DO */
		Tree tree = new Tree(program);
		ExploreElements v = new ExploreElements();
		Node root = tree.construct();
		return v.check(root);
	}


	/**
	 *
	 * @param s - a string, that contains a list of programs, each
	 * program starting with a '[' and ending with a matching ']'.
	 * Programs are separated by the whitespace caracter;
	 * @return - array of strings, each element in the array representing
	 * a program;
	 * Example: "[* [+ 1 2] 3] [* 4 5]" -> "[* [+ 1 2] 3]" & "[* 4 5]";
	 */
	public static String[] splitList(String s){
		//String[] result = new String[0];
		List<String> l = new LinkedList<String>();
		int inside = 0;
		int start = 0, stop = 0;
		for (int i=0; i<s.length(); i++){
			if (s.charAt(i) == '['){
				inside++;
				stop++;
				continue;
			}
			if (s.charAt(i) == ']'){
				inside--;
				stop++;
				continue;
			}
			if (s.charAt(i) == ' ' && inside == 0){
				l.add(s.substring(start,stop));
				start = i+1; //starting after whitespace
				stop = start;

				continue;
			}
			stop++; //no special case encountered
		}
		if (stop > start) {
			l.add(s.substring(start, stop));
		}

		return l.toArray(new String[l.size()]);
	}

	public static void main(String[] args) {
	}
}