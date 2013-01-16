package com.emitrom.flex4j.explorer.client.data.misc.file;

import com.emitrom.flex4j.explorer.client.data.AbstractExplorerTreeItem;

public class FileTreeItem extends AbstractExplorerTreeItem {

    private static final FileTreeItem INSTANCE = new FileTreeItem();
    private static final String PACKAGE_NAME = "misc.file";

    public static FileTreeItem get() {
        return INSTANCE;
    }

    private FileTreeItem() {
        this.setLabel("File");
    }

    @Override
    public String getPackageName() {
        return PACKAGE_NAME;
    }

    @Override
    public void createElements() {
        elements.add("FileRead");
        elements.add("FileWrite");
    }

}
