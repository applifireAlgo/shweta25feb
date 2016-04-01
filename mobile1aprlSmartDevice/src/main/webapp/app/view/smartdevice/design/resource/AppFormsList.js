Ext.define('Mobile1aprl.view.smartdevice.design.resource.AppFormsList', {
	extend : 'Ext.grid.Panel',
	xtype : 'appFormsList',
	controller:'appFormsList',
	requires:['Mobile1aprl.view.smartdevice.design.resource.AppFormsListController'],
	title:'',
	features:[{ftype:"grouping"}],
	hideHeaders:true,
	editTools:false,
	/*bodyStyle:{
		background:'#F2F2F2'
	},*/
	columns: [
 		{
 			xtype:'templatecolumn',
 			tpl:'<div style="padding:15px;font-size:18px;font-weight: bold;vertical-align: middle;">{menuName}</div>',
 			flex:1
 		}
 	],
 	listeners:{
 		afterrender:'onAppFormsListAfteRender',
 		itemclick:'onAppFormsListItemClick'
 	}
   
});
