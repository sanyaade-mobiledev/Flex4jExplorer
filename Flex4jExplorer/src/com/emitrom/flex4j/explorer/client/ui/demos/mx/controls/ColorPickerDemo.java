/*******************************************************************************
 * ColorPickerDemo.java is part of the Flex4j Explorer (for Flex4j 3.0)
 * 
 * Copyright (c) 2012 Emitrom LLC. All rights reserved.
 * 
 * http://www.emitrom.com/
 * 
 ******************************************************************************/
package com.emitrom.flex4j.explorer.client.ui.demos.mx.controls;

import com.emitrom.flash4j.core.client.events.Event;
import com.emitrom.flash4j.core.client.events.handlers.EventHandler;
import com.emitrom.flash4j.flex.client.mx.containers.Panel;
import com.emitrom.flash4j.flex.client.mx.containers.VBox;
import com.emitrom.flash4j.flex.client.mx.controls.ColorPicker;
import com.emitrom.flash4j.flex.client.mx.controls.Label;
import com.emitrom.flash4j.flex.client.mx.core.ContainerLayout;
import com.emitrom.flash4j.flex.client.mx.events.ColorPickerEvent;
import com.emitrom.flex4j.explorer.client.ui.demos.AbstractDemo;

public class ColorPickerDemo extends AbstractDemo {

    private static final ColorPickerDemo INSTANCE = new ColorPickerDemo();
    public static final String FULL_PATH = "mx.controls.ColorPicker";

    public static ColorPickerDemo get() {
        return INSTANCE;
    }

    private VBox vBox;

    private ColorPickerDemo() {

        final Panel panel = new Panel("ColorPicker Control Example");
        panel.setLayout(ContainerLayout.ABSOLUTE);
        panel.setCentered();
        panel.setPercentSize(80, 60);

        VBox box = new VBox();
        box.setRelativePosition(10);
        box.addElement(new Label("Select a background color for the VBox."));

        ColorPicker colorPicker = new ColorPicker();
        colorPicker.setShowTextField(true);
        colorPicker.setSelectedColor(0xFFFFFF);
        colorPicker.addEventHandler(ColorPickerEvent.CHANGE, new EventHandler() {
            @Override
            public void onEvent(Event event) {
                ColorPickerEvent e = ColorPickerEvent.cast(event);
                vBox.setStyle("backgroundColor", e.getColorAsHex());
                ColorPickerDemo.this.setStyle("backgroundColor", e.getColorAsHex());
            }
        });
        box.addElement(colorPicker);

        vBox = new VBox();
        vBox.strech();
        vBox.setStyle("borderStyle", "solid");
        box.addElement(vBox);

        panel.addElement(box);
        this.addElement(panel);

    }

    @Override
    public String getDemoPath() {
        return "mx/controls/ColorPickerDemo.java";
    }

    @Override
    public String getTitle() {
        return "ColorPicker";
    }
}
