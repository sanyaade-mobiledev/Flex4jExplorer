package com.emitrom.flex4j.explorer.client.data.misc.gwt;

import com.emitrom.flex4j.explorer.client.data.AbstractExplorerTreeItem;

public class GwtTreeItem extends AbstractExplorerTreeItem {

    private static final GwtTreeItem INSTANCE = new GwtTreeItem();
    private static final String PACKAGE_NAME = "misc.gwt";

    public static GwtTreeItem get() {
        return INSTANCE;
    }

    private GwtTreeItem() {
        this.setLabel("GWT");
    }

    @Override
    public String getPackageName() {
        return PACKAGE_NAME;
    }

    @Override
    public void createElements() {
        elements.add("GwtRpc");
    }

}
