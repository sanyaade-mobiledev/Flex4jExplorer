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
import com.emitrom.flash4j.flex.client.mx.controls.Tree;
import com.emitrom.flash4j.flex.client.mx.controls.treeClasses.TreeItem;
import com.emitrom.flash4j.flex.client.mx.events.TreeEvent;
import com.emitrom.flex4j.explorer.client.data.ComponentsTreeStore;
import com.emitrom.flex4j.explorer.client.utils.Constants;
import com.google.gwt.user.client.History;

public class ComponentsTree extends Tree {

    private static final ComponentsTree INSTANCE = new ComponentsTree();

    public static ComponentsTree get() {
        return INSTANCE;
    }

    private ComponentsTree() {
        this.strech();
        this.setStyle("backgroundColor", Constants.DEMO_BG_COLOR);
        this.setDataProvider(ComponentsTreeStore.get());
        this.addEventHandler(TreeEvent.CHANGE, new EventHandler() {
            @Override
            public void onEvent(Event event) {
                TreeItem item = ComponentsTree.this.getSelectedItem();
                if (!item.getData().isEmpty()) {
                    History.newItem(item.getData());
                }
            }
        });

    }

}
