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

@WebServlet(name = "sendirectPage", value = "/sendirectpage")
public class SendirectPageAdd extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Dao dao = new Dao();
        List<Category> listC = dao.getAllCategory();

        request.setAttribute("listCC",listC);
              request.getRequestDispatcher("AddProduct.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
