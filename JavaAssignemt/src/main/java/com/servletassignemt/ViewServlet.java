package com.servletassignemt;
import java.io.IOException;  
import java.io.PrintWriter;  
import java.util.List;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@SuppressWarnings("serial")
@WebServlet("/ViewServlet")  
public class ViewServlet extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
               throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.println("<a href='index.html'>Add New Data</a>");  
        out.println("<h1>Datas List</h1>");  
          
        List<Emp> list=EmpDao.getAllDatas();  
          
        out.print("<table border='1' width='100%'");  
        out.print("<tr><th>Id</th><th>First Name</th><th>Last Name</th><th>District</th><th>Party</th><th>Phone</th><th>Room</th><th>Assignment</th><th>Country</th>"
        		+ "<th>Edit</th><th>Delete</th></tr>");  
        for(Emp e:list){  
         out.print("<tr><td>"+e.getId()+"</td><td>"+e.getFname()+"</td><td>"+e.getLname()+"</td>"
         		+ "<td>"+e.getDistrict()+"</td><td>"+e.getParty()+"</td><td>"+e.getPhone()+"</td><td>"+e.getRoom()+"</td><td>"+e.getAssignment()+"</td><td>"+e.getCountry()+"</td><td><a href='EditServlet?id="+e.getId()+"'>edit</a></td>"
         				+ "<td><a href='DeleteServlet?id="+e.getId()+"'>delete</a></td></tr>");  
        }  
        out.print("</table>");  
          
        out.close();  
    }  
}
