/*******************************************************************************
 * Header.java is part of the Flex4j Explorer (for Flex4j 3.0)
 * 
 * Copyright (c) 2012 Emitrom LLC. All rights reserved.
 * 
 * http://www.emitrom.com/
 * 
 ******************************************************************************/
package com.emitrom.flex4j.explorer.client.ui.pages;

import com.emitrom.flash4j.core.client.events.Event;
import com.emitrom.flash4j.core.client.events.handlers.EventHandler;
import com.emitrom.flash4j.core.client.toplevel.Flash;
import com.emitrom.flash4j.flex.client.mx.collections.ArrayCollection;
import com.emitrom.flash4j.flex.client.mx.containers.Box;
import com.emitrom.flash4j.flex.client.mx.containers.HBox;
import com.emitrom.flash4j.flex.client.mx.controls.Alert;
import com.emitrom.flash4j.flex.client.mx.controls.Label;
import com.emitrom.flash4j.flex.client.mx.controls.LinkBar;
import com.emitrom.flash4j.flex.client.mx.controls.Spacer;
import com.emitrom.flash4j.flex.client.mx.events.ListEvent;
import com.emitrom.flex4j.explorer.client.utils.Constants;
import com.emitrom.flex4j.explorer.client.utils.LayoutUtil;

public class Header extends HBox {

    private static final Header INSTANCE = new Header();

    public static Header get() {
        return INSTANCE;
    }

    private LinkBar linkBar;

    private Header() {
        this.setPercentWidth(100);
        this.setStyle("margingLeft", "10");
        this.setStyle("margingRight", "10");

        Label appTitle = new Label(Constants.APP_NAME);
        appTitle.setStyle("fontSize", "24");
        appTitle.setStyle("color", "#FFFF");
        appTitle.setStyle("fontWeight", "normal");
        this.addElement(appTitle);

        Label versionLabel = new Label(Constants.APP_VERSION);
        versionLabel.setStyle("fontSize", "10");
        versionLabel.setStyle("color", "#FFFF");

        Box versionBox = new Box();
        versionBox.setHeight(20);
        versionBox.addElement(versionLabel);
        this.addElement(versionBox);

        Spacer spacer = new Spacer();
        LayoutUtil.strech(spacer);
        this.addElement(spacer);

        final ArrayCollection linkBarDataProvider = new ArrayCollection();
        linkBarDataProvider.addItem("Discuss");
        linkBarDataProvider.addItem("Download");
        linkBarDataProvider.addItem("About");

        linkBar = new LinkBar();
        linkBar.setStyle("fontSize", "9");
        linkBar.setStyle("color", "#FFFF");
        linkBar.setStyle("fontWeight", "normal");
        linkBar.setDataProvider(linkBarDataProvider);
        linkBar.addEventHandler(ListEvent.ITEM_CLICK, new EventHandler() {
            @Override
            public void onEvent(Event event) {
                int index = linkBar.getSelectedIndex();
                String selectedElement = linkBarDataProvider.getItemAt(index);
                processSelection(selectedElement);
            }
        });
        this.addElement(linkBar);

    }

    public LinkBar getAppLinkBar() {
        return linkBar;
    }

    private void processSelection(String selection) {
        if (selection.equalsIgnoreCase("Download")) {
            Flash.get().navigateToURL(Constants.APP_DOWNLOAD_URL);
        } else if (selection.equalsIgnoreCase("Discuss")) {
            Flash.get().navigateToURL(Constants.APP_DISCUSS_URL);
        } else if (selection.equalsIgnoreCase("About")) {
            Alert.show("Powered by Flash4j", "Flex4j Explorer");
        }
    }
}
