package com.emitrom.flex4j.explorer.client.data.ux.containers;

import com.emitrom.flex4j.explorer.client.data.AbstractExplorerTreeItem;

public class UxContainersTreeItem extends AbstractExplorerTreeItem {

	private static final UxContainersTreeItem INSTANCE = new UxContainersTreeItem();
	private static final String PACKAGE_NAME = "ux.containers";

	public static UxContainersTreeItem get() {
		return INSTANCE;
	}

	private UxContainersTreeItem() {
		this.setLabel("containers");
	}

	@Override
	public String getPackageName() {
		return PACKAGE_NAME;
	}

	@Override
	public void createElements() {
		elements.add("CoverflowContainer");
		elements.add("Rolotab");
		elements.add("SuperAccordion");
		elements.add("SuperPanel");
	}

}
