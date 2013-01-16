package com.emitrom.flex4j.explorer.client.ui.demos.mx.charts;

import com.emitrom.flash4j.core.client.data.BaseModel;
import com.emitrom.flash4j.flex.client.mx.charts.BubbleChart;
import com.emitrom.flash4j.flex.client.mx.charts.CategoryAxis;
import com.emitrom.flash4j.flex.client.mx.charts.Legend;
import com.emitrom.flash4j.flex.client.mx.charts.series.BubbleSeries;
import com.emitrom.flash4j.flex.client.mx.collections.ArrayCollection;
import com.emitrom.flash4j.flex.client.mx.containers.Panel;
import com.emitrom.flash4j.flex.client.mx.core.ContainerLayout;
import com.emitrom.flash4j.flex.client.mx.graphics.SolidColor;
import com.emitrom.flash4j.flex.client.mx.graphics.SolidColorStroke;
import com.emitrom.flex4j.explorer.client.ui.demos.AbstractDemo;

public class BubbleChartDemo extends AbstractDemo {

    public static final String FULL_PATH = "mx.charts.BubbleChart";

    public static BubbleChartDemo get() {
        return new BubbleChartDemo();
    }

    private BubbleChartDemo() {

        BubbleSeries bubbleSeries = new BubbleSeries();
        bubbleSeries.setYField("Profit");
        bubbleSeries.setYField("Expenses");
        bubbleSeries.setRadiusField("Amount");
        bubbleSeries.setDisplayName("Profit/Expenses/Amount");
        bubbleSeries.setStyle("stroke", new SolidColorStroke(0xFFFF00, 2));
        bubbleSeries.setStyle("fill", new SolidColor(0xFFFF00, 0.8));

        BubbleChart chart = new BubbleChart();
        chart.setShowDataTips(true);
        chart.setSeries(bubbleSeries);
        chart.strech();
        chart.setDataProvider(getChartData());
        chart.setHorizontalAxis(new CategoryAxis("month"));

        Panel panel = new Panel("BubblueChart Example");
        panel.setLayout(ContainerLayout.VERTICAL);
        panel.setCentered();
        panel.setPercentSize(80, 80);
        panel.addElement(chart);
        panel.addElement(new Legend(chart));

        this.addElement(panel);
    }

    @Override
    public String getDemoPath() {
        return "mx/charts/BubbleChartDemo.java";
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
