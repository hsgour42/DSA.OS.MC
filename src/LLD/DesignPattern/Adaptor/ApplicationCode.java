package LLD.DesignPattern.Adaptor;

public class ApplicationCode {
    ILogger iLogger;

    public ApplicationCode(ILogger iLogger){
        this.iLogger = iLogger;
    }

    public void doSomething(){
        /*
               --- work something
         */

        iLogger.log("do something");
    }
}

//Many Logging Libraries
// 1 : Log4J - sendStream();
// 2 : Logger - printLog();
// 3 : Slo4j - out();
