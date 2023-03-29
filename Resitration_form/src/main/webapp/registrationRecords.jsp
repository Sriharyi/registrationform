<%@page import="util.ConnectionUtil" import ="modal.User" import ="java.sql.*" import ="java.util.*"  import ="service.UserService" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registeration Records</title>
 <link rel="stylesheet" href="table.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.1/moment.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css"  referrerpolicy="no-referrer" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/js/bootstrap.bundle.min.js" integrity="sha384-qKXV1j0HvMUeCBQ+QVp7JcfGl760yU08IQ+GpUo5hlbpg51QRiuqHAJz8+BrxE/N" crossorigin="anonymous"></script>
</head>
<body>
	  <main>
        <div class="container">
          <h1>Registeration Records</h1>
          <div class="table-display">
              <table class="table table-striped table-dark">
                <thead>
                  <tr>
                    <th scope="col">#</th>
                    <th scope="col">Name</th>
                    <th scope="col">Email</th>
                    <th scope="col">DOB</th>
                    <th scope="col">Gender</th>
                    <th scope="col">Role</th>
                    <th scope="col">Phone Number</th>
                    <th scope="col">Action</th>
                  </tr>
                </thead>
                <tbody>
                <%
                	Connection con = ConnectionUtil.getConnection();
                	UserService userservice = new UserService(con);
                	List<User> list = userservice.getUsers();
                	int i=1;
                	for(User u :list){
                		%>
                		<tr>
                        <th scope="row"><%= i++ %></th>
                        <td><%=u.getName() %></td>
                        <td><%=u.getEmail() %></td>
                        <td><%=u.getGender() %></td>
                        <td><%=u.getDateofbirth() %></td>
                        <td><%=u.getRole() %></td>
                        <td><%=u.getPhonenumber() %></td>
                        <td><span style="display:flex;justify-content:space-between;">
                        	<form action="EditAction" method="post">
                       		<input type="hidden" name="id" value="<%=u.getId()%>">
                       		<input type="submit"  class="btn btn-primary" value="Edit">
                       		</form > 
                       		<form action="DeleteAction" method="post">
                       		<input type="hidden" name="id" value="<%=u.getId()%>">
                       		<input type="submit"  class="btn btn-danger" value="DELETE">
                       		</form>
                        </span> 
                       	</td>
                      </tr>
                		<%
                	}
                %>
                  
                </tbody>
              </table>
            </div>
            <a href="index.html"><button>Add New Records</button></a>
        </div>
    </main>
      <script src="table.js"></script>
</body>
</html>