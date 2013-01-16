package com.emitrom.flex4j.explorer.client.ui.demos.mx.containers;

import com.emitrom.flash4j.flex.client.mx.containers.Box;
import com.emitrom.flash4j.flex.client.mx.containers.BoxDirection;
import com.emitrom.flash4j.flex.client.mx.containers.Panel;
import com.emitrom.flash4j.flex.client.mx.containers.VBox;
import com.emitrom.flash4j.flex.client.mx.controls.Button;
import com.emitrom.flash4j.flex.client.mx.controls.Label;
import com.emitrom.flash4j.flex.client.mx.core.ContainerLayout;
import com.emitrom.flex4j.explorer.client.ui.demos.AbstractDemo;

public class BoxDemo extends AbstractDemo {

    private static final BoxDemo INSTANCE = new BoxDemo();

    public static final String FULL_PATH = "mx.containers.Box";

    public static BoxDemo get() {
        return INSTANCE;
    }

    private BoxDemo() {

        Panel panel = new Panel("Box Container Example");
        panel.setLayout(ContainerLayout.ABSOLUTE);
        panel.setCentered();
        panel.setPercentSize(80, 80);

        VBox container = new VBox();
        container.strech();
        container.setRelativePosition(10);

        container.addElement(new Label("A Box container with vertically aligned children."));

        Box box = new Box(BoxDirection.VERTICAL);
        box.setStyle("borderStyle", "solid");
        box.setStyle("paddingTop", "10");
        box.setStyle("paddingLeft", "10");
        box.addElement(new Button("Button 1"));
        box.addElement(new Button("Button 2"));
        box.addElement(new Button("Button 3"));
        container.addElement(box);

        container.addElement(new Label("A Box container with horizontally aligned children."));

        box = new Box(BoxDirection.HORIZONTAL);
        box.setStyle("borderStyle", "solid");
        box.setStyle("paddingTop", "10");
        box.setStyle("paddingLeft", "10");
        box.addElement(new Button("Button 1"));
        box.addElement(new Button("Button 2"));
        box.addElement(new Button("Button 3"));
        container.addElement(box);

        panel.addElement(container);
        this.addElement(panel);
    }

    @Override
    public String getDemoPath() {
        return "mx/containers/BoxDemo.java";
    }

    @Override
    public String getTitle() {
        return "Box";
    }
}
