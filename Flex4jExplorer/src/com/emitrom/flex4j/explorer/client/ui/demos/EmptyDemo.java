/*******************************************************************************
 * EmptyDemo.java is part of the Flex4j Explorer (for Flex4j 3.0)
 * 
 * Copyright (c) 2012 Emitrom LLC. All rights reserved.
 * 
 * http://www.emitrom.com/
 * 
 ******************************************************************************/
package com.emitrom.flex4j.explorer.client.ui.demos;

import com.emitrom.flash4j.flex.client.mx.controls.Label;

public class EmptyDemo extends AbstractDemo {

    private String title;

    public EmptyDemo(String content) {
        this.setLabel(content);
        srcButton.setEnabled(false);
        Label label = new Label("Demo for :" + content + " coming soon...");
        label.setCentered();
        this.addElement(label);
    }

    @Override
    public String getDemoPath() {
        return title;
    }

    @Override
    public String getTitle() {
        return title;
    }

}
