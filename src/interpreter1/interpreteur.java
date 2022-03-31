package interpreter1;

import java.util.ArrayList;

public class interpreteur {
	
	Pile<String> pile = new Pile<>();
	Memoire memoire = new Memoire();
	ArrayList<instructions> vic; //vecteurs des instructions cibles
    int co =0 ;
    
    public interpreteur(String text) {
    	String[] ligne = text.split("/");
    	// decoupage de l'instruction entre la partie operation et celle operande si elle existe
    	for(String instru : ligne) {
    		String[] phrase=instru.split(" ");
            String operation = phrase[0];
            String operande;
            if (phrase.length == 2) {operande = phrase[1];}
            else {operande = "";}
            
            if(operation.equals("END")){
                vic.add(new instructions(instructions.Keyword.END, operande));
            }
            else if (operation.equals("LOAD")) {
        		vic.add(new instructions(instructions.Keyword.LOAD , operande));
        	}
        	else if(operation.equals("LOADC")){
                vic.add(new instructions(instructions.Keyword.LOADC, operande));
            }
        	else if(operation.equals("ADD")) {
        		vic.add(new instructions(instructions.Keyword.ADD));
        	}
        	else if(operation.equals("SUB")) {
        		vic.add(new instructions(instructions.Keyword.SUB));
        	}
        	else if(operation.equals("MUL")) {
        		vic.add(new instructions(instructions.Keyword.MUL));
        	}
        	else if(operation.equals("DIV")) {
        		vic.add(new instructions(instructions.Keyword.DIV));
        	}
        	else if(operation.equals("WRITE")) {
        		vic.add(new instructions(instructions.Keyword.WRITE , operande));
        	}
        	else if(operation.equals("WRITEC")) {
        		vic.add(new instructions(instructions.Keyword.WRITEC , operande));
        	}
            else if(operation.equals("JUMP")){
                vic.add(new instructions(instructions.Keyword.JUMP, operande));
            }
            else if(operation.equals("STORE")){
                vic.add(new instructions(instructions.Keyword.STORE, operande));
            }
            else if(operation.equals("JZERO")){
                vic.add(new instructions(instructions.Keyword.JZERO, operande));
            }
            else if(operation.equals("EQUAL")){
                vic.add(new instructions(instructions.Keyword.EQUAL));
            }
           
      }
    	instructions instrCour ;
        while(!vic.get(co).getOperation().equals(instructions.Keyword.END)){
            instrCour = vic.get(co) ;
            co++;
            switch(instrCour.getOperation()){
            
            
                case LOAD : 
                    pile.empiler(memoire.getObjet(Integer.valueOf(instrCour.getOperande())));
                    break;
                    
                case LOADC :
//                    int operant = Integer.valueOf(instructionCorant.getOperant());
                    pile.empiler(instrCour.getOperande());
                    break;
                    
                case ADD :
                        Integer a1 = Integer.valueOf(pile.depiler());
                        Integer a2 = Integer.valueOf(pile.depiler());
                        int add = a1 + a2;
                        pile.empiler(String.valueOf(add));
                    break;
                    
                case SUB :
                    Integer s1 = Integer.valueOf(pile.depiler());
                    Integer s2 = Integer.valueOf(pile.depiler());
                    int c1 = s1 - s2;
                    pile.empiler(String.valueOf(c1));
                break;
                
                case MUL :
                    Integer m1 = Integer.valueOf(pile.depiler());
                    Integer m2 = Integer.valueOf(pile.depiler());
                    int c11 = m1 * m2;
                    pile.empiler(String.valueOf(c11));
                break;
                
                case DIV :
                    Integer d1 = Integer.valueOf(pile.depiler());
                    Integer d2 = Integer.valueOf(pile.depiler());
                    int c111 = d1 / d2;
                    pile.empiler(String.valueOf(c111));
                break;
                
                case STORE :
                    memoire.addObjet(pile.depiler(),Integer.valueOf(instrCour.getOperande()));
                    break;
                    
                case WRITE :
                    int address = Integer.valueOf(instrCour.getOperande());
                    System.out.println(memoire.getObjet(address));
                    break;
                    
                case WRITEC :
                    System.out.println(instrCour.getOperande());
                    break;
                    
                case JUMP :
                    co = Integer.valueOf(instrCour.getOperande());
                    break;
                    
                case EQUAL :
                    int x1 = Integer.valueOf(pile.depiler());
                    int x2 = Integer.valueOf(pile.depiler());
                    if(x1 == x2){
                        pile.empiler(String.valueOf(1));
                    }else {
                        pile.empiler(String.valueOf(0));  
                    }
                    break;
                    
                case JZERO :
                    int i = Integer.valueOf(pile.depiler());
                    if(i==0){
                        co = Integer.valueOf(instrCour.getOperande());
                    }
                    break;    
                
            }
        } 
      
       
    	
    }

}
