Ext.define('Salespro1.view.databrowsercalendar.DBCalendar', {
	extend : 'Salespro1.view.databrowsercalendar.DBCalendarView',
	requires : [ 'Salespro1.view.databrowsercalendar.DBCalendarController',
	             'Salespro1.view.databrowsercalendar.DBCalendarView','Ext.layout.container.Card',
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
