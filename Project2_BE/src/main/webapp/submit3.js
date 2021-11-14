function return_main() {
	var Post_DB2 = document.PostDB;
	//Post_DB2.method = "get";
    Post_DB2.action = "logic";
    Post_DB2.submit(); // Send to Servlet
    return true;      
}

function GetDateFunc() {
    var currentDate = new Date();
    var tt = currentDate.getMonth() + 1;
    var Date_current = currentDate.getFullYear() + "-" + tt + "-" + currentDate.getDate();

    return Date_current;
}

function SendToDo(param1, param2, param3) {
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
    
    var ur = 'http://localhost:8080/webapiexam2/todolists?' + "WhatWork_name=" + param1.value 
    + "&WhoWork_name=" + param2.value + "&PriorityBtn_name=" + param3.value;
//    var ur = 'http://localhost:8080/webapiexam2/todolistpost';
    xhr.open('GET', ur);
    //xhr.setRequestHeader('Content-type', 'application/json');
    //xhr.send(JSON.stringify(formData));
    submittodo(param1);
    reqLis2();
    xhr.send();
}


function reqLis2() {
	var httpRequest3;
    fetch('./HOME.html').then(function(response) {
	    response.text().then(function() {
		    document.querySelector('article').innerHTML = "test11";
	    })
    })
}

function SendToDo2(param1, param2, param3) {

    var xhr2 = new XMLHttpRequest();
    var ur2 = 'http://localhost:8080/webapiexam2/todolists?';
    var ur3 = '&WhoWork_name=' + param2.value;

    xhr2.open('POST', ur2, true);
    xhr2.send(ur3);
}

function clearTextInput() {
	var textinputlength = document.getElementsByClassName("input-text");
	var radbtn = document.getElementsByClassName("input-radio");
	
	
	var len_clearTextInput = textinputlength.length;
	for (var i = 0; i < len_clearTextInput; i++) {
		textinputlength[i].value = '';
	}
	var len_radbtn = radbtn.length;
	for (var i = 0; i < len_radbtn; i++) {
		radbtn[i].checked = false;
	}
    radbtn[0].checked = true;	
}

function submittodo(param1) {
    var testz = document.getElementsByClassName("testfor46");
    testz[0].innerHTML = "test";
}

function submittodo222() {
            var z, i, elmnt, file, xhttp;
            z = document.getElementById("form_add");
            testz = document.getElementsByClassName("form_add2");
            for (i = 0; i < z.length; i++) {
                elmnt = z[1];
            file = elmnt.getAttribute("HOME");
            if(file) {
                xhttp = new XMLHttpRequest();
                xhttp.onreadystatechange = function() {
                    if(this.readyState == 4 && this.status == 200) {
                        elmnt.innerHTML = this.responseText;
                        elmnt.removeAttribute("HOME");
                        includeHTML();
                }
            }
            xhttp.open("GET", file, true);
            xhttp.send();
            return;
            }
        }
}
