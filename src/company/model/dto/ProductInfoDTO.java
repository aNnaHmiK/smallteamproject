package company.model.dto;

public class ProductInfoDTO {
	
	private String productName;
	private String companyName;
	private int sales;
	
	public ProductInfoDTO() {}

	public ProductInfoDTO(String productName, String companyName, int sales) {
		super();
		this.productName = productName;
		this.companyName = companyName;
		this.sales = sales;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public int getSales() {
		return sales;
	}

	public void setSales(int sales) {
		this.sales = sales;
	}

	@Override
	public String toString() {
		return "productInfo [productName=" + productName + ", companyName=" + companyName + ", sales=" + sales + "]";
	}

}