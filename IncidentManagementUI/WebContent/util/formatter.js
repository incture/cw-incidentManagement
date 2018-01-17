jQuery.sap.declare("com.incture.util.formatter");

com.incture.util.formatter = {
	/** This function calculates the no of list items to be shown on Panel. 
	 * If no list items are present it automatically hides the number
	 */
	fnMD_DisplayChildCount: function(oNode) {
		this.removeStyleClass("inctureMDTxtClrWhite inctureMDBadge");
		if (oNode) {
			if (oNode.length > 0) {
				//			  this.addStyleClass("inctureMDTxtClrWhite inctureMDBadge");
				//			  return oNode.length;
				this.addStyleClass("inctureMDTxtClrWhite");
				return "";
			} else {
				return "";
			}
		} else {
			return "";
		}
	},

	getDate: function(value) {
		if (value) {
			if (typeof value == "string") {
				if (value.includes("-")) {
					value = value.split("-");
					value = value[1] + "/" + value[2] + "/" + value[0];
				}
			}
			return value;
		}
	},

	getPhoneNumber: function(value) {
		if (value) {
			return "Phone Number: " + value;
		}
	},

	setDefaultBtn: function(value) {
		if (value) {
			return false;
		} else {
			return true;
		}
	},

	addressVisible: function(newAddress, address) {
		if (newAddress && !address) {
			return true;
		} else {
			return false;
		}
	},

	addressVisible2: function(newAddress, address) {
		if (newAddress && !address) {
			return false;
		} else {
			return true;
		}
	},

	getStatus: function(status) {
		if (status === "A") {
			this.addStyleClass('inctureDBGreyOrderStatus');
			return "Not yet Processed"
		} else if (status === "B") {
			this.addStyleClass('inctureDBRedOrderStatus');
			return "Partially Processed"
		} else {
			this.addStyleClass('inctureDBGreenOrderStatus');
			return "Completely Processed"
		}
	},

	getOrderStatusColor: function(status) {
		if(status){
		this.removeStyleClass('inctureGreyOrderStatus inctureRedOrderStatus inctureGreenOrderStatus');
		if (status === "A") {
			this.addStyleClass('inctureGreyOrderStatus');
			return "Not yet Processed"
		} else if (status === "B") {
			this.addStyleClass('inctureRedOrderStatus');
			return "Partially Processed"
		} else {
			this.addStyleClass('inctureGreenOrderStatus');
			return "Completely Processed"
		}
		}
	},

	getQuantityUOM: function(quantity, UOM) {
		switch (UOM) {
			case "Piece":
				return quantity;
				break;
			case "Case (6pcs.)":
				return quantity / 6;
				break;
			case "Layer (36pcs.)":
				return quantity / 36;
				break;
			case "Pallet (216pcs.)":
				return quantity / 216;
				break;
		}
	},

	getTotalPrice: function(price, quantity, currency) {
		var totalPrice = parseFloat(price * quantity).toFixed(2);
		var oTotal = totalPrice + " " + currency;
		return oTotal;
	},

	getDecimalValue: function(value) {
		if (value) {
			return parseFloat(value).toFixed(2);
		} else {
			return value;
		}
	},

	formatQty: function(oValue) {
		if (oValue) {
			return parseInt(oValue);
		} else {
			return "";
		}
	},

	getImagePath: function(path) {
		if (path) {
			return "." + path;
		}
	},
	getDBHeaderTotal: function(oComplete, oPartial, oNetYet) {
		if (oComplete && oPartial && oNetYet) {
			return oComplete + oPartial + oNetYet;
		} else {
			return " ";
		}
	},
	
	getOrderStatusColour:function(oOrderStatus){
		if(oOrderStatus){
		this.getParent().removeStyleClass("inctureTrackOrderStatusBox");
		var oOrderStatusText=this.getParent().getItems()[1].getText();
		if(oOrderStatus===oOrderStatusText)	{
			this.getParent().addStyleClass("inctureTrackOrderStatusBox");
			return "";
		}
		}
		return "";
	},
	
	Priority: function(stat) {
		console.log(stat);
		
		switch (stat) {
			
			case 'Urgent':
				this.getParent().addStyleClass('red');
				break;
			case 'Medium':
				this.getParent().addStyleClass('green');
				break;
			default:
				this.getParent().addStyleClass('green');
		};
		
	},
	//date format
	date_display: function(oDate)  
		 {
			var returnValue = "";
			if (oDate) {
				var date = oDate.split("T")[0].split("-");
				var monthCount = date[0];
				var month = getMonthName(monthCount-1);
				returnValue = date[1] + " " + month + " " + date[2];
			}
			return returnValue;
		}, 
 

};