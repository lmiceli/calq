package com.pacho.android.calq.events;

import java.util.HashMap;
import java.util.Map;

/**
 * probably wont be using it as the removal of listeners
 * might add even more complexity than what is intended to simplify.
 *
 * Created by Pacho on 24/02/2016.
 */
public class Event {

    private Map<String, Runnable> listeners;

    public Event() {
        listeners = new HashMap<String, Runnable>();
    }

    public void trigger(){

    }

    public boolean addListener(String listenerName, Runnable listener) {

        if (listeners.containsKey(listenerName)){
            return false;
        }

        listeners.put(listenerName, listener);

        return true;
    }

    public boolean removeListener(){
        return true;
    }

}
