package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DistributerDao;
import model.Participant;

/**
 * Servlet implementation class CheckServlet
 */
@WebServlet("/check")
public class CheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor.
     */
    public CheckServlet() {
        // TODO Auto-generated constructor stub
    }

    String password ="";
	String name ="";
	Cookie[] cookies;
	Participant participant = new Participant();
	List<Participant> participants = new ArrayList<Participant>();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("utf-8");

		password = request.getParameter("password");
		name = request.getParameter("name");
		cookies = request.getCookies();
		participant = new Participant();
		participants = new ArrayList<Participant>();

		if(!password.equals("2020webobkai")) {
			RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
			rd.forward(request, response);
			return;
		}

		String url = "jdbc:mysql://localhost:3306/example?useSSL=false&characterEncoding=UTF-8&serverTimezone=JST";
		String user = "root";
		String pass = "root";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, pass);

			System.out.println("kokomade");

			DistributerDao dao = new DistributerDao(con);

			//参加者全員を取得
			participants = dao.findAll();

			if(cookies != null) {
				for(int i = 0; i < cookies.length; i++) {
					if(cookies[i].getName().equals("number")) {
						//一回来たことある人だから別の登録はしない
						System.out.println("has visited");

						int number = Integer.parseInt(cookies[i].getValue());
						participant = dao.getParticipant(number);
						request.setAttribute("message", "複数回目のアクセスです");
						toNext(request, response);

						return;
					}
				}
			}

			//部屋を取得
			int yourNumber = dao.getNumber();
			if(dao.countRoomNumber("A")< 5) {
				participant.setNumber(yourNumber);
				participant.setParticipantName(name);
				participant.setRoomNumber("A");
				//参加者登録
				dao.registerParticipant(participant);
				Cookie cookie = new Cookie("number", String.valueOf(yourNumber));
				response.addCookie(cookie);

			}else if(dao.countRoomNumber("B")< 5) {
				participant.setNumber(yourNumber);
				participant.setParticipantName(name);
				participant.setRoomNumber("B");
				//参加者登録
				dao.registerParticipant(participant);
				Cookie cookie = new Cookie("number", String.valueOf(yourNumber));
				response.addCookie(cookie);

			}else if(dao.countRoomNumber("C")< 5) {
				participant.setNumber(yourNumber);
				participant.setParticipantName(name);
				participant.setRoomNumber("C");
				//参加者登録
				dao.registerParticipant(participant);
				Cookie cookie = new Cookie("number", String.valueOf(yourNumber));
				response.addCookie(cookie);

			}else if(dao.countRoomNumber("D")< 5) {
				participant.setNumber(yourNumber);
				participant.setParticipantName(name);
				participant.setRoomNumber("D");
				//参加者登録
				dao.registerParticipant(participant);
				Cookie cookie = new Cookie("number", String.valueOf(yourNumber));
				response.addCookie(cookie);

			}else {
						request.setAttribute("error","定員オーバーしています。");
			}

			}catch (SQLException | ClassNotFoundException e ){
				e.printStackTrace();
			}

		toNext(request, response);
	}

	public void toNext(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエストセッションに参加者情報を登録
		request.setAttribute("participants", participants);
		request.setAttribute("participant", participant);
		//displayへ遷移
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/display.jsp");
		rd.forward(request, response);
	}

}

