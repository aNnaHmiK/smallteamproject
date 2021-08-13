package company.model.dto;

public class MemberInfoDTO {
	private String memberId;
	private String memberName;
	private String birthDate;
	private String major;
	private String email;
	private int deptHope;
	
	public MemberInfoDTO() {}
	public MemberInfoDTO(String memberId, String memberName, String birthDate, String major, String email,
			int deptHope) {
		this.memberId = memberId;
		this.memberName = memberName;
		this.birthDate = birthDate;
		this.major = major;
		this.email = email;
		this.deptHope = deptHope;
	}
	
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getDeptHope() {
		return deptHope;
	}
	public void setDeptHope(int deptHope) {
		this.deptHope = deptHope;
	}
	
	
	@Override
	public String toString() {
		return "나의 회원정보 [아이디=" + memberId + ", 이름=" + memberName + ", 생년월일=" + birthDate
				+ ", 전공=" + major + ", 이메일=" + email + ", 희망직무번호=" + deptHope + "]";
	}
	
}
