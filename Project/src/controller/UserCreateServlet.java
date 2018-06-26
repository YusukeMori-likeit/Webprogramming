package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Common;
import dao.UserDao;
import model.User;

/**
 * Servlet implementation class UserCreateServlet
 */
@WebServlet("/UserCreateServlet")
public class UserCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserCreateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/UserCreate.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        // リクエストパラメータの文字コードを指定
        request.setCharacterEncoding("UTF-8");

		// リクエストパラメータの入力項目を取得
		String loginId = request.getParameter("loginId");
		String password = request.getParameter("password");
		String passwordA =request.getParameter("passwordA");
		String name = request.getParameter("name");
		String birthdate = request.getParameter("birthdate");

		if(!password.equals(passwordA)) {
			request.setAttribute("errMsg", "確認用パスワードが異なります。");

			User user = new User();
			user.setLoginId(loginId);
			user.setName(name);
			user.setBirthDate(Common.convertDate(birthdate));
			request.setAttribute("user", user);

			//新規登録画面にフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/UserCreate.jsp");
			dispatcher.forward(request, response);
			return;
		}


		UserDao userDao = new UserDao();
		boolean result = userDao.userCreate(loginId,name,birthdate,password);

		if(result == false) {
			request.setAttribute("errMsg1", "ログインIDが重複しているか、入力された内容が正しくありません。");

			User user = new User();
			user.setLoginId(loginId);
			user.setName(name);
			user.setBirthDate(Common.convertDate(birthdate));
			request.setAttribute("user", user);

			//新規登録画面にフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/UserCreate.jsp");
			dispatcher.forward(request, response);
			return;
		}





		response.sendRedirect("UserListServlet");


	}

}
