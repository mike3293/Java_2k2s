package servlets;

import connection.Newspaper;
import connection.NewspaperDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(value = "/welcome",name = "WelcomeServlet")
public class WelcomeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        NewspaperDao newspaperDao = null;
        try {
            newspaperDao = new NewspaperDao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ArrayList<Newspaper> newspapers = newspaperDao.select(Integer.parseInt(session.getAttribute("iduser").toString()));
        request.setAttribute("newspapers", newspapers);
        getServletContext().getRequestDispatcher("/secret/welcome.jsp").forward(request, response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        NewspaperDao newspaperDao = null;
        try {
            newspaperDao = new NewspaperDao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ArrayList<Newspaper> newspapers = newspaperDao.select(Integer.parseInt(session.getAttribute("iduser").toString()));
        request.setAttribute("newspapers", newspapers);
        getServletContext().getRequestDispatcher("/secret/welcome.jsp").forward(request, response);
    }
}
