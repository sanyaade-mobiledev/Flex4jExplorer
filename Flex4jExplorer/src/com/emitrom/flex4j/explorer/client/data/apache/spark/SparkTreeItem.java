/*******************************************************************************
 * SparkTreeItem.java is part of the Flex4j Explorer (for Flex4j 3.0)
 * 
 * Copyright (c) 2012 Emitrom LLC. All rights reserved.
 *
 *  http://www.emitrom.com/
 *  
 ******************************************************************************/
package com.emitrom.flex4j.explorer.client.data.apache.spark;

import java.util.ArrayList;
import java.util.List;

import com.emitrom.flash4j.flex.client.mx.controls.treeClasses.TreeItem;

public class SparkTreeItem extends TreeItem {

    private static final SparkTreeItem INSTANCE = new SparkTreeItem();
    List<TreeItem> children = new ArrayList<TreeItem>();

    public static SparkTreeItem get() {
        return INSTANCE;
    }

    private SparkTreeItem() {
        this.setLabel("spark");
        children.add(SparkComponentsTreeItem.get());
        children.add(SparkEffectsTreeItem.get());
        this.addChildren(children);
    }

}
