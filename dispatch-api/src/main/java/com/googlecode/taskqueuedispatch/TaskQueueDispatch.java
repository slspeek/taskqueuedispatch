package com.googlecode.taskqueuedispatch;

import net.customware.gwt.dispatch.shared.Action;
import net.customware.gwt.dispatch.shared.Result;

public interface TaskQueueDispatch {

    <A extends Action<R>, R extends Result> void execute(A action,
            SerializableAsyncCallback<R> callback);

    <A extends Action<R>, R extends Result> void execute(long delayMillis,
            A action, SerializableAsyncCallback<R> callback);

    <A extends Action<R>, R extends Result> void execute(A action);

    <A extends Action<R>, R extends Result> void execute(long delayMillis,
            A action);
}
