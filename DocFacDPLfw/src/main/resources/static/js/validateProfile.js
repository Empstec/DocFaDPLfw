$("form").submit(function( event ) {
    
    if($("#pwd1").val()===$("#pwd2").val() && $("#pwd1").val()!=="" && $("#pwd2").val()!=="" ){
    $("#pwd2").prop('disabled',true);  
        return;
    }
    $("#pwdError").show();
    event.preventDefault();
});