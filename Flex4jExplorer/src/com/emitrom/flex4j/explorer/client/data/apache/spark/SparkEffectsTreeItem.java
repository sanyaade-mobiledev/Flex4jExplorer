/*******************************************************************************
 * SparkEffectsTreeItem.java is part of the Flex4j Explorer (for Flex4j 3.0)
 * 
 * Copyright (c) 2012 Emitrom LLC. All rights reserved.
 * 
 * http://www.emitrom.com/
 * 
 ******************************************************************************/
package com.emitrom.flex4j.explorer.client.data.apache.spark;

import com.emitrom.flex4j.explorer.client.data.AbstractExplorerTreeItem;

public class SparkEffectsTreeItem extends AbstractExplorerTreeItem {

    private static final SparkEffectsTreeItem INSTANCE = new SparkEffectsTreeItem();
    private static final String PACKAGE_NAME = "spark.effects";

    public static SparkEffectsTreeItem get() {
        return INSTANCE;
    }

    private SparkEffectsTreeItem() {
        this.setLabel("effects");
    }

    @Override
    public String getPackageName() {
        return PACKAGE_NAME;
    }

    @Override
    public void createElements() {
        elements.add("Fade");
        elements.add("Move");
    }
}
