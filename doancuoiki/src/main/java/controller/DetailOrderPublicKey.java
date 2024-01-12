package controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DetailOrderPublicKey", value = "/detailOrderPublicKey")
public class DetailOrderPublicKey extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String cid = request.getParameter("cid");
            request.setAttribute("cid",cid);
             request.getRequestDispatcher("DetailOrderPublickey.jsp").forward(request, response);
//        PrintWriter out = response.getWriter();
//             out.println(cid);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
