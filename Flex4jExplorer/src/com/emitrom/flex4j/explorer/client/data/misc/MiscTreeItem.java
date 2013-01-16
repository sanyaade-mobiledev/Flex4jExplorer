package com.emitrom.flex4j.explorer.client.data.misc;

import java.util.ArrayList;
import java.util.List;

import com.emitrom.flash4j.flex.client.mx.controls.treeClasses.TreeItem;
import com.emitrom.flex4j.explorer.client.data.misc.file.FileTreeItem;
import com.emitrom.flex4j.explorer.client.data.misc.gwt.GwtTreeItem;
import com.emitrom.flex4j.explorer.client.data.misc.maps.MapsTreeItem;

public class MiscTreeItem extends TreeItem {

    private static final MiscTreeItem INSTANCE = new MiscTreeItem();
    List<TreeItem> children = new ArrayList<TreeItem>();

    public static MiscTreeItem get() {
        return INSTANCE;
    }

    private MiscTreeItem() {
        this.setLabel("Misc");
        children.add(FileTreeItem.get());
        children.add(GwtTreeItem.get());
        children.add(MapsTreeItem.get());
        this.addChildren(children);
    }

}