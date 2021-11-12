
function t123() {
        $.ajax({ 
            type: 'post' , 
            url: '/list.html' , 
            dataType : 'html' , 
            success: function(data) { 
                $("#listDiv").html(data);
            } 
        });
    }


    (function() {
        var httpRequest;
        document.getElementById("listButton").addEventListener('click', makeRequest);
      
        function makeRequest() {
          httpRequest = new XMLHttpRequest();
      
          if(!httpRequest) {
            alert('#1 err');
            return false;
          }
          httpRequest.onreadystatechange = alertContents;
          httpRequest.open('GET', 'test4.html');
          httpRequest.send();
        }
      
        function alertContents() {
          if (httpRequest.readyState === XMLHttpRequest.DONE) {
            if (httpRequest.status === 200) {
              alert(httpRequest.responseText);
            } else {
              alert('#2 err request');
            }
          }
        }
      })();