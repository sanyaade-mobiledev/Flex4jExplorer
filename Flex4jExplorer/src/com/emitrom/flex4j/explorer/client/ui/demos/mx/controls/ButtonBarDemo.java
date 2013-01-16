/*******************************************************************************
 * ButtonBarDemo.java is part of the Flex4j Explorer (for Flex4j 3.0)
 * 
 * Copyright (c) 2012 Emitrom LLC. All rights reserved.
 * 
 * http://www.emitrom.com/
 * 
 ******************************************************************************/
package com.emitrom.flex4j.explorer.client.ui.demos.mx.controls;

import com.emitrom.flash4j.core.client.events.Event;
import com.emitrom.flash4j.core.client.events.handlers.EventHandler;
import com.emitrom.flash4j.flex.client.mx.collections.ArrayCollection;
import com.emitrom.flash4j.flex.client.mx.containers.Panel;
import com.emitrom.flash4j.flex.client.mx.containers.VBox;
import com.emitrom.flash4j.flex.client.mx.controls.ButtonBar;
import com.emitrom.flash4j.flex.client.mx.controls.Label;
import com.emitrom.flash4j.flex.client.mx.controls.TextArea;
import com.emitrom.flash4j.flex.client.mx.core.ContainerLayout;
import com.emitrom.flash4j.flex.client.mx.events.ItemClickEvent;
import com.emitrom.flex4j.explorer.client.ui.demos.AbstractDemo;

public class ButtonBarDemo extends AbstractDemo {

    private static final ButtonBarDemo INSTANCE = new ButtonBarDemo();
    public static final String FULL_PATH = "mx.controls.ButtonBar";

    public static ButtonBarDemo get() {
        return INSTANCE;
    }

    private ButtonBarDemo() {

        final Panel panel = new Panel("ButtonBar Control Example");
        panel.setLayout(ContainerLayout.ABSOLUTE);
        panel.setCentered();
        panel.setPercentSize(80, 60);

        VBox box = new VBox();
        box.setRelativePosition(10);
        box.addElement(new Label("Select a Button in the ButtonBar control."));

        final TextArea textArea = new TextArea();
        textArea.strech();
        box.addElement(textArea);

        ArrayCollection dataProvider = new ArrayCollection();
        dataProvider.addItem("Touch4j");
        dataProvider.addItem("Flash4j");
        dataProvider.addItem("Titanium4j");
        dataProvider.addItem("Air4j");
        dataProvider.addItem("Canvas4j");

        ButtonBar butttonBar = new ButtonBar();
        butttonBar.setDataProvider(dataProvider);
        butttonBar.addEventHandler(ItemClickEvent.ITEM_CLICK, new EventHandler() {
            @Override
            public void onEvent(Event event) {
                ItemClickEvent e = ItemClickEvent.cast(event);
                String text = "You selected : " + e.getLabel();
                textArea.setText(text);
            }
        });
        box.addElement(butttonBar);

        panel.addElement(box);
        this.addElement(panel);

    }

    @Override
    public String getDemoPath() {
        return "mx/controls/ButtonBarDemo.java";
    }

    @Override
    public String getTitle() {
        return "ButtonBar";
    }
}
