Ext.define('Salespro1.view.fw.mainViewPanel.MainPanelController', {
	extend : 'Ext.app.ViewController',
	requires : ['Ext.util.Cookies'],
	alias : 'controller.mainViewPanelController',
	
	afterRender:function()
	{
		var cookieChangePwd = Ext.util.Cookies.get('changePwd');
		if(cookieChangePwd=="true"){
			var window = Ext.create('Ext.window.Window', {
				width : '25%',
				height : 250,
				layout : 'fit',
				modal : true,
				resizable : true,
				closeAction : 'close',
				plain : true,
				title : 'Change Password',
				autoDestroy:true,
				closable:false
		});
		window.add(Ext.create('Salespro1.view.usermanagement.enduser.ChangePwd'));
		window.show();
		}
	},
	aftrAppMainTabPanelRender:function(tabpanel)
	{
		contextMenu = new Ext.menu.Menu({
			  items: [{
			    text: 'Close All',
			    icon: 'images/closable.png',
			    listeners:{
					click:'onCloseAllClick',
					scope:this
				}
			  }]
			});

		tabpanel.tabBar.getEl().on('contextmenu', function(e) {
			     e.stopEvent();
			     contextMenu.showAt(e.getXY());
			});
	},
	onCloseAllClick:function()
	{
		var tabpanel=this.getView().down('#appMainTabPanel');
		while(tabpanel.items.items.length>0){
			tabpanel.items.items[0].close();
		}
	}
});