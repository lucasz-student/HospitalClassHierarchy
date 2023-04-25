package HospitalClassHierarchy;

public abstract class GeneralEmployee {
	

	private String branchOfHospital; 
	private String name;
	private String employeeId; 
	private String role;
	
	public GeneralEmployee(String name, String branchOfHospital, String employeeID, String role) {
		this.employeeId = employeeID;
		this.branchOfHospital = branchOfHospital;
		this.name = name;
		this.role = role;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getId() {
		return this.employeeId;
	}
	
	
	public void setBranch(String branch) { 
		this.branchOfHospital = branch;
	}
	
	public void setRole(String role) { 
		this.role = role;
	}
	
	
	
	public abstract void identifySelf();
}
