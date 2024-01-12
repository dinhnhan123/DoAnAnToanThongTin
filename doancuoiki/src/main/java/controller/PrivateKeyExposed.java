package controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "PrivateKeyExposed", value = "/privateKeyExposed")
public class PrivateKeyExposed extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sessions = request.getSession();
        String account = sessions.getAttribute("acc").toString();
        int startIndex4 = account.indexOf("id=") + 3; // Tìm vị trí bắt đầu của id
        int endIndex4 = account.indexOf(",", startIndex4); // Tìm vị trí kết thúc của id
        String idString = account.substring(startIndex4, endIndex4); // Trích xuất id từ chuỗi
        int id = Integer.parseInt(idString); // Chuyển đổi id từ kiểu chuỗi sang kiểu số nguyên
        request.setAttribute("cid",id);
        request.getRequestDispatcher("NotificationPrivateKeyExposed.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
