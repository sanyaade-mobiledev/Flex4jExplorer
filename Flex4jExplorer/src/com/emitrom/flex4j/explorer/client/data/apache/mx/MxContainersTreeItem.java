/*******************************************************************************
 * MxContainersTreeItem.java is part of the Flex4j Explorer (for Flex4j 3.0)
 * 
 * Copyright (c) 2012 Emitrom LLC. All rights reserved.
 * 
 * http://www.emitrom.com/
 * 
 ******************************************************************************/
package com.emitrom.flex4j.explorer.client.data.apache.mx;

import com.emitrom.flex4j.explorer.client.data.AbstractExplorerTreeItem;

public class MxContainersTreeItem extends AbstractExplorerTreeItem {

    private static final MxContainersTreeItem INSTANCE = new MxContainersTreeItem();
    private static final String PACKAGE_NAME = "mx.containers";

    public static MxContainersTreeItem get() {
        return INSTANCE;
    }

    private MxContainersTreeItem() {
        this.setLabel("containers");
    }

    @Override
    public String getPackageName() {
        return PACKAGE_NAME;
    }

    @Override
    public void createElements() {
        elements.add("Accordion");
        elements.add("Box");
        elements.add("Canvas");
        elements.add("ControlBar");
        elements.add("DividedBox");
        elements.add("Form");
        // elements.add("Grid");
        // elements.add("HBox");
        // elements.add("HDividedBox");
        // elements.add("Panel");
        elements.add("TabNavigator");
        // elements.add("Tile");
        // elements.add("TitleWindow");
        // elements.add("VBox");
        // elements.add("VDividedBox");
        elements.add("ViewStack");
    }
}
