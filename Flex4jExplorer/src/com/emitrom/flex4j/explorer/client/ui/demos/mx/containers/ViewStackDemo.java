package com.emitrom.flex4j.explorer.client.ui.demos.mx.containers;

import com.emitrom.flash4j.core.client.events.Event;
import com.emitrom.flash4j.core.client.events.MouseEvent;
import com.emitrom.flash4j.core.client.events.handlers.EventHandler;
import com.emitrom.flash4j.flex.client.mx.containers.Canvas;
import com.emitrom.flash4j.flex.client.mx.containers.HBox;
import com.emitrom.flash4j.flex.client.mx.containers.Panel;
import com.emitrom.flash4j.flex.client.mx.containers.VBox;
import com.emitrom.flash4j.flex.client.mx.containers.ViewStack;
import com.emitrom.flash4j.flex.client.mx.controls.Button;
import com.emitrom.flash4j.flex.client.mx.controls.Label;
import com.emitrom.flash4j.flex.client.mx.core.ContainerLayout;
import com.emitrom.flex4j.explorer.client.ui.demos.AbstractDemo;

public class ViewStackDemo extends AbstractDemo {

    private static final ViewStackDemo INSTANCE = new ViewStackDemo();

    public static final String FULL_PATH = "mx.containers.ViewStack";

    public static ViewStackDemo get() {
        return INSTANCE;
    }

    private ViewStackDemo() {

        Panel panel = new Panel("ViewStack Container Example");
        panel.setLayout(ContainerLayout.ABSOLUTE);
        panel.setCentered();
        panel.setPercentSize(80, 80);

        VBox box = new VBox();
        box.strech();
        box.setRelativePosition(10);

        Label label = new Label("Use the buttons to change the panels in the viewstack");
        label.setPercentWidth(100);
        label.setStyle("color", "blue");
        box.addElement(label);

        final ViewStack viewStack = new ViewStack();
        viewStack.strech();

        Canvas child = new Canvas();
        child.strech();
        child.setStyle("backgroundColor", "#1C97ED");
        viewStack.addElement(child);

        child = new Canvas();
        child.strech();
        child.setStyle("backgroundColor", "#CCFFFF");
        viewStack.addElement(child);

        child = new Canvas();
        child.strech();
        child.setStyle("backgroundColor", "#FFCCFF");
        viewStack.addElement(child);
        box.addElement(viewStack);

        HBox hBox = new HBox();
        hBox.setPercentWidth(100);

        Button button = new Button("Canvas 1");
        button.addEventHandler(MouseEvent.CLICK, new EventHandler() {
            @Override
            public void onEvent(Event event) {
                viewStack.setSelectedIndex(0);
            }
        });
        hBox.addElement(button);

        button = new Button("Canvas 2");
        button.addEventHandler(MouseEvent.CLICK, new EventHandler() {
            @Override
            public void onEvent(Event event) {
                viewStack.setSelectedIndex(1);
            }
        });
        hBox.addElement(button);

        button = new Button("Canvas 3");
        button.addEventHandler(MouseEvent.CLICK, new EventHandler() {
            @Override
            public void onEvent(Event event) {
                viewStack.setSelectedIndex(2);
            }
        });
        hBox.addElement(button);
        box.addElement(hBox);

        panel.addElement(box);
        this.addElement(panel);
    }

    @Override
    public String getDemoPath() {
        return "mx/containers/ViewStackDemo.java";
    }

    @Override
    public String getTitle() {
        return "ViewStack";
    }
}
