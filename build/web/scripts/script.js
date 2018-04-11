var counter=2;
var values=[];
$( document ).ready(function(){
    $( "#convertbtn" ).click(function() {
        for (var i=0; i<counter; i++){
            var checkid="val"+i.toString();
            var temp=document.getElementById(checkid).value;
            if(temp!==''){
                values[i]=temp;
            }
        }
    var operation=document.getElementById("operation").value;
    var str=operation+"<?xml version = '1.0'?>\n\
                <data>";
                
    for(var i=0; i<values.length;i++){
        str=str+"<val"+i.toString()+">"+values[i]+"</val"+i.toString()+">";
    }
    str=str+"</data>";
    alert(str);
    alert(counter);
    $.ajax({
        
        type: 'POST',
        url: 'handle',
        data: 'value='+str+"&counter="+counter,
        success: function(data){
          $('#resultMessage').html(data);
        }
        
});
return false;
    });
        $( '#addbtn' ).click(function() {
            if(counter<11){
            var id="val"+counter.toString();
            $("#in-fields").append("<input class='in-value' type='text' id='"+id+"' name='"+id+"'>");
            counter++;
        }
        return false;
    });
    return false;
});


