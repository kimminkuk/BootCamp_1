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
    <link rel="stylesheet" href="./main1css.css?ver=1">
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
        <nav class = "todolist1_frame" id = "todolist1_frame_id">
<c:forEach items="${list_test}" var="list_test_num">
            <form action="" class = "todolist1" id="todolist1_id<c:out value="${list_test_num.getToDoId()}"/>" >
                <div class = "form_add2">
                    <h1 ><c:out value="${list_test_num.getToDoWork()}"/></h1>
                    등록날짜: <c:out value="${list_test_num.getToDoDate()} "/>
                    ,<c:out value="${list_test_num.getToDoWho()}"/>
                    ,우선순위   <c:out value="${list_test_num.getToDoPriority()}"/>             
                    <button id="temp1" type="button" onclick="MoveRight(<c:out value="${list_test_num.getToDoId()}"/>)" style="cursor; hand;">
                        &rarr;
                    </button>
                    <button id="temp2" type="button" onclick="MoveLeft(<c:out value="${list_test_num.getToDoId()}"/>)" style="cursor; hand;">
                        &larr;
                    </button>
                </div>
            </form>   
</c:forEach>
        </nav>
        <nav class = "todolist2_frame"  id = "todolist2_frame_id"></nav>
        <nav class = "todolist3_frame" id = todolist3_frame_id></nav>
    </article>
    <script type="text/javascript" src="main1js.js?ver=3"></script>
</body>
</html>