package company.model.dto;

public class ApplyInfoDTO {
	private int applicantNum;
	private String memberId;
	private String wantedNum;
	private String applyDate;
	
	public ApplyInfoDTO() {}
	public ApplyInfoDTO(int applicantNum, String memberId, String wantedNum, String applyDate) {
		this.applicantNum = applicantNum;
		this.memberId = memberId;
		this.wantedNum = wantedNum;
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
	public String getWantedNum() {
		return wantedNum;
	}
	public void setWantedNum(String wantedNum) {
		this.wantedNum = wantedNum;
	}
	public String getApplyDate() {
		return applyDate;
	}
	public void setApplyDate(String applyDate) {
		this.applyDate = applyDate;
	}
	
	@Override
	public String toString() {
		return "나의 지원정보 [지원번호=" + applicantNum + ", 아이디=" + memberId + ", 채용공고 번호=" + wantedNum
				+ ", 지원날짜=" + applyDate + "]";
	}
	
}
