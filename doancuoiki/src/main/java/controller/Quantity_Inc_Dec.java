package controller;

import model.Item;
import model.Order;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "quantity-inc-dec", value = "/quantity-inc-dec")
public class Quantity_Inc_Dec extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        int id = Integer.parseInt(request.getParameter("id"));
        Order order = (Order) request.getSession().getAttribute("order");

        if (action != null && id >= 0) {
            if (action.equals("inc")) {
                List<Item> listItems = order.getItems();
                for (Item item : listItems) {
                    if (item.getProduct().getId() == id) {
                        int quantity = item.getQuantity();
                        quantity++;
                        item.setQuantity(quantity);
                        response.sendRedirect("Cart.jsp");
                    }
                }
            } else {
                if (action.equals("dec")) {
                    List<Item> listItems = order.getItems();
                    for (Item item : listItems) {
                        if (item.getProduct().getId() == id && item.getQuantity() > 1) {
                            int quantity = item.getQuantity();
                            quantity--;
                            item.setQuantity(quantity);
                            break;

                        }
                    }
                    response.sendRedirect("Cart.jsp");

                }
            }
        }else {
            response.sendRedirect("Cart.jsp");
        }

    }


        @Override
        protected void doPost (HttpServletRequest request, HttpServletResponse response) throws
        ServletException, IOException {

        }
    }


