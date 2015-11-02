package edu.tum.pse.employee;

/////////////////////////////////
// superclass
/////////////////////////////////
abstract class EmployeeType {
	 public static final Type ENGINEER = Type.ENGINEER;
	 public static final Type MANAGER = Type.MANAGER;
	 public static final Type INTERN = Type.INTERN;
	 
	 public abstract Type getTypeCode();

	 //functionality of this method has been distributed to each subclass
	 public abstract int payAmount(Employee emp);

}

/////////////////////////////////
// subclass: Engineer
/////////////////////////////////
class Engineer extends EmployeeType {
	public Type getTypeCode() {
		return Type.ENGINEER;
	}
	
	//overriding method
	public int payAmount(Employee emp) {
      return emp.getMonthlySalary();
  }	
}

/////////////////////////////////
// subclass: Manager
/////////////////////////////////
class Manager extends EmployeeType {
	public Type getTypeCode() {
		return Type.MANAGER;
	}
	
	//overriding method
	public int payAmount(Employee emp) {
	        return emp.getMonthlySalary() + emp.getBonus();
	}	
}

/////////////////////////////////
// subclass: Intern (NEW!)
/////////////////////////////////
class Intern extends EmployeeType {
	public Type getTypeCode() {
		return Type.INTERN;
	}
	
	//overriding method
	public int payAmount(Employee emp) {
	        return emp.getMonthlySalary()/2;
	}	
}