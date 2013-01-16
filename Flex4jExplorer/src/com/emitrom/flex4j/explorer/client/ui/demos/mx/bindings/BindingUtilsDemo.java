/*******************************************************************************
 * BindingsDemo.java is part of the Flex4j Explorer (for Flex4j 3.0)
 * 
 * Copyright (c) 2012 Emitrom LLC. All rights reserved.
 * 
 * http://www.emitrom.com/
 * 
 ******************************************************************************/
package com.emitrom.flex4j.explorer.client.ui.demos.mx.bindings;

import com.emitrom.flash4j.flex.client.mx.bindings.BindingUtils;
import com.emitrom.flash4j.flex.client.mx.containers.VBox;
import com.emitrom.flash4j.flex.client.mx.controls.Label;
import com.emitrom.flash4j.flex.client.mx.controls.TextInput;
import com.emitrom.flex4j.explorer.client.ui.demos.AbstractDemo;

public class BindingUtilsDemo extends AbstractDemo {

    private static final BindingUtilsDemo INSTANCE = new BindingUtilsDemo();
    public static final String FULL_PATH = "mx.bindings.BindingUtils";

    public static BindingUtilsDemo get() {
        return INSTANCE;
    }

    private BindingUtilsDemo() {
        VBox box = new VBox();
        box.setCentered();

        Label label = new Label("Type in a text input to see databinding in action");
        label.setPercentWidth(100);
        label.setStyle("fontSize", "20");
        box.addElement(label);

        TextInput first = new TextInput();
        first.setPercentWidth(100);
        box.addElement(first);

        TextInput second = new TextInput();
        second.setPercentWidth(100);
        box.addElement(second);

        this.addElement(box);

        // Binds the first textinput to the second
        // Note that the target id the first argument
        BindingUtils.bindProperty(second, "text", first, "text");

        // Binds the second textinput to the first
        BindingUtils.bindProperty(first, "text", second, "text");

    }

    @Override
    public String getDemoPath() {
        return "mx/bindings/BindingUtilsDemo.java";
    }

    @Override
    public String getTitle() {
        return "Bindings";
    }

}
