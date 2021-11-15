<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "kr.or.connect.jdbcexam.dao.ToDoListDao" %>
<%@ page import = "kr.or.connect.jdbcexam.dto.ToDoList" %>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "java.util.List" %>
<%@ page import = "java.util.Date" %>
<%@ page import = "com.fasterxml.jackson.databind.ObjectMapper" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    ObjectMapper ob = new ObjectMapper();
    List<ToDoList> list_ = (List<ToDoList>)request.getAttribute("ori_list");
    request.setAttribute("list_test", list_);
%> 
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <title>HOME</title>
    <link rel="stylesheet" href="./teststy.css?ver=1">
</head>
<body>
    <header>
        <div id = "inclinationText"> 
            나의 해야할 일들
        </div>
        <div class = "btnsty">
            <button id = "btn1" type="button" onclick="location.href='./test3.html'" style="cursor: hand;">
                새로운 TODO 등록
            </button>
        </div>
    </header>
    <nav class = "mainlist_">
        DONE
    </nav>

    <nav class = "mainlist2_">
        DOING
    </nav>

    <nav class = "mainlist3_">
        TODO
    </nav>

    <article>
        <nav class = "todolist1_frame">

<c:forEach items="${list_test}" var="list_test_num">
            <form action="" class = "todolist1" >
                <div class = "form_add2">
                    <c:out value="${list_test_num.getToDoWork()}"/><br>
                    등록날짜: <c:out value="${list_test_num.getToDoDate()} "/>
                    ,<c:out value="${list_test_num.getToDoWho()}"/>
                    ,우선순위: <c:out value="${list_test_num.getToDoPriority()}"/>
                    <button id="temp1" type="button" onclick="" style="cursor; hand;">
                        &rarr;
                    </button>
                </div>
            </form>   
</c:forEach>

        </nav>
        <nav class = "todolist2_frame">
            <form action="" class = "todolist2" >
                <div>
                    11
                </div>
            </form>
        
            <form action="" class = "todolist2" >
                <div>
                    12
                </div>
            </form>
        </nav>

        <nav class = "todolist3_frame">
            <form action="" class = "todolist3" >
                <div>
                    21
                </div>
            </form>
        
            <form action="" class = "todolist3" >
                <div>
                    24
                </div>
            </form>
        </nav>
    </article>    
    <script type="text/javascript" src="submit3.js?ver=1"></script>
</body>
</html>