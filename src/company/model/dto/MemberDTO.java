package company.model.dto;

public class MemberDTO {
	private String memberId;
	private String memberName;
	private String birthDate;
	private String major;
	
	public MemberDTO() {}
	public MemberDTO(String memberId, String memberName, String birthDate, String major) {
		this.memberId = memberId;
		this.memberName = memberName;
		this.birthDate = birthDate;
		this.major = major;
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
	
	@Override
	public String toString() {
		return "MemberDTO [memberId=" + memberId + ", memberName=" + memberName + ", birthDate=" + birthDate
				+ ", major=" + major + "]";
	}
}
