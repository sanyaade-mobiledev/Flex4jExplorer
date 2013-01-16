/*******************************************************************************
 * DemoContainer.java is part of the Flex4j Explorer (for Flex4j 3.0)
 * 
 * Copyright (c) 2012 Emitrom LLC. All rights reserved.
 * 
 * http://www.emitrom.com/
 * 
 ******************************************************************************/
package com.emitrom.flex4j.explorer.client.ui.pages;

import com.emitrom.flash4j.flex.client.mx.containers.Canvas;
import com.emitrom.flash4j.flex.client.mx.containers.VBox;
import com.emitrom.flash4j.flex.client.mx.controls.Image;

/**
 * Holds the demo viewport
 * 
 */
public class DemoContainer extends Canvas {

    private static final DemoContainer INSTANCE = new DemoContainer();

    public static DemoContainer get() {
        return INSTANCE;
    }

    private DemoContainer() {
        this.strech();

        Image image = new Image("/imgs/icons/bg.jpeg");
        image.strech();
        this.addElement(image);

        VBox contentHolder = new VBox();
        contentHolder.strech();
        contentHolder.addElement(Header.get());
        contentHolder.addElement(Body.get());
        contentHolder.addElement(Footer.get());

        this.addElement(contentHolder);

    }
}
