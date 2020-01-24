package test.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import test.entity.User;
import test.model.UserModel;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/Home")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @Resource(name = "jdbc/webtest")
    private DataSource datasource;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = request.getParameter("page");
		page = page.toLowerCase();
		switch(page) {
		case "home":
			request.setAttribute("title", "Home Page");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		case "listuser":
			List<User> userlist = new UserModel().listUsers(datasource, response) ;
			request.setAttribute("userlist", userlist);
			request.setAttribute("title", "List Users");
			request.getRequestDispatcher("listUsers.jsp").forward(request, response);
		default:
			request.setAttribute("title", "404 - Not Found");
			request.getRequestDispatcher("error.jsp").forward(request,response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
