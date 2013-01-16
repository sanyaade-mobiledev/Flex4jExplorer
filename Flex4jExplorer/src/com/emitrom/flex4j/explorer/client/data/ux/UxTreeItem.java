package com.emitrom.flex4j.explorer.client.data.ux;

import java.util.ArrayList;
import java.util.List;

import com.emitrom.flash4j.flex.client.mx.controls.treeClasses.TreeItem;
import com.emitrom.flex4j.explorer.client.data.ux.containers.UxContainersTreeItem;
import com.emitrom.flex4j.explorer.client.data.ux.controls.UxControlsTreeItem;

public class UxTreeItem extends TreeItem {

	private static final UxTreeItem INSTANCE = new UxTreeItem();
	List<TreeItem> children = new ArrayList<TreeItem>();

	public static UxTreeItem get() {
		return INSTANCE;
	}

	private UxTreeItem() {
		this.setLabel("Ux");
		children.add(UxContainersTreeItem.get());
		children.add(UxControlsTreeItem.get());
		this.addChildren(children);
	}

}