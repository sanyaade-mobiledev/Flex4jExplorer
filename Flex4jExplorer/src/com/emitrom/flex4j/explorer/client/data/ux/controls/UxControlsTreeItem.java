package com.emitrom.flex4j.explorer.client.data.ux.controls;

import com.emitrom.flex4j.explorer.client.data.AbstractExplorerTreeItem;

public class UxControlsTreeItem extends AbstractExplorerTreeItem {

    private static final UxControlsTreeItem INSTANCE = new UxControlsTreeItem();
    private static final String PACKAGE_NAME = "ux.controls";

    public static UxControlsTreeItem get() {
        return INSTANCE;
    }

    private UxControlsTreeItem() {
        this.setLabel("controls");
    }

    @Override
    public String getPackageName() {
        return PACKAGE_NAME;
    }

    @Override
    public void createElements() {
        elements.add("AdvancedAutoComplete");
        elements.add("Clock");
        elements.add("FileUpload");
        elements.add("Keyboard");
        elements.add("SuperDatagrid");
    }

}
