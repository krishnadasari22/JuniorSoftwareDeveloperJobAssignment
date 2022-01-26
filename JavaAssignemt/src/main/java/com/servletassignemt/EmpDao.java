package com.servletassignemt;
import java.util.*;  
import java.sql.*;  
  
public class EmpDao {  
  
    public static Connection getConnection(){  
        Connection con=null;  
        try{  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306","root","abcd");  
        }catch(Exception e){System.out.println(e);}  
        return con;  
    }  
    public static int save(Emp e){  
        int status=0;  
        try{  
            Connection con=EmpDao.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "insert into test.data(fname,lname,district,party,phone,room,assignment,country) values (?,?,?,?,?,?,?,?)");  
            ps.setString(1,e.getFname());  
            ps.setString(2,e.getLname());  
            ps.setString(3,e.getDistrict());  
            ps.setString(4,e.getParty());
            ps.setString(5,e.getPhone());
            ps.setString(6,e.getRoom());
            ps.setString(7,e.getAssignment());
            ps.setString(8,e.getCountry());  
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
    public static int update(Emp e){  
        int status=0;  
        try{  
            Connection con=EmpDao.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "update test.data set fname=?,lname=?,district=?,party=?,phone=?,room=?,assignment=?,country=? where id=?");  
            ps.setString(1,e.getFname()); 
            ps.setString(2,e.getLname());  
            ps.setString(3,e.getDistrict());
            ps.setString(4,e.getParty());
            ps.setString(5,e.getPhone()); 
            ps.setString(6,e.getRoom());
            ps.setString(7,e.getAssignment());
            ps.setString(8,e.getCountry());
            ps.setInt(9,e.getId());  
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
    public static int delete(int id){  
        int status=0;  
        try{  
            Connection con=EmpDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("delete from test.data where id=?");  
            ps.setInt(1,id);  
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return status;  
    }  
    public static Emp getEmployeeById(int id){  
        Emp e=new Emp();  
          
        try{  
            Connection con=EmpDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from test.data where id=?");  
            ps.setInt(1,id);  
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){  
                e.setId(rs.getInt(1));  
                e.setFname(rs.getString(2));  
                e.setLname(rs.getString(3));  
                e.setDistrict(rs.getString(4)); 
                e.setParty(rs.getString(5));
                e.setPhone(rs.getString(6));
                e.setRoom(rs.getString(7));
                e.setAssignment(rs.getString(8));
                e.setCountry(rs.getString(9));  
            }  
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return e;  
    }  
    public static List<Emp> getAllDatas(){  
        List<Emp> list=new ArrayList<Emp>();  
          
        try{  
            Connection con=EmpDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from test.data");  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                Emp e=new Emp();  
                e.setId(rs.getInt(1));  
                e.setFname(rs.getString(2));  
                e.setLname(rs.getString(3));  
                e.setDistrict(rs.getString(4));  
                e.setPhone(rs.getString(5));
                e.setRoom(rs.getString(6));
                e.setAssignment(rs.getString(7));
                e.setCountry(rs.getString(8));  
                list.add(e);  
            }  
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return list;  
    }  
}
