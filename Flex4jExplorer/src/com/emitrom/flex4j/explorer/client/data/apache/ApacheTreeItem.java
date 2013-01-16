/*******************************************************************************
 * ApacheTreeItem.java is part of the Flex4j Explorer (for Flex4j 3.0)
 * 
 * Copyright (c) 2012 Emitrom LLC. All rights reserved.
 * 
 * http://www.emitrom.com/
 * 
 ******************************************************************************/
package com.emitrom.flex4j.explorer.client.data.apache;

import java.util.ArrayList;
import java.util.List;

import com.emitrom.flash4j.flex.client.mx.controls.treeClasses.TreeItem;
import com.emitrom.flex4j.explorer.client.data.apache.mx.MxTreeItem;
import com.emitrom.flex4j.explorer.client.data.apache.spark.SparkTreeItem;

public class ApacheTreeItem extends TreeItem {

    private static final ApacheTreeItem INSTANCE = new ApacheTreeItem();
    List<TreeItem> children = new ArrayList<TreeItem>();

    public static ApacheTreeItem get() {
        return INSTANCE;
    }

    private ApacheTreeItem() {
        this.setLabel("Apache");

        TreeItem flexTreeItem = new TreeItem("Flex");
        children.add(MxTreeItem.get());
        children.add(SparkTreeItem.get());
        flexTreeItem.addChildren(children);

        this.addChild(flexTreeItem);
    }
}
