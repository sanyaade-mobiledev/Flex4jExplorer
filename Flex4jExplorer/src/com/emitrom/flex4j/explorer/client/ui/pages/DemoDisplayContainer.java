/*******************************************************************************
 * DemoDisplayContainer.java is part of the Flex4j Explorer (for Flex4j 3.0)
 * 
 * Copyright (c) 2012 Emitrom LLC. All rights reserved.
 * 
 * http://www.emitrom.com/
 * 
 ******************************************************************************/
package com.emitrom.flex4j.explorer.client.ui.pages;

import com.emitrom.flash4j.flex.client.mx.containers.Panel;
import com.emitrom.flash4j.flex.flexlib.client.containers.SuperTabNavigator;
import com.emitrom.flash4j.flex.flexlib.client.controls.tabBarClasses.SuperTab;
import com.emitrom.flex4j.explorer.client.utils.Constants;

public class DemoDisplayContainer extends Panel {

    private static final DemoDisplayContainer INSTANCE = new DemoDisplayContainer();
    private SuperTabNavigator superTabNavigator;

    public static DemoDisplayContainer get() {
        return INSTANCE;
    }

    private DemoDisplayContainer() {
        this.strech();
        this.setTitle("Showcase");
        this.setStyle("backgroundColor", Constants.DEMO_BG_COLOR);
        this.setStyle("roundedBottomCorners", "true");

        superTabNavigator = new SuperTabNavigator();
        superTabNavigator.setStyle("backgroundColor", Constants.DEMO_BG_COLOR);
        superTabNavigator.setClosePolicy(SuperTab.CLOSE_ROLLOVER);
        superTabNavigator.setAllowTabSqueezing(false);
        superTabNavigator.strech();
        this.addElement(superTabNavigator);

    }

    public SuperTabNavigator getSuperTabNavigator() {
        return superTabNavigator;
    }
}
