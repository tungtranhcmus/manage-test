<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <style type="text/css">
        
		input{
                    background-color: f2e6ff;
		    color: black;
		    border: 1px solid #400080;
		    border-radius:5px;
		    padding: 10px 20px;
		    text-align: center;
		    text-decoration: none;
		    display: inline-block;
		    font-size: 16px;
		    font-family:Arial;
		}
		label{
			font-family:  Arial;
		}
		h2{
			font-family: Arial;
		}
    	</style>
		<title>Form Login</title>
	</head>
	<body>
		<div style="width: 400px; margin: 50px auto;background:#ccffcc ;padding:30px">
			<h2>Login </h2>
			<%
				if(request.getParameter("error") != null){
					out.print("<p style='color:red'>Sai tên đăng nhập hoặc mật khẩu </p>");
				}
			%>

			<form action="<%=request.getContextPath() %>/login" method="post" >
				<div>
					<label>Username: </label>
					<input  style="width: 300px;padding:10px; border-radius:0px" type="text" name="username" value="" />
				</div>	

				<br />
				<div>
					<label>Password : </label>
					<input style="width: 300px; padding:10px; border-radius:0px" type="password" name="password" value="" />
				</div>
				<br />
				<div>
					<input type="submit" style="width: 100px;background: #400080 " name="submit" value="Login" />
                                        <input type="submit" style="width: 100px;background: #400080 " name="submit" value="Create" />
				</div>
			</form>
                                
		</div>
	</body>
</html>
