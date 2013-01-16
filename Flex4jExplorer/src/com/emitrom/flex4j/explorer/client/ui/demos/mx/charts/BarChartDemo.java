package com.emitrom.flex4j.explorer.client.ui.demos.mx.charts;

import com.emitrom.flash4j.core.client.data.BaseModel;
import com.emitrom.flash4j.flex.client.mx.charts.BarChart;
import com.emitrom.flash4j.flex.client.mx.charts.CategoryAxis;
import com.emitrom.flash4j.flex.client.mx.charts.Legend;
import com.emitrom.flash4j.flex.client.mx.charts.series.BarSeries;
import com.emitrom.flash4j.flex.client.mx.collections.ArrayCollection;
import com.emitrom.flash4j.flex.client.mx.containers.Panel;
import com.emitrom.flash4j.flex.client.mx.core.ContainerLayout;
import com.emitrom.flash4j.flex.client.mx.graphics.SolidColor;
import com.emitrom.flash4j.flex.client.mx.graphics.SolidColorStroke;
import com.emitrom.flex4j.explorer.client.ui.demos.AbstractDemo;

public class BarChartDemo extends AbstractDemo {

    public static final String FULL_PATH = "mx.charts.BarChart";

    public static BarChartDemo get() {
        return new BarChartDemo();
    }

    private BarChartDemo() {

        BarSeries goldSeries = new BarSeries();
        goldSeries.setYField("Country");
        goldSeries.setXField("Gold");
        goldSeries.setDisplayName("Gold");
        goldSeries.setStyle("fill", new SolidColor(0xFFFF00, 0.8));
        goldSeries.setStyle("stroke", new SolidColorStroke(0xFFFF00, 2));

        BarSeries silverSeries = new BarSeries();
        silverSeries.setYField("Country");
        silverSeries.setXField("Silver");
        silverSeries.setDisplayName("Silver");
        silverSeries.setStyle("fill", new SolidColor(0xCCCCCC, 0.6));
        silverSeries.setStyle("stroke", new SolidColorStroke(0xCCCCCC, 2));

        BarSeries bronzeSeries = new BarSeries();
        bronzeSeries.setYField("Country");
        bronzeSeries.setXField("Bronze");
        bronzeSeries.setDisplayName("Bronze");
        bronzeSeries.setStyle("fill", new SolidColor(0xFFCC66, 0.8));
        bronzeSeries.setStyle("stroke", new SolidColorStroke(0xFFCC66, 2));

        BarChart chart = new BarChart();
        chart.strech();
        chart.setShowDataTips(true);
        chart.setDataProvider(getChartData());
        chart.setSeries(goldSeries, silverSeries, bronzeSeries);
        chart.setVerticalAxis(new CategoryAxis("Country"));

        Panel panel = new Panel("BarChart Example");
        panel.setLayout(ContainerLayout.VERTICAL);
        panel.setCentered();
        panel.setPercentSize(80, 80);
        panel.addElement(chart);
        panel.addElement(new Legend(chart));

        this.addElement(panel);
    }

    @Override
    public String getDemoPath() {
        return "mx/charts/BarChartDemo.java";
    }

    @Override
    public String getTitle() {
        return "BarChart";
    }

    private ArrayCollection getChartData() {
        ArrayCollection dataProvider = new ArrayCollection();
        BaseModel model = new BaseModel();
        model.set("Country", "USA");
        model.set("Gold", "35");
        model.set("Silver", "39");
        model.set("Bronze", "29");
        dataProvider.addItem(model);

        model.set("Country", "China");
        model.set("Gold", "32");
        model.set("Silver", "17");
        model.set("Bronze", "14");
        dataProvider.addItem(model);

        model.set("Country", "Russia");
        model.set("Gold", "27");
        model.set("Silver", "27");
        model.set("Bronze", "38");
        dataProvider.addItem(model);
        return dataProvider;
    }

}
