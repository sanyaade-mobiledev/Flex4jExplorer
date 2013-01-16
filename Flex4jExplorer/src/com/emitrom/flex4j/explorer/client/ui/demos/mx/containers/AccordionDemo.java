package com.emitrom.flex4j.explorer.client.ui.demos.mx.containers;

import com.emitrom.flash4j.flex.client.mx.containers.Accordion;
import com.emitrom.flash4j.flex.client.mx.containers.Panel;
import com.emitrom.flash4j.flex.client.mx.containers.VBox;
import com.emitrom.flash4j.flex.client.mx.controls.Label;
import com.emitrom.flash4j.flex.client.mx.core.ContainerLayout;
import com.emitrom.flex4j.explorer.client.ui.demos.AbstractDemo;

public class AccordionDemo extends AbstractDemo {

    private static final AccordionDemo INSTANCE = new AccordionDemo();

    public static final String FULL_PATH = "mx.containers.Accordion";

    public static AccordionDemo get() {
        return INSTANCE;
    }

    private AccordionDemo() {

        Panel panel = new Panel("Accordion Container Example");
        panel.setLayout(ContainerLayout.VERTICAL);
        panel.setCentered();
        panel.setPercentSize(80, 80);

        Accordion container = new Accordion();
        container.strech();

        VBox item = new VBox();
        item.setLabel("Accordion Item 1");
        item.addElement(new Label("I m inside accordion 1"));
        container.addElement(item);

        item = new VBox();
        item.setLabel("Accordion Item 2");
        item.addElement(new Label("I m inside accordion 2"));
        container.addElement(item);

        item = new VBox();
        item.setLabel("Accordion Item 3");
        item.addElement(new Label("I m inside accordion 3"));
        container.addElement(item);

        panel.addElement(container);

        this.addElement(panel);
    }

    @Override
    public String getDemoPath() {
        return "mx/containers/AccordionDemo.java";
    }

    @Override
    public String getTitle() {
        return "Accordion";
    }
}
