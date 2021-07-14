package by.voluevich.transportation_corp.controller;

import by.voluevich.transportation_corp.service.log.Query;
import by.voluevich.transportation_corp.service.log.TypeQuery;

import java.util.List;

public interface LogQueriesController {

    List<Query> getQueries();

    List<TypeQuery> getTypeQueries();

    void addQuery(Query query);
}
