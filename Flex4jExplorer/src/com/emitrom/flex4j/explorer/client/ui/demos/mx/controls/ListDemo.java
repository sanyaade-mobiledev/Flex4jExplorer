/*******************************************************************************
 * ListDemo.java is part of the Flex4j Explorer (for Flex4j 3.0)
 * 
 * Copyright (c) 2012 Emitrom LLC. All rights reserved.
 * 
 * http://www.emitrom.com/
 * 
 ******************************************************************************/
package com.emitrom.flex4j.explorer.client.ui.demos.mx.controls;

import com.emitrom.flash4j.core.client.events.Event;
import com.emitrom.flash4j.core.client.events.handlers.EventHandler;
import com.emitrom.flash4j.flex.client.mx.collections.ArrayCollection;
import com.emitrom.flash4j.flex.client.mx.containers.Panel;
import com.emitrom.flash4j.flex.client.mx.containers.VBox;
import com.emitrom.flash4j.flex.client.mx.controls.Label;
import com.emitrom.flash4j.flex.client.mx.controls.List;
import com.emitrom.flash4j.flex.client.mx.controls.listClasses.ListItem;
import com.emitrom.flash4j.flex.client.mx.core.ContainerLayout;
import com.emitrom.flash4j.flex.client.mx.events.IndexChangeEvent;
import com.emitrom.flex4j.explorer.client.ui.demos.AbstractDemo;

public class ListDemo extends AbstractDemo {

    private static final ListDemo INSTANCE = new ListDemo();
    public static final String FULL_PATH = "mx.controls.List";

    public static ListDemo get() {
        return INSTANCE;
    }

    private Label state;
    private Label abbreviation;

    private ListDemo() {

        final Panel panel = new Panel("List Control Example");
        panel.setLayout(ContainerLayout.ABSOLUTE);
        panel.setCentered();
        panel.setPercentSize(80, 60);

        VBox box = new VBox();
        box.setRelativePosition(10);
        box.addElement(new Label("Select a state to se its abreviation."));

        ArrayCollection dataProvider = new ArrayCollection();

        ListItem item = new ListItem();
        item.setLabel("Alabama");
        item.setData("AL");
        dataProvider.addItem(item);

        item = new ListItem();
        item.setLabel("Alaska");
        item.setData("AK");
        dataProvider.addItem(item);

        item = new ListItem();
        item.setLabel("Arizona");
        item.setData("AZ");
        dataProvider.addItem(item);

        item = new ListItem();
        item.setLabel("Arkansas");
        item.setData("AR");
        dataProvider.addItem(item);

        item = new ListItem();
        item.setLabel("California");
        item.setData("Cal");
        dataProvider.addItem(item);

        item = new ListItem();
        item.setLabel("Colorado");
        item.setData("Cal");
        dataProvider.addItem(item);

        item = new ListItem();
        item.setLabel("Connecticut");
        item.setData("CT");
        dataProvider.addItem(item);

        final List list = new List();
        list.strech();
        list.setStyle("color", "blue");
        list.setDataProvider(dataProvider);
        list.addEventHandler(IndexChangeEvent.CHANGE, new EventHandler() {
            @Override
            public void onEvent(Event event) {
                ListItem item = list.getSelectedItem();
                state.setText("Selected state : " + item.getLabel());
                abbreviation.setText("State Abbreviation : " + item.getData());
            }
        });
        box.addElement(list);

        state = new Label("Selected stated : ");
        abbreviation = new Label("Selected stated : ");
        box.addElement(state);
        box.addElement(abbreviation);

        panel.addElement(box);
        this.addElement(panel);

    }

    @Override
    public String getDemoPath() {
        return "mx/controls/ListDemo.java";
    }

    @Override
    public String getTitle() {
        return "List";
    }
}
