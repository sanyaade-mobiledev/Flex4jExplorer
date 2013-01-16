/*******************************************************************************
 * SourceCodePanel.java is part of the Flex4j Explorer (for Flex4j 3.0)
 * 
 * Copyright (c) 2012 Emitrom LLC. All rights reserved.
 * 
 * http://www.emitrom.com/
 * 
 ******************************************************************************/
package com.emitrom.flex4j.explorer.client.ui.demos;

import com.emitrom.flash4j.core.client.events.Event;
import com.emitrom.flash4j.core.client.events.MouseEvent;
import com.emitrom.flash4j.core.client.events.handlers.EventHandler;
import com.emitrom.flash4j.core.client.geom.Point;
import com.emitrom.flash4j.flex.client.mx.containers.ControlBar;
import com.emitrom.flash4j.flex.client.mx.containers.Panel;
import com.emitrom.flash4j.flex.client.mx.controls.Button;
import com.emitrom.flash4j.flex.client.mx.controls.Spacer;
import com.emitrom.flash4j.flex.client.mx.managers.PopUpManager;
import com.emitrom.flash4j.flex.client.spark.components.Application;
import com.emitrom.flash4j.flex.ux.client.mx.iframe.IFrame;
import com.emitrom.flex4j.explorer.client.utils.Constants;

public class IFramePanel extends Panel {

    public static IFramePanel get() {
        return new IFramePanel();
    }

    private IFramePanel() {
        this.setStyle("borderColor", "#CCCCCC");
        this.setStyle("borderAlpha", "1");
        this.setStyle("titleStyleName", Constants.PANEL_HEADER_STYLE);

        this.setSize(1200, 600);

        Point point = new Point();
        point = Application.get().localToGlobal(point);

        this.setX(point.getX() + 100);
        this.setY(point.getY() + 15);
    }

    public void show(String title, String url) {
        this.setTitle(title);
        final IFrame iFrame = new IFrame(url);
        iFrame.setUseLoadIndicator(true);
        this.addElement(iFrame);

        PopUpManager.addPopUp(this, Application.get(), true);

        ControlBar controlBar = new ControlBar();
        controlBar.addElement(new Spacer());
        Button closeButton = new Button("Close");
        closeButton.setIcon("/imgs/icons/quit.png");
        closeButton.setHeight(25);
        closeButton.addEventHandler(MouseEvent.CLICK, new EventHandler() {
            @Override
            public void onEvent(Event event) {
                PopUpManager.removePopUp(IFramePanel.this);
                iFrame.removeIFrame();
            }
        });
        controlBar.addElement(closeButton);
        this.addElement(controlBar);
    }
}
