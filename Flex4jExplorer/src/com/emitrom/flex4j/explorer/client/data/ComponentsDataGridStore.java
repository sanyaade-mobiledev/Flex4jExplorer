/*******************************************************************************
 * ComponentsTreeStore.java is part of the Flex4j Explorer (for Flex4j 3.0)
 * 
 * Copyright (c) 2012 Emitrom LLC. All rights reserved.
 * 
 * http://www.emitrom.com/
 * 
 ******************************************************************************/
package com.emitrom.flex4j.explorer.client.data;

import com.emitrom.flash4j.flex.client.mx.collections.ArrayCollection;
import com.emitrom.flash4j.flex.client.mx.controls.listClasses.ListItem;

public class ComponentsDataGridStore extends ArrayCollection {

    private static final ComponentsDataGridStore INSTANCE = new ComponentsDataGridStore();

    public static ComponentsDataGridStore get() {
        return INSTANCE;
    }

    private ComponentsDataGridStore() {
        this.addItem(new ListItem("mx.bindings.BindingUtils"));
        this.addItem(new ListItem("mx.charts.ChartDashboard"));
        this.addItem(new ListItem("mx.charts.AreaChart"));
        this.addItem(new ListItem("mx.charts.BarChart"));
        this.addItem(new ListItem("mx.charts.BubbleChart"));
        this.addItem(new ListItem("mx.charts.ColumnChart"));
        this.addItem(new ListItem("mx.charts.LineChart"));
        this.addItem(new ListItem("mx.charts.PieChart"));
        this.addItem(new ListItem("mx.containers.Accordion"));
        this.addItem(new ListItem("mx.containers.Box"));
        this.addItem(new ListItem("mx.containers.Canvas"));
        this.addItem(new ListItem("mx.containers.ControlBar"));
        this.addItem(new ListItem("mx.containers.DividedBox"));
        this.addItem(new ListItem("mx.containers.Form"));
        this.addItem(new ListItem("mx.containers.TabNavigator"));
        this.addItem(new ListItem("mx.containers.ViewStack"));
        this.addItem(new ListItem("mx.controls.Alert"));
        this.addItem(new ListItem("mx.controls.Button"));
        this.addItem(new ListItem("mx.controls.ButtonBar"));
        this.addItem(new ListItem("mx.controls.ColorPicker"));
        this.addItem(new ListItem("mx.controls.DataGrid"));
        this.addItem(new ListItem("mx.controls.DateChooser"));
        this.addItem(new ListItem("mx.controls.LinkBar"));
        this.addItem(new ListItem("mx.controls.List"));
        this.addItem(new ListItem("mx.controls.Menu"));
        this.addItem(new ListItem("mx.controls.MenuBar"));
        this.addItem(new ListItem("spark.components.BorderContainer"));
        this.addItem(new ListItem("spark.components.Panel"));
        this.addItem(new ListItem("spark.components.TitleWindow"));
        this.addItem(new ListItem("spark.effects.Move"));
        this.addItem(new ListItem("spark.effects.Fade"));
        this.addItem(new ListItem("flexlib.containers.HAccordion"));
        this.addItem(new ListItem("flexlib.containers.VAccordion"));
        this.addItem(new ListItem("flexlib.containers.HCollapsiblePanel"));
        this.addItem(new ListItem("flexlib.controls.Base64Image"));
        this.addItem(new ListItem("flexlib.controls.Highlighter"));
        this.addItem(new ListItem("flexlib.controls.PromptingTextInputs"));
        this.addItem(new ListItem("flexlib.controls.ScrollableMenus"));
        this.addItem(new ListItem("flexlib.controls.VerticalMenuBar"));
        this.addItem(new ListItem("flexlib.controls.TreeGrid"));
        this.addItem(new ListItem("ux.containers.CoverflowContainer"));
        this.addItem(new ListItem("ux.containers.Rolotab"));
        this.addItem(new ListItem("ux.containers.SuperAccordion"));
        this.addItem(new ListItem("ux.containers.SuperPanel"));
        this.addItem(new ListItem("ux.controls.AdvancedAutoComplete"));
        this.addItem(new ListItem("ux.controls.Clock"));
        this.addItem(new ListItem("ux.controls.FileUpload"));
        this.addItem(new ListItem("ux.controls.Keyboard"));
        this.addItem(new ListItem("ux.controls.SuperDatagrid"));
        this.addItem(new ListItem("misc.file.FileRead"));
        this.addItem(new ListItem("misc.file.FileWrite"));
        this.addItem(new ListItem("misc.gwt.GwtRpc"));

    }

}
