<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import="web.SQL" %>
<%@ page import="web.CauhoiTraloi" %>

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
                        background-color: white;
		    color: black;
		    border: 1px solid #3385ff;
		    border-radius:5px;
		    padding: 10px 20px;
		    text-align: center;
		    text-decoration: none;
		    display: inline-block;
		    font-size: 16px;
		    font-family:Arial;
		}
		h2{
			font-family: Arial;
		}
                h4{
			font-family: Arial;
		}
    	</style>
		<title>Form Login</title>
	</head>
	<body>
		<div style="width: 400px; margin: 50px auto;background:#ccffcc ;padding:30px">
			<h2><< GIÁO VIÊN ĐĂNG NHẬP >></h2>
                        
                        <h3>DANH SÁCH SINH VIÊN TRẢ LỜI CÂU HỎI</h3>
			
                        
                        <form action="<%=request.getContextPath() %>/xulyadmin" method="post" >
                        <input type="submit" style="width: 300px;background: #400080 " type = "submit" name="submit" value="Exit" /></br></br>
                        <%
                            ArrayList<String>t= SQL.getAllUser();
                            for (String t1 : t) {%>
                            <input type="submit" style="width: 300px; border-radius:5px" type = "submit" name="submit" value="<%=t1%>" /></br></br>
                         <%}%>
                         
			</form>
		</div>
	</body>
</html>