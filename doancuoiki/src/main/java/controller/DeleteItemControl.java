package controller;

import model.Item;
import model.Order;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "deleteItem", value = "/deleteItem")
public class DeleteItemControl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String id = request.getParameter("pid");
            Order order = (Order) request.getSession().getAttribute("order");
            if(order!=null){
                List<Item> listItems = order.getItems();
                for(Item item : listItems){
                    if(item.getProduct().getId()== Integer.parseInt(id)){
                        listItems.remove(listItems.indexOf(item));
                        break;
                    }
                }
                response.sendRedirect("Cart.jsp");
            }else {
                response.sendRedirect("Cart.jsp");
            }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
