package vo;

public class EmpVO {
	//목표가 되는 테이블은 employees이며 필요한 컬럼들을 
	//현재객체에 멤버변수로 선언
	private String employee_id, first_name, job_id, department_id;

	
	public String getemployee_id() {
		return employee_id;
	}

	public void setemployee_id(String employee_id) {
		this.employee_id = employee_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getJob_id() {
		return job_id;
	}

	public void setJob_id(String job_id) {
		this.job_id = job_id;
	}

	public String getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(String department_id) {
		this.department_id = department_id;
	}
	
}
