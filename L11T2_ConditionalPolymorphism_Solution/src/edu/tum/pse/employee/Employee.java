package edu.tum.pse.employee;

//caller class
public class Employee {
    private EmployeeType _type;
	private int _monthlySalary = 1000;
	private int _bonus = 300;
	
	private Employee(EmployeeType type) {
		_type = type;
	}
	
//	public static Employee create(EmployeeType type) {
//		_type = type;
//		return new Employee(type);
//	}
	
	//body of this method was moved to the superclass
    public int payAmount() {
    	return _type.payAmount(this);
    }
    
    Type getType() {
        return _type.getTypeCode(); 
    }   
    
    public int getMonthlySalary() {
    	return _monthlySalary;
    }
    
    public int getBonus() {
    	return _bonus;
    }
    
    //main()
    public static void main(String[] args) {
		Employee jack = new Employee(new Engineer());
		Employee stephan = new Employee(new Manager());
		Employee hinke = new Employee(new Intern());
		
		System.out.println("Payment amount=" + jack.payAmount());
		System.out.println("Payment amount=" + stephan.payAmount());
		System.out.println("Payment amount=" + hinke.payAmount());
	}
}

