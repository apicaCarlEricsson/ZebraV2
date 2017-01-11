import dfischer.proxysniffer.*;
import dfischer.utils.LoadtestExternalResources;

import java.util.Vector;

/**
 * Created by carlericsson on 11/01/17.
 */
public class PrxdatMirror {
    public static final int RECOMMENDED_MAX_PARALLEL_THREADS_PER_USER = 6;
    private Vector proxyData = null;
    private ProxySnifferVarSourceHandler varSourceHandler = null;
    private ProxySnifferVarHandler varHandler = null;
    private LoadtestExternalResources externalResources = null;
    private ProxyDataDumpSessionFilter sessionFilter = null;
    private ProxySnifferTransactionHandler transactionHandler = null;
    private int maxParallelThreadsPerUser = 6;

}
