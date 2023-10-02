package LLD.DesignPattern.Adaptor;

import LLD.DesignPattern.Adaptor.thirdparty.logger.LoggerAPI;

public class LoggerAdaptor implements ILogger{
    private LoggerAPI loggerAPI = new LoggerAPI();
    @Override
    public void log(String message) {
        loggerAPI.printLog(message.getBytes());
    }
}
