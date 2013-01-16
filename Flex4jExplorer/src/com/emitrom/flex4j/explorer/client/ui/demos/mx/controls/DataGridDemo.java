/*******************************************************************************
 * DataGridDemo.java is part of the Flex4j Explorer (for Flex4j 3.0)
 * 
 * Copyright (c) 2012 Emitrom LLC. All rights reserved.
 * 
 * http://www.emitrom.com/
 * 
 ******************************************************************************/
package com.emitrom.flex4j.explorer.client.ui.demos.mx.controls;

import com.emitrom.flash4j.core.client.data.BaseModel;
import com.emitrom.flash4j.core.client.events.Event;
import com.emitrom.flash4j.core.client.events.handlers.EventHandler;
import com.emitrom.flash4j.flex.client.mx.collections.ArrayCollection;
import com.emitrom.flash4j.flex.client.mx.containers.Panel;
import com.emitrom.flash4j.flex.client.mx.controls.Alert;
import com.emitrom.flash4j.flex.client.mx.controls.DataGrid;
import com.emitrom.flash4j.flex.client.mx.controls.datagridClasses.DataGridColumn;
import com.emitrom.flash4j.flex.client.mx.core.ContainerLayout;
import com.emitrom.flash4j.flex.client.mx.events.ListEvent;
import com.emitrom.flex4j.explorer.client.ui.demos.AbstractDemo;

public class DataGridDemo extends AbstractDemo {

    private static final DataGridDemo INSTANCE = new DataGridDemo();
    public static final String FULL_PATH = "mx.controls.DataGrid";

    public static DataGridDemo get() {
        return INSTANCE;
    }

    private DataGridDemo() {

        final Panel panel = new Panel("DataGrid Control Example");
        panel.setLayout(ContainerLayout.ABSOLUTE);
        panel.setCentered();
        panel.setPercentSize(80, 60);

        ArrayCollection dataProvider = new ArrayCollection();
        dataProvider.addItem(new SuperHero("Logan", "Wolverine"));
        dataProvider.addItem(new SuperHero("Scott Summers", "Cyclops"));
        dataProvider.addItem(new SuperHero("Professor Charles Francis Xavier", "Professor X"));
        dataProvider.addItem(new SuperHero("Jean Grey-Summers", "Marvel Girl"));
        dataProvider.addItem(new SuperHero("Kurt Wagner", "Nightcrawler"));
        dataProvider.addItem(new SuperHero("Robert Louis Drake", "Iceman"));
        dataProvider.addItem(new SuperHero("Ororo Lqaldi T' Challa-Wakandas", "Storm"));
        dataProvider.addItem(new SuperHero("Henry Phillip McKoy", "Beast"));

        DataGridColumn realNameColumn = new DataGridColumn();
        realNameColumn.setDataField(SuperHero.REAL_NAME);
        realNameColumn.setHeaderText("Realname");

        DataGridColumn nickNameColumn = new DataGridColumn();
        nickNameColumn.setDataField(SuperHero.NICK_NAME);
        nickNameColumn.setHeaderText("Nickname");

        final DataGrid dataGrid = new DataGrid();
        dataGrid.strech();
        dataGrid.setDataProvider(dataProvider);
        dataGrid.setColumns(realNameColumn, nickNameColumn);
        dataGrid.addEventHandler(ListEvent.ITEM_CLICK, new EventHandler() {
            @Override
            public void onEvent(Event event) {
                BaseModel record = dataGrid.getSelection();
                Alert.show(record.get(SuperHero.REAL_NAME) + " a.k.a " + record.get(SuperHero.NICK_NAME),
                                "You selected");
            }
        });
        panel.addElement(dataGrid);

        this.addElement(panel);

    }

    @Override
    public String getDemoPath() {
        return "mx/controls/DataGridDemo.java";
    }

    @Override
    public String getTitle() {
        return "DataGrid";
    }

    private class SuperHero extends BaseModel {
        public static final String REAL_NAME = "realName";
        public static final String NICK_NAME = "nickName";

        public SuperHero(String realName, String nickName) {
            this.set(NICK_NAME, nickName);
            this.set(REAL_NAME, realName);
        }
    }

}
