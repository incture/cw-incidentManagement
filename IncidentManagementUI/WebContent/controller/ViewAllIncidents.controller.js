sap.ui.define([
	"sap/ui/core/mvc/Controller",
	"com/incture/util/formatter",
	"com/incture/util/util"
], function(Controller, formatter) {

	return Controller.extend("com.incture.controller.ViewAllIncidents", {
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
			this._router.getRoute("ViewAllIncidents").attachPatternMatched(this._routePatternMatched, this);
			
			
			var that = this;
			var ApprovalModel= new sap.ui.model.json.JSONModel();
			var IncidentModel = new sap.ui.model.json.JSONModel();
			var oView = this.getView();
			var oHeader = {
					"Content-Type" : "application/json; charset=utf-8"
				};
			var DHeader = {
					"Content-Type" : "application/json; charset=utf-8"
				};
			var Geturl= "/IncidentManagementWeb/allincidents";
			oView.setBusy(true);

				IncidentModel.loadData(Geturl, null, true,
						"GET", true, true, oHeader);

				console.log(IncidentModel.getData());
			oView.setModel(IncidentModel, "IncidentModel");
			oView.setBusy(false);	
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
				this.oDialog = sap.ui.xmlfragment("com.incture.fragments.screen2frag", this);
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
		
		/*
		incidentAction : function(oEvent) {
			console.log("inside incidentaction");
			var IHeader = {
				"Content-Type" : "application/json; charset=utf-8"
			};
			var oView = this.getView();
			var that = this;
			oView.setBusy(true);
			var ApprovalModel = new sap.ui.model.json.JSONModel();
			var rowID = oEvent.getSource().getText().toString();
			var Table_url = "http://localhost:8501/SpringRestEx/getapproval/";

			var Table_urlFinal = Table_url + rowID;

			ApprovalModel.attachRequestCompleted(function(oEvent) {
				oView.setBusy(false);

				oView.setModel(ApprovalModel, "ApprovalModel");
				console.log("attached req com");
				if (!oDialog) {
					var oDialog = sap.ui.xmlfragment(
							"com.incture.fragments.screen2frag",this);
//					var oView = this.getView();
					oView.addDependent(oDialog);
					oDialog.open();
				}

				ApprovalModel.refresh();
			});

			ApprovalModel.attachRequestFailed(function(oEvent) {
				Approval.refresh();
			});
			ApprovalModel.loadData(Table_urlFinal, null, true,
					"GET", false, false, IHeader);

		},
		
		dateConverter: function(date_in) {
			var date = new Date(0);
			date.setUTCSeconds(date_in);
			return date;
		},
		onclose_apprvl: function(oEvent){
			this.oDialog.close();
			//this.getOwnerComponent().getRouter().navTo("dashboard");
							},

							//dailog open
							
							onlinkclick: function(oEvent) {

								this.ologindailog().open(oEvent.getSource());
							},

							onloginclose: function(oEvent) {
								this.getOwnerComponent().getRouter().navTo("dashboard");
							},
*/

		

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