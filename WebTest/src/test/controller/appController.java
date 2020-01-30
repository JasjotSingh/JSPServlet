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
 * Servlet implementation class appController
 */
@WebServlet("/Operations")
public class appController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name = "jdbc/webtest")
    private DataSource datasource;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public appController() {
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
		case "listuser":
			listUsers(request,response);
			break;
		case "adduserform":
			addUserForm(request, response);
			break;
		case "updateuserform":
			updateUserForm(request,response);
			break;
		case "deleteuser":
			deleteUser(request, response);
			break;
		default:
			request.setAttribute("title", "404 - Not Found");
			request.getRequestDispatcher("error1.jsp").forward(request,response);
			break;
		}
	}
	
	

	public void listUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User> userlist = new UserModel().listUsers(datasource, response) ;
		request.setAttribute("userlist", userlist);
		request.setAttribute("title", "List Users");
		request.getRequestDispatcher("listUsers.jsp").forward(request, response);
	}
	
	public void addUserForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setAttribute("title", "Add User");
		request.getRequestDispatcher("adduser.jsp").forward(request, response);
	}
	
	public void updateUserForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setAttribute("title", "Update User");
		request.setAttribute("userid", request.getParameter("userid"));
		request.getRequestDispatcher("updateuser.jsp").forward(request,response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.sendRedirect("listuser.jsp");
		String action = request.getParameter("action");
		action = action.toLowerCase();
		switch(action) {
		case "adduser":
			addUser(request,response);
			break;
		case "updateuser":
			String userid = request.getParameter("userid");
			updateUser(request,response);
			break;
		default:
			request.getRequestDispatcher("error1.jsp").forward(request, response);
		}
	}
	
	private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userid = Integer.parseInt(request.getParameter("userid"));
		
		UserModel um = new UserModel();
		um.deleteUser(datasource, userid);
		
		//redirect to listusers.
		String path = request.getContextPath();
		response.sendRedirect(path+"/Operations?page=listuser");
		
	}
	
	private void updateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		int userid = Integer.parseInt(request.getParameter("userid"));
		
		UserModel um = new UserModel();
		um.updateUser(datasource, new User(userid, username, email));
		
		//redirect to listusers.
		String path = request.getContextPath();
		response.sendRedirect(path+"/Operations?page=listuser");
	}

	private void addUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		
		UserModel um = new UserModel();
		um.addUser(datasource, new User(username, email));
		
		//redirect to listusers.
		String path = request.getContextPath();
		response.sendRedirect(path+"/Operations?page=listuser");
		
	}

}
