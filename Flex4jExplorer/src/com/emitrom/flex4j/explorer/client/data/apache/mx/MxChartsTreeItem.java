/*******************************************************************************
 * MxChartsTreeItem.java is part of the Flex4j Explorer (for Flex4j 3.0)
 * 
 * Copyright (c) 2012 Emitrom LLC. All rights reserved.
 *
 *  http://www.emitrom.com/
 *  
 ******************************************************************************/
package com.emitrom.flex4j.explorer.client.data.apache.mx;

import com.emitrom.flex4j.explorer.client.data.AbstractExplorerTreeItem;

public class MxChartsTreeItem extends AbstractExplorerTreeItem {

    private static final MxChartsTreeItem INSTANCE = new MxChartsTreeItem();
    private static final String PACKAGE_NAME = "mx.charts";

    public static MxChartsTreeItem get() {
        return INSTANCE;
    }

    private MxChartsTreeItem() {
        this.setLabel("charts");
    }

    @Override
    public String getPackageName() {
        return PACKAGE_NAME;
    }

    @Override
    public void createElements() {
        elements.add("ChartDashboard");
        elements.add("AreaChart");
        elements.add("BarChart");
        elements.add("BubbleChart");
        elements.add("ColumnChart");
        elements.add("LineChart");
        elements.add("PieChart");
    }
}
