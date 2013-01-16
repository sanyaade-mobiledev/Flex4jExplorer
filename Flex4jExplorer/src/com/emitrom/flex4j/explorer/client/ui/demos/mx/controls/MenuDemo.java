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
import com.emitrom.flash4j.core.client.events.MouseEvent;
import com.emitrom.flash4j.core.client.events.handlers.EventHandler;
import com.emitrom.flash4j.core.client.geom.Point;
import com.emitrom.flash4j.flex.client.mx.containers.Panel;
import com.emitrom.flash4j.flex.client.mx.containers.VBox;
import com.emitrom.flash4j.flex.client.mx.controls.Button;
import com.emitrom.flash4j.flex.client.mx.controls.Label;
import com.emitrom.flash4j.flex.client.mx.controls.Menu;
import com.emitrom.flash4j.flex.client.mx.controls.menuClasses.MenuItem;
import com.emitrom.flash4j.flex.client.mx.core.ContainerLayout;
import com.emitrom.flash4j.flex.client.mx.events.MenuEvent;
import com.emitrom.flex4j.explorer.client.ui.demos.AbstractDemo;
import com.google.gwt.user.client.Window;

public class MenuDemo extends AbstractDemo {

    private static final MenuDemo INSTANCE = new MenuDemo();
    public static final String FULL_PATH = "mx.controls.Menu";

    public static MenuDemo get() {
        return INSTANCE;
    }

    Button button;

    private MenuDemo() {

        final Panel panel = new Panel("Menu Control Example");
        panel.setLayout(ContainerLayout.ABSOLUTE);
        panel.setCentered();
        panel.setPercentSize(80, 60);

        VBox box = new VBox();
        box.setRelativePosition(10);
        box.addElement(new Label("Click the button to open the menu"));

        MenuItem item1 = new MenuItem("MenuItem 1");
        MenuItem item2 = new MenuItem("MenuItem 2");

        final Menu menu = Menu.createMenu(panel, item1, item2);
        menu.setLabelField("label");
        menu.addEventHandler(MenuEvent.ITEM_CLICK, new EventHandler() {
            @Override
            public void onEvent(Event event) {
                MenuEvent e = MenuEvent.cast(event);
                Window.alert("You selected : " + e.getItem().getLabel());
            }
        });

        button = new Button("Open menu");
        button.addEventHandler(MouseEvent.CLICK, new EventHandler() {
            @Override
            public void onEvent(Event event) {
                Point point = new Point(button.getX(), button.getY());
                point = button.localToGlobal(point);
                menu.show(point.getX() + 10, point.getY() + 10);
            }
        });
        box.addElement(button);

        panel.addElement(box);
        this.addElement(panel);

    }

    @Override
    public String getDemoPath() {
        return "mx/controls/MenuDemo.java";
    }

    @Override
    public String getTitle() {
        return "Menu";
    }
}
