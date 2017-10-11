/* global selected, documents */

$("#createDocument").submit(function( event ) {
    if($("#titleNewDocument").val()!=="" ){
        return;
    }
    $(".title-error").show();
    event.preventDefault();
});

$("#deleteDocument").submit(function( event ) {
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
                // Clean layout and onjects
                $.notify("BORRADO");
            }else{
                // Show error message
            }
            
        },
        error: function(errorResponse){ // errorResponse = JSON Object 
            // Show error message
        }
    });
    
    event.preventDefault();
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

$(document).on("click",".document",function(){
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