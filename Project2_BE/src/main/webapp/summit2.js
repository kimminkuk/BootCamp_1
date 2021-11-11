function GetDateFunc() {
    var currentDate = new Date();
    var tt = currentDate.getMonth() + 1;
    var Date_current = currentDate.getFullYear() + "-" + tt + "-" + currentDate.getDate();

    return Date_current;
}

function SendToDo() {
    var currentDate = GetDateFunc();
    var Post_DB = document.PostDB;
    
    Post_DB.method = "get";
    Post_DB.method = "todolists";
    //Post_DB.action = "./test2.html";
    Post_DB.submit(); // Send to Servlet
    
    alert("OK");
    reqLis();
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
    fetch('./HOME.html').then(function(response) {
	    response.text().then(function(text) {
		    document.querySelector('article').innerHTML = text;
	    })
    })
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

