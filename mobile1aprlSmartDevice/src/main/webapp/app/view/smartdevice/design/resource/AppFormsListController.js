Ext.define('Mobile1aprl.view.smartdevice.design.resource.AppFormsListController', {
    extend: 'Ext.app.ViewController',
 
    alias: 'controller.appFormsList',
    appFormsList:undefined,
    homeScreenMenuItem:undefined,
    init:function(){
    	this.appFormsList = this.getView();
    },
    onAppFormsListItemClick : function( sender, record, item, index, e, eOpts ){
         var westPanel = Ext.getCmp('westPanel');
         westPanel.setHidden(!westPanel.isHidden());
        
         var appMainTabPanel =  Ext.getCmp('appMainTabPanel');
         
         appMainTabPanel.removeAll(true);
         appMainTabPanel.add(Ext.create(record.data.menuAction));
        
         var centerPanel =  Ext.getCmp('centerPanel');
         centerPanel.setTitle(record.data.menuName);
         centerPanel.setDisabled(!centerPanel.isDisabled());
   
         
    },
    onDrawerBtnClick : function(drawerBtn){
        var westPanel = Ext.getCmp('westPanel');
        westPanel.setHidden(!westPanel.isHidden());
        var centerPanel = Ext.getCmp('centerPanel');
        centerPanel.setDisabled(!centerPanel.isDisabled());
          
    },
    onAppFormsListAfteRender : function(drawerBtn){
       
        var sender = this;
        sender.appFormsList.setStore(Ext.create('Ext.data.Store',{
            fields:["menuId", "menuTreeId", "menuName", "menuAction", "menuIcon", "userId", "menuLabel", "text", "refId", "autoSave", "menuCommands"]
        }));

        Ext.Ajax.request({
                     url : AppRestUrl+"secure/MenuService/findMainScreenMenus",
                     method:'POST', 
                     sender:sender,
                     jsonData:{
                     },
                     success : function(response,scope){
                          
                         var responseJson = Ext.JSON.decode(response.responseText);
                          
                          var data = Ext.decode(responseJson.response.data);
                          scope.sender.loadAppFormsListStore(scope.sender,data.menus);

                          if(scope.sender.homeScreenMenuItem){
                              var appMainTabPanel =  Ext.getCmp('appMainTabPanel');
                              appMainTabPanel.removeAll(true);
                              appMainTabPanel.add(Ext.create(scope.sender.homeScreenMenuItem.menuAction));
                              
                              var centerPanel =  Ext.getCmp('centerPanel');
                              centerPanel.setTitle(scope.sender.homeScreenMenuItem.menuName);
                         
                          }
                         
                        
                     },
                     failure : function(response,scope){
                       
                       Ext.MessageBox.show({title: 'Error',msg: "Cannot connect to server.",icon: Ext.MessageBox.ERROR});
                     }
                 },sender);     
    },

    loadAppFormsListStore : function(scope,data){

        for (var i = 0; i <= data.length; i++) {
            var obj = data[i];
            if(obj){
            if(!obj.hasOwnProperty('children')){
                scope.appFormsList.store.add(obj);
                if(!scope.homeScreenMenuItem && (obj.menuCommands)){
                	var mCmd = Ext.decode(obj.menuCommands);
                	
                	if(mCmd.homeScreen);
                	{
                		scope.homeScreenMenuItem = obj;
                	}
                }
            }
            else if(obj.children && obj.children.length>0){
               scope.loadAppFormsListStore(scope,obj.children);
            }
            }
        }

    }
});
