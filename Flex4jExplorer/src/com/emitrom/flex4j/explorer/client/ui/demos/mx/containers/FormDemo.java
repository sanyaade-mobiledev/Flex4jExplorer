package com.emitrom.flex4j.explorer.client.ui.demos.mx.containers;

import com.emitrom.flash4j.core.client.events.Event;
import com.emitrom.flash4j.core.client.events.MouseEvent;
import com.emitrom.flash4j.core.client.events.handlers.EventHandler;
import com.emitrom.flash4j.flex.client.mx.containers.Form;
import com.emitrom.flash4j.flex.client.mx.containers.FormItem;
import com.emitrom.flash4j.flex.client.mx.containers.Panel;
import com.emitrom.flash4j.flex.client.mx.controls.Alert;
import com.emitrom.flash4j.flex.client.mx.controls.Button;
import com.emitrom.flash4j.flex.client.mx.controls.TextInput;
import com.emitrom.flash4j.flex.client.mx.core.ContainerLayout;
import com.emitrom.flash4j.flex.client.mx.events.ValidationResultEvent;
import com.emitrom.flash4j.flex.client.mx.validators.EmailValidator;
import com.emitrom.flex4j.explorer.client.ui.demos.AbstractDemo;

public class FormDemo extends AbstractDemo {

    private static final FormDemo INSTANCE = new FormDemo();

    public static final String FULL_PATH = "mx.containers.Form";

    public static FormDemo get() {
        return INSTANCE;
    }

    private FormDemo() {

        Panel panel = new Panel("Form Container Example");
        panel.setLayout(ContainerLayout.ABSOLUTE);
        panel.setCentered();
        panel.setPercentSize(80, 80);

        Form form = new Form();
        form.setCentered();

        TextInput email = new TextInput();
        email.setPercentWidth(100);

        FormItem formItem = new FormItem("Enter an Email address");
        formItem.setRequired(true);
        formItem.addElement(email);
        form.addElement(formItem);

        Button validateButton = new Button("Validate Email");
        validateButton.setPercentWidth(100);

        formItem = new FormItem();
        formItem.addElement(validateButton);
        form.addElement(formItem);

        panel.addElement(form);
        this.addElement(panel);

        EmailValidator emailValidator = new EmailValidator();
        emailValidator.setSource(email);
        emailValidator.setMissingAtSignError("The adress is missing an @ sign");
        emailValidator.setProperty("text");
        emailValidator.setTrigger(validateButton);
        emailValidator.setTriggerEvent(MouseEvent.CLICK);
        emailValidator.addEventHandler(ValidationResultEvent.VALID, new EventHandler() {
            @Override
            public void onEvent(Event event) {
                Alert.show("Validaton OK", "Message");
            }
        });

    }

    @Override
    public String getDemoPath() {
        return "mx/containers/FormDemo.java";
    }

    @Override
    public String getTitle() {
        return "Form";
    }
}
