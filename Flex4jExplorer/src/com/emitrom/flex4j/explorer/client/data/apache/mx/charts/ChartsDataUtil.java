package com.emitrom.flex4j.explorer.client.data.apache.mx.charts;

import com.emitrom.flash4j.core.client.data.BaseModel;
import com.emitrom.flash4j.flex.client.mx.collections.ArrayCollection;

public class ChartsDataUtil {

    private ChartsDataUtil() {

    }

    public static ArrayCollection getData() {
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

    public static ArrayCollection getBarChartData() {
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
