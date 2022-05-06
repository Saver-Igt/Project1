package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.User;
@SuppressWarnings("serial")
@WebServlet("/registretion")
public class Registration extends HttpServlet {
  
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
            user.getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
