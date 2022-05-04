package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.User;
@WebServlet("/registretion")
public class Registration extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        // База Данных
        User user = new User();
        try {
            user.connectToSQL();
        } catch (NamingException e) {
            e.printStackTrace();
        }
        user.createStatement();

        if(!user.checkForUniqueLogin(login)) {
            user.insertInBase(login, password);
            request.setAttribute("success", true);
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }else{

            request.getRequestDispatcher("Register.jsp").forward(request, response);
        }

        // Закрытие подключения к БД
        try {
            user.getStatement().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
