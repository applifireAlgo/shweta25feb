Ext.define('Mobile1aprl.mobile1aprl.web.com.view.organizationboundedcontext.contacts.CommunicationTypeMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "CommunicationTypeMainController",
     "restURL": "/CommunicationType",
     "defaults": {
          "split": true
     },
     "requires": ["Mobile1aprl.mobile1aprl.shared.com.model.organizationboundedcontext.contacts.CommunicationTypeModel", "Mobile1aprl.mobile1aprl.web.com.controller.organizationboundedcontext.contacts.CommunicationTypeMainController", "Mobile1aprl.mobile1aprl.shared.com.model.organizationboundedcontext.contacts.CommunicationGroupModel", "Mobile1aprl.mobile1aprl.shared.com.viewmodel.organizationboundedcontext.contacts.CommunicationTypeViewModel"],
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
               "displayName": "Communication Type",
               "name": "CommunicationTypeTreeContainer",
               "itemId": "CommunicationTypeTreeContainer",
               "restURL": "/CommunicationType",
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
                    "itemId": "CommunicationTypeTree",
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
                    "items": [{
                         "name": "commTypeName",
                         "itemId": "commTypeName",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Communication Type Name",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Communication Type Name",
                         "fieldId": "3A80E15F-BD6F-4F0D-A0AD-9C042A5CF145",
                         "minLength": "0",
                         "maxLength": "128",
                         "errorMessage": "Please enter communication type",
                         "bindable": "commTypeName"
                    }]
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
                    "displayName": "Communication Type",
                    "title": "Communication Type",
                    "name": "CommunicationType",
                    "itemId": "CommunicationTypeForm",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "commType",
                         "itemId": "commType",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "commType",
                         "margin": "5 5 5 5",
                         "fieldLabel": "commType<font color='red'> *<\/font>",
                         "fieldId": "CF5650A9-1715-4659-B6F0-5DF249D4ECB4",
                         "minLength": "0",
                         "maxLength": "64",
                         "hidden": true,
                         "value": "",
                         "bindable": "commType"
                    }, {
                         "name": "commTypeName",
                         "itemId": "commTypeName",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Communication Type Name",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Communication Type Name<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "3A80E15F-BD6F-4F0D-A0AD-9C042A5CF145",
                         "minLength": "0",
                         "maxLength": "128",
                         "errorMessage": "Please enter communication type",
                         "bindable": "commTypeName",
                         "columnWidth": 0.5
                    }, {
                         "name": "commTypeDescription",
                         "itemId": "commTypeDescription",
                         "xtype": "textareafield",
                         "customWidgetType": "vdTextareafield",
                         "displayName": "Communication Type Description",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Communication Type Description",
                         "fieldId": "8B6A3C25-5C61-496F-9EA9-85D782128DFC",
                         "bindable": "commTypeDescription",
                         "columnWidth": 0.5
                    }, {
                         "name": "commGroupId",
                         "itemId": "commGroupId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Communication Group",
                         "margin": "5 5 5 5",
                         "valueField": "primaryKey",
                         "displayField": "primaryDisplay",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Mobile1aprl.mobile1aprl.shared.com.model.organizationboundedcontext.contacts.CommunicationGroupModel"
                         },
                         "allowBlank": false,
                         "fieldLabel": "Communication Group<font color='red'> *<\/font>",
                         "fieldId": "3A882844-457A-4EFA-B66D-724E99FDF3AC",
                         "restURL": "CommunicationGroup",
                         "bindable": "commGroupId",
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
                         "fieldId": "43780C5F-7018-4C6A-A2C5-A86672C93A00",
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
                         "customId": 778,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 778,
                              "customId": 744
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "name": "saveFormButton",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 778,
                              "customId": 745,
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
                              "parentId": 778,
                              "customId": 746,
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
                    "displayName": "Communication Type",
                    "title": "Details Grid",
                    "name": "CommunicationTypeGrid",
                    "itemId": "CommunicationTypeGrid",
                    "restURL": "/CommunicationType",
                    "store": [],
                    "bodyPadding": 10,
                    "columns": [{
                         "header": "commType",
                         "dataIndex": "commType",
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
                         "header": "Communication Type Name",
                         "dataIndex": "commTypeName",
                         "flex": 1
                    }, {
                         "header": "Communication Type Description",
                         "dataIndex": "commTypeDescription",
                         "flex": 1
                    }, {
                         "header": "Communication Group",
                         "dataIndex": "commGroupId",
                         "renderer": "renderFormValue",
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
               "displayName": "Communication Type",
               "title": "Communication Type",
               "name": "CommunicationType",
               "itemId": "CommunicationTypeForm",
               "bodyPadding": 10,
               "items": [{
                    "name": "commType",
                    "itemId": "commType",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "commType",
                    "margin": "5 5 5 5",
                    "fieldLabel": "commType<font color='red'> *<\/font>",
                    "fieldId": "CF5650A9-1715-4659-B6F0-5DF249D4ECB4",
                    "minLength": "0",
                    "maxLength": "64",
                    "hidden": true,
                    "value": "",
                    "bindable": "commType"
               }, {
                    "name": "commTypeName",
                    "itemId": "commTypeName",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Communication Type Name",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Communication Type Name<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "3A80E15F-BD6F-4F0D-A0AD-9C042A5CF145",
                    "minLength": "0",
                    "maxLength": "128",
                    "errorMessage": "Please enter communication type",
                    "bindable": "commTypeName",
                    "columnWidth": 0.5
               }, {
                    "name": "commTypeDescription",
                    "itemId": "commTypeDescription",
                    "xtype": "textareafield",
                    "customWidgetType": "vdTextareafield",
                    "displayName": "Communication Type Description",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Communication Type Description",
                    "fieldId": "8B6A3C25-5C61-496F-9EA9-85D782128DFC",
                    "bindable": "commTypeDescription",
                    "columnWidth": 0.5
               }, {
                    "name": "commGroupId",
                    "itemId": "commGroupId",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "Communication Group",
                    "margin": "5 5 5 5",
                    "valueField": "primaryKey",
                    "displayField": "primaryDisplay",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Mobile1aprl.mobile1aprl.shared.com.model.organizationboundedcontext.contacts.CommunicationGroupModel"
                    },
                    "allowBlank": false,
                    "fieldLabel": "Communication Group<font color='red'> *<\/font>",
                    "fieldId": "3A882844-457A-4EFA-B66D-724E99FDF3AC",
                    "restURL": "CommunicationGroup",
                    "bindable": "commGroupId",
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
                    "fieldId": "43780C5F-7018-4C6A-A2C5-A86672C93A00",
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
                    "customId": 778,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 778,
                         "customId": 744
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "name": "saveFormButton",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 778,
                         "customId": 745,
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
                         "parentId": 778,
                         "customId": 746,
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