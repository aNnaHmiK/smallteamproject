package company.model.dto;

public class ManageInfoDTO extends QualificationInfoDTO{
	private String companyName ;
	private int marketCap ;
	private int stockPrice ;
	private String mainProduct ;
	
	public ManageInfoDTO() {}
	public ManageInfoDTO(String companyName, int marketCap, int stockPrice, String mainProduct) {
		this.companyName = companyName;
		this.marketCap = marketCap;
		this.stockPrice = stockPrice;
		this.mainProduct = mainProduct;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public int getMarketCap() {
		return marketCap;
	}
	public void setMarketCap(int marketCap) {
		this.marketCap = marketCap;
	}
	public int getStockPrice() {
		return stockPrice;
	}
	public void setStockPrice(int stockPrice) {
		this.stockPrice = stockPrice;
	}
	public String getMainProduct() {
		return mainProduct;
	}
	public void setMainProduct(String mainProduct) {
		this.mainProduct = mainProduct;
	}
	@Override
	public String toString() {
		return "ManageInfoDTO [companyName=" + companyName + ", marketCap=" + marketCap + ", stockPrice=" + stockPrice
				+ ", mainProduct=" + mainProduct + "]";
	}
}