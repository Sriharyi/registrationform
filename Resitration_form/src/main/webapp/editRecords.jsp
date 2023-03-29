<%@page import="util.ConnectionUtil" import ="modal.User" import ="java.sql.*" import ="java.util.*"  import ="service.UserService" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UPDATE RECORDS</title>
	<link rel="stylesheet" href="style.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.1/moment.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css"  referrerpolicy="no-referrer" />
</head>
<body>
	<% User user = (User)session.getAttribute("user"); %>
	<div class="container">
       <div class="header">
        <h3>Register User</h3>
       </div>
        <form action="update" class="form" method="post" id="formin" onsubmit="submitForm(event)">
            <div class="row">
                <div class="col-6 form-control">
                    <label for="username">Name</label>
                     <input type="hidden" id="id" name="id" value="<%=user.getId()%>" >
                    <input type="text" id="username" name="name" placeholder="E.g.steverogers" value="<%=user.getName() %>" >
                    <i class="fa-regular fa-circle-check"></i>
                    <i class="fa-solid fa-exclamation"></i>
                    <small>error message</small>
                </div>
                <div class="col-6 form-control">
                    <label for="email">Email</label>
                    <input type="email" name="email" placeholder="E.g.email@gmail.com" id="email" value="<%=user.getEmail()%>">
                    <i class="fa-regular fa-circle-check"></i>
                    <i class="fa-solid fa-exclamation"></i>
                    <small>error message</small>
                </div>
            </div>
           
            <div class="form-control">
                <label for="phoneno">Phone Number</label>
                <input type="number" name="phonenumber" placeholder="E.g.+918512453358" id="phoneno" value="<%=user.getPhonenumber()%>">
                <i class="fa-regular fa-circle-check"></i>
                <i class="fa-solid fa-exclamation"></i>
                <small>error message</small>
            </div>
            <div class="form-control">
                <label for="dob">Date of Birth</label>
                <input type="date" name="dateofbirth" id="dob" value="<%=user.getDateofbirth()%>">
                <i class="fa-regular fa-circle-check"></i>
                <i class="fa-solid fa-exclamation"></i>
                <small>error message</small>
            </div>
            <div class="form-gender">
                <div class="form-control-div">
                    <label>Gender:</label>
                    <label for="male">male
                        <input type="radio" name="gender" id="male" value="male" checked></input> </label>
                    <label for="female">Female
                        <input type="radio"  name="gender" id="female" value="female"></input>
                    </label>
                    <label for="other">Other
                        <input type="radio" name="gender" id="other" value="other"></input>
                    </label>
                </div>
            </div>
            <div class="form-control">
                <label for="role" id="label-role">Which option best describes you?</label>
                <select name="role" class="selectbox" id="role" value="<%=user.getRole()%>">
                    <option value="student">Student</option>
                    <option value="intern">Intern</option>
                    <option value="professional">Professional</option>
                    <option value="other">Other</option>
                </select>
                <i class="fa-regular fa-circle-check"></i>
                <i class="fa-solid fa-exclamation"></i>
                <small>error message</small>
            </div>  
            <button type="submit" >submit</button>       
        </form>
    </div>
    <script src="script.js"></script>
</body>
</html>