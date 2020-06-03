package servlets;

import com.sun.messaging.jms.Session;

import javax.annotation.Resource;
import javax.jms.*;
import javax.naming.InitialContext;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ServletSendMOM")
public class ServletSendMOM extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try
        { //создать соединение
            InitialContext ctx = new InitialContext();
            QueueConnectionFactory f=
                    (QueueConnectionFactory)ctx.lookup("java:comp/DefaultJMSConnectionFactory");
            QueueConnection con=f.createQueueConnection();
            con.start();
//2) создать queue session
            QueueSession session=
                    con.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
//3) получить Queue object
            Queue queue=(Queue)ctx.lookup("MainQueue");
//4)создать QueueSender object
            QueueSender sender=session.createSender(queue);
//5) создатть TextMessage object
            TextMessage msg=session.createTextMessage();
//7) послать
            msg.setText("Button clicked in web app");
            sender.send(msg);
            System.out.println("Message successfully sent.");
//8) закрыть
            con.close();
        }catch(Exception e){System.out.println(e);}
    }
}


//@WebServlet("/ServletSendMOM")
//public class ServletSendMOM extends HttpServlet {
//
//    @Resource(lookup ="java:comp/DefaultJMSConnectionFactory") // JNDI name
//            ConnectionFactory factory;
//    @Resource(lookup = "MainQueue")
//    Queue queue;
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        try( JMSContext context = factory.createContext("admin","admin")){
//            JMSProducer producer = context.createProducer();
//            producer.send(queue,"Button clicked in web app");
//            System.out.println("button clicked");
//            req.getRequestDispatcher("/login.jsp").forward(req,resp);
//        }
//    }
//}