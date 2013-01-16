/*******************************************************************************
 * MxEfffectsTreeItem.java is part of the Flex4j Explorer (for Flex4j 3.0)
 * 
 * Copyright (c) 2012 Emitrom LLC. All rights reserved.
 *
 *  http://www.emitrom.com/
 *  
 ******************************************************************************/
package com.emitrom.flex4j.explorer.client.data.apache.mx;

import com.emitrom.flex4j.explorer.client.data.AbstractExplorerTreeItem;

public class MxEfffectsTreeItem extends AbstractExplorerTreeItem {

    private static final MxEfffectsTreeItem INSTANCE = new MxEfffectsTreeItem();
    private static final String PACKAGE_NAME = "mx.effects";

    public static MxEfffectsTreeItem get() {
        return INSTANCE;
    }

    private MxEfffectsTreeItem() {
        this.setLabel("effects");
    }

    @Override
    public String getPackageName() {
        return PACKAGE_NAME;
    }

    @Override
    public void createElements() {
        elements.add("Blur");
        elements.add("Fade");
        elements.add("Glow");
        elements.add("Iris");
        elements.add("Move");
        elements.add("Parallel");
        elements.add("Pause");
    }
}
