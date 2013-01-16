/*******************************************************************************
 * NavigationContainer.java is part of the Flex4j Explorer (for Flex4j 3.0)
 * 
 * Copyright (c) 2012 Emitrom LLC. All rights reserved.
 *
 *  http://www.emitrom.com/
 *  
 ******************************************************************************/
package com.emitrom.flex4j.explorer.client.ui.pages;

import com.emitrom.flash4j.flex.client.mx.containers.Panel;
import com.emitrom.flex4j.explorer.client.utils.Constants;

public class NavigationContainer extends Panel {

    private static final NavigationContainer INSTANCE = new NavigationContainer();

    public static NavigationContainer get() {
        return INSTANCE;
    }

    private NavigationContainer() {
        this.setTitle(Constants.APP_NAVIGATION_TITLE);
        this.setPercentHeight(100);
        // this.setStyle("borderStyle", "solid");
        this.setStyle("roundedBottomCorners", "true");
        this.setWidth(350);
        this.addElement(NavigationViewstack.get());

    }
}
