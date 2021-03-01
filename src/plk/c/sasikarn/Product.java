package plk.c.sasikarn;

import java.io.Serializable;

public class Product implements Serializable {

	private int productId;
	private String productGenreCode;//char(1)
	private String productName;
	private String productMaker;
	private int productPrice;
	private int productStock;
	private int productSales;
	private String productRemarks;

	public Product(String productGenreCode, String productName, String productMaker,
			int productPrice, int productStock, int productSales, String productRemarks) {
		this.productGenreCode = productGenreCode;
		this.productName = productName;
		this.productMaker = productMaker;
		this.productPrice = productPrice;
		this.productStock = productStock;
		this.productSales = productSales;
		this.productRemarks = productRemarks;
	}

	public Product(int productId, String productGenreCode, String productName, String productMaker,
			int productPrice, int productStock, int productSales, String productRemarks) {
		this.productId = productId;
		this.productGenreCode = productGenreCode;
		this.productName = productName;
		this.productMaker = productMaker;
		this.productPrice = productPrice;
		this.productStock = productStock;
		this.productSales = productSales;
		this.productRemarks = productRemarks;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductGenreCode() {
		return productGenreCode;
	}

	public void setProductGenreCode(String productGenreCode) {
		this.productGenreCode = productGenreCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductMaker() {
		return productMaker;
	}

	public void setProductMaker(String productMaker) {
		this.productMaker = productMaker;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public int getProductStock() {
		return productStock;
	}

	public void setProductStock(int productStock) {
		this.productStock = productStock;
	}

	public int getProductSales() {
		return productSales;
	}

	public void setProductSales(int productSales) {
		this.productSales = productSales;
	}

	public String getProductRemarks() {
		return productRemarks;
	}

	public void setProductRemarks(String productRemarks) {
		this.productRemarks = productRemarks;
	}

	@Override
	//use for debug
	public String toString() {
		return "Product [productId=" + productId + ", productGenreCode=" + productGenreCode + ", productName="
				+ productName + ", productMaker=" + productMaker + ", productPrice=" + productPrice + ", productStock="
				+ productStock + ", productSales=" + productSales + ", productRemarks=" + productRemarks + "]";

	}

}