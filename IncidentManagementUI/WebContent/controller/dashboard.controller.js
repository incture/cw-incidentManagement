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
			
			var SModel = new sap.ui.model.json.JSONModel();
			this.getView().setModel(SModel, "SModel");
			SModel.loadData("./JSON/DBoard.json");
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
			
			
		},
		
		onSearch : function() {
			var that = this;
			var oView = this.getView();
			var DHeader = {
				"Content-Type" : "application/json; charset=utf-8"
			};
			var DModelPost = this.getView().getModel("DModelPost");
			var url = "http://localhost:9014/SpringRestEx/search";

			/*
			 * http://localhost:8413/SpringRestEx/search
			 */var DModel = this.getView().getModel("DModel");
			var obj = {
				"lineOfBusiness" : DModelPost.getData().lob,
				"priority" : DModelPost.getData().priority,
				"status" : DModelPost.getData().status
			};
			var data = JSON.stringify(obj);
			console.log("xyz");
			this.getView().setBusy(true);
			DModelPost.attachRequestCompleted(function(oEvent) {
				console.log("inside completed")
				oView.setBusy(false);
				console.log(oEvent.getSource().getData());
				DModelPost.refresh();
			});
			DModelPost.attachRequestFailed(function(oEvent) {
				DModelPost.refresh();
			});
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
			 * DModel.refresh(); });
			 */
		},

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
			var Table_url = "http://localhost:9014/SpringRestEx/getapproval/";

			var Table_urlFinal = Table_url + rowID;

			ApprovalModel.attachRequestCompleted(function(oEvent) {
				oView.setBusy(false);

				oView.setModel(ApprovalModel, "ApprovalModel");
				console.log("attached req com");
				if (!oDialog) {
					var oDialog = sap.ui.xmlfragment(
							"dashboard.frag", this);
					// var oView = this.getView();
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

		onclose : function(oEvent) {
			console.log("button");

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