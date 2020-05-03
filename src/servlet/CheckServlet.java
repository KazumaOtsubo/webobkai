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

		if(request.getAttribute("participant") != null) {
			System.out.println("not null");
			participant = (Participant)request.getAttribute("participant");
			password = participant.getPassword();
			name = participant.getParticipantName();

		}else {
			System.out.println("null");
			password = request.getParameter("password");
			name = request.getParameter("name");
			participant = new Participant();
		}
//		cookies = request.getCookies();

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

			for(Participant p : participants) {
				System.out.println(Integer.toString(p.getId()));
			}
//			if(cookies != null) {
//				for(int i = 0; i < cookies.length; i++) {
//					if(cookies[i].getName().equals("number")) {
//						//一回来たことある人だから別の登録はしない
//						System.out.println("has visited");
//
//						int number = Integer.parseInt(cookies[i].getValue());
//						participant = dao.getParticipant(number);
//						request.setAttribute("message", "複数回目のアクセスです");
//						toNext(request, response);
//
//						return;
//					}
//				}
//			}
			participants = dao.findAll();

						//ユーザー取得
			participant = dao.getParticipant(name);

			//パスワードチェック
			if(!password.equals(participant.getPassword()) || participant.getDeleteflag()==1) {
				System.out.println("password check");
				RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
				rd.forward(request, response);
				return;
			}

			//ROOM A
			//部屋を取得
			if(dao.countRoomNumber("A") < 6 ) {
				participant.setRoomNumber("A");
				dao.setNumber(participant);
				//ホストの設定
				if(String.valueOf(dao.findMinId("A"))==null ||participant.getId() == dao.findMinId("A")) {
					dao.setHost(participant);
					request.setAttribute("host",1);
					System.out.println("hostA : "+ participant.getParticipantName());
				}
				//参加者全員を取得
				participants = dao.findAll();
			}else if(participant.getRoomNumber() != null && participant.getRoomNumber() .equals("A")) {
				if(dao.countRoomNumber("A") -1 < 6) {
					participant.setRoomNumber("A");
					dao.setNumber(participant);
					//ホストの設定
					if(String.valueOf(dao.findMinId("A"))==null ||participant.getId() == dao.findMinId("A")) {
						dao.setHost(participant);
						request.setAttribute("host",1);
						System.out.println("hostA : "+ participant.getParticipantName());
					}
				}
				//参加者全員を取得
				participants = dao.findAll();


			//ROOM B
			}else if(dao.countRoomNumber("B") < 6) {
				participant.setRoomNumber("B");
				dao.setNumber(participant);
				//ホストの設定
				System.out.println(String.valueOf(dao.findMinId("B")) +"+"+  participant.getId());
				if(String.valueOf(dao.findMinId("B"))==null ||participant.getId() == dao.findMinId("B")) {
					dao.setHost(participant);
					request.setAttribute("host",1);
					System.out.println("hostB : "+ participant.getParticipantName());
				}
				//参加者全員を取得
				participants = dao.findAll();

			}else if(participant.getRoomNumber() != null && participant.getRoomNumber() .equals("B")) {
				if(dao.countRoomNumber("B") -1 < 6) {
					participant.setRoomNumber("B");
					dao.setNumber(participant);
					//ホストの設定
					System.out.println(String.valueOf(dao.findMinId("B")) +"++"+  participant.getId());
					if(String.valueOf(dao.findMinId("B"))==null ||participant.getId() == dao.findMinId("B")) {
						dao.setHost(participant);
						request.setAttribute("host",1);
						System.out.println("hostB : "+ participant.getParticipantName());
					}
				}
				//参加者全員を取得
				participants = dao.findAll();


			//ROOM C
			}else if(dao.countRoomNumber("C") < 6) {
				participant.setRoomNumber("C");
				dao.setNumber(participant);
				//ホストの設定
				if(String.valueOf(dao.findMinId("C"))==null ||participant.getId() == dao.findMinId("C")) {
					dao.setHost(participant);
					request.setAttribute("host",1);
					System.out.println("hostC : "+ participant.getParticipantName());
				}
				//参加者全員を取得
				participants = dao.findAll();

			}else if(participant.getRoomNumber() != null && participant.getRoomNumber() .equals("C")) {
				if(dao.countRoomNumber("C") -1 < 6) {
					participant.setRoomNumber("C");
					dao.setNumber(participant);
					//ホストの設定
					if(String.valueOf(dao.findMinId("C"))==null ||participant.getId() == dao.findMinId("C")) {
						dao.setHost(participant);
						request.setAttribute("host",1);
						System.out.println("hostC : "+ participant.getParticipantName());
					}
				}
				//参加者全員を取得
				participants = dao.findAll();

			//ROOM D
			}else if(dao.countRoomNumber("D") < 6) {
				participant.setRoomNumber("D");
				dao.setNumber(participant);
				//ホストの設定
				if(String.valueOf(dao.findMinId("D"))==null ||participant.getId() == dao.findMinId("D")) {
					dao.setHost(participant);
					request.setAttribute("host",1);
					System.out.println("hostD : "+ participant.getParticipantName());
				}
				//参加者全員を取得
				participants = dao.findAll();

			}else if(participant.getRoomNumber() != null && participant.getRoomNumber() .equals("D")) {
				if(dao.countRoomNumber("D") -1 < 6) {
					participant.setRoomNumber("D");
					dao.setNumber(participant);
					//ホストの設定
					if(String.valueOf(dao.findMinId("D"))==null ||participant.getId() == dao.findMinId("D")) {
						dao.setHost(participant);
						request.setAttribute("host",1);
						System.out.println("hostD : "+ participant.getParticipantName());
					}
				}
				//参加者全員を取得
				participants = dao.findAll();


				//ROOM E
			}else if(dao.countRoomNumber("E") < 6) {
				participant.setRoomNumber("E");
				dao.setNumber(participant);
				//ホストの設定
				if(dao.findMinId("E") == 0 ||participant.getId() == dao.findMinId("E")) {
					dao.setHost(participant);
					request.setAttribute("host",1);
					System.out.println("hostE : "+ participant.getParticipantName());
				}
				//参加者全員を取得
				participants = dao.findAll();

			}else if(participant.getRoomNumber() != null && participant.getRoomNumber() .equals("E")) {
				if(dao.countRoomNumber("E") -1 < 6 ) {
					participant.setRoomNumber("E");
					dao.setNumber(participant);
					//ホストの設定
					if(String.valueOf(dao.findMinId("E"))==null ||participant.getId() == dao.findMinId("E")) {
						dao.setHost(participant);
						request.setAttribute("host",1);
						System.out.println("hostE : "+ participant.getParticipantName());
					}
				}
				//参加者全員を取得
				participants = dao.findAll();

				//ROOM F
			}else if(dao.countRoomNumber("F") < 6) {
				participant.setRoomNumber("F");
				dao.setNumber(participant);
				//ホストの設定
				if(String.valueOf(dao.findMinId("F"))==null ||participant.getId() == dao.findMinId("F")) {
					dao.setHost(participant);
					request.setAttribute("host",1);
					System.out.println("hostF : "+ participant.getParticipantName());
				}
				//参加者全員を取得
				participants = dao.findAll();

			}else if(participant.getRoomNumber() != null && participant.getRoomNumber() .equals("F")) {
				if(dao.countRoomNumber("F") -1 < 6 ) {
					participant.setRoomNumber("F");
					dao.setNumber(participant);
					//ホストの設定
					if(String.valueOf(dao.findMinId("F"))==null ||participant.getId() == dao.findMinId("F")) {
						dao.setHost(participant);
						request.setAttribute("host",1);
						System.out.println("hostF : "+ participant.getParticipantName());
					}
				}
				//参加者全員を取得
				participants = dao.findAll();


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

