package by.voluevich.transportation_corp.controller;

import by.voluevich.transportation_corp.service.log.Query;
import by.voluevich.transportation_corp.service.log.TypeQuery;
import by.voluevich.transportation_corp.service.utils.Dependencies;

import java.util.List;

public class LogQueriesControllerImpl implements LogQueriesController {
    @Override
    public List<Query> getQueries() {
        return Dependencies.getLogQueriesDao().getQueries();
    }

    @Override
    public List<TypeQuery> getTypeQueries() {
        return Dependencies.getLogQueriesDao().getTypeQueries();
    }

    @Override
    public void addQuery(Query query) {
        Dependencies.getLogQueriesDao().addQuery(query);
    }
}
