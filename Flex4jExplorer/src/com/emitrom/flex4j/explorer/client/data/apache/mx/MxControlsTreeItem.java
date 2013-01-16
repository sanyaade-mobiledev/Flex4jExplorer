/*******************************************************************************
 * MxControlsTreeItem.java is part of the Flex4j Explorer (for Flex4j 3.0)
 * 
 * Copyright (c) 2012 Emitrom LLC. All rights reserved.
 * 
 * http://www.emitrom.com/
 * 
 ******************************************************************************/
package com.emitrom.flex4j.explorer.client.data.apache.mx;

import com.emitrom.flex4j.explorer.client.data.AbstractExplorerTreeItem;

public class MxControlsTreeItem extends AbstractExplorerTreeItem {

    private static final MxControlsTreeItem INSTANCE = new MxControlsTreeItem();
    private final String PACKAGE_NAME = "mx.controls";

    public static MxControlsTreeItem get() {
        return INSTANCE;
    }

    private MxControlsTreeItem() {
        this.setLabel("controls");
    }

    @Override
    public String getPackageName() {
        return PACKAGE_NAME;
    }

    @Override
    public void createElements() {
        // elements.add("AdvancedDataGrid");
        elements.add("Alert");
        elements.add("Button");
        elements.add("ButtonBar");
        // elements.add("CheckBox");
        elements.add("ColorPicker");
        // elements.add("ComboBox");
        elements.add("DataGrid");
        elements.add("DateChooser");
        // elements.add("DateField");
        // elements.add("HorizontalList");
        // elements.add("HRule");
        // elements.add("HScrollBar");
        // elements.add("HSlider");
        // elements.add("Image");
        // elements.add("Label");
        elements.add("LinkBar");
        // elements.add("LinkButton");
        elements.add("List");
        elements.add("Menu");
        elements.add("MenuBar");
        // elements.add("RichTextEditor");
        // elements.add("VideoDislplay");
    }
}
