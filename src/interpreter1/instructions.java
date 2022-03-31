package interpreter1;

public class instructions {
	 public Keyword operation ;
	 public String operande;
	 
	 public enum Keyword {
		 LOAD , LOADC , STORE ,ADD , SUB ,MUL ,DIV ,EQUAL,JZERO,JUMP ,WRITEC , WRITE , END
	 }
	 
	public instructions(Keyword operation, String operande) {
		super();
		this.operation = operation;
		this.operande = operande;
	}
	public instructions(Keyword operation) {
		super();
		this.operation = operation;
	}

	public Keyword getOperation() {
		return operation;
	}

	public void setOperation(Keyword operation) {
		this.operation = operation;
	}

	public String getOperande() {
		return operande;
	}

	public void setOperande(String operande) {
		this.operande = operande;
	}
	
	
	 
	 

}
