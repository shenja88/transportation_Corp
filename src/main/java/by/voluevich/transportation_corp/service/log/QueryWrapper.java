package by.voluevich.transportation_corp.service.log;

import by.voluevich.transportation_corp.entity.City;
import by.voluevich.transportation_corp.entity.Transport;
import by.voluevich.transportation_corp.service.utils.Dependencies;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "log_queries")
public class QueryWrapper {
    private List<Query> log = new ArrayList<>();

    public QueryWrapper(List<Query> log) {
        this.log = log;
    }

    public QueryWrapper() {
    }

    @XmlElementWrapper(name = "queries")
    @XmlElement(name = "query")
    public List<Query> getLogList() {
        return log;
    }

    public void toLog(City city1, City city2, Transport transport, int numPass, int cargoW, TypeQuery typeQuery) {
        Query query = new Query(
                LocalDate.now() + " " + LocalTime.now(),
                city1.getName(),
                city2.getName(),
                transport.getName(),
                numPass,
                cargoW,
                typeQuery);
        Dependencies.getLogQueriesController().addQuery(query);
    }
}
