/*******************************************************************************
 * ComponentsTree.java is part of the Flex4j Explorer (for Flex4j 3.0)
 * 
 * Copyright (c) 2012 Emitrom LLC. All rights reserved.
 * 
 * http://www.emitrom.com/
 * 
 ******************************************************************************/
package com.emitrom.flex4j.explorer.client.ui.pages;

import com.emitrom.flash4j.core.client.events.Event;
import com.emitrom.flash4j.core.client.events.handlers.EventHandler;
import com.emitrom.flash4j.flex.client.mx.events.ListEvent;
import com.emitrom.flash4j.flex.ux.client.mx.containers.mdatagrid.SuperDataGrid;
import com.emitrom.flash4j.flex.ux.client.mx.containers.mdatagrid.datagridClasses.SuperDataGridColumn;
import com.emitrom.flex4j.explorer.client.data.ComponentsDataGridStore;
import com.google.gwt.user.client.History;

public class ComponentsDataGrid extends SuperDataGrid {

    private static final ComponentsDataGrid INSTANCE = new ComponentsDataGrid();

    public static ComponentsDataGrid get() {
        return INSTANCE;
    }

    private ComponentsDataGrid() {
        this.strech();
        this.setDataProvider(ComponentsDataGridStore.get());

        SuperDataGridColumn column = new SuperDataGridColumn();
        column.setDataField("label");
        column.setHeaderText("Components");
        this.setColumns(column);
        this.addEventHandler(ListEvent.ITEM_CLICK, new EventHandler() {
            @Override
            public void onEvent(Event event) {
                String selectedItem = ComponentsDataGrid.this.getSelectedItem().getLabel();
                History.newItem(selectedItem, true);
            }
        });

    }

}
