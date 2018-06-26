package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.Common;
import dao.UserDao;
import model.User;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		if(null == session.getAttribute("userInfo")) {
			response.sendRedirect("LoginServlet");
			return;
		}

		String id = request.getParameter("id");

		// 確認用：idをコンソールに出力
		System.out.println(id);



		//   未実装：idを引数にして、idに紐づくユーザ情報を出力する

		UserDao userDao = new UserDao();
		User user = userDao.findByLoginInfo1(id);

		request.setAttribute("userInfo2", user);


		// フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/update.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // リクエストパラメータの文字コードを指定
        request.setCharacterEncoding("UTF-8");

		String idData = request.getParameter("id");
		String nameData = request.getParameter("name");
		String loginIdData = request.getParameter("loginId");
		String passwordData = request.getParameter("password");
		String passwordDataA = request.getParameter("passwordA");
		String birthDateData = request.getParameter("birthDate");

		// 確認用：idをコンソールに出力
		System.out.println(idData);

		if(!passwordData.equals(passwordDataA)) {
			request.setAttribute("errMsg3", "確認用パスワードが異なります。");

			User user = new User();
			user.setId(Integer.parseInt(idData));
			user.setLoginId(loginIdData);
			user.setName(nameData);
			user.setBirthDate(Common.convertDate(birthDateData));
			request.setAttribute("userInfo2", user);

			//新規登録画面にフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/update.jsp");
			dispatcher.forward(request, response);
			return;

		}

		UserDao userDao = new UserDao();
		boolean result = userDao.userUpdate(idData,passwordData,nameData,birthDateData);

		if(result == false) {
			request.setAttribute("errMsg2", "入力された内容は正しくありません。");

			User user = new User();
			user.setId(Integer.parseInt(idData));
			user.setLoginId(loginIdData);
			user.setName(nameData);
			user.setBirthDate(Common.convertDate(birthDateData));
			request.setAttribute("userInfo2", user);

			//新規登録画面にフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/update.jsp");
			dispatcher.forward(request, response);
			return;
		}

		response.sendRedirect("UserListServlet");



	}

}
