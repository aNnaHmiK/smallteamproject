package company.model.dto;

public class FounderInfoDTO {
	
	private String founderName;
	private String birthDate;
	private String birthCountry;
	
	public FounderInfoDTO() {
	}

	public FounderInfoDTO(String founderName, String birthDate, String birthCountry) {
		super();
		this.founderName = founderName;
		this.birthDate = birthDate;
		this.birthCountry = birthCountry;
	}

	public String getFounderName() {
		return founderName;
	}

	public void setFounderName(String founderName) {
		this.founderName = founderName;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getBirthCountry() {
		return birthCountry;
	}

	public void setBirthCountry(String birthCountry) {
		this.birthCountry = birthCountry;
	}

	@Override
	public String toString() {
		return "founderInfo [founderName=" + founderName + ", birthDate=" + birthDate + ", birthCountry=" + birthCountry
				+ "]";
	}
	
}