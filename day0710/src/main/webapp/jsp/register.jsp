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
    <title>注册</title>
    <script type="text/javascript" src="jquery.js"></script>
</head>
<body>
    用户名：<input type="text" id="username"><br>
    密码：<input type="password" id="password"><br>
    邮箱：<input type="text" id="email"><br>
    手机号：<input type="text" id="phone"><br>
    <input type="button" value="提交" onclick="subPost()">
    <h2></h2>
    <script type="text/javascript">
        function subPost() {
            $.ajax({
                type:"POST",
                url:"<%=request.getContextPath()%>/registerServlet",
                data:{
                    username:$("#username").val(),
                    password:$("#password").val(),
                    email:$("#email").val(),
                    phone:$("#phone").val()
                },
                success:function (data) {
                    $("h2").html(data);
                    setTimeout(function () {
                        window.location.href="<%=request.getContextPath() %>/servlet";
                    },3000);
                }
            });
        }
    </script>
</body>
</html>
