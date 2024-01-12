package controller;

import Dao.Dao;
import model.Account;
import model.Hash;
import model.InvoiceSigning;
import model.Order;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ManagerAccount", value = "/managerAccount")
public class ManagerAccount extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Dao dao = new Dao();
        String status = request.getParameter("status");
        if (status != null && status.equals("not_the_owner")) {
            List<Account> lists = dao.getListAccountNotTheOwner();
            request.setAttribute("list",lists);
            request.getRequestDispatcher("ManagerAccount.jsp").forward(request,response);
        }else if(status != null && status.equals("the_owner")){
            List<Account> listd = dao.getListAccountTheOwner();
            request.setAttribute("list",listd);
            request.getRequestDispatcher("ManagerAccount.jsp").forward(request,response);
        } else {
            List<Account> list = dao.getListAccount();
            request.setAttribute("list",list);
            request.getRequestDispatcher("ManagerAccount.jsp").forward(request,response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
