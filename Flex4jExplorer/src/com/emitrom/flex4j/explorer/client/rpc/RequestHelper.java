package com.emitrom.flex4j.explorer.client.rpc;

import com.emitrom.flash4j.core.client.events.Event;
import com.emitrom.flash4j.core.client.events.MouseEvent;
import com.emitrom.flash4j.core.client.events.handlers.EventHandler;
import com.emitrom.flash4j.flex.client.mx.containers.ControlBar;
import com.emitrom.flash4j.flex.client.mx.controls.Alert;
import com.emitrom.flash4j.flex.client.mx.controls.Button;
import com.emitrom.flash4j.flex.client.mx.controls.Spacer;
import com.emitrom.flash4j.flex.client.mx.managers.CursorManager;
import com.emitrom.flash4j.flex.client.mx.managers.PopUpManager;
import com.emitrom.flash4j.flex.client.spark.components.Application;
import com.emitrom.flash4j.flex.ux.client.mx.iframe.IFrame;
import com.emitrom.flash4j.tween.client.TweenLite;
import com.emitrom.flash4j.tween.client.TweenMax;
import com.emitrom.flash4j.tween.client.config.TweenConfig;
import com.emitrom.flash4j.tween.client.config.TweenMaxConfig;
import com.emitrom.flash4j.tween.client.events.TweenEvent;
import com.emitrom.flex4j.explorer.client.KitchenSinkService;
import com.emitrom.flex4j.explorer.client.KitchenSinkServiceAsync;
import com.emitrom.flex4j.explorer.client.ui.demos.SourceCodePanel;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * Utility class for RPC calls
 * 
 */
public class RequestHelper {

    private final static String GITHUB_PATH = "http://svn.emitrom.com/depot/flash4jdemos/trunk/Flex4jExplorer/src/com/emitrom/flex4j/explorer/client/ui/demos/";
    private static KitchenSinkServiceAsync service = GWT.create(KitchenSinkService.class);

    private RequestHelper() {
    }

    public static void loadSource(String component) {
        CursorManager.setBusyCursor();
        service.getSource(component, new AsyncCallback<String>() {
            @Override
            public void onSuccess(String result) {
                processResponse(result);
            }

            @Override
            public void onFailure(Throwable caught) {
                Alert.show("Could not load source code", "Error");
            }
        });
    }

    private static void processResponse(String response) {

        String html = "<textarea name=\"code\" class=\"java:nocontrols\" rows=\"15\" cols=\"100\">";
        html += response;
        html += "</textarea>";

        final SourceCodePanel p = SourceCodePanel.get();

        final IFrame iFrame = new IFrame();
        p.addElement(iFrame);
        iFrame.setContent(html);

        PopUpManager.addPopUp(p, Application.get(), true);
        TweenLite.to(p, 1, TweenConfig.create().setHeight(600));

        ControlBar controlBar = new ControlBar();
        controlBar.addElement(new Spacer());
        Button closeButton = new Button("Close");
        closeButton.setIcon("/imgs/icons/quit.png");
        closeButton.setHeight(25);
        closeButton.addEventHandler(MouseEvent.CLICK, new EventHandler() {
            @Override
            public void onEvent(Event event) {
                TweenMax.to(p, 1, TweenMaxConfig.create().setHeight(100)).addEventHandler(TweenEvent.COMPLTE,
                                new EventHandler() {
                                    @Override
                                    public void onEvent(Event event) {
                                        PopUpManager.removePopUp(p);
                                        iFrame.removeIFrame();
                                    }
                                });

            }
        });
        controlBar.addElement(closeButton);
        p.addElement(controlBar);

        prettyPrint();
        CursorManager.removeBusyCursor();
    }

    private static native void prettyPrint() /*-{
		$wnd.dp.SyntaxHighlighter.HighlightAll("code");
    }-*/;
}
