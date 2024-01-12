package controller;

import Dao.Dao;
import model.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

@WebServlet(name = "OrderConfirmation", value = "/orderConfirmation")
public class OrderConfirmation extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Dao dao = new Dao();
//        String cid = request.getParameter("cid");
//        Order order = dao.getOrderById(cid);
//        Customer customer = dao.getCustomerByOrderId(order.getCustomer_id());
//        String invoice = order.toString();
//        KeyPair keyPair;



//        try {
//            keyPair = InvoiceSigning.generateKeyPair();
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//        try {
//            String signedInvoice = InvoiceSigning.sign(invoice, keyPair.getPrivate());
//            String publickey = Base64.getEncoder().encodeToString(keyPair.getPublic().getEncoded());
//            dao.private_key(signedInvoice,cid);
//            sendMail.send(customer.getEmail(),"private_key","", SecurityMail.USER,SecurityMail.PASS);

//            PrintWriter out = response.getWriter();
//            out.println(customer.getNum_phone());
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }


    }

        @Override
        protected void doPost (HttpServletRequest request, HttpServletResponse response) throws
        ServletException, IOException {
            String privateKeyBase64 = request.getParameter("privatekey");
            String cid = request.getParameter("cid");
            String active = "1";
            Dao dao = new Dao();
            Order order = dao.getOrderByID(Integer.parseInt(cid));
            String data = order.toString();
            String publickey = order.getPublic_key();
            PrivateKey restoredPrivateKey = InvoiceSigning.privateKeyFromBase64(privateKeyBase64);
                String signedInvoice = InvoiceSigning.signData(restoredPrivateKey,data);
                dao.signedInvoice(signedInvoice,cid);
                dao.updateAuthenticated(active,cid);
                request.setAttribute("publickey",publickey);
                request.setAttribute("cid",cid);
                request.setAttribute("signedInvoice",signedInvoice);
                request.getRequestDispatcher("successfully_authenticated.jsp").forward(request,response);
//                PrintWriter out = response.getWriter();
//                out.println(signedInvoice);



            PrintWriter out = response.getWriter();
            out.println(data);
        }
    }
