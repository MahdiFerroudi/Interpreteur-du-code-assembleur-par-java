package interpreter1;

import java.util.HashMap;

public class Memoire {
	
	private HashMap<Integer,String> memoire = new HashMap<>();
    
	public Memoire() {
	}
	
	public String getObjet(Integer index) {
		return memoire.get(index);
	}
	
	public void addObjet(String Objet , int index) {
	      memoire.put(index, Objet);
	}

}