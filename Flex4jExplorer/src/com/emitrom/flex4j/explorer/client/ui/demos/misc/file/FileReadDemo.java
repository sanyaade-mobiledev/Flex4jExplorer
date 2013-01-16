package com.emitrom.flex4j.explorer.client.ui.demos.misc.file;

import com.emitrom.flash4j.core.client.events.Event;
import com.emitrom.flash4j.core.client.events.IOErrorEvent;
import com.emitrom.flash4j.core.client.events.MouseEvent;
import com.emitrom.flash4j.core.client.events.handlers.EventHandler;
import com.emitrom.flash4j.core.client.net.FileFilter;
import com.emitrom.flash4j.core.client.net.FileReference;
import com.emitrom.flash4j.core.client.utils.ByteArray;
import com.emitrom.flash4j.flex.client.mx.containers.ControlBar;
import com.emitrom.flash4j.flex.client.mx.containers.Panel;
import com.emitrom.flash4j.flex.client.mx.controls.Button;
import com.emitrom.flash4j.flex.client.mx.controls.RichTextEditor;
import com.emitrom.flash4j.flex.client.mx.controls.Spacer;
import com.emitrom.flash4j.flex.client.mx.core.ContainerLayout;
import com.emitrom.flash4j.flex.client.spark.components.Application;
import com.emitrom.flex4j.explorer.client.ui.demos.AbstractDemo;
import com.google.gwt.user.client.Window;

public class FileReadDemo extends AbstractDemo {

    private static final FileReadDemo INSTANCE = new FileReadDemo();
    public static final String FULL_PATH = "misc.file.Read";

    public static FileReadDemo get() {
        return INSTANCE;
    }

    private RichTextEditor richTextEditor;
    private Button button;

    private FileReadDemo() {
        final Panel panel = new Panel("File reading example");
        panel.setLayout(ContainerLayout.ABSOLUTE);
        panel.setCentered();
        panel.setPercentSize(80, 70);

        richTextEditor = new RichTextEditor();
        richTextEditor.strech();
        panel.addElement(richTextEditor);

        this.addElement(panel);

        ControlBar controlBar = new ControlBar();
        controlBar.addElement(new Spacer());
        button = new Button("Import File", "");
        button.addEventHandler(MouseEvent.CLICK, new EventHandler() {
            @Override
            public void onEvent(Event event) {
                readTextFile();
            }
        });
        controlBar.addElement(button);
        panel.addElement(controlBar);

    }

    @Override
    public String getDemoPath() {
        return "misc/file/FileReadDemo.java";
    }

    @Override
    public String getTitle() {
        return "File Read";
    }

    private void readTextFile() {
        FileFilter fileFilter = new FileFilter("Text File", "*.txt;*.text");
        final FileReference fileReference = Application.get().browseFile(fileFilter);
        fileReference.addEventHandler(Event.SELECT, new EventHandler() {
            @Override
            public void onEvent(Event event) {
                fileReference.load();
                fileReference.addEventHandler(Event.COMPLETE, new EventHandler() {
                    @Override
                    public void onEvent(Event event) {
                        ByteArray data = fileReference.getData();
                        richTextEditor.setText(data.readUTFBytes(data.getBytesAvailable()));
                        button.setEnabled(false);
                    }
                });

                fileReference.addEventHandler(IOErrorEvent.IO_ERROR, new EventHandler() {
                    @Override
                    public void onEvent(Event event) {
                        IOErrorEvent e = IOErrorEvent.cast(event);
                        Window.alert("Error loading file :" + e.getText());
                        button.setEnabled(false);
                    }
                });
            }
        });
    }
}