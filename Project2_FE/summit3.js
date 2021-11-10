$(document).ready(function(){
    $("#addForm").on("click",function(){	// 클릭 이벤트
      $.ajax({
          url : "addForm.do",
          dataType: "html",	// 이 부분이 반환 타입을 핸들링하는 곳이다.
          type: "get",
          success: function(data) {
            $('body').append(data); // 반환된 data를 body태그에 추가
          },
          error: function (){alert("실패");}
      });
    });
  });


