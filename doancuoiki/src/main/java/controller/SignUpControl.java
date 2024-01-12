package controller;

import Dao.Dao;
import model.Account;
import model.SecurityMail;
import model.sendMail;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "signup", value = "/signup")
public class SignUpControl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        String email = request.getParameter("email");
        String re_pass = request.getParameter("repass");
        if(!pass.equals(re_pass)){
            request.setAttribute("mess","Mật khẩu bạn vừa nhập lại không khớp, vui lòng kiểm tra lại");
            request.getRequestDispatcher("Login.jsp").forward(request,response);

        }else{
             Dao dao = new Dao();
            Account a = dao.CheckUserExist(user);
             if(a == null){
              int id = dao.signUp(user,pass,email);
                 String link = "http://localhost:8080/doancuoiki/keyPairAccount?cid=" + id;
              String sub = "<p> Ban vui long nhan vao day de xac thuc  <a href='" + link + "'>XAC THUC</a></p>";

                 PrintWriter out = response.getWriter();
                out.println(id);
//              response.sendRedirect("homeControl");
                 sendMail.send(email,"Xac Thuc Tai Khoan",sub, SecurityMail.USER,SecurityMail.PASS);
                 response.sendRedirect("CheckAccount.jsp");

             }else {
              request.setAttribute("mess","Username đã tồn tại");
              request.getRequestDispatcher("Login.jsp").forward(request,response);

             }
        }

    }
}
