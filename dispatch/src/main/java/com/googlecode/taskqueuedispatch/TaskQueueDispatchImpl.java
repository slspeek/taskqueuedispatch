package com.googlecode.taskqueuedispatch;

import org.apache.commons.lang.SerializationUtils;

import net.customware.gwt.dispatch.shared.Action;
import net.customware.gwt.dispatch.shared.Result;

import com.google.appengine.api.taskqueue.TaskOptions;
import com.google.appengine.api.taskqueue.Queue;
import com.google.inject.Inject;
import com.google.inject.name.Named;

public class TaskQueueDispatchImpl implements TaskQueueDispatch {
    private static final int MILLIS_IN_SECOND = 1000;

    private final Queue queue;

    @Inject
    public TaskQueueDispatchImpl(@Named("dispatch") Queue queue) {
        super();
        this.queue = queue;
    }
    public Queue getQueue() {
        return queue;
    }

    @Override
    public <A extends Action<R>, R extends Result> void execute(A action,
            SerializableAsyncCallback<R> callback) {
        execute(0, action, callback);
    }


    @Override
    public <A extends Action<R>, R extends Result> void execute(A action) {
        execute(0, action);
    }

    @Override
    public <A extends Action<R>, R extends Result> void execute(long delayMillis, A action, SerializableAsyncCallback<R> callback) {
        AsyncCommand<A, R> command = new AsyncCommand<A, R>(callback, action);
        byte[] payload = SerializationUtils.serialize(command);
        TaskOptions taskOptions = 
                TaskOptions.Builder.withUrl(
                "/taskqueue/dispatch")
                .payload(payload, "image/jpeg")
                .countdownMillis(delayMillis);
        queue.add(taskOptions);
    }

    @Override
    public <A extends Action<R>, R extends Result> void execute(long delayMillis, A action) {
        NullCallback<R> nullCallback = new NullCallback<R>();
        execute(delayMillis, action, nullCallback);
    }
}
