/*******************************************************************************
 * AbstractExplorerTreeItem.java is part of the Flex4j Explorer (for Flex4j 3.0)
 * 
 * Copyright (c) 2012 Emitrom LLC. All rights reserved.
 *
 *  http://www.emitrom.com/
 *  
 ******************************************************************************/
package com.emitrom.flex4j.explorer.client.data;

import java.util.ArrayList;
import java.util.List;

import com.emitrom.flash4j.flex.client.mx.controls.treeClasses.TreeItem;

public abstract class AbstractExplorerTreeItem extends TreeItem {

    protected List<String> elements = new ArrayList<String>();
    protected List<TreeItem> children = new ArrayList<TreeItem>();

    protected AbstractExplorerTreeItem() {

        createElements();

        for (String element : elements) {
            children.add(new TreeItem(element, getPackageName() + "." + element));
        }
        this.addChildren(children);
    }

    public abstract String getPackageName();

    public abstract void createElements();
}
