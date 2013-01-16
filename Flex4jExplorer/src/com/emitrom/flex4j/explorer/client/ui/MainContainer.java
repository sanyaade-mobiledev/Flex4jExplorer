/*******************************************************************************
 * MainContainer.java is part of the Flex4j Explorer (for Flex4j 3.0)
 * 
 * Copyright (c) 2012 Emitrom LLC. All rights reserved.
 * 
 * http://www.emitrom.com/
 * 
 ******************************************************************************/
package com.emitrom.flex4j.explorer.client.ui;

import com.emitrom.flash4j.core.client.events.Event;
import com.emitrom.flash4j.core.client.events.handlers.EventHandler;
import com.emitrom.flash4j.flex.client.mx.containers.ViewStack;
import com.emitrom.flash4j.flex.client.mx.core.Container;
import com.emitrom.flash4j.flex.client.mx.events.FlexEvent;
import com.emitrom.flash4j.flex.ux.client.mx.efflex.mx.viewstackeffects.FlipPapervision3DTile;
import com.emitrom.flex4j.explorer.client.ui.demos.mx.charts.ChartDashboard;
import com.emitrom.flex4j.explorer.client.ui.pages.DemoContainer;
import com.emitrom.flex4j.explorer.client.ui.pages.StartPage;

/**
 * MainContainer of the explorer
 * 
 */
public class MainContainer extends ViewStack {

    private static final MainContainer INSTANCE = new MainContainer();

    public static MainContainer get() {
        return INSTANCE;
    }

    private MainContainer() {
        this.strech();
        // addElement(StartPage.get());
        addElement(DemoContainer.get());
        addElement(ChartDashboard.get());

        final FlipPapervision3DTile effect = new FlipPapervision3DTile(this);
        this.addEventHandler(FlexEvent.CREATION_COMPLETE, new EventHandler() {
            @Override
            public void onEvent(Event event) {
                for (int i = 0; i < MainContainer.this.getNumChildren(); i++) {
                    Container c = Container.cast(MainContainer.this.getChildAt(i));
                    c.setStyle("showEffect", effect);
                    c.setStyle("hideEffect", effect);
                }
            }
        });

    }

    public void gotoDemoPage() {
        this.setSelectedChild(DemoContainer.get());
    }

    public void gotoStartPage() {
        this.setSelectedChild(StartPage.get());
    }

    public boolean isNotDisplayingDemoPage() {
        return this.getSelectedIndex() != 0;
    }

    public void goToChartPage() {
        this.setSelectedChild(ChartDashboard.get());
    }
}
