/*******************************************************************************
 * NavigationViewstack.java is part of the Flex4j Explorer (for Flex4j 3.0)
 * 
 * Copyright (c) 2012 Emitrom LLC. All rights reserved.
 * 
 * http://www.emitrom.com/
 * 
 ******************************************************************************/
package com.emitrom.flex4j.explorer.client.ui.pages;

import com.emitrom.flash4j.core.client.events.Event;
import com.emitrom.flash4j.core.client.events.handlers.EventHandler;
import com.emitrom.flash4j.flex.client.mx.containers.Canvas;
import com.emitrom.flash4j.flex.client.mx.containers.VBox;
import com.emitrom.flash4j.flex.client.mx.containers.ViewStack;
import com.emitrom.flash4j.flex.client.mx.core.Container;
import com.emitrom.flash4j.flex.client.mx.events.FlexEvent;
import com.emitrom.flash4j.flex.ux.client.mx.containers.mdatagrid.SearchBox;
import com.emitrom.flash4j.flex.ux.client.mx.efflex.mx.viewstackeffects.ListEffect;

public class NavigationViewstack extends ViewStack {

    private static final NavigationViewstack INSTANCE = new NavigationViewstack();

    public static NavigationViewstack get() {
        return INSTANCE;
    }

    private NavigationViewstack() {
        this.strech();

        Canvas canvas = new Canvas();
        canvas.strech();
        canvas.setStyle("backgroundColor", "#EEE9E9");
        canvas.addElement(ComponentsTree.get());
        this.addElement(canvas);

        VBox vBox = new VBox();
        vBox.strech();
        vBox.setStyle("backgroundColor", "#EEE9E9");
        vBox.addElement(new SearchBox(ComponentsDataGrid.get()));
        vBox.addElement(ComponentsDataGrid.get());
        this.addElement(vBox);

        final ListEffect effect = new ListEffect(this);
        this.addEventHandler(FlexEvent.CREATION_COMPLETE, new EventHandler() {
            @Override
            public void onEvent(Event event) {
                for (int i = 0; i < NavigationViewstack.this.getNumChildren(); i++) {
                    Container c = Container.cast(NavigationViewstack.this.getChildAt(i));
                    c.setStyle("showEffect", effect);
                    c.setStyle("hideEffect", effect);
                }
            }
        });
    }
}
