/*******************************************************************************
 * AppToggleButtonBar.java is part of the Flex4j Explorer (for Flex4j 3.0)
 * 
 * Copyright (c) 2012 Emitrom LLC. All rights reserved.
 * 
 * http://www.emitrom.com/
 * 
 ******************************************************************************/
package com.emitrom.flex4j.explorer.client.ui.widgets;

import com.emitrom.flash4j.core.client.events.Event;
import com.emitrom.flash4j.core.client.events.handlers.EventHandler;
import com.emitrom.flash4j.flex.client.mx.collections.ArrayCollection;
import com.emitrom.flash4j.flex.client.mx.controls.ToggleButtonBar;
import com.emitrom.flash4j.flex.client.mx.events.ItemClickEvent;
import com.emitrom.flex4j.explorer.client.ui.pages.NavigationViewstack;

public class AppToggleButtonBar extends ToggleButtonBar {

    private static final AppToggleButtonBar INSTANCE = new AppToggleButtonBar();

    public static AppToggleButtonBar get() {
        return INSTANCE;
    }

    private AppToggleButtonBar() {
        ArrayCollection entries = new ArrayCollection();
        entries.addItem("TreeView");
        entries.addItem("GridView");
        this.setDataProvider(entries);
        this.addEventHandler(ItemClickEvent.ITEM_CLICK, new EventHandler() {
            @Override
            public void onEvent(Event event) {
                ItemClickEvent e = ItemClickEvent.cast(event);
                if (e.getLabel().equalsIgnoreCase("TreeView")) {
                    NavigationViewstack.get().setSelectedIndex(0);
                } else {
                    NavigationViewstack.get().setSelectedIndex(1);
                }
            }
        });
    }
}
