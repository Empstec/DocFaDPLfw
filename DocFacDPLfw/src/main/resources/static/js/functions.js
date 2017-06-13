$(document).on("click","#saveDoc",function(){
    $('input.infDoc').each(function() {
        $("<span />", { text: this.value, "class":"view" }).insertAfter(this);
        $(this).hide();
    });
    $(this).hide();
    $(".tableContent").show();
});

$(document).on("click","#add",function(){
    $("#tableContent").children("tbody").append("<tr><td><select class=\"selectType\" data-numberType=\"1\"><option value=\"title\">T&iacute;tulo</option><option value=\"subtitle\">Subt&iacute;tulo</option><option value=\"paragraph\">Texto</option></select></td><td colspan=2><input type=\"text\" class=\"contentDITA\" data-numberContent=\"1\"/></td></tr>");
});


$(document).on("click","#saveAll",function(){
    elements = {};
    $(".selectType").each(function(i,value){
        elements[i]={};
        elements[i][0] = $(value).val();
    });
    
    $(".contentDITA").each(function(i,value){
        elements[i][1] = $(value).val(); 
    });
    
    $.ajax({
        url:'saveDoc',
        type:'POST',
        data:{'elements':JSON.stringify(elements),'title':$("#titleDoc").val(),'desc':$("#descDoc").val()},
        success:function(r){
            if(r==='true')
                window.location = "view.jsp";
        }
    });
    
});