package company.model.dto;

public class ApplyInfoDTO {
	private int applicantNum;
	private String memberId;
	private String companyName;
	private String applyDate;
	
	public ApplyInfoDTO() {}
	public ApplyInfoDTO(int applicantNum, String memberId, String companyName, String applyDate) {
		this.applicantNum = applicantNum;
		this.memberId = memberId;
		this.companyName = companyName;
		this.applyDate = applyDate;
	}

	public int getApplicantNum() {
		return applicantNum;
	}
	public void setApplicantNum(int applicantNum) {
		this.applicantNum = applicantNum;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getApplyDate() {
		return applyDate;
	}
	public void setApplyDate(String applyDate) {
		this.applyDate = applyDate;
	}
	
	@Override
	public String toString() {
		return "ApplyInfoDTO [applicantNum=" + applicantNum + ", memberId=" + memberId + ", companyName=" + companyName
				+ ", applyDate=" + applyDate + "]";
	}

}
