package edu.tum.pse.employee;


//caller class
public class Employee {
    private EmployeeType _type;
	private int _monthlySalary = 1000;
	private int _bonus = 300;
	
	public Employee(EmployeeType type) {
		_type = type;
	}
	
	//please refactor this method
    public int payAmount(EmpType empType) {
        switch (empType) {
            case ENGINEER:
               return _monthlySalary;
            case MANAGER:
               return _monthlySalary + _bonus;
            default:
               throw new RuntimeException("Incorrect Employee");
        }
    }
   
    int getType() {
        return _type.getTypeCode(); 
    }   
    
    //main()
    public static void main(String[] args) {
		Employee jack = new Employee(new Engineer());
		Employee stephan = new Employee(new Manager());
		
		System.out.println("Payment amount=" + jack.payAmount());
		System.out.println("Payment amount=" + stephan.payAmount());
	}
}

