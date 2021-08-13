package company.model.dto;

public class WantedInfoDTO {
	private int wantedNum;
	private String companyName;
	private int salary;
	private int deptNum;
	private String location;
	private String qualification;
	
	public WantedInfoDTO() {}
	public WantedInfoDTO(int wantedNum, String companyName, int salary, int deptNum, String location,
			String qualification) {
		super();
		this.wantedNum = wantedNum;
		this.companyName = companyName;
		this.salary = salary;
		this.deptNum = deptNum;
		this.location = location;
		this.qualification = qualification;
	}
	
	public int getWantedNum() {
		return wantedNum;
	}
	public void setWantedNum(int wantedNum) {
		this.wantedNum = wantedNum;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getDeptNum() {
		return deptNum;
	}
	public void setDeptNum(int deptNum) {
		this.deptNum = deptNum;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	
	@Override
	public String toString() {
		return " [ä����� ��ȣ=" + wantedNum + ", ȸ���=" + companyName + ", ����=" + salary
				+ ", ������ȣ=" + deptNum + ", �ٹ���=" + location + ", ��Ÿ�ڰ�=" + qualification + "]";
	}
	
}