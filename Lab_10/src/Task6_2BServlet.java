import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Task6_2BServletTest")
public class Task6_2BServlet extends HttpServlet {

    public Task6_2BServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse
            response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        String str = "";
        try {
            str += request.getAttribute("Attribute1").toString() + "<br>";
        } catch (NullPointerException e) {
            str += "Attribute1 fail<br>";
        }
        try {
            ServletContext servletContext = getServletContext();
            str += servletContext.getAttribute("Attribute2").toString() + "<br>";
        } catch (NullPointerException e) {
            str += "Servlet fail<br>";
        }
        request.setAttribute("mystr2", str);
        request.getRequestDispatcher("index.jsp").
                forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse
            response)
            throws ServletException, IOException {
        response.setContentType("text/html");

    }
}