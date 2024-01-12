package controller;

import Dao.Dao;
import model.Customer;
import model.Order;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ManagerCustomerControl", value = "/managerCustomer")
public class ManagerCustomerControl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Dao dao = new Dao();
        List<Customer> list = dao.getListCustomer();
        request.setAttribute("list",list);
        request.getRequestDispatcher("ManagerCustomer.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
