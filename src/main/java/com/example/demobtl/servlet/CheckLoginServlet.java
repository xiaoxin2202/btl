package com.example.demobtl.servlet;

import com.example.demobtl.dao.UserDAO;
import com.example.demobtl.model.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "CheckLoginServlet", value = "/CheckLoginServlet")
public class CheckLoginServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ServletContext context = getServletContext();
        String url = "/index.jsp";
        HttpSession session = request.getSession();

        if (!session.isNew()) {
            session.invalidate();
            session = request.getSession();
        }
        UserDAO userDAO = new UserDAO();
        String action = request.getParameter("action");
        System.out.println("action " + action);
        if (action.equals("checkLogin")) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            User user = new User();
            user.setUserName(username);
            user.setPassWord(password);

            boolean check = false;
            try {
                check = userDAO.checkLogin(user);
            } catch (SQLException ex) {
                Logger.getLogger(CheckLoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (check) {
                session.setAttribute("user", user);
                url="/Home.jsp";
            }
        }
        context.getRequestDispatcher(url).forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

}
