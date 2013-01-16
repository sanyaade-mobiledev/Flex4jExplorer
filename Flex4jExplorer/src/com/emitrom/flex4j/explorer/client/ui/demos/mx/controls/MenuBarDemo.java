/*******************************************************************************
 * MenuDemo.java is part of the Flex4j Explorer (for Flex4j 3.0)
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
import com.emitrom.flash4j.flex.client.mx.controls.Button;
import com.emitrom.flash4j.flex.client.mx.controls.Label;
import com.emitrom.flash4j.flex.client.mx.controls.MenuBar;
import com.emitrom.flash4j.flex.client.mx.controls.menuClasses.FormMenuItem;
import com.emitrom.flash4j.flex.client.mx.controls.menuClasses.MenuItem;
import com.emitrom.flash4j.flex.client.mx.core.ContainerLayout;
import com.emitrom.flash4j.flex.client.mx.events.MenuEvent;
import com.emitrom.flex4j.explorer.client.ui.demos.AbstractDemo;
import com.google.gwt.user.client.Window;

public class MenuBarDemo extends AbstractDemo {

    private static final MenuBarDemo INSTANCE = new MenuBarDemo();
    public static final String FULL_PATH = "mx.controls.MenuBar";

    public static MenuBarDemo get() {
        return INSTANCE;
    }

    Button button;

    private MenuBarDemo() {

        final Panel panel = new Panel("MenuBar Control Example");
        panel.setLayout(ContainerLayout.ABSOLUTE);
        panel.setCentered();
        panel.setPercentSize(80, 60);

        VBox box = new VBox();
        box.setRelativePosition(10);
        box.addElement(new Label("Select a menu item"));

        MenuItem item1 = new MenuItem("Menu 1");
        item1.addChildren(new MenuItem("Menu 1 A"), new MenuItem("Menu 1 B"));

        MenuItem item2 = new MenuItem("Menu 2");

        MenuItem child = new MenuItem("Menu 2 B");
        FormMenuItem radioMenuItem = FormMenuItem.createRadioMenuItem("Menu 3 A");
        radioMenuItem.setGroupName("Flex4j");
        radioMenuItem.setData("MenuBar Demo");
        child.addChild(radioMenuItem);

        item2.addChildren(new MenuItem("Menu 2 A"), MenuItem.createSeparator(), child);

        MenuBar menuBar = new MenuBar();
        menuBar.setLabelField("label");
        menuBar.addMenuItems(item1, item2);
        menuBar.addEventHandler(MenuEvent.ITEM_CLICK, new EventHandler() {
            @Override
            public void onEvent(Event event) {
                MenuEvent e = MenuEvent.cast(event);
                String data = e.getItem().getData();
                if (data == null || data.isEmpty()) {
                    data = " this item has no data";
                }
                Window.alert("Data : " + data);
            }
        });
        box.addElement(menuBar);

        panel.addElement(box);
        this.addElement(panel);

    }

    @Override
    public String getDemoPath() {
        return "mx/controls/MenuBarDemo.java";
    }

    @Override
    public String getTitle() {
        return "MenuBar";
    }
}
