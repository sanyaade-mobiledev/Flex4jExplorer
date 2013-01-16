package com.emitrom.flex4j.explorer.client.ui.demos.mx.containers;

import com.emitrom.flash4j.core.client.events.Event;
import com.emitrom.flash4j.core.client.events.MouseEvent;
import com.emitrom.flash4j.core.client.events.handlers.EventHandler;
import com.emitrom.flash4j.flex.client.mx.containers.Canvas;
import com.emitrom.flash4j.flex.client.mx.containers.Panel;
import com.emitrom.flash4j.flex.client.mx.containers.TabNavigator;
import com.emitrom.flash4j.flex.client.mx.containers.VBox;
import com.emitrom.flash4j.flex.client.mx.controls.Button;
import com.emitrom.flash4j.flex.client.mx.controls.DateChooser;
import com.emitrom.flash4j.flex.client.mx.controls.Label;
import com.emitrom.flash4j.flex.client.mx.core.ContainerLayout;
import com.emitrom.flex4j.explorer.client.ui.demos.AbstractDemo;

public class TabNavigatorDemo extends AbstractDemo {

    private static final TabNavigatorDemo INSTANCE = new TabNavigatorDemo();

    public static final String FULL_PATH = "mx.containers.TabNavigator";

    public static TabNavigatorDemo get() {
        return INSTANCE;
    }

    private TabNavigatorDemo() {

        Panel panel = new Panel("TabNavigator Container Example");
        panel.setLayout(ContainerLayout.ABSOLUTE);
        panel.setCentered();
        panel.setPercentSize(80, 80);

        VBox box = new VBox();
        box.strech();
        box.setRelativePosition(10);

        Label label = new Label("Select the tabs to change the panel");
        label.setPercentWidth(100);
        label.setStyle("color", "blue");
        box.addElement(label);

        final TabNavigator tabNavigator = new TabNavigator();
        tabNavigator.strech();

        // TabItem 1
        Canvas child = new Canvas();
        child.strech();
        child.setLabel("Panel 1");

        DateChooser dateChooser = new DateChooser();
        dateChooser.setCentered();

        child.addElement(dateChooser);
        tabNavigator.addElement(child);

        // TabItem 2
        child = new Canvas();
        child.strech();
        child.setLabel("Panel 2");
        child.addElement(new Label("Panel content 2"));
        tabNavigator.addElement(child);

        // TabItem 3
        child = new Canvas();
        child.strech();
        child.setLabel("Panel 2");
        child.addElement(new Label("Panel content 3"));
        tabNavigator.addElement(child);
        box.addElement(tabNavigator);

        label = new Label("Programmatically select the panel using a button control");
        label.setPercentWidth(100);
        label.setStyle("color", "blue");
        box.addElement(label);

        Button button = new Button("Select panel 3");
        button.addEventHandler(MouseEvent.CLICK, new EventHandler() {
            @Override
            public void onEvent(Event event) {
                tabNavigator.setSelectedIndex(2);
            }
        });
        box.addElement(button);

        panel.addElement(box);
        this.addElement(panel);
    }

    @Override
    public String getDemoPath() {
        return "mx/containers/TabNavigatorDemo.java";
    }

    @Override
    public String getTitle() {
        return "TabNavigator";
    }
}
