function GetDateFunc() {
    var currentDate = new Date();
    var tt = currentDate.getMonth() + 1;
    var Date_current = currentDate.getFullYear() + "-" + tt + "-" + currentDate.getDate();

    return Date_current;
}

function SendToDo(param1, param2) {
    var currentDate3 = GetDateFunc();
/*    var Post_DB = document.PostDB;

    if (!param1 || !param2) {
        console.log("ERR: EMPTY TEXT!")
        return false;
    } else {
        Post_DB.method = "get";
        Post_DB.action = "todolists";
        Post_DB.submit(); // Send to Servlet
        
        alert("OK");
        return true;  
    }
*/

    var xhr = new XMLHttpRequest();
    var formData = {'age': 26, 'lang': 'JS', 'drink': 'zero coke'};
    xhr.onreadystatechange = function () {
        if (xhr.readyState === xhr.DONE) {
            if (xhr.status === 200 || xhr.status === 201) {
                console.log(xhr.responseText);
            } else {
                console.error(xhr.responseText);
            }
        }
    };
    
    var ur = 'http://localhost:8080/webapiexam2/todolists?WhatWork_name=' + param1.value 
+ "&" + "WhoWork_name=" + param2.value + "&PriorityBtn_name=3"; 
    xhr.open('GET', ur);
    //xhr.setRequestHeader('Content-type', 'application/json');
    //xhr.send(JSON.stringify(formData));
    xhr.send();
}

