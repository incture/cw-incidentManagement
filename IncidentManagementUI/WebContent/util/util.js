function fetchToken(oUrl){
    var token;
    $.ajax({
        url: oUrl,
        method: "GET",
        async: false,
        headers: {
            "X-CSRF-Token": "Fetch"
        },
        success: function(result, xhr, data) {
            token = data.getResponseHeader("X-CSRF-Token");
        },
        error: function(result,xhr,data)
        {
        token = result.getResponseHeader("x-csrf-token");
        }
    });
    return token;
}

function successAlertBox(msg){
	  jQuery.sap.require("sap.m.MessageBox");
	  sap.m.MessageBox.success(msg, {
          icon: sap.m.MessageBox.Icon.SUCCESS,
          styleClass: "fontClass",
          title: "Information"
      });
};

function failureAlertBox(msg){
	  jQuery.sap.require("sap.m.MessageBox");
	  sap.m.MessageBox.error(msg, {
          icon: sap.m.MessageBox.Icon.ERROR,
          styleClass: "fontClass",
          title: "Information"
	  });
};

function getLoggedInUser(){
	var user = getJSONData("/brms/project/logon","GET",null).getData();
	return user;
};

//date format

function getMonthName(monthCount) {
	var month = ["Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sept","Oct","Nov","Dec"];
	return month[monthCount];
}

function getJSONData(url,method,oParam){
	var oHeader={"Content-Type":"application/json; charset=utf-8"};
	var oModel = new sap.ui.model.json.JSONModel(); 
	oModel.loadData(url,JSON.stringify(oParam), false,method,false,false,oHeader);
	oModel.attachRequestCompleted(function(evt){
		//debugger;
	});
	oModel.attachRequestFailed(function(){
    	alert('Request Failed!');
	});
    
    if(oModel.getData() && Object.keys(oModel.getData()).length){
    	//If Data exist
    }else{
    	 var msg = 'No Data Available';
    	 oModel.setProperty("/msg",msg);
    	 oModel.setProperty("/msgStatus","0");
    } 
    return oModel;
};