package homeworkPP;

import java.util.HashMap;
import java.util.Map;

public class Context {
	
	//Structura de date care va mapa o variabila cu valoarea ei.
	Map<String, Integer> map = new HashMap<String, Integer>();

	/**
	 * 
	 * @param c - reprezinta contextul in care se lucreaza(mai exact
	 * ce variabile sunt in scope la acel moment si valorile lor)
	 * @return - o copie a contextului curent.
	 */
	public Context makeCopy(Context c){
		Context cLocal = new Context();
		cLocal.map = new HashMap<String, Integer>(c.map);
		return cLocal;
	}

	public void add (String v, Integer i){
		/* TO-DO */
		map.put(v, i);
	}

	public Integer valueOf(String v) {
		/* TO-DO */
		return map.get(v);
	}
}