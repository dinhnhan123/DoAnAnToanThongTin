package controller;

import Dao.Dao;
import model.Account;
import model.Category;
import model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "manager", value = "/manager")
public class ManagerControl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // mình đã lưu Account trên session nên giờ phải lấy xuống bằng cách
        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("acc"); // vì khi getAttribute
        // thì nó sẽ trả về kiểu String nên mình ép về object lúc này account của mình sẽ là một object mà mình đã lưu trên session
        int id = a.getId(); // vì mình get từ trên session về nên nó là kiểu int bình thường
        Dao dao = new Dao();
        List<Product> list = dao.getProductBySellID(id);
        List<Category> listC = dao.getAllCategory();

        request.setAttribute("list",list);
        request.setAttribute("listCC",listC);
        request.getRequestDispatcher("ManagerProduct.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
