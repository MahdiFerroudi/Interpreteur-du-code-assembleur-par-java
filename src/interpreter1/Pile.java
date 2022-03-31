package interpreter1;

import java.util.ArrayList;

@SuppressWarnings("hiding")
	public class Pile<String> {
		
		private ArrayList<String> objets = new ArrayList<String>();
		
		public Pile() {
		}
		
		public String getObjets() {
			return objets.get(objets.size()-1);
		}
		
		// faire depiler un element de la pile 
		public String depiler() {
			String objet_sommet=objets.get(objets.size()-1);
			objets.remove(objet_sommet);
			return objet_sommet;
		}
		
		// ajouter dans la pile un objet 
		public void empiler(String objet) {
			objets.add(objet);
		}
	}
		 
	    