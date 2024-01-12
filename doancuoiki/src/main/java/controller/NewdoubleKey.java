package controller;

import Dao.Dao;
import model.InvoiceSigning;
import model.SecurityMail;
import model.sendMail;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;

@WebServlet(name = "NewdoubleKey", value = "/newdoubleKey")
public class NewdoubleKey extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cid = request.getParameter("cid");
//        PrintWriter out = response.getWriter();
//        out.println(cid);
        request.setAttribute("cid",cid);
        request.getRequestDispatcher("NewdoubleKey.jsp").forward(request, response);// vẫn tiếp tục đẩy lên trang home
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}

