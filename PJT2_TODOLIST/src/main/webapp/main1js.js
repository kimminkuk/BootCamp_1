function return_main() {
	var Post_DB2 = document.PostDB;
    Post_DB2.action = "logic";
    Post_DB2.submit();
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
    console.log(param2.value.length);
    if(param1.value.length > 48 || param2.value.length > 24) {
	    alert('Text Length Over! retry plz');
        return false;
    }
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
    //var ur = 'http://localhost:8080/TODO/todolists?' + "WhatWork_name=" + param1.value 
    //+ "&WhoWork_name=" + param2.value + "&PriorityBtn_name=" + param3.value;

    //[END POSITION]
    var ur = 'http://localhost:8080/PJT2_ODOLIST/todolists?' + "WhatWork_name=" + param1.value 
    + "&WhoWork_name=" + param2.value + "&PriorityBtn_name=" + param3.value;

    xhr.open('GET', ur);
    xhr.send();
}

function SendToDoPost(param1, param2, param3) {
    var xhrPost = new XMLHttpRequest();
    
    //var xhrPost_ur = 'http://localhost:8080/PJT2_ODOLIST/todolists?WhatWork_name=Post Error...&WhoWork_name=Hage&PriorityBtn_name=3';
    //var xhrPost_ur = 'http://localhost:8080/PJT2_ODOLIST/todolists';
    //var xhrPost_ur = 'http://localhost:8080/PJT2_ODOLIST/todolists?' + "WhatWork_name=" + param1.value 
    //+ "&WhoWork_name=" + param2.value + "&PriorityBtn_name=" + param3.value;
    //var xhrPost_ur = 'PJT2_ODOLIST/logic';
    //var xhrPost_ur = '/PostTest';
    //var xhrPost_ur = 'PJT2_ODOLIST/PostTest' 
    xhrPost.open('POST', 'PJT2_ODOLIST/PostTest', true);
    xhrPost.onreadystatechange = function () {
        if (xhrPost.readyState === xhrPost.DONE) {
            if (xhrPost.status === 200) {
                console.log(xhrPost.responseText);
            } else {
                console.error(xhrPost.responseText);
            }
        }
    };

    xhrPost.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    //[END POSITION]
    var urPost = "WhatWork_name=" + param1.value + "&WhoWork_name=" + param2.value + "&PriorityBtn_name=" + param3.value;
    //xhrPost.send("WhatWork_name=Post?????????!&WhoWork_name=MKK.KIIMM&PriorityBtn_name=3");
    //var urPost = "todolists"+"WhatWork_name=" + param1.value + "&WhoWork_name=" + param2.value + "&PriorityBtn_name=" + param3.value;
    //xhrPost.send(JSON.stringify(testdata));
    xhrPost.send(urPost);
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

function MoveRight(getId_MR) {
	
    var td2frameid = document.getElementById("todolist2_frame_id");
    var td3frameid = document.getElementById("todolist3_frame_id");

    if (document.getElementById("todolist1_id"+getId_MR)) {
	    var tanstt1 = document.getElementById("todolist1_id"+getId_MR);
        tanstt1.id = "L1_todolist1_id"+getId_MR;
	    td2frameid.append(tanstt1);
    } else if (document.getElementById("L1_todolist1_id"+getId_MR)) {
	    var tanstt2 = document.getElementById("L1_todolist1_id"+getId_MR);
        tanstt2.id = "L2_todolist1_id"+getId_MR;	
	    td3frameid.append(tanstt2);
    } else { //No Move
	    return false;
    }
}

function MoveLeft(getId_ML) {
    var LBTN_td2frameid = document.getElementById("todolist1_frame_id");
    var LBTN_td3frameid = document.getElementById("todolist2_frame_id");
    
    if (document.getElementById("L1_todolist1_id"+getId_ML)) {
	    var LBTN_tanstt1 = document.getElementById("L1_todolist1_id"+getId_ML);
        LBTN_tanstt1.id = "todolist1_id"+getId_ML;
	    LBTN_td2frameid.append(LBTN_tanstt1);
    } else if (document.getElementById("L2_todolist1_id"+getId_ML)) {
	    var LBTN_tanstt2 = document.getElementById("L2_todolist1_id"+getId_ML);
        LBTN_tanstt2.id = "L1_todolist1_id"+getId_ML;	
	    LBTN_td3frameid.append(LBTN_tanstt2);
    } else { //No Move
	    return false;
    }
}
