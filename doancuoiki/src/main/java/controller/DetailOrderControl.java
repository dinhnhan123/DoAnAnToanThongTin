package controller;

import Dao.Dao;
import model.Item;
import model.Order;
import model.Order_item;
import model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "DetailOrderControl", value = "/detailOrder")
public class DetailOrderControl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String cid = request.getParameter("cid");
        Dao dao = new Dao();
        Order order =  dao.getOrderById(cid);
//        PrintWriter out = response.getWriter();
//        out.println(order.getShipping_address());
        List<Order_item> order_item = dao.getListProductByOrderId(cid);
        List<Integer> productIds = new ArrayList<>();
        List<Product> products = new ArrayList<>();

        for (Order_item item : order_item) {
            productIds.add(item.getProduct_id());
        }

        for (Integer productId : productIds) {
            Product product = dao.getProductByID(String.valueOf(productId));
            if (product != null) {
//                PrintWriter out = response.getWriter();
                products.add(product); // Thêm sản phẩm vào mảng products
            }
        }



         request.setAttribute("order",order);
        request.setAttribute("products",products);
        request.setAttribute("order_item",order_item);
        request.getRequestDispatcher("DetailOrder.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
