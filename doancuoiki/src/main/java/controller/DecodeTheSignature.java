package controller;

import Dao.Dao;
import model.InvoiceSigning;
import model.Order;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

@WebServlet(name = "DecodeTheSignature", value = "/decodeTheSignature")
public class DecodeTheSignature extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String Publickey = request.getParameter("Publickey");
        String cid = request.getParameter("cid");
//        PrintWriter outs= response.getWriter();
//        outs.println(cid);
        HttpSession sessions = request.getSession();
        String account = sessions.getAttribute("acc").toString();
        int startIndex = account.indexOf("signature=");
        // Tìm dấu bằng và "{" gần vị trí của "signature"
        startIndex = account.indexOf("=", startIndex) + 1;
        int endIndex = account.indexOf(",", startIndex);
        // Lấy giá trị của "signature" từ chuỗi
        String signature = account.substring(startIndex, endIndex);
        int startIndex2 = account.indexOf("data=");
        startIndex2 = account.indexOf("=", startIndex2) + 1;
        int endIndex2 = account.indexOf("}", startIndex2);
        String dataa = account.substring(startIndex2, endIndex2);
//        PrintWriter outs= response.getWriter();
//        outs.println(dataa);
//        PrintWriter outs= response.getWriter();
//        outs.println(account);
        Dao dao = new Dao();
        PublicKey restoredPublicKey = InvoiceSigning.publicKeyFromBase64(Publickey);
//        PrintWriter out = response.getWriter();
//        out.println(data);
        boolean isSignatureValid = InvoiceSigning.verifySignature(restoredPublicKey, dataa, signature);
        if (isSignatureValid) {
            String valid_signature = "Chữ ký hợp lệ";
//            PrintWriter out = response.getWriter();
//            out.println(valid_signature);
            request.setAttribute("valid_signature",valid_signature);
            request.setAttribute("cid",cid);
            request.getRequestDispatcher("valid_signature.jsp").forward(request,response);

        } else {
            PrintWriter out = response.getWriter();
            out.println("Signature is invalid.");

        }


    }
}
