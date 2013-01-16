package com.emitrom.flex4j.explorer.client.data.flexlib.containers;

import com.emitrom.flex4j.explorer.client.data.AbstractExplorerTreeItem;

public class FlexLibContainersTreeItem extends AbstractExplorerTreeItem {

    private static final FlexLibContainersTreeItem INSTANCE = new FlexLibContainersTreeItem();
    private static final String PACKAGE_NAME = "flexlib.containers";

    public static FlexLibContainersTreeItem get() {
        return INSTANCE;
    }

    private FlexLibContainersTreeItem() {
        this.setLabel("containers");
    }

    @Override
    public String getPackageName() {
        return PACKAGE_NAME;
    }

    @Override
    public void createElements() {
        elements.add("HAccordion");
        elements.add("VAccordion");
        elements.add("HCollapsiblePanel");
    }

}
