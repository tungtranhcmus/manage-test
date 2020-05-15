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
                    background-color: f2ccff;
		    color: black;
		    border: 1px solid #3385ff;
		    padding: 10px 20px;
		    text-align: center;
		    text-decoration: none;
		    display: inline-block;
		    font-size: 16px;
		    font-family:Arial;
		}
		h3{
			font-family: Arial;
		}
                h5{
			font-family: Arial;
		}
    	</style>
		<title>Form Login</title>
	</head>
	<body>
		<div style="width: 400px; margin: 50px auto;background:#ccffcc ;padding:30px">
         
                        <h3> << GV đăng nhập>> << <%=session.getAttribute("username")%> trả lời>> </h3>
                        
                        <h3><%=session.getAttribute("CH") %> / <%=SQL.DemCauHoi() %></h3>
			
                        
                        <form action="<%=request.getContextPath() %>/backad" method="post" >
                            <%
                        int a = Integer.parseInt(session.getAttribute("CH").toString());
                           
                        CauhoiTraloi ch = SQL.LayCauHoi(a);
                        String ten = String.valueOf(session.getAttribute("username"));
                        CauhoiTraloi tl = SQL.LayCauTraLoi(a, ten);
                        %>
                            <h5>Câu Hỏi      :</h5></br><label style="width: 250px" > <%=ch.a %> </label></br>
                            <h5>Trả Lời      :</h5></br><label style="width: 250px" > <%=tl.b %> </label></br>
                            <h5>Trả Lời Đúng :</h5></br><label style="width: 250px" > <%=ch.b %> </label>
				<br />
                                <br />
                                <br />
				<div>
					<input type="submit" style="width: 120px;background: #400080 " type = "submit" name="submit" value="Back" />
                                        <input type="submit" style="width: 120px;background: #400080 " type = "submit" name="submit" value="Next" />
                                        <input type="submit" style="width: 120px;background: #400080 " type = "submit" name="submit" value="Out" />
				</div>
			</form>
		</div>
	</body>
</html>