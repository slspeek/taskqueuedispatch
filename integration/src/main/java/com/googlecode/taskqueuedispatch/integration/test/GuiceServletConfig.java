package com.googlecode.taskqueuedispatch.integration.test;

import java.util.ArrayList;
import java.util.List;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;

import com.googlecode.taskqueuedispatch.inject.TaskQueueDispatchModule;
import com.googlecode.taskqueuedispatch.inject.TaskQueueDispatchServletModule;

public class GuiceServletConfig extends GuiceServletContextListener {
	@Override
	protected Injector getInjector() {
		Injector i = Guice.createInjector(new TaskQueueDispatchModule(),new TestServletModule(),
				new TestModule(), new ActionsModule());
		return i;
	}

	private class TestServletModule extends TaskQueueDispatchServletModule {
		@Override
		protected void configureServlets() {
			super.configureServlets();
			serve("/test").with(TestServlet.class);
		}
	}

	private class TestModule extends AbstractModule {

		@Override
		protected void configure() {
			bind(List.class).toInstance(new ArrayList<String>());

		}

	}

}
