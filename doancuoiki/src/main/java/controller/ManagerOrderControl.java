package controller;

import Dao.Dao;
import model.Hash;
import model.Order;
import model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ManagerOrderControl", value = "/managerOrder")
public class ManagerOrderControl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Dao dao = new Dao();
        String status = request.getParameter("status");
        if (status != null && status.equals("authenticated")) {
            Hash hashObject = new Hash();
            List<Order> lists = dao.getListOrderAuthenticated();
            request.setAttribute("list",lists);
            request.setAttribute("hashObject", hashObject);
            request.getRequestDispatcher("ManagerOrder.jsp").forward(request,response);
        }else if(status != null && status.equals("notYetAuthenticated")){
            Hash hashObject = new Hash();
            List<Order> lists = dao.getListOrderNotYetAuthenticated();
            request.setAttribute("list",lists);
            request.setAttribute("hashObject", hashObject);
            request.getRequestDispatcher("ManagerOrder.jsp").forward(request,response);
        } else {
            Hash hashObject = new Hash();
            List<Order> list = dao.getListOrder();
            request.setAttribute("list",list);
            request.setAttribute("hashObject", hashObject);
            request.getRequestDispatcher("ManagerOrder.jsp").forward(request,response);
        }



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
