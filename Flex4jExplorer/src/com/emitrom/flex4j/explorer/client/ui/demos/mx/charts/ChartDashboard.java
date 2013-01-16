package com.emitrom.flex4j.explorer.client.ui.demos.mx.charts;

import com.emitrom.flash4j.core.client.events.Event;
import com.emitrom.flash4j.core.client.events.MouseEvent;
import com.emitrom.flash4j.core.client.events.handlers.EventHandler;
import com.emitrom.flash4j.flex.client.mx.containers.Canvas;
import com.emitrom.flash4j.flex.client.mx.controls.Button;
import com.emitrom.flash4j.flex.client.mx.controls.Image;
import com.emitrom.flash4j.flex.ux.client.mx.containers.DashBoard;
import com.emitrom.flash4j.flex.ux.client.mx.containers.DashBoardItem;
import com.emitrom.flex4j.explorer.client.ui.MainContainer;

public class ChartDashboard extends Canvas {

    private static final ChartDashboard INSTANCE = new ChartDashboard();
    public static final String FULL_PATH = "mx.charts.ChartDashboard";

    public static ChartDashboard get() {
        return INSTANCE;
    }

    private ChartDashboard() {
        this.strech();
        this.setStyle("backgroundColor", "#000000");

        Image image = new Image("/imgs/icons/bg.jpeg");
        image.strech();
        this.addElement(image);

        DashBoard dashBoard = new DashBoard();
        dashBoard.strech();

        DashBoardItem item = new DashBoardItem("Area Chart");
        item.addElement(ChartDemoBuilder.getAreaChart());
        dashBoard.addDashboardItem(item);

        item = new DashBoardItem("Bar Chart");
        item.addElement(ChartDemoBuilder.getBarChart());
        dashBoard.addDashboardItem(item);

        item = new DashBoardItem("Bubble Chart");
        item.addElement(ChartDemoBuilder.getBubbleChart());
        dashBoard.addDashboardItem(item);

        item = new DashBoardItem("Column Chart");
        item.addElement(ChartDemoBuilder.getColumnChart());
        dashBoard.addDashboardItem(item);

        item = new DashBoardItem("Line Chart");
        item.addElement(ChartDemoBuilder.getLineChart());
        dashBoard.addDashboardItem(item);

        item = new DashBoardItem("Pie Chart");
        item.addElement(ChartDemoBuilder.getPieChart());
        dashBoard.addDashboardItem(item);

        this.addElement(dashBoard);

        Button button = new Button("Close");
        button.setIcon("/imgs/icons/quit.png");
        button.setHeight(25);
        button.setBottom(5);
        button.setRight(10);
        button.addEventHandler(MouseEvent.CLICK, new EventHandler() {
            @Override
            public void onEvent(Event event) {
                MainContainer.get().gotoDemoPage();
            }
        });
        this.addElement(button);

    }
}
