package com.emitrom.flex4j.explorer.client.ui.demos.mx.containers;

import com.emitrom.flash4j.flex.client.mx.containers.Canvas;
import com.emitrom.flash4j.flex.client.mx.containers.Panel;
import com.emitrom.flash4j.flex.client.mx.containers.VBox;
import com.emitrom.flash4j.flex.client.mx.controls.Label;
import com.emitrom.flash4j.flex.client.mx.controls.TextInput;
import com.emitrom.flash4j.flex.client.mx.core.ContainerLayout;
import com.emitrom.flex4j.explorer.client.ui.demos.AbstractDemo;

public class CanvasDemo extends AbstractDemo {

    private static final CanvasDemo INSTANCE = new CanvasDemo();

    public static final String FULL_PATH = "mx.containers.Canvas";

    public static CanvasDemo get() {
        return INSTANCE;
    }

    private CanvasDemo() {

        Panel panel = new Panel("Canvas Container Example");
        panel.setLayout(ContainerLayout.ABSOLUTE);
        panel.setCentered();
        panel.setPercentSize(80, 80);

        VBox container = new VBox();
        container.strech();
        container.setRelativePosition(10);
        container.addElement(new Label("Use absolute positioning to place the children of a Canvas container."));

        Canvas canvas = new Canvas();
        canvas.setStyle("borderStyle", "solid");
        canvas.strech();

        TextInput textInput = new TextInput();
        textInput.setWidth(100);
        textInput.setXY(50, 5);
        canvas.addElement(textInput);

        textInput = new TextInput();
        textInput.setWidth(100);
        textInput.setXY(100, 30);
        canvas.addElement(textInput);

        textInput = new TextInput();
        textInput.setWidth(100);
        textInput.setXY(150, 55);
        canvas.addElement(textInput);

        // Overlap the VBOX containers using layout constraints
        VBox box = new VBox();
        box.setRight(115);
        box.setBottom(50);
        box.setSize(75);
        box.setStyle("backgroundColor", "#0080C0");
        canvas.addElement(box);

        box = new VBox();
        box.setRight(75);
        box.setBottom(30);
        box.setSize(75);
        box.setStyle("backgroundColor", "#FFFF80");
        canvas.addElement(box);

        box = new VBox();
        box.setRight(25);
        box.setBottom(10);
        box.setSize(75);
        box.setStyle("backgroundColor", "#8080C0");
        canvas.addElement(box);

        Label label = new Label("The Canvas lets you place components on top of each other.");
        label.setRight(25);
        label.setBottom(60);
        canvas.addElement(label);

        container.addElement(canvas);
        panel.addElement(container);
        this.addElement(panel);
    }

    @Override
    public String getDemoPath() {
        return "mx/containers/CanvasDemo.java";
    }

    @Override
    public String getTitle() {
        return "Canvas";
    }
}
