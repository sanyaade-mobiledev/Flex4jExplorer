/*******************************************************************************
 * Footer.java is part of the Flex4j Explorer (for Flex4j 3.0)
 * 
 * Copyright (c) 2012 Emitrom LLC. All rights reserved.
 * 
 * http://www.emitrom.com/
 * 
 ******************************************************************************/
package com.emitrom.flex4j.explorer.client.ui.pages;

import com.emitrom.flash4j.flex.client.mx.containers.HBox;
import com.emitrom.flash4j.flex.client.mx.controls.Label;
import com.emitrom.flash4j.flex.client.mx.controls.Spacer;
import com.emitrom.flex4j.explorer.client.utils.Constants;
import com.emitrom.flex4j.explorer.client.utils.LayoutUtil;

public class Footer extends HBox {

    private static final Footer INSTANCE = new Footer();

    public static Footer get() {
        return INSTANCE;
    }

    private Footer() {
        this.setPercentWidth(100);
        this.setHeight(26);

        Spacer spacer = new Spacer();
        LayoutUtil.strech(spacer);
        this.addElement(spacer);

        Label copyrightLabel = new Label(Constants.APP_COPYRIGHT);
        copyrightLabel.setStyle("fontSize", "9");
        copyrightLabel.setStyle("color", "#FFFF");
        copyrightLabel.setStyle("fontWeight", "normal");
        this.addElement(copyrightLabel);

    }

}
