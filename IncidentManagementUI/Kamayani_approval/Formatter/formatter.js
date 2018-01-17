jQuery.sap.declare("Formatter.formatter");
Dashboard.Formatter.formatter={
	

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
						
					}
}

