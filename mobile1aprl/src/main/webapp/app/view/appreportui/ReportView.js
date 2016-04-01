Ext.define('Mobile1aprl.view.appreportui.ReportView', {
	extend : 'Ext.form.Panel',
	requires : ['Mobile1aprl.view.appreportui.ReportViewController',
	            'Mobile1aprl.view.appreportui.datagrid.DataGridPanel',
	            'Mobile1aprl.view.appreportui.datagrid.DataGridView',
	            'Mobile1aprl.view.appreportui.querycriteria.QueryCriteriaView',
	            'Mobile1aprl.view.appreportui.chart.ChartView',
	            'Mobile1aprl.view.appreportui.datapoint.DataPointView',
	            'Mobile1aprl.view.googlemaps.map.MapPanel',
	            'Mobile1aprl.view.appreportui.chartpoint.ChartPointView'
	            ],
	xtype : 'reportView',
	controller : 'reportViewController',
	layout : 'border',
	reportJSON:null,
	listeners : {
		scope : 'controller',
		afterrender : 'afterRenderReport',
		boxready : 'fetchReportData'
	}
});
