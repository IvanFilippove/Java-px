package plk.c.sasikarn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class ProductDbUtil {
	//reference to datasource
	private DataSource dataSource;

	//set constructor
	public ProductDbUtil(DataSource theDataSource) {
		dataSource = theDataSource;
	}

	//SHELL out line of method
	public List<Product> getProducts() throws Exception {
		List<Product> products = new ArrayList<>();
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;

		try {
			//get a connection
			myConn = dataSource.getConnection();

			//create sql statement
			String sql = "select*from t_product";
			myStmt = myConn.createStatement();

			//execute query
			myRs = myStmt.executeQuery(sql);

			//process result set
			while (myRs.next()) {
				//retrive data from result set row (database column name)
				int productId = myRs.getInt("PRODUCT_ID");
				String productGenreCode = myRs.getString("PRODUCT_GENRE_CODE");
				String productName = myRs.getString("PRODUCT_NAME");
				String productMaker = myRs.getString("PRODUCT_MAKER");
				int productPrice = myRs.getInt("PRODUCT_PRICE");
				int productStock = myRs.getInt("PRODUCT_STOCK");
				int productSales = myRs.getInt("PRODUCT_SALES");
				String productRemarks = myRs.getString("PRODUCT_REMARKS");
				//create new Product object
				Product tempProduct = new Product(productId, productGenreCode, productName, productMaker, productPrice,
						productStock, productSales, productRemarks);
				// add it to the list of products
				products.add(tempProduct);
			}

			return products;
		} finally {
			//close JDBC object
			close(myConn, myStmt, myRs);
		}

	}

	//make eclispe to create class for you
	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {
		try {
			if (myRs != null) {
				myRs.close();
			}
			if (myStmt != null) {
				myStmt.close();
			}
			if (myConn != null) {
				myConn.close(); //doesn't really close it..just put it back in connection pool
			}
		} catch (Exception exc) {
			exc.printStackTrace();
		}

	}
	public void addProduct(Product theProduct) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;

		try {
			// get db connection
			myConn = dataSource.getConnection();

			// create sql for insert
			String sql = "insert into t_product "
					   + "(product_id, product_genre_code, product_name, product_maker, product_price, product_stock, product_sales, product_remarks) "
					   + "values (?, ?, ?, ?, ?, ?, ?, ?)";

			myStmt = myConn.prepareStatement(sql);

			// set the param values for the student
			myStmt.setInt(1, theProduct.getProductId());
			myStmt.setString(2, theProduct.getProductGenreCode());
			myStmt.setString(3, theProduct.getProductName());
			myStmt.setString(4, theProduct.getProductMaker());
			myStmt.setInt(5, theProduct.getProductPrice());
			myStmt.setInt(6, theProduct.getProductStock());
			myStmt.setInt(7, theProduct.getProductSales());
			myStmt.setString(8, theProduct.getProductRemarks());

			// execute sql insert
			myStmt.execute();
		}
		finally {
			// clean up JDBC objects
			close(myConn, myStmt, null);
		}
	}
	public Product getProduct(String theProductId) throws Exception {

		Product theProduct = null;
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		int productId;

		try {
			// convert product id to int
			productId = Integer.parseInt(theProductId);

			// get connection to database
			myConn = dataSource.getConnection();

			// create sql to get selected product
			String sql = "select * from t_product where product_id=?";

			// create prepared statement
			myStmt = myConn.prepareStatement(sql);

			// set params
			myStmt.setInt(1, productId);

			// execute statement
			myRs = myStmt.executeQuery();

			// retrieve data from result set row
			if (myRs.next()) {

				String productGenreCode = myRs.getString("PRODUCT_GENRE_CODE");
				String productName = myRs.getString("PRODUCT_NAME");
				String productMaker = myRs.getString("PRODUCT_MAKER");
				int productPrice = myRs.getInt("PRODUCT_PRICE");
				int productStock = myRs.getInt("PRODUCT_STOCK");
				int productSales = myRs.getInt("PRODUCT_SALES");
				String productRemarks = myRs.getString("PRODUCT_REMARKS");

				// use the productId during construction
				theProduct = new Product(productId, productGenreCode, productName, productMaker, productPrice,
						productStock, productSales, productRemarks);
			}
			else {
				throw new Exception("Could not find product id: " + productId);
			}

			return theProduct;
		}
		finally {
			// clean up JDBC objects
			close(myConn, myStmt, myRs);
		}
	}

	public void updateProduct(Product theProduct) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;

		try {
			// get db connection
			myConn = dataSource.getConnection();

			// create SQL update statement
			String sql = "update t_product "
						+ "set product_id, product_genre_code=?, product_name=?, product_maker=?, product_price=?, product_stock=?, product_sales=?, product_remarks=? "
						+ "where id=?";

			// prepare statement
			myStmt = myConn.prepareStatement(sql);

			// set params
			myStmt.setInt(1, theProduct.getProductId());
			myStmt.setString(2, theProduct.getProductGenreCode());
			myStmt.setString(3, theProduct.getProductName());
			myStmt.setString(4, theProduct.getProductMaker());
			myStmt.setInt(5, theProduct.getProductPrice());
			myStmt.setInt(6, theProduct.getProductStock());
			myStmt.setInt(7, theProduct.getProductSales());
			myStmt.setString(8, theProduct.getProductRemarks());

			// execute SQL statement
			myStmt.execute();
		}
		finally {
			// clean up JDBC objects
			close(myConn, myStmt, null);
		}
	}



}
