<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/17
  Time: 17:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
      integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<head>
    <title>老师界面</title>
</head>
<body>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
        integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
        integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
        crossorigin="anonymous"></script>

<section>
    <div class="container text-center display2">
        <h1>${className.name}${teacher.name}老师欢迎你</h1>
        <h2 class="text-left " style="color: red;">班级标语：${className.slogan}</h2>
    </div>
</section>
<section class="container">
    <h2 class="display3">班级学生信息：</h2>
    <div class="container text-center">

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
            <c:forEach items="${students}" var="student">
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
        <div class="text-right">
            <a href="/student/addStudent" class="btn btn-info">添加学生</a>
        </div>

    </div>
</section>
<section>
    <div class="container">
        <h2 class="display2 ">模糊查询</h2>
        <form action="/teacher/select" class="form-inline">

            <div class="form-group col-md-2">
                <label for="name">名字：</label>
                <input type="text" class="form-control col-md-6" name="name" id="name">
            </div>
            <div class="form-group col-md-2">
                <label for="id">学号：</label>
                <input type="text" class="form-control col-md-6" name="id" id="id">
            </div>
            <div class="form-group col-md-2">
                <label for="sex">性别：</label>
                <select class="form-control" name="sex" id="sex" placeholder="">
                    <option>男</option>
                    <option>女</option>
                </select>
            </div>
            <div class="form-group col-md-2">
                <label for="roomId">寝室号：</label>
                <input type="text" class="form-control col-md-6" name="roomId" id="roomId">
            </div>
            <input style="display: none" type="number" value="${teacher.classId}" name="classId">
            <input type="submit" class="btn btn-info col-md-1" value="查询">
        </form>
    </div>
</section>

</body>

</html>
