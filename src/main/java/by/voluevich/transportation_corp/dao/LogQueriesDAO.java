package by.voluevich.transportation_corp.dao;

import by.voluevich.transportation_corp.service.log.Query;
import by.voluevich.transportation_corp.service.log.TypeQuery;

import java.util.List;

public interface LogQueriesDAO {

    List<Query> getQueries();

    List<TypeQuery> getTypeQueries();

    void addQuery(Query query);
}
