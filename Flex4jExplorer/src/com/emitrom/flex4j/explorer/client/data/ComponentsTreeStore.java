/*******************************************************************************
 * ComponentsTreeStore.java is part of the Flex4j Explorer (for Flex4j 3.0)
 * 
 * Copyright (c) 2012 Emitrom LLC. All rights reserved.
 * 
 * http://www.emitrom.com/
 * 
 ******************************************************************************/
package com.emitrom.flex4j.explorer.client.data;

import com.emitrom.flash4j.flex.client.mx.collections.ArrayCollection;
import com.emitrom.flex4j.explorer.client.data.apache.ApacheTreeItem;
import com.emitrom.flex4j.explorer.client.data.flexlib.FlexLibTreeItem;
import com.emitrom.flex4j.explorer.client.data.misc.MiscTreeItem;
import com.emitrom.flex4j.explorer.client.data.ux.UxTreeItem;

public class ComponentsTreeStore extends ArrayCollection {

	private static final ComponentsTreeStore INSTANCE = new ComponentsTreeStore();

	public static ComponentsTreeStore get() {
		return INSTANCE;
	}

	private ComponentsTreeStore() {
		this.addItem(ApacheTreeItem.get());
		this.addItem(FlexLibTreeItem.get());
		this.addItem(UxTreeItem.get());
		this.addItem(MiscTreeItem.get());
	}

}
