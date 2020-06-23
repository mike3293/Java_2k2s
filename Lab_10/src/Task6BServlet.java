import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/Task6BServletTest")
public class Task6BServlet extends HttpServlet {

    public Task6BServlet() {
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
        request.setAttribute("Attribute1", "Task 6(attribute)");
        ServletContext servletContext = getServletContext();
        servletContext.setAttribute("Attribute2", "Task 6(servlet)");
        response.sendRedirect("Task6_2BServletTest");
    }
}