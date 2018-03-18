<%--
  Created by IntelliJ IDEA.
  User: 杨少侠
  Date: 2018/1/6
  Time: 19:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>寝室卫生分数表</title>
</head>
<link rel="stylesheet" href="../css/bootstrap.css">
<style>
    .hygiene-list {
        width: 70%;
        margin: 50px auto;
    }

    h2 {
        margin-top: 50px;
        text-align: center;
    }

    .excel-btn {
        float: right;
        margin: 10px 200px 50px auto;
    }

</style>
<body>
    <ol class="breadcrumb">
        <li><a href="/staffHome">主页</a></li>
        <li class="active">查看分数</li>
    </ol>

    <div class="downLoadExcel">
        <h2>寝室卫生检查表</h2>
        <input type="button" class="excel-btn btn btn-success" value="导出Excel" onclick="download()"/>
    </div>
    <div class="hygiene-list">
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>#</th>
                    <th>公寓</th>
                    <th>寝室号</th>
                    <th>时间</th>
                    <th>分数</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="hygiene" varStatus="i" items="${hygieneList}">
                    <tr>
                        <td>${i.count}</td>
                        <td>${aptName}</td>
                        <td>${hygiene.roomNo}</td>
                        <td>${hygiene.yearAndMonth}</td>
                        <td>${hygiene.remarks}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

</body>
<script src="../js/jquery-3.2.1.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script>
    function download(){
        var url="/downloadExcel";
        window.open(url);
    }
</script>
</html>
