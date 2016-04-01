Ext.define('Mobile1aprl.view.smartdevice.design.drawer.main.MainPanel', {
    extend : 'Ext.panel.Panel',
    xtype : 'mainPanel',
    requires : ['Mobile1aprl.view.smartdevice.design.drawer.main.MainPanelController','Mobile1aprl.view.smartdevice.design.resource.AppFormsList'],
    userinfo:{},
    controller:'mainPanel',
    
    layout: {
        type: 'border'
    },

    items: [
    {
        region : 'west',
        itemId : 'westPanel',
        id:'westPanel',
        split : false,
        width : '80%',
        height:'100%',
        xtype : 'appFormsList',
        collapsible:false,
        hidden:true,
        title:"",
        autoScroll:false,
        header : {
			titlePosition : 1,
			items : [ {
				xtype : 'image',
				src : 'img/logo.png',
				id : 'userImg',
				height : 50,
				width : 50,
				margin : '0 10 0 0'
			}],
			tools:[{ 
                       xtype: 'button',
                       text: '',
                       scale:'large',
                       icon:'resources/appicons/ic_drawer_collapse.png',
                       margin:'0 0 0 10',
                       listeners:{
                          click:'onDrawerBtnClick'
                       }
           }]
		}
    },{
        region : 'center',
        itemId : 'centerPanel',
        id:'centerPanel',
        title:'',
        layout:'fit',
        header:{
                 titlePosition:1,
                 tools:[{
                    xtype: 'button',
                    text:'',
                    scale:'large',
                    arrowVisible:false,
                    icon:'resources/appicons/ic_action_navigation_more_vert.png',
                    arrowAlign:'bottom',
                    menu:{
                        items:[{
                            xtype:'menuitem',
                            height:35,
                            text:'Logout',
                            listeners:{
                                click:'onLogoutMenuItemClick'
                            }
                        }]
                    }
                 }],
                 items:[
                 { 
                       xtype: 'button',
                       text: '',
                       scale:'large',
                       icon:'resources/appicons/ic_drawer_button.png',
                       margin:'0 10 0 0',
                       listeners:{
                          click:'onDrawerBtnClick'
                       }
                 }
                 
                 ]
        },
        items:[
            {
                xtype:'panel',
                title:'',
                id:'appMainTabPanel',
                layout:'fit',
                itemId:'appMainTabPanel'
            }
        ]

    }],
    listeners:{
        afterrender:'onMainPanelAfterRender'
    }

});
