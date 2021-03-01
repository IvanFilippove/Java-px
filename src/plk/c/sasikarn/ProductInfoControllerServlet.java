package plk.c.sasikarn;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/ProductInfoControllerServlet")
public class ProductInfoControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDbUtil productDbUtil;

	@Resource(name = "jdbc/wbr_inventory_control")
	private DataSource dataSource;

	@Override
	public void init() throws ServletException {
		super.init();

		// create our product db util ... and pass in the conn pool / datasource
		try {
			productDbUtil = new ProductDbUtil(dataSource);
		} catch (Exception exc) {
			throw new ServletException(exc);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			int productId = Integer.parseInt(request.getParameter("productId"));
			String productGenreCode = request.getParameter("productGenreCode");
			String productName = request.getParameter("productName");
			String productMaker = request.getParameter("productMaker");
			int productPrice = Integer.parseInt(request.getParameter("productPrice"));
			int productStock = Integer.parseInt(request.getParameter("productStock"));
			int productSales = Integer.parseInt(request.getParameter("productSales"));
			String productRemarks = request.getParameter("productRemarks");

			// create a new product object
			Product theProduct = new Product(productId, productGenreCode, productName, productMaker, productPrice,
					productStock, productSales, productRemarks);

			// add the product to the database
			productDbUtil.addProduct(theProduct);

			List<Product> products = productDbUtil.getProducts();
			request.setAttribute("theProduct", products);
			
			

		} catch (Exception e) {

			e.printStackTrace();
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/ProductList.jsp");
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		try {
			String theProductId = request.getParameter("productId");
			Product theProduct;
			theProduct = productDbUtil.getProduct(theProductId);
			request.setAttribute("THE_PRODUCT", theProduct);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/ProductList.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
