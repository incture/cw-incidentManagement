jQuery.sap.declare("Dashboard2.Formatter.formatter");

Dashboard2.Formatter.formatter={
	

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