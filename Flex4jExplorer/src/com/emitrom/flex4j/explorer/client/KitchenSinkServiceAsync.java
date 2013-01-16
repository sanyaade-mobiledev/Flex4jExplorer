/*******************************************************************************
 * KitchenSinkServiceAsync.java is part of the Flex4j Explorer (for Flex4j 3.0)
 * 
 * Copyright (c) 2012 Emitrom LLC. All rights reserved.
 *
 *  http://www.emitrom.com/
 *  
 ******************************************************************************/
package com.emitrom.flex4j.explorer.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>KitchenSinkService</code>.
 */
public interface KitchenSinkServiceAsync {
    void getSource(String input, AsyncCallback<String> callback) throws IllegalArgumentException;

    void getVersion(AsyncCallback<String> callback);
}
