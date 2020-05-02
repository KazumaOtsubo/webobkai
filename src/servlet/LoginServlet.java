package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DistributerDao;
import model.Participant;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	String password;
	String newPassword;
	String name;
	int grade;
	Participant participant = new Participant();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("utf-8");

		password = request.getParameter("password");
		newPassword = request.getParameter("newPassword");
		name = request.getParameter("name");
		grade = Integer.parseInt(request.getParameter("grade"));

		if(!password.equals("2020webobkai")) {
			System.out.println("check");
			RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
			rd.forward(request, response);
			return;
		}

		//登録処理
		String url = "jdbc:mysql://us-cdbr-east-06.cleardb.net/heroku_791ec9286655973?useSSL=false&characterEncoding=UTF-8&serverTimezone=JST";
		String user = "b887e48668536b";
		String pass = "6c9e7bf9";

//		String url = "jdbc:mysql://localhost:3306/example?useSSL=false&characterEncoding=UTF-8&serverTimezone=JST";
//		String user = "root";
//		String pass = "root";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, pass);
			DistributerDao dao = new DistributerDao(con);

			if( request.getAttribute("participant") != null) {
				participant = (Participant)request.getAttribute("participant");
			}else {

				if(dao.checkName(name)) {
					System.out.println(name);
					RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
					rd.forward(request, response);
					return;
				}

				participant.setId(dao.getId());
				participant.setPassword(newPassword);
				participant.setParticipantName(name);
				participant.setGrade(grade);
				System.out.println(newPassword);
				dao.registerParticipant(participant);
			}

		}catch (SQLException | ClassNotFoundException e ){
			e.printStackTrace();
		}

		request.setAttribute("participant", participant);
		RequestDispatcher rd = request.getRequestDispatcher("/check");
		rd.forward(request, response);
	}

}

