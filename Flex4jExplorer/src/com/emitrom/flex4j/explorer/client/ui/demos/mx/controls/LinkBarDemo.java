/*******************************************************************************
 * LinkBarDemo.java is part of the Flex4j Explorer (for Flex4j 3.0)
 * 
 * Copyright (c) 2012 Emitrom LLC. All rights reserved.
 * 
 * http://www.emitrom.com/
 * 
 ******************************************************************************/
package com.emitrom.flex4j.explorer.client.ui.demos.mx.controls;

import com.emitrom.flash4j.flex.client.mx.containers.Canvas;
import com.emitrom.flash4j.flex.client.mx.containers.Panel;
import com.emitrom.flash4j.flex.client.mx.containers.VBox;
import com.emitrom.flash4j.flex.client.mx.containers.ViewStack;
import com.emitrom.flash4j.flex.client.mx.controls.Label;
import com.emitrom.flash4j.flex.client.mx.controls.LinkBar;
import com.emitrom.flash4j.flex.client.mx.core.ContainerLayout;
import com.emitrom.flex4j.explorer.client.ui.demos.AbstractDemo;

public class LinkBarDemo extends AbstractDemo {

    private static final LinkBarDemo INSTANCE = new LinkBarDemo();
    public static final String FULL_PATH = "mx.controls.LinkBar";

    public static LinkBarDemo get() {
        return INSTANCE;
    }

    private LinkBarDemo() {

        final Panel panel = new Panel("LinkBar Control Example");
        panel.setLayout(ContainerLayout.ABSOLUTE);
        panel.setCentered();
        panel.setPercentSize(80, 70);

        VBox box = new VBox();
        box.setRelativePosition(10);
        box.addElement(new Label(
                        "Select a link in the LinkBar control to set the active child of the ViewStack container."));

        ViewStack viewStack = new ViewStack();
        viewStack.strech();

        Canvas child = new Canvas();
        child.setStyle("backgroundColor", "#FFFFCC");
        child.setLabel("Search");
        child.strech();
        viewStack.addElement(child);

        child = new Canvas();
        child.setStyle("backgroundColor", "#CCFFFF");
        child.setLabel("Customer Info");
        child.strech();
        viewStack.addElement(child);

        child = new Canvas();
        child.setStyle("backgroundColor", "#FFCCFF");
        child.setLabel("Account Info");
        child.setLabel("Search");
        child.strech();
        viewStack.addElement(child);

        LinkBar LinkBar = new LinkBar();
        LinkBar.setDataProvider(viewStack);
        box.addElement(LinkBar);
        box.addElement(viewStack);

        panel.addElement(box);
        this.addElement(panel);

    }

    @Override
    public String getDemoPath() {
        return "mx/controls/LinkBarDemo.java";
    }

    @Override
    public String getTitle() {
        return "LinkBar";
    }
}
