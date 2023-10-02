package LLD.DesignPattern.Adaptor;

import LLD.DesignPattern.Adaptor.thirdparty.log4j.Log4jSDK;
import LLD.DesignPattern.Adaptor.thirdparty.slo4j.LoggingAPI4J;

public class Log4JAdaptor implements ILogger{
    private Log4jSDK log4jSDK = new Log4jSDK();
    @Override
    public void log(String message) {
        log4jSDK.sendStream(message);
    }
}
