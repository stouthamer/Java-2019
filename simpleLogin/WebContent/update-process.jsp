<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<%! String driverName = "com.mysql.jdbc.Driver";%>
<%!String url = "jdbc:mysql://localhost:3308/mydb";%>
<%!String user = "root";%>
<%!String psw = "";%>
<%
String uid = request.getParameter("uid");
String uname=request.getParameter("uname");
String upass=request.getParameter("upass");
String uemail=request.getParameter("uemail");
if(uid != null)
{
Connection con = null;
PreparedStatement ps = null;
int personID = Integer.parseInt(uid);
try
{
Class.forName(driverName);
con = DriverManager.getConnection(url,user,psw);
String sql="Update user_reg set uid=?,uname=?,upass=?,uemail=? where uid="+uid;
ps = con.prepareStatement(sql);
ps.setString(1,uid);
ps.setString(2, uname);
ps.setString(3, upass);
ps.setString(4, uemail);
int i = ps.executeUpdate();
if(i > 0)
{
out.print("Record Updated Successfully");
}
else
{
out.print("There is a problem in updating Record.");
} 
}
catch(SQLException sql)
{
request.setAttribute("error", sql);
out.println(sql);
}
}
%>
