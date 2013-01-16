package com.emitrom.flex4j.explorer.client.bindery.events;

import com.google.gwt.event.shared.EventHandler;

/**
 * Base interface for any class that listen to the game start event
 */
public interface DemoLoadEventHandler extends EventHandler {
    public void onEvent(DemoLoadEvent event);
}
