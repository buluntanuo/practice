<%--
  Created by IntelliJ IDEA.
  User: 20677
  Date: 2020/7/10
  Time: 15:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <script type="text/javascript" src="jquery.js"></script>
</head>
<body>
    用户名：<input type="text" id="username"><br>
    密码：<input type="password" id="password"><br>
    <input type="button" value="登录" onclick="subGet()">
    <h2 id="tip"></h2>
    <script type="text/javascript">
        function subGet() {
            $.ajax({
                type:"POST",
                url:"<%=request.getContextPath()%>/loginServlet",
                data:{
                    username:$("#username").val(),
                    password:$("#password").val()
                },
                success:function(data) {
                    $("h2").html(data);
                    setTimeout(function () {
                        window.location.href="<%=request.getContextPath()%>/jsp/main.jsp";
                    },3000);
                }
            });
        }
    </script>
</body>
</html>
