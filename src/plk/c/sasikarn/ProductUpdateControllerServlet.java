package plk.c.sasikarn;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/ProductUpdateControllerServlet")
public class ProductUpdateControllerServlet extends HttpServlet {
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

		request.setCharacterEncoding("UTF-8");

		String theProductId = request.getParameter("productId");

		try {

			Product theProduct = productDbUtil.getProduct(theProductId);

			//set attribute and attribute reference
			request.setAttribute("THE_PRODUCT", theProduct);

		} catch (Exception e) {

			e.printStackTrace();
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/ProductUpdate.jsp");
		dispatcher.forward(request, response);
	}

}
