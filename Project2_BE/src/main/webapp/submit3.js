function Aajx_movebtn() {
	var xhr_movebtn = new XMLHttpRequest();
	
    //[HOME CASE]    
    //var ur = 'http://localhost:8080/webapiexam2/movetodoing?' + "WhatWork_name=" + param1.value 
    //+ "&WhoWork_name=" + param2.value + "&PriorityBtn_name=" + param3.value;

    //[OFFICE CASE]
    //var ur_xhr_movebtn = 'http://localhost:8080/TODO/movetodoing?move_1=1';
    var ur_xhr_movebtn = "movetodoing";
    xhr_movebtn.open('GET', ur_xhr_movebtn);
    xhr_movebtn.onreadystatechange = function() {
	    
    }
    xhr_movebtn.send();
}

function Aajx_movebtn2() {
	var tableList = document.querySelector(".form_add2");
	var tt = document.querySelector(".form_add4");
	tt.innerText = "";
	var tt_ = tt.innerText;
    var table_ = tableList.innerText;
    fetch('./logic').then(function(response) {
	    response.text().then(function() {
		    tt_ = "TEXT TEST";
	    })
    })
}

function Aajx_movebtn3() {
	var xhr_movebtn = new XMLHttpRequest();
	
    //[HOME CASE]    
    //var ur = 'http://localhost:8080/webapiexam2/movetodoing?' + "WhatWork_name=" + param1.value 
    //+ "&WhoWork_name=" + param2.value + "&PriorityBtn_name=" + param3.value;

    //[OFFICE CASE]
    //var ur_xhr_movebtn = 'http://localhost:8080/TODO/movetodoing?move_1=1';

	var tableList = document.querySelector(".form_add2");
	var tt = document.querySelector(".form_add4");
	var tt_ = tt.innerText;
    var table_ = tableList.innerText;
    tt_ = "TEXT TEST";
    var ur_xhr_movebtn = "movetodoing";
    xhr_movebtn.open('GET', ur_xhr_movebtn);
    xhr_movebtn.send();
}

function reqLis3() {
    fetch('./logic').then(function(response) {
	    response.text().then(function() {
		    document.querySelector('form_add2').innerHTML = "test11";
	    })
    })
}

function return_main() {
	var Post_DB2 = document.PostDB;
	//Post_DB2.method = "get";
    Post_DB2.action = "logic";
    //Post_DB2.action = "main1.jsp";
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

    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState === xhr.DONE) {
            if (xhr.status === 200 || xhr.status === 201) {
                console.log(xhr.responseText);
            } else {
                console.error(xhr.responseText);
            }
        }
    };

    //[HOME CASE]    
    //var ur = 'http://localhost:8080/webapiexam2/todolists?' + "WhatWork_name=" + param1.value 
    //+ "&WhoWork_name=" + param2.value + "&PriorityBtn_name=" + param3.value;

    //[OFFICE CASE]
    var ur = 'http://localhost:8080/TODO/todolists?' + "WhatWork_name=" + param1.value 
    + "&WhoWork_name=" + param2.value + "&PriorityBtn_name=" + param3.value;

//    var ur = 'http://localhost:8080/webapiexam2/todolistpost';
    xhr.open('GET', ur);
    //xhr.setRequestHeader('Content-type', 'application/json');
    //xhr.send(JSON.stringify(formData));
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
