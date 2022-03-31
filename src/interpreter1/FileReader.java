package interpreter1;

import java.io.File;
import java.util.Scanner;


public class FileReader {
	
	public static void main(String[] args) {

		try {
			File f = new File("C:\\Users\\dell\\Desktop\\assembleur.txt");
			Scanner s = new Scanner(f);
			String text="";
            while (s.hasNextLine()){
            	text += s.nextLine()+"/";
			}
            new interpreteur(text);
//			Iterator<String> itr = vic.iterator();
//			while(itr.hasNext()) {
//				System.out.println(itr.next());
//			}
			s.close();
		}
		
           //Pour la gestion des erreurs
	       catch (Exception e) {
	           System.err.println("Error de lecture du fichier: " + e.getMessage());
	       }
	 }

}

