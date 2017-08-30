$("form").submit(function( event ) {
    if($("#old").val()!==""){
        if($("#pwd1").val()===$("#pwd2").val()){
        $("#pwd2").prop('disabled',true);  
            return;
        }
        $("#pwdError").show();
    }
    event.preventDefault();
});

