
$( document ).ready(function(){
    $( "#convertbtn" ).click(function() {
    var operation=document.getElementById("operation").value;
    var name=document.getElementById("uname").value;
    var login=document.getElementById("login").value;
    var email=document.getElementById("email").value;
    var pnumber=document.getElementById("pnumber").value;
    var msg=document.getElementById("msg").value;
    var str=operation+"<?xml version = '1.0'?>\n\
                <users>\n\
                    <user>\n\
                        <name>"+name+"</name>\n\
                        <login>"+login+"</login>\n\
                        <email>"+email+"</email>\n\
                        <pnumber>"+pnumber+"</pnumber>\n\
                        <msg>"+msg+"</msg>\n\
                    </user>\n\
                </users>"
    alert(str);
    $.ajax({
        
        type: 'POST',
        url: 'handle',
        data: 'value='+str,
        success: function(data){
          $('#resultMessage').html(data);
        }
        
});
return false;
    });
    return false;
});


