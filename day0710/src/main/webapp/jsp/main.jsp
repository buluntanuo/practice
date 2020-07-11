<%--
  Created by IntelliJ IDEA.
  User: 20677
  Date: 2020/7/11
  Time: 8:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
用户名=${sessionScope.user.username }<br>
密码：${sessionScope.user.password }<br>
邮箱：${sessionScope.user.email }<br>
电话：${sessionScope.user.phone }<br>
注册时间：${sessionScope.user.insert_time}<br>
信息修改时间：${sessionScope.user.update_time}<br>
</body>
</html>
