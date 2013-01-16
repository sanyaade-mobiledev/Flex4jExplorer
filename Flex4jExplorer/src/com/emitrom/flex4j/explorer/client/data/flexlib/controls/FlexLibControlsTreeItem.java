package com.emitrom.flex4j.explorer.client.data.flexlib.controls;

import com.emitrom.flex4j.explorer.client.data.AbstractExplorerTreeItem;

public class FlexLibControlsTreeItem extends AbstractExplorerTreeItem {

    private static final FlexLibControlsTreeItem INSTANCE = new FlexLibControlsTreeItem();
    private static final String PACKAGE_NAME = "flexlib.controls";

    public static FlexLibControlsTreeItem get() {
        return INSTANCE;
    }

    private FlexLibControlsTreeItem() {
        this.setLabel("controls");
    }

    @Override
    public String getPackageName() {
        return PACKAGE_NAME;
    }

    @Override
    public void createElements() {
        elements.add("Base64Image");
        elements.add("Highlighter");
        elements.add("PromtingTextInputs");
        elements.add("ScrollableMenus");
        elements.add("VerticalMenuBar");
        elements.add("TreeGrid");
    }

}
