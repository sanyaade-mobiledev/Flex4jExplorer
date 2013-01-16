/*******************************************************************************
 * DemoController.java is part of the Flex4j Explorer (for Flex4j 3.0)
 * 
 * Copyright (c) 2012 Emitrom LLC. All rights reserved.
 * 
 * http://www.emitrom.com/
 * 
 ******************************************************************************/
package com.emitrom.flex4j.explorer.client.controllers;

import com.emitrom.flex4j.explorer.client.KitchenSinkService;
import com.emitrom.flex4j.explorer.client.KitchenSinkServiceAsync;
import com.emitrom.flex4j.explorer.client.bindery.EventBusUtil;
import com.emitrom.flex4j.explorer.client.bindery.events.DemoLoadEvent;
import com.emitrom.flex4j.explorer.client.rpc.RequestHelper;
import com.emitrom.flex4j.explorer.client.ui.MainContainer;
import com.emitrom.flex4j.explorer.client.ui.demos.misc.file.FileReadDemo;
import com.emitrom.flex4j.explorer.client.ui.demos.misc.file.FileWriteDemo;
import com.emitrom.flex4j.explorer.client.ui.demos.misc.gwt.GwtRpcDemo;
import com.emitrom.flex4j.explorer.client.ui.demos.misc.maps.GoogleMapsDemo;
import com.emitrom.flex4j.explorer.client.ui.demos.mx.bindings.BindingUtilsDemo;
import com.emitrom.flex4j.explorer.client.ui.demos.mx.charts.AreaChartDemo;
import com.emitrom.flex4j.explorer.client.ui.demos.mx.charts.BarChartDemo;
import com.emitrom.flex4j.explorer.client.ui.demos.mx.charts.BubbleChartDemo;
import com.emitrom.flex4j.explorer.client.ui.demos.mx.charts.ChartDashboard;
import com.emitrom.flex4j.explorer.client.ui.demos.mx.charts.ColumnChartDemo;
import com.emitrom.flex4j.explorer.client.ui.demos.mx.charts.LineChartDemo;
import com.emitrom.flex4j.explorer.client.ui.demos.mx.charts.PieChartDemo;
import com.emitrom.flex4j.explorer.client.ui.demos.mx.containers.AccordionDemo;
import com.emitrom.flex4j.explorer.client.ui.demos.mx.containers.BoxDemo;
import com.emitrom.flex4j.explorer.client.ui.demos.mx.containers.CanvasDemo;
import com.emitrom.flex4j.explorer.client.ui.demos.mx.containers.ControlBarDemo;
import com.emitrom.flex4j.explorer.client.ui.demos.mx.containers.DividedBoxDemo;
import com.emitrom.flex4j.explorer.client.ui.demos.mx.containers.FormDemo;
import com.emitrom.flex4j.explorer.client.ui.demos.mx.containers.TabNavigatorDemo;
import com.emitrom.flex4j.explorer.client.ui.demos.mx.containers.ViewStackDemo;
import com.emitrom.flex4j.explorer.client.ui.demos.mx.controls.AlertDemo;
import com.emitrom.flex4j.explorer.client.ui.demos.mx.controls.ButtonBarDemo;
import com.emitrom.flex4j.explorer.client.ui.demos.mx.controls.ButtonDemo;
import com.emitrom.flex4j.explorer.client.ui.demos.mx.controls.ColorPickerDemo;
import com.emitrom.flex4j.explorer.client.ui.demos.mx.controls.DataGridDemo;
import com.emitrom.flex4j.explorer.client.ui.demos.mx.controls.DateChooserDemo;
import com.emitrom.flex4j.explorer.client.ui.demos.mx.controls.LinkBarDemo;
import com.emitrom.flex4j.explorer.client.ui.demos.mx.controls.ListDemo;
import com.emitrom.flex4j.explorer.client.ui.demos.mx.controls.MenuBarDemo;
import com.emitrom.flex4j.explorer.client.ui.demos.mx.controls.MenuDemo;
import com.emitrom.flex4j.explorer.client.ui.pages.ComponentsDataGrid;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;

public class DemoController implements ValueChangeHandler<String> {

    private static final DemoController INSTANCE = new DemoController();
    KitchenSinkServiceAsync service = GWT.create(KitchenSinkService.class);

    public static DemoController get() {
        return INSTANCE;
    }

    @Override
    public void onValueChange(ValueChangeEvent<String> event) {
        if (event.getValue().equalsIgnoreCase(ChartDashboard.FULL_PATH)) {
            MainContainer.get().goToChartPage();
        } else if (!event.getValue().isEmpty()) {
            EventBusUtil.get().fireEvent(new DemoLoadEvent(event.getValue()));
            ComponentsDataGrid.get().find(event.getValue(), true);
        }
    }

    public void displaySource(String component) {
        RequestHelper.loadSource(component);
    }

    public static void loadDemos() {
        BindingUtilsDemo.get();
        AreaChartDemo.get();
        BarChartDemo.get();
        BubbleChartDemo.get();
        ColumnChartDemo.get();
        LineChartDemo.get();
        PieChartDemo.get();
        AccordionDemo.get();
        BoxDemo.get();
        CanvasDemo.get();
        ControlBarDemo.get();
        DividedBoxDemo.get();
        FormDemo.get();
        TabNavigatorDemo.get();
        ViewStackDemo.get();
        AlertDemo.get();
        ButtonBarDemo.get();
        ButtonDemo.get();
        ColorPickerDemo.get();
        DataGridDemo.get();
        LinkBarDemo.get();
        DateChooserDemo.get();
        ListDemo.get();
        MenuBarDemo.get();
        MenuDemo.get();
        FileReadDemo.get();
        FileWriteDemo.get();
        GwtRpcDemo.get();
        GoogleMapsDemo.get();
    }

    private String getDemoSource(String componentName) {
        return GWT.getHostPageBaseURL() + "src/" + componentName + ".html";
    }

    private native void highlight() /*-{
		$wnd.dp.SyntaxHighlighter.HighlightAll("code");
    }-*/;

}
