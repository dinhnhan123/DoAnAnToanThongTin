package controller;

import Dao.Dao;
import model.Category;
import model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "loadProduct", value = "/loadProduct")
public class LoadControl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String id = request.getParameter("pid");
            Dao dao = new Dao();
            Product p =  dao.getProductByID(id);
            List<Category> listC = dao.getAllCategory();
            request.setAttribute("detail" , p);
            request.setAttribute("listCC",listC);
            request.getRequestDispatcher("Edit.jsp").forward(request,response);
//        response.sendRedirect("Edit.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
