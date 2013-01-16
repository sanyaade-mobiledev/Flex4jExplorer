/*******************************************************************************
 * DateChooserDemo.java is part of the Flex4j Explorer (for Flex4j 3.0)
 * 
 * Copyright (c) 2012 Emitrom LLC. All rights reserved.
 * 
 * http://www.emitrom.com/
 * 
 ******************************************************************************/
package com.emitrom.flex4j.explorer.client.ui.demos.mx.controls;

import com.emitrom.flash4j.core.client.events.Event;
import com.emitrom.flash4j.core.client.events.handlers.EventHandler;
import com.emitrom.flash4j.core.client.toplevel.Date;
import com.emitrom.flash4j.flex.client.mx.containers.Panel;
import com.emitrom.flash4j.flex.client.mx.controls.DateChooser;
import com.emitrom.flash4j.flex.client.mx.core.ContainerLayout;
import com.emitrom.flash4j.flex.client.mx.events.DateChooserEvent;
import com.emitrom.flex4j.explorer.client.ui.demos.AbstractDemo;
import com.google.gwt.user.client.Window;

public class DateChooserDemo extends AbstractDemo {

    private static final DateChooserDemo INSTANCE = new DateChooserDemo();
    public static final String FULL_PATH = "mx.controls.DateChooser";

    public static DateChooserDemo get() {
        return INSTANCE;
    }

    private DateChooserDemo() {

        final Panel panel = new Panel("DateChooser Control Example");
        panel.setLayout(ContainerLayout.ABSOLUTE);
        panel.setCentered();
        panel.setPercentSize(80, 60);

        final DateChooser dateChooser = new DateChooser();
        dateChooser.setCentered();
        dateChooser.setYearNavigationEnabled(true);
        dateChooser.setDisabledRanges(new Date(25), new Date(26), new Date(27), new Date(28));
        dateChooser.addEventHandler(DateChooserEvent.CHANGE, new EventHandler() {
            @Override
            public void onEvent(Event event) {
                Date date = dateChooser.getSelectedDate();
                Window.alert("You selected :" + date.getFullYear() + "/" + date.getMonth() + "/" + date.getDate());
            }
        });
        panel.addElement(dateChooser);
        this.addElement(panel);

    }

    @Override
    public String getDemoPath() {
        return "mx/controls/DateChooserDemo.java";
    }

    @Override
    public String getTitle() {
        return "DateChooser";
    }
}
