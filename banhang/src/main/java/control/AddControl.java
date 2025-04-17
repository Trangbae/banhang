/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.DAO;
import context.Account;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "AddControl", urlPatterns = {"/add"})
public class AddControl extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        // ... (các dòng code khác)

        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("acc");

        // Kiểm tra xem biến a có giá trị hay không
        if (a != null) {
            int sid = a.getId();
            DAO dao = new DAO();
            dao.insertProduct("name", "image", "price", "title", "description", "category", sid);
            response.sendRedirect("manager");
        } else {
            // Xử lý khi biến a là null
            response.sendRedirect("login.jsp"); // Chẳng hạn chuyển hướng đến trang đăng nhập
        }
    }


   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}