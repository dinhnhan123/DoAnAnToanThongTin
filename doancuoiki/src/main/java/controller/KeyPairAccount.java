package controller;

import Dao.Dao;
import model.InvoiceSigning;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;

@WebServlet(name = "KeyPairAccount", value = "/keyPairAccount")
public class KeyPairAccount extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Dao dao = new Dao();
        KeyPair keyPair = InvoiceSigning.generateKeyPair();
        PrivateKey privateKey = keyPair.getPrivate();
        PublicKey publicKey = keyPair.getPublic();
        String privateKeyBase64 = InvoiceSigning.privateKeyToBase64(privateKey);
        String publicKeyBase64 = InvoiceSigning.publicKeyToBase64(publicKey);
        String cid = request.getParameter("cid");
        dao.insertPublickey(publicKeyBase64,cid);
        request.setAttribute("cid",cid);
        request.setAttribute("privateKeyBase64",privateKeyBase64);
        request.getRequestDispatcher("KeyAuthentication.jsp").forward(request, response);
//        response.sendRedirect("KeyAuthentication.jsp");
//        PrintWriter out = response.getWriter();
//                out.println(privateKeyBase64 + " " +cid);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
