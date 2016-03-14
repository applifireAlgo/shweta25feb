Ext.define('Salespro1.view.reportui.ReportView', {
	extend : 'Ext.panel.Panel',
	requires : [ 'Salespro1.view.reportui.querycriteria.QueryCriteriaView',
			'Salespro1.view.reportui.datachart.DataChartViewTab',
			'Salespro1.view.reportui.datachart.DataChartViewPanel',
			'Salespro1.view.reportui.ReportViewController' ,
			'Salespro1.view.fw.MainDataPointPanel',
			'Salespro1.view.googlemaps.map.MapPanel'
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
