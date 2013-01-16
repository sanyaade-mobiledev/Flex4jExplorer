package com.emitrom.flex4j.explorer.client.bindery.events;

import com.google.gwt.event.shared.GwtEvent;

/**
 * Dispatched when an asset is loaded
 * 
 */
public class DemoLoadEvent extends GwtEvent<DemoLoadEventHandler> {

    public static Type<DemoLoadEventHandler> TYPE = new Type<DemoLoadEventHandler>();

    private String componentName;

    public DemoLoadEvent(String compomentName) {
        this.componentName = compomentName;
    }

    @Override
    public Type<DemoLoadEventHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(DemoLoadEventHandler handler) {
        handler.onEvent(this);
    }

    public String getComponentName() {
        return this.componentName;
    }

}
