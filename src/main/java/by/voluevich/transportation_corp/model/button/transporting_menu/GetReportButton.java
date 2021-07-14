package by.voluevich.transportation_corp.model.button.transporting_menu;

import by.voluevich.transportation_corp.model.button.ActionButton;
import by.voluevich.transportation_corp.service.log.Query;
import by.voluevich.transportation_corp.service.utils.Dependencies;

import java.util.List;

public class GetReportButton implements ActionButton {
    @Override
    public String name() {
        return "View report.";
    }

    @Override
    public void tap() {
        List<Query> queryList = Dependencies.getLogQueriesController().getQueries();
        for (Query qr: queryList){
            System.out.println(qr);
        }
    }
}
