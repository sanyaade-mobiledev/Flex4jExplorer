/*******************************************************************************
 * LayoutUtil.java is part of the Flex4j Explorer (for Flex4j 3.0)
 * 
 * Copyright (c) 2012 Emitrom LLC. All rights reserved.
 *
 *  http://www.emitrom.com/
 *  
 ******************************************************************************/
package com.emitrom.flex4j.explorer.client.utils;

import com.emitrom.flash4j.flex.client.mx.core.UIComponent;

/**
 * Utility class to layout components
 */
public class LayoutUtil {

    private LayoutUtil() {

    }

    public static void strech(UIComponent component) {
        component.setPercentHeight(100);
        component.setPercentWidth(100);
    }

    public static void center(UIComponent component) {
        component.setVerticalCenter(0);
        component.setHorizontalCenter(0);
    }

    public static void strech(UIComponent component, double percentWidth, double percentHeight) {
        component.setPercentHeight(percentHeight);
        component.setPercentWidth(percentWidth);
    }

}
