package com.emitrom.flex4j.explorer.client.ui.demos.misc.gwt;

import com.emitrom.flash4j.core.client.events.Event;
import com.emitrom.flash4j.core.client.events.MouseEvent;
import com.emitrom.flash4j.core.client.events.handlers.EventHandler;
import com.emitrom.flash4j.flex.client.mx.containers.ControlBar;
import com.emitrom.flash4j.flex.client.mx.containers.Form;
import com.emitrom.flash4j.flex.client.mx.containers.FormItem;
import com.emitrom.flash4j.flex.client.mx.containers.Panel;
import com.emitrom.flash4j.flex.client.mx.controls.Alert;
import com.emitrom.flash4j.flex.client.mx.controls.Button;
import com.emitrom.flash4j.flex.client.mx.controls.Spacer;
import com.emitrom.flash4j.flex.client.mx.core.ContainerLayout;
import com.emitrom.flash4j.flex.client.mx.events.ValidationResultEvent;
import com.emitrom.flash4j.flex.client.mx.validators.StringValidator;
import com.emitrom.flash4j.flex.flexlib.client.controls.PromptingTextInput;
import com.emitrom.flex4j.explorer.client.GreetingService;
import com.emitrom.flex4j.explorer.client.GreetingServiceAsync;
import com.emitrom.flex4j.explorer.client.ui.demos.AbstractDemo;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class GwtRpcDemo extends AbstractDemo {

    private static final GwtRpcDemo INSTANCE = new GwtRpcDemo();
    public static final String FULL_PATH = "misc.gwt.rpc";

    /**
     * The message displayed to the user when the server cannot be reached or
     * returns an error.
     */
    private final String SERVER_ERROR = "An error occurred while "
                    + "attempting to contact the server. Please check your network " + "connection and try again.";

    /**
     * Create a remote service proxy to talk to the server-side Greeting
     * service.
     */
    private final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

    public static GwtRpcDemo get() {
        return INSTANCE;
    }

    private Button button;
    private PromptingTextInput textInput;

    private GwtRpcDemo() {
        final Panel panel = new Panel("GWT RPC example");
        panel.setLayout(ContainerLayout.ABSOLUTE);
        panel.setCentered();
        panel.setPercentSize(80, 50);

        Form form = new Form();
        form.setCentered();
        panel.addElement(form);

        FormItem item = new FormItem();
        item.setLabel("Enter your name :");
        item.setRequired(true);
        form.addElement(item);

        textInput = new PromptingTextInput("Your name here ...");
        textInput.setWidth(200);
        item.addElement(textInput);

        button = new Button("Send To Server", "");

        StringValidator validator = new StringValidator();
        validator.setSource(textInput);
        validator.setProperty("text");
        validator.setTrigger(button);
        validator.setTriggerEvent(MouseEvent.CLICK);
        validator.addEventHandler(ValidationResultEvent.VALID, new EventHandler() {
            @Override
            public void onEvent(Event event) {
                sendNameToServer();
            }
        });
        validator.addEventHandler(ValidationResultEvent.INVALID, new EventHandler() {
            @Override
            public void onEvent(Event event) {
                Alert.show("Please enter the name");
            }
        });

        this.addElement(panel);

        ControlBar controlBar = new ControlBar();
        controlBar.addElement(new Spacer());

        controlBar.addElement(button);
        panel.addElement(controlBar);

    }

    @Override
    public String getDemoPath() {
        return "misc/gwt/GwtRpcDemo.java";
    }

    @Override
    public String getTitle() {
        return "GWT RPC";
    }

    private void sendNameToServer() {
        greetingService.greetServer(textInput.getText(), new AsyncCallback<String>() {
            @Override
            public void onSuccess(String result) {
                result = result.replace("<br>", "\n");
                Alert.show(result, "Response");
            }

            @Override
            public void onFailure(Throwable caught) {
                Alert.show(SERVER_ERROR);
            }
        });
    }
}