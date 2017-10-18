$("form").submit(function( event ) {
    event.stopImmediatePropagation();
    if($("#switch-sex").prop("checked"))
        $("#switch-sex").val("M");
    else
        $("#switch-sex").val("F");
    
    $("#switch-sex").prop( "checked", true );
    
    if($("#old").val()!==""){
        if($("#pwd1").val()===$("#pwd2").val()){
            $("#pwd2").prop('disabled',true);  
            return;
        }
        $("#pwdError").show();
    }
    event.preventDefault();
});

