sap.ui.define([
	"sap/ui/core/mvc/Controller",
	"sap/tnt/NavigationListItem",
	"com/incture/util/formatter",
	"com/incture/util/util"
], function(Controller, NavigationListItem, formatter) {

	return Controller.extend("com.incture.controller.Master", {
		formatter: formatter,

		/**
		 * Called when a controller is instantiated and its View controls (if available) are already created.
		 * Can be used to modify the View before it is displayed, to bind event handlers and do other one-time initialization.
		 * @memberOf view.Details
		 */
		onInit: function() {
			var oComponent = this.getOwnerComponent();
			this._router = oComponent.getRouter();
			this._router.getRoute("master").attachPatternMatched(this._routePatternMatched, this);

			var oSideNavModel = new sap.ui.model.json.JSONModel();
			this.getView().setModel(oSideNavModel, "oSideNavModel");
			/*	var oFetchTokenModel = this.getOwnerComponent().getModel("oFetchTokenModel");
				this.token = oFetchTokenModel.getData().token;*/
			this.getMasterData();
			/** DO NOT Change this method call **/
			this._fnAttachPressEventToPanels();
		},

		_routePatternMatched: function(oEvent) {
			
			

		},

		getMasterData: function() {
			var that = this;
			var oSideNavModel = this.getView().getModel("oSideNavModel");
			var oModel = new sap.ui.model.json.JSONModel();
			oModel.loadData("model/init_data.json");
			oModel.attachRequestCompleted(function(oEvent) {
				if (oEvent.getParameter("success")) {
					var resultData = oEvent.getSource().getData();
					if (resultData) {
						oSideNavModel.setData(resultData);
						that.fnMasterItemSelectStyle("Dashboard")
						that.getUserDetails();
					}
				} else {
					sap.m.MessageToast.show("Internal Server Error");
				}
			});
			oModel.attachRequestFailed(function(oEvent) {
				sap.m.MessageToast.show("Internal Server Error");
			});
		},

		getUserDetails: function() {
			var oUserModel = this.getOwnerComponent().getModel("oUserModel");
			var sUrl = "/services/userapi/currentUser";
			var oModel = new sap.ui.model.json.JSONModel();
			var that = this;
			oModel.loadData(sUrl, true, "GET", false, false);
			oModel.attachRequestCompleted(function(oEvent) {
				if (oEvent.getParameter("success")) {
					var resultData = oEvent.getSource().getData();
					if (resultData) {
						oUserModel.setData(resultData);
						that.getRolesForUser();
					}
				} else {
					sap.m.MessageToast.show("Internal Server Error");
				}
			});
			oModel.attachRequestFailed(function(oEvent) {
				sap.m.MessageToast.show("Internal Server Error");
			});
		},

		/** Method is used to make the Panels expandable or not by checking, 	
		 * if the Subitems( list items) are present or not. Modify carefully.
		 */
		isExpandable: function(oNode) {
			if (oNode) {
				if (oNode.length > 0) {
					return true;
				} else {
					return false;
				}
			}
			return false;
		},

		 fnMasterItemSelectStyle: function(oContextPath) {
				var oVBox = this.getOwnerComponent()._oViews._oViews["com.incture.view.Master"].byId('inctureMDMasterVBox');
				var oVBoxItems = oVBox.getItems();
				var oPanelItems = "";
				for (var i = 0; i < oVBoxItems.length; i++) {
					oVBoxItems[i].removeStyleClass("inctureMDMasterPanelSolidClass");
					var oList = oVBoxItems[i].getContent()[0];
					if (oList.getSelectedItem() && (oList.getSelectedItem().getId())) {
						oList.removeSelections(true);
					}
					if (oVBoxItems[i].getHeaderToolbar().getContent()[1].getItems()[0].getText() === oContextPath) {
						oVBoxItems[i].addStyleClass("inctureMDMasterPanelSolidClass");
					}
				}
			},
		 
		_fnAttachPressEventToPanels: function() {
			var oPanel = this.byId('inctureMDMasterPanel');
			var that = this;
			oPanel.attachBrowserEvent("click", function() {
				var oPanel = this.getParent();
				var oList = oPanel.getContent()[0];
				var oItems = oList.getItems();
				// Expand or collapse based on list items length
				if (oPanel.getHeaderToolbar().getContent()[1].getItems()[0].getText() === "Dashboard") {
					that._router.navTo("dashboard");
				} else if (oPanel.getHeaderToolbar().getContent()[1].getItems()[0].getText() === "Create Request") {
					that._router.navTo("CreateRequest");
				} else if (oPanel.getHeaderToolbar().getContent()[1].getItems()[0].getText() === "View All Incidents") {
					that._router.navTo("ViewAllIncidents");
				} else if (oPanel.getHeaderToolbar().getContent()[1].getItems()[0].getText() === "Service Request") {
					that._router.navTo("serviceReq");
				} else if (oPanel.getHeaderToolbar().getContent()[1].getItems()[0].getText() === "Order History") {
					that._router.navTo("myOrders");
				} else {
					if (oPanel.getExpanded()) {
						oPanel.setExpanded(false);
					} else {
						oPanel.setExpanded(true);
					}
				}

				//Resetting of Classes.
				var oVBox = that.byId('inctureMDMasterVBox');
				var oVBoxItems = oVBox.getItems();
				for (var i = 0; i < oVBoxItems.length; i++) {
					oVBoxItems[i].removeStyleClass("inctureMDMasterPanelSolidClass");
					var oList = oVBoxItems[i].getContent()[0];
					oList.removeSelections(true);
				}
				oPanel.addStyleClass('inctureMDMasterPanelSolidClass');
			});
		},

		/**
		 * Used to remove the previous selection of list items present in Panels.
		 * DO NOT MODIFY.
		 */

		_fnRemoveParentPanelSelect: function(oEvent) {
			var oVBox = this.byId('inctureMDMasterVBox');
			var oVBoxItems = oVBox.getItems();
			for (var i = 0; i < oVBoxItems.length; i++) {
				oVBoxItems[i].removeStyleClass("inctureMDMasterPanelSolidClass");
				var oList = oVBoxItems[i].getContent()[0];
				if (oList.getSelectedItem() && (oList.getSelectedItem().getId() !== oEvent.getParameter('listItem').getId())) {
					oList.removeSelections(true);
				}
			}
		},

		/**
		 * Navigate to Details on click of list items
		 */
		onItemPress: function(oEvent) {
			//DO not remove the below function call.
			this._fnRemoveParentPanelSelect(oEvent);
			
			// ROuting changes can be done here.
			var contextPath = oEvent.getParameter('listItem');
			var sPath = contextPath.getBindingContext("oSideNavModel").getPath();
			var index = sPath.split("/")[4];
			/*if (index === "0") {
				this._router.navTo("selectBrand", {
					contextPath: "beverages"
				});
			} else if (index === "1") {
				this._router.navTo("selectBrand", {
					contextPath: "snacks"
				});
			} else {
				this._router.navTo("dashboard");
			}*/
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
		/*	onAfterRendering: function() {
		}
		*/
		/**
		 * Private method. MODIFY CAREFULLY.
		 * Method is fired on click on the panels. 
		 * Check if made to see if list items are present. 
		 * If list items are present, set expand true or false 
		 * else navigate to details page.
		 */

		/**
		 * Called when the Controller is destroyed. Use this one to free resources and finalize activities.
		 * @memberOf view.Details
		 */
		//		onExit: function() {
		//	
		//		}

	});
});