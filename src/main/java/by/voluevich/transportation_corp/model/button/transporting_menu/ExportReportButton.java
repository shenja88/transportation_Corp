package by.voluevich.transportation_corp.model.button.transporting_menu;

import by.voluevich.transportation_corp.model.button.ActionButton;
import by.voluevich.transportation_corp.service.log.LogWrapperThread;


public class ExportReportButton implements ActionButton {

    @Override
    public String name() {
        return "Export to XML report list.";
    }

    @Override
    public void tap() {
        new LogWrapperThread().start();
    }
}
