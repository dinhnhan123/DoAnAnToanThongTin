package controller;

import Dao.Dao;
import model.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static model.InvoiceSigning.generateKeyPair;


@WebServlet(name = "OrderControl", value = "/order")
public class OrderControl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        Dao dao = new Dao();
        String fullname = request.getParameter("fullname");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String num_phone = request.getParameter("num_phone");
        String note = request.getParameter("note");
        String data = fullname+email+num_phone;
        String privateKeyy = request.getParameter("privateKey");
        PrivateKey restoredPrivateKey = InvoiceSigning.privateKeyFromBase64(privateKeyy);
        String signatureNew = InvoiceSigning.signData(restoredPrivateKey,data);
        HttpSession sessions = request.getSession();
        String account = sessions.getAttribute("acc").toString();

        // Kiểm tra xem account có tồn tại trong session không
        if (account != null) {
            // Sử dụng thông tin account ở đây
            int startIndex = account.indexOf("signature=");

            // Tìm dấu bằng và "{" gần vị trí của "signature"
            startIndex = account.indexOf("=", startIndex) + 1;
            int endIndex = account.indexOf(",", startIndex);

            // Lấy giá trị của "signature" từ chuỗi
            String signature = account.substring(startIndex, endIndex);
            int startIndex2 = account.indexOf("publicKey=");
            startIndex2 = account.indexOf("=", startIndex2) + 1;
            int endIndex2 = account.indexOf(",", startIndex2);
            String publicKey = account.substring(startIndex2, endIndex2);

//            Account account1 = dao.getSignatureOld(id);
//            String str = account1.toString()
            if(signature.equals(signatureNew)){
                int id_customer = dao.insert_customer(fullname, email, address, num_phone, note);
                // Lấy hoặc tạo mới một phiên
                HttpSession session = request.getSession();

                // Lấy giỏ hàng từ phiên (nếu tồn tại)
                Order order = (Order) session.getAttribute("order");
                // Lưu thông tin giỏ hàng vào cơ sở dữ liệu
                if (order != null) {
                    // Lấy danh sách các mặt hàng trong giỏ hàng
                    List<Item> items = order.getItems();
                    int total_amount = 0;
                    int total_product_quantity = 0;
                    String order_code = order.generateOrderCode();
                    String payment_method = request.getParameter("payment_method");
                    for (Item item : items) {
                        total_amount+=item.getPrice()*item.getQuantity();
                        total_product_quantity+=item.getQuantity();
                    }
                    int order_id = dao.insertOder(id_customer,total_amount,total_product_quantity,payment_method,address,order_code,fullname);
                    String active = "1";
                    dao.updateAuthenticated(active, String.valueOf(order_id));
                    for (Item item : items) {
                        dao.insert_order_item(order_id,item.getProduct().getId(),item.getQuantity(),(int) (item.getQuantity()*item.getPrice()));
//                PrintWriter out = response.getWriter();
//                out.println("<h1>Hello, " + order_id  + "id:"+item.getProduct().getId()+"quntity"+item.getQuantity()+"price"+ (int) (item.getQuantity()*item.getPrice())+"</h1>");
                    }
//
//
                    Customer customer = dao.getCustomerByOrderId(id_customer);
                    Order orders = dao.getOrderByID(order_id);
                    String orderStr = orders.toString();
                    try {
                        // Tính toán mã băm cho thông tin đơn hàng
                        String hashedValue = Hash.calculateHash(orderStr);
                        dao.hashedValueOld(hashedValue,order_id);
                    } catch (NoSuchAlgorithmException e) {
                        e.printStackTrace();
                    }

                    KeyPair keyPair = InvoiceSigning.generateKeyPair();
                    PrivateKey privateKey = keyPair.getPrivate();
//                    PublicKey publicKey = keyPair.getPublic();
                    String privateKeyBase64 = InvoiceSigning.privateKeyToBase64(privateKey);
//                    String publicKeyBase64 = InvoiceSigning.publicKeyToBase64(publicKey);
//                    dao.public_key(publicKeyBase64, order_id);
//
                    String link = "http://localhost:8080/doancuoiki/detailOrderPublicKey?cid="+order_id;
                    String message = "Thank you for your purchase : " + publicKey +" "+
                            "Please click here to:  <a href='" + link + "'>XAC THUC</a>";

//            PrintWriter out = response.getWriter();
//             out.println("<h1>Hello, " + privateKeyBase64  + "</h1>");
                sendMail.send("dinhnhanpp@gmail.com","Xac Thuc Don Hang",message, SecurityMail.USER,SecurityMail.PASS);
                    response.sendRedirect("SendEmail.jsp");

//            PrintWriter out = response.getWriter();
//            out.println("total_amount: " + total_amount + ", total_product_quantity: " + total_product_quantity + "<br>" +order_code);
                } else {
                    PrintWriter out = response.getWriter();
                    out.println("Cart is empty");
                }

                PrintWriter out = response.getWriter();
                out.println("ok");
            }else {
                PrintWriter out = response.getWriter();
                int startIndex4 = account.indexOf("id=") + 3; // Tìm vị trí bắt đầu của id
                int endIndex4 = account.indexOf(",", startIndex4); // Tìm vị trí kết thúc của id

                String idString = account.substring(startIndex4, endIndex4); // Trích xuất id từ chuỗi

                int id = Integer.parseInt(idString); // Chuyển đổi id từ kiểu chuỗi sang kiểu số nguyên

                request.setAttribute("cid",id);
                request.getRequestDispatcher("errorKey.jsp").forward(request, response);// vẫn tiếp tục đẩy lên trang home
//                out.println("PrivateKey không hợp lệ, vui lòng quay lại <a href='#'>Trang chủ</a> hoặc tạo <a href='newdoubleKey?cid=" + id + "'>key mới</a>");
            }

        } else {
            PrintWriter out = response.getWriter();
            out.println("Không tìm thấy");
        }





    }

    }








