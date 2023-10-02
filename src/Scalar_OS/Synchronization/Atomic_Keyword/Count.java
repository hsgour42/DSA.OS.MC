package Scalar_OS.Synchronization.Atomic_Keyword;

import java.util.concurrent.atomic.AtomicInteger;

public class Count {
     //Internally doing lock we do not care of that
     public AtomicInteger value = new AtomicInteger(0);
}
