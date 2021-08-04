package com.codingdojo.calculator;

class Calculator implements java.io.Serializable {
    private double OperandOne;
    private double OperandTwo;
    private String name;
    private String operation;
    private double results;
    public double getResults() {
		return results;
	}
	public void setResults(double results) {
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
    public double getOperandOne() {
		return OperandOne;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		if(operation != "+" && operation != "-" && operation != "*" && operation != "/") {
			System.out.println("Please enter a valid operator (+, -, * or /)");
		} else {
			this.operation = operation;	
		}		
	}
	public void setOperandOne(double operandOne) {
		OperandOne = operandOne;
	}
	public double getOperandTwo() {
		return OperandTwo;
	}
	public void setOperandTwo(double operandTwo) {
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
    	} else if(this.operation == "*") {
    		this.setResults(this.OperandOne * this.OperandTwo);
    		return "Successfully performed multiplication operation!";
    	} else if(this.operation == "/") {
    		this.setResults(this.OperandOne / this.OperandTwo);
    		return "Successfully performed division operation!";
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