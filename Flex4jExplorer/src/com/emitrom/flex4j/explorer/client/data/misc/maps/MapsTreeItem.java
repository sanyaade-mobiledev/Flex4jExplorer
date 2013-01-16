package com.emitrom.flex4j.explorer.client.data.misc.maps;

import com.emitrom.flex4j.explorer.client.data.AbstractExplorerTreeItem;

public class MapsTreeItem extends AbstractExplorerTreeItem {

    private static final MapsTreeItem INSTANCE = new MapsTreeItem();
    private static final String PACKAGE_NAME = "misc.maps";

    public static MapsTreeItem get() {
        return INSTANCE;
    }

    private MapsTreeItem() {
        this.setLabel("Maps");
    }

    @Override
    public String getPackageName() {
        return PACKAGE_NAME;
    }

    @Override
    public void createElements() {
        elements.add("GoogleMaps");
    }

}
