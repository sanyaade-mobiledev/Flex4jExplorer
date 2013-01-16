/*******************************************************************************
 * Flex4jExplorer.java is part of the Flex4j Explorer (for Flex4j 3.0)
 * 
 * Copyright (c) 2012 Emitrom LLC. All rights reserved.
 * 
 * http://www.emitrom.com/
 * 
 ******************************************************************************/
package com.emitrom.flex4j.explorer.client;

import com.emitrom.flash4j.flex.client.core.runtime.FlexEntryPoint;
import com.emitrom.flex4j.explorer.client.controllers.AppController;

/**
 * Entry point class
 */
public class Flex4jExplorer extends FlexEntryPoint {

    @Override
    public void onLoad() {
        AppController.get().lauchApp();
    }

}