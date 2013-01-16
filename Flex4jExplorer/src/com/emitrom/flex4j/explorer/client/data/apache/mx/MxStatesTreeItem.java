/*******************************************************************************
 * MxStatesTreeItem.java is part of the Flex4j Explorer (for Flex4j 3.0)
 * 
 * Copyright (c) 2012 Emitrom LLC. All rights reserved.
 *
 *  http://www.emitrom.com/
 *  
 ******************************************************************************/
package com.emitrom.flex4j.explorer.client.data.apache.mx;

import com.emitrom.flex4j.explorer.client.data.AbstractExplorerTreeItem;

public class MxStatesTreeItem extends AbstractExplorerTreeItem {

    private static final MxStatesTreeItem INSTANCE = new MxStatesTreeItem();
    private static final String PACKAGE_NAME = "mx.states";

    public static MxStatesTreeItem get() {
        return INSTANCE;
    }

    private MxStatesTreeItem() {
        this.setLabel("states");
    }

    @Override
    public String getPackageName() {
        return PACKAGE_NAME;
    }

    @Override
    public void createElements() {
        elements.add("States and Transitions");
    }
}
