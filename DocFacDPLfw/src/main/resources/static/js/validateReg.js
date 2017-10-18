$("#switch-sex").prop('checked', true);

$("form").submit(function( event ) {
    
    if($("#switch-sex").prop("checked"))
        $("#switch-sex").val("M");
    else
        $("#switch-sex").val("F");
    
    $("#switch-sex").prop( "checked", true );

    if($("#pwd1").val()===$("#pwd2").val() && $("#pwd1").val()!=="" && $("#pwd2").val()!=="" ){
    $("#pwd2").prop('disabled',true);  
        return;
    }
    $("#pwdError").show();
    event.preventDefault();
});