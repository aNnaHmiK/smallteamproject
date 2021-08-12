package company.model.dto;

public class QualificationInfoDTO {
	private String companyName  ;
	private String education  ;
	private String major;
	private String lang;
	
	public QualificationInfoDTO() {}
	public QualificationInfoDTO(String companyName, String education, String major, String lang) {
		this.companyName = companyName;
		this.education = education;
		this.major = major;
		this.lang = lang;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getLang() {
		return lang;
	}
	public void setLang(String lang) {
		this.lang = lang;
	}
	@Override
	public String toString() {
		return "QualificationInfoDTO [companyName=" + companyName + ", education=" + education + ", major=" + major
				+ ", lang=" + lang + "]";
	}
}