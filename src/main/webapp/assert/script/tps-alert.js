/**
 * fmb 插件
 * @param msg
 * @param c
 */
function tpsAlert(msg,c){
    $(".alert").html(msg);
    $(".alert").fbmodal({
         title: "温馨提示",  
         cancel: "取消",
         okay: "确定",
         okaybutton: true,
         cancelbutton: false,
         buttons: true,
         opacity: 0.0,
         fadeout: false,
         overlayclose: true,
         modaltop: "30%",
         modalwidth: "400" ,
         opacity: 0.22
     },function(callback){
         if(c!=null&& c!='undefined'){
            c(callback); 
         }
     });
    $("#okay").attr("tabindex", "0");
    $("#okay").focus();
    $("#okay").keydown(function(e){
        // enter or escape
        if(e.keyCode==13 || e.keyCode==27){
            $("#okay").click();
        }
    });
    return true;
}
function tpsConfirm(msg,callback_OK,callback_CANCEL){
    $(".alert").html(msg);
    $(".alert").fbmodal({
        title: "温馨提示",  
        cancel: "取消",
        okay: "确定",
        okaybutton: true,
        cancelbutton: true,
        buttons: true,
        opacity: 0.0,
        fadeout: false,
        overlayclose: true,
        modaltop: "30%",
        modalwidth: "400" ,
        opacity: 0.22
    },function(callback){
    });
     $("#okay").click(function(){
            if(callback_OK && typeof callback_OK == "function")
                callback_OK( true );
        });
     $("#cancel").click(function(){
            if(callback_CANCEL && typeof callback_CANCEL== "function")
                callback_CANCEL( false );
        });
}
function tpsConfirms(msg, t, ok, cancel, c) {
    if (t == '') {
        t = "确认操作";
    }
    if (ok == '') {
        ok = "确定";
    }
    if (cancel == '') {
        cancel = "取消";
    }
    $(".alert").html(msg);
    $(".alert").fbmodal({
        title : t,
        cancel : cancel,
        okay : ok,
        okaybutton : true,
        cancelbutton : true,
        buttons : true,
        opacity : 0.0,
        fadeout : false,
        overlayclose : true,
        modaltop : "30%",
        modalwidth : "400",
        opacity : 0.22
    }, function(callback) {
        if (c != null && c != 'undefined') {
            var result = "cancel";
            if (callback == '1') {
                result = "ok";
            }
            c(result);
        }
    });
    $("#cancel").attr("tabindex", "0");
    $("#cancel").focus();
    $("#cancel").keydown(function(e) {
        // enter or escape
        if (e.keyCode == 13 || e.keyCode == 27) {
            $("#cancel").click();
        }
    });
    return true;
}
function tpsCustomizeConfirm(divHtml, width, t, ok, cancel, c) {
    if (ok == '') {
        ok = "确定";
    }
    if (cancel == '') {
        cancel = "取消";
    }
    if (width <= 0) {
        width = "400";
    }
    $(".alert").html(divHtml);

    var plugin = $(".alert").fbmodal({
        title : t,
        cancel : cancel,
        okay : ok,
        okaybutton : true,
        cancelbutton : true,
        buttons : true,
        opacity : 0.0,
        fadeout : false,
        overlayclose : true,
        modaltop : "30%",
        modalwidth : width,
        customized: true,
        allowclose: false,
        opacity : 0.22
    }, innerCallback);
    $(".alert").html("");
    $("#cancel").attr("tabindex", "0");
    $("#cancel").focus();
    $("#cancel").keydown(function(e) {
        // enter or escape
        if (e.keyCode == 13 || e.keyCode == 27) {
            $("#cancel").click();
        }
    });
    function innerCallback(callbackValue) {
        if (c != null && c != 'undefined') {
            var result = "cancel";
            if (callbackValue == '1') {
                result = "ok";
            }
            if(c(result)) {
                tpsAlertHide();
            }
        }
    }
    return true;
}
function tpsAlertHide() {
    $("#fbmodal").remove();
    $("#fbmodal_overlay").removeClass("fbmodal_overlay");
}