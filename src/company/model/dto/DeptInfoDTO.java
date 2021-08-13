package company.model.dto;

public class DeptInfoDTO {
	private int deptNum ;
	private String deptName ;
	private int incentive ;
	
	public DeptInfoDTO() {}
	public DeptInfoDTO(int deptNum, String deptName, int incentive) {
		this.deptNum = deptNum;
		this.deptName = deptName;
		this.incentive = incentive;
	}
	
	public int getDeptNum() {
		return deptNum;
	}
	public void setDeptNum(int deptNum) {
		this.deptNum = deptNum;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public int getIncentive() {
		return incentive;
	}
	public void setIncentive(int incentive) {
		this.incentive = incentive;
	}
	
	@Override
	public String toString() {
		return "[직무번호=" + deptNum + ", 직무이름=" + deptName + ", 인센티브=" + incentive + "]";
	}
	
}
