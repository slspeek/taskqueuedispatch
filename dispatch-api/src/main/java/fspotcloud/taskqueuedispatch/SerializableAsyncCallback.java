package fspotcloud.taskqueuedispatch;

import java.io.Serializable;


public interface SerializableAsyncCallback<T> extends AsyncCallback<T>, Serializable{
	
}
