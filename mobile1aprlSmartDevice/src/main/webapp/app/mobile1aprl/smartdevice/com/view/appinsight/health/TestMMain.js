Ext.define('Mobile1aprl.mobile1aprl.smartdevice.com.view.appinsight.health.TestMMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "TestMMainController",
     "restURL": "/TestM",
     "requires": ["Mobile1aprl.mobile1aprl.shared.com.model.appinsight.health.TestMModel", "Mobile1aprl.mobile1aprl.smartdevice.com.controller.appinsight.health.TestMMainController", "Mobile1aprl.mobile1aprl.shared.com.viewmodel.appinsight.health.TestMViewModel"],
     "communicationLog": [],
     "tabPosition": "bottom",
     "margin": 5,
     "tabBar": {
          "hidden": true
     },
     "items": [{
          "title": "Data Browser",
          "layout": "border",
          "autoScroll": false,
          "customWidgetType": "vdBorderLayout",
          "items": [{
               "xtype": "treepanel",
               "customWidgetType": "vdTree",
               "title": "List",
               "useArrows": true,
               "rowLines": true,
               "columnLines": true,
               "rootVisible": false,
               "itemId": "TestMTree",
               "listeners": {
                    "select": "treeClick"
               },
               "tbar": [{
                    "xtype": "triggerfield",
                    "customWidgetType": "vdTriggerField",
                    "width": "90%",
                    "height": "35",
                    "emptyText": "Search",
                    "triggerCls": "",
                    "listeners": {
                         "change": "onTriggerfieldChange",
                         "buffer": 250
                    }
               }, "->", {
                    "xtype": "tool",
                    "type": "refresh",
                    "tooltip": "Refresh Tree Data",
                    "handler": "onTreeRefreshClick"
               }],
               "region": "south",
               "height": "100%",
               "collapsible": true,
               "titleCollapse": true,
               "collapseMode": "header",
               "collapsed": false
          }, {
               "region": "center",
               "layout": "border",
               "customWidgetType": "vdBorderLayout",
               "items": [{
                    "customWidgetType": "vdFormpanel",
                    "viewModel": "TestMViewModel",
                    "xtype": "form",
                    "displayName": "TestM",
                    "title": "TestM",
                    "name": "TestM",
                    "itemId": "TestM",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "testNM",
                         "itemId": "testNM",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "testNM",
                         "margin": "5 5 5 5",
                         "fieldLabel": "testNM<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "B5CA7FFC-34A9-4B46-A75A-E33A088DF865",
                         "minLength": "1",
                         "maxLength": "256",
                         "bind": "{testNM}",
                         "columnWidth": 1
                    }, {
                         "name": "testNo",
                         "itemId": "testNo",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "testNo",
                         "margin": "5 5 5 5",
                         "fieldLabel": "testNo<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "FA2CD594-D1CF-494C-BDF3-F1D077558079",
                         "minValue": "-2147483648",
                         "maxValue": "2147483647",
                         "bind": "{testNo}",
                         "columnWidth": 1
                    }],
                    "layout": "column",
                    "defaults": {
                         "columnWidth": 0.5,
                         "labelAlign": "left",
                         "labelWidth": 200
                    },
                    "autoScroll": true,
                    "dockedItems": [{
                         "xtype ": "toolbar",
                         "customWidgetType": "vdBBar",
                         "dock": "bottom",
                         "isDockedItem": true,
                         "parentId": 1,
                         "customId": 886,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 886,
                              "customId": 523
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 886,
                              "customId": 524,
                              "listeners": {
                                   "click": "saveForm"
                              }
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "margin": "0 5 0 5",
                              "text": "Reset",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "resetFormButton",
                              "parentId": 886,
                              "customId": 525,
                              "listeners": {
                                   "click": "resetForm"
                              }
                         }],
                         "defaults": {
                              "margin": "0 5 0 5",
                              "flex": 1,
                              "height": 30
                         }
                    }],
                    "listeners": {
                         "scope": "controller"
                    },
                    "extend": "Ext.form.Panel",
                    "region": "center"
               }]
          }]
     }]
});