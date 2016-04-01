/** Rename this file as CustomDateField 
 * but a file with same name is already there in app 
 * so make sure that app is getting generated without any problem after removing that file n 
 * then do changes for this file as well */

Ext.define('Mobile1aprl.view.fw.component.DateFields',{
	extend : 'Ext.form.Date',
	xtype : 'datefields',
	
	getValues : function() {
		
		if (this.getSubmitValue() != "" && this.getSubmitValue() != null) {
			/** Appending time for datefield */
			var value = this.getSubmitValue() + " 0:0:0";
			var timezone = Ext.util.Cookies.get('XA_TID');
			return value + " "+ timezone;
		}
	}

});