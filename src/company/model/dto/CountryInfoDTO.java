
package company.model.dto;

public class CountryInfoDTO {
	private String country_name  ;
	private String continent ;
	private int  gdp_rank ;
	
	public CountryInfoDTO() {}
	public CountryInfoDTO(String country_name, String continent, int gdp_rank) {
		this.country_name = country_name;
		this.continent = continent;
		this.gdp_rank = gdp_rank;
	}
	
	public String getCountry_name() {
		return country_name;
	}
	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}
	public String getContinent() {
		return continent;
	}
	public void setContinent(String continent) {
		this.continent = continent;
	}
	public int getGdp_rank() {
		return gdp_rank;
	}
	public void setGdp_rank(int gdp_rank) {
		this.gdp_rank = gdp_rank;
	}
	
	@Override
	public String toString() {
		return "countryInfoDTO [country_name=" + country_name + ", continent=" + continent + ", gdp_rank=" + gdp_rank
				+ "]";
	} 
}