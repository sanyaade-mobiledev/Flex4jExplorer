/*******************************************************************************
 * SourceCodePanel.java is part of the Flex4j Explorer (for Flex4j 3.0)
 * 
 * Copyright (c) 2012 Emitrom LLC. All rights reserved.
 * 
 * http://www.emitrom.com/
 * 
 ******************************************************************************/
package com.emitrom.flex4j.explorer.client.ui.demos;

import com.emitrom.flash4j.core.client.geom.Point;
import com.emitrom.flash4j.flex.client.mx.containers.Panel;
import com.emitrom.flash4j.flex.client.spark.components.Application;
import com.emitrom.flex4j.explorer.client.utils.Constants;

public class SourceCodePanel extends Panel {

    public static SourceCodePanel get() {
        return new SourceCodePanel();
    }

    private SourceCodePanel() {
        this.setStyle("borderColor", "#CCCCCC");
        this.setStyle("borderAlpha", "1");
        this.setStyle("titleStyleName", Constants.PANEL_HEADER_STYLE);
        this.setTitle("Source Code");
        this.setSize(1000, 10);

        Point point = new Point();
        point = Application.get().localToGlobal(point);

        this.setX(point.getX() + 250);
        this.setY(point.getY() + 25);
    }
}
