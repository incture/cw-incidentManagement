sap.ui.define([
	"sap/ui/core/mvc/Controller",
	"com/incture/util/formatter",
	"com/incture/util/util"
], function(Controller, formatter) {

	return Controller.extend("com.incture.controller.CreateRequest", {
		formatter: formatter,

		/**
		 * Called when a controller is instantiated and its View controls (if available) are already created.
		 * Can be used to modify the View before it is displayed, to bind event handlers and do other one-time initialization.
		 * @memberOf view.Details
		 */
		onInit: function() {
			this.oBusyInd = document.getElementById("idBusyIndicator");
			this.todaydate();
			
			var mod4 = new sap.ui.model.json.JSONModel();//for the post data by create press define init
		this.getView().setModel(mod4,"mod4");
		//
			
		
			var model = new sap.ui.model.json.JSONModel();// for the lob , type, action , pririty, accesing it from the model 
			var oView = this.getView();
			model.attachRequestCompleted(function(oEvent) {
				oView.setModel(model, "model");
			});
			model.attachRequestFailed(function(oEvent) {
				sap.m.messageToast.show("Failed to load data");

			});
			model.loadData("model/incidentmanagement.json", null, false);
			model.setProperty("/priorityaction", "");

			this.getView().setModel(model, "incidentmanagement");

			var that = this;
			var oComponent = this.getOwnerComponent();
			this._router = oComponent.getRouter();
			this._router.getRoute("CreateRequest").attachPatternMatched(this._routePatternMatched, this);

		 	
		 	

		    
			
			//
			
			
//			//o data service for the WORK TYPE
			var mod1 = new sap.ui.model.json.JSONModel();
			var oView = this.getView();
				mod1.attachRequestCompleted(function(oEvent) {
				oView.setModel(mod1, "mod1");
			});
			var baseurl = "/sap/opu/odata/sap/ZSL_IM_SRV/EtAuartSet?$format=json";
			
			if (window.location.hostname == "localhost") {
			      baseurl= "proxy" + baseurl;
			  }

			
			console.log(baseurl);
			mod1.loadData(baseurl, true, "GET", false, false);
			
			this.getView().setModel(mod1, "mod1");
			console.log("mod1 loaded");
		
			
			//
			
			//o data service for the WORK TYPE
			
//	          var svcUrl="http://34.210.142.28:8080/sap/opu/odata/sap/ZSL_IM_SRV";
//	          //when you create OData Model then its hits the service and get metadata
//	          var oDataModel= new sap.ui.model.odata.ODataModel(svcUrl,true,"wsoudagar","soudagar");
//	          oDataModel.read("/EtAuartSet?$format=json",null,null,false,function(oData,oRes){
//	        	  that.mod1.setData(oData);
//	             
//	          console.log(that.mod1.getData());
//	          
//		},
//	         function(oError){
//	                          console.log('error');
//	                          },
//	                         
//	                         function(oSuccess)
//	                          {
//	                                          console.log('Success');
//	                          
//		});
			
			
		
			
			//
			
//			//rest service for the user info
				var mod2 = new sap.ui.model.json.JSONModel();
			var oView = this.getView();
				mod2.attachRequestCompleted(function(oEvent) {
				oView.setModel(mod2, "mod2");
			});
			var baseurl2 = "http://172.16.30.238:8080/SpringRestEx/get/USR0001.json";

			console.log(baseurl2);
			mod2.loadData(baseurl2, true, "GET", false, false);
			
			this.getView().setModel(mod2, "mod2");
			console.log("mod2 loaded");
          //
		},
		
		
		
		//here  calling the o data palnt palnnig url concatning by the worktype 
		onChangeWorkType : function(oEvent){
			var mod3 = new sap.ui.model.json.JSONModel();
		    var oView = this.getView();
				mod3.attachRequestCompleted(function(oEvent) {
				oView.setModel(mod3, "mod3");
			});
			var locav = true;
			
			try{
			var locname = oEvent.getSource().getValue();
			}
			catch(err){
			locav=false;
			}
			if(locav){
			var  baseurl3="/sap/opu/odata/sap/ZSL_IM_SRV/planningplantSet?$filter=ImAufnr%20eq%20%27"+locname+"%27";
			
			if (window.location.hostname == "localhost") {
				baseurl3= "proxy" + baseurl3;
			  }

			}
	       	console.log(baseurl3);
			mod3.loadData(baseurl3, true, "GET", false, false);
			
			this.getView().setModel(mod3, "mod3");
			console.log("mod3 loaded");
			//
		},
		//
		
		//here  calling the o data  url concatning by the planningplant 
		onChangePlanningPlant: function(oEvent){
			var mod5 = new sap.ui.model.json.JSONModel();
			var oView = this.getView();//business area
			mod5.attachRequestCompleted(function(oEvent) {
				oView.setModel(mod5, "mod5");
				console.log(oEvent.getSource().getData());

			});
			var mod6 = new sap.ui.model.json.JSONModel(); //for work area
			mod6.attachRequestCompleted(function(oEvent) {
				oView.setModel(mod6, "mod6");
			});
			var mod7 = new sap.ui.model.json.JSONModel(); //funct luct
			mod7.attachRequestCompleted(function(oEvent) {
				oView.setModel(mod7, "mod7");
			});
			var mod8 = new sap.ui.model.json.JSONModel(); //for equptment
			mod8.attachRequestCompleted(function(oEvent) {
				oView.setModel(mod8, "mod8");
			});
			var mod9 = new sap.ui.model.json.JSONModel(); //for planning grp
		    
		    mod9.attachRequestCompleted(function(oEvent) {
				oView.setModel(mod9, "mod9");
			});
				
			var locaw = true;
			
			try{
			var locname2 = oEvent.getSource().getValue();
			}
			catch(err){
			locav=false;
			}
			if(locaw){
			var  baseurl4="/sap/opu/odata/sap/ZSL_IM_SRV/businessareaSet?$filter=ImWerks%20eq%20%27"+locname2+"%27";
			
			if (window.location.hostname == "localhost") {
				baseurl4= "proxy" + baseurl4;
			  }

			}
	       	console.log(baseurl4);
			mod5.loadData(baseurl4, true, "GET", false, false);
			
			//this.getView().setModel(mod5, "mod5");
			console.log("mod5 loaded");
			
			//here  calling the o data work area url concatning by the planningplant 
			if(locaw){
				var  baseurl5="/sap/opu/odata/sap/ZSL_IM_SRV/mainworkareaSet?$filter=ImWerks%20eq%20%27"+locname2+"%27";
				
				if (window.location.hostname == "localhost") {
					baseurl5= "proxy" + baseurl5;
				  }

				}
		       	console.log(baseurl5);
				mod6.loadData(baseurl5, true, "GET", false, false);
				
				this.getView().setModel(mod6, "mod6");
				console.log("mod6 loaded");
			
			//
				
				//here  calling the o data fun loc url concatning by the planningplant 
				if(locaw){
					var  baseurl6="/sap/opu/odata/sap/ZSL_IM_SRV/functionallocSet?$filter=ImWerks%20eq%20%27"+locname2+"%27";
					
					if (window.location.hostname == "localhost") {
						baseurl6= "proxy" + baseurl6;
					  }

					}
			       	console.log(baseurl6);
					mod7.loadData(baseurl6, true, "GET", false, false);
					
					this.getView().setModel(mod7, "mod7");
					console.log("mod7 loaded");
				
				//
					
					//here  calling the o data equptmnt url concatning by the planningplant 
					if(locaw){
						var  baseurl7="/sap/opu/odata/sap/ZSL_IM_SRV/businessareaSet?$filter=ImWerks%20eq%20%27"+locname2+"%27";
						
						if (window.location.hostname == "localhost") {
							baseurl7= "proxy" + baseurl7;
						  }

						}
				       	console.log(baseurl7);
						mod8.loadData(baseurl7, true, "GET", false, false);
						
						this.getView().setModel(mod8, "mod8");
						console.log("mod8 loaded");
					
					//
						//here  calling the o data planng grp url concatning by the planningplant 
						if(locaw){
							var  baseurl8="/sap/opu/odata/sap/ZSL_IM_SRV/planninggroupSet?$filter=ImWerks%20eq%20%27"+locname2+"%27";
							
							if (window.location.hostname == "localhost") {
								baseurl8= "proxy" + baseurl8;
							  }

							}
					       	console.log(baseurl8);
							mod9.loadData(baseurl8, true, "GET", false, false);
							
							this.getView().setModel(mod9, "mod9");
							console.log("mod9 loaded");
						
						//
		},
		//
		
		
		
		
		
		
		
		
		//for the post data by create press
	
	onreateClick:function(){
		var that = this;

		var oHeader = {
				"Accept":"application/json",
				"Content-Type": "application/json"
				};
		var mod4 =this.getView().getModel("mod4");
	    var oView = this.getView();
	    var mod2 =this.getView().getModel("mod2");
	    var model =this.getView().getModel("model");
//	    var changedt= model.getData().startdate;
			
		var url = "proxy/http/172.16.30.238:8080/SpringRestEx/create";
	    //var url = "http:///172.16.30.238:8080/SpringRestEx/create";
		
		var obj =	{
			  "userId": mod2.getData().userId,
			  "incident": {
			    "incidentId": null,
			    "incidentLob": mod4.getData().lob,
			    "incidentType": mod4.getData().type,
			    "incidentDescription": mod4.getData().Desrpt,
			    "incidentPriority": mod4.getData().Priorty,
			    "createdDate": "658577643453",
			    "finishDate": "658577643453",
			    "incidentStatus": "OPEN",
			    "reportedDate": "658577643453",
			    "assignedGroup": mod4.getData().Assignd_grp,
			    "assignedTo": "SomePerson",
			    "assignedDate": "658577643453"
			  },
			  "wo": {
			    "workId": null,
			    "workEquipment": mod4.getData().Work_eqpt,
			    "workCenter": mod4.getData().Work_centr,
			    "funcLoc": mod4.getData().Fun_loc,
			    "assembly": mod4.getData().assembly,
			    "controlKey": mod4.getData().Contr_key,
			    "activityType": mod4.getData().Actvty_typ,
			    "planningGroup": mod4.getData().Plng_grp,
			    "planningPlant": mod4.getData().Planng_plant,
			    "busArea": mod4.getData().Bus_ar,
			    "workDescription": "This is Test Description",
			    "workorderId": "W003"
			  }
			};

		
		
		this.getView().setBusy(true);
		var data = JSON.stringify(obj);
		mod4.loadData(url, data, true, "POST", false, false, oHeader);
		mod4.attachRequestCompleted(function(oEvent) {
		mod4.refresh();
		that.getView().setBusy(false);
		});
		
		
		mod4.attachRequestFailed(function(oEvent) {
			mod4.refresh();
		});
		
	},
	//
		
		
		// for the description box giving the warning 
		handleLiveChange: function(oEvent) {
			var oTextArea = oEvent.getSource(),
				iValueLength = oTextArea.getValue().length,
				iMaxLength = oTextArea.getMaxLength(),
				sState = iValueLength > iMaxLength ? "Warning" : "None";

			oTextArea.setValueState(sState);
		},

		// on clicking the cancel nav to the dash board
		onCancelClick: function() {
			this.getOwnerComponent().getRouter().navTo("dashboard");

		},

		//on lob selection the type should be changed
		//getting the type of the lob and setting it to the new model and in the type accesing the new model here

		onLOBselection: function(oEvent) {
			var s = oEvent.getSource().getSelectedItem().oBindingContexts.model.sPath;
			var sItem = this.getView().getModel("model").getProperty(s).type;
			var oModel = new sap.ui.model.json.JSONModel();
			oModel.setData(sItem);
			this.getView().setModel(oModel, "oModel");
			oModel.refresh();
		},
	//for the prority selection
		onpriorityselection: function(oEvent) {
			var ops = oEvent.getSource().getSelectedItem().oBindingContexts.model.sPath;
			var sItem = this.getView().getModel("model").getProperty(ops).action;
			this.getView().getModel("model").setProperty("/priorityaction", sItem);
		},


	//for the date validation
		todaydate: function() {

			var today = new Date();
			var dd = today.getDate();
			var mm = today.getMonth();
			var yy = today.getFullYear();
			var date = dd + "-" + mm + "-" + yy;
			var model = this.getView().getModel("model");
			console.log(date);
			//this.getView().getModel("model").setProperty("/todaydate",date,null,false);
			this.byId("date_start").setMinDate(new Date(yy, mm, dd));
			this.byId("assigndate").setMinDate(new Date(2018, mm, dd));
			this.byId("reportedon").setMinDate(new Date(2018, mm, dd));
			//	this.byId("date_start").setMaxDate(new Date());
		},

		startdate: function(oEvent) {
			var model = this.getView().getModel("model");
			var data = model.getData();
			var startdate = data.startdate;
			var dd = startdate.split("/")[1];
			var mm = startdate.split("/")[0] - 1;
			this.byId("date_finish").setMinDate(new Date(2018, mm, dd));

		},

		//dailog open

		ologindailog: function() {
			if (!this.mylogindailog) {
				this.mylogindailog = sap.ui.xmlfragment("com.incture.fragments.login", this);
				this.getView().addDependent(this.mylogindailog);
			}
			return this.mylogindailog;
		},

		onloginclose: function(oEvent) {
			this.getOwnerComponent().getRouter().navTo("dashboard");
			/*	this.ologindailog().close();*/
		},
		
		//warning massage..
		oneateClick: function(oEvent) {
			var model = this.getView().getModel("model");
			var data = model.getData();
			if (data.startdate==""||data.startdate==undefined) {
				sap.m.MessageToast.show("please enter the start date:");

			} else {
					this.ologindailog().open(oEvent.getSource());


			}
		
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