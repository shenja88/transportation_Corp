package by.voluevich.transportation_corp.service.log;

import by.voluevich.transportation_corp.service.utils.Dependencies;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.List;

public class LogWrapperThread extends Thread {

    @Override
    public void run() {
        List<Query> list = Dependencies.getLogQueriesController().getQueries();
        QueryWrapper log = new QueryWrapper(list);
        try {
            JAXBContext context = JAXBContext.newInstance(QueryWrapper.class, Query.class, TypeQuery.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(log, new File("LogInfo.xml"));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        System.out.println("Report export successfully completed.");
    }
}
