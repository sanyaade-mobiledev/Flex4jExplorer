/*******************************************************************************
 * StyleUtil.java is part of the Flex4j Explorer (for Flex4j 3.0)
 * 
 * Copyright (c) 2012 Emitrom LLC. All rights reserved.
 * 
 * http://www.emitrom.com/
 * 
 ******************************************************************************/
package com.emitrom.flex4j.explorer.client.utils;

import com.emitrom.flash4j.flex.client.mx.styles.CSSStyleDeclaration;
import com.emitrom.flash4j.flex.client.mx.styles.StyleManager;

public class StyleUtil {

    private StyleUtil() {

    }

    public static void createStyles() {
        StyleManager.get().getGlobalStyleDeclaration().setStyle("fontStyle", "italic");
        createCenteredTextStyle();
    }

    private static void createCenteredTextStyle() {
        CSSStyleDeclaration centeredText = new CSSStyleDeclaration();
        centeredText.setStyle("textAlign", "center");
        centeredText.setStyle("fontWeight", "bold");
        centeredText.setStyle("fontSize", "14");
        StyleManager.get().setStyleDeclaration("." + Constants.PANEL_HEADER_STYLE, centeredText, true);
    }
}
