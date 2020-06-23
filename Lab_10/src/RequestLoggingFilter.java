import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.ArrayList;

@WebFilter("/UserServlet")
public class RequestLoggingFilter implements Filter {

    public void init(FilterConfig arg0) throws ServletException {
    }

    public void doFilter(ServletRequest request, ServletResponse resp,
                         FilterChain chain) throws IOException, ServletException {

        String inputLogin = request.getParameter("Login");
        User cUser = null;
        DataBase db = new DataBase();
        ArrayList<User> users = db.GetUsers();
        for (User us : users) {
            if (us.name.equals(inputLogin)) {
                cUser = us;
                break;
            }
        }

        if (cUser == null) {
            request.getRequestDispatcher("index.jsp").
                    forward(request, resp);
        } else {
            chain.doFilter(request, resp);
        }
    }

    public void destroy() {
    }
}