package LLD.DesignPattern.Adaptor;

import LLD.DesignPattern.Adaptor.thirdparty.slo4j.LoggingAPI4J;

public class Slo4JAdaptor implements ILogger{
    private LoggingAPI4J loggingAPI4J = new LoggingAPI4J();
    @Override
    public void log(String message) {
        loggingAPI4J.out(message);
    }
}
