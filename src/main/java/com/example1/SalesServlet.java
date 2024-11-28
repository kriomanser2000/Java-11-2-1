package com.example1;

import com.example1.dao.SellerDAO;
import com.example1.entities.Seller;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/addSeller")
public class SalesServlet extends HttpServlet
{
    private SellerDAO sellerDAO = new SellerDAO();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String name = request.getParameter("sellerName");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        Seller seller = new Seller();
        seller.setSellerName(name);
        seller.setPhone(phone);
        seller.setEmail(email);
        sellerDAO.addSeller(seller);
        response.getWriter().println("Seller added successfully!");
    }
}