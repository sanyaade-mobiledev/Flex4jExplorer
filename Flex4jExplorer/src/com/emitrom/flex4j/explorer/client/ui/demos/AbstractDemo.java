/*******************************************************************************
 * AbstractDemo.java is part of the Flex4j Explorer (for Flex4j 3.0)
 * 
 * Copyright (c) 2012 Emitrom LLC. All rights reserved.
 * 
 * http://www.emitrom.com/
 * 
 ******************************************************************************/
package com.emitrom.flex4j.explorer.client.ui.demos;

import com.emitrom.flash4j.core.client.events.Event;
import com.emitrom.flash4j.core.client.events.MouseEvent;
import com.emitrom.flash4j.core.client.events.handlers.EventHandler;
import com.emitrom.flash4j.flex.client.mx.containers.Canvas;
import com.emitrom.flash4j.flex.client.mx.controls.Button;
import com.emitrom.flex4j.explorer.client.bindery.EventBusUtil;
import com.emitrom.flex4j.explorer.client.bindery.events.DemoLoadEvent;
import com.emitrom.flex4j.explorer.client.bindery.events.DemoLoadEventHandler;
import com.emitrom.flex4j.explorer.client.controllers.DemoController;
import com.emitrom.flex4j.explorer.client.ui.pages.DemoDisplayContainer;
import com.emitrom.flex4j.explorer.client.utils.Constants;

public abstract class AbstractDemo extends Canvas implements DemoLoadEventHandler {

    protected Button srcButton;

    protected AbstractDemo() {
        EventBusUtil.get().addHandler(DemoLoadEvent.TYPE, this);
        this.setStyle("backgroundColor", Constants.DEMO_BG_COLOR);
        this.strech();
        this.setLabel(getTitle());

        srcButton = new Button("Source");
        srcButton.setHeight(32);
        srcButton.setTop(10);
        srcButton.setRight(10);
        srcButton.setIcon("/imgs/icons/src.png");
        srcButton.addEventHandler(MouseEvent.CLICK, new EventHandler() {
            @Override
            public void onEvent(Event event) {
                DemoController.get().displaySource(getDemoPath());
            }
        });
        this.addElement(srcButton);
    }

    public Button getScrButton() {
        return srcButton;
    }

    public abstract String getDemoPath();

    public abstract String getTitle();

    @Override
    public void onEvent(DemoLoadEvent event) {
        String path = this.getDemoPath().replace("/", ".");
        int index = path.lastIndexOf("Demo.java");
        path = path.substring(0, index);

        if (event.getComponentName().equalsIgnoreCase(path)) {
            DemoDisplayContainer.get().getSuperTabNavigator().addElement(this);
            DemoDisplayContainer.get().getSuperTabNavigator().setSelectedChild(this);
        }
    }

}
