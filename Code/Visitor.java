package homeworkPP;
import Elements.*;

public interface  Visitor {
	
	public void visit(Value v, Context c);
	public void visit(Variable v, Context c);
	public void visit(Addition op, Context c);
	public void visit(Multiplication op, Context c);
	public void visit(Equality op, Context c);
	public void visit(Inequality op, Context c);
	public void visit(Initialization i, Context c);
	public void visit(IfClause i, Context c);
	public void visit(End e, Context c);
	public void visit(Repetitive r, Context c);
	public void visit(Return r, Context c);
}
