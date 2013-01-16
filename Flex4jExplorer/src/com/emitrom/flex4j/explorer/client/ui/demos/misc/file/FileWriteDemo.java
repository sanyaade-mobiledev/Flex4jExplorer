package com.emitrom.flex4j.explorer.client.ui.demos.misc.file;

import com.emitrom.flash4j.alivepdf.client.pdf.PDF;
import com.emitrom.flash4j.core.client.events.Event;
import com.emitrom.flash4j.core.client.events.MouseEvent;
import com.emitrom.flash4j.core.client.events.handlers.EventHandler;
import com.emitrom.flash4j.excel.client.ExcelFile;
import com.emitrom.flash4j.excel.client.Sheet;
import com.emitrom.flash4j.flex.client.mx.containers.ControlBar;
import com.emitrom.flash4j.flex.client.mx.containers.Panel;
import com.emitrom.flash4j.flex.client.mx.controls.Button;
import com.emitrom.flash4j.flex.client.mx.controls.ComboBox;
import com.emitrom.flash4j.flex.client.mx.controls.Label;
import com.emitrom.flash4j.flex.client.mx.controls.RichTextEditor;
import com.emitrom.flash4j.flex.client.mx.controls.Spacer;
import com.emitrom.flash4j.flex.client.mx.controls.comboxClasses.ComboBoxEntry;
import com.emitrom.flash4j.flex.client.mx.core.ContainerLayout;
import com.emitrom.flash4j.flex.client.spark.components.Application;
import com.emitrom.flex4j.explorer.client.ui.demos.AbstractDemo;
import com.google.gwt.user.client.Window;

public class FileWriteDemo extends AbstractDemo {

    private static final FileWriteDemo INSTANCE = new FileWriteDemo();
    public static final String FULL_PATH = "misc.file.Write";

    public static FileWriteDemo get() {
        return INSTANCE;
    }

    private RichTextEditor richTextEditor;
    private ComboBox fileFormats;

    private FileWriteDemo() {
        final Panel panel = new Panel("File writing example");
        panel.setLayout(ContainerLayout.ABSOLUTE);
        panel.setCentered();
        panel.setPercentSize(80, 70);

        richTextEditor = new RichTextEditor();
        richTextEditor.strech();
        panel.addElement(richTextEditor);

        this.addElement(panel);

        ControlBar controlBar = new ControlBar();
        controlBar.addElement(new Label("Select a file format: "));

        fileFormats = new ComboBox();
        fileFormats.addItems(new ComboBoxEntry("Text", "1"), new ComboBoxEntry("PDF", "1"), new ComboBoxEntry("Excel",
                        "3"));
        fileFormats.setWidth(150);
        controlBar.addElement(fileFormats);
        controlBar.addElement(new Spacer());

        Button button = new Button("Create File", "");
        button.addEventHandler(MouseEvent.CLICK, new EventHandler() {
            @Override
            public void onEvent(Event event) {
                String content = richTextEditor.getText();
                if (content == null || content.isEmpty()) {
                    Window.alert("Please enter some text in the RichtextEditor");
                } else {
                    writeFile(content, fileFormats.getSelectedLabel());
                }
            }
        });
        controlBar.addElement(button);
        panel.addElement(controlBar);

    }

    @Override
    public String getDemoPath() {
        return "misc/file/FileWriteDemo.java";
    }

    @Override
    public String getTitle() {
        return "File Write";
    }

    private void writeFile(String content, String format) {
        if (format.equalsIgnoreCase("text")) {
            writeTextFile(content);
        } else if (format.equalsIgnoreCase("pdf")) {
            writePdfFile(content);
        } else if (format.equalsIgnoreCase("excel")) {
            writeExcelFile(content);
        }
    }

    private void writeTextFile(String content) {
        Application.get().saveFile(content, "export.txt");
    }

    private void writePdfFile(String content) {
        PDF pdf = new PDF();
        pdf.addPage();
        pdf.writeText(content);
        pdf.saveFile("export.pdf");
    }

    private void writeExcelFile(String content) {
        Sheet sheet = new Sheet();
        sheet.resize(10, 10);
        sheet.setCell(0, 0, content);

        ExcelFile excelFile = new ExcelFile();
        excelFile.addSheet(sheet);
        excelFile.save("export.xls");
    }
}