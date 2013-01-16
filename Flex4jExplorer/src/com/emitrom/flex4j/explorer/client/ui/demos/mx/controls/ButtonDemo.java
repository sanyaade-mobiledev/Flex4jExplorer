/*******************************************************************************
 * ButtonDemo.java is part of the Flex4j Explorer (for Flex4j 3.0)
 * 
 * Copyright (c) 2012 Emitrom LLC. All rights reserved.
 *
 *  http://www.emitrom.com/
 *  
 ******************************************************************************/
package com.emitrom.flex4j.explorer.client.ui.demos.mx.controls;

import com.emitrom.flash4j.core.client.events.Event;
import com.emitrom.flash4j.core.client.events.MouseEvent;
import com.emitrom.flash4j.core.client.events.handlers.EventHandler;
import com.emitrom.flash4j.flex.client.mx.containers.HBox;
import com.emitrom.flash4j.flex.client.mx.controls.Button;
import com.emitrom.flash4j.flex.client.mx.controls.ButtonLabelPlacement;
import com.emitrom.flex4j.explorer.client.ui.demos.AbstractDemo;
import com.google.gwt.user.client.Window;

public class ButtonDemo extends AbstractDemo {

    private static final ButtonDemo INSTANCE = new ButtonDemo();
    public static final String FULL_PATH = "mx.controls.Button";

    public static ButtonDemo get() {
        return INSTANCE;
    }

    private ButtonDemo() {
        HBox box = new HBox();
        box.setCentered();
        box.setPercentSize(50, 50);

        Button button = new Button("Click me");
        button.addEventHandler(MouseEvent.CLICK, new EventHandler() {
            @Override
            public void onEvent(Event event) {
                Window.alert("Hello, World");
            }
        });
        box.addElement(button);

        button = new Button("Button with icon");
        button.setIcon("/imgs/icons/quit.png");
        button.setHeight(25);
        box.addElement(button);

        button = new Button("Label align bottom");
        button.setIcon("/imgs/icons/quit.png");
        button.setLabelPlacement(ButtonLabelPlacement.BOTTOM);
        button.setHeight(55);
        box.addElement(button);

        button = new Button("Label align top");
        button.setIcon("/imgs/icons/quit.png");
        button.setLabelPlacement(ButtonLabelPlacement.TOP);
        button.setHeight(55);
        box.addElement(button);

        button = new Button("Label align left");
        button.setIcon("/imgs/icons/quit.png");
        button.setLabelPlacement(ButtonLabelPlacement.LEFT);
        button.setHeight(25);
        box.addElement(button);

        this.addElement(box);
    }

    @Override
    public String getDemoPath() {
        return "mx/controls/ButtonDemo.java";
    }

    @Override
    public String getTitle() {
        return "Button";
    }
}
