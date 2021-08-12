package company.model.dto;

public class CompanyInfoDTO {
	
	private String companyName;
	private String founderName;
	private String foundDate;
	private String headCountry;
	private int salary;
	
	public CompanyInfoDTO() {}

	public CompanyInfoDTO(String companyName, String founderName, String foundDate, String headCountry, int salary) {
		super();
		this.companyName = companyName;
		this.founderName = founderName;
		this.foundDate = foundDate;
		this.headCountry = headCountry;
		this.salary = salary;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getFounderName() {
		return founderName;
	}

	public void setFounderName(String founderName) {
		this.founderName = founderName;
	}

	public String getFoundDate() {
		return foundDate;
	}

	public void setFoundDate(String foundDate) {
		this.foundDate = foundDate;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getHeadCountry() {
		return headCountry;
	}

	public void setHeadCountry(String headCountry) {
		this.headCountry = headCountry;
	}

	@Override
	public String toString() {
		return "companyInfo [companyName=" + companyName + ", founderName=" + founderName + ", foundDate=" + foundDate
				+ ", salary=" + salary + ", headCountry=" + headCountry + "]";
	}
	
}