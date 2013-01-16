package com.emitrom.flex4j.explorer.client.ui.demos.mx.charts;

import com.emitrom.flash4j.core.client.data.BaseModel;
import com.emitrom.flash4j.flex.client.mx.charts.AreaChart;
import com.emitrom.flash4j.flex.client.mx.charts.CategoryAxis;
import com.emitrom.flash4j.flex.client.mx.charts.Legend;
import com.emitrom.flash4j.flex.client.mx.charts.series.AreaSeries;
import com.emitrom.flash4j.flex.client.mx.collections.ArrayCollection;
import com.emitrom.flash4j.flex.client.mx.containers.Panel;
import com.emitrom.flash4j.flex.client.mx.core.ContainerLayout;
import com.emitrom.flash4j.flex.client.mx.graphics.SolidColor;
import com.emitrom.flash4j.flex.client.mx.graphics.SolidColorStroke;
import com.emitrom.flex4j.explorer.client.ui.demos.AbstractDemo;

public class AreaChartDemo extends AbstractDemo {

    public static final String FULL_PATH = "mx.charts.AreaChart";

    public static AreaChartDemo get() {
        return new AreaChartDemo();
    }

    private AreaChartDemo() {

        AreaSeries profitSeries = new AreaSeries();
        profitSeries.setYField("Profit");
        profitSeries.setStyle("form", "curve");
        profitSeries.setDisplayName("Profit");
        profitSeries.setStyle("areaStroke", new SolidColorStroke(0xEB7712, 2));
        profitSeries.setStyle("areaFill", new SolidColor(0x7B68EE, 0.3));

        AreaSeries expensesSeries = new AreaSeries();
        expensesSeries.setYField("Expenses");
        expensesSeries.setStyle("form", "curve");
        expensesSeries.setDisplayName("Expenses");
        expensesSeries.setStyle("areaStroke", new SolidColorStroke(0xEB7712, 2));
        expensesSeries.setStyle("areaFill", new SolidColor(0xEE7712, 0.3));

        AreaSeries amountSeries = new AreaSeries();
        amountSeries.setYField("Amount");
        amountSeries.setStyle("form", "curve");
        amountSeries.setDisplayName("Amount");
        amountSeries.setStyle("areaStroke", new SolidColorStroke(0xEB7712, 2));
        amountSeries.setStyle("areaFill", new SolidColor(0x7B68EE, 0.3));

        AreaChart chart = new AreaChart();
        chart.setShowDataTips(true);
        chart.setSeries(profitSeries, expensesSeries, amountSeries);
        chart.strech();
        chart.setDataProvider(getChartData());
        chart.setHorizontalAxis(new CategoryAxis("month"));

        Panel panel = new Panel("AreaChart Example");
        panel.setLayout(ContainerLayout.VERTICAL);
        panel.setCentered();
        panel.setPercentSize(80, 80);
        panel.addElement(chart);
        panel.addElement(new Legend(chart));

        this.addElement(panel);
    }

    @Override
    public String getDemoPath() {
        return "mx/charts/AreaChartDemo.java";
    }

    @Override
    public String getTitle() {
        return "AreaChart";
    }

    private ArrayCollection getChartData() {
        ArrayCollection dataProvider = new ArrayCollection();
        BaseModel model = new BaseModel();
        model.set("month", "Jan");
        model.set("Profit", "2000");
        model.set("Expenses", "1500");
        model.set("Amount", "450");
        dataProvider.addItem(model);

        model = new BaseModel();
        model.set("month", "Feb");
        model.set("Profit", "1000");
        model.set("Expenses", "200");
        model.set("Amount", "600");
        dataProvider.addItem(model);

        model = new BaseModel();
        model.set("month", "Mar");
        model.set("Profit", "1500");
        model.set("Expenses", "500");
        model.set("Amount", "300");
        dataProvider.addItem(model);

        model = new BaseModel();
        model.set("month", "Apr");
        model.set("Profit", "1800");
        model.set("Expenses", "1200");
        model.set("Amount", "900");
        dataProvider.addItem(model);

        model = new BaseModel();
        model.set("month", "May");
        model.set("Profit", "2400");
        model.set("Expenses", "575");
        model.set("Amount", "500");
        dataProvider.addItem(model);

        return dataProvider;
    }

}
