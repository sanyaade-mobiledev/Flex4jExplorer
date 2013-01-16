/*******************************************************************************
 * StartPage.java is part of the Flex4j Explorer (for Flex4j 3.0)
 * 
 * Copyright (c) 2012 Emitrom LLC. All rights reserved.
 * 
 * http://www.emitrom.com/
 * 
 ******************************************************************************/
package com.emitrom.flex4j.explorer.client.ui.pages;

import com.emitrom.flash4j.core.client.events.Event;
import com.emitrom.flash4j.core.client.events.MouseEvent;
import com.emitrom.flash4j.core.client.events.handlers.EventHandler;
import com.emitrom.flash4j.flex.client.mx.containers.Canvas;
import com.emitrom.flash4j.flex.client.mx.controls.Image;
import com.emitrom.flash4j.flex.client.mx.controls.Label;
import com.emitrom.flex4j.explorer.client.utils.Constants;
import com.emitrom.flex4j.explorer.client.utils.LayoutUtil;
import com.google.gwt.user.client.History;

/**
 * StartPage of the explorer
 */
public class StartPage extends Canvas {

    private static final StartPage INSTANCE = new StartPage();

    public static StartPage get() {
        return INSTANCE;
    }

    private StartPage() {
        LayoutUtil.strech(this);

        // App desciption
        Label appDescription = new Label(Constants.APP_DESCRIPTION);
        appDescription.setLeft(10);
        appDescription.setTop(10);
        appDescription.setStyle("fontFamily", "Verdana");
        appDescription.setStyle("fontSize", "15");
        appDescription.setStyle("fontWeight", "normal");
        appDescription.setStyle("color", "#FFFFFF");
        this.addElement(appDescription);

        // Emitrom logo
        Image logo = new Image("/imgs/logo/emitrom.png");
        logo.setUseHandCursor(true);
        logo.addEventHandler(MouseEvent.CLICK, new EventHandler() {
            @Override
            public void onEvent(Event event) {
                History.newItem("Demo");
            }
        });
        logo.setHorizontalCenter(0);
        logo.setTop(100);
        this.addElement(logo);

        Image flexLogo = new Image("/imgs/logo/flexlogo.png");
        flexLogo.setUseHandCursor(true);
        flexLogo.addEventHandler(MouseEvent.CLICK, new EventHandler() {
            @Override
            public void onEvent(Event event) {
                History.newItem("Demo");
            }
        });
        flexLogo.setCentered();
        this.addElement(flexLogo);

        // Copyrights

        Label apacheCopyright = new Label(Constants.APACHE_TEXT);
        apacheCopyright.setStyle("fontWeight", "normal");
        apacheCopyright.setStyle("color", "#FFFFFF");
        apacheCopyright.setRight(10);
        apacheCopyright.setBottom(20);
        this.addElement(apacheCopyright);

        Label othersCopyright = new Label(Constants.OTHERS_TEXT);
        othersCopyright.setStyle("fontWeight", "normal");
        othersCopyright.setStyle("color", "#FFFFFF");
        othersCopyright.setRight(10);
        othersCopyright.setBottom(10);
        this.addElement(othersCopyright);

        // this.addElement(ProductImage.get());

    }
}
