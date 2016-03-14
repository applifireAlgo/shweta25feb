Ext.define('Salespro1.view.reportui.datachart.DataChartViewTab', {
	extend : 'Ext.tab.Panel',
	requires : [ 'Salespro1.view.reportui.datachart.DataChartTController',
	             'Salespro1.view.reportui.datachart.datagrid.DataGridView',
	             'Salespro1.view.reportui.datachart.chart.ChartTabView',
	             'Salespro1.view.reportui.datachart.ChartPointView' ],
	controller : 'datacharttController',
	xtype : 'datachart-tabpanel',
	tabPosition : 'bottom',
	bodyStyle : 'background:#D8D8D8',
	listeners : {
		scope : "controller",
		tabchange : 'tabchange',
		afterrender:'afterTabPanelRender'
	}
});