package com.googlecode.taskqueuedispatch.inject;

import javax.inject.Singleton;

import com.google.inject.AbstractModule;

import com.googlecode.taskqueuedispatch.TaskQueueDispatch;
import com.googlecode.taskqueuedispatch.TaskQueueDispatchDirectImpl;


public class TaskQueueDispatchDirectModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(TaskQueueDispatch.class).to(TaskQueueDispatchDirectImpl.class).in(Singleton.class);
	}
	
}
