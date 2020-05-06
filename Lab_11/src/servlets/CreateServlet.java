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

@WebServlet("/create")
public class CreateServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/secret/create.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String newspapernumber = request.getParameter("newspapernumber");
            HttpSession session = request.getSession(true);
            Newspaper newspaper = new Newspaper(1,newspapernumber, Integer.parseInt(session.getAttribute("iduser").toString()));
            NewspaperDao newspaperDao = new NewspaperDao();
            newspaperDao.addNewspaper(newspaper);
            response.sendRedirect(request.getContextPath()+"/welcome");
        }
        catch(Exception ex) {
            getServletContext().getRequestDispatcher("/secret/create.jsp").forward(request, response);
        }
    }
}
