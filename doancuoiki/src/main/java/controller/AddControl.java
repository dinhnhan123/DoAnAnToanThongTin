package controller;

import Dao.Dao;
import model.Account;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "add", value = "/add")
public class AddControl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String pname = request.getParameter("name");
        String pimage = request.getParameter("image");
        int pprice = Integer.parseInt(request.getParameter("price"));
        String ptitle = request.getParameter("title");
        String pdescription= request.getParameter("description");
        int pcategory = Integer.parseInt(request.getParameter("category"));


        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("acc");
        int sid = a.getId();

        Dao dao = new Dao();
        dao.insertProduct(pname,pimage,pprice,ptitle,pdescription,pcategory,sid);
        response.sendRedirect("manager");
    }
}
