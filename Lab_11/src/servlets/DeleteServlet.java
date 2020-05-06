package servlets;

import connection.NewspaperDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            NewspaperDao newspaperDao = new NewspaperDao();
            int id = Integer.parseInt(request.getParameter("id"));
            newspaperDao.delete(id);
            response.sendRedirect(request.getContextPath() + "/welcome");
        }
        catch(Exception ex) {
            getServletContext().getRequestDispatcher("/Error.jsp").forward(request, response);
        }
    }
}