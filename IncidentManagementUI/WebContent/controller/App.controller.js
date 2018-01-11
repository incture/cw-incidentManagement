sap.ui.define(["sap/ui/core/mvc/Controller",
"com/incture/util/util"
], function(Controller) {

	return Controller.extend("com.incture.controller.App", {

		/**
		 * Called when a controller is instantiated and its View controls (if available) are already created.
		 * Can be used to modify the View before it is displayed, to bind event handlers and do other one-time initialization.
		 * @memberOf view.Details
		 */
		onInit: function() {
			var oComponent = this.getOwnerComponent();
			this._router = oComponent.getRouter();
			/*var oFetchTokenModel = this.getOwnerComponent().getModel("oFetchTokenModel");
			var oUrl="/destination/bpmrulesruntime/rules-service/v1/rules/xsrf-token";
			var token = fetchToken(oUrl);
			oFetchTokenModel.setData({"token":token});*/
		},
		/**
		 * Method is called when user starts searching in the SearchField.
		 * @param: event - search event.
		 */
		
		onSuggest: function(event) {
			var value = event.getParameter("suggestValue");
			var oSearchField = this.byId("searchField");
			var filters = [];
			if (value) {
				filters = [new sap.ui.model.Filter([new sap.ui.model.Filter(
					"desc",
					function(sDes) {
						return (sDes || "").toUpperCase().indexOf(
							value.toUpperCase()) > -1;
					})])];
			}

			oSearchField.getBinding("suggestionItems").filter(filters);
			oSearchField.suggest();
		},

		/**
		 * Method is called when user selects a element from SearchField only.
		 */
		onSearch: function(event) {
			var item = event.getParameter("suggestionItem");
			if (item) {
				sap.m.MessageToast.show("search for: " + item.getText());
			}
		},

		/**
		 * UserPreference fragment is called and shown to user. 
		 * To change the user information, please change UserPreference.fragment.xml
		 */

		onUserPress: function(oEvent) {
			var oView = this.getView();
			var oDialog = oView.byId("userDialog");
			// create dialog lazily
			if (!oDialog) {
				// create dialog via fragment factory
				oDialog = sap.ui.xmlfragment(oView.getId(), "com.incture.view.userPreference", this);
				oView.addDependent(oDialog);
			}
			oDialog.openBy(oEvent.getSource());
		},

		/**
		 * Used to show  the master page on click of menu button.
		 * DO NOT CHANGE.
		 */
		onShowMaster: function(oEvent) {
			var oSplitApp = this.getView().byId('idSplitApp');
			if (oSplitApp.isMasterShown()) {
				oSplitApp.hideMaster();
			} else {
				oSplitApp.showMaster();
				this._router.navTo("master");
			}
		},

		/*
		 * Function is called when user clicks on the notification icon
		 * To change NotificationPanel, please change NotificationPanel.fragment.xml
		 */
		handleNotifications: function(oEvent) {
			var oView = this.getView();
			var oDialog = oView.byId("inctureMDNotifications");
			// create dialog lazily
			if (!oDialog) {
				// create dialog via fragment factory
				oDialog = sap.ui.xmlfragment(oView.getId(), "com.incture.view.notificationPanel", this);
				oView.addDependent(oDialog);
			}
			oDialog.openBy(oEvent.getSource());
		},

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
		onAfterRendering: function() {
			this.fnDeviceCheck();
			this._router.navTo("dashboard");
		},

		fnDeviceCheck: function() {
			var that = this;
			if (sap.ui.Device.system.desktop || sap.ui.Device.system.tablet) {
				this.getView().byId("idShell").setSearchVisible(true);
				this.getView().byId("idHdrMenu").setVisible(false);
				this.getView().byId("idShell").setIcon("./images/logoCW.png");
			} else {
				this.getView().byId("idShell").setSearchVisible(false);
				this.getView().byId("idHdrMenu").setVisible(true);
				this.getView().byId("idShell").setIcon("");
			}
			sap.ui.Device.resize.attachHandler(function() {
				if (sap.ui.Device.resize.width > 1020) {
					that.getView().byId("idShell").setSearchVisible(true);
				} else {
					that.getView().byId("idShell").setSearchVisible(false);
				}

				if (sap.ui.Device.resize.width > 800) {
					that.getView().byId("idHdrMenu").setVisible(false);
					that.getView().byId("idShell").setIcon("./images/logoCW.png");
				} else {
					that.getView().byId("idHdrMenu").setVisible(true);
					that.getView().byId("idShell").setIcon("");
				}
			});
		},

		onLogout: function(oEvent) {
			// callLogout();
	    	sap.m.URLHelper.redirect("WebContent/logout.html", false);
		},

		onUserSettingsPress: function(oEvent) {
			this._router.navTo("userProfile");
			this.fnMasterItemSelectStyle("My Profile");
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
			}
			/**
			 * Called when the Controller is destroyed. Use this one to free resources and finalize activities.
			 * @memberOf view.Details
			 */
			//		onExit: function() {
			//
			//		}
	});
});