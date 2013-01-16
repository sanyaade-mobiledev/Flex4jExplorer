package com.emitrom.flex4j.explorer.client.data.flexlib;

import java.util.ArrayList;
import java.util.List;

import com.emitrom.flash4j.flex.client.mx.controls.treeClasses.TreeItem;
import com.emitrom.flex4j.explorer.client.data.flexlib.containers.FlexLibContainersTreeItem;
import com.emitrom.flex4j.explorer.client.data.flexlib.controls.FlexLibControlsTreeItem;

public class FlexLibTreeItem extends TreeItem {

    private static final FlexLibTreeItem INSTANCE = new FlexLibTreeItem();
    List<TreeItem> children = new ArrayList<TreeItem>();

    public static FlexLibTreeItem get() {
        return INSTANCE;
    }

    private FlexLibTreeItem() {
        this.setLabel("FlexLib");
        children.add(FlexLibContainersTreeItem.get());
        children.add(FlexLibControlsTreeItem.get());
        this.addChildren(children);
    }

}
