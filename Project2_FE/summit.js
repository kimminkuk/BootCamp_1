var rad = document.PriorityForm.Prioritybtn;
var fContainer = document.getElementsByClassName('centerfix_font');
var prev = null;
var len = rad.length;
for (var i = 0; i < len; i++) {
    rad[i].addEventListener('change', function() {
        fContainer.item(0).style.flexDirection = this.value;
    });
}


function printWhatWork() {
    const textInputWork = document.getElementById("WhatWork_id").value;
    document.getElementById("result_WhatWork_id").innerText = textInputWork;
}

function printWhoWork() {
    const textInputWho = document.getElementById("WhoWork_id").value;
    document.getElementById("result_WhoWork_id").innerText = textInputWho;
}

function runtest(param, param2) {
    console.log(param);
    console.log(param.value);
    console.log(param2.value);

    var currentDate = new Date();
    var tt = currentDate.getMonth()+1
    var Date_current = currentDate.getFullYear() +"-" + tt +"-"+ currentDate.getDate()
    console.log(Date_current);     //10 ???

    // setTimeout(function() {
    //     var msg = "test1";
    //     console.log(msg);
    //     location.href = './HOME.html' // Action ok
    // }, 3000);

    makeTodoList(param, param2);
    TodotoServlet(param, param2)
    location.href = './HOME.html' // Action ok
    makeTodoList2();
}

function javascript() {
    
    document.getElementById("testDiv").style.border = "1px solid #000000";    //1픽셀로 점선방식으로 검정색으로 넣습니다.        
}

function makeTodoList(param, param2) {
    document.getElementById("testNav").style.border = "10px solid #000000";
}

function makeTodoList2() {
    document.getElementById("testNav2").style.border = "10px solid #000000";
}

function TodotoServlet(param, param2) {
    var Work_DB = document.WhatWorkForm.WhatWork_id.value;
    var Who_DB = document.WhoWorkForm.WhoWork_id.value;
    var Post_DB = document.PostDB;
    Post_DB.method = "post";
    Post_DB.action = "send5"; //localhost url 쓰기?

    console.log(Work_DB, Who_DB, Post_DB.action, "1111");
    Post_DB.submit();

    console.log(Work_DB, Who_DB, Post_DB.action, "2222");
}