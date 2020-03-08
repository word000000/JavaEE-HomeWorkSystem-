package code.servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author:GQM
 * @Date:created in 8:46 2020/3/5
 * @Description:
 * @Modifyed_By:
 */

//HttpServlet实现了http请求
public class Test_Servlet_V2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String myHeader = req.getParameter("myheader");
        resp.getWriter().println("hello Servlet v2 "+myHeader);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String param = req.getParameter("param");
        resp.getWriter().println("hello Servlet v2 post "+param);
    }
}
