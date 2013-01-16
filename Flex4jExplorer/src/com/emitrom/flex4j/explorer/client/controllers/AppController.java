/*******************************************************************************
 * AppController.java is part of the Flex4j Explorer (for Flex4j 3.0)
 * 
 * Copyright (c) 2012 Emitrom LLC. All rights reserved.
 * 
 * http://www.emitrom.com/
 * 
 ******************************************************************************/
package com.emitrom.flex4j.explorer.client.controllers;

import com.emitrom.flash4j.flex.client.spark.components.Application;
import com.emitrom.flex4j.explorer.client.ui.MainContainer;
import com.emitrom.flex4j.explorer.client.utils.StyleUtil;
import com.google.gwt.user.client.History;

/**
 * Binds all part of the app together
 * 
 */
public class AppController {

    private static final AppController INSTANCE = new AppController();

    public static AppController get() {
        return INSTANCE;
    }

    private AppController() {
        StyleUtil.createStyles();
        bind();
    }

    public void lauchApp() {
        Application.get().setStyle("backgroundColor", "#000000");
        Application.get().addElement(MainContainer.get());
    }

    private void bind() {
        DemoController.loadDemos();
        History.addValueChangeHandler(DemoController.get());
        History.fireCurrentHistoryState();
    }
}
