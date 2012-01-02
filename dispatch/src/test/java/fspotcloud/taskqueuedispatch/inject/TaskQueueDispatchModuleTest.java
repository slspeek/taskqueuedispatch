package fspotcloud.taskqueuedispatch.inject;

import junit.framework.TestCase;
import net.customware.gwt.dispatch.server.guice.ActionHandlerModule;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;
import com.google.inject.Guice;
import com.google.inject.Injector;

import fspotcloud.taskqueuedispatch.TaskQueueDispatch;


public class TaskQueueDispatchModuleTest extends TestCase {

	private final LocalServiceTestHelper helper =
        new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig());

	TaskQueueDispatchDirectModule module;
	@Before
    public void setUp() {
        helper.setUp();
        module = new TaskQueueDispatchDirectModule();
	}

	@Test
	public void testCreateTaskQueueDispatch() {
		Injector i = Guice.createInjector(module, new ActionsModule());
		TaskQueueDispatch queueDispatch = i.getInstance(TaskQueueDispatch.class);
		assertNotNull(queueDispatch);
	}
	
	@After
    public void tearDown() {
        helper.tearDown();
    }
	public class ActionsModule extends ActionHandlerModule {

		@Override
		protected void configureHandlers() {
		}

	}
}
