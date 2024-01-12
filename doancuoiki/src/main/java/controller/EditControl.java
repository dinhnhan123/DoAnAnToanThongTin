package controller;

import Dao.Dao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "edit", value = "/edit")
public class EditControl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        int pid = Integer.parseInt(request.getParameter("id"));
        String pname = request.getParameter("name");
        String pimage = request.getParameter("image");
        int pprice = Integer.parseInt(request.getParameter("price"));
        String ptitle = request.getParameter("title");
        String pdescription= request.getParameter("description");
        int pcategory = Integer.parseInt(request.getParameter("category"));

        Dao dao = new Dao();
        dao.editProduct(pname,pimage,pprice,ptitle,pdescription,pcategory,pid);
        response.sendRedirect("manager");

    }
}
