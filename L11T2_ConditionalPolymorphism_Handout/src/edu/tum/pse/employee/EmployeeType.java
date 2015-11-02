package edu.tum.pse.employee;

/////////////////////////////////
// superclass
/////////////////////////////////
abstract class EmployeeType {
	 public static final EmpType ENGINEER = EmpType.ENGINEER;
	 public static final EmpType MANAGER = EmpType.MANAGER;
	 public static final EmpType INTERN = EmpType.INTERN;
	 
	 abstract public EmpType getTypeCode();
	 public abstract int payAmount(Employee emp);
	 public abstract int getMonthlySalary();
}

/////////////////////////////////
// subclass: Engineer
/////////////////////////////////
class Engineer extends EmployeeType {
	private static final int MONTHLY_SALARY = 4000;
	
	public EmpType  getTypeCode() {
		return EmployeeType.ENGINEER;
	}

	@Override
	public int payAmount(Employee emp) {
		return 0;
	}

	@Override
	public int getMonthlySalary() {
		return MONTHLY_SALARY;
	}
}

/////////////////////////////////
// subclass: Manager
/////////////////////////////////
class Manager extends EmployeeType {
	private static final int MONTHLY_SALARY = 5000;

	public EmpType getTypeCode() {
		return EmployeeType.MANAGER;
	}

	@Override
	public int payAmount(Employee emp) {
		return 0;
	}

	@Override
	public int getMonthlySalary() {
		// TODO Auto-generated method stub
		return MONTHLY_SALARY;
	}
}
