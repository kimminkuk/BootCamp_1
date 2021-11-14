<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "kr.or.connect.jdbcexam.dao.ToDoListDao" %>
<%@ page import = "kr.or.connect.jdbcexam.dto.ToDoList" %>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "java.util.List" %>
<%@ page import = "com.fasterxml.jackson.databind.ObjectMapper" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <title>HOME</title>
    <link rel="stylesheet" href="./teststy.css">
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
            <form action="" class = "todolist1" >
                 javascript study, 김민극, 2021-11-13, 우선순위 1
            </form>
        
            <form action="" class = "todolist1" >
                <div id = "form_add">
<%-- <%
ToDoListDao ToDoDao = new ToDoListDao();
List<ToDoList> list = new ArrayList<>();
list = ToDoDao.getAllToDoLists();
ObjectMapper ob = new ObjectMapper();
String json = ob.writeValueAsString(list);
%>
<%=json%> --%>
<%-- <%
    ToDoListDao ToDoDao = new ToDoListDao();
    ToDoList todo = ToDoDao.getToDoList(1);
    ObjectMapper ob = new ObjectMapper();
    String json = ob.writeValueAsString(todo);
%>
    <%=json%> --%>
<%
    String json = (String)request.getAttribute("todolist");

%>
<%=json%>
                </div>
            </form>

            <form action="" class = "todolist1" >
                <div class = "form_add2">

                </div>
            </form>
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
    <script type="text/javascript" src="submit3.js"></script>
</body>
</html>