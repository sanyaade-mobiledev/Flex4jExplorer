package com.emitrom.flex4j.explorer.client.ui.demos.mx.charts;

import com.emitrom.flash4j.flex.client.mx.charts.AreaChart;
import com.emitrom.flash4j.flex.client.mx.charts.BarChart;
import com.emitrom.flash4j.flex.client.mx.charts.BubbleChart;
import com.emitrom.flash4j.flex.client.mx.charts.CategoryAxis;
import com.emitrom.flash4j.flex.client.mx.charts.ColumnChart;
import com.emitrom.flash4j.flex.client.mx.charts.LineChart;
import com.emitrom.flash4j.flex.client.mx.charts.PieChart;
import com.emitrom.flash4j.flex.client.mx.charts.series.AreaSeries;
import com.emitrom.flash4j.flex.client.mx.charts.series.BarSeries;
import com.emitrom.flash4j.flex.client.mx.charts.series.BubbleSeries;
import com.emitrom.flash4j.flex.client.mx.charts.series.ColumnSeries;
import com.emitrom.flash4j.flex.client.mx.charts.series.LineSeries;
import com.emitrom.flash4j.flex.client.mx.charts.series.PieSeries;
import com.emitrom.flash4j.flex.client.mx.collections.ArrayCollection;
import com.emitrom.flash4j.flex.client.mx.containers.Canvas;
import com.emitrom.flash4j.flex.client.mx.graphics.SolidColor;
import com.emitrom.flash4j.flex.client.mx.graphics.SolidColorStroke;
import com.emitrom.flex4j.explorer.client.data.apache.mx.charts.ChartsDataUtil;

public class ChartDemoBuilder {

    private ChartDemoBuilder() {

    }

    public static Canvas getAreaChart() {

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
        chart.setDataProvider(ChartsDataUtil.getData());
        chart.setHorizontalAxis(new CategoryAxis("month"));

        Canvas canvas = new Canvas();
        canvas.strech();
        canvas.addElement(chart);

        return canvas;
    }

    public static Canvas getLineChart() {
        LineSeries profitSeries = new LineSeries();
        profitSeries.setYField("Profit");
        profitSeries.setStyle("form", "curve");
        profitSeries.setDisplayName("Profit");
        profitSeries.setStyle("lineStroke", new SolidColorStroke(0xEB7712, 2));

        LineSeries expensesSeries = new LineSeries();
        expensesSeries.setYField("Expenses");
        expensesSeries.setStyle("form", "curve");
        expensesSeries.setDisplayName("Expenses");
        expensesSeries.setStyle("lineStroke", new SolidColorStroke(0xEB7712, 2));

        LineSeries amountSeries = new LineSeries();
        amountSeries.setYField("Amount");
        amountSeries.setStyle("form", "curve");
        amountSeries.setDisplayName("Amount");
        amountSeries.setStyle("lineStroke", new SolidColorStroke(0xEB7712, 2));

        LineChart chart = new LineChart();
        chart.setShowDataTips(true);
        chart.setSeries(profitSeries, expensesSeries, amountSeries);
        chart.strech();
        chart.setHorizontalAxis(new CategoryAxis("month"));
        chart.setDataProvider(ChartsDataUtil.getData());

        Canvas canvas = new Canvas();
        canvas.strech();
        canvas.addElement(chart);

        return canvas;
    }

    public static Canvas getBarChart() {

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
        chart.setDataProvider(ChartsDataUtil.getBarChartData());
        chart.setSeries(goldSeries, silverSeries, bronzeSeries);
        chart.setVerticalAxis(new CategoryAxis("Country"));

        Canvas canvas = new Canvas();
        canvas.strech();
        canvas.addElement(chart);

        return canvas;
    }

    public static Canvas getColumnChart() {

        ColumnSeries goldSeries = new ColumnSeries();
        goldSeries.setXField("Country");
        goldSeries.setYField("Gold");
        goldSeries.setDisplayName("Gold");
        goldSeries.setStyle("fill", new SolidColor(0xFFFF00, 0.8));
        goldSeries.setStyle("stroke", new SolidColorStroke(0xFFFF00, 2));

        ColumnSeries silverSeries = new ColumnSeries();
        silverSeries.setXField("Country");
        silverSeries.setYField("Silver");
        silverSeries.setDisplayName("Silver");
        silverSeries.setStyle("fill", new SolidColor(0xCCCCCC, 0.6));
        silverSeries.setStyle("stroke", new SolidColorStroke(0xCCCCCC, 2));

        ColumnSeries bronzeSeries = new ColumnSeries();
        bronzeSeries.setYField("Country");
        bronzeSeries.setYField("Bronze");
        bronzeSeries.setDisplayName("Bronze");
        bronzeSeries.setStyle("fill", new SolidColor(0xFFCC66, 0.8));
        bronzeSeries.setStyle("stroke", new SolidColorStroke(0xFFCC66, 2));

        ColumnChart chart = new ColumnChart();
        chart.strech();
        chart.setShowDataTips(true);
        chart.setDataProvider(ChartsDataUtil.getBarChartData());
        chart.setSeries(goldSeries, silverSeries, bronzeSeries);
        chart.setHorizontalAxis(new CategoryAxis("Country"));

        Canvas canvas = new Canvas();
        canvas.strech();
        canvas.addElement(chart);

        return canvas;
    }

    public static Canvas getPieChart() {
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
        chart.setDataProvider(ChartsDataUtil.getBarChartData());
        chart.setSeries(goldSeries);

        Canvas canvas = new Canvas();
        canvas.strech();
        canvas.addElement(chart);

        return canvas;
    }

    public static Canvas getBubbleChart() {
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
        chart.setDataProvider(ChartsDataUtil.getData());

        Canvas canvas = new Canvas();
        canvas.strech();
        canvas.addElement(chart);

        return canvas;
    }
}
