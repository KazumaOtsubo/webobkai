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

/**
 * Servlet implementation class DleteServlet
 */
@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
		rd.forward(request, response);
		return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		if(request.getParameter("id") != null) {
			String url = "jdbc:mysql://us-cdbr-east-06.cleardb.net/heroku_791ec9286655973?useSSL=false&characterEncoding=UTF-8&serverTimezone=JST";
			String user = "b887e48668536b";
			String pass = "6c9e7bf9";

//			String url = "jdbc:mysql://localhost:3306/example?useSSL=false&characterEncoding=UTF-8&serverTimezone=JST";
//			String user = "root";
//			String pass = "root";
			int id = Integer.parseInt(request.getParameter("id"));
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection(url, user, pass);

				DistributerDao dao = new DistributerDao(con);

				dao.deleteParticipant(id);

//				Cookie cookies[] = request.getCookies();
//				if(cookies != null) {
//					for(int i = 0; i < cookies.length; i++) {
//
//						// クッキーの有効期間を0秒に設定する
//						cookies[i].setMaxAge(0);
//						response.addCookie(cookies[i]);
//					}
//				}
				RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
				rd.forward(request, response);
				return;
		}catch   (SQLException | ClassNotFoundException e ){
			e.printStackTrace();
		}
	}
	}
}
