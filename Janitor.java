package HospitalClassHierarchy;

public class Janitor extends GeneralEmployee {

	private String location;
	
	public Janitor(String name, String branchOfHospital, String employeeID, String role, String location) {
		super(name, branchOfHospital, employeeID, role);
		this.location = location;
		
	}

	@Override
	public void identifySelf() {
		System.out.print("hello world");
	}

}
