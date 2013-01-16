package com.emitrom.flex4j.explorer.client.ui.demos.mx.containers;

import com.emitrom.flash4j.flex.client.mx.containers.ControlBar;
import com.emitrom.flash4j.flex.client.mx.containers.Panel;
import com.emitrom.flash4j.flex.client.mx.controls.Button;
import com.emitrom.flash4j.flex.client.mx.controls.Label;
import com.emitrom.flash4j.flex.client.mx.controls.NumericStepper;
import com.emitrom.flash4j.flex.client.mx.controls.Spacer;
import com.emitrom.flash4j.flex.client.mx.core.ContainerLayout;
import com.emitrom.flex4j.explorer.client.ui.demos.AbstractDemo;

public class ControlBarDemo extends AbstractDemo {

    private static final ControlBarDemo INSTANCE = new ControlBarDemo();

    public static final String FULL_PATH = "mx.containers.ControlBar";

    public static ControlBarDemo get() {
        return INSTANCE;
    }

    private ControlBarDemo() {

        Panel panel = new Panel("ControlBar Container Example");
        panel.setLayout(ContainerLayout.ABSOLUTE);
        panel.setCentered();
        panel.setPercentSize(80, 80);

        this.addElement(panel);

        ControlBar controlBar = new ControlBar();
        controlBar.addElement(new Label("Quantity"));
        controlBar.addElement(new NumericStepper());
        controlBar.addElement(new Spacer());
        controlBar.addElement(new Button("Add to cart", "/imgs/icons/cart.png"));
        panel.addElement(controlBar);
    }

    @Override
    public String getDemoPath() {
        return "mx/containers/ControlBarDemo.java";
    }

    @Override
    public String getTitle() {
        return "ControlBar";
    }
}
