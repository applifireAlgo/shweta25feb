Ext.define('Mobile1aprl.mobile1aprl.web.com.view.appinsight.health.TestMMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "TestMMainController",
     "restURL": "/TestM",
     "defaults": {
          "split": true
     },
     "requires": ["Mobile1aprl.mobile1aprl.shared.com.model.appinsight.health.TestMModel", "Mobile1aprl.mobile1aprl.web.com.controller.appinsight.health.TestMMainController", "Mobile1aprl.mobile1aprl.shared.com.viewmodel.appinsight.health.TestMViewModel"],
     "communicationLog": [],
     "tabPosition": "bottom",
     "items": [{
          "title": "Data Browser",
          "layout": "border",
          "defaults": {
               "split": true
          },
          "autoScroll": false,
          "customWidgetType": "vdBorderLayout",
          "items": [{
               "xtype": "tabpanel",
               "customWidgetType": "vdTabLayout",
               "margin": "5 0 5 5",
               "border": 1,
               "style": {
                    "borderColor": "#f6f6f6",
                    "borderStyle": "solid",
                    "borderWidth": "1px"
               },
               "displayName": "TestM",
               "name": "TestMTreeContainer",
               "itemId": "TestMTreeContainer",
               "restURL": "/TestM",
               "autoScroll": false,
               "collapsible": true,
               "titleCollapse": true,
               "collapseMode": "header",
               "collapsed": false,
               "items": [{
                    "xtype": "treepanel",
                    "customWidgetType": "vdTree",
                    "title": "Browse",
                    "name": "entityTreePanel",
                    "useArrows": true,
                    "rootVisible": false,
                    "itemId": "TestMTree",
                    "listeners": {
                         "select": "treeClick"
                    },
                    "tbar": [{
                         "xtype": "triggerfield",
                         "customWidgetType": "vdTriggerField",
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
                    }]
               }, {
                    "title": "Advance Search",
                    "xtype": "form",
                    "customWidgetType": "vdFormpanel",
                    "itemId": "queryPanel",
                    "dockedItems": [{
                         "xtype ": "toolbar",
                         "customWidgetType": "vdBBar",
                         "dock": "bottom",
                         "isDockedItem": true,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill"
                         }, {
                              "xtype": "button",
                              "customWidgetType": "vdButton",
                              "text": "Filter",
                              "name": "filterButton",
                              "handler": "onFilterClick"
                         }]
                    }],
                    "items": []
               }],
               "region": "west",
               "width": "20%"
          }, {
               "region": "center",
               "layout": "border",
               "defaults": {
                    "split": true
               },
               "customWidgetType": "vdBorderLayout",
               "items": [{
                    "customWidgetType": "vdFormpanel",
                    "xtype": "form",
                    "displayName": "TestM",
                    "title": "TestM",
                    "name": "TestM",
                    "itemId": "TestMForm",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "testMId",
                         "itemId": "testMId",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "testMId",
                         "margin": "5 5 5 5",
                         "fieldLabel": "testMId<font color='red'> *<\/font>",
                         "fieldId": "EDCECB6D-9384-4019-9A0C-6DE8058C206A",
                         "hidden": true,
                         "value": "",
                         "bindable": "testMId"
                    }, {
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
                         "bindable": "testNM",
                         "columnWidth": 0.5
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
                         "bindable": "testNo",
                         "columnWidth": 0.5
                    }, {
                         "name": "versionId",
                         "itemId": "versionId",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "versionId",
                         "margin": "5 5 5 5",
                         "value": "-1",
                         "fieldLabel": "versionId",
                         "fieldId": "9D250673-9592-4953-9E6F-C3F4D5E7D26A",
                         "bindable": "versionId",
                         "hidden": true
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
                         "ui": "footer",
                         "isDockedItem": true,
                         "parentId": 1,
                         "customId": 353,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 353,
                              "customId": 730
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "name": "saveFormButton",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 353,
                              "customId": 731,
                              "listeners": {
                                   "click": "saveForm"
                              }
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "name": "resetFormButton",
                              "margin": "0 5 0 5",
                              "text": "Reset",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "resetFormButton",
                              "parentId": 353,
                              "customId": 732,
                              "listeners": {
                                   "click": "resetForm"
                              }
                         }],
                         "defaults": {}
                    }],
                    "listeners": {
                         "scope": "controller"
                    },
                    "tools": [{
                         "type": "help",
                         "tooltip": "Console",
                         "handler": "onConsoleClick"
                    }, {
                         "type": "refresh",
                         "tooltip": "Refresh Tab",
                         "handler": "init"
                    }],
                    "extend": "Ext.form.Panel",
                    "region": "center"
               }, {
                    "xtype": "gridpanel",
                    "customWidgetType": "vdGrid",
                    "displayName": "TestM",
                    "title": "Details Grid",
                    "name": "TestMGrid",
                    "itemId": "TestMGrid",
                    "restURL": "/TestM",
                    "store": [],
                    "bodyPadding": 10,
                    "columns": [{
                         "header": "testMId",
                         "dataIndex": "testMId",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "primaryDisplay",
                         "dataIndex": "primaryDisplay",
                         "hidden": true
                    }, {
                         "header": "primaryKey",
                         "dataIndex": "primaryKey",
                         "hidden": true
                    }, {
                         "header": "testNM",
                         "dataIndex": "testNM",
                         "flex": 1
                    }, {
                         "header": "testNo",
                         "dataIndex": "testNo",
                         "flex": 1
                    }, {
                         "header": "createdBy",
                         "dataIndex": "createdBy",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "createdDate",
                         "dataIndex": "createdDate",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "updatedBy",
                         "dataIndex": "updatedBy",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "updatedDate",
                         "dataIndex": "updatedDate",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "versionId",
                         "dataIndex": "versionId",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "activeStatus",
                         "dataIndex": "activeStatus",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "txnAccessCode",
                         "dataIndex": "txnAccessCode",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "xtype": "actioncolumn",
                         "customWidgetType": "vdActionColumn",
                         "width": 30,
                         "sortable": false,
                         "menuDisable": true,
                         "items": [{
                              "icon": "images/delete.gif",
                              "tooltip": "Delete Record",
                              "handler": "onDeleteActionColumnClickMainGrid"
                         }]
                    }],
                    "listeners": {
                         "itemclick": "onGridItemClick"
                    },
                    "tools": [{
                         "type": "refresh",
                         "tooltip": "Refresh Grid Data",
                         "handler": "onGridRefreshClick"
                    }],
                    "collapsible": true,
                    "titleCollapse": true,
                    "collapseMode": "header",
                    "region": "south",
                    "height": "40%"
               }]
          }]
     }, {
          "title": "Add New",
          "itemId": "addNewForm",
          "layout": "border",
          "customWidgetType": "vdBorderLayout",
          "autoScroll": false,
          "items": [{
               "customWidgetType": "vdFormpanel",
               "xtype": "form",
               "displayName": "TestM",
               "title": "TestM",
               "name": "TestM",
               "itemId": "TestMForm",
               "bodyPadding": 10,
               "items": [{
                    "name": "testMId",
                    "itemId": "testMId",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "testMId",
                    "margin": "5 5 5 5",
                    "fieldLabel": "testMId<font color='red'> *<\/font>",
                    "fieldId": "EDCECB6D-9384-4019-9A0C-6DE8058C206A",
                    "hidden": true,
                    "value": "",
                    "bindable": "testMId"
               }, {
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
                    "bindable": "testNM",
                    "columnWidth": 0.5
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
                    "bindable": "testNo",
                    "columnWidth": 0.5
               }, {
                    "name": "versionId",
                    "itemId": "versionId",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "versionId",
                    "margin": "5 5 5 5",
                    "value": "-1",
                    "fieldLabel": "versionId",
                    "fieldId": "9D250673-9592-4953-9E6F-C3F4D5E7D26A",
                    "bindable": "versionId",
                    "hidden": true
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
                    "ui": "footer",
                    "isDockedItem": true,
                    "parentId": 1,
                    "customId": 353,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 353,
                         "customId": 730
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "name": "saveFormButton",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 353,
                         "customId": 731,
                         "listeners": {
                              "click": "saveForm"
                         }
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "name": "resetFormButton",
                         "margin": "0 5 0 5",
                         "text": "Reset",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "resetFormButton",
                         "parentId": 353,
                         "customId": 732,
                         "listeners": {
                              "click": "resetForm"
                         }
                    }],
                    "defaults": {}
               }],
               "listeners": {
                    "scope": "controller"
               },
               "tools": [{
                    "type": "help",
                    "tooltip": "Console",
                    "handler": "onConsoleClick"
               }, {
                    "type": "refresh",
                    "tooltip": "Refresh Tab",
                    "handler": "init"
               }],
               "extend": "Ext.form.Panel",
               "region": "center"
          }]
     }]
});