package servlets;

import connection.Newspaper;
import connection.NewspaperDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/edit")
public class EditServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        NewspaperDao newspaperDao = null;
        try {
            newspaperDao = new NewspaperDao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Newspaper newspaper = newspaperDao.selectOne(id);
        if (newspaper != null) {
            request.setAttribute("newspaper", newspaper);
            getServletContext().getRequestDispatcher("/secret/edit.jsp").forward(request, response);
        } else {
            getServletContext().getRequestDispatcher("/Error.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        NewspaperDao newspaperDao = null;
        try {
            newspaperDao = new NewspaperDao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            int id = Integer.parseInt(request.getParameter("newspaperId"));
            int userid = Integer.parseInt(request.getParameter("userid"));
            String newspapernumber = request.getParameter("newspapernumber");
            Newspaper newspaper = new Newspaper(id, newspapernumber, userid);
            newspaperDao.update(newspaper);
            response.sendRedirect(request.getContextPath() + "/welcome");
        } catch (Exception ex) {
            getServletContext().getRequestDispatcher("/Error.jsp").forward(request, response);
        }
    }
}