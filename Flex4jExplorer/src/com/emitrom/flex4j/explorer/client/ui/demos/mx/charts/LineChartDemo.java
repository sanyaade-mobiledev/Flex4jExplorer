package com.emitrom.flex4j.explorer.client.ui.demos.mx.charts;

import com.emitrom.flash4j.core.client.data.BaseModel;
import com.emitrom.flash4j.flex.client.mx.charts.CategoryAxis;
import com.emitrom.flash4j.flex.client.mx.charts.Legend;
import com.emitrom.flash4j.flex.client.mx.charts.LineChart;
import com.emitrom.flash4j.flex.client.mx.charts.series.LineSeries;
import com.emitrom.flash4j.flex.client.mx.collections.ArrayCollection;
import com.emitrom.flash4j.flex.client.mx.containers.Panel;
import com.emitrom.flash4j.flex.client.mx.core.ContainerLayout;
import com.emitrom.flash4j.flex.client.mx.graphics.SolidColorStroke;
import com.emitrom.flex4j.explorer.client.ui.demos.AbstractDemo;

public class LineChartDemo extends AbstractDemo {

    public static final String FULL_PATH = "mx.charts.LineChart";

    public static LineChartDemo get() {
        return new LineChartDemo();
    }

    private LineChartDemo() {

        LineSeries profitSeries = new LineSeries();
        profitSeries.setYField("Profit");
        profitSeries.setStyle("form", "curve");
        profitSeries.setDisplayName("Profit");
        profitSeries.setStyle("lineStroke", new SolidColorStroke(0x7B6824, 2));

        LineSeries expensesSeries = new LineSeries();
        expensesSeries.setYField("Expenses");
        expensesSeries.setStyle("form", "curve");
        expensesSeries.setDisplayName("Expenses");
        expensesSeries.setStyle("lineStroke", new SolidColorStroke(0xEE7712, 2));

        LineSeries amountSeries = new LineSeries();
        amountSeries.setYField("Amount");
        amountSeries.setStyle("form", "curve");
        amountSeries.setDisplayName("Amount");
        amountSeries.setStyle("lineStroke", new SolidColorStroke(0x7B68EE, 2));

        LineChart chart = new LineChart();
        chart.setShowDataTips(true);
        chart.setSeries(profitSeries, expensesSeries, amountSeries);
        chart.strech();
        chart.setDataProvider(getChartData());
        chart.setHorizontalAxis(new CategoryAxis("month"));

        Panel panel = new Panel("LineChart Example");
        panel.setLayout(ContainerLayout.VERTICAL);
        panel.setCentered();
        panel.setPercentSize(80, 80);
        panel.addElement(chart);
        panel.addElement(new Legend(chart));

        this.addElement(panel);
    }

    @Override
    public String getDemoPath() {
        return "mx/charts/LineChartDemo.java";
    }

    @Override
    public String getTitle() {
        return "LineChart";
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
