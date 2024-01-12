package controller;

import model.SecurityMail;
import model.sendMail;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SendMailNewKey", value = "/sendMailNewKey")
public class SendMailNewKey extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String cid = request.getParameter("cid");
        String link = "http://localhost:8080/doancuoiki/createNewKeyControl?cid=" + cid;
        String sub = "<p> Ban vui long nhan vao day de xac thuc  <a href='" + link + "'>XAC THUC</a></p>";
        sendMail.send(email,"Xac Thuc Tai Khoan",sub, SecurityMail.USER,SecurityMail.PASS);
        response.sendRedirect("CheckAccount.jsp");
    }
}
