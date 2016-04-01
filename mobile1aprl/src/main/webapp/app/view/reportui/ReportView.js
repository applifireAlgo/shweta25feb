Ext.define('Mobile1aprl.view.reportui.ReportView', {
	extend : 'Ext.panel.Panel',
	requires : [ 'Mobile1aprl.view.reportui.querycriteria.QueryCriteriaView',
			'Mobile1aprl.view.reportui.datachart.DataChartViewTab',
			'Mobile1aprl.view.reportui.datachart.DataChartViewPanel',
			'Mobile1aprl.view.reportui.ReportViewController' ,
			'Mobile1aprl.view.fw.MainDataPointPanel',
			'Mobile1aprl.view.googlemaps.map.MapPanel'
			],
	xtype : 'reportview',
	controller : 'reportviewController',
	layout : 'border',
	isCustomReport:false,
	reportWidgets :["1","2","3","4"],
	//autoScroll : true,
	//margin : '3 0 5 0',
	height:500,
	width:"100%",
	listeners : {
		scope : 'controller',
		afterrender : 'renderReport'
	}
});
