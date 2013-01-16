/*******************************************************************************
 * MxTreeItem.java is part of the Flex4j Explorer (for Flex4j 3.0)
 * 
 * Copyright (c) 2012 Emitrom LLC. All rights reserved.
 * 
 * http://www.emitrom.com/
 * 
 ******************************************************************************/
package com.emitrom.flex4j.explorer.client.data.apache.mx;

import java.util.ArrayList;
import java.util.List;

import com.emitrom.flash4j.flex.client.mx.controls.treeClasses.TreeItem;

public class MxTreeItem extends TreeItem {

    private static final MxTreeItem INSTANCE = new MxTreeItem();
    List<TreeItem> children = new ArrayList<TreeItem>();

    public static MxTreeItem get() {
        return INSTANCE;
    }

    private MxTreeItem() {
        this.setLabel("mx");
        children.add(MxBindingsTreeItem.get());
        children.add(MxChartsTreeItem.get());
        children.add(MxContainersTreeItem.get());
        children.add(MxControlsTreeItem.get());
        // children.add(MxEfffectsTreeItem.get());
        // children.add(MxFormattersTreeItem.get());
        // children.add(MxStatesTreeItem.get());
        // children.add(MxValidatorsTreeItem.get());
        this.addChildren(children);
    }

}
