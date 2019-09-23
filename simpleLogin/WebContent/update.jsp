<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%
String uid = request.getParameter("uid");
String driver = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3308/";
String database = "mydb";
String userid = "root";
String password = "";
try {
Class.forName(driver);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}
Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>
<%
try{
connection = DriverManager.getConnection(connectionUrl+database, userid, password);
statement=connection.createStatement();
String sql ="select * from user_reg where uid="+uid;
resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>
<!DOCTYPE html>
<html>
<body>
<h1>Update data from database in jsp</h1>
<form method="post" action="update-process.jsp">
<input type="hidden" name="uid" value="<%=resultSet.getString("uid") %>">
<input type="text" name="uid" value="<%=resultSet.getString("uid") %>">
<br>
First name:<br>
<input type="text" name="uname" value="<%=resultSet.getString("uname") %>">
<br>
Last name:<br>
<input type="text" name="upass" value="<%=resultSet.getString("upass") %>">
<br>
City name:<br>
<input type="text" name="uemail" value="<%=resultSet.getString("uemail") %>">
<br>
<br>
<input type="submit" value="submit">
</form>
<h1>HALLOOOOO</h1>
<%
}
connection.close();
} catch (Exception e) {
e.printStackTrace();
}
%>
</body>
</html>