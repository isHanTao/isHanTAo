<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/16
  Time: 19:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
      integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<head>
    <title>Students</title>
    <h1 class="display-2 text-center">学生信息</h1>
</head>
<body>
<section class="h-60" >
    <div class="container h-100 ">
        <table class="w-100 table bg-info table-hover table-spriped table-bordered ">
            <tr class="text-center bg-primary">
                <th>学号</th>
                <th>名字</th>
                <th> 性别</th>
                <th>QQ号</th>
                <th>班级号</th>
                <th>寝室号</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${list}" var="student">
                <tr class="text-center mb-5">
                    <td>${student.id}</td>
                    <td>${student.name}</td>
                    <td>${student.sex}</td>
                    <td>${student.qqNumber}</td>
                    <td>${student.classId}</td>
                    <td>${student.roomId}</td>
                    <td><a href="/student/delete/${student.id}" class="del" ><p class="btn btn-danger ">删除</p></a>
                        <a href="/student/edit/${student.id}" class="edit"><p class="btn btn-info">修改</p></a></td>
                </tr>
            </c:forEach>
        </table>
        <p>
            <a href="/student/addStudent" class="btn btn-primary"> 添加学生</a>
        </p>
    </div>
</section>

<script>
    var items = document.querySelectorAll(".del")
    for (var i = 0; i < items.length; i++) {
        items[i].onclick = function () {
            return confirm("确认删除吗？");
        }
    }
</script>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
        integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
        integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
        crossorigin="anonymous"></script>

<link rel="stylesheet" href="/css/myCss.css">>


</body>
</body>
</html>

