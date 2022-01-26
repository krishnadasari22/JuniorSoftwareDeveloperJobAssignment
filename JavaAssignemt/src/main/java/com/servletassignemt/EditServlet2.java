package com.servletassignemt;
import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@SuppressWarnings("serial")
@WebServlet("/EditServlet2")  
public class EditServlet2 extends HttpServlet {  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   
          throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid);  
        String fname=request.getParameter("fname");  
        String lname=request.getParameter("lname");  
        String district=request.getParameter("district");  
        String party=request.getParameter("party");
        String phone=request.getParameter("phone");
        String room=request.getParameter("room");
        String assignment=request.getParameter("assignment");
        String country=request.getParameter("country");  
          
        Emp e=new Emp();  
        e.setId(id);  
        e.setFname(fname);  
        e.setLname(lname);  
        e.setDistrict(district); 
        e.setParty(party);
        e.setPhone(phone);
        e.setRoom(room);
        e.setAssignment(assignment);
        
        e.setCountry(country);  
          
        int status=EmpDao.update(e);  
        if(status>0){  
            response.sendRedirect("ViewServlet");  
        }else{  
            out.println("Sorry! unable to update record");  
        }  
          
        out.close();  
    }  
  
}