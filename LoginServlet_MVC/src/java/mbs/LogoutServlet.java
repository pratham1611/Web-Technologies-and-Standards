/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mbs;
import java.sql.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import java.sql.*;


/**
 *
 * @author Prathamesh Marathe
 */
public class LogoutServlet extends HttpServlet {
     protected void doGet(HttpServletRequest request, HttpServletResponse response)  
                                throws ServletException, IOException { 
         try{
           // response.setContentType("text/html");  
            //PrintWriter out=response.getWriter();  
              
            //request.getRequestDispatcher("JSP2.jsp").include(request, response);  
              
            HttpSession session=request.getSession(false);  
             myBean bean=null;
            bean=(myBean)session.getAttribute("ub"); //Fetching the ub object set in Servlet1
            String name=bean.getName();
            session.invalidate();  //to force user logout
           
            
              //String name=request.getParameter("test");
               ResultSet rs=null;
                Connection conn = null;
         Statement stmt = null;
        String DB_URL="jdbc:derby://localhost:1527/Assignment3";

      //  Database credentials
      String USER = "pratham";
      String PASS = "pratham";
      //Class.forName("com.mysql.jdbc.Driver");
      conn = DriverManager.getConnection(DB_URL,USER,PASS);
       stmt =(Statement) conn.createStatement();
       String sql;
       sql="UPDATE PRATHAM.LOGIN SET STATUS='D' WHERE USERNAME='"+name+"'"; //Connecting to databbase and setting status D for that particular user
        stmt.executeUpdate(sql);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/Logout.jsp"); //Redirecting to Logout.jsp
            rd.forward(request, response);
         }
         catch(Exception e)
         {
             e.toString();
         }
         
              
            //out.print("You are successfully logged out!");  
              
            //out.close();  
    }  
    
}
