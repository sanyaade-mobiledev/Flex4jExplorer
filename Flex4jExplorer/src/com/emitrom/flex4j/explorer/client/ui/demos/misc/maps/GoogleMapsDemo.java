package com.emitrom.flex4j.explorer.client.ui.demos.misc.maps;

import com.emitrom.flash4j.core.client.events.Event;
import com.emitrom.flash4j.core.client.events.MouseEvent;
import com.emitrom.flash4j.core.client.events.handlers.EventHandler;
import com.emitrom.flash4j.flex.client.mx.containers.HBox;
import com.emitrom.flash4j.flex.client.mx.controls.Button;
import com.emitrom.flash4j.flex.maps.client.MapLoadHandler;
import com.emitrom.flash4j.flex.maps.client.MapWidget;
import com.emitrom.flex4j.explorer.client.ui.demos.AbstractDemo;
import com.emitrom.pilot.maps.client.GMap;
import com.emitrom.pilot.maps.client.base.LatLng;
import com.emitrom.pilot.maps.client.core.MapTypeId;
import com.emitrom.pilot.maps.client.overlays.InfoWindow;
import com.emitrom.pilot.maps.client.overlays.Marker;
import com.google.gwt.user.client.Random;
import com.google.gwt.user.client.Window;

public class GoogleMapsDemo extends AbstractDemo {

    private static final GoogleMapsDemo INSTANCE = new GoogleMapsDemo();
    public static final String FULL_PATH = "misc.maps.googlemaps";

    public static GoogleMapsDemo get() {
        return INSTANCE;
    }

    private GMap googleMap;
    private MapWidget mapWidget;

    private GoogleMapsDemo() {
        srcButton.setEnabled(false);

        this.addElement(getButtonBox());

        mapWidget = new MapWidget();
        mapWidget.asUIComponent().strech();
        mapWidget.asUIComponent().setPercentSize(90, 80);
        mapWidget.asUIComponent().setCentered();
        mapWidget.addMapLoadHandler(new MapLoadHandler() {
            @Override
            public void onMapLoad() {
                googleMap = new GMap(mapWidget.getMap());
            }
        });
        this.addElement(mapWidget);

    }

    @Override
    public String getDemoPath() {
        return "misc/maps/GoogleMapsDemo.java";
    }

    @Override
    public String getTitle() {
        return "Google Maps";
    }

    private HBox getButtonBox() {
        HBox box = new HBox();
        box.setHorizontalCenter(0);
        box.setTop(20);
        box.setPercentSize(50, 50);

        Button button = new Button("Change Map Type");
        button.addEventHandler(MouseEvent.CLICK, new EventHandler() {
            @Override
            public void onEvent(Event event) {
                googleMap.setMapType(getMapType());
            }
        });
        box.addElement(button);

        button = new Button("Add Marker");
        button.addEventHandler(MouseEvent.CLICK, new EventHandler() {
            @Override
            public void onEvent(Event event) {

                LatLng position = googleMap.getCenter();
                Marker marker = new Marker(googleMap, position);

                InfoWindow info = new InfoWindow();
                info.setContent("Flash4j and Google Maps for the win !");
                info.open(googleMap, marker);
            }
        });
        box.addElement(button);

        button = new Button("Get Current Location");
        button.addEventHandler(MouseEvent.CLICK, new EventHandler() {
            @Override
            public void onEvent(Event event) {
                Window.alert("Coming soon ...");
            }
        });
        box.addElement(button);
        box.addElement(button);

        return box;
    }

    private MapTypeId getMapType() {
        MapTypeId[] ids = { MapTypeId.HYBRID, MapTypeId.ROADMAP, MapTypeId.SATELLITE, MapTypeId.TERRAIN };
        int index = Random.nextInt(4);
        return ids[index];
    }
}