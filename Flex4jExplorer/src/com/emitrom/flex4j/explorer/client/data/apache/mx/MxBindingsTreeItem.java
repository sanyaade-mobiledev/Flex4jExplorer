/*******************************************************************************
 * MxBindingsTreeItem.java is part of the Flex4j Explorer (for Flex4j 3.0)
 * 
 * Copyright (c) 2012 Emitrom LLC. All rights reserved.
 *
 *  http://www.emitrom.com/
 *  
 ******************************************************************************/
package com.emitrom.flex4j.explorer.client.data.apache.mx;

import com.emitrom.flex4j.explorer.client.data.AbstractExplorerTreeItem;

public class MxBindingsTreeItem extends AbstractExplorerTreeItem {

    private static final MxBindingsTreeItem INSTANCE = new MxBindingsTreeItem();
    private static final String PACKAGE_NAME = "mx.bindings";

    public static MxBindingsTreeItem get() {
        return INSTANCE;
    }

    private MxBindingsTreeItem() {
        this.setLabel("bindings");
    }

    @Override
    public String getPackageName() {
        return PACKAGE_NAME;
    }

    @Override
    public void createElements() {
        elements.add("BindingUtils");
    }
}
