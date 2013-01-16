package com.emitrom.flex4j.explorer.client.ui.demos.mx.charts;

import com.emitrom.flash4j.core.client.data.BaseModel;
import com.emitrom.flash4j.flex.client.mx.charts.Legend;
import com.emitrom.flash4j.flex.client.mx.charts.PieChart;
import com.emitrom.flash4j.flex.client.mx.charts.series.PieSeries;
import com.emitrom.flash4j.flex.client.mx.collections.ArrayCollection;
import com.emitrom.flash4j.flex.client.mx.containers.Panel;
import com.emitrom.flash4j.flex.client.mx.core.ContainerLayout;
import com.emitrom.flash4j.flex.client.mx.graphics.SolidColor;
import com.emitrom.flash4j.flex.client.mx.graphics.SolidColorStroke;
import com.emitrom.flex4j.explorer.client.ui.demos.AbstractDemo;

public class PieChartDemo extends AbstractDemo {

    public static final String FULL_PATH = "mx.charts.PieChart";

    public static PieChartDemo get() {
        return new PieChartDemo();
    }

    private PieChartDemo() {

        ArrayCollection colors = new ArrayCollection();
        colors.addItem(new SolidColor(0xFFFF00, 0.8)).addItem(new SolidColor(0x0000CD, 0.6))
                        .addItem(new SolidColor(0x006400, 0.3));

        PieSeries goldSeries = new PieSeries();
        goldSeries.setNameField("Country");
        goldSeries.setField("Gold");
        goldSeries.setStyle("labelPosition", "callout");
        goldSeries.setStyle("fill", new SolidColor(0xFFFF00, 0.8));
        goldSeries.setStyle("calloutStroke", new SolidColorStroke(0xFFFF00, 2));
        goldSeries.setStyle("radialStroke", new SolidColorStroke(0xCCCCCC, 2));
        goldSeries.setStyle("stroke", new SolidColorStroke(0xFFCC66, 2));
        goldSeries.setStyle("fills", colors.toArray());

        PieChart chart = new PieChart();
        chart.strech();
        chart.setShowDataTips(true);
        chart.setDataProvider(getChartData());
        chart.setSeries(goldSeries);

        Panel panel = new Panel("PieChart Example");
        panel.setLayout(ContainerLayout.HORIZONTAL);
        panel.setCentered();
        panel.setPercentSize(80, 80);
        panel.addElement(chart);
        panel.addElement(new Legend(chart));

        this.addElement(panel);
    }

    @Override
    public String getDemoPath() {
        return "mx/charts/PieChartDemo.java";
    }

    @Override
    public String getTitle() {
        return "PieChart";
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
