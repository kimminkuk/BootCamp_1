function GetDateFunc() {
    var currentDate = new Date();
    var tt = currentDate.getMonth() + 1;
    var Date_current = currentDate.getFullYear() + "-" + tt + "-" + currentDate.getDate();

    return Date_current;
}

function SendToDo(param1, param2) {
    var currentDate = GetDateFunc();
    var Post_DB = document.PostDB;
    if (!param1 || !param2) {
        console.log("ERR: EMPTY TEXT!")
        return false;
    } else {
        Post_DB.method = "get";
        Post_DB.method = "todolists";
        Post_DB.submit(); // Send to Servlet
        return true;  
    }
}

function testAjax() {
    var httpRequest;
    document.AjaxDelBtn;
    document.getElementById("btn3").addEventListener('click', DelRequest);

    function DelRequest() {
        httpRequest = new XMLHttpRequest();
        if(!httpRequest) {
            alert('#1 Del Message Error.');
            return false;
        }
        httpRequest.onreadystatechange = alertContents;

        httpRequest.open('GET', './test2.html');
        httpRequest.send();
    }

    function alertContents() {
        try {
            if (httpRequest.readyState === XMLHttpRequest.DONE) {
                if (httpRequest.status === 200) {
                    alert(httpRequest.responseText);
                } else {
                    alert('#2 Server Request Error.');
                }
            }
        } catch( e ) {
            alert('Caught Exception: ' + e.description);
        }
    }
}

function testAjax2() {
    var WhatWork_empty = document.getElementById("WhatWork_Id").value;
    DelRequest2('./test2.html', WhatWork_empty);
}

function DelRequest2(url, userName) {
    var httpRequest2;
    httpRequest2 = new XMLHttpRequest();
    if(!httpRequest2) {
        alert('#1 DelRequest2 Error.');
        return false;
    }
    httpRequest2.onreadystatechange = alertContents;
    httpRequest2.open('POST', url);
    httpRequest2.send();
}

function reqLis() {
    var httpRequest3;
    httpRequest3 = new XMLHttpRequest();
    httpRequest3.open('GET', './../../../../Project2_FE/HOME.html');
    httpRequest3.send();
}