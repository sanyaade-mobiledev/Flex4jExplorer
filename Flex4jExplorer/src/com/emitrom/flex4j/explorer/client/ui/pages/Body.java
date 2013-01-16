/*******************************************************************************
 * Body.java is part of the Flex4j Explorer (for Flex4j 3.0)
 * 
 * Copyright (c) 2012 Emitrom LLC. All rights reserved.
 * 
 * http://www.emitrom.com/
 * 
 ******************************************************************************/
package com.emitrom.flex4j.explorer.client.ui.pages;

import com.emitrom.flash4j.flex.client.mx.containers.ControlBar;
import com.emitrom.flash4j.flex.client.mx.containers.HBox;
import com.emitrom.flex4j.explorer.client.ui.widgets.AppToggleButtonBar;

public class Body extends HBox {

    private static final Body INSTANCE = new Body();

    public static Body get() {
        return INSTANCE;
    }

    private Body() {
        this.strech();
        this.addElement(NavigationContainer.get());
        ControlBar controlBar = new ControlBar();
        controlBar.addElement(AppToggleButtonBar.get());
        NavigationContainer.get().addElement(controlBar);
        this.addElement(DemoDisplayContainer.get());
    }
}
