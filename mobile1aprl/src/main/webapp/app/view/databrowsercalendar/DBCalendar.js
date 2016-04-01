Ext.define('Mobile1aprl.view.databrowsercalendar.DBCalendar', {
	extend : 'Mobile1aprl.view.databrowsercalendar.DBCalendarView',
	requires : [ 'Mobile1aprl.view.databrowsercalendar.DBCalendarController',
	             'Mobile1aprl.view.databrowsercalendar.DBCalendarView','Ext.layout.container.Card',
	             'Ext.calendar.view.Day', 'Ext.calendar.view.Week',
	             'Ext.calendar.view.Month',
	             'Ext.calendar.form.EventDetails',
	             'Ext.calendar.data.EventMappings'],
	controller : 'databrowsercalendar',
	items : [],
	listeners : {
		afterrender : 'loadData',
		scope : "controller"
	}
});
