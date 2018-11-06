
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



public class Servlet1 extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response,boolean flag)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       
        HttpSession session=request.getSession(true);
        myBean ub = new myBean();
        session.setAttribute("ub",ub);
        //depending on which form on index.jsp was used we login or register
        //failure returns to index.jsp, success spawns cw
        //the userbean is used to transfer information
       // if(request.getParameter("log")!=null)
            if(flag)
            {
            ub.setStatus("ACTIVE");
            ub.setName(request.getParameter("uname"));
            ub.setId(1);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/Home.jsp");
            rd.forward(request, response);
            }
            else{
            ub.setStatus("LOGIN FAILURE RETRY");
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/Failure.jsp");
            rd.forward(request, response);
           }
        
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        //processRequest(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        ResultSet rs=null;
        try{
            //System.out.println("Inside dopost()");
            boolean flag=false;
         Connection conn = null;
         Statement stmt = null;
        String DB_URL="jdbc:derby://localhost:1527/Assignment3";

      //  Database credentials
      String USER = "pratham";
      String PASS = "pratham";
      //Class.forName("com.mysql.jdbc.Driver");
      conn = DriverManager.getConnection(DB_URL,USER,PASS);
      
      String uname=request.getParameter("uname"); //sent from jsp
       String pwd = request.getParameter("pwd"); //sent from jsp
        //try {
            stmt =(Statement) conn.createStatement();
//        } //catch (SQLException ex) {
//            //Logger.getLogger(Servlet1.class.getName()).log(Level.SEVERE, null, ex);
//        }
      String sql;
      sql = "SELECT * from  PRATHAM.LOGIN";
      //stmt=conn.c
       rs= stmt.executeQuery(sql);
        while(rs.next())
        {
           if((rs.getString(1).equals(uname)) && (rs.getString(2).equals(pwd)))
                   {
                       sql="UPDATE PRATHAM.LOGIN SET STATUS='A' WHERE USERNAME='"+uname+"'";
                       stmt.executeUpdate(sql);
                        //response.sendRedirect("success.jsp");
                         flag=true;
                         break;
                   }
            else
           {
               flag=false;
               break;
           }
        }

      processRequest(request, response,flag);
        }
        catch(Exception e)
        {
            e.toString();
        }
        finally
        {
         if(rs!=null) {
        try {
             rs.close();
        }
         catch(SQLException ex) {
              System.out.println("Could not close query");
        }
        }
        
    }
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
