package com.codingdojo.calculator;

class Calculator implements java.io.Serializable {
    private int OperandOne;
    private int OperandTwo;
    private String name;
    private String operation;
    private int results;
    public int getResults() {
		return results;
	}
	public void setResults(int results) {
		this.results = results;
	}
	public Calculator(){
    }
    public Calculator(String name){
    	this.name = name;
        this.OperandOne = 0;
        this.OperandTwo = 0;
        this.operation="";
    }
    public int getOperandOne() {
		return OperandOne;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		if(operation != "+" && operation != "-") {
			System.out.println("Please enter a valid operator (+ or -)");
		} else {
			this.operation = operation;	
		}		
	}
	public void setOperandOne(int operandOne) {
		OperandOne = operandOne;
	}
	public int getOperandTwo() {
		return OperandTwo;
	}
	public void setOperandTwo(int operandTwo) {
		OperandTwo = operandTwo;
	}
	public void setName(String n){
        name = n;
    }
    public String getName(){
        return name;
    }
    public String performOperation() {
    	if(this.operation == "") {
    		return "Please first enter an operation";
    	} else if(this.operation == "+") {
    		this.setResults(this.OperandOne + this.OperandTwo);
    		return "Successfully performed addition operation!";
    	} else if(this.operation == "-") {
    		this.setResults(this.OperandOne + this.OperandTwo);
    		return "Successfully performed subtraction operation!";
    	}
    	return "To see results, please use getResults.";
    }    
    
    
//They only need adding and subtracting functionality right now. They need the method performOperation and getResults to be the methods 
//that run all the operations and return the end result respectively.
//setOperandOne(10.5)
//setOperation("+")
//setOperandTwo(5.2)
//performOperation()
//getResults()
//where the result would be 15.7.
    
    
    
    
    
    
    
    
    
    
    
    
    
}