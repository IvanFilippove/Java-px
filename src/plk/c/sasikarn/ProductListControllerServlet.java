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

@WebServlet("/ProductListControllerServlet")
public class ProductListControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDbUtil productDbUtil;

	@Resource(name = "jdbc/wbr_inventory_control")
	private DataSource dataSource;

	@Override
	public void init() throws ServletException {
		super.init();

		// create our student db util ... and pass in the conn pool / datasource
		try {
			productDbUtil = new ProductDbUtil(dataSource);
		} catch (Exception exc) {
			throw new ServletException(exc);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		try {
			List<Product> products = productDbUtil.getProducts();
			request.setAttribute("PRODUCT_LIST", products);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/ProductList.jsp");
			dispatcher.forward(request, response);

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
