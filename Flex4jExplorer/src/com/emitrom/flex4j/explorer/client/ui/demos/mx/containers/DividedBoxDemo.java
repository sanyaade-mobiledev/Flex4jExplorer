package com.emitrom.flex4j.explorer.client.ui.demos.mx.containers;

import com.emitrom.flash4j.flex.client.mx.containers.BoxDirection;
import com.emitrom.flash4j.flex.client.mx.containers.DividedBox;
import com.emitrom.flash4j.flex.client.mx.containers.Panel;
import com.emitrom.flash4j.flex.client.mx.containers.VBox;
import com.emitrom.flash4j.flex.client.mx.controls.Label;
import com.emitrom.flash4j.flex.client.mx.core.ContainerLayout;
import com.emitrom.flex4j.explorer.client.ui.demos.AbstractDemo;

public class DividedBoxDemo extends AbstractDemo {

    private static final DividedBoxDemo INSTANCE = new DividedBoxDemo();

    public static final String FULL_PATH = "mx.containers.DividedBox";

    public static DividedBoxDemo get() {
        return INSTANCE;
    }

    private DividedBoxDemo() {

        Panel panel = new Panel("DividedBox Container Example");
        panel.setLayout(ContainerLayout.ABSOLUTE);
        panel.setCentered();
        panel.setPercentSize(80, 80);

        VBox box = new VBox();
        box.strech();
        box.setRelativePosition(10);

        box.addElement(new Label(
                        "A horizontal DividedBox container. Drag the divider side to side to resize the children"));

        DividedBox dividedBox = new DividedBox(BoxDirection.HORIZONTAL);
        dividedBox.strech();

        Panel child = new Panel("Panel 1");
        child.setPercentSize(25, 100);
        child.setStyle("backgroundColor", "#CCCCCC");
        child.setStyle("borderStyle", "solid");
        child.setStyle("roundedBottomCorners", "true");
        dividedBox.addElement(child);

        child = new Panel("Panel 2");
        child.setPercentSize(25, 100);
        child.setStyle("backgroundColor", "#CCCCCC");
        child.setStyle("borderStyle", "solid");
        child.setStyle("roundedBottomCorners", "true");
        dividedBox.addElement(child);

        box.addElement(dividedBox);
        panel.addElement(box);
        this.addElement(panel);

    }

    @Override
    public String getDemoPath() {
        return "mx/containers/DividedBoxDemo.java";
    }

    @Override
    public String getTitle() {
        return "DividedBox";
    }
}
