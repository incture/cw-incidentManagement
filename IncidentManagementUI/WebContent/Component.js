jQuery.sap.declare('com.incture.Component');

sap.ui.define([
               'sap/ui/core/UIComponent',
               'sap/ui/core/IconPool'
               ], function (UIComponent, IconPool) {
	return UIComponent.extend('com.incture.Component',{
		metadata: {
			manifest: "json"
		},
		
		init: function () {
			
			UIComponent.prototype.init.apply(this, arguments);
			this._router = this.getRouter();

			// initialize the router
			this._router.initialize();
			var deviceModel = new sap.ui.model.json.JSONModel({
	            isTouch : sap.ui.Device.support.touch,
	            isNoTouch : !sap.ui.Device.support.touch,
	            isPhone : sap.ui.Device.system.phone,
	            isNoPhone : !sap.ui.Device.system.phone,
	            listMode : sap.ui.Device.system.phone ? "None" : "SingleSelectMaster",
	            listItemType : sap.ui.Device.system.phone ? "Active" : "Inactive"
	        });
	        deviceModel.setDefaultBindingMode("OneWay");
	        this.setModel(deviceModel, "device");
	        
	        IconPool.addIcon("tachometer", "fa", {
	        	fontFamily:"FontAwesome",
	        	content:"f0e4"
	        });
	        
	        IconPool.addIcon("user", "fa", {
	        	fontFamily:"FontAwesome",
	        	content:"f007"
	        });
	        
	        IconPool.addIcon("creditCard", "fa", {
	        	fontFamily:"FontAwesome",
	        	content:"f09d"
	        });
	        
	        IconPool.addIcon("trophy", "fa", {
	        	fontFamily:"FontAwesome",
	        	content:"f091"
	        });
	        
	        IconPool.addIcon("shopping-cart", "fa", {
	        	fontFamily:"FontAwesome",
	        	content:"f07a"
	        });
		},
		
		destroy: function () {
			
		}
	});
});