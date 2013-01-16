package com.emitrom.flex4j.explorer.client.ui.demos.misc.maps;

import com.emitrom.flash4j.core.client.events.Event;
import com.emitrom.flash4j.core.client.events.MouseEvent;
import com.emitrom.flash4j.core.client.events.handlers.EventHandler;
import com.emitrom.flash4j.flex.client.mx.containers.ControlBar;
import com.emitrom.flash4j.flex.client.mx.containers.Panel;
import com.emitrom.flash4j.flex.client.mx.controls.Button;
import com.emitrom.flash4j.flex.client.mx.controls.Spacer;
import com.emitrom.flash4j.flex.client.mx.core.ContainerLayout;
import com.emitrom.flash4j.flex.maps.client.MapLoadHandler;
import com.emitrom.flash4j.flex.maps.client.MapWidget;
import com.emitrom.flex4j.explorer.client.ui.demos.AbstractDemo;
import com.emitrom.pilot.maps.client.GMap;
import com.emitrom.pilot.maps.client.base.LatLng;
import com.emitrom.pilot.maps.client.core.MapTypeId;
import com.emitrom.pilot.maps.client.overlays.InfoWindow;
import com.emitrom.pilot.maps.client.overlays.Marker;

public class GoogleMapsDemo extends AbstractDemo {

    private static final GoogleMapsDemo INSTANCE = new GoogleMapsDemo();
    public static final String FULL_PATH = "misc.maps.googlemaps";

    public static GoogleMapsDemo get() {
        return INSTANCE;
    }

    private Button button = new Button("Change Map");
    private GMap googleMap;

    private GoogleMapsDemo() {
        final Panel panel = new Panel("GoogleMaps example");
        panel.setLayout(ContainerLayout.ABSOLUTE);
        panel.setCentered();
        panel.setPercentSize(80, 80);

        final MapWidget w = new MapWidget();
        w.addMapLoadHandler(new MapLoadHandler() {
            @Override
            public void onMapLoad() {

                // create the Google map from the map widget
                googleMap = new GMap(w.getMap());

                LatLng position = googleMap.getCenter();
                Marker marker = new Marker(googleMap, position);

                InfoWindow info = new InfoWindow();
                info.setContent("Flash4j 3.1 and Google Maps");
                info.open(googleMap, marker);

            }
        });
        panel.addElement(w);
        this.addElement(panel);

        ControlBar controlBar = new ControlBar();
        controlBar.addElement(new Spacer());

        button.addEventHandler(MouseEvent.CLICK, new EventHandler() {
            @Override
            public void onEvent(Event event) {
                googleMap.setZoom(7);
                googleMap.setMapType(MapTypeId.HYBRID);
                button.setEnabled(false);
            }
        });
        controlBar.addElement(button);
        panel.addElement(controlBar);

    }

    @Override
    public String getDemoPath() {
        return "misc/maps/GoogleMapsDemo.java";
    }

    @Override
    public String getTitle() {
        return "Google Maps";
    }
}