package com.googlecode.taskqueuedispatch.inject;

import java.util.logging.Logger;

import com.google.inject.servlet.ServletModule;

import com.googlecode.taskqueuedispatch.TaskQueueDispatchServlet;

public class TaskQueueDispatchServletModule extends ServletModule {

	@SuppressWarnings("unused")
	private static final Logger log = Logger
			.getLogger(TaskQueueDispatchServletModule.class.getName());

	@Override
	protected void configureServlets() {
		serve("/taskqueue/dispatch").with(TaskQueueDispatchServlet.class);
	}

}
