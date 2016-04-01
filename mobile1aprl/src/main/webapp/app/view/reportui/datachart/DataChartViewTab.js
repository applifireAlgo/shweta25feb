Ext.define('Mobile1aprl.view.reportui.datachart.DataChartViewTab', {
	extend : 'Ext.tab.Panel',
	requires : [ 'Mobile1aprl.view.reportui.datachart.DataChartTController',
	             'Mobile1aprl.view.reportui.datachart.datagrid.DataGridView',
	             'Mobile1aprl.view.reportui.datachart.chart.ChartTabView',
	             'Mobile1aprl.view.reportui.datachart.ChartPointView' ],
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