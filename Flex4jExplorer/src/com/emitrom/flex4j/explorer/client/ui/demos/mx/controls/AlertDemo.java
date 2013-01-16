/*******************************************************************************
 * AlertDemo.java is part of the Flex4j Explorer (for Flex4j 3.0)
 * 
 * Copyright (c) 2012 Emitrom LLC. All rights reserved.
 * 
 * http://www.emitrom.com/
 * 
 ******************************************************************************/
package com.emitrom.flex4j.explorer.client.ui.demos.mx.controls;

import com.emitrom.flash4j.core.client.events.Event;
import com.emitrom.flash4j.core.client.events.MouseEvent;
import com.emitrom.flash4j.core.client.events.handlers.EventHandler;
import com.emitrom.flash4j.flex.client.mx.containers.Panel;
import com.emitrom.flash4j.flex.client.mx.containers.VBox;
import com.emitrom.flash4j.flex.client.mx.controls.Alert;
import com.emitrom.flash4j.flex.client.mx.controls.Button;
import com.emitrom.flash4j.flex.client.mx.controls.HRule;
import com.emitrom.flash4j.flex.client.mx.controls.Label;
import com.emitrom.flash4j.flex.client.mx.core.ContainerLayout;
import com.emitrom.flash4j.flex.client.mx.events.CloseEvent;
import com.emitrom.flex4j.explorer.client.ui.demos.AbstractDemo;
import com.google.gwt.user.client.Window;

public class AlertDemo extends AbstractDemo {

    private static final AlertDemo INSTANCE = new AlertDemo();
    public static final String FULL_PATH = "mx.controls.Alert";

    public static AlertDemo get() {
        return INSTANCE;
    }

    private AlertDemo() {
        final Panel panel = new Panel("Alert Control Example");
        panel.setLayout(ContainerLayout.ABSOLUTE);
        panel.setCentered();
        panel.setPercentSize(80, 50);

        VBox box = new VBox();
        box.strech();
        box.setRelativePosition(10);
        box.addElement(new Label("Click the button below to display a simple Alert window."));

        Button button = new Button("Click Me");
        button.addEventHandler(MouseEvent.CLICK, new EventHandler() {
            @Override
            public void onEvent(Event event) {
                Alert.show("Hello, World.", "Flex4j");
            }
        });
        box.addElement(button);
        box.addElement(new HRule());

        box.addElement(new Label(
                        "Click the button below to display an Alert window and capture the button pressed by the user."));

        button = new Button("Click Me");
        button.addEventHandler(MouseEvent.CLICK, new EventHandler() {
            @Override
            public void onEvent(Event event) {
                Alert.confirm("Do you really want to quit ?", "Confirm", new EventHandler() {
                    @Override
                    public void onEvent(Event event) {
                        CloseEvent closeEvent = CloseEvent.cast(event);
                        if (closeEvent.getDetail() == Alert.YES) {
                            Window.alert("You choosed Yes");
                        } else {
                            Window.alert("You choosed No");
                        }
                    }
                });
            }
        });
        box.addElement(button);
        box.addElement(new HRule());

        box.addElement(new Label("Click the button below to display an Alert window that uses custom Button labels."));

        button = new Button("Click Me");
        button.addEventHandler(MouseEvent.CLICK, new EventHandler() {
            @Override
            public void onEvent(Event event) {
                Alert.setButtonWidth(100);
                Alert.setYesLabel("Touch4j");
                Alert.setNoLabel("Flash4j");
                Alert.setCancelLabel("Titanium4j");
                Alert.show("Wich Emitrom products do you like the most ? ", "Select a product", Alert.YES | Alert.NO
                                | Alert.CANCEL);

                // Set the labels back to normal
                Alert.setYesLabel("Yes");
                Alert.setNoLabel("No");
                Alert.setCancelLabel("Cancel");
            }
        });
        box.addElement(button);

        panel.addElement(box);
        this.addElement(panel);
    }

    @Override
    public String getDemoPath() {
        return "mx/controls/AlertDemo.java";
    }

    @Override
    public String getTitle() {
        return "Alert";
    }
}
