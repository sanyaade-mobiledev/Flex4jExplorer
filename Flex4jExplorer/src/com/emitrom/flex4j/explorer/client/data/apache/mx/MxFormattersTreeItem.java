/*******************************************************************************
 * MxFormattersTreeItem.java is part of the Flex4j Explorer (for Flex4j 3.0)
 * 
 * Copyright (c) 2012 Emitrom LLC. All rights reserved.
 *
 *  http://www.emitrom.com/
 *  
 ******************************************************************************/
package com.emitrom.flex4j.explorer.client.data.apache.mx;

import com.emitrom.flex4j.explorer.client.data.AbstractExplorerTreeItem;

public class MxFormattersTreeItem extends AbstractExplorerTreeItem {

    private static final MxFormattersTreeItem INSTANCE = new MxFormattersTreeItem();
    private static final String PACKAGE_NAME = "mx.formatters";

    public static MxFormattersTreeItem get() {
        return INSTANCE;
    }

    private MxFormattersTreeItem() {
        this.setLabel("formatters");
    }

    @Override
    public String getPackageName() {
        return PACKAGE_NAME;
    }

    @Override
    public void createElements() {
        elements.add("CurrencyFormatter");
        elements.add("DateFormatter");
        elements.add("NumberFormatter");
        elements.add("PhoneFormatter");
    }
}
