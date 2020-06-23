import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/Task6CServletTest")
public class Task6CServlet extends HttpServlet {

    public Task6CServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse
            response)
            throws ServletException, IOException {
        response.setContentType("text/html");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse
            response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        HttpSession session = request.getSession();
        session.setAttribute("Attribute3", "Task 6(session)");
        response.sendRedirect("Task6_2CServletTest");
    }
}