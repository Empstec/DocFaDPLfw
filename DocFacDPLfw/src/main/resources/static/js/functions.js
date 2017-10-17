/* global selected, documents, selectedDocument */

$("#createDocument").submit(function( event ) {
    
    if($("#titleNewDocument").val() === "")
        $(".title-error").show();
    else
        $(".title-error").hide();
    
    if($("#titleNewDocument").val().length > 255)
        $(".title-length-error").show();
    else
        $(".title-length-error").hide();
    
    if($("#description").val().length > 255)
        $(".desc-error").show();
    else
        $(".desc-error").hide();
    
    if($("#description").val().length <= 255 && $("#titleNewDocument").val().length <= 255 && $("#titleNewDocument").val() !== "")
        return;
    
    event.preventDefault();
});

$("#formDeleteDocument").submit(function( event ) {
    
    event.stopImmediatePropagation();
    
    var csrfHeader = $("meta[name='_csrf_header']").attr("content");
    
    var header = {};
    header[csrfHeader] = $("meta[name='_csrf']").attr("content");
    
    var data = {
        "idDocument": selected
    };
    
    $.ajax({
        url: "/rest/deleteDocument",
        type: "POST",
        contentType : "application/json",
        dataType : "json",
        headers: header,
        data: JSON.stringify(data),
        success: function(response){ // response = JSON Object 
            if($.isEmptyObject(response)){
                $(selectedDocument).remove();
                $("#deleteDocument").modal("hide");
                
                delete documents[selected]; // Remove element from documents variable
                selected = 0; // Reset variable
                $(".document").mouseout();
                
                selectedDocument = {};
                
                // Ok Message
                $.notify(
                        {
                            message : "Documento eliminado satisfactoriamente",
                            icon : "fa fa-check-circle-o"
                        },{
                            placement : {
                                align : "center" 
                            },
                            delay : 2500,
                            type : "success",
                            mouse_over : "pause"
                        });
            }else{
                // Show error message
                $.notify(
                    {
                        message : "Error al eliminar el documento",
                        icon : "fa fa-exclamation-triangle"
                    },{
                        placement : {
                            align : "center" 
                        },
                        delay : 2500,
                        type : "danger",
                        mouse_over : "pause"
                    });
            }
        },
        error: function(errorResponse){ // errorResponse = JSON Object 
            // Show error message
            $.notify(
                {
                    message : "Error al eliminar el documento",
                    icon : "fa fa-exclamation-triangle"
                },{
                    placement : {
                        align : "center" 
                    },
                    delay : 2500,
                    type : "danger",
                    mouse_over : "pause"
                });
        }
    });
    
    return false;

});

$(document).ready(function(){
    $('[data-tooltip="tooltip"]').tooltip({trigger:'hover'});
});

$(document).on("mouseover",".document",function(){
    var temporal = $(this).find(".document-element").attr("id");
    
    if(selected === 0){
        $("#right-document-info").show();
        $("#document-title").text(documents[temporal]['title']);
        
        if(typeof documents[temporal]['description'] === "undefined"){
            $("#document-description").removeClass("right-text");
            $("#document-description").text("none");
        }else{
            $("#document-description").addClass("right-text");
            $("#document-description").text(documents[temporal]['description']);
        }
    
        $("#document-creation").text(documents[temporal]['creation'].split(".")[0]);
        
        if(typeof documents[temporal]['lastEdition'] === "undefined"){
            $("#document-lastEdition").removeClass("right-text");
            $("#document-lastEdition").text("none");
        }else{
            $("#document-lastEdition").addClass("right-text");
            $("#document-lastEdition").text(documents[temporal]['lastEdition'].split(".")[0]);
        }
    }
});

$(document).on("mouseout",".document",function(){
    if(selected === 0)
        $("#right-document-info").hide();
});

$(document).on("click",".document",function(event){
    event.stopImmediatePropagation();
    
    selectedDocument = $(this).parent(".home-element");
    selected = $(this).find(".document-element").attr("id");
    
    
    $("#document-title").text(documents[selected]['title']);
    if(typeof documents[selected]['description'] === "undefined"){
        $("#document-description").removeClass("right-text");
        $("#document-description").text("none");
    }else{
        $("#document-description").addClass("right-text");
        $("#document-description").text(documents[selected]['description']);
    }
        
    $("#document-creation").text(documents[selected]['creation'].split(".")[0]);
        
    if(typeof documents[selected]['lastEdition'] === "undefined"){
        $("#document-lastEdition").removeClass("right-text");
        $("#document-lastEdition").text("none");
    }else{
        $("#document-lastEdition").addClass("right-text");
        $("#document-lastEdition").text(documents[selected]['lastEdition'].split(".")[0]);
    }
});

$(document).on("dblclick",".document-element",function(){
    // Go to document view/editor
});