/*******************************************************************************
 * SparkComponentsTreeItem.java is part of the Flex4j Explorer (for Flex4j 3.0)
 * 
 * Copyright (c) 2012 Emitrom LLC. All rights reserved.
 *
 *  http://www.emitrom.com/
 *  
 ******************************************************************************/
package com.emitrom.flex4j.explorer.client.data.apache.spark;

import com.emitrom.flex4j.explorer.client.data.AbstractExplorerTreeItem;

public class SparkComponentsTreeItem extends AbstractExplorerTreeItem {

    private static final SparkComponentsTreeItem INSTANCE = new SparkComponentsTreeItem();
    private static final String PACKAGE_NAME = "spark.components";

    public static SparkComponentsTreeItem get() {
        return INSTANCE;
    }

    private SparkComponentsTreeItem() {
        this.setLabel("components");
    }

    @Override
    public String getPackageName() {
        return PACKAGE_NAME;
    }

    @Override
    public void createElements() {
        elements.add("BorderContainer");
        elements.add("Panel");
        elements.add("TitleWindow");
    }
}
