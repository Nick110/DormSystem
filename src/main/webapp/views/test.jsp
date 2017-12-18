<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 杨少侠
  Date: 2017/12/14
  Time: 19:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1">
    <c:forEach var="noticeHistory" items="${noticeDtoHistory}">
        <tr>
            <td><c:out value="${noticeHistory.id}"></c:out></td>
            <td><c:out value="${noticeHistory.context}"></c:out></td>
            <td><c:out value="${noticeHistory.time}"></c:out></td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
