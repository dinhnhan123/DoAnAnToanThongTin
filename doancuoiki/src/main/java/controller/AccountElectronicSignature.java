package controller;

import Dao.Dao;
import model.InvoiceSigning;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.PrivateKey;

@WebServlet(name = "AccountElectronicSignature", value = "/accountElectronicSignature")
public class AccountElectronicSignature extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        Dao dao = new Dao();
        String cid = request.getParameter("cid");
        String fullname = request.getParameter("fullname");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String num_phone = request.getParameter("num_phone");
        String PrivateKey = request.getParameter("PrivateKey");
        String data = fullname+email+num_phone;
        PrivateKey restoredPrivateKey = InvoiceSigning.privateKeyFromBase64(PrivateKey);
        String signedInvoice = InvoiceSigning.signData(restoredPrivateKey,data);
        boolean success = dao.insertSignatureAccount(signedInvoice,cid);
        if (success) {
            String account_authenticated = "1";
            dao.update_account_authenticated(account_authenticated,cid);
            dao.update_data(data,cid);
            response.sendRedirect("AccountAuthenticationSuccessful.jsp");
        } else {
           PrintWriter out = response.getWriter();
                out.println("Update không thành công");

        }

//        PrintWriter out = response.getWriter();
//                out.println(ok);
    }
}
