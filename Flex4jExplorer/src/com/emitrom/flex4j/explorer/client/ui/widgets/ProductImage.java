/*******************************************************************************
 * ProductImage.java is part of the Flex4j Explorer (for Flex4j 3.0)
 * 
 * Copyright (c) 2012 Emitrom LLC. All rights reserved.
 * 
 * http://www.emitrom.com/
 * 
 ******************************************************************************/
package com.emitrom.flex4j.explorer.client.ui.widgets;

import com.emitrom.flash4j.flex.client.mx.collections.ArrayCollection;
import com.emitrom.flash4j.flex.client.mx.containers.VBox;
import com.emitrom.flash4j.flex.client.mx.controls.Image;
import com.emitrom.flash4j.flex.ux.client.mx.fisheye.Fisheye;

/**
 * Implements the product image with bouncing letters
 */
public class ProductImage extends VBox {

    private static final ProductImage INSTANCE = new ProductImage();

    public static ProductImage get() {
        return INSTANCE;
    }

    private ProductImage() {
        ArrayCollection dataProvider = new ArrayCollection();
        dataProvider.addItem("/imgs/logo/F.png");
        dataProvider.addItem("/imgs/logo/L.png");
        dataProvider.addItem("/imgs/logo/E.png");
        dataProvider.addItem("/imgs/logo/X.png");
        dataProvider.addItem("/imgs/logo/4.png");
        dataProvider.addItem("/imgs/logo/J.png");

        Fisheye fishEye = new Fisheye();
        fishEye.setDataProvider(dataProvider);
        fishEye.strech();
        fishEye.setSelectionEnabled(false);
        fishEye.setStyle("verticalAlign", "bottom");
        fishEye.setStyle("horizontalAlign", "center");
        fishEye.setItemRenderer(new Image());

        this.strech();
        this.addElement(fishEye);
        this.setClipContent(true);

    }
}
