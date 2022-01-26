package com.servletassignemt;
import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@SuppressWarnings("serial")
@WebServlet("/EditServlet")  
public class EditServlet extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
           throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.println("<h1>Update Data</h1>");  
        String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid);  
          
        Emp e=EmpDao.getEmployeeById(id);  
          
        out.print("<form action='EditServlet2' method='post'>");  
        out.print("<table>");  
        out.print("<tr><td></td><td><input type='hidden' name='id' value='"+e.getId()+"'/></td></tr>");  
        out.print("<tr><td>First Name:</td><td><input type='text' name='fname' value='"+e.getFname()+"'/></td></tr>");  
        out.print("<tr><td>Last Name:</td><td><input type='text' name='lname' value='"+e.getLname()+"'/>"
        		+ "</td></tr>");  
        out.print("<tr><td>District:</td><td><input type='text' name='district' value='"+e.getDistrict()+"'/></td></tr>"); 
        out.print("<tr><td>Party:</td><td><input type='text' name='party' value='"+e.getParty()+"'/></td></tr>");
        out.print("<tr><td>Phone:</td><td><input type='text' name='phone' value='"+e.getPhone()+"'/></td></tr>");
        out.print("<tr><td>Room:</td><td><input type='text' name='room' value='"+e.getRoom()+"'/></td></tr>");
        out.print("<tr><td>Assignment:</td><td><input type='text' name='assignment' value='"+e.getAssignment()+"'/></td></tr>");
        out.print("<tr><td>Country:</td><td>");  
        out.print("<select name='country' style='width:150px'>");  
        out.print("<option>India</option>");  
        out.print("<option>USA</option>");  
        out.print("<option>UK</option>");  
        out.print("<option>Other</option>");  
        out.print("</select>");  
        out.print("</td></tr>");  
        out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");  
        out.print("</table>");  
        out.print("</form>");  
          
        out.close();  
    }  
}