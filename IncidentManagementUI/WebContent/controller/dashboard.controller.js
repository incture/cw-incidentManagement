sap.ui.define([
	"sap/ui/core/mvc/Controller",
	"com/incture/util/formatter",
	"com/incture/util/util"
], function(Controller, formatter) {

	return Controller.extend("com.incture.controller.dashboard", {
		formatter: formatter,

		/**
		 * Called when a controller is instantiated and its View controls (if available) are already created.
		 * Can be used to modify the View before it is displayed, to bind event handlers and do other one-time initialization.
		 * @memberOf view.Details
		 */
		onInit: function() {
			// this.oBusyInd = document.getElementById("idBusyIndicator");
			var that = this;
			var oComponent = this.getOwnerComponent();
			this._router = oComponent.getRouter();
			this._router.getRoute("dashboard").attachPatternMatched(this._routePatternMatched, this);
			
			var ChartModel = new sap.ui.model.json.JSONModel();
			this.getView().setModel(ChartModel,"ChartModel");
			var SModel = new sap.ui.model.json.JSONModel();
			this.getView().setModel(SModel, "SModel");
			SModel.loadData("./model/DBoard.json");
			this.getView().getModel("SModel").setProperty(
					"IncidentID", "", null, true);
			this.getView().getModel("SModel").setProperty("Status",
					"", null, true);
			this.getView().getModel("SModel").setProperty(
					"LineOfBusiness", "", null, true);
			this.getView().getModel("SModel").setProperty(
					"StartDate", "", null, true);
			this.getView().getModel("SModel").setProperty(
					"EndDate", "", null, true);

			var DModelPost = new sap.ui.model.json.JSONModel();
			this.getView().setModel(DModelPost, "DModelPost");
			var DModelGet = new sap.ui.model.json.JSONModel();
			this.getView().setModel(DModelGet, "DModelGet");
			var DModel = new sap.ui.model.json.JSONModel();
			this.getView().getModel("DModel");
			this.getView().setModel(DModel, "DModel");
			var ReporterIncidentModel = new sap.ui.model.json.JSONModel();
			var oView = this.getView();
			var oHeader = {
					"Content-Type" : "application/json; charset=utf-8"
				};
				// url to be changed to the new reporter incidents, open 
			var reporterUrl= "/IncidentManagementWeb/allincidents";
			oView.setBusy(true);

				ReporterIncidentModel.loadData(reporterUrl, null, true,
						"GET", true, true, oHeader);

			oView.setModel(ReporterIncidentModel, "ReporterIncidentModel");
			oView.setBusy(false);	
		
			
			
		},
		
		onSearch : function(oEvent) {
			var that = this;
			var oView = this.getView();
			var DHeader = {
				"Content-Type" : "application/json; charset=utf-8"
			};
			var DModelPost = this.getView().getModel("DModelPost");
			var url = "/IncidentManagementWeb/search";

			/*
			 * http://localhost:8413/SpringRestEx/search
			 */
			 var DModel = this.getView().getModel("DModel");
			 
			 
		  var lob = this.getView().byId("LineOfBusiness").getSelectedKey();
          var priority = this.getView().byId("Priority").getSelectedKey();
          var status = this.getView().byId("Status").getSelectedKey();

			var obj = {
				"lineOfBusiness" : lob,
				"priority" : priority,
				"status" : status
			};
			
			
			var data = JSON.stringify(obj);
			console.log("xyz");
			this.getView().setBusy(true);
			DModelPost.attachRequestCompleted(function(oEvent) {
				console.log("inside completed");
				oView.setBusy(false);
				console.log(oEvent.getSource().getData());
				var c = [];
				var a = DModelPost.getData();
				var i=0 ;
				for(i=0; i<a.length; i++)
				{
					c.push(a[i].incidentPriority);
				}
			//	console.log(c)
				
				var obj2 = {};
				obj2['c']=c;
				
			
			
var low=0 ;
var medium=0;
var high =0;
var critical =0;
for(i=0;i<c.length;i++){
	
			if(c[i] === "Medium"){
medium++;
}
			if(c[i] === "Low"){
				low++;
			}
			if(c[i] === "High"){
high++;
}
			if(c[i] === "Critical"){
critical++;
}
		
			}
/*	c.filter(function(obj2, i, c){
					if(c[i] === "High"){
						high = high + 1;
					}else if(c[i] === "Medium"){
						medium = medium + 1;
					}else if(c[i] === "Low"){
						low = low + 1;
					}else if(c[i] === "Critical"){
						critical = critical + 1;
					}
				});
				*/
		var oLowPriorObj = {
			priority: "Low",
			value: low
		};
		var oMediumPriorObj = {
			priority: "Medium",
			value: medium
		};
		var oHighPriorObj = {
			priority: "High",
			value: high
		};
		var oCriticalPriorObj = {
			priority: "Critical",
			value: critical
		};
		 
		var oArray = [oLowPriorObj, oMediumPriorObj, oHighPriorObj, oCriticalPriorObj];
		 var oData={};
		 
		 oData['oData']=oArray;
		 

 //console.log(low,medium,high,critical);
 
 			var ChartModel =oView.getModel("ChartModel");
			ChartModel.setProperty("/oData", oData);
			
//old code resumes
/*				DModelPost.refresh();
*/			});
			DModelPost.attachRequestFailed(function(oEvent) {
/*				DModelPost.refresh();
*/			});
			DModelPost.loadData(url, data, true, "POST", false,
					false, DHeader);
			/*
			 * DModelGet.loadData(url,data, true, "GET", false,
			 * false, DHeader);
			 * 
			 * DModelGet.attachRequestCompleted(function(oEvent) {
			 * this.getView.setModel(DModelGet,"DModelGet");
			 * DModelGet.refresh(); that.getView().setBusy(false);
			 * });
			 * 
			 * DModelGet.attachRequestFailed(function(oEvent) {
			 * DModel.refresh(); })
			 */
			 
			 
			 
			 //CHARTS
			 
			 
		},

		incidentAction : function(oEvent) {
			//console.log("inside incidentaction");
			var oHeader = {
				"Content-Type" : "application/json; charset=utf-8"
			};
			var oView = this.getView();
			var that = this;
			oView.setBusy(true);
			
			if (!this.oDialog) {
				this.oDialog = sap.ui.xmlfragment("com.incture.fragments.frag", this);
				oView.addDependent(this.oDialog);
			}
			
			var ApprovalModel = new sap.ui.model.json.JSONModel();
			var rowID = oEvent.getSource().getText().toString();
			var Table_url = "/IncidentManagementWeb/getapproval/";

			var Table_urlFinal = Table_url + rowID;
			oView.setModel(ApprovalModel, "ApprovalModel");
			ApprovalModel.loadData(Table_urlFinal, null, true,"GET", false, false, oHeader);
			
			ApprovalModel.attachRequestCompleted(function(oEvent) {
				//oView.setModel(ApprovalModel, "ApprovalModel");
				//console.log("attached req com");
				/*if (!that.oDialog) {
					that.oDialog = sap.ui.xmlfragment(
							"com.incture.fragments.frag", that);
					 var oView = that.getView();
					oView.addDependent(that.oDialog);
					that.oDialog.open();
				}*/
				that.oDialog.open();
				ApprovalModel.refresh();
				oView.setBusy(false);
			});

			ApprovalModel.attachRequestFailed(function(oEvent) {
				ApprovalModel.refresh();
			});
			

		},

		onclose : function(oEvent) {
			
			// var oView = this.getView();
//this.oEvent.getSource().getParent().close();
			this.oDialog.close();
		},
	

		/**
		 * Perform activities to be done when navigating to details page.
		 */
		_routePatternMatched: function(oEvent) {
			
		}

		/**
		 * Similar to onAfterRendering, but this hook is invoked before the controller's View is re-rendered
		 * (NOT before the first rendering! onInit() is used for that one!).
		 * @memberOf view.Details
		 */
		//		onBeforeRendering: function() {
		//	
		//		},

		/**
		 * Called when the View has been rendered (so its HTML is part of the document). Post-rendering manipulations of the HTML could be done here.
		 * This hook is the same one that SAPUI5 controls get after being rendered.
		 * @memberOf view.Details
		 */
		//		onAfterRendering: function() {
		//	
		//		},

		/**
		 * Called when the Controller is destroyed. Use this one to free resources and finalize activities.
		 * @memberOf view.Details
		 */
		//		onExit: function() {
		//	
		//		}
	});
});