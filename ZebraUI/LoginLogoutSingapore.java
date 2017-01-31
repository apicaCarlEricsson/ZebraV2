
// *********************************************************************************************
//
// Automatically Generated Load Test Program
// -----------------------------------------
//
// Source: LoginLogoutSingapore.java
// Date  : 30 Jan 2017 08:17:27 ECT
// Author: Apica ZebraTester V5.4-I / automatically generated
//
// Procedure Copyright by Ingenieurbuero David Fischer AG  |  A Company of the Apica Group
// All Rights Reserved
//
// http://www.apicasystem.com                                         http://www.zebratester.com
// *********************************************************************************************


import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.*;
import dfischer.utils.AbstractInputFileReader;
import dfischer.utils.Base64Decoder;
import dfischer.utils.Base64Encoder;
import dfischer.utils.ConvertToDoubleNumber;
import dfischer.utils.ContentTokenExtractor;
import dfischer.utils.ContentTokenExtractorItem;
import dfischer.utils.Cookie;
import dfischer.utils.CookieHandler;
import dfischer.utils.DigestAuthContext;
import dfischer.utils.DNSCache;
import dfischer.utils.DNSTranslationTable;
import dfischer.utils.DynamicProtobufContentParser;
import dfischer.utils.ExternalParamFile;
import dfischer.utils.FileCache;
import dfischer.utils.GenericPluginInterface;
import dfischer.utils.GetRealTimeUserInputFieldsInterface;
import dfischer.utils.HtmlContentParser;
import dfischer.utils.HtmlHeaderCookieExtractor;
import dfischer.utils.HttpLoadTest;
import dfischer.utils.HttpLoadTestIncrementUserThread;
import dfischer.utils.HttpLoadTestUserContext;
import dfischer.utils.HttpSocketPool;
import dfischer.utils.HttpTestURL;
import dfischer.utils.HttpTestURLDNSContext;
import dfischer.utils.HttpTestURLThreadHandler;
import dfischer.utils.InlineScriptExecutionException;
import dfischer.utils.InlineScriptExecutor;
import dfischer.utils.InnerLoopContext;
import dfischer.utils.Lib;
import dfischer.utils.LoadtestInlineScriptContext;
import dfischer.utils.LoadtestInlineScriptVar;
import dfischer.utils.LoadtestPluginContext;
import dfischer.utils.NextProxyConfig;
import dfischer.utils.ParseArgs;
import dfischer.utils.ParseUrl;
import dfischer.utils.PerformanceData;
import dfischer.utils.PerformanceDataTickExtension;
import dfischer.utils.ProtobufFieldAndValueElement;
import dfischer.utils.ProtobufLib;
import dfischer.utils.RealTimeUserInputField;
import dfischer.utils.ScreenshotImage;
import dfischer.utils.SetThreadStepInterface;
import dfischer.utils.SSLInit;
import dfischer.utils.SSLSessionCacheStatistic;
import dfischer.utils.SSLSessionCacheStatisticInterface;
import dfischer.utils.SuspendResumeInterface;
import dfischer.utils.TextLineTokenExtractor;
import dfischer.utils.TextLineTokenExtractorItem;
import dfischer.utils.ThreadStepInterface;
import dfischer.utils.UserInputField;
import dfischer.utils.UserTransactionContext;
import dfischer.utils.UserTransactionRuntimeHandler;
import dfischer.utils.VarInputFileReader;
import dfischer.utils.VarRandomInputFileReader;
import dfischer.utils.VaryingLoadInterface;
import dfischer.utils.VaryingTestDurationInterface;
import dfischer.utils.XmlContentParser;
import dfischer.utils.XmlDoctypeCommentParser;
import dfischer.utils.ZoneTime;
import dfischer.proxysniffer.ProxySnifferVarSourceInlineScript;


/**
 * Automatically generated load test program.
 */
public class LoginLogoutSingapore extends HttpLoadTest implements Runnable, ThreadStepInterface, SetThreadStepInterface, SSLSessionCacheStatisticInterface, VaryingLoadInterface, VaryingTestDurationInterface, SuspendResumeInterface, GetRealTimeUserInputFieldsInterface
{
	public static final String prxVersion = "V5.4-I";
	public static final int    prxCharEncoding = 1;                         // 1 = OS Default, 2 = ISO-8859-1, 3 = UTF-8
	public static final String testDescription = "";

	public static String USER_AGENT_1 = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.11; rv:51.0) Gecko/20100101 Firefox/51.0";

	private static final boolean CONTAINS_PARALLEL_EXECUTED_URLS = true;
	private static final int MAX_PARALLEL_THREADS_PER_USER = 6;                       // default value for max. parallel executed URLs per user
	private static int maxParallelThreadsPerUser = MAX_PARALLEL_THREADS_PER_USER;     // configured value for max. parallel executed URLs per user

	private static final boolean CONTAINS_EXTERNAL_RESOURCES = false;       // note: external resources are typically additional Java library files (*.jar files) invoked by self-developed plug-ins. Consider that Input Files and the Main Class of Plug-Ins are NOT external resources in this context because ZebraTester knows already their declarations.

	// --- proxy configuration ---
	private static boolean proxyEnabled = true;                             // if false: do no use a proxy server
	private static boolean proxyCacheDisabled = true;
	private static String  proxyHttpHost = "";
	private static int     proxyHttpPort = -1;
	private static String  proxyHttpsHost = "";
	private static int     proxyHttpsPort = -1;
	private static String  noProxyFor = "";
	private static String  proxyAuthorization = null;
	private static NextProxyConfig commonNextProxyConfig = new NextProxyConfig(proxyEnabled, proxyCacheDisabled, proxyHttpHost, proxyHttpPort, proxyHttpsHost, proxyHttpsPort, proxyAuthorization, noProxyFor);
	private NextProxyConfig userNextProxyConfig = null;
	
	private static int plannedStartupDelay = 200;                           // startup delay between concurrent users in milliseconds, see main argument "-sdelay"
	private static int plannedTestDuration = -1;                            // planned load test duration in seconds, 0 = unlimited, see main argument "-d"
	private static int maxPlannedLoops = 0;  								// maximum planned loops per user, 0 = unlimited, see main argument "-maxloops"
	private static int plannedRequestTimeout = 0;                           // planned request timeout in seconds, see main argument "-t"
	
	private static String defaultTimeZone = "ECT";                          // use main argument -tz <timezone> to alter
	private static char defaultNumberGroupingSeparator = '\'';              // use main argument -dgs a|c to alter
	private static String sslProtocolVersion = "all";                       // applied ssl protocol version: "all" = v3/tls/tls11/tls12, use main argument -ssl to set a fixed protocol version
	private static boolean sslcmode = false;                                // support of deficient ssl servers, use main argument -sslcmode to enable
	private static boolean sslECC = false;                                  // elliptic curve cryptography (ECC) is disabled by default, use main argument -ecc to enable
	private static boolean sslSNI = true;                                   // server name indication (SNI) is enabled by default, use main argument -nosni to disable
	private static boolean sslSNICirical = false;                           // the SNI TLS extension is by default set as non-critical, use main argument -snicritical to set as critical
	private static final long loopErrorDelay = 20;                          // error delay (in milliseconds) applied if a loop of a virtual user has failed
	private static final String THREAD_NAME = "T000000";                    // internal
	private static Integer dumpLock = new Integer(0);                       // internal
	private static Integer inputFileLock = new Integer(0);                  // internal
	private volatile int threadStep = ThreadStepInterface.THREAD_NO_STEP;   // internal
	private boolean urlCallPassed = false;                                  // internal
	private String localIpAddress = null;                                   // internal
	private static long downlinkBandwidth = 0;                              // max. downlink bandwidth per user. 0 = unlimited. use main argument -downlink <kbps> to alter
	private static long uplinkBandwidth = 0;                                // max. uplink bandwidth per user. 0 = unlimited. use main argument -uplink <kbps> to alter
	private static boolean dnsPerLoop = false;								// true if main argument "-dnsperloop" is set = perform new DNS resolves for each executed loop. normally false
	private HttpTestURLDNSContext userDNSContext = null;                    // user specific DNS context - normally null when no special DNS servers are used
	
	private static volatile boolean debugFailedLoops = false;               // true if main argument "-dfl" is set
	private static volatile boolean debugLoops = false;                     // true if main argument "-dl" is set
	private static volatile boolean debugHttp = false;                      // true if main argument "-dh" is set
	private static volatile boolean debugContent = false;                   // true if main argument "-dc" is set
	private static volatile boolean debugCookies = false;                   // true if main argument "-dC" is set
	private static volatile boolean debugKeepAlive = false;                 // true if main argument "-dK" is set
	private static volatile boolean debugSsl = false;                       // true if main argument "-dssl" is set
	
	private static String resultFile = null;                                // name of binary test result file or null
	
	private final static String httpProtocolVersion = "1.0";      // applied HTTP protocol version V1.0
	
	private static ExternalParamFile externalParamFile = null;                              // used only for very large parameter values (commonly unused)
	private static final String EXTERNAL_PARAM_FILE = "LoginLogoutSingaporeExtParams.dat";  // input file name for very large parameter values
	private static FileCache requestFileCache = new FileCache();  // file cache for large XML, SOAP and ASCII requests
	
	private int requestTimeout = -1;                              // thread input data from constructor, timeout per url request in seconds
	private int remainingLoops = -1;                              // thread input data from constructor, number of loops per thread (optional)
	private boolean checkLoopCount = false;                       // thread input data from constructor, number of loops per thread (optional)
	private int threadNumber = -1;                                // thread input data from constructor, internal thread number
	private int threadLoopCounter = 0;                            // internal loop counter per thread
	private volatile int userResumeStartWaitDelay = 0;            // internal, user specific delay when the load test execution is resumed
	private volatile boolean decrementEndOfLoopFlag = false;	  // internal flag to decrement the simulated user at runtime
	private volatile boolean incrementUserFlag = false;           // internal flag to increment the simulated user at runtime
	private volatile long incrementUserStartTime = -1;            // internal start time when increment the simulated user at runtime
	private static AtomicInteger totalLoopCounter = new AtomicInteger(0);    // internal overall loop counter

	private LoadtestPluginContext userPluginContext = null;       // plug-in context per user
	private LoadtestInlineScriptContext inlineScriptContext = null;          // re-used, scratch, the returned context of an inline script that runs at item or URL exec scope

	private Object sslSessionCache = null;                        // internal ssl session cache per thread
	private SSLSessionCacheStatistic sslStatistic = null;         // internal ssl session cache statistic per thread
	private static int sslSessionCacheTimeout = 300;              // timeout of ssl session cache in seconds, 0 = session cache disabled
	private static int sslHandshakeRandomGeneratorType = -1;      // invalid initial value, use the default secure random generator for SSL handshakes
	private HttpSocketPool socketPool = null;                     // re-used, scratch, internal socket pool per thread and loop
	private CookieHandler cookieHandler = null;                   // re-used, scratch, internal cookie handler per thread and loop

	private HttpTestURL testURL = null;                           // re-used, scratch, http request and response
	private HttpTestURLThreadHandler pageThreadHandler = null;    // re-used, scratch, support for parallel processing of http request within a page
	private int httpStatus = -1;                                  // re-used, scratch, http response status code from webserver
	private HtmlContentParser htmlContentParser = null;           // re-used, scratch, used to extract vars from http response
	private XmlContentParser xmlContentParser = null;             // re-used, scratch, used to extract vars from http response
	private DynamicProtobufContentParser protobufContentParser = null;  // re-used, scratch, used to extract vars from http response
	private TextLineTokenExtractor textLineTokenExtractor = null; // re-used, scratch, used to extract vars from http response
	private ContentTokenExtractor contentTokenExtractor = null;   // re-used, scratch, used to extract vars from http response
	
	private volatile UserTransactionRuntimeHandler transactionHandler = new UserTransactionRuntimeHandler();		// re-used, support to manage user-defined transactions

	private String vWctx_1 = null;                       // var declaration from web admin var handler: scope = per loop
	private String rider9 = null;                        // var declaration from web admin var handler: scope = per loop
	private String rider8 = null;                        // var declaration from web admin var handler: scope = per loop
	private String rider7 = null;                        // var declaration from web admin var handler: scope = per loop
	private String rider6 = null;                        // var declaration from web admin var handler: scope = per loop
	private String rider5 = null;                        // var declaration from web admin var handler: scope = per loop
	private String rider4 = null;                        // var declaration from web admin var handler: scope = per loop
	private String rider3 = null;                        // var declaration from web admin var handler: scope = per loop
	private String vVIEWSTATEGENERATOR = null;           // var declaration from web admin var handler: scope = per loop
	private String vSAMLResponse = null;                 // var declaration from web admin var handler: scope = per loop
	private String rider2 = null;                        // var declaration from web admin var handler: scope = per loop
	private String rider1 = null;                        // var declaration from web admin var handler: scope = per loop
	private String rider13 = null;                       // var declaration from web admin var handler: scope = per loop
	private String vSAMLResponse_1 = null;               // var declaration from web admin var handler: scope = per loop
	private String rider12 = null;                       // var declaration from web admin var handler: scope = per loop
	private String rider11 = null;                       // var declaration from web admin var handler: scope = per loop
	private String vWctx = null;                         // var declaration from web admin var handler: scope = per loop
	private String rider10 = null;                       // var declaration from web admin var handler: scope = per loop
	private String vVIEWSTATE = null;                    // var declaration from web admin var handler: scope = per loop
	private String vEVENTVALIDATION = null;              // var declaration from web admin var handler: scope = per loop
	private String vWa_1 = null;                         // var declaration from web admin var handler: scope = per loop
	private String vWresult = null;                      // var declaration from web admin var handler: scope = per loop
	private String vWa = null;                           // var declaration from web admin var handler: scope = per loop
	private String vWresult_2 = null;                    // var declaration from web admin var handler: scope = per loop
	private String vWresult_1 = null;                    // var declaration from web admin var handler: scope = per loop
	private String vWctx_2 = null;                       // var declaration from web admin var handler: scope = per loop
	

	/**
	 * constructor: called from load test plug-ins (scope = global).
	 */
	public LoginLogoutSingapore()
	{
		super();
	}


	/**
	 * constructor: called when a user is created (per user).
	 */
	public LoginLogoutSingapore(int maxLoops, int requestTimeout, int threadNumber)
	{
		super();
		this.requestTimeout = requestTimeout;
		this.remainingLoops = maxLoops;
		this.checkLoopCount = (maxLoops > 0);
		this.threadNumber = threadNumber;
		this.sslSessionCache = SSLInit.getNewSslSessionCache(sslSessionCacheTimeout);
		this.sslStatistic = new SSLSessionCacheStatistic();
		if (isMultihomed() && (!ipPerLoop()))
			this.localIpAddress = getNextMultihomedIpAddress();
		if (dnsCache != null)
			userDNSContext = new HttpTestURLDNSContext(dnsCache, threadNumber);
		
		// set proxy configuration data per user 
		userNextProxyConfig = new NextProxyConfig(commonNextProxyConfig);
		
		// initialize context for plug-ins which are executed per user
		userPluginContext = new LoadtestPluginContext(prxVersion, prxCharEncoding, this, threadNumber);
	}


	/**
	 * internal method: called when a user starts a loop.
	 * contains the recorded session which is called by users x loops.
	 * 
	 * @param totalLoopCounter total number of loops (0..n-1) counted overall threads. This value is unique per loop.
	 * 
	 * @return  true:  loop successful completed.
	 *          false: loop failed.
	 */
	private boolean execute(int totalLoopCounter) throws Exception
	{
		markStartOfLoop();
		threadStep = 0;                 // internal - start loop at thread step 0
		
		// enable DNS resolves per loop?
		if (dnsPerLoop)
			userDNSContext = new HttpTestURLDNSContext(dnsCache.clone(false), threadNumber);
		
		// debug http headers?
		Object httpLogVectorObject = null;
		if (debugHttp)
			httpLogVectorObject = this;
		
		// create socket pool per loop
		sslSessionCache = SSLInit.getNewSslSessionCache(sslSessionCacheTimeout);		// reset the SSL session cache to get new SSL session IDs for this loop
		socketPool = new HttpSocketPool(this, sslProtocolVersion, sslSessionCache, sslStatistic, sslcmode);
		if (sslHandshakeRandomGeneratorType != -1)
			socketPool.setSslHandshakeRandomGeneratorType(sslHandshakeRandomGeneratorType);
		socketPool.setSupportEllipticCurves(sslECC);
		socketPool.setHintUseSNI(sslSNI);
		socketPool.setSniCritical(sslSNICirical);
		if (debugKeepAlive)
		{
			socketPool.setlogVectorObject(this);
			if (debugSsl)
				socketPool.enableSslLog();
		}
		
		if (downlinkBandwidth > 0)
			socketPool.setDownlinkBandwidth(downlinkBandwidth);
		if (uplinkBandwidth > 0)
			socketPool.setUplinkBandwidth(uplinkBandwidth);
		
		if (isMultihomed())
		{
			if (ipPerLoop())
				localIpAddress = getNextMultihomedIpAddress();
			socketPool.setClientIpAddress(localIpAddress);
			log();
			log("multihomed client ip address = " + localIpAddress);
		}
		
		// setup cookie handler per loop
		cookieHandler = new CookieHandler();
		if (debugCookies)
			cookieHandler.setLogVectorInterface(this);
		
		// customised vars from web admin var handler: scope = per loop
		htmlContentParser = null;
		xmlContentParser = null;
		protobufContentParser = null;
		vWctx_1 = null;
		rider9 = null;
		rider8 = null;
		rider7 = null;
		rider6 = null;
		rider5 = null;
		rider4 = null;
		rider3 = null;
		vVIEWSTATEGENERATOR = null;
		vSAMLResponse = null;
		rider2 = null;
		rider1 = null;
		rider13 = null;
		vSAMLResponse_1 = null;
		rider12 = null;
		rider11 = null;
		vWctx = null;
		rider10 = null;
		vVIEWSTATE = null;
		vEVENTVALIDATION = null;
		vWa_1 = null;
		vWresult = null;
		vWa = null;
		vWresult_2 = null;
		vWresult_1 = null;
		vWctx_2 = null;
		log();
		log("<<< vWctx_1 = " + vWctx_1);
		log("<<< rider9 = " + rider9);
		log("<<< rider8 = " + rider8);
		log("<<< rider7 = " + rider7);
		log("<<< rider6 = " + rider6);
		log("<<< rider5 = " + rider5);
		log("<<< rider4 = " + rider4);
		log("<<< rider3 = " + rider3);
		log("<<< vVIEWSTATEGENERATOR = " + vVIEWSTATEGENERATOR);
		log("<<< vSAMLResponse = " + vSAMLResponse);
		log("<<< rider2 = " + rider2);
		log("<<< rider1 = " + rider1);
		log("<<< rider13 = " + rider13);
		log("<<< vSAMLResponse_1 = " + vSAMLResponse_1);
		log("<<< rider12 = " + rider12);
		log("<<< rider11 = " + rider11);
		log("<<< vWctx = " + vWctx);
		log("<<< rider10 = " + rider10);
		log("<<< vVIEWSTATE = " + vVIEWSTATE);
		log("<<< vEVENTVALIDATION = " + vEVENTVALIDATION);
		log("<<< vWa_1 = " + vWa_1);
		log("<<< vWresult = " + vWresult);
		log("<<< vWa = " + vWa);
		log("<<< vWresult_2 = " + vWresult_2);
		log("<<< vWresult_1 = " + vWresult_1);
		log("<<< vWctx_2 = " + vWctx_2);
		
		// initialize context for plug-ins which are executed per loop
		LoadtestPluginContext loopPluginContext = new LoadtestPluginContext(prxVersion, prxCharEncoding, this, threadNumber, socketPool, cookieHandler);
		



		// --- VIRTUAL PAGE #0 ---
		if (!executePage_0(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject))
			return false;



		// --- PAGE BREAK: Test [0] ---
		log();
		log();
		log("# Page #1: Start page");
		log("# -------------------");
		threadStep = setPageBreak(performanceData, threadStep, "Page #1: Start page", 0, 35, -1);		// hint: param #4 is the user's think time in milliseconds, param #5 is randomness of the user's think time in percent (+/- 0..100%), param #6 is the maximum acceptable response time in milliseconds (-1 = not configured)
		pageThreadHandler = new HttpTestURLThreadHandler(threadStep - 1, maxParallelThreadsPerUser, performanceData, this);   // support for parallel processing of http(s) requests within a page. hint: param #2 is the number of parallel threads per user
		log();

		if (!executePage_1(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject))
		{
			// execution of page 1 failed
			synchResponsesParallelRequestsPage_1(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject);
			return false;
		}
		if (!synchResponsesParallelRequestsPage_1(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject))
			return false;		// execution of page 1 failed
		
		// page 1 successfully executed
		pageThreadHandler.addPageResponseTimeToResult(this);



		// --- PAGE BREAK: Test [20] ---
		log();
		log();
		log("# Page #2: Login");
		log("# --------------");
		threadStep = setPageBreak(performanceData, threadStep, "Page #2: Login", 0, 35, -1);		// hint: param #4 is the user's think time in milliseconds, param #5 is randomness of the user's think time in percent (+/- 0..100%), param #6 is the maximum acceptable response time in milliseconds (-1 = not configured)
		pageThreadHandler = new HttpTestURLThreadHandler(threadStep - 1, maxParallelThreadsPerUser, performanceData, this);   // support for parallel processing of http(s) requests within a page. hint: param #2 is the number of parallel threads per user
		log();

		if (!executePage_2(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject))
		{
			// execution of page 2 failed
			synchResponsesParallelRequestsPage_2(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject);
			return false;
		}
		if (!executePage_2_1(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject))
		{
			// execution of page 2 failed
			synchResponsesParallelRequestsPage_2(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject);
			return false;
		}
		if (!executePage_2_2(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject))
		{
			// execution of page 2 failed
			synchResponsesParallelRequestsPage_2(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject);
			return false;
		}
		if (!executePage_2_3(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject))
		{
			// execution of page 2 failed
			synchResponsesParallelRequestsPage_2(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject);
			return false;
		}
		if (!executePage_2_4(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject))
		{
			// execution of page 2 failed
			synchResponsesParallelRequestsPage_2(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject);
			return false;
		}
		if (!synchResponsesParallelRequestsPage_2(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject))
			return false;		// execution of page 2 failed
		
		// page 2 successfully executed
		pageThreadHandler.addPageResponseTimeToResult(this);



		// --- PAGE BREAK: Test [113] ---
		log();
		log();
		log("# Page #3: Logout");
		log("# ---------------");
		threadStep = setPageBreak(performanceData, threadStep, "Page #3: Logout", 0, 35, -1);		// hint: param #4 is the user's think time in milliseconds, param #5 is randomness of the user's think time in percent (+/- 0..100%), param #6 is the maximum acceptable response time in milliseconds (-1 = not configured)
		pageThreadHandler = new HttpTestURLThreadHandler(threadStep - 1, maxParallelThreadsPerUser, performanceData, this);   // support for parallel processing of http(s) requests within a page. hint: param #2 is the number of parallel threads per user
		log();

		if (!executePage_3(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject))
		{
			// execution of page 3 failed
			synchResponsesParallelRequestsPage_3(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject);
			return false;
		}
		if (!executePage_3_1(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject))
		{
			// execution of page 3 failed
			synchResponsesParallelRequestsPage_3(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject);
			return false;
		}
		if (!executePage_3_2(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject))
		{
			// execution of page 3 failed
			synchResponsesParallelRequestsPage_3(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject);
			return false;
		}
		if (!synchResponsesParallelRequestsPage_3(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject))
			return false;		// execution of page 3 failed
		
		// page 3 successfully executed
		pageThreadHandler.addPageResponseTimeToResult(this);



		// --- PAGE BREAK: Test [167] ---
		log();
		log();
		log("# Page #4: rkwerwlkr");
		log("# ------------------");
		threadStep = setPageBreak(performanceData, threadStep, "Page #4: rkwerwlkr", 3000, 35, -1);		// hint: param #4 is the user's think time in milliseconds, param #5 is randomness of the user's think time in percent (+/- 0..100%), param #6 is the maximum acceptable response time in milliseconds (-1 = not configured)
		pageThreadHandler = new HttpTestURLThreadHandler(threadStep - 1, maxParallelThreadsPerUser, performanceData, this);   // support for parallel processing of http(s) requests within a page. hint: param #2 is the number of parallel threads per user
		log();

		if (!executePage_4(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject))
		{
			// execution of page 4 failed
			synchResponsesParallelRequestsPage_4(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject);
			return false;
		}
		if (!synchResponsesParallelRequestsPage_4(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject))
			return false;		// execution of page 4 failed
		
		// page 4 successfully executed
		pageThreadHandler.addPageResponseTimeToResult(this);
		
		
		// loop successful done
		// --------------------
		
		markEndOfPage(performanceData);
		
		endOfExecuteLoop(true, null, -1, loopPluginContext);
		log();
		return true;
	}		// end of execute()
		
		
		
	/**
	 * internal method: called when a user has completed a loop.
	 */
	private void endOfExecuteLoop(boolean loopPassed, HttpTestURL testURL, int threadStep, LoadtestPluginContext loopPluginContext) throws Exception
	{
		// log URL if last call has failed
		if ((!loopPassed) && (testURL != null))
			log(testURL);
		
		// update plugin context
		loopPluginContext.setLoopPassed(loopPassed);
		if ((testURL != null) && (loopPluginContext.getHttpTestURL() == null))
			loopPluginContext.setHttpTestURL(testURL);
		if ((threadStep != -1) && (loopPluginContext.getThreadStep() == -1))
			loopPluginContext.setThreadStep(threadStep);
	}


	/**
	 * Recorded http requests of page #0.
	 *
	 * @return  true:  method successful completed.
	 *          false: method/loop failed.
	 */
	boolean executePage_0(int totalLoopCounter, LoadtestPluginContext loopPluginContext, InnerLoopContext innerLoopContext, Object httpLogVectorObject) throws Exception
	{

		// all http requests of page #0 successful done
		return true;
	}


	/**
	 * Recorded http requests of page #1.
	 *
	 * @return  true:  method successful completed.
	 *          false: method/loop failed.
	 */
	boolean executePage_1(int totalLoopCounter, LoadtestPluginContext loopPluginContext, InnerLoopContext innerLoopContext, Object httpLogVectorObject) throws Exception
	{
		// # Page #1: Start page
		// # -------------------



		// --- HTTP REQUEST: Test [1] <- WEB ADMIN Index 1 ---
		log();
		log("# title: Document Moved");
		String requestProt0001 = "https";
		String requestHost0001 = "www.abb.com";
		int    requestPort0001 = 443;
		String requestFile0001 = "/myabb";
		String requestHeader0001 = "GET " + requestFile0001 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"Upgrade-Insecure-Requests: 1\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0001, requestHost0001, requestPort0001, requestHeader0001, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0001 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 301, content type = [verification disabled], header text fragment = [verification disabled], recorded content size = 149
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {301}, null, null, null);		// Test [1] <- Index 1
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [2] <- WEB ADMIN Index 2 ---
		log();
		log("# title: Object moved");
		String requestProt0002 = "https";
		String requestHost0002 = "www.abb.com";
		int    requestPort0002 = 443;
		String requestFile0002 = "/myabb/";
		String requestHeader0002 = "GET " + requestFile0002 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"Upgrade-Insecure-Requests: 1\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0002, requestHost0002, requestPort0002, requestHeader0002, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0002 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 302, content type = [verification disabled], header text fragment = [verification disabled], recorded content size = 375
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {302}, null, null, null);		// Test [2] <- Index 2
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// extract variable(s) from response
		htmlContentParser = new HtmlContentParser(testURL, this);
		try
		{
			// extract var 'rider1'
			rider1 = new ParseUrl(testURL.getHeaderField("location")).getFile();		// recorded value = /adfs/ls/?wa=wsignin1.0&wtrealm=https%3a%2f%2fwww.abb.com%2f&wctx=rm%3d0%26id%3dpassive%26ru%3d%252fmyabb%252fdefault.aspx&wct=2016-12-20T10%3a16%3a00Z&wreply=https%3a%2f%2fwww.abb.com%2fAuthentication%2fADFSHandler.ashx
			log("<<< rider1 = " + rider1);
		}
		catch (Exception e) { rider1 = null; log(e); }
		if (rider1 == null)
		{
			// failure - dump wrong response content and abort current outer loop - after that start next loop
			String errorText = "*** error: unable to extract var 'rider1' from http redirection";
			log(errorText);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			threadStep = performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_USER_SPECIFIC_TEST_FAILED, errorText, testURL, this);
		
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [3] <- WEB ADMIN Index 3 ---
		log();
		log("# title: Object moved");
		String requestProt0003 = "https";
		String requestHost0003 = "stsint.abb.com";
		int    requestPort0003 = 443;
		String requestFile0003 = "/adfs/ls/" +
				"?wa=wsignin1.0" +
				"&wtrealm=https%3a%2f%2fwww.abb.com%2f" +
				"&wctx=rm%3d0%26id%3dpassive%26ru%3d%252fmyabb%252fdefault.aspx" +
				"&wct=2016-12-20T10%3a16%3a00Z" +
				"&wreply=https%3a%2f%2fwww.abb.com%2fAuthentication%2fADFSHandler.ashx";
		requestFile0003 = Lib.replaceTextPattern(requestFile0003, "/adfs/ls/?wa=wsignin1.0&wtrealm=https%3a%2f%2fwww.abb.com%2f&wctx=rm%3d0%26id%3dpassive%26ru%3d%252fmyabb%252fdefault.aspx&wct=2016-12-20T10%3a16%3a00Z&wreply=https%3a%2f%2fwww.abb.com%2fAuthentication%2fADFSHandler.ashx", rider1, 0);		// search and replace request file fragment "/adfs/ls/?wa=wsignin1.0&wtrealm=https%3a%2f%2fwww.abb.com%2f&wctx=rm%3d0%26id%3dpassive%26ru%3d%252fmyabb%252fdefault.aspx&wct=2016-12-20T10%3a16%3a00Z&wreply=https%3a%2f%2fwww.abb.com%2fAuthentication%2fADFSHandler.ashx" with variable 'rider1' on all occurrences

		String requestHeader0003 = "GET " + requestFile0003 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: stsint.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"Upgrade-Insecure-Requests: 1\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0003, requestHost0003, requestPort0003, requestHeader0003, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0003 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 302, content type = [verification disabled], header text fragment = [verification disabled], recorded content size = 315
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {302}, null, null, null);		// Test [3] <- Index 3
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// extract variable(s) from response
		htmlContentParser = new HtmlContentParser(testURL, this);
		try
		{
			// extract var 'rider2'
			rider2 = new ParseUrl(testURL.getHeaderField("location")).getFile();		// recorded value = /adfs/ls/Fwd.aspx?wa=wsignin1.0&wtrealm=http%3a%2f%2fstsint.abb.com%2fadfs%2fservices%2ftrust&wctx=f29eb6a3-5cdf-479c-a7e9-ed6e60508465&wct=2016-12-20T10%3a16%3a00Z
			log("<<< rider2 = " + rider2);
		}
		catch (Exception e) { rider2 = null; log(e); }
		if (rider2 == null)
		{
			// failure - dump wrong response content and abort current outer loop - after that start next loop
			String errorText = "*** error: unable to extract var 'rider2' from http redirection";
			log(errorText);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			threadStep = performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_USER_SPECIFIC_TEST_FAILED, errorText, testURL, this);
		
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [4] <- WEB ADMIN Index 4 ---
		log();
		log("# title: Object moved");
		String requestProt0004 = "https";
		String requestHost0004 = "stsint.abb.com";
		int    requestPort0004 = 443;
		String requestFile0004 = "/adfs/ls/Fwd.aspx" +
				"?wa=wsignin1.0" +
				"&wtrealm=http%3a%2f%2fstsint.abb.com%2fadfs%2fservices%2ftrust" +
				"&wctx=f29eb6a3-5cdf-479c-a7e9-ed6e60508465" +
				"&wct=2016-12-20T10%3a16%3a00Z";
		requestFile0004 = Lib.replaceTextPattern(requestFile0004, "/adfs/ls/Fwd.aspx?wa=wsignin1.0&wtrealm=http%3a%2f%2fstsint.abb.com%2fadfs%2fservices%2ftrust&wctx=f29eb6a3-5cdf-479c-a7e9-ed6e60508465&wct=2016-12-20T10%3a16%3a00Z", rider2, 0);		// search and replace request file fragment "/adfs/ls/Fwd.aspx?wa=wsignin1.0&wtrealm=http%3a%2f%2fstsint.abb.com%2fadfs%2fservices%2ftrust&wctx=f29eb6a3-5cdf-479c-a7e9-ed6e60508465&wct=2016-12-20T10%3a16%3a00Z" with variable 'rider2' on all occurrences

		String requestHeader0004 = "GET " + requestFile0004 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: stsint.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"Upgrade-Insecure-Requests: 1\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0004, requestHost0004, requestPort0004, requestHeader0004, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0004 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 302, content type = [verification disabled], header text fragment = [verification disabled], recorded content size = 309
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {302}, null, null, null);		// Test [4] <- Index 4
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// extract variable(s) from response
		htmlContentParser = new HtmlContentParser(testURL, this);
		try
		{
			// extract var 'rider3'
			rider3 = new ParseUrl(testURL.getHeaderField("location")).getFile();		// recorded value = /vissts?wa=wsignin1.0&wtrealm=http%3a%2f%2fstsint.abb.com%2fadfs%2fservices%2ftrust&wctx=f29eb6a3-5cdf-479c-a7e9-ed6e60508465&wct=2016-12-20t10%3a16%3a00z
			log("<<< rider3 = " + rider3);
		}
		catch (Exception e) { rider3 = null; log(e); }
		if (rider3 == null)
		{
			// failure - dump wrong response content and abort current outer loop - after that start next loop
			String errorText = "*** error: unable to extract var 'rider3' from http redirection";
			log(errorText);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			threadStep = performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_USER_SPECIFIC_TEST_FAILED, errorText, testURL, this);
		
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [5] <- WEB ADMIN Index 5 ---
		log();
		log("# title: Document Moved");
		String requestProt0005 = "https";
		String requestHost0005 = "stsint.abb.com";
		int    requestPort0005 = 443;
		String requestFile0005 = "/vissts" +
				"?wa=wsignin1.0" +
				"&wtrealm=http%3a%2f%2fstsint.abb.com%2fadfs%2fservices%2ftrust" +
				"&wctx=f29eb6a3-5cdf-479c-a7e9-ed6e60508465" +
				"&wct=2016-12-20t10%3a16%3a00z";
		requestFile0005 = Lib.replaceTextPattern(requestFile0005, "/vissts?wa=wsignin1.0&wtrealm=http%3a%2f%2fstsint.abb.com%2fadfs%2fservices%2ftrust&wctx=f29eb6a3-5cdf-479c-a7e9-ed6e60508465&wct=2016-12-20t10%3a16%3a00z", rider3, 0);		// search and replace request file fragment "/vissts?wa=wsignin1.0&wtrealm=http%3a%2f%2fstsint.abb.com%2fadfs%2fservices%2ftrust&wctx=f29eb6a3-5cdf-479c-a7e9-ed6e60508465&wct=2016-12-20t10%3a16%3a00z" with variable 'rider3' on all occurrences

		String requestHeader0005 = "GET " + requestFile0005 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: stsint.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"Upgrade-Insecure-Requests: 1\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0005, requestHost0005, requestPort0005, requestHeader0005, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0005 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 301, content type = [verification disabled], header text fragment = [verification disabled], recorded content size = 312
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {301}, null, null, null);		// Test [5] <- Index 5
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// extract variable(s) from response
		htmlContentParser = new HtmlContentParser(testURL, this);
		try
		{
			// extract var 'rider4'
			rider4 = new ParseUrl(testURL.getHeaderField("location")).getFile();		// recorded value = /vissts/?wa=wsignin1.0&wtrealm=http%3a%2f%2fstsint.abb.com%2fadfs%2fservices%2ftrust&wctx=f29eb6a3-5cdf-479c-a7e9-ed6e60508465&wct=2016-12-20t10%3a16%3a00z
			log("<<< rider4 = " + rider4);
		}
		catch (Exception e) { rider4 = null; log(e); }
		if (rider4 == null)
		{
			// failure - dump wrong response content and abort current outer loop - after that start next loop
			String errorText = "*** error: unable to extract var 'rider4' from http redirection";
			log(errorText);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			threadStep = performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_USER_SPECIFIC_TEST_FAILED, errorText, testURL, this);
		
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [6] <- WEB ADMIN Index 6 ---
		log();
		log("# title: Object moved");
		String requestProt0006 = "https";
		String requestHost0006 = "stsint.abb.com";
		int    requestPort0006 = 443;
		String requestFile0006 = "/vissts/" +
				"?wa=wsignin1.0" +
				"&wtrealm=http%3a%2f%2fstsint.abb.com%2fadfs%2fservices%2ftrust" +
				"&wctx=f29eb6a3-5cdf-479c-a7e9-ed6e60508465" +
				"&wct=2016-12-20t10%3a16%3a00z";
		requestFile0006 = Lib.replaceTextPattern(requestFile0006, "/vissts/?wa=wsignin1.0&wtrealm=http%3a%2f%2fstsint.abb.com%2fadfs%2fservices%2ftrust&wctx=f29eb6a3-5cdf-479c-a7e9-ed6e60508465&wct=2016-12-20t10%3a16%3a00z", rider4, 0);		// search and replace request file fragment "/vissts/?wa=wsignin1.0&wtrealm=http%3a%2f%2fstsint.abb.com%2fadfs%2fservices%2ftrust&wctx=f29eb6a3-5cdf-479c-a7e9-ed6e60508465&wct=2016-12-20t10%3a16%3a00z" with variable 'rider4' on all occurrences

		String requestHeader0006 = "GET " + requestFile0006 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: stsint.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"Upgrade-Insecure-Requests: 1\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0006, requestHost0006, requestPort0006, requestHeader0006, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0006 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 302, content type = [verification disabled], header text fragment = [verification disabled], recorded content size = 292
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {302}, null, null, null);		// Test [6] <- Index 6
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// extract variable(s) from response
		htmlContentParser = new HtmlContentParser(testURL, this);
		try
		{
			// extract var 'rider5'
			rider5 = testURL.getHeaderField("Location");		// recorded value = /vissts/sts.aspx?wa=wsignin1.0&wtrealm=http%3a%2f%2fstsint.abb.com%2fadfs%2fservices%2ftrust&wctx=f29eb6a3-5cdf-479c-a7e9-ed6e60508465&wct=2016-12-20t10%3a16%3a00z
			log("<<< rider5 = " + rider5);
		}
		catch (Exception e) { rider5 = null; log(e); }
		if (rider5 == null)
		{
			// failure - dump wrong response content and abort current outer loop - after that start next loop
			String errorText = "*** error: unable to extract var 'rider5' from http response header field";
			log(errorText);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			threadStep = performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_USER_SPECIFIC_TEST_FAILED, errorText, testURL, this);
		
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [7] <- WEB ADMIN Index 7 ---
		log();
		log("# title: Object moved");
		String requestProt0007 = "https";
		String requestHost0007 = "stsint.abb.com";
		int    requestPort0007 = 443;
		String requestFile0007 = "/vissts/sts.aspx" +
				"?wa=wsignin1.0" +
				"&wtrealm=http%3a%2f%2fstsint.abb.com%2fadfs%2fservices%2ftrust" +
				"&wctx=f29eb6a3-5cdf-479c-a7e9-ed6e60508465" +
				"&wct=2016-12-20t10%3a16%3a00z";
		requestFile0007 = Lib.replaceTextPattern(requestFile0007, "/vissts/sts.aspx?wa=wsignin1.0&wtrealm=http%3a%2f%2fstsint.abb.com%2fadfs%2fservices%2ftrust&wctx=f29eb6a3-5cdf-479c-a7e9-ed6e60508465&wct=2016-12-20t10%3a16%3a00z", rider5, 0);		// search and replace request file fragment "/vissts/sts.aspx?wa=wsignin1.0&wtrealm=http%3a%2f%2fstsint.abb.com%2fadfs%2fservices%2ftrust&wctx=f29eb6a3-5cdf-479c-a7e9-ed6e60508465&wct=2016-12-20t10%3a16%3a00z" with variable 'rider5' on all occurrences

		String requestHeader0007 = "GET " + requestFile0007 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: stsint.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"Upgrade-Insecure-Requests: 1\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0007, requestHost0007, requestPort0007, requestHeader0007, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0007 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 302, content type = [verification disabled], header text fragment = [verification disabled], recorded content size = 531
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {302}, null, null, null);		// Test [7] <- Index 7
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// extract variable(s) from response
		htmlContentParser = new HtmlContentParser(testURL, this);
		try
		{
			// extract var 'rider6'
			rider6 = testURL.getHeaderField("Location");		// recorded value = /vissts/public/BasicPages/LoginBasic.aspx?ReturnUrl=%2fvissts%2fsts.aspx%3fwa%3dwsignin1.0%26wtrealm%3dhttp%253a%252f%252fstsint.abb.com%252fadfs%252fservices%252ftrust%26wctx%3df29eb6a3-5cdf-479c-a7e9-ed6e60508465%26wct%3d2016-12-20t10%253a16%253a00z&wa=wsignin1.0&wtrealm=http%3a%2f%2fstsint.abb.com%2fadfs%2fservices%2ftrust&wctx=f29eb6a3-5cdf-479c-a7e9-ed6e60508465&wct=2016-12-20t10%3a16%3a00z
			log("<<< rider6 = " + rider6);
		}
		catch (Exception e) { rider6 = null; log(e); }
		if (rider6 == null)
		{
			// failure - dump wrong response content and abort current outer loop - after that start next loop
			String errorText = "*** error: unable to extract var 'rider6' from http response header field";
			log(errorText);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			threadStep = performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_USER_SPECIFIC_TEST_FAILED, errorText, testURL, this);
		
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [8] <- WEB ADMIN Index 8 ---
		log();
		log("# title: Log in");
		String requestProt0008 = "https";
		String requestHost0008 = "stsint.abb.com";
		int    requestPort0008 = 443;
		String requestFile0008 = "/vissts/public/BasicPages/LoginBasic.aspx" +
				"?ReturnUrl=%2fvissts%2fsts.aspx%3fwa%3dwsignin1.0%26wtrealm%3dhttp%253a%252f%252fstsint.abb.com%252fadfs%252fservices%252ftrust%26wctx%3df29eb6a3-5cdf-479c-a7e9-ed6e60508465%26wct%3d2016-12-20t10%253a16%253a00z" +
				"&wa=wsignin1.0" +
				"&wtrealm=http%3a%2f%2fstsint.abb.com%2fadfs%2fservices%2ftrust" +
				"&wctx=f29eb6a3-5cdf-479c-a7e9-ed6e60508465" +
				"&wct=2016-12-20t10%3a16%3a00z";
		requestFile0008 = Lib.replaceTextPattern(requestFile0008, "/vissts/public/BasicPages/LoginBasic.aspx?ReturnUrl=%2fvissts%2fsts.aspx%3fwa%3dwsignin1.0%26wtrealm%3dhttp%253a%252f%252fstsint.abb.com%252fadfs%252fservices%252ftrust%26wctx%3df29eb6a3-5cdf-479c-a7e9-ed6e60508465%26wct%3d2016-12-20t10%253a16%253a00z&wa=wsignin1.0&wtrealm=http%3a%2f%2fstsint.abb.com%2fadfs%2fservices%2ftrust&wctx=f29eb6a3-5cdf-479c-a7e9-ed6e60508465&wct=2016-12-20t10%3a16%3a00z", rider6, 0);		// search and replace request file fragment "/vissts/public/BasicPages/LoginBasic.aspx?ReturnUrl=%2fvissts%2fsts.aspx%3fwa%3dwsignin1.0%26wtrealm%3dhttp%253a%252f%252fstsint.abb.com%252fadfs%252fservices%252ftrust%26wctx%3df29eb6a3-5cdf-479c-a7e9-ed6e60508465%26wct%3d2016-12-20t10%253a16%253a00z&wa=wsignin1.0&wtrealm=http%3a%2f%2fstsint.abb.com%2fadfs%2fservices%2ftrust&wctx=f29eb6a3-5cdf-479c-a7e9-ed6e60508465&wct=2016-12-20t10%3a16%3a00z" with variable 'rider6' on all occurrences

		String requestHeader0008 = "GET " + requestFile0008 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: stsint.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"Upgrade-Insecure-Requests: 1\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0008, requestHost0008, requestPort0008, requestHeader0008, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0008 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 16423
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, null);		// Test [8] <- Index 8
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// extract variable(s) from response
		htmlContentParser = new HtmlContentParser(testURL, this);
		try
		{
			// extract var 'vVIEWSTATEGENERATOR'
			vVIEWSTATEGENERATOR = htmlContentParser.getFormTable().getForm(0).getFormItemValue("__VIEWSTATEGENERATOR");		// recorded value = 9333DAF3
			log("<<< vVIEWSTATEGENERATOR = " + vVIEWSTATEGENERATOR);
		}
		catch (Exception e) { vVIEWSTATEGENERATOR = null; log(e); }
		if (vVIEWSTATEGENERATOR == null)
		{
			// failure - dump wrong response content and abort current outer loop - after that start next loop
			String errorText = "*** error: unable to extract var 'vVIEWSTATEGENERATOR' from html form parameter";
			log(errorText);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			threadStep = performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_USER_SPECIFIC_TEST_FAILED, errorText, testURL, this);
		
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		try
		{
			// extract var 'vVIEWSTATE'
			vVIEWSTATE = htmlContentParser.getFormTable().getForm(0).getFormItemValue("__VIEWSTATE");		// recorded value = /wEPDwUKLTM5NjExMzYwNw9kFgICAw9kFiQCAQ8PFgIeBFRleHQFBkxvZyBpbmRkAgMPDxYCHwAF5AJSZXR1cm5Vcmw9JTJmdmlzc3RzJTJmc3RzLmFzcHglM2Z3YSUzZHdzaWduaW4xLjAlMjZ3dHJlYWxtJTNkaHR0cCUyNTNhJTI1MmYlMjUyZnN0c2ludC5hYmIuY29tJTI1MmZhZGZzJTI1MmZzZXJ2aWNlcyUyNTJmdHJ1c3QlMjZ3Y3R4JTNkZjI5ZWI2YTMtNWNkZi00NzljLWE3ZTktZWQ2ZTYwNTA4NDY1JTI2d2N0JTNkMjAxNi0xMi0yMHQxMCUyNTNhMTYlMjUzYTAweiZ3YT13c2lnbmluMS4wJnd0cmVhbG09aHR0cCUzYSUyZiUyZnN0c2ludC5hYmIuY29tJTJmYWRmcyUyZnNlcnZpY2VzJTJmdHJ1c3Qmd2N0eD1mMjllYjZhMy01Y2RmLTQ3OWMtYTdlOS1lZDZlNjA1MDg0NjUmd2N0PTIwMTYtMTItMjB0MTAlM2ExNiUzYTAwemRkAgUPDxYCHwAFxwElMmZ2aXNzdHMlMmZzdHMuYXNweCUzZndhJTNkd3NpZ25pbjEuMCUyNnd0cmVhbG0lM2RodHRwJTI1M2ElMjUyZiUyNTJmc3RzaW50LmFiYi5jb20lMjUyZmFkZnMlMjUyZnNlcnZpY2VzJTI1MmZ0cnVzdCUyNndjdHglM2RmMjllYjZhMy01Y2RmLTQ3OWMtYTdlOS1lZDZlNjA1MDg0NjUlMjZ3Y3QlM2QyMDE2LTEyLTIwdDEwJTI1M2ExNiUyNTNhMDB6ZGQCCQ8PFgIfAAUORS1tYWlsIGFkZHJlc3NkZAIND2QWAmYPDxYCHwAFHVlvdSBtdXN0IGVudGVyIGUtbWFpbCBhZGRyZXNzZGQCDw9kFgJmDw8WAh8ABSVZb3UgbXVzdCBwcm92aWRlIHZhbGlkIGVtYWlsIGFkZHJlc3MuZGQCEQ8PFgIfAAUIUGFzc3dvcmRkZAIVD2QWAmYPDxYCHwAFF1lvdSBtdXN0IGVudGVyIHBhc3N3b3JkZGQCFw8PFgIfAAUGdW5tYXNrZGQCGQ8PFgIfAAUFTG9naW5kZAIbDxYCHgRocmVmZGQCHQ8WAh8BBTNodHRwczovL3d3dy5hYmIuY29tL1VzZXIvUmVxdWVzdEZvcmdvdFBhc3N3b3JkLmFzcHgWAgIBDw8WAh8ABRVGb3Jnb3QgeW91ciBwYXNzd29yZD8WAh4LcmVzb3VyY2VLZXkFF1VJLkxvZ2luLkZvcmdvdFBhc3N3b3JkZAIfDw8WAh8ABRBOZWVkIGFuIGFjY291bnQ/ZGQCIQ8WAh8BBS5odHRwczovL3d3dy5hYmIuY29tL1VzZXIvUmVnaXN0cmF0aW9uUGFnZS5hc3B4FgICAQ8PFgIfAAUIU2lnbiB1cCFkZAIjDw8WAh8ABR5Qcm92aWRlciBJbmZvcm1hdGlvbi9JbXByZXNzdW1kZAIlDw8WAh8ABRpDb29raWVzIGFuZCBwcml2YWN5IHBvbGljeWRkAicPDxYCHwAFElByZWZlcnJlZCBsYW5ndWFnZWRkAikPEGQPFiNmAgECAgIDAgQCBQIGAgcCCAIJAgoCCwIMAg0CDgIPAhACEQISAhMCFAIVAhYCFwIYAhkCGgIbAhwCHQIeAh8CIAIhAiIWIxAFBkFyYWJpYwUEMTAyNWcQBQlCdWxnYXJpYW4FBDEwMjZnEAUFQ3plY2gFBDEwMjlnEAUGRGFuaXNoBQQxMDMwZxAFBkdlcm1hbgUEMTAzMWcQBQVHcmVlawUEMTAzMmcQBQdFbmdsaXNoBQQxMDMzZxAFB1NwYW5pc2gFBDEwMzRnEAUHRmlubmlzaAUEMTAzNWcQBQZGcmVuY2gFBDEwMzZnEAUGSGVicmV3BQQxMDM3ZxAFCUh1bmdhcmlhbgUEMTAzOGcQBQdJdGFsaWFuBQQxMDQwZxAFCEphcGFuZXNlBQQxMDQxZxAFBktvcmVhbgUEMTA0MmcQBQVEdXRjaAUEMTA0M2cQBQlOb3J3ZWdpYW4FBDEwNDRnEAUGUG9saXNoBQQxMDQ1ZxAFCFJvbWFuaWFuBQQxMDQ4ZxAFB1J1c3NpYW4FBDEwNDlnEAUIQ3JvYXRpYW4FBDEwNTBnEAUGU2xvdmFrBQQxMDUxZxAFB1N3ZWRpc2gFBDEwNTNnEAUEVGhhaQUEMTA1NGcQBQdUdXJraXNoBQQxMDU1ZxAFCVVrcmFpbmlhbgUEMTA1OGcQBQlTbG92ZW5pYW4FBDEwNjBnEAUIRXN0b25pYW4FBDEwNjFnEAUHTGF0dmlhbgUEMTA2MmcQBQpMaXRodWFuaWFuBQQxMDYzZxAFB1BlcnNpYW4FBDEwNjVnEAUKVmlldG5hbWVzZQUEMTA2NmcQBRJDaGluZXNlIFNpbXBsaWZpZWQFBDIwNTJnEAUKUG9ydHVndWVzZQUEMjA3MGcQBRNDaGluZXNlIFRyYWRpdGlvbmFsBQUzMTc0OGcWAQIGZGSBXq0wc/Z4XqeS/iQm9BjKNYJMHI7TQ/j2L8eDa9Cz/A==
			log("<<< vVIEWSTATE = " + vVIEWSTATE);
		}
		catch (Exception e) { vVIEWSTATE = null; log(e); }
		if (vVIEWSTATE == null)
		{
			// failure - dump wrong response content and abort current outer loop - after that start next loop
			String errorText = "*** error: unable to extract var 'vVIEWSTATE' from html form parameter";
			log(errorText);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			threadStep = performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_USER_SPECIFIC_TEST_FAILED, errorText, testURL, this);
		
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		try
		{
			// extract var 'vEVENTVALIDATION'
			vEVENTVALIDATION = htmlContentParser.getFormTable().getForm(0).getFormItemValue("__EVENTVALIDATION");		// recorded value = /wEdACm3CLaiLBYH3+RaPY0kTkxBVK7BrRAtEiqu9nGFEI+jB3Y2+Mc6SrnAqio3oCKbxYY85pbWlDO2hADfoPXD/5tdd9DWhICYo6sOpkGpIzIKzK6kzfFnmEDmUoYjmX3HfXt0ArrMpJHqMpvN7H76vx6ULpWbmVO3wqowOSESFccQH8AS0HPYrMvqXZc0LkYvqE8VmvASjMcfDWd4wOnR6K0l+vphdUnkKGrDlX05SiKOd1G0ZrUo0X/vCwq5tnDMl9jxaugKz1XfkUBebVE0Hx/INVDThD20RQkmH6G2uEhtQQSwCCJ8GTxX66Lvudb330amIxmiiGYZK+7nmMfVyyWhGkKju3NiCmYzB1lDfuOLuL8EY+ujUQKrELQq24t48OobwfTn0mwzGyiT4VeMtwFvgLeOINUfNWgB63hd7OG4hoZ3R6M5vQAiquJ7aZyXzGp3nQSyhH/s83YLFUjVW77S6EyHCQ9Y1dYDyAwb+nUgYxHjtnWfJkF9Tb9RD/HffSAkvJfAeSMhO0haucUb/ShOZ+n6h59hztKTqIqhwM8Tmso8t68eAwSmtST2g0Le4G2+CtaPCcYqdt6NbsGk5wvu46lXf9YpaQA871VY8A78QS+Ln9IwrnNKFy6dAYnf35hAC+kssw9QbB4cTffeqeQodn8N1icK0TqOTkyjig1ZyjinKHG0JiIhDGpllGVrWiDVQ5F2XlQ6mDmoIwfrzJCHT3ycP13a6ngwGCmbLWwWyzy4cVdKRXV2qB/NKmtUWZFpIOsTlzX+dbyZSP+xlW9YE406D2ZfT9z/BLKq+RAZgW+Sek9X7oJDxGqpClP4RRlw72pE+jSQQo8G/LwmKUz8ozoUWGaxZlwLC8due01Cq+75Vd0bh+lZ771JDs9PbExpIuQr1Al3fAQheNLJtMdI
			log("<<< vEVENTVALIDATION = " + vEVENTVALIDATION);
		}
		catch (Exception e) { vEVENTVALIDATION = null; log(e); }
		if (vEVENTVALIDATION == null)
		{
			// failure - dump wrong response content and abort current outer loop - after that start next loop
			String errorText = "*** error: unable to extract var 'vEVENTVALIDATION' from html form parameter";
			log(errorText);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			threadStep = performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_USER_SPECIFIC_TEST_FAILED, errorText, testURL, this);
		
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [9] <- WEB ADMIN Index 9 ---
		String requestProt0009 = "https";
		String requestHost0009 = "stsint.abb.com";
		int    requestPort0009 = 443;
		String requestFile0009 = "/vissts/css_abb/bundles/_fifa.all/_fifa.all.min.css";
		String requestHeader0009 = "GET " + requestFile0009 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: stsint.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0009, requestHost0009, requestPort0009, requestHeader0009, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0009 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [10] <- WEB ADMIN Index 10 ---
		String requestProt0010 = "https";
		String requestHost0010 = "stsint.abb.com";
		int    requestPort0010 = 443;
		String requestFile0010 = "/vissts/WebResource.axd" +
				"?d=EzMTcif0sakCI16AtuwGB1xlZZwqq8o7-6wc6bGfdjwNRZAoXaav2N0RaL8b4V0qBuMtgha-Ce944yKLjvyfIrbrOSi2zyIwy8WC9L0Y-G81" +
				"&t=635802997220000000";
		String requestHeader0010 = "GET " + requestFile0010 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: stsint.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0010, requestHost0010, requestPort0010, requestHeader0010, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0010 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [11] <- WEB ADMIN Index 11 ---
		String requestProt0011 = "https";
		String requestHost0011 = "stsint.abb.com";
		int    requestPort0011 = 443;
		String requestFile0011 = "/vissts/css_abb/bundles/_fifa.all/_fifa.all.fixes.css";
		String requestHeader0011 = "GET " + requestFile0011 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: stsint.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0011, requestHost0011, requestPort0011, requestHeader0011, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0011 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [12] <- WEB ADMIN Index 12 ---
		String requestProt0012 = "https";
		String requestHost0012 = "stsint.abb.com";
		int    requestPort0012 = 443;
		String requestFile0012 = "/vissts/css_abb/bundles/_fifa.all/_fifa.all.min.js";
		String requestHeader0012 = "GET " + requestFile0012 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: stsint.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0012, requestHost0012, requestPort0012, requestHeader0012, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0012 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [13] <- WEB ADMIN Index 13 ---
		String requestProt0013 = "https";
		String requestHost0013 = "stsint.abb.com";
		int    requestPort0013 = 443;
		String requestFile0013 = "/vissts/WebResource.axd" +
				"?d=4DHyHLSiX7LAK9tE0NjTldwatuCK-x2h-b4mq42k30GHdT0udXunF3yndHRuShtHXhK38h7j4q4xe40nIi9XkWjjV5nknrdyqjzezK5kUbo1" +
				"&t=635802997220000000";
		String requestHeader0013 = "GET " + requestFile0013 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: stsint.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0013, requestHost0013, requestPort0013, requestHeader0013, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0013 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [14] <- WEB ADMIN Index 14 ---
		String requestProt0014 = "https";
		String requestHost0014 = "stsint.abb.com";
		int    requestPort0014 = 443;
		String requestFile0014 = "/vissts/WebResource.axd" +
				"?d=2XAiJWeSDVXeSLVtNqDEZ-NyWqgr_cxbUUBUmlJJmLT9PyDDMtxja2s-3Wc2ZjyDBRID5Q8xzlZihlLxw_r0m76zUIa0YGMGTQ7Av5fG4hs1" +
				"&t=635802997220000000";
		String requestHeader0014 = "GET " + requestFile0014 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: stsint.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0014, requestHost0014, requestPort0014, requestHeader0014, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0014 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [15] <- WEB ADMIN Index 15 ---
		String requestProt0015 = "https";
		String requestHost0015 = "stsint.abb.com";
		int    requestPort0015 = 443;
		String requestFile0015 = "/vissts/css_abb/bundles/_fifa.all/fonts/HelveticaNeueeTextPro-Light.woff";
		String requestHeader0015 = "GET " + requestFile0015 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: stsint.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: identity\r\n" + 
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0015, requestHost0015, requestPort0015, requestHeader0015, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0015 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [16] <- WEB ADMIN Index 16 ---
		String requestProt0016 = "https";
		String requestHost0016 = "stsint.abb.com";
		int    requestPort0016 = 443;
		String requestFile0016 = "/vissts/css_abb/bundles/_fifa.all/fonts/abb-logo.svg";
		String requestHeader0016 = "GET " + requestFile0016 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: stsint.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0016, requestHost0016, requestPort0016, requestHeader0016, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0016 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/SVG+XML", header text fragment = [verification disabled], recorded content size = 6281
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/SVG+XML", null, null);		// Test [16] <- Index 16
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [17] <- WEB ADMIN Index 17 ---
		String requestProt0017 = "https";
		String requestHost0017 = "stsint.abb.com";
		int    requestPort0017 = 443;
		String requestFile0017 = "/vissts/css_spec/assets/stub-port-image.jpg";
		String requestHeader0017 = "GET " + requestFile0017 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: stsint.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0017, requestHost0017, requestPort0017, requestHeader0017, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0017 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [18] <- WEB ADMIN Index 18 ---
		String requestProt0018 = "https";
		String requestHost0018 = "stsint.abb.com";
		int    requestPort0018 = 443;
		String requestFile0018 = "/vissts/css_abb/bundles/_fifa.all/fonts/HelveticaNeueeTextPro-Md.woff";
		String requestHeader0018 = "GET " + requestFile0018 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: stsint.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: identity\r\n" + 
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0018, requestHost0018, requestPort0018, requestHeader0018, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0018 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [19] <- WEB ADMIN Index 19 ---
		String requestProt0019 = "http";
		String requestHost0019 = "new.abb.com";
		int    requestPort0019 = 80;
		String requestFile0019 = "/cdn/img/favicon32-web.png";
		String requestHeader0019 = "GET " + requestFile0019 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: new.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0019, requestHost0019, requestPort0019, requestHeader0019, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0019 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;


		// all http requests of page #1 successful done
		return true;
	}


	/**
	 * Recorded http requests of page #2.
	 *
	 * @return  true:  method successful completed.
	 *          false: method/loop failed.
	 */
	boolean executePage_2(int totalLoopCounter, LoadtestPluginContext loopPluginContext, InnerLoopContext innerLoopContext, Object httpLogVectorObject) throws Exception
	{
		// # Page #2: Login
		// # --------------



		// --- HTTP REQUEST: Test [21] <- WEB ADMIN Index 21 ---
		log();
		log("# title: Object moved");
		String requestProt0021 = "https";
		String requestHost0021 = "stsint.abb.com";
		int    requestPort0021 = 443;
		String requestFile0021 = "/vissts/public/BasicPages/LoginBasic.aspx" +
				"?ReturnUrl=%2fvissts%2fsts.aspx%3fwa%3dwsignin1.0%26wtrealm%3dhttp%253a%252f%252fstsint.abb.com%252fadfs%252fservices%252ftrust%26wctx%3df29eb6a3-5cdf-479c-a7e9-ed6e60508465%26wct%3d2016-12-20t10%253a16%253a00z" +
				"&wa=wsignin1.0" +
				"&wtrealm=http%3a%2f%2fstsint.abb.com%2fadfs%2fservices%2ftrust" +
				"&wctx=f29eb6a3-5cdf-479c-a7e9-ed6e60508465" +
				"&wct=2016-12-20t10%3a16%3a00z";
		String requestContent0021 = 
				"__LASTFOCUS=" +
				"&__EVENTTARGET=" +
				"&__EVENTARGUMENT=" +
				"&__VIEWSTATE=" + java.net.URLEncoder.encode(vVIEWSTATE) +		// recorded value = %2FwEPDwUKLTM5NjExMzYwNw9kFgICAw9kFiQCAQ8PFgIeBFRleHQFBkxvZyBpbmRkAgMPDxYCHwAF5AJSZXR1cm5Vcmw9JTJmdmlzc3RzJTJmc3RzLmFzcHglM2Z3YSUzZHdzaWduaW4xLjAlMjZ3dHJlYWxtJTNkaHR0cCUyNTNhJTI1MmYlMjUyZnN0c2ludC5hYmIuY29tJTI1MmZhZGZzJTI1MmZzZXJ2aWNlcyUyNTJmdHJ1c3QlMjZ3Y3R4JTNkZjI5ZWI2YTMtNWNkZi00NzljLWE3ZTktZWQ2ZTYwNTA4NDY1JTI2d2N0JTNkMjAxNi0xMi0yMHQxMCUyNTNhMTYlMjUzYTAweiZ3YT13c2lnbmluMS4wJnd0cmVhbG09aHR0cCUzYSUyZiUyZnN0c2ludC5hYmIuY29tJTJmYWRmcyUyZnNlcnZpY2VzJTJmdHJ1c3Qmd2N0eD1mMjllYjZhMy01Y2RmLTQ3OWMtYTdlOS1lZDZlNjA1MDg0NjUmd2N0PTIwMTYtMTItMjB0MTAlM2ExNiUzYTAwemRkAgUPDxYCHwAFxwElMmZ2aXNzdHMlMmZzdHMuYXNweCUzZndhJTNkd3NpZ25pbjEuMCUyNnd0cmVhbG0lM2RodHRwJTI1M2ElMjUyZiUyNTJmc3RzaW50LmFiYi5jb20lMjUyZmFkZnMlMjUyZnNlcnZpY2VzJTI1MmZ0cnVzdCUyNndjdHglM2RmMjllYjZhMy01Y2RmLTQ3OWMtYTdlOS1lZDZlNjA1MDg0NjUlMjZ3Y3QlM2QyMDE2LTEyLTIwdDEwJTI1M2ExNiUyNTNhMDB6ZGQCCQ8PFgIfAAUORS1tYWlsIGFkZHJlc3NkZAIND2QWAmYPDxYCHwAFHVlvdSBtdXN0IGVudGVyIGUtbWFpbCBhZGRyZXNzZGQCDw9kFgJmDw8WAh8ABSVZb3UgbXVzdCBwcm92aWRlIHZhbGlkIGVtYWlsIGFkZHJlc3MuZGQCEQ8PFgIfAAUIUGFzc3dvcmRkZAIVD2QWAmYPDxYCHwAFF1lvdSBtdXN0IGVudGVyIHBhc3N3b3JkZGQCFw8PFgIfAAUGdW5tYXNrZGQCGQ8PFgIfAAUFTG9naW5kZAIbDxYCHgRocmVmZGQCHQ8WAh8BBTNodHRwczovL3d3dy5hYmIuY29tL1VzZXIvUmVxdWVzdEZvcmdvdFBhc3N3b3JkLmFzcHgWAgIBDw8WAh8ABRVGb3Jnb3QgeW91ciBwYXNzd29yZD8WAh4LcmVzb3VyY2VLZXkFF1VJLkxvZ2luLkZvcmdvdFBhc3N3b3JkZAIfDw8WAh8ABRBOZWVkIGFuIGFjY291bnQ%2FZGQCIQ8WAh8BBS5odHRwczovL3d3dy5hYmIuY29tL1VzZXIvUmVnaXN0cmF0aW9uUGFnZS5hc3B4FgICAQ8PFgIfAAUIU2lnbiB1cCFkZAIjDw8WAh8ABR5Qcm92aWRlciBJbmZvcm1hdGlvbi9JbXByZXNzdW1kZAIlDw8WAh8ABRpDb29raWVzIGFuZCBwcml2YWN5IHBvbGljeWRkAicPDxYCHwAFElByZWZlcnJlZCBsYW5ndWFnZWRkAikPEGQPFiNmAgECAgIDAgQCBQIGAgcCCAIJAgoCCwIMAg0CDgIPAhACEQISAhMCFAIVAhYCFwIYAhkCGgIbAhwCHQIeAh8CIAIhAiIWIxAFBkFyYWJpYwUEMTAyNWcQBQlCdWxnYXJpYW4FBDEwMjZnEAUFQ3plY2gFBDEwMjlnEAUGRGFuaXNoBQQxMDMwZxAFBkdlcm1hbgUEMTAzMWcQBQVHcmVlawUEMTAzMmcQBQdFbmdsaXNoBQQxMDMzZxAFB1NwYW5pc2gFBDEwMzRnEAUHRmlubmlzaAUEMTAzNWcQBQZGcmVuY2gFBDEwMzZnEAUGSGVicmV3BQQxMDM3ZxAFCUh1bmdhcmlhbgUEMTAzOGcQBQdJdGFsaWFuBQQxMDQwZxAFCEphcGFuZXNlBQQxMDQxZxAFBktvcmVhbgUEMTA0MmcQBQVEdXRjaAUEMTA0M2cQBQlOb3J3ZWdpYW4FBDEwNDRnEAUGUG9saXNoBQQxMDQ1ZxAFCFJvbWFuaWFuBQQxMDQ4ZxAFB1J1c3NpYW4FBDEwNDlnEAUIQ3JvYXRpYW4FBDEwNTBnEAUGU2xvdmFrBQQxMDUxZxAFB1N3ZWRpc2gFBDEwNTNnEAUEVGhhaQUEMTA1NGcQBQdUdXJraXNoBQQxMDU1ZxAFCVVrcmFpbmlhbgUEMTA1OGcQBQlTbG92ZW5pYW4FBDEwNjBnEAUIRXN0b25pYW4FBDEwNjFnEAUHTGF0dmlhbgUEMTA2MmcQBQpMaXRodWFuaWFuBQQxMDYzZxAFB1BlcnNpYW4FBDEwNjVnEAUKVmlldG5hbWVzZQUEMTA2NmcQBRJDaGluZXNlIFNpbXBsaWZpZWQFBDIwNTJnEAUKUG9ydHVndWVzZQUEMjA3MGcQBRNDaGluZXNlIFRyYWRpdGlvbmFsBQUzMTc0OGcWAQIGZGSBXq0wc%2FZ4XqeS%2FiQm9BjKNYJMHI7TQ%2Fj2L8eDa9Cz%2FA%3D%3D
				"&__VIEWSTATEGENERATOR=" + vVIEWSTATEGENERATOR +		// recorded value = 9333DAF3
				"&__EVENTVALIDATION=" + java.net.URLEncoder.encode(vEVENTVALIDATION) +		// recorded value = %2FwEdACm3CLaiLBYH3%2BRaPY0kTkxBVK7BrRAtEiqu9nGFEI%2BjB3Y2%2BMc6SrnAqio3oCKbxYY85pbWlDO2hADfoPXD%2F5tdd9DWhICYo6sOpkGpIzIKzK6kzfFnmEDmUoYjmX3HfXt0ArrMpJHqMpvN7H76vx6ULpWbmVO3wqowOSESFccQH8AS0HPYrMvqXZc0LkYvqE8VmvASjMcfDWd4wOnR6K0l%2BvphdUnkKGrDlX05SiKOd1G0ZrUo0X%2FvCwq5tnDMl9jxaugKz1XfkUBebVE0Hx%2FINVDThD20RQkmH6G2uEhtQQSwCCJ8GTxX66Lvudb330amIxmiiGYZK%2B7nmMfVyyWhGkKju3NiCmYzB1lDfuOLuL8EY%2BujUQKrELQq24t48OobwfTn0mwzGyiT4VeMtwFvgLeOINUfNWgB63hd7OG4hoZ3R6M5vQAiquJ7aZyXzGp3nQSyhH%2Fs83YLFUjVW77S6EyHCQ9Y1dYDyAwb%2BnUgYxHjtnWfJkF9Tb9RD%2FHffSAkvJfAeSMhO0haucUb%2FShOZ%2Bn6h59hztKTqIqhwM8Tmso8t68eAwSmtST2g0Le4G2%2BCtaPCcYqdt6NbsGk5wvu46lXf9YpaQA871VY8A78QS%2BLn9IwrnNKFy6dAYnf35hAC%2Bkssw9QbB4cTffeqeQodn8N1icK0TqOTkyjig1ZyjinKHG0JiIhDGpllGVrWiDVQ5F2XlQ6mDmoIwfrzJCHT3ycP13a6ngwGCmbLWwWyzy4cVdKRXV2qB%2FNKmtUWZFpIOsTlzX%2BdbyZSP%2BxlW9YE406D2ZfT9z%2FBLKq%2BRAZgW%2BSek9X7oJDxGqpClP4RRlw72pE%2BjSQQo8G%2FLwmKUz8ozoUWGaxZlwLC8due01Cq%2B75Vd0bh%2BlZ771JDs9PbExpIuQr1Al3fAQheNLJtMdI
				"&txtUsername=mcp.test.ari%40gmail.com" +
				"&txtPassword=%23Mcptestsession2" +
				"&btnSubmit=Login" +
				"&ddlLanguages=1033";
		String requestHeader0021 = "POST " + requestFile0021 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: stsint.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"Upgrade-Insecure-Requests: 1\r\n" + 
				"Content-Type: application/x-www-form-urlencoded\r\n" + 
				"Content-Length: " + requestContent0021.length() + "\r\n" + 		// Content-Length: 3812
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0021, requestHost0021, requestPort0021, requestHeader0021, requestContent0021.getBytes(), requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		if (debugLoops)
		{
			if (Lib.isAsciiContent(testURL.getRequestContent(), 256))
				log(">>> " + new String(testURL.getRequestContent()));
			else
				log(">>> [binary data]");
		}

		testURL.execute(performanceData);
		requestHeader0021 = null;		// support garbage collector to reduce memory
		requestContent0021 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 302, content type = [verification disabled], header text fragment = [verification disabled], recorded content size = 510
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {302}, null, null, null);		// Test [21] <- Index 21
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// extract variable(s) from response
		htmlContentParser = new HtmlContentParser(testURL, this);
		try
		{
			// extract var 'rider7'
			rider7 = testURL.getHeaderField("Location");		// recorded value = /vissts/default.aspx?ReturnUrl=%2fvissts%2fsts.aspx%3fwa%3dwsignin1.0%26wtrealm%3dhttp%253a%252f%252fstsint.abb.com%252fadfs%252fservices%252ftrust%26wctx%3df29eb6a3-5cdf-479c-a7e9-ed6e60508465%26wct%3d2016-12-20t10%253a16%253a00z&wa=wsignin1.0&wtrealm=http%3a%2f%2fstsint.abb.com%2fadfs%2fservices%2ftrust&wctx=f29eb6a3-5cdf-479c-a7e9-ed6e60508465&wct=2016-12-20t10%3a16%3a00z
			log("<<< rider7 = " + rider7);
		}
		catch (Exception e) { rider7 = null; log(e); }
		if (rider7 == null)
		{
			// failure - dump wrong response content and abort current outer loop - after that start next loop
			String errorText = "*** error: unable to extract var 'rider7' from http response header field";
			log(errorText);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			threadStep = performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_USER_SPECIFIC_TEST_FAILED, errorText, testURL, this);
		
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [22] <- WEB ADMIN Index 22 ---
		log();
		log("# title: Object moved");
		String requestProt0022 = "https";
		String requestHost0022 = "stsint.abb.com";
		int    requestPort0022 = 443;
		String requestFile0022 = "/vissts/default.aspx" +
				"?ReturnUrl=%2fvissts%2fsts.aspx%3fwa%3dwsignin1.0%26wtrealm%3dhttp%253a%252f%252fstsint.abb.com%252fadfs%252fservices%252ftrust%26wctx%3df29eb6a3-5cdf-479c-a7e9-ed6e60508465%26wct%3d2016-12-20t10%253a16%253a00z" +
				"&wa=wsignin1.0" +
				"&wtrealm=http%3a%2f%2fstsint.abb.com%2fadfs%2fservices%2ftrust" +
				"&wctx=f29eb6a3-5cdf-479c-a7e9-ed6e60508465" +
				"&wct=2016-12-20t10%3a16%3a00z";
		requestFile0022 = Lib.replaceTextPattern(requestFile0022, "/vissts/default.aspx?ReturnUrl=%2fvissts%2fsts.aspx%3fwa%3dwsignin1.0%26wtrealm%3dhttp%253a%252f%252fstsint.abb.com%252fadfs%252fservices%252ftrust%26wctx%3df29eb6a3-5cdf-479c-a7e9-ed6e60508465%26wct%3d2016-12-20t10%253a16%253a00z&wa=wsignin1.0&wtrealm=http%3a%2f%2fstsint.abb.com%2fadfs%2fservices%2ftrust&wctx=f29eb6a3-5cdf-479c-a7e9-ed6e60508465&wct=2016-12-20t10%3a16%3a00z", rider7, 0);		// search and replace request file fragment "/vissts/default.aspx?ReturnUrl=%2fvissts%2fsts.aspx%3fwa%3dwsignin1.0%26wtrealm%3dhttp%253a%252f%252fstsint.abb.com%252fadfs%252fservices%252ftrust%26wctx%3df29eb6a3-5cdf-479c-a7e9-ed6e60508465%26wct%3d2016-12-20t10%253a16%253a00z&wa=wsignin1.0&wtrealm=http%3a%2f%2fstsint.abb.com%2fadfs%2fservices%2ftrust&wctx=f29eb6a3-5cdf-479c-a7e9-ed6e60508465&wct=2016-12-20t10%3a16%3a00z" with variable 'rider7' on all occurrences

		String requestHeader0022 = "GET " + requestFile0022 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: stsint.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"Upgrade-Insecure-Requests: 1\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0022, requestHost0022, requestPort0022, requestHeader0022, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0022 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 302, content type = [verification disabled], header text fragment = [verification disabled], recorded content size = 506
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {302}, null, null, null);		// Test [22] <- Index 22
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// extract variable(s) from response
		htmlContentParser = new HtmlContentParser(testURL, this);
		try
		{
			// extract var 'rider8'
			rider8 = testURL.getHeaderField("Location");		// recorded value = /vissts/sts.aspx?ReturnUrl=%2fvissts%2fsts.aspx%3fwa%3dwsignin1.0%26wtrealm%3dhttp%253a%252f%252fstsint.abb.com%252fadfs%252fservices%252ftrust%26wctx%3df29eb6a3-5cdf-479c-a7e9-ed6e60508465%26wct%3d2016-12-20t10%253a16%253a00z&wa=wsignin1.0&wtrealm=http%3a%2f%2fstsint.abb.com%2fadfs%2fservices%2ftrust&wctx=f29eb6a3-5cdf-479c-a7e9-ed6e60508465&wct=2016-12-20t10%3a16%3a00z
			log("<<< rider8 = " + rider8);
		}
		catch (Exception e) { rider8 = null; log(e); }
		if (rider8 == null)
		{
			// failure - dump wrong response content and abort current outer loop - after that start next loop
			String errorText = "*** error: unable to extract var 'rider8' from http response header field";
			log(errorText);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			threadStep = performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_USER_SPECIFIC_TEST_FAILED, errorText, testURL, this);
		
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [23] <- WEB ADMIN Index 23 ---
		log();
		log("# title: Working...");
		String requestProt0023 = "https";
		String requestHost0023 = "stsint.abb.com";
		int    requestPort0023 = 443;
		String requestFile0023 = "/vissts/sts.aspx" +
				"?ReturnUrl=%2fvissts%2fsts.aspx%3fwa%3dwsignin1.0%26wtrealm%3dhttp%253a%252f%252fstsint.abb.com%252fadfs%252fservices%252ftrust%26wctx%3df29eb6a3-5cdf-479c-a7e9-ed6e60508465%26wct%3d2016-12-20t10%253a16%253a00z" +
				"&wa=wsignin1.0" +
				"&wtrealm=http%3a%2f%2fstsint.abb.com%2fadfs%2fservices%2ftrust" +
				"&wctx=f29eb6a3-5cdf-479c-a7e9-ed6e60508465" +
				"&wct=2016-12-20t10%3a16%3a00z";
		requestFile0023 = Lib.replaceTextPattern(requestFile0023, "/vissts/sts.aspx?ReturnUrl=%2fvissts%2fsts.aspx%3fwa%3dwsignin1.0%26wtrealm%3dhttp%253a%252f%252fstsint.abb.com%252fadfs%252fservices%252ftrust%26wctx%3df29eb6a3-5cdf-479c-a7e9-ed6e60508465%26wct%3d2016-12-20t10%253a16%253a00z&wa=wsignin1.0&wtrealm=http%3a%2f%2fstsint.abb.com%2fadfs%2fservices%2ftrust&wctx=f29eb6a3-5cdf-479c-a7e9-ed6e60508465&wct=2016-12-20t10%3a16%3a00z", rider8, 0);		// search and replace request file fragment "/vissts/sts.aspx?ReturnUrl=%2fvissts%2fsts.aspx%3fwa%3dwsignin1.0%26wtrealm%3dhttp%253a%252f%252fstsint.abb.com%252fadfs%252fservices%252ftrust%26wctx%3df29eb6a3-5cdf-479c-a7e9-ed6e60508465%26wct%3d2016-12-20t10%253a16%253a00z&wa=wsignin1.0&wtrealm=http%3a%2f%2fstsint.abb.com%2fadfs%2fservices%2ftrust&wctx=f29eb6a3-5cdf-479c-a7e9-ed6e60508465&wct=2016-12-20t10%3a16%3a00z" with variable 'rider8' on all occurrences

		String requestHeader0023 = "GET " + requestFile0023 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: stsint.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"Upgrade-Insecure-Requests: 1\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0023, requestHost0023, requestPort0023, requestHeader0023, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0023 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 9127
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, null);		// Test [23] <- Index 23
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// extract variable(s) from response
		htmlContentParser = new HtmlContentParser(testURL, this);
		try
		{
			// extract var 'vWctx'
			vWctx = htmlContentParser.getFormTable().getForm("hiddenform").getFormItemValue("wctx");		// recorded value = f29eb6a3-5cdf-479c-a7e9-ed6e60508465
			log("<<< vWctx = " + vWctx);
		}
		catch (Exception e) { vWctx = null; log(e); }
		if (vWctx == null)
		{
			// failure - dump wrong response content and abort current outer loop - after that start next loop
			String errorText = "*** error: unable to extract var 'vWctx' from html form parameter";
			log(errorText);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			threadStep = performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_USER_SPECIFIC_TEST_FAILED, errorText, testURL, this);
		
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		try
		{
			// extract var 'vWresult'
			vWresult = htmlContentParser.getFormTable().getForm("hiddenform").getFormItemValue("wresult");		// recorded value = <t:RequestSecurityTokenResponse Context=\"f29eb6a3-5cdf-479c-a7e9-ed6e60508465\" xmlns:t=\"http://schemas.xmlsoap.org/ws/2005/02/trust\"><t:Lifetime><wsu:Created xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\">2016-12-20T10:17:13.481Z</wsu:Created><wsu:Expires xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\">2016-12-20T18:17:13.481Z</wsu:Expires></t:Lifetime><wsp:AppliesTo xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><wsa:EndpointReference xmlns:wsa=\"http://www.w3.org/2005/08/addressing\"><wsa:Address>http://stsint.abb.com/adfs/services/trust</wsa:Address></wsa:EndpointReference></wsp:AppliesTo><t:RequestedSecurityToken><saml:Assertion MajorVersion=\"1\" MinorVersion=\"1\" AssertionID=\"_0decb845-69cf-40bc-95bc-50f15ebf86f2\" Issuer=\"https://stsint.abb.com/vissts\" IssueInstant=\"2016-12-20T10:17:13.496Z\" xmlns:saml=\"urn:oasis:names:tc:SAML:1.0:assertion\"><saml:Conditions NotBefore=\"2016-12-20T10:17:13.481Z\" NotOnOrAfter=\"2016-12-20T18:17:13.481Z\"><saml:AudienceRestrictionCondition><saml:Audience>http://stsint.abb.com/adfs/services/trust</saml:Audience></saml:AudienceRestrictionCondition></saml:Conditions><saml:AttributeStatement><saml:Subject><saml:NameIdentifier Format=\"urn:oasis:names:tc:SAML:1.1:nameid-format:unspecified\">7D6jICuQMUSD+KNdnKEPdA==</saml:NameIdentifier><saml:SubjectConfirmation><saml:ConfirmationMethod>urn:oasis:names:tc:SAML:1.0:cm:bearer</saml:ConfirmationMethod></saml:SubjectConfirmation></saml:Subject><saml:Attribute AttributeName=\"ImmutableID\" AttributeNamespace=\"http://schemas.microsoft.com/LiveID/Federation/2008/05\"><saml:AttributeValue>7D6jICuQMUSD+KNdnKEPdA==</saml:AttributeValue></saml:Attribute><saml:Attribute AttributeName=\"emailaddress\" AttributeNamespace=\"http://schemas.xmlsoap.org/ws/2005/05/identity/claims\"><saml:AttributeValue>mcp.test.ari@gmail.com</saml:AttributeValue></saml:Attribute><saml:Attribute AttributeName=\"upn\" AttributeNamespace=\"http://schemas.xmlsoap.org/ws/2005/05/identity/claims\"><saml:AttributeValue>mcp.test.ari@gmail.com</saml:AttributeValue></saml:Attribute><saml:Attribute AttributeName=\"UPN\" AttributeNamespace=\"http://schemas.xmlsoap.org/claims\"><saml:AttributeValue>mcp.test.ari@gmail.com</saml:AttributeValue></saml:Attribute></saml:AttributeStatement><saml:AuthenticationStatement AuthenticationMethod=\"urn:federation:authentication:windows\" AuthenticationInstant=\"2016-12-20T10:17:13.496Z\"><saml:Subject><saml:NameIdentifier Format=\"urn:oasis:names:tc:SAML:1.1:nameid-format:unspecified\">7D6jICuQMUSD+KNdnKEPdA==</saml:NameIdentifier><saml:SubjectConfirmation><saml:ConfirmationMethod>urn:oasis:names:tc:SAML:1.0:cm:bearer</saml:ConfirmationMethod></saml:SubjectConfirmation></saml:Subject></saml:AuthenticationStatement><Signature xmlns=\"http://www.w3.org/2000/09/xmldsig#\"><SignedInfo><CanonicalizationMethod Algorithm=\"http://www.w3.org/2001/10/xml-exc-c14n#\" /><SignatureMethod Algorithm=\"http://www.w3.org/2001/04/xmldsig-more#rsa-sha256\" /><Reference URI=\"#_0decb845-69cf-40bc-95bc-50f15ebf86f2\"><Transforms><Transform Algorithm=\"http://www.w3.org/2000/09/xmldsig#enveloped-signature\" /><Transform Algorithm=\"http://www.w3.org/2001/10/xml-exc-c14n#\" /></Transforms><DigestMethod Algorithm=\"http://www.w3.org/2001/04/xmlenc#sha256\" /><DigestValue>VFBSCSx2qBCpgJWHEQwe1vFQZmX0fjsZKss1s9szsd4=</DigestValue></Reference></SignedInfo><SignatureValue>YiJTCz9EWRy2kfLKFLDGXCTRjyIKBo9bpUei33YEusLlj8SDWbp90t7whM5E6z+6zcBPPipvRaN9YHzHR9tmL87mGXo8F23MYpv+XmzdkMAzSh8B2kAKQToKaDCQOhizy76RWsLZX2SSOzRauphLVykpVI02RZn7gcQUciAkXw6Dna7KpmjD2LD6dMleFgr0S4H+pCD6l4DbNPNhHtw7B3W97s/+IXjnZ4AaLhW2jNYWudhBgcg84YDmdeUJCX316RDc1N4VcxkvSeXwumciZheoPzh0FNYCyRCjYBxBm6vfivR3jdAJcsePs20O0C1obJNEjiefsVKzKVxqcRdegA==</SignatureValue><KeyInfo><X509Data><X509Certificate>MIIHqzCCBpOgAwIBAgIKOFbvRQADAAF6LDANBgkqhkiG9w0BAQsFADBTMRMwEQYKCZImiZPyLGQBGRYDQ09NMRMwEQYKCZImiZPyLGQBGRYDQUJCMQwwCgYDVQQKEwNBQkIxGTAXBgNVBAMTEEFCQiBJc3N1aW5nIENBIDMwHhcNMTUwNzAxMjEyNzA5WhcNMjAwNTE0MTYwNjQ2WjB1MQswCQYDVQQGEwJDSDEOMAwGA1UEBxMFQmFkZW4xJTAjBgNVBAoTHEFCQiBJbmZvcm1hdGlvbiBTeXN0ZW1zIEx0ZC4xFjAUBgNVBAsTDUFEIEZTIFNpZ25pbmcxFzAVBgNVBAMTDnN0c2ludC5hYmIuY29tMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAuERLBSH7XVVVijsIP+YctHDxWTmpbfGjoeRFWqbyMKKxiEVLdADUGGDicrwV61FaDlCZhs9Jt23kB5yTR2474wmbX5Mf5VNBC4sEcopLqRe2IE7yaANfS8T7CeBOU/7F2yvoAJSsmYF9P1g2Iqyq0Z/BdBU3ygrDIaqp/vnAm4TGGxD29+f0XHyAvLgeFwsoQVsAlPIkh0nhi5wR62b7hM41iy0pK8hu0fBbUl3SCv9WCg/Bj0TxIXMAIOS1UaLDpyzpNFNV1MZKGF9YkSN/Fp4X/WEepx7SwWxw51WYZeGg3i2kSnGkniWNULgvMMLJK/vlYRhymEZMi/nTaE9y8wIDAQABo4IEXTCCBFkwCwYDVR0PBAQDAgWgMB0GA1UdDgQWBBTHsnHIQKViab0y2kh2vLPv6ax4OjAmBgNVHREEHzAdghtBREZTLVNpZ25pbmctU1RTSU5ULmFiYi5jb20wHwYDVR0jBBgwFoAUq5M6ES29PZ/ozYvFtNpEJv+ADYcwggFrBgNVHR8EggFiMIIBXjCCAVqgggFWoIIBUoYraHR0cDovL2NybC5wa2kuYWJiLmNvbS9BQkJJc3N1aW5nQ0EzKDMpLmNybIaBqGxkYXA6Ly8vQ049QUJCSXNzdWluZ0NBMygzKSxDTj1DRFAsQ049UHVibGljJTIwS2V5JTIwU2VydmljZXMsQ049U2VydmljZXMsQ049Q29uZmlndXJhdGlvbixEQz1hYmIsREM9Y29tP2NlcnRpZmljYXRlUmV2b2NhdGlvbkxpc3Q/YmFzZT9vYmplY3RDbGFzcz1jUkxEaXN0cmlidXRpb25Qb2ludIZ4bGRhcDovL2NybC5wa2kuYWJiLmNvbS9DTj1BQkJJc3N1aW5nQ0EzKDMpLENOPUNEUCxDTj1QS0k/Y2VydGlmaWNhdGVSZXZvY2F0aW9uTGlzdD9iYXNlP29iamVjdENsYXNzPWNSTERpc3RyaWJ1dGlvblBvaW50MIIBmAYIKwYBBQUHAQEEggGKMIIBhjA3BggrBgEFBQcwAoYraHR0cDovL2FpYS5wa2kuYWJiLmNvbS9BQkJJc3N1aW5nQ0EzKDMpLmNydDCBqAYIKwYBBQUHMAKGgZtsZGFwOi8vL0NOPUFCQklzc3VpbmdDQTMsQ049QUlBLENOPVB1YmxpYyUyMEtleSUyMFNlcnZpY2VzLENOPVNlcnZpY2VzLENOPUNvbmZpZ3VyYXRpb24sREM9YWJiLERDPWNvbT9jQUNlcnRpZmljYXRlP2Jhc2U/b2JqZWN0Q2xhc3M9Y2VydGlmaWNhdGlvbkF1dGhvcml0eTB3BggrBgEFBQcwAoZrbGRhcDovL2FpYS5wa2kuYWJiLmNvbS9DTj1BQkJJc3N1aW5nQ0EzLENOPUFJQSxDTj1QS0k/Y0FDZXJ0aWZpY2F0ZT9iYXNlP29iamVjdENsYXNzPWNlcnRpZmljYXRpb25BdXRob3JpdHkwJwYIKwYBBQUHMAGGG2h0dHA6Ly9haWEucGtpLmFiYi5jb20vb2NzcDA8BgkrBgEEAYI3FQcELzAtBiUrBgEEAYI3FQjHqCaGsIR6hrWLCoLqjWqEj60hKYGNt0iD7+tTAgFkAgENMB0GA1UdJQQWMBQGCCsGAQUFBwMCBggrBgEFBQcDATBRBgNVHSAESjBIMEYGDCsGAQQBgdcHAR4KAjA2MDQGCCsGAQUFBwIBFihodHRwOi8vY3AucGtpLmFiYi5jb20vU1NMU2VydmVySW50ZXJuYWwvMCcGCSsGAQQBgjcVCgQaMBgwCgYIKwYBBQUHAwIwCgYIKwYBBQUHAwEwDQYJKoZIhvcNAQELBQADggEBABnaaISWCQ5stI9VUa+OqZNZeFvXyTyaM1VSyqIaEt55K8H5ts7Lte6BcBddjTxQuxRrSYRGzxA2An0SFD79/IhFy07Et0psPNaciWq7yhkIHWO2XeBfKWietIb78Ose98su1jgdyzf7UqSa8EZu6rrPzGab285WBEKCYaOY9746lFOmChUh9af+X+0AdN99SglGLL5/1qSHgFZL5+MHbeaXZ8HJwjG2bIEBtZM5ydoJi+cKGpidhh9UJjwpzXBLsCVzPr/ZYjozVhJYgpY8Rx9z4+80r2YslbByd8KphT+KV9LMFc06CW4/yz91lyXpE19Iwyyrr3TRuJ1AYYuQWFs=</X509Certificate></X509Data></KeyInfo></Signature></saml:Assertion></t:RequestedSecurityToken><t:RequestedAttachedReference><o:SecurityTokenReference k:TokenType=\"http://docs.oasis-open.org/wss/oasis-wss-saml-token-profile-1.1#SAMLV1.1\" xmlns:k=\"http://docs.oasis-open.org/wss/oasis-wss-wssecurity-secext-1.1.xsd\" xmlns:o=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\"><o:KeyIdentifier ValueType=\"http://docs.oasis-open.org/wss/oasis-wss-saml-token-profile-1.0#SAMLAssertionID\">_0decb845-69cf-40bc-95bc-50f15ebf86f2</o:KeyIdentifier></o:SecurityTokenReference></t:RequestedAttachedReference><t:RequestedUnattachedReference><o:SecurityTokenReference k:TokenType=\"http://docs.oasis-open.org/wss/oasis-wss-saml-token-profile-1.1#SAMLV1.1\" xmlns:k=\"http://docs.oasis-open.org/wss/oasis-wss-wssecurity-secext-1.1.xsd\" xmlns:o=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\"><o:KeyIdentifier ValueType=\"http://docs.oasis-open.org/wss/oasis-wss-saml-token-profile-1.0#SAMLAssertionID\">_0decb845-69cf-40bc-95bc-50f15ebf86f2</o:KeyIdentifier></o:SecurityTokenReference></t:RequestedUnattachedReference><t:TokenType>urn:oasis:names:tc:SAML:1.0:assertion</t:TokenType><t:RequestType>http://schemas.xmlsoap.org/ws/2005/02/trust/Issue</t:RequestType><t:KeyType>http://schemas.xmlsoap.org/ws/2005/05/identity/NoProofKey</t:KeyType></t:RequestSecurityTokenResponse>
			log("<<< vWresult = " + vWresult);
		}
		catch (Exception e) { vWresult = null; log(e); }
		if (vWresult == null)
		{
			// failure - dump wrong response content and abort current outer loop - after that start next loop
			String errorText = "*** error: unable to extract var 'vWresult' from html form parameter";
			log(errorText);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			threadStep = performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_USER_SPECIFIC_TEST_FAILED, errorText, testURL, this);
		
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		try
		{
			// extract var 'vWa'
			vWa = htmlContentParser.getFormTable().getForm("hiddenform").getFormItemValue("wa");		// recorded value = wsignin1.0
			log("<<< vWa = " + vWa);
		}
		catch (Exception e) { vWa = null; log(e); }
		if (vWa == null)
		{
			// failure - dump wrong response content and abort current outer loop - after that start next loop
			String errorText = "*** error: unable to extract var 'vWa' from html form parameter";
			log(errorText);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			threadStep = performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_USER_SPECIFIC_TEST_FAILED, errorText, testURL, this);
		
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [24] <- WEB ADMIN Index 24 ---
		log();
		log("# title: Working...");
		String requestProt0024 = "https";
		String requestHost0024 = "stsint.abb.com";
		int    requestPort0024 = 443;
		String requestFile0024 = "/adfs/ls/";
		String requestContent0024 = 
				"wa=" + java.net.URLEncoder.encode(vWa) +		// recorded value = wsignin1.0
				"&wresult=" + java.net.URLEncoder.encode(vWresult) +		// recorded value = %3Ct%3ARequestSecurityTokenResponse+Context%3D%22f29eb6a3-5cdf-479c-a7e9-ed6e60508465%22+xmlns%3At%3D%22http%3A%2F%2Fschemas.xmlsoap.org%2Fws%2F2005%2F02%2Ftrust%22%3E%3Ct%3ALifetime%3E%3Cwsu%3ACreated+xmlns%3Awsu%3D%22http%3A%2F%2Fdocs.oasis-open.org%2Fwss%2F2004%2F01%2Foasis-200401-wss-wssecurity-utility-1.0.xsd%22%3E2016-12-20T10%3A17%3A13.481Z%3C%2Fwsu%3ACreated%3E%3Cwsu%3AExpires+xmlns%3Awsu%3D%22http%3A%2F%2Fdocs.oasis-open.org%2Fwss%2F2004%2F01%2Foasis-200401-wss-wssecurity-utility-1.0.xsd%22%3E2016-12-20T18%3A17%3A13.481Z%3C%2Fwsu%3AExpires%3E%3C%2Ft%3ALifetime%3E%3Cwsp%3AAppliesTo+xmlns%3Awsp%3D%22http%3A%2F%2Fschemas.xmlsoap.org%2Fws%2F2004%2F09%2Fpolicy%22%3E%3Cwsa%3AEndpointReference+xmlns%3Awsa%3D%22http%3A%2F%2Fwww.w3.org%2F2005%2F08%2Faddressing%22%3E%3Cwsa%3AAddress%3Ehttp%3A%2F%2Fstsint.abb.com%2Fadfs%2Fservices%2Ftrust%3C%2Fwsa%3AAddress%3E%3C%2Fwsa%3AEndpointReference%3E%3C%2Fwsp%3AAppliesTo%3E%3Ct%3ARequestedSecurityToken%3E%3Csaml%3AAssertion+MajorVersion%3D%221%22+MinorVersion%3D%221%22+AssertionID%3D%22_0decb845-69cf-40bc-95bc-50f15ebf86f2%22+Issuer%3D%22https%3A%2F%2Fstsint.abb.com%2Fvissts%22+IssueInstant%3D%222016-12-20T10%3A17%3A13.496Z%22+xmlns%3Asaml%3D%22urn%3Aoasis%3Anames%3Atc%3ASAML%3A1.0%3Aassertion%22%3E%3Csaml%3AConditions+NotBefore%3D%222016-12-20T10%3A17%3A13.481Z%22+NotOnOrAfter%3D%222016-12-20T18%3A17%3A13.481Z%22%3E%3Csaml%3AAudienceRestrictionCondition%3E%3Csaml%3AAudience%3Ehttp%3A%2F%2Fstsint.abb.com%2Fadfs%2Fservices%2Ftrust%3C%2Fsaml%3AAudience%3E%3C%2Fsaml%3AAudienceRestrictionCondition%3E%3C%2Fsaml%3AConditions%3E%3Csaml%3AAttributeStatement%3E%3Csaml%3ASubject%3E%3Csaml%3ANameIdentifier+Format%3D%22urn%3Aoasis%3Anames%3Atc%3ASAML%3A1.1%3Anameid-format%3Aunspecified%22%3E7D6jICuQMUSD%2BKNdnKEPdA%3D%3D%3C%2Fsaml%3ANameIdentifier%3E%3Csaml%3ASubjectConfirmation%3E%3Csaml%3AConfirmationMethod%3Eurn%3Aoasis%3Anames%3Atc%3ASAML%3A1.0%3Acm%3Abearer%3C%2Fsaml%3AConfirmationMethod%3E%3C%2Fsaml%3ASubjectConfirmation%3E%3C%2Fsaml%3ASubject%3E%3Csaml%3AAttribute+AttributeName%3D%22ImmutableID%22+AttributeNamespace%3D%22http%3A%2F%2Fschemas.microsoft.com%2FLiveID%2FFederation%2F2008%2F05%22%3E%3Csaml%3AAttributeValue%3E7D6jICuQMUSD%2BKNdnKEPdA%3D%3D%3C%2Fsaml%3AAttributeValue%3E%3C%2Fsaml%3AAttribute%3E%3Csaml%3AAttribute+AttributeName%3D%22emailaddress%22+AttributeNamespace%3D%22http%3A%2F%2Fschemas.xmlsoap.org%2Fws%2F2005%2F05%2Fidentity%2Fclaims%22%3E%3Csaml%3AAttributeValue%3Emcp.test.ari%40gmail.com%3C%2Fsaml%3AAttributeValue%3E%3C%2Fsaml%3AAttribute%3E%3Csaml%3AAttribute+AttributeName%3D%22upn%22+AttributeNamespace%3D%22http%3A%2F%2Fschemas.xmlsoap.org%2Fws%2F2005%2F05%2Fidentity%2Fclaims%22%3E%3Csaml%3AAttributeValue%3Emcp.test.ari%40gmail.com%3C%2Fsaml%3AAttributeValue%3E%3C%2Fsaml%3AAttribute%3E%3Csaml%3AAttribute+AttributeName%3D%22UPN%22+AttributeNamespace%3D%22http%3A%2F%2Fschemas.xmlsoap.org%2Fclaims%22%3E%3Csaml%3AAttributeValue%3Emcp.test.ari%40gmail.com%3C%2Fsaml%3AAttributeValue%3E%3C%2Fsaml%3AAttribute%3E%3C%2Fsaml%3AAttributeStatement%3E%3Csaml%3AAuthenticationStatement+AuthenticationMethod%3D%22urn%3Afederation%3Aauthentication%3Awindows%22+AuthenticationInstant%3D%222016-12-20T10%3A17%3A13.496Z%22%3E%3Csaml%3ASubject%3E%3Csaml%3ANameIdentifier+Format%3D%22urn%3Aoasis%3Anames%3Atc%3ASAML%3A1.1%3Anameid-format%3Aunspecified%22%3E7D6jICuQMUSD%2BKNdnKEPdA%3D%3D%3C%2Fsaml%3ANameIdentifier%3E%3Csaml%3ASubjectConfirmation%3E%3Csaml%3AConfirmationMethod%3Eurn%3Aoasis%3Anames%3Atc%3ASAML%3A1.0%3Acm%3Abearer%3C%2Fsaml%3AConfirmationMethod%3E%3C%2Fsaml%3ASubjectConfirmation%3E%3C%2Fsaml%3ASubject%3E%3C%2Fsaml%3AAuthenticationStatement%3E%3CSignature+xmlns%3D%22http%3A%2F%2Fwww.w3.org%2F2000%2F09%2Fxmldsig%23%22%3E%3CSignedInfo%3E%3CCanonicalizationMethod+Algorithm%3D%22http%3A%2F%2Fwww.w3.org%2F2001%2F10%2Fxml-exc-c14n%23%22+%2F%3E%3CSignatureMethod+Algorithm%3D%22http%3A%2F%2Fwww.w3.org%2F2001%2F04%2Fxmldsig-more%23rsa-sha256%22+%2F%3E%3CReference+URI%3D%22%23_0decb845-69cf-40bc-95bc-50f15ebf86f2%22%3E%3CTransforms%3E%3CTransform+Algorithm%3D%22http%3A%2F%2Fwww.w3.org%2F2000%2F09%2Fxmldsig%23enveloped-signature%22+%2F%3E%3CTransform+Algorithm%3D%22http%3A%2F%2Fwww.w3.org%2F2001%2F10%2Fxml-exc-c14n%23%22+%2F%3E%3C%2FTransforms%3E%3CDigestMethod+Algorithm%3D%22http%3A%2F%2Fwww.w3.org%2F2001%2F04%2Fxmlenc%23sha256%22+%2F%3E%3CDigestValue%3EVFBSCSx2qBCpgJWHEQwe1vFQZmX0fjsZKss1s9szsd4%3D%3C%2FDigestValue%3E%3C%2FReference%3E%3C%2FSignedInfo%3E%3CSignatureValue%3EYiJTCz9EWRy2kfLKFLDGXCTRjyIKBo9bpUei33YEusLlj8SDWbp90t7whM5E6z%2B6zcBPPipvRaN9YHzHR9tmL87mGXo8F23MYpv%2BXmzdkMAzSh8B2kAKQToKaDCQOhizy76RWsLZX2SSOzRauphLVykpVI02RZn7gcQUciAkXw6Dna7KpmjD2LD6dMleFgr0S4H%2BpCD6l4DbNPNhHtw7B3W97s%2F%2BIXjnZ4AaLhW2jNYWudhBgcg84YDmdeUJCX316RDc1N4VcxkvSeXwumciZheoPzh0FNYCyRCjYBxBm6vfivR3jdAJcsePs20O0C1obJNEjiefsVKzKVxqcRdegA%3D%3D%3C%2FSignatureValue%3E%3CKeyInfo%3E%3CX509Data%3E%3CX509Certificate%3EMIIHqzCCBpOgAwIBAgIKOFbvRQADAAF6LDANBgkqhkiG9w0BAQsFADBTMRMwEQYKCZImiZPyLGQBGRYDQ09NMRMwEQYKCZImiZPyLGQBGRYDQUJCMQwwCgYDVQQKEwNBQkIxGTAXBgNVBAMTEEFCQiBJc3N1aW5nIENBIDMwHhcNMTUwNzAxMjEyNzA5WhcNMjAwNTE0MTYwNjQ2WjB1MQswCQYDVQQGEwJDSDEOMAwGA1UEBxMFQmFkZW4xJTAjBgNVBAoTHEFCQiBJbmZvcm1hdGlvbiBTeXN0ZW1zIEx0ZC4xFjAUBgNVBAsTDUFEIEZTIFNpZ25pbmcxFzAVBgNVBAMTDnN0c2ludC5hYmIuY29tMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAuERLBSH7XVVVijsIP%2BYctHDxWTmpbfGjoeRFWqbyMKKxiEVLdADUGGDicrwV61FaDlCZhs9Jt23kB5yTR2474wmbX5Mf5VNBC4sEcopLqRe2IE7yaANfS8T7CeBOU%2F7F2yvoAJSsmYF9P1g2Iqyq0Z%2FBdBU3ygrDIaqp%2FvnAm4TGGxD29%2Bf0XHyAvLgeFwsoQVsAlPIkh0nhi5wR62b7hM41iy0pK8hu0fBbUl3SCv9WCg%2FBj0TxIXMAIOS1UaLDpyzpNFNV1MZKGF9YkSN%2FFp4X%2FWEepx7SwWxw51WYZeGg3i2kSnGkniWNULgvMMLJK%2FvlYRhymEZMi%2FnTaE9y8wIDAQABo4IEXTCCBFkwCwYDVR0PBAQDAgWgMB0GA1UdDgQWBBTHsnHIQKViab0y2kh2vLPv6ax4OjAmBgNVHREEHzAdghtBREZTLVNpZ25pbmctU1RTSU5ULmFiYi5jb20wHwYDVR0jBBgwFoAUq5M6ES29PZ%2FozYvFtNpEJv%2BADYcwggFrBgNVHR8EggFiMIIBXjCCAVqgggFWoIIBUoYraHR0cDovL2NybC5wa2kuYWJiLmNvbS9BQkJJc3N1aW5nQ0EzKDMpLmNybIaBqGxkYXA6Ly8vQ049QUJCSXNzdWluZ0NBMygzKSxDTj1DRFAsQ049UHVibGljJTIwS2V5JTIwU2VydmljZXMsQ049U2VydmljZXMsQ049Q29uZmlndXJhdGlvbixEQz1hYmIsREM9Y29tP2NlcnRpZmljYXRlUmV2b2NhdGlvbkxpc3Q%2FYmFzZT9vYmplY3RDbGFzcz1jUkxEaXN0cmlidXRpb25Qb2ludIZ4bGRhcDovL2NybC5wa2kuYWJiLmNvbS9DTj1BQkJJc3N1aW5nQ0EzKDMpLENOPUNEUCxDTj1QS0k%2FY2VydGlmaWNhdGVSZXZvY2F0aW9uTGlzdD9iYXNlP29iamVjdENsYXNzPWNSTERpc3RyaWJ1dGlvblBvaW50MIIBmAYIKwYBBQUHAQEEggGKMIIBhjA3BggrBgEFBQcwAoYraHR0cDovL2FpYS5wa2kuYWJiLmNvbS9BQkJJc3N1aW5nQ0EzKDMpLmNydDCBqAYIKwYBBQUHMAKGgZtsZGFwOi8vL0NOPUFCQklzc3VpbmdDQTMsQ049QUlBLENOPVB1YmxpYyUyMEtleSUyMFNlcnZpY2VzLENOPVNlcnZpY2VzLENOPUNvbmZpZ3VyYXRpb24sREM9YWJiLERDPWNvbT9jQUNlcnRpZmljYXRlP2Jhc2U%2Fb2JqZWN0Q2xhc3M9Y2VydGlmaWNhdGlvbkF1dGhvcml0eTB3BggrBgEFBQcwAoZrbGRhcDovL2FpYS5wa2kuYWJiLmNvbS9DTj1BQkJJc3N1aW5nQ0EzLENOPUFJQSxDTj1QS0k%2FY0FDZXJ0aWZpY2F0ZT9iYXNlP29iamVjdENsYXNzPWNlcnRpZmljYXRpb25BdXRob3JpdHkwJwYIKwYBBQUHMAGGG2h0dHA6Ly9haWEucGtpLmFiYi5jb20vb2NzcDA8BgkrBgEEAYI3FQcELzAtBiUrBgEEAYI3FQjHqCaGsIR6hrWLCoLqjWqEj60hKYGNt0iD7%2BtTAgFkAgENMB0GA1UdJQQWMBQGCCsGAQUFBwMCBggrBgEFBQcDATBRBgNVHSAESjBIMEYGDCsGAQQBgdcHAR4KAjA2MDQGCCsGAQUFBwIBFihodHRwOi8vY3AucGtpLmFiYi5jb20vU1NMU2VydmVySW50ZXJuYWwvMCcGCSsGAQQBgjcVCgQaMBgwCgYIKwYBBQUHAwIwCgYIKwYBBQUHAwEwDQYJKoZIhvcNAQELBQADggEBABnaaISWCQ5stI9VUa%2BOqZNZeFvXyTyaM1VSyqIaEt55K8H5ts7Lte6BcBddjTxQuxRrSYRGzxA2An0SFD79%2FIhFy07Et0psPNaciWq7yhkIHWO2XeBfKWietIb78Ose98su1jgdyzf7UqSa8EZu6rrPzGab285WBEKCYaOY9746lFOmChUh9af%2BX%2B0AdN99SglGLL5%2F1qSHgFZL5%2BMHbeaXZ8HJwjG2bIEBtZM5ydoJi%2BcKGpidhh9UJjwpzXBLsCVzPr%2FZYjozVhJYgpY8Rx9z4%2B80r2YslbByd8KphT%2BKV9LMFc06CW4%2Fyz91lyXpE19Iwyyrr3TRuJ1AYYuQWFs%3D%3C%2FX509Certificate%3E%3C%2FX509Data%3E%3C%2FKeyInfo%3E%3C%2FSignature%3E%3C%2Fsaml%3AAssertion%3E%3C%2Ft%3ARequestedSecurityToken%3E%3Ct%3ARequestedAttachedReference%3E%3Co%3ASecurityTokenReference+k%3ATokenType%3D%22http%3A%2F%2Fdocs.oasis-open.org%2Fwss%2Foasis-wss-saml-token-profile-1.1%23SAMLV1.1%22+xmlns%3Ak%3D%22http%3A%2F%2Fdocs.oasis-open.org%2Fwss%2Foasis-wss-wssecurity-secext-1.1.xsd%22+xmlns%3Ao%3D%22http%3A%2F%2Fdocs.oasis-open.org%2Fwss%2F2004%2F01%2Foasis-200401-wss-wssecurity-secext-1.0.xsd%22%3E%3Co%3AKeyIdentifier+ValueType%3D%22http%3A%2F%2Fdocs.oasis-open.org%2Fwss%2Foasis-wss-saml-token-profile-1.0%23SAMLAssertionID%22%3E_0decb845-69cf-40bc-95bc-50f15ebf86f2%3C%2Fo%3AKeyIdentifier%3E%3C%2Fo%3ASecurityTokenReference%3E%3C%2Ft%3ARequestedAttachedReference%3E%3Ct%3ARequestedUnattachedReference%3E%3Co%3ASecurityTokenReference+k%3ATokenType%3D%22http%3A%2F%2Fdocs.oasis-open.org%2Fwss%2Foasis-wss-saml-token-profile-1.1%23SAMLV1.1%22+xmlns%3Ak%3D%22http%3A%2F%2Fdocs.oasis-open.org%2Fwss%2Foasis-wss-wssecurity-secext-1.1.xsd%22+xmlns%3Ao%3D%22http%3A%2F%2Fdocs.oasis-open.org%2Fwss%2F2004%2F01%2Foasis-200401-wss-wssecurity-secext-1.0.xsd%22%3E%3Co%3AKeyIdentifier+ValueType%3D%22http%3A%2F%2Fdocs.oasis-open.org%2Fwss%2Foasis-wss-saml-token-profile-1.0%23SAMLAssertionID%22%3E_0decb845-69cf-40bc-95bc-50f15ebf86f2%3C%2Fo%3AKeyIdentifier%3E%3C%2Fo%3ASecurityTokenReference%3E%3C%2Ft%3ARequestedUnattachedReference%3E%3Ct%3ATokenType%3Eurn%3Aoasis%3Anames%3Atc%3ASAML%3A1.0%3Aassertion%3C%2Ft%3ATokenType%3E%3Ct%3ARequestType%3Ehttp%3A%2F%2Fschemas.xmlsoap.org%2Fws%2F2005%2F02%2Ftrust%2FIssue%3C%2Ft%3ARequestType%3E%3Ct%3AKeyType%3Ehttp%3A%2F%2Fschemas.xmlsoap.org%2Fws%2F2005%2F05%2Fidentity%2FNoProofKey%3C%2Ft%3AKeyType%3E%3C%2Ft%3ARequestSecurityTokenResponse%3E
				"&wctx=" + vWctx;		// recorded value = f29eb6a3-5cdf-479c-a7e9-ed6e60508465
		String requestHeader0024 = "POST " + requestFile0024 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: stsint.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"Upgrade-Insecure-Requests: 1\r\n" + 
				"Content-Type: application/x-www-form-urlencoded\r\n" + 
				"Content-Length: " + requestContent0024.length() + "\r\n" + 		// Content-Length: 9460
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0024, requestHost0024, requestPort0024, requestHeader0024, requestContent0024.getBytes(), requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		if (debugLoops)
		{
			if (Lib.isAsciiContent(testURL.getRequestContent(), 256))
				log(">>> " + new String(testURL.getRequestContent()));
			else
				log(">>> [binary data]");
		}

		testURL.execute(performanceData);
		requestHeader0024 = null;		// support garbage collector to reduce memory
		requestContent0024 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 9439
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, null);		// Test [24] <- Index 24
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// extract variable(s) from response
		htmlContentParser = new HtmlContentParser(testURL, this);
		try
		{
			// extract var 'vWctx_1'
			vWctx_1 = htmlContentParser.getFormTable().getForm("hiddenform").getFormItemValue("wctx");		// recorded value = rm=0&id=passive&ru=%2fmyabb%2fdefault.aspx
			log("<<< vWctx_1 = " + vWctx_1);
		}
		catch (Exception e) { vWctx_1 = null; log(e); }
		if (vWctx_1 == null)
		{
			// failure - dump wrong response content and abort current outer loop - after that start next loop
			String errorText = "*** error: unable to extract var 'vWctx_1' from html form parameter";
			log(errorText);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			threadStep = performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_USER_SPECIFIC_TEST_FAILED, errorText, testURL, this);
		
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		try
		{
			// extract var 'vWa_1'
			vWa_1 = htmlContentParser.getFormTable().getForm("hiddenform").getFormItemValue("wa");		// recorded value = wsignin1.0
			log("<<< vWa_1 = " + vWa_1);
		}
		catch (Exception e) { vWa_1 = null; log(e); }
		if (vWa_1 == null)
		{
			// failure - dump wrong response content and abort current outer loop - after that start next loop
			String errorText = "*** error: unable to extract var 'vWa_1' from html form parameter";
			log(errorText);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			threadStep = performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_USER_SPECIFIC_TEST_FAILED, errorText, testURL, this);
		
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		try
		{
			// extract var 'vWresult_1'
			vWresult_1 = htmlContentParser.getFormTable().getForm("hiddenform").getFormItemValue("wresult");		// recorded value = <t:RequestSecurityTokenResponse xmlns:t=\"http://schemas.xmlsoap.org/ws/2005/02/trust\"><t:Lifetime><wsu:Created xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\">2016-12-20T10:17:14.263Z</wsu:Created><wsu:Expires xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\">2016-12-20T11:17:14.263Z</wsu:Expires></t:Lifetime><wsp:AppliesTo xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><wsa:EndpointReference xmlns:wsa=\"http://www.w3.org/2005/08/addressing\"><wsa:Address>https://www.abb.com</wsa:Address></wsa:EndpointReference></wsp:AppliesTo><t:RequestedSecurityToken><saml:Assertion MajorVersion=\"1\" MinorVersion=\"1\" AssertionID=\"_9da611ed-b63f-48cc-af53-5c7a9f7b10fa\" Issuer=\"http://stsint.abb.com/adfs/services/trust\" IssueInstant=\"2016-12-20T10:17:14.399Z\" xmlns:saml=\"urn:oasis:names:tc:SAML:1.0:assertion\"><saml:Conditions NotBefore=\"2016-12-20T10:17:14.263Z\" NotOnOrAfter=\"2016-12-20T11:17:14.263Z\"><saml:AudienceRestrictionCondition><saml:Audience>https://www.abb.com</saml:Audience></saml:AudienceRestrictionCondition></saml:Conditions><saml:AttributeStatement><saml:Subject><saml:SubjectConfirmation><saml:ConfirmationMethod>urn:oasis:names:tc:SAML:1.0:cm:bearer</saml:ConfirmationMethod></saml:SubjectConfirmation></saml:Subject><saml:Attribute AttributeName=\"upn\" AttributeNamespace=\"http://schemas.xmlsoap.org/ws/2005/05/identity/claims\"><saml:AttributeValue>mcp.test.ari@gmail.com</saml:AttributeValue></saml:Attribute><saml:Attribute AttributeName=\"emailaddress\" AttributeNamespace=\"http://schemas.xmlsoap.org/ws/2005/05/identity/claims\"><saml:AttributeValue>mcp.test.ari@gmail.com</saml:AttributeValue></saml:Attribute><saml:Attribute AttributeName=\"name\" AttributeNamespace=\"http://schemas.xmlsoap.org/ws/2005/05/identity/claims\"><saml:AttributeValue>mcp.test.ari@gmail.com</saml:AttributeValue></saml:Attribute><saml:Attribute AttributeName=\"DN\" AttributeNamespace=\"http://schemas.abb.com/claims\"><saml:AttributeValue>CN=mcp.test.ari@gmail.com,OU=Self-registered Users,DC=EXT,dc=abb,dc=com</saml:AttributeValue></saml:Attribute><saml:Attribute AttributeName=\"sn\" AttributeNamespace=\"http://schemas.abb.com/claims\"><saml:AttributeValue>Ari</saml:AttributeValue></saml:Attribute><saml:Attribute AttributeName=\"givenname\" AttributeNamespace=\"http://schemas.abb.com/claims\"><saml:AttributeValue>Mcp</saml:AttributeValue></saml:Attribute><saml:Attribute AttributeName=\"company\" AttributeNamespace=\"http://schemas.abb.com/claims\"><saml:AttributeValue>ABB</saml:AttributeValue></saml:Attribute><saml:Attribute AttributeName=\"countrycode\" AttributeNamespace=\"http://schemas.abb.com/claims\"><saml:AttributeValue>616</saml:AttributeValue></saml:Attribute><saml:Attribute AttributeName=\"preferredlanguage\" AttributeNamespace=\"http://schemas.abb.com/claims\"><saml:AttributeValue>us</saml:AttributeValue></saml:Attribute><saml:Attribute AttributeName=\"middlename\" AttributeNamespace=\"http://schemas.abb.com/claims\"><saml:AttributeValue>Test</saml:AttributeValue></saml:Attribute><saml:Attribute AttributeName=\"gid\" AttributeNamespace=\"http://schemas.abb.com/claims\"><saml:AttributeValue>9E1345026</saml:AttributeValue></saml:Attribute><saml:Attribute AttributeName=\"useraccountcontrol\" AttributeNamespace=\"http://schemas.abb.com/claims\"><saml:AttributeValue>512</saml:AttributeValue></saml:Attribute><saml:Attribute AttributeName=\"isfromproxy\" AttributeNamespace=\"http://schemas.abb.com/claims\"><saml:AttributeValue>true</saml:AttributeValue></saml:Attribute></saml:AttributeStatement><saml:AuthenticationStatement AuthenticationMethod=\"urn:federation:authentication:windows\" AuthenticationInstant=\"2016-12-20T10:17:13.496Z\"><saml:Subject><saml:SubjectConfirmation><saml:ConfirmationMethod>urn:oasis:names:tc:SAML:1.0:cm:bearer</saml:ConfirmationMethod></saml:SubjectConfirmation></saml:Subject></saml:AuthenticationStatement><ds:Signature xmlns:ds=\"http://www.w3.org/2000/09/xmldsig#\"><ds:SignedInfo><ds:CanonicalizationMethod Algorithm=\"http://www.w3.org/2001/10/xml-exc-c14n#\" /><ds:SignatureMethod Algorithm=\"http://www.w3.org/2001/04/xmldsig-more#rsa-sha256\" /><ds:Reference URI=\"#_9da611ed-b63f-48cc-af53-5c7a9f7b10fa\"><ds:Transforms><ds:Transform Algorithm=\"http://www.w3.org/2000/09/xmldsig#enveloped-signature\" /><ds:Transform Algorithm=\"http://www.w3.org/2001/10/xml-exc-c14n#\" /></ds:Transforms><ds:DigestMethod Algorithm=\"http://www.w3.org/2001/04/xmlenc#sha256\" /><ds:DigestValue>A/MczP1P/XMglpZfdysMkdtwvEIMAOF5sTejVyqJ7ek=</ds:DigestValue></ds:Reference></ds:SignedInfo><ds:SignatureValue>oVF1HslDe5sZSoK23tuOiqylsePfdD132wGPynZQZ1eY2TcOxRpm6XIkpHsJliQ7MKyoJ8Hf9JUzrZaE2BB4jIMAFHOpW7OXwHSMAdAGUmyT1zxiAld4cYsslO8r9xwhZ1+BHnTRM2zG7EEpgl+NCxjxegtSd4w00C+rUR7TSKuXBvdEkm3kRkbopNX827G1vZYz/LJJrVcQtsgQdpFvewDSNWJCWkHFYLDavF+jP2+TAV2AVrhajdmNSh56x1d1m5gpI3H/2FTNw3BwzLwKPPzXAubcJohhY8rUAae6qfP/g+hzMLO3nLw3SwC/pvoHZjMUQ8+MTKmquQ6a2El2lg==</ds:SignatureValue><KeyInfo xmlns=\"http://www.w3.org/2000/09/xmldsig#\"><X509Data><X509Certificate>MIIHqzCCBpOgAwIBAgIKOFbvRQADAAF6LDANBgkqhkiG9w0BAQsFADBTMRMwEQYKCZImiZPyLGQBGRYDQ09NMRMwEQYKCZImiZPyLGQBGRYDQUJCMQwwCgYDVQQKEwNBQkIxGTAXBgNVBAMTEEFCQiBJc3N1aW5nIENBIDMwHhcNMTUwNzAxMjEyNzA5WhcNMjAwNTE0MTYwNjQ2WjB1MQswCQYDVQQGEwJDSDEOMAwGA1UEBxMFQmFkZW4xJTAjBgNVBAoTHEFCQiBJbmZvcm1hdGlvbiBTeXN0ZW1zIEx0ZC4xFjAUBgNVBAsTDUFEIEZTIFNpZ25pbmcxFzAVBgNVBAMTDnN0c2ludC5hYmIuY29tMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAuERLBSH7XVVVijsIP+YctHDxWTmpbfGjoeRFWqbyMKKxiEVLdADUGGDicrwV61FaDlCZhs9Jt23kB5yTR2474wmbX5Mf5VNBC4sEcopLqRe2IE7yaANfS8T7CeBOU/7F2yvoAJSsmYF9P1g2Iqyq0Z/BdBU3ygrDIaqp/vnAm4TGGxD29+f0XHyAvLgeFwsoQVsAlPIkh0nhi5wR62b7hM41iy0pK8hu0fBbUl3SCv9WCg/Bj0TxIXMAIOS1UaLDpyzpNFNV1MZKGF9YkSN/Fp4X/WEepx7SwWxw51WYZeGg3i2kSnGkniWNULgvMMLJK/vlYRhymEZMi/nTaE9y8wIDAQABo4IEXTCCBFkwCwYDVR0PBAQDAgWgMB0GA1UdDgQWBBTHsnHIQKViab0y2kh2vLPv6ax4OjAmBgNVHREEHzAdghtBREZTLVNpZ25pbmctU1RTSU5ULmFiYi5jb20wHwYDVR0jBBgwFoAUq5M6ES29PZ/ozYvFtNpEJv+ADYcwggFrBgNVHR8EggFiMIIBXjCCAVqgggFWoIIBUoYraHR0cDovL2NybC5wa2kuYWJiLmNvbS9BQkJJc3N1aW5nQ0EzKDMpLmNybIaBqGxkYXA6Ly8vQ049QUJCSXNzdWluZ0NBMygzKSxDTj1DRFAsQ049UHVibGljJTIwS2V5JTIwU2VydmljZXMsQ049U2VydmljZXMsQ049Q29uZmlndXJhdGlvbixEQz1hYmIsREM9Y29tP2NlcnRpZmljYXRlUmV2b2NhdGlvbkxpc3Q/YmFzZT9vYmplY3RDbGFzcz1jUkxEaXN0cmlidXRpb25Qb2ludIZ4bGRhcDovL2NybC5wa2kuYWJiLmNvbS9DTj1BQkJJc3N1aW5nQ0EzKDMpLENOPUNEUCxDTj1QS0k/Y2VydGlmaWNhdGVSZXZvY2F0aW9uTGlzdD9iYXNlP29iamVjdENsYXNzPWNSTERpc3RyaWJ1dGlvblBvaW50MIIBmAYIKwYBBQUHAQEEggGKMIIBhjA3BggrBgEFBQcwAoYraHR0cDovL2FpYS5wa2kuYWJiLmNvbS9BQkJJc3N1aW5nQ0EzKDMpLmNydDCBqAYIKwYBBQUHMAKGgZtsZGFwOi8vL0NOPUFCQklzc3VpbmdDQTMsQ049QUlBLENOPVB1YmxpYyUyMEtleSUyMFNlcnZpY2VzLENOPVNlcnZpY2VzLENOPUNvbmZpZ3VyYXRpb24sREM9YWJiLERDPWNvbT9jQUNlcnRpZmljYXRlP2Jhc2U/b2JqZWN0Q2xhc3M9Y2VydGlmaWNhdGlvbkF1dGhvcml0eTB3BggrBgEFBQcwAoZrbGRhcDovL2FpYS5wa2kuYWJiLmNvbS9DTj1BQkJJc3N1aW5nQ0EzLENOPUFJQSxDTj1QS0k/Y0FDZXJ0aWZpY2F0ZT9iYXNlP29iamVjdENsYXNzPWNlcnRpZmljYXRpb25BdXRob3JpdHkwJwYIKwYBBQUHMAGGG2h0dHA6Ly9haWEucGtpLmFiYi5jb20vb2NzcDA8BgkrBgEEAYI3FQcELzAtBiUrBgEEAYI3FQjHqCaGsIR6hrWLCoLqjWqEj60hKYGNt0iD7+tTAgFkAgENMB0GA1UdJQQWMBQGCCsGAQUFBwMCBggrBgEFBQcDATBRBgNVHSAESjBIMEYGDCsGAQQBgdcHAR4KAjA2MDQGCCsGAQUFBwIBFihodHRwOi8vY3AucGtpLmFiYi5jb20vU1NMU2VydmVySW50ZXJuYWwvMCcGCSsGAQQBgjcVCgQaMBgwCgYIKwYBBQUHAwIwCgYIKwYBBQUHAwEwDQYJKoZIhvcNAQELBQADggEBABnaaISWCQ5stI9VUa+OqZNZeFvXyTyaM1VSyqIaEt55K8H5ts7Lte6BcBddjTxQuxRrSYRGzxA2An0SFD79/IhFy07Et0psPNaciWq7yhkIHWO2XeBfKWietIb78Ose98su1jgdyzf7UqSa8EZu6rrPzGab285WBEKCYaOY9746lFOmChUh9af+X+0AdN99SglGLL5/1qSHgFZL5+MHbeaXZ8HJwjG2bIEBtZM5ydoJi+cKGpidhh9UJjwpzXBLsCVzPr/ZYjozVhJYgpY8Rx9z4+80r2YslbByd8KphT+KV9LMFc06CW4/yz91lyXpE19Iwyyrr3TRuJ1AYYuQWFs=</X509Certificate></X509Data></KeyInfo></ds:Signature></saml:Assertion></t:RequestedSecurityToken><t:TokenType>urn:oasis:names:tc:SAML:1.0:assertion</t:TokenType><t:RequestType>http://schemas.xmlsoap.org/ws/2005/02/trust/Issue</t:RequestType><t:KeyType>http://schemas.xmlsoap.org/ws/2005/05/identity/NoProofKey</t:KeyType></t:RequestSecurityTokenResponse>
			log("<<< vWresult_1 = " + vWresult_1);
		}
		catch (Exception e) { vWresult_1 = null; log(e); }
		if (vWresult_1 == null)
		{
			// failure - dump wrong response content and abort current outer loop - after that start next loop
			String errorText = "*** error: unable to extract var 'vWresult_1' from html form parameter";
			log(errorText);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			threadStep = performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_USER_SPECIFIC_TEST_FAILED, errorText, testURL, this);
		
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [25] <- WEB ADMIN Index 25 ---
		log();
		log("# title: Object moved");
		String requestProt0025 = "https";
		String requestHost0025 = "www.abb.com";
		int    requestPort0025 = 443;
		String requestFile0025 = "/Authentication/ADFSHandler.ashx";
		String requestContent0025 = 
				"wa=" + java.net.URLEncoder.encode(vWa_1) +		// recorded value = wsignin1.0
				"&wresult=" + java.net.URLEncoder.encode(vWresult_1) +		// recorded value = %3Ct%3ARequestSecurityTokenResponse+xmlns%3At%3D%22http%3A%2F%2Fschemas.xmlsoap.org%2Fws%2F2005%2F02%2Ftrust%22%3E%3Ct%3ALifetime%3E%3Cwsu%3ACreated+xmlns%3Awsu%3D%22http%3A%2F%2Fdocs.oasis-open.org%2Fwss%2F2004%2F01%2Foasis-200401-wss-wssecurity-utility-1.0.xsd%22%3E2016-12-20T10%3A17%3A14.263Z%3C%2Fwsu%3ACreated%3E%3Cwsu%3AExpires+xmlns%3Awsu%3D%22http%3A%2F%2Fdocs.oasis-open.org%2Fwss%2F2004%2F01%2Foasis-200401-wss-wssecurity-utility-1.0.xsd%22%3E2016-12-20T11%3A17%3A14.263Z%3C%2Fwsu%3AExpires%3E%3C%2Ft%3ALifetime%3E%3Cwsp%3AAppliesTo+xmlns%3Awsp%3D%22http%3A%2F%2Fschemas.xmlsoap.org%2Fws%2F2004%2F09%2Fpolicy%22%3E%3Cwsa%3AEndpointReference+xmlns%3Awsa%3D%22http%3A%2F%2Fwww.w3.org%2F2005%2F08%2Faddressing%22%3E%3Cwsa%3AAddress%3Ehttps%3A%2F%2Fwww.abb.com%3C%2Fwsa%3AAddress%3E%3C%2Fwsa%3AEndpointReference%3E%3C%2Fwsp%3AAppliesTo%3E%3Ct%3ARequestedSecurityToken%3E%3Csaml%3AAssertion+MajorVersion%3D%221%22+MinorVersion%3D%221%22+AssertionID%3D%22_9da611ed-b63f-48cc-af53-5c7a9f7b10fa%22+Issuer%3D%22http%3A%2F%2Fstsint.abb.com%2Fadfs%2Fservices%2Ftrust%22+IssueInstant%3D%222016-12-20T10%3A17%3A14.399Z%22+xmlns%3Asaml%3D%22urn%3Aoasis%3Anames%3Atc%3ASAML%3A1.0%3Aassertion%22%3E%3Csaml%3AConditions+NotBefore%3D%222016-12-20T10%3A17%3A14.263Z%22+NotOnOrAfter%3D%222016-12-20T11%3A17%3A14.263Z%22%3E%3Csaml%3AAudienceRestrictionCondition%3E%3Csaml%3AAudience%3Ehttps%3A%2F%2Fwww.abb.com%3C%2Fsaml%3AAudience%3E%3C%2Fsaml%3AAudienceRestrictionCondition%3E%3C%2Fsaml%3AConditions%3E%3Csaml%3AAttributeStatement%3E%3Csaml%3ASubject%3E%3Csaml%3ASubjectConfirmation%3E%3Csaml%3AConfirmationMethod%3Eurn%3Aoasis%3Anames%3Atc%3ASAML%3A1.0%3Acm%3Abearer%3C%2Fsaml%3AConfirmationMethod%3E%3C%2Fsaml%3ASubjectConfirmation%3E%3C%2Fsaml%3ASubject%3E%3Csaml%3AAttribute+AttributeName%3D%22upn%22+AttributeNamespace%3D%22http%3A%2F%2Fschemas.xmlsoap.org%2Fws%2F2005%2F05%2Fidentity%2Fclaims%22%3E%3Csaml%3AAttributeValue%3Emcp.test.ari%40gmail.com%3C%2Fsaml%3AAttributeValue%3E%3C%2Fsaml%3AAttribute%3E%3Csaml%3AAttribute+AttributeName%3D%22emailaddress%22+AttributeNamespace%3D%22http%3A%2F%2Fschemas.xmlsoap.org%2Fws%2F2005%2F05%2Fidentity%2Fclaims%22%3E%3Csaml%3AAttributeValue%3Emcp.test.ari%40gmail.com%3C%2Fsaml%3AAttributeValue%3E%3C%2Fsaml%3AAttribute%3E%3Csaml%3AAttribute+AttributeName%3D%22name%22+AttributeNamespace%3D%22http%3A%2F%2Fschemas.xmlsoap.org%2Fws%2F2005%2F05%2Fidentity%2Fclaims%22%3E%3Csaml%3AAttributeValue%3Emcp.test.ari%40gmail.com%3C%2Fsaml%3AAttributeValue%3E%3C%2Fsaml%3AAttribute%3E%3Csaml%3AAttribute+AttributeName%3D%22DN%22+AttributeNamespace%3D%22http%3A%2F%2Fschemas.abb.com%2Fclaims%22%3E%3Csaml%3AAttributeValue%3ECN%3Dmcp.test.ari%40gmail.com%2COU%3DSelf-registered+Users%2CDC%3DEXT%2Cdc%3Dabb%2Cdc%3Dcom%3C%2Fsaml%3AAttributeValue%3E%3C%2Fsaml%3AAttribute%3E%3Csaml%3AAttribute+AttributeName%3D%22sn%22+AttributeNamespace%3D%22http%3A%2F%2Fschemas.abb.com%2Fclaims%22%3E%3Csaml%3AAttributeValue%3EAri%3C%2Fsaml%3AAttributeValue%3E%3C%2Fsaml%3AAttribute%3E%3Csaml%3AAttribute+AttributeName%3D%22givenname%22+AttributeNamespace%3D%22http%3A%2F%2Fschemas.abb.com%2Fclaims%22%3E%3Csaml%3AAttributeValue%3EMcp%3C%2Fsaml%3AAttributeValue%3E%3C%2Fsaml%3AAttribute%3E%3Csaml%3AAttribute+AttributeName%3D%22company%22+AttributeNamespace%3D%22http%3A%2F%2Fschemas.abb.com%2Fclaims%22%3E%3Csaml%3AAttributeValue%3EABB%3C%2Fsaml%3AAttributeValue%3E%3C%2Fsaml%3AAttribute%3E%3Csaml%3AAttribute+AttributeName%3D%22countrycode%22+AttributeNamespace%3D%22http%3A%2F%2Fschemas.abb.com%2Fclaims%22%3E%3Csaml%3AAttributeValue%3E616%3C%2Fsaml%3AAttributeValue%3E%3C%2Fsaml%3AAttribute%3E%3Csaml%3AAttribute+AttributeName%3D%22preferredlanguage%22+AttributeNamespace%3D%22http%3A%2F%2Fschemas.abb.com%2Fclaims%22%3E%3Csaml%3AAttributeValue%3Eus%3C%2Fsaml%3AAttributeValue%3E%3C%2Fsaml%3AAttribute%3E%3Csaml%3AAttribute+AttributeName%3D%22middlename%22+AttributeNamespace%3D%22http%3A%2F%2Fschemas.abb.com%2Fclaims%22%3E%3Csaml%3AAttributeValue%3ETest%3C%2Fsaml%3AAttributeValue%3E%3C%2Fsaml%3AAttribute%3E%3Csaml%3AAttribute+AttributeName%3D%22gid%22+AttributeNamespace%3D%22http%3A%2F%2Fschemas.abb.com%2Fclaims%22%3E%3Csaml%3AAttributeValue%3E9E1345026%3C%2Fsaml%3AAttributeValue%3E%3C%2Fsaml%3AAttribute%3E%3Csaml%3AAttribute+AttributeName%3D%22useraccountcontrol%22+AttributeNamespace%3D%22http%3A%2F%2Fschemas.abb.com%2Fclaims%22%3E%3Csaml%3AAttributeValue%3E512%3C%2Fsaml%3AAttributeValue%3E%3C%2Fsaml%3AAttribute%3E%3Csaml%3AAttribute+AttributeName%3D%22isfromproxy%22+AttributeNamespace%3D%22http%3A%2F%2Fschemas.abb.com%2Fclaims%22%3E%3Csaml%3AAttributeValue%3Etrue%3C%2Fsaml%3AAttributeValue%3E%3C%2Fsaml%3AAttribute%3E%3C%2Fsaml%3AAttributeStatement%3E%3Csaml%3AAuthenticationStatement+AuthenticationMethod%3D%22urn%3Afederation%3Aauthentication%3Awindows%22+AuthenticationInstant%3D%222016-12-20T10%3A17%3A13.496Z%22%3E%3Csaml%3ASubject%3E%3Csaml%3ASubjectConfirmation%3E%3Csaml%3AConfirmationMethod%3Eurn%3Aoasis%3Anames%3Atc%3ASAML%3A1.0%3Acm%3Abearer%3C%2Fsaml%3AConfirmationMethod%3E%3C%2Fsaml%3ASubjectConfirmation%3E%3C%2Fsaml%3ASubject%3E%3C%2Fsaml%3AAuthenticationStatement%3E%3Cds%3ASignature+xmlns%3Ads%3D%22http%3A%2F%2Fwww.w3.org%2F2000%2F09%2Fxmldsig%23%22%3E%3Cds%3ASignedInfo%3E%3Cds%3ACanonicalizationMethod+Algorithm%3D%22http%3A%2F%2Fwww.w3.org%2F2001%2F10%2Fxml-exc-c14n%23%22+%2F%3E%3Cds%3ASignatureMethod+Algorithm%3D%22http%3A%2F%2Fwww.w3.org%2F2001%2F04%2Fxmldsig-more%23rsa-sha256%22+%2F%3E%3Cds%3AReference+URI%3D%22%23_9da611ed-b63f-48cc-af53-5c7a9f7b10fa%22%3E%3Cds%3ATransforms%3E%3Cds%3ATransform+Algorithm%3D%22http%3A%2F%2Fwww.w3.org%2F2000%2F09%2Fxmldsig%23enveloped-signature%22+%2F%3E%3Cds%3ATransform+Algorithm%3D%22http%3A%2F%2Fwww.w3.org%2F2001%2F10%2Fxml-exc-c14n%23%22+%2F%3E%3C%2Fds%3ATransforms%3E%3Cds%3ADigestMethod+Algorithm%3D%22http%3A%2F%2Fwww.w3.org%2F2001%2F04%2Fxmlenc%23sha256%22+%2F%3E%3Cds%3ADigestValue%3EA%2FMczP1P%2FXMglpZfdysMkdtwvEIMAOF5sTejVyqJ7ek%3D%3C%2Fds%3ADigestValue%3E%3C%2Fds%3AReference%3E%3C%2Fds%3ASignedInfo%3E%3Cds%3ASignatureValue%3EoVF1HslDe5sZSoK23tuOiqylsePfdD132wGPynZQZ1eY2TcOxRpm6XIkpHsJliQ7MKyoJ8Hf9JUzrZaE2BB4jIMAFHOpW7OXwHSMAdAGUmyT1zxiAld4cYsslO8r9xwhZ1%2BBHnTRM2zG7EEpgl%2BNCxjxegtSd4w00C%2BrUR7TSKuXBvdEkm3kRkbopNX827G1vZYz%2FLJJrVcQtsgQdpFvewDSNWJCWkHFYLDavF%2BjP2%2BTAV2AVrhajdmNSh56x1d1m5gpI3H%2F2FTNw3BwzLwKPPzXAubcJohhY8rUAae6qfP%2Fg%2BhzMLO3nLw3SwC%2FpvoHZjMUQ8%2BMTKmquQ6a2El2lg%3D%3D%3C%2Fds%3ASignatureValue%3E%3CKeyInfo+xmlns%3D%22http%3A%2F%2Fwww.w3.org%2F2000%2F09%2Fxmldsig%23%22%3E%3CX509Data%3E%3CX509Certificate%3EMIIHqzCCBpOgAwIBAgIKOFbvRQADAAF6LDANBgkqhkiG9w0BAQsFADBTMRMwEQYKCZImiZPyLGQBGRYDQ09NMRMwEQYKCZImiZPyLGQBGRYDQUJCMQwwCgYDVQQKEwNBQkIxGTAXBgNVBAMTEEFCQiBJc3N1aW5nIENBIDMwHhcNMTUwNzAxMjEyNzA5WhcNMjAwNTE0MTYwNjQ2WjB1MQswCQYDVQQGEwJDSDEOMAwGA1UEBxMFQmFkZW4xJTAjBgNVBAoTHEFCQiBJbmZvcm1hdGlvbiBTeXN0ZW1zIEx0ZC4xFjAUBgNVBAsTDUFEIEZTIFNpZ25pbmcxFzAVBgNVBAMTDnN0c2ludC5hYmIuY29tMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAuERLBSH7XVVVijsIP%2BYctHDxWTmpbfGjoeRFWqbyMKKxiEVLdADUGGDicrwV61FaDlCZhs9Jt23kB5yTR2474wmbX5Mf5VNBC4sEcopLqRe2IE7yaANfS8T7CeBOU%2F7F2yvoAJSsmYF9P1g2Iqyq0Z%2FBdBU3ygrDIaqp%2FvnAm4TGGxD29%2Bf0XHyAvLgeFwsoQVsAlPIkh0nhi5wR62b7hM41iy0pK8hu0fBbUl3SCv9WCg%2FBj0TxIXMAIOS1UaLDpyzpNFNV1MZKGF9YkSN%2FFp4X%2FWEepx7SwWxw51WYZeGg3i2kSnGkniWNULgvMMLJK%2FvlYRhymEZMi%2FnTaE9y8wIDAQABo4IEXTCCBFkwCwYDVR0PBAQDAgWgMB0GA1UdDgQWBBTHsnHIQKViab0y2kh2vLPv6ax4OjAmBgNVHREEHzAdghtBREZTLVNpZ25pbmctU1RTSU5ULmFiYi5jb20wHwYDVR0jBBgwFoAUq5M6ES29PZ%2FozYvFtNpEJv%2BADYcwggFrBgNVHR8EggFiMIIBXjCCAVqgggFWoIIBUoYraHR0cDovL2NybC5wa2kuYWJiLmNvbS9BQkJJc3N1aW5nQ0EzKDMpLmNybIaBqGxkYXA6Ly8vQ049QUJCSXNzdWluZ0NBMygzKSxDTj1DRFAsQ049UHVibGljJTIwS2V5JTIwU2VydmljZXMsQ049U2VydmljZXMsQ049Q29uZmlndXJhdGlvbixEQz1hYmIsREM9Y29tP2NlcnRpZmljYXRlUmV2b2NhdGlvbkxpc3Q%2FYmFzZT9vYmplY3RDbGFzcz1jUkxEaXN0cmlidXRpb25Qb2ludIZ4bGRhcDovL2NybC5wa2kuYWJiLmNvbS9DTj1BQkJJc3N1aW5nQ0EzKDMpLENOPUNEUCxDTj1QS0k%2FY2VydGlmaWNhdGVSZXZvY2F0aW9uTGlzdD9iYXNlP29iamVjdENsYXNzPWNSTERpc3RyaWJ1dGlvblBvaW50MIIBmAYIKwYBBQUHAQEEggGKMIIBhjA3BggrBgEFBQcwAoYraHR0cDovL2FpYS5wa2kuYWJiLmNvbS9BQkJJc3N1aW5nQ0EzKDMpLmNydDCBqAYIKwYBBQUHMAKGgZtsZGFwOi8vL0NOPUFCQklzc3VpbmdDQTMsQ049QUlBLENOPVB1YmxpYyUyMEtleSUyMFNlcnZpY2VzLENOPVNlcnZpY2VzLENOPUNvbmZpZ3VyYXRpb24sREM9YWJiLERDPWNvbT9jQUNlcnRpZmljYXRlP2Jhc2U%2Fb2JqZWN0Q2xhc3M9Y2VydGlmaWNhdGlvbkF1dGhvcml0eTB3BggrBgEFBQcwAoZrbGRhcDovL2FpYS5wa2kuYWJiLmNvbS9DTj1BQkJJc3N1aW5nQ0EzLENOPUFJQSxDTj1QS0k%2FY0FDZXJ0aWZpY2F0ZT9iYXNlP29iamVjdENsYXNzPWNlcnRpZmljYXRpb25BdXRob3JpdHkwJwYIKwYBBQUHMAGGG2h0dHA6Ly9haWEucGtpLmFiYi5jb20vb2NzcDA8BgkrBgEEAYI3FQcELzAtBiUrBgEEAYI3FQjHqCaGsIR6hrWLCoLqjWqEj60hKYGNt0iD7%2BtTAgFkAgENMB0GA1UdJQQWMBQGCCsGAQUFBwMCBggrBgEFBQcDATBRBgNVHSAESjBIMEYGDCsGAQQBgdcHAR4KAjA2MDQGCCsGAQUFBwIBFihodHRwOi8vY3AucGtpLmFiYi5jb20vU1NMU2VydmVySW50ZXJuYWwvMCcGCSsGAQQBgjcVCgQaMBgwCgYIKwYBBQUHAwIwCgYIKwYBBQUHAwEwDQYJKoZIhvcNAQELBQADggEBABnaaISWCQ5stI9VUa%2BOqZNZeFvXyTyaM1VSyqIaEt55K8H5ts7Lte6BcBddjTxQuxRrSYRGzxA2An0SFD79%2FIhFy07Et0psPNaciWq7yhkIHWO2XeBfKWietIb78Ose98su1jgdyzf7UqSa8EZu6rrPzGab285WBEKCYaOY9746lFOmChUh9af%2BX%2B0AdN99SglGLL5%2F1qSHgFZL5%2BMHbeaXZ8HJwjG2bIEBtZM5ydoJi%2BcKGpidhh9UJjwpzXBLsCVzPr%2FZYjozVhJYgpY8Rx9z4%2B80r2YslbByd8KphT%2BKV9LMFc06CW4%2Fyz91lyXpE19Iwyyrr3TRuJ1AYYuQWFs%3D%3C%2FX509Certificate%3E%3C%2FX509Data%3E%3C%2FKeyInfo%3E%3C%2Fds%3ASignature%3E%3C%2Fsaml%3AAssertion%3E%3C%2Ft%3ARequestedSecurityToken%3E%3Ct%3ATokenType%3Eurn%3Aoasis%3Anames%3Atc%3ASAML%3A1.0%3Aassertion%3C%2Ft%3ATokenType%3E%3Ct%3ARequestType%3Ehttp%3A%2F%2Fschemas.xmlsoap.org%2Fws%2F2005%2F02%2Ftrust%2FIssue%3C%2Ft%3ARequestType%3E%3Ct%3AKeyType%3Ehttp%3A%2F%2Fschemas.xmlsoap.org%2Fws%2F2005%2F05%2Fidentity%2FNoProofKey%3C%2Ft%3AKeyType%3E%3C%2Ft%3ARequestSecurityTokenResponse%3E
				"&wctx=" + java.net.URLEncoder.encode(vWctx_1);		// recorded value = rm%3D0%26id%3Dpassive%26ru%3D%252fmyabb%252fdefault.aspx
		String requestHeader0025 = "POST " + requestFile0025 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"Upgrade-Insecure-Requests: 1\r\n" + 
				"Content-Type: application/x-www-form-urlencoded\r\n" + 
				"Content-Length: " + requestContent0025.length() + "\r\n" + 		// Content-Length: 9804
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0025, requestHost0025, requestPort0025, requestHeader0025, requestContent0025.getBytes(), requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		if (debugLoops)
		{
			if (Lib.isAsciiContent(testURL.getRequestContent(), 256))
				log(">>> " + new String(testURL.getRequestContent()));
			else
				log(">>> [binary data]");
		}

		testURL.execute(performanceData);
		requestHeader0025 = null;		// support garbage collector to reduce memory
		requestContent0025 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 302, content type = [verification disabled], header text fragment = [verification disabled], recorded content size = 140
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {302}, null, null, null);		// Test [25] <- Index 25
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [26] <- WEB ADMIN Index 26 ---
		log();
		log("# title: Object moved");
		String requestProt0026 = "https";
		String requestHost0026 = "www.abb.com";
		int    requestPort0026 = 443;
		String requestFile0026 = "/myabb/default.aspx";
		String requestHeader0026 = "GET " + requestFile0026 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"Upgrade-Insecure-Requests: 1\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0026, requestHost0026, requestPort0026, requestHeader0026, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0026 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 302, content type = [verification disabled], header text fragment = [verification disabled], recorded content size = 206
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {302}, null, null, null);		// Test [26] <- Index 26
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [27] <- WEB ADMIN Index 27 ---
		log();
		log("# title: Object moved");
		String requestProt0027 = "https";
		String requestHost0027 = "stsint.abb.com";
		int    requestPort0027 = 443;
		String requestFile0027 = "/adfs/ls/IdpInitiatedsignon.aspx" +
				"?loginToRp=https://myportal.abb.com";
		String requestHeader0027 = "GET " + requestFile0027 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: stsint.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"Upgrade-Insecure-Requests: 1\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0027, requestHost0027, requestPort0027, requestHeader0027, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0027 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 302, content type = [verification disabled], header text fragment = [verification disabled], recorded content size = 1219
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {302}, null, null, null);		// Test [27] <- Index 27
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// extract variable(s) from response
		htmlContentParser = new HtmlContentParser(testURL, this);
		try
		{
			// extract var 'rider9'
			rider9 = new ParseUrl(testURL.getHeaderField("location")).getFile();		// recorded value = /adfs/ls/?SAMLRequest=7b0HYBxJliUmL23Ke39K9UrX4HShCIBgEyTYkEAQ7MGIzeaS7B1pRyMpqyqBymVWZV1mFkDM7Z28995777333nvvvfe6O51OJ%2fff%2fz9cZmQBbPbOStrJniGAqsgfP358Hz8iHjfZolw9Ol638%2bWr%2fBet86ZNz55%2b9tHvnz3c3c%2fPH%2bxunx%2fMJtv7%2b%2bcH2wf3Ht7bzu8%2fvH8%2bOz9%2f%2bOnD%2bx%2blP5nXTVEtP%2ftob7zzUXrWNOv8bNm02bKlj3Z2P93e3dve23mzu%2fNo98Gj3U%2fH9%2ffv%2fdRH6VPqpVhmLb85b9tV8%2bju3aZtimU7ziaT8bRa3M1m583dsrn7UXpSLZscANf18lGVNUXzaJkt8uZRO330%2bviL54%2bo70dTafRovWxW%2bbQ4L%2fLZR%2bm7RblsHvEIN7%2b9qqu2mlblR0ePeQy1vLr5paxp8hpj%2bOgIYxgYArW5LKZ5c7et1037%2bK7AP3pMo5oVeLt5z74eH69nRb6c5q%2bIinUxxafuwyNDzsX1qqrbrDTYPL5rm7hfAxB3HUr0R58vjv4f&Signature=g5R%2fdStl3CiuJ0iurv76LCIqzKJTIhZCKuOboCiT2SbxrNAJL5SR2Y8e9YtzvSwyOeQEKehT5RmUAEegI3nBCjEI5LRo4spbS5KLImsEdarwfaHXnnRhfS%2bIcOr%2fGvMlzfB501yhlQ0ZGfD1t4aoRQLjIcHhV31FBD6LrmnAMXRNfd0E%2bEDu7397NBHognpHMeInEFMdrklxTnCXIQGKIPXN1Lz4ySfjg%2fwVjSoOtBK03%2fXDZih%2b3ZNUZ13rzlEPrRG70dB1WsNxCkIHAcDrHD7EAfQiPEAiPursDmvamRJ2SIcRKSQdjUIoj7oY2DjTZ4xi%2bf7GI9Zy7Y%2b2yP3C9A%3d%3d&SigAlg=http%3a%2f%2fwww.w3.org%2f2001%2f04%2fxmldsig-more%23rsa-sha256
			log("<<< rider9 = " + rider9);
		}
		catch (Exception e) { rider9 = null; log(e); }
		if (rider9 == null)
		{
			// failure - dump wrong response content and abort current outer loop - after that start next loop
			String errorText = "*** error: unable to extract var 'rider9' from http redirection";
			log(errorText);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			threadStep = performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_USER_SPECIFIC_TEST_FAILED, errorText, testURL, this);
		
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [28] <- WEB ADMIN Index 28 ---
		log();
		log("# title: Object moved");
		String requestProt0028 = "https";
		String requestHost0028 = "stsint.abb.com";
		int    requestPort0028 = 443;
		String requestFile0028 = "/adfs/ls/" +
				"?SAMLRequest=7b0HYBxJliUmL23Ke39K9UrX4HShCIBgEyTYkEAQ7MGIzeaS7B1pRyMpqyqBymVWZV1mFkDM7Z28995777333nvvvfe6O51OJ%2fff%2fz9cZmQBbPbOStrJniGAqsgfP358Hz8iHjfZolw9Ol638%2bWr%2fBet86ZNz55%2b9tHvnz3c3c%2fPH%2bxunx%2fMJtv7%2b%2bcH2wf3Ht7bzu8%2fvH8%2bOz9%2f%2bOnD%2bx%2blP5nXTVEtP%2ftob7zzUXrWNOv8bNm02bKlj3Z2P93e3dve23mzu%2fNo98Gj3U%2fH9%2ffv%2fdRH6VPqpVhmLb85b9tV8%2bju3aZtimU7ziaT8bRa3M1m583dsrn7UXpSLZscANf18lGVNUXzaJkt8uZRO330%2bviL54%2bo70dTafRovWxW%2bbQ4L%2fLZR%2bm7RblsHvEIN7%2b9qqu2mlblR0ePeQy1vLr5paxp8hpj%2bOgIYxgYArW5LKZ5c7et1037%2bK7AP3pMo5oVeLt5z74eH69nRb6c5q%2bIinUxxafuwyNDzsX1qqrbrDTYPL5rm7hfAxB3HUr0R58vjv4f" +
				"&Signature=g5R%2fdStl3CiuJ0iurv76LCIqzKJTIhZCKuOboCiT2SbxrNAJL5SR2Y8e9YtzvSwyOeQEKehT5RmUAEegI3nBCjEI5LRo4spbS5KLImsEdarwfaHXnnRhfS%2bIcOr%2fGvMlzfB501yhlQ0ZGfD1t4aoRQLjIcHhV31FBD6LrmnAMXRNfd0E%2bEDu7397NBHognpHMeInEFMdrklxTnCXIQGKIPXN1Lz4ySfjg%2fwVjSoOtBK03%2fXDZih%2b3ZNUZ13rzlEPrRG70dB1WsNxCkIHAcDrHD7EAfQiPEAiPursDmvamRJ2SIcRKSQdjUIoj7oY2DjTZ4xi%2bf7GI9Zy7Y%2b2yP3C9A%3d%3d" +
				"&SigAlg=http%3a%2f%2fwww.w3.org%2f2001%2f04%2fxmldsig-more%23rsa-sha256";
		requestFile0028 = Lib.replaceTextPattern(requestFile0028, "/adfs/ls/?SAMLRequest=7b0HYBxJliUmL23Ke39K9UrX4HShCIBgEyTYkEAQ7MGIzeaS7B1pRyMpqyqBymVWZV1mFkDM7Z28995777333nvvvfe6O51OJ%2fff%2fz9cZmQBbPbOStrJniGAqsgfP358Hz8iHjfZolw9Ol638%2bWr%2fBet86ZNz55%2b9tHvnz3c3c%2fPH%2bxunx%2fMJtv7%2b%2bcH2wf3Ht7bzu8%2fvH8%2bOz9%2f%2bOnD%2bx%2blP5nXTVEtP%2ftob7zzUXrWNOv8bNm02bKlj3Z2P93e3dve23mzu%2fNo98Gj3U%2fH9%2ffv%2fdRH6VPqpVhmLb85b9tV8%2bju3aZtimU7ziaT8bRa3M1m583dsrn7UXpSLZscANf18lGVNUXzaJkt8uZRO330%2bviL54%2bo70dTafRovWxW%2bbQ4L%2fLZR%2bm7RblsHvEIN7%2b9qqu2mlblR0ePeQy1vLr5paxp8hpj%2bOgIYxgYArW5LKZ5c7et1037%2bK7AP3pMo5oVeLt5z74eH69nRb6c5q%2bIinUxxafuwyNDzsX1qqrbrDTYPL5rm7hfAxB3HUr0R58vjv4f&Signature=g5R%2fdStl3CiuJ0iurv76LCIqzKJTIhZCKuOboCiT2SbxrNAJL5SR2Y8e9YtzvSwyOeQEKehT5RmUAEegI3nBCjEI5LRo4spbS5KLImsEdarwfaHXnnRhfS%2bIcOr%2fGvMlzfB501yhlQ0ZGfD1t4aoRQLjIcHhV31FBD6LrmnAMXRNfd0E%2bEDu7397NBHognpHMeInEFMdrklxTnCXIQGKIPXN1Lz4ySfjg%2fwVjSoOtBK03%2fXDZih%2b3ZNUZ13rzlEPrRG70dB1WsNxCkIHAcDrHD7EAfQiPEAiPursDmvamRJ2SIcRKSQdjUIoj7oY2DjTZ4xi%2bf7GI9Zy7Y%2b2yP3C9A%3d%3d&SigAlg=http%3a%2f%2fwww.w3.org%2f2001%2f04%2fxmldsig-more%23rsa-sha256", rider9, 0);		// search and replace request file fragment "/adfs/ls/?SAMLRequest=7b0HYBxJliUmL23Ke39K9UrX4HShCIBgEyTYkEAQ7MGIzeaS7B1pRyMpqyqBymVWZV1mFkDM7Z28995777333nvvvfe6O51OJ%2fff%2fz9cZmQBbPbOStrJniGAqsgfP358Hz8iHjfZolw9Ol638%2bWr%2fBet86ZNz55%2b9tHvnz3c3c%2fPH%2bxunx%2fMJtv7%2b%2bcH2wf3Ht7bzu8%2fvH8%2bOz9%2f%2bOnD%2bx%2blP5nXTVEtP%2ftob7zzUXrWNOv8bNm02bKlj3Z2P93e3dve23mzu%2fNo98Gj3U%2fH9%2ffv%2fdRH6VPqpVhmLb85b9tV8%2bju3aZtimU7ziaT8bRa3M1m583dsrn7UXpSLZscANf18lGVNUXzaJkt8uZRO330%2bviL54%2bo70dTafRovWxW%2bbQ4L%2fLZR%2bm7RblsHvEIN7%2b9qqu2mlblR0ePeQy1vLr5paxp8hpj%2bOgIYxgYArW5LKZ5c7et1037%2bK7AP3pMo5oVeLt5z74eH69nRb6c5q%2bIinUxxafuwyNDzsX1qqrbrDTYPL5rm7hfAxB3HUr0R58vjv4f&Signature=g5R%2fdStl3CiuJ0iurv76LCIqzKJTIhZCKuOboCiT2SbxrNAJL5SR2Y8e9YtzvSwyOeQEKehT5RmUAEegI3nBCjEI5LRo4spbS5KLImsEdarwfaHXnnRhfS%2bIcOr%2fGvMlzfB501yhlQ0ZGfD1t4aoRQLjIcHhV31FBD6LrmnAMXRNfd0E%2bEDu7397NBHognpHMeInEFMdrklxTnCXIQGKIPXN1Lz4ySfjg%2fwVjSoOtBK03%2fXDZih%2b3ZNUZ13rzlEPrRG70dB1WsNxCkIHAcDrHD7EAfQiPEAiPursDmvamRJ2SIcRKSQdjUIoj7oY2DjTZ4xi%2bf7GI9Zy7Y%2b2yP3C9A%3d%3d&SigAlg=http%3a%2f%2fwww.w3.org%2f2001%2f04%2fxmldsig-more%23rsa-sha256" with variable 'rider9' on all occurrences

		String requestHeader0028 = "GET " + requestFile0028 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: stsint.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"Upgrade-Insecure-Requests: 1\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0028, requestHost0028, requestPort0028, requestHeader0028, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0028 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 302, content type = [verification disabled], header text fragment = [verification disabled], recorded content size = 315
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {302}, null, null, null);		// Test [28] <- Index 28
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// extract variable(s) from response
		htmlContentParser = new HtmlContentParser(testURL, this);
		try
		{
			// extract var 'rider10'
			rider10 = new ParseUrl(testURL.getHeaderField("location")).getFile();		// recorded value = /adfs/ls/Fwd.aspx?wa=wsignin1.0&wtrealm=http%3a%2f%2fstsint.abb.com%2fadfs%2fservices%2ftrust&wctx=02bc8c5b-9f24-4e1f-958e-6cf760be8678&wct=2016-12-20T10%3a17%3a16Z
			log("<<< rider10 = " + rider10);
		}
		catch (Exception e) { rider10 = null; log(e); }
		if (rider10 == null)
		{
			// failure - dump wrong response content and abort current outer loop - after that start next loop
			String errorText = "*** error: unable to extract var 'rider10' from http redirection";
			log(errorText);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			threadStep = performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_USER_SPECIFIC_TEST_FAILED, errorText, testURL, this);
		
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [29] <- WEB ADMIN Index 29 ---
		log();
		log("# title: Object moved");
		String requestProt0029 = "https";
		String requestHost0029 = "stsint.abb.com";
		int    requestPort0029 = 443;
		String requestFile0029 = "/adfs/ls/Fwd.aspx" +
				"?wa=wsignin1.0" +
				"&wtrealm=http%3a%2f%2fstsint.abb.com%2fadfs%2fservices%2ftrust" +
				"&wctx=02bc8c5b-9f24-4e1f-958e-6cf760be8678" +
				"&wct=2016-12-20T10%3a17%3a16Z";
		requestFile0029 = Lib.replaceTextPattern(requestFile0029, "/adfs/ls/Fwd.aspx?wa=wsignin1.0&wtrealm=http%3a%2f%2fstsint.abb.com%2fadfs%2fservices%2ftrust&wctx=02bc8c5b-9f24-4e1f-958e-6cf760be8678&wct=2016-12-20T10%3a17%3a16Z", rider10, 0);		// search and replace request file fragment "/adfs/ls/Fwd.aspx?wa=wsignin1.0&wtrealm=http%3a%2f%2fstsint.abb.com%2fadfs%2fservices%2ftrust&wctx=02bc8c5b-9f24-4e1f-958e-6cf760be8678&wct=2016-12-20T10%3a17%3a16Z" with variable 'rider10' on all occurrences

		String requestHeader0029 = "GET " + requestFile0029 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: stsint.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"Upgrade-Insecure-Requests: 1\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0029, requestHost0029, requestPort0029, requestHeader0029, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0029 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 302, content type = [verification disabled], header text fragment = [verification disabled], recorded content size = 309
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {302}, null, null, null);		// Test [29] <- Index 29
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// extract variable(s) from response
		htmlContentParser = new HtmlContentParser(testURL, this);
		try
		{
			// extract var 'rider11'
			rider11 = new ParseUrl(testURL.getHeaderField("location")).getFile();		// recorded value = /vissts?wa=wsignin1.0&wtrealm=http%3a%2f%2fstsint.abb.com%2fadfs%2fservices%2ftrust&wctx=02bc8c5b-9f24-4e1f-958e-6cf760be8678&wct=2016-12-20t10%3a17%3a16z
			log("<<< rider11 = " + rider11);
		}
		catch (Exception e) { rider11 = null; log(e); }
		if (rider11 == null)
		{
			// failure - dump wrong response content and abort current outer loop - after that start next loop
			String errorText = "*** error: unable to extract var 'rider11' from http redirection";
			log(errorText);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			threadStep = performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_USER_SPECIFIC_TEST_FAILED, errorText, testURL, this);
		
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [30] <- WEB ADMIN Index 30 ---
		log();
		log("# title: Document Moved");
		String requestProt0030 = "https";
		String requestHost0030 = "stsint.abb.com";
		int    requestPort0030 = 443;
		String requestFile0030 = "/vissts" +
				"?wa=wsignin1.0" +
				"&wtrealm=http%3a%2f%2fstsint.abb.com%2fadfs%2fservices%2ftrust" +
				"&wctx=02bc8c5b-9f24-4e1f-958e-6cf760be8678" +
				"&wct=2016-12-20t10%3a17%3a16z";
		requestFile0030 = Lib.replaceTextPattern(requestFile0030, "/vissts?wa=wsignin1.0&wtrealm=http%3a%2f%2fstsint.abb.com%2fadfs%2fservices%2ftrust&wctx=02bc8c5b-9f24-4e1f-958e-6cf760be8678&wct=2016-12-20t10%3a17%3a16z", rider11, 0);		// search and replace request file fragment "/vissts?wa=wsignin1.0&wtrealm=http%3a%2f%2fstsint.abb.com%2fadfs%2fservices%2ftrust&wctx=02bc8c5b-9f24-4e1f-958e-6cf760be8678&wct=2016-12-20t10%3a17%3a16z" with variable 'rider11' on all occurrences

		String requestHeader0030 = "GET " + requestFile0030 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: stsint.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"Upgrade-Insecure-Requests: 1\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0030, requestHost0030, requestPort0030, requestHeader0030, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0030 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 301, content type = [verification disabled], header text fragment = [verification disabled], recorded content size = 312
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {301}, null, null, null);		// Test [30] <- Index 30
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// extract variable(s) from response
		htmlContentParser = new HtmlContentParser(testURL, this);
		try
		{
			// extract var 'rider12'
			rider12 = new ParseUrl(testURL.getHeaderField("location")).getFile();		// recorded value = /vissts/?wa=wsignin1.0&wtrealm=http%3a%2f%2fstsint.abb.com%2fadfs%2fservices%2ftrust&wctx=02bc8c5b-9f24-4e1f-958e-6cf760be8678&wct=2016-12-20t10%3a17%3a16z
			log("<<< rider12 = " + rider12);
		}
		catch (Exception e) { rider12 = null; log(e); }
		if (rider12 == null)
		{
			// failure - dump wrong response content and abort current outer loop - after that start next loop
			String errorText = "*** error: unable to extract var 'rider12' from http redirection";
			log(errorText);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			threadStep = performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_USER_SPECIFIC_TEST_FAILED, errorText, testURL, this);
		
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [31] <- WEB ADMIN Index 31 ---
		log();
		log("# title: Object moved");
		String requestProt0031 = "https";
		String requestHost0031 = "stsint.abb.com";
		int    requestPort0031 = 443;
		String requestFile0031 = "/vissts/" +
				"?wa=wsignin1.0" +
				"&wtrealm=http%3a%2f%2fstsint.abb.com%2fadfs%2fservices%2ftrust" +
				"&wctx=02bc8c5b-9f24-4e1f-958e-6cf760be8678" +
				"&wct=2016-12-20t10%3a17%3a16z";
		requestFile0031 = Lib.replaceTextPattern(requestFile0031, "/vissts/?wa=wsignin1.0&wtrealm=http%3a%2f%2fstsint.abb.com%2fadfs%2fservices%2ftrust&wctx=02bc8c5b-9f24-4e1f-958e-6cf760be8678&wct=2016-12-20t10%3a17%3a16z", rider12, 0);		// search and replace request file fragment "/vissts/?wa=wsignin1.0&wtrealm=http%3a%2f%2fstsint.abb.com%2fadfs%2fservices%2ftrust&wctx=02bc8c5b-9f24-4e1f-958e-6cf760be8678&wct=2016-12-20t10%3a17%3a16z" with variable 'rider12' on all occurrences

		String requestHeader0031 = "GET " + requestFile0031 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: stsint.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"Upgrade-Insecure-Requests: 1\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0031, requestHost0031, requestPort0031, requestHeader0031, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0031 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 302, content type = [verification disabled], header text fragment = [verification disabled], recorded content size = 292
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {302}, null, null, null);		// Test [31] <- Index 31
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// extract variable(s) from response
		htmlContentParser = new HtmlContentParser(testURL, this);
		try
		{
			// extract var 'rider13'
			rider13 = testURL.getHeaderField("Location");		// recorded value = /vissts/sts.aspx?wa=wsignin1.0&wtrealm=http%3a%2f%2fstsint.abb.com%2fadfs%2fservices%2ftrust&wctx=02bc8c5b-9f24-4e1f-958e-6cf760be8678&wct=2016-12-20t10%3a17%3a16z
			log("<<< rider13 = " + rider13);
		}
		catch (Exception e) { rider13 = null; log(e); }
		if (rider13 == null)
		{
			// failure - dump wrong response content and abort current outer loop - after that start next loop
			String errorText = "*** error: unable to extract var 'rider13' from http response header field";
			log(errorText);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			threadStep = performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_USER_SPECIFIC_TEST_FAILED, errorText, testURL, this);
		
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [32] <- WEB ADMIN Index 32 ---
		log();
		log("# title: Working...");
		String requestProt0032 = "https";
		String requestHost0032 = "stsint.abb.com";
		int    requestPort0032 = 443;
		String requestFile0032 = "/vissts/sts.aspx" +
				"?wa=wsignin1.0" +
				"&wtrealm=http%3a%2f%2fstsint.abb.com%2fadfs%2fservices%2ftrust" +
				"&wctx=02bc8c5b-9f24-4e1f-958e-6cf760be8678" +
				"&wct=2016-12-20t10%3a17%3a16z";
		requestFile0032 = Lib.replaceTextPattern(requestFile0032, "/vissts/sts.aspx?wa=wsignin1.0&wtrealm=http%3a%2f%2fstsint.abb.com%2fadfs%2fservices%2ftrust&wctx=02bc8c5b-9f24-4e1f-958e-6cf760be8678&wct=2016-12-20t10%3a17%3a16z", rider13, 0);		// search and replace request file fragment "/vissts/sts.aspx?wa=wsignin1.0&wtrealm=http%3a%2f%2fstsint.abb.com%2fadfs%2fservices%2ftrust&wctx=02bc8c5b-9f24-4e1f-958e-6cf760be8678&wct=2016-12-20t10%3a17%3a16z" with variable 'rider13' on all occurrences

		String requestHeader0032 = "GET " + requestFile0032 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: stsint.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"Upgrade-Insecure-Requests: 1\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0032, requestHost0032, requestPort0032, requestHeader0032, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0032 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 9127
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, null);		// Test [32] <- Index 32
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// extract variable(s) from response
		htmlContentParser = new HtmlContentParser(testURL, this);
		try
		{
			// extract var 'vWresult_2'
			vWresult_2 = htmlContentParser.getFormTable().getForm("hiddenform").getFormItemValue("wresult");		// recorded value = <t:RequestSecurityTokenResponse Context=\"02bc8c5b-9f24-4e1f-958e-6cf760be8678\" xmlns:t=\"http://schemas.xmlsoap.org/ws/2005/02/trust\"><t:Lifetime><wsu:Created xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\">2016-12-20T10:17:16.928Z</wsu:Created><wsu:Expires xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\">2016-12-20T18:17:16.928Z</wsu:Expires></t:Lifetime><wsp:AppliesTo xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><wsa:EndpointReference xmlns:wsa=\"http://www.w3.org/2005/08/addressing\"><wsa:Address>http://stsint.abb.com/adfs/services/trust</wsa:Address></wsa:EndpointReference></wsp:AppliesTo><t:RequestedSecurityToken><saml:Assertion MajorVersion=\"1\" MinorVersion=\"1\" AssertionID=\"_f2213857-b9ac-45db-8ba1-68450a8d2bd2\" Issuer=\"https://stsint.abb.com/vissts\" IssueInstant=\"2016-12-20T10:17:16.928Z\" xmlns:saml=\"urn:oasis:names:tc:SAML:1.0:assertion\"><saml:Conditions NotBefore=\"2016-12-20T10:17:16.928Z\" NotOnOrAfter=\"2016-12-20T18:17:16.928Z\"><saml:AudienceRestrictionCondition><saml:Audience>http://stsint.abb.com/adfs/services/trust</saml:Audience></saml:AudienceRestrictionCondition></saml:Conditions><saml:AttributeStatement><saml:Subject><saml:NameIdentifier Format=\"urn:oasis:names:tc:SAML:1.1:nameid-format:unspecified\">7D6jICuQMUSD+KNdnKEPdA==</saml:NameIdentifier><saml:SubjectConfirmation><saml:ConfirmationMethod>urn:oasis:names:tc:SAML:1.0:cm:bearer</saml:ConfirmationMethod></saml:SubjectConfirmation></saml:Subject><saml:Attribute AttributeName=\"ImmutableID\" AttributeNamespace=\"http://schemas.microsoft.com/LiveID/Federation/2008/05\"><saml:AttributeValue>7D6jICuQMUSD+KNdnKEPdA==</saml:AttributeValue></saml:Attribute><saml:Attribute AttributeName=\"emailaddress\" AttributeNamespace=\"http://schemas.xmlsoap.org/ws/2005/05/identity/claims\"><saml:AttributeValue>mcp.test.ari@gmail.com</saml:AttributeValue></saml:Attribute><saml:Attribute AttributeName=\"upn\" AttributeNamespace=\"http://schemas.xmlsoap.org/ws/2005/05/identity/claims\"><saml:AttributeValue>mcp.test.ari@gmail.com</saml:AttributeValue></saml:Attribute><saml:Attribute AttributeName=\"UPN\" AttributeNamespace=\"http://schemas.xmlsoap.org/claims\"><saml:AttributeValue>mcp.test.ari@gmail.com</saml:AttributeValue></saml:Attribute></saml:AttributeStatement><saml:AuthenticationStatement AuthenticationMethod=\"urn:federation:authentication:windows\" AuthenticationInstant=\"2016-12-20T10:17:16.928Z\"><saml:Subject><saml:NameIdentifier Format=\"urn:oasis:names:tc:SAML:1.1:nameid-format:unspecified\">7D6jICuQMUSD+KNdnKEPdA==</saml:NameIdentifier><saml:SubjectConfirmation><saml:ConfirmationMethod>urn:oasis:names:tc:SAML:1.0:cm:bearer</saml:ConfirmationMethod></saml:SubjectConfirmation></saml:Subject></saml:AuthenticationStatement><Signature xmlns=\"http://www.w3.org/2000/09/xmldsig#\"><SignedInfo><CanonicalizationMethod Algorithm=\"http://www.w3.org/2001/10/xml-exc-c14n#\" /><SignatureMethod Algorithm=\"http://www.w3.org/2001/04/xmldsig-more#rsa-sha256\" /><Reference URI=\"#_f2213857-b9ac-45db-8ba1-68450a8d2bd2\"><Transforms><Transform Algorithm=\"http://www.w3.org/2000/09/xmldsig#enveloped-signature\" /><Transform Algorithm=\"http://www.w3.org/2001/10/xml-exc-c14n#\" /></Transforms><DigestMethod Algorithm=\"http://www.w3.org/2001/04/xmlenc#sha256\" /><DigestValue>YLPwT1nfR/0hEwFY03O7GxrEW/GVDnXm9Jk1+341qSY=</DigestValue></Reference></SignedInfo><SignatureValue>gYh7g7nKSMnyChED35ovfMuD7NgOWMLAfu2VZXi6lV+n92opQR7oS7ujNfGj1ZETs174dQqd9S6sZyB1ydBnKIIe3v+MHxd90AqKvxiuCevQVpMQwpRWAA07/GcUnSEE4OQoVd7ODK57vJfWMaSE6sfk7L6bl6XZMwKJbzK/XRhscYAecIkNLUfacJRl9cL6zMXokBaXlgS6yd1ezPPkABzLtXCZSc2nY9kYORNArSQXla3LgG2UVR8GHsdLmNaB/9ufueneHby+yluVDzJN6R/aIC4ORZjVtFdJQ/eFdYtdRdF4gUk765tn1xaTdWn3ISpO3TYOcE6xWtRdTqy17g==</SignatureValue><KeyInfo><X509Data><X509Certificate>MIIHqzCCBpOgAwIBAgIKOFbvRQADAAF6LDANBgkqhkiG9w0BAQsFADBTMRMwEQYKCZImiZPyLGQBGRYDQ09NMRMwEQYKCZImiZPyLGQBGRYDQUJCMQwwCgYDVQQKEwNBQkIxGTAXBgNVBAMTEEFCQiBJc3N1aW5nIENBIDMwHhcNMTUwNzAxMjEyNzA5WhcNMjAwNTE0MTYwNjQ2WjB1MQswCQYDVQQGEwJDSDEOMAwGA1UEBxMFQmFkZW4xJTAjBgNVBAoTHEFCQiBJbmZvcm1hdGlvbiBTeXN0ZW1zIEx0ZC4xFjAUBgNVBAsTDUFEIEZTIFNpZ25pbmcxFzAVBgNVBAMTDnN0c2ludC5hYmIuY29tMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAuERLBSH7XVVVijsIP+YctHDxWTmpbfGjoeRFWqbyMKKxiEVLdADUGGDicrwV61FaDlCZhs9Jt23kB5yTR2474wmbX5Mf5VNBC4sEcopLqRe2IE7yaANfS8T7CeBOU/7F2yvoAJSsmYF9P1g2Iqyq0Z/BdBU3ygrDIaqp/vnAm4TGGxD29+f0XHyAvLgeFwsoQVsAlPIkh0nhi5wR62b7hM41iy0pK8hu0fBbUl3SCv9WCg/Bj0TxIXMAIOS1UaLDpyzpNFNV1MZKGF9YkSN/Fp4X/WEepx7SwWxw51WYZeGg3i2kSnGkniWNULgvMMLJK/vlYRhymEZMi/nTaE9y8wIDAQABo4IEXTCCBFkwCwYDVR0PBAQDAgWgMB0GA1UdDgQWBBTHsnHIQKViab0y2kh2vLPv6ax4OjAmBgNVHREEHzAdghtBREZTLVNpZ25pbmctU1RTSU5ULmFiYi5jb20wHwYDVR0jBBgwFoAUq5M6ES29PZ/ozYvFtNpEJv+ADYcwggFrBgNVHR8EggFiMIIBXjCCAVqgggFWoIIBUoYraHR0cDovL2NybC5wa2kuYWJiLmNvbS9BQkJJc3N1aW5nQ0EzKDMpLmNybIaBqGxkYXA6Ly8vQ049QUJCSXNzdWluZ0NBMygzKSxDTj1DRFAsQ049UHVibGljJTIwS2V5JTIwU2VydmljZXMsQ049U2VydmljZXMsQ049Q29uZmlndXJhdGlvbixEQz1hYmIsREM9Y29tP2NlcnRpZmljYXRlUmV2b2NhdGlvbkxpc3Q/YmFzZT9vYmplY3RDbGFzcz1jUkxEaXN0cmlidXRpb25Qb2ludIZ4bGRhcDovL2NybC5wa2kuYWJiLmNvbS9DTj1BQkJJc3N1aW5nQ0EzKDMpLENOPUNEUCxDTj1QS0k/Y2VydGlmaWNhdGVSZXZvY2F0aW9uTGlzdD9iYXNlP29iamVjdENsYXNzPWNSTERpc3RyaWJ1dGlvblBvaW50MIIBmAYIKwYBBQUHAQEEggGKMIIBhjA3BggrBgEFBQcwAoYraHR0cDovL2FpYS5wa2kuYWJiLmNvbS9BQkJJc3N1aW5nQ0EzKDMpLmNydDCBqAYIKwYBBQUHMAKGgZtsZGFwOi8vL0NOPUFCQklzc3VpbmdDQTMsQ049QUlBLENOPVB1YmxpYyUyMEtleSUyMFNlcnZpY2VzLENOPVNlcnZpY2VzLENOPUNvbmZpZ3VyYXRpb24sREM9YWJiLERDPWNvbT9jQUNlcnRpZmljYXRlP2Jhc2U/b2JqZWN0Q2xhc3M9Y2VydGlmaWNhdGlvbkF1dGhvcml0eTB3BggrBgEFBQcwAoZrbGRhcDovL2FpYS5wa2kuYWJiLmNvbS9DTj1BQkJJc3N1aW5nQ0EzLENOPUFJQSxDTj1QS0k/Y0FDZXJ0aWZpY2F0ZT9iYXNlP29iamVjdENsYXNzPWNlcnRpZmljYXRpb25BdXRob3JpdHkwJwYIKwYBBQUHMAGGG2h0dHA6Ly9haWEucGtpLmFiYi5jb20vb2NzcDA8BgkrBgEEAYI3FQcELzAtBiUrBgEEAYI3FQjHqCaGsIR6hrWLCoLqjWqEj60hKYGNt0iD7+tTAgFkAgENMB0GA1UdJQQWMBQGCCsGAQUFBwMCBggrBgEFBQcDATBRBgNVHSAESjBIMEYGDCsGAQQBgdcHAR4KAjA2MDQGCCsGAQUFBwIBFihodHRwOi8vY3AucGtpLmFiYi5jb20vU1NMU2VydmVySW50ZXJuYWwvMCcGCSsGAQQBgjcVCgQaMBgwCgYIKwYBBQUHAwIwCgYIKwYBBQUHAwEwDQYJKoZIhvcNAQELBQADggEBABnaaISWCQ5stI9VUa+OqZNZeFvXyTyaM1VSyqIaEt55K8H5ts7Lte6BcBddjTxQuxRrSYRGzxA2An0SFD79/IhFy07Et0psPNaciWq7yhkIHWO2XeBfKWietIb78Ose98su1jgdyzf7UqSa8EZu6rrPzGab285WBEKCYaOY9746lFOmChUh9af+X+0AdN99SglGLL5/1qSHgFZL5+MHbeaXZ8HJwjG2bIEBtZM5ydoJi+cKGpidhh9UJjwpzXBLsCVzPr/ZYjozVhJYgpY8Rx9z4+80r2YslbByd8KphT+KV9LMFc06CW4/yz91lyXpE19Iwyyrr3TRuJ1AYYuQWFs=</X509Certificate></X509Data></KeyInfo></Signature></saml:Assertion></t:RequestedSecurityToken><t:RequestedAttachedReference><o:SecurityTokenReference k:TokenType=\"http://docs.oasis-open.org/wss/oasis-wss-saml-token-profile-1.1#SAMLV1.1\" xmlns:k=\"http://docs.oasis-open.org/wss/oasis-wss-wssecurity-secext-1.1.xsd\" xmlns:o=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\"><o:KeyIdentifier ValueType=\"http://docs.oasis-open.org/wss/oasis-wss-saml-token-profile-1.0#SAMLAssertionID\">_f2213857-b9ac-45db-8ba1-68450a8d2bd2</o:KeyIdentifier></o:SecurityTokenReference></t:RequestedAttachedReference><t:RequestedUnattachedReference><o:SecurityTokenReference k:TokenType=\"http://docs.oasis-open.org/wss/oasis-wss-saml-token-profile-1.1#SAMLV1.1\" xmlns:k=\"http://docs.oasis-open.org/wss/oasis-wss-wssecurity-secext-1.1.xsd\" xmlns:o=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\"><o:KeyIdentifier ValueType=\"http://docs.oasis-open.org/wss/oasis-wss-saml-token-profile-1.0#SAMLAssertionID\">_f2213857-b9ac-45db-8ba1-68450a8d2bd2</o:KeyIdentifier></o:SecurityTokenReference></t:RequestedUnattachedReference><t:TokenType>urn:oasis:names:tc:SAML:1.0:assertion</t:TokenType><t:RequestType>http://schemas.xmlsoap.org/ws/2005/02/trust/Issue</t:RequestType><t:KeyType>http://schemas.xmlsoap.org/ws/2005/05/identity/NoProofKey</t:KeyType></t:RequestSecurityTokenResponse>
			log("<<< vWresult_2 = " + vWresult_2);
		}
		catch (Exception e) { vWresult_2 = null; log(e); }
		if (vWresult_2 == null)
		{
			// failure - dump wrong response content and abort current outer loop - after that start next loop
			String errorText = "*** error: unable to extract var 'vWresult_2' from html form parameter";
			log(errorText);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			threadStep = performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_USER_SPECIFIC_TEST_FAILED, errorText, testURL, this);
		
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		try
		{
			// extract var 'vWctx_2'
			vWctx_2 = htmlContentParser.getFormTable().getForm("hiddenform").getFormItemValue("wctx");		// recorded value = 02bc8c5b-9f24-4e1f-958e-6cf760be8678
			log("<<< vWctx_2 = " + vWctx_2);
		}
		catch (Exception e) { vWctx_2 = null; log(e); }
		if (vWctx_2 == null)
		{
			// failure - dump wrong response content and abort current outer loop - after that start next loop
			String errorText = "*** error: unable to extract var 'vWctx_2' from html form parameter";
			log(errorText);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			threadStep = performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_USER_SPECIFIC_TEST_FAILED, errorText, testURL, this);
		
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [33] <- WEB ADMIN Index 33 ---
		log();
		log("# title: Working...");
		String requestProt0033 = "https";
		String requestHost0033 = "stsint.abb.com";
		int    requestPort0033 = 443;
		String requestFile0033 = "/adfs/ls/";
		String requestContent0033 = 
				"wa=wsignin1.0" +
				"&wresult=" + java.net.URLEncoder.encode(vWresult_2) +		// recorded value = %3Ct%3ARequestSecurityTokenResponse+Context%3D%2202bc8c5b-9f24-4e1f-958e-6cf760be8678%22+xmlns%3At%3D%22http%3A%2F%2Fschemas.xmlsoap.org%2Fws%2F2005%2F02%2Ftrust%22%3E%3Ct%3ALifetime%3E%3Cwsu%3ACreated+xmlns%3Awsu%3D%22http%3A%2F%2Fdocs.oasis-open.org%2Fwss%2F2004%2F01%2Foasis-200401-wss-wssecurity-utility-1.0.xsd%22%3E2016-12-20T10%3A17%3A16.928Z%3C%2Fwsu%3ACreated%3E%3Cwsu%3AExpires+xmlns%3Awsu%3D%22http%3A%2F%2Fdocs.oasis-open.org%2Fwss%2F2004%2F01%2Foasis-200401-wss-wssecurity-utility-1.0.xsd%22%3E2016-12-20T18%3A17%3A16.928Z%3C%2Fwsu%3AExpires%3E%3C%2Ft%3ALifetime%3E%3Cwsp%3AAppliesTo+xmlns%3Awsp%3D%22http%3A%2F%2Fschemas.xmlsoap.org%2Fws%2F2004%2F09%2Fpolicy%22%3E%3Cwsa%3AEndpointReference+xmlns%3Awsa%3D%22http%3A%2F%2Fwww.w3.org%2F2005%2F08%2Faddressing%22%3E%3Cwsa%3AAddress%3Ehttp%3A%2F%2Fstsint.abb.com%2Fadfs%2Fservices%2Ftrust%3C%2Fwsa%3AAddress%3E%3C%2Fwsa%3AEndpointReference%3E%3C%2Fwsp%3AAppliesTo%3E%3Ct%3ARequestedSecurityToken%3E%3Csaml%3AAssertion+MajorVersion%3D%221%22+MinorVersion%3D%221%22+AssertionID%3D%22_f2213857-b9ac-45db-8ba1-68450a8d2bd2%22+Issuer%3D%22https%3A%2F%2Fstsint.abb.com%2Fvissts%22+IssueInstant%3D%222016-12-20T10%3A17%3A16.928Z%22+xmlns%3Asaml%3D%22urn%3Aoasis%3Anames%3Atc%3ASAML%3A1.0%3Aassertion%22%3E%3Csaml%3AConditions+NotBefore%3D%222016-12-20T10%3A17%3A16.928Z%22+NotOnOrAfter%3D%222016-12-20T18%3A17%3A16.928Z%22%3E%3Csaml%3AAudienceRestrictionCondition%3E%3Csaml%3AAudience%3Ehttp%3A%2F%2Fstsint.abb.com%2Fadfs%2Fservices%2Ftrust%3C%2Fsaml%3AAudience%3E%3C%2Fsaml%3AAudienceRestrictionCondition%3E%3C%2Fsaml%3AConditions%3E%3Csaml%3AAttributeStatement%3E%3Csaml%3ASubject%3E%3Csaml%3ANameIdentifier+Format%3D%22urn%3Aoasis%3Anames%3Atc%3ASAML%3A1.1%3Anameid-format%3Aunspecified%22%3E7D6jICuQMUSD%2BKNdnKEPdA%3D%3D%3C%2Fsaml%3ANameIdentifier%3E%3Csaml%3ASubjectConfirmation%3E%3Csaml%3AConfirmationMethod%3Eurn%3Aoasis%3Anames%3Atc%3ASAML%3A1.0%3Acm%3Abearer%3C%2Fsaml%3AConfirmationMethod%3E%3C%2Fsaml%3ASubjectConfirmation%3E%3C%2Fsaml%3ASubject%3E%3Csaml%3AAttribute+AttributeName%3D%22ImmutableID%22+AttributeNamespace%3D%22http%3A%2F%2Fschemas.microsoft.com%2FLiveID%2FFederation%2F2008%2F05%22%3E%3Csaml%3AAttributeValue%3E7D6jICuQMUSD%2BKNdnKEPdA%3D%3D%3C%2Fsaml%3AAttributeValue%3E%3C%2Fsaml%3AAttribute%3E%3Csaml%3AAttribute+AttributeName%3D%22emailaddress%22+AttributeNamespace%3D%22http%3A%2F%2Fschemas.xmlsoap.org%2Fws%2F2005%2F05%2Fidentity%2Fclaims%22%3E%3Csaml%3AAttributeValue%3Emcp.test.ari%40gmail.com%3C%2Fsaml%3AAttributeValue%3E%3C%2Fsaml%3AAttribute%3E%3Csaml%3AAttribute+AttributeName%3D%22upn%22+AttributeNamespace%3D%22http%3A%2F%2Fschemas.xmlsoap.org%2Fws%2F2005%2F05%2Fidentity%2Fclaims%22%3E%3Csaml%3AAttributeValue%3Emcp.test.ari%40gmail.com%3C%2Fsaml%3AAttributeValue%3E%3C%2Fsaml%3AAttribute%3E%3Csaml%3AAttribute+AttributeName%3D%22UPN%22+AttributeNamespace%3D%22http%3A%2F%2Fschemas.xmlsoap.org%2Fclaims%22%3E%3Csaml%3AAttributeValue%3Emcp.test.ari%40gmail.com%3C%2Fsaml%3AAttributeValue%3E%3C%2Fsaml%3AAttribute%3E%3C%2Fsaml%3AAttributeStatement%3E%3Csaml%3AAuthenticationStatement+AuthenticationMethod%3D%22urn%3Afederation%3Aauthentication%3Awindows%22+AuthenticationInstant%3D%222016-12-20T10%3A17%3A16.928Z%22%3E%3Csaml%3ASubject%3E%3Csaml%3ANameIdentifier+Format%3D%22urn%3Aoasis%3Anames%3Atc%3ASAML%3A1.1%3Anameid-format%3Aunspecified%22%3E7D6jICuQMUSD%2BKNdnKEPdA%3D%3D%3C%2Fsaml%3ANameIdentifier%3E%3Csaml%3ASubjectConfirmation%3E%3Csaml%3AConfirmationMethod%3Eurn%3Aoasis%3Anames%3Atc%3ASAML%3A1.0%3Acm%3Abearer%3C%2Fsaml%3AConfirmationMethod%3E%3C%2Fsaml%3ASubjectConfirmation%3E%3C%2Fsaml%3ASubject%3E%3C%2Fsaml%3AAuthenticationStatement%3E%3CSignature+xmlns%3D%22http%3A%2F%2Fwww.w3.org%2F2000%2F09%2Fxmldsig%23%22%3E%3CSignedInfo%3E%3CCanonicalizationMethod+Algorithm%3D%22http%3A%2F%2Fwww.w3.org%2F2001%2F10%2Fxml-exc-c14n%23%22+%2F%3E%3CSignatureMethod+Algorithm%3D%22http%3A%2F%2Fwww.w3.org%2F2001%2F04%2Fxmldsig-more%23rsa-sha256%22+%2F%3E%3CReference+URI%3D%22%23_f2213857-b9ac-45db-8ba1-68450a8d2bd2%22%3E%3CTransforms%3E%3CTransform+Algorithm%3D%22http%3A%2F%2Fwww.w3.org%2F2000%2F09%2Fxmldsig%23enveloped-signature%22+%2F%3E%3CTransform+Algorithm%3D%22http%3A%2F%2Fwww.w3.org%2F2001%2F10%2Fxml-exc-c14n%23%22+%2F%3E%3C%2FTransforms%3E%3CDigestMethod+Algorithm%3D%22http%3A%2F%2Fwww.w3.org%2F2001%2F04%2Fxmlenc%23sha256%22+%2F%3E%3CDigestValue%3EYLPwT1nfR%2F0hEwFY03O7GxrEW%2FGVDnXm9Jk1%2B341qSY%3D%3C%2FDigestValue%3E%3C%2FReference%3E%3C%2FSignedInfo%3E%3CSignatureValue%3EgYh7g7nKSMnyChED35ovfMuD7NgOWMLAfu2VZXi6lV%2Bn92opQR7oS7ujNfGj1ZETs174dQqd9S6sZyB1ydBnKIIe3v%2BMHxd90AqKvxiuCevQVpMQwpRWAA07%2FGcUnSEE4OQoVd7ODK57vJfWMaSE6sfk7L6bl6XZMwKJbzK%2FXRhscYAecIkNLUfacJRl9cL6zMXokBaXlgS6yd1ezPPkABzLtXCZSc2nY9kYORNArSQXla3LgG2UVR8GHsdLmNaB%2F9ufueneHby%2ByluVDzJN6R%2FaIC4ORZjVtFdJQ%2FeFdYtdRdF4gUk765tn1xaTdWn3ISpO3TYOcE6xWtRdTqy17g%3D%3D%3C%2FSignatureValue%3E%3CKeyInfo%3E%3CX509Data%3E%3CX509Certificate%3EMIIHqzCCBpOgAwIBAgIKOFbvRQADAAF6LDANBgkqhkiG9w0BAQsFADBTMRMwEQYKCZImiZPyLGQBGRYDQ09NMRMwEQYKCZImiZPyLGQBGRYDQUJCMQwwCgYDVQQKEwNBQkIxGTAXBgNVBAMTEEFCQiBJc3N1aW5nIENBIDMwHhcNMTUwNzAxMjEyNzA5WhcNMjAwNTE0MTYwNjQ2WjB1MQswCQYDVQQGEwJDSDEOMAwGA1UEBxMFQmFkZW4xJTAjBgNVBAoTHEFCQiBJbmZvcm1hdGlvbiBTeXN0ZW1zIEx0ZC4xFjAUBgNVBAsTDUFEIEZTIFNpZ25pbmcxFzAVBgNVBAMTDnN0c2ludC5hYmIuY29tMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAuERLBSH7XVVVijsIP%2BYctHDxWTmpbfGjoeRFWqbyMKKxiEVLdADUGGDicrwV61FaDlCZhs9Jt23kB5yTR2474wmbX5Mf5VNBC4sEcopLqRe2IE7yaANfS8T7CeBOU%2F7F2yvoAJSsmYF9P1g2Iqyq0Z%2FBdBU3ygrDIaqp%2FvnAm4TGGxD29%2Bf0XHyAvLgeFwsoQVsAlPIkh0nhi5wR62b7hM41iy0pK8hu0fBbUl3SCv9WCg%2FBj0TxIXMAIOS1UaLDpyzpNFNV1MZKGF9YkSN%2FFp4X%2FWEepx7SwWxw51WYZeGg3i2kSnGkniWNULgvMMLJK%2FvlYRhymEZMi%2FnTaE9y8wIDAQABo4IEXTCCBFkwCwYDVR0PBAQDAgWgMB0GA1UdDgQWBBTHsnHIQKViab0y2kh2vLPv6ax4OjAmBgNVHREEHzAdghtBREZTLVNpZ25pbmctU1RTSU5ULmFiYi5jb20wHwYDVR0jBBgwFoAUq5M6ES29PZ%2FozYvFtNpEJv%2BADYcwggFrBgNVHR8EggFiMIIBXjCCAVqgggFWoIIBUoYraHR0cDovL2NybC5wa2kuYWJiLmNvbS9BQkJJc3N1aW5nQ0EzKDMpLmNybIaBqGxkYXA6Ly8vQ049QUJCSXNzdWluZ0NBMygzKSxDTj1DRFAsQ049UHVibGljJTIwS2V5JTIwU2VydmljZXMsQ049U2VydmljZXMsQ049Q29uZmlndXJhdGlvbixEQz1hYmIsREM9Y29tP2NlcnRpZmljYXRlUmV2b2NhdGlvbkxpc3Q%2FYmFzZT9vYmplY3RDbGFzcz1jUkxEaXN0cmlidXRpb25Qb2ludIZ4bGRhcDovL2NybC5wa2kuYWJiLmNvbS9DTj1BQkJJc3N1aW5nQ0EzKDMpLENOPUNEUCxDTj1QS0k%2FY2VydGlmaWNhdGVSZXZvY2F0aW9uTGlzdD9iYXNlP29iamVjdENsYXNzPWNSTERpc3RyaWJ1dGlvblBvaW50MIIBmAYIKwYBBQUHAQEEggGKMIIBhjA3BggrBgEFBQcwAoYraHR0cDovL2FpYS5wa2kuYWJiLmNvbS9BQkJJc3N1aW5nQ0EzKDMpLmNydDCBqAYIKwYBBQUHMAKGgZtsZGFwOi8vL0NOPUFCQklzc3VpbmdDQTMsQ049QUlBLENOPVB1YmxpYyUyMEtleSUyMFNlcnZpY2VzLENOPVNlcnZpY2VzLENOPUNvbmZpZ3VyYXRpb24sREM9YWJiLERDPWNvbT9jQUNlcnRpZmljYXRlP2Jhc2U%2Fb2JqZWN0Q2xhc3M9Y2VydGlmaWNhdGlvbkF1dGhvcml0eTB3BggrBgEFBQcwAoZrbGRhcDovL2FpYS5wa2kuYWJiLmNvbS9DTj1BQkJJc3N1aW5nQ0EzLENOPUFJQSxDTj1QS0k%2FY0FDZXJ0aWZpY2F0ZT9iYXNlP29iamVjdENsYXNzPWNlcnRpZmljYXRpb25BdXRob3JpdHkwJwYIKwYBBQUHMAGGG2h0dHA6Ly9haWEucGtpLmFiYi5jb20vb2NzcDA8BgkrBgEEAYI3FQcELzAtBiUrBgEEAYI3FQjHqCaGsIR6hrWLCoLqjWqEj60hKYGNt0iD7%2BtTAgFkAgENMB0GA1UdJQQWMBQGCCsGAQUFBwMCBggrBgEFBQcDATBRBgNVHSAESjBIMEYGDCsGAQQBgdcHAR4KAjA2MDQGCCsGAQUFBwIBFihodHRwOi8vY3AucGtpLmFiYi5jb20vU1NMU2VydmVySW50ZXJuYWwvMCcGCSsGAQQBgjcVCgQaMBgwCgYIKwYBBQUHAwIwCgYIKwYBBQUHAwEwDQYJKoZIhvcNAQELBQADggEBABnaaISWCQ5stI9VUa%2BOqZNZeFvXyTyaM1VSyqIaEt55K8H5ts7Lte6BcBddjTxQuxRrSYRGzxA2An0SFD79%2FIhFy07Et0psPNaciWq7yhkIHWO2XeBfKWietIb78Ose98su1jgdyzf7UqSa8EZu6rrPzGab285WBEKCYaOY9746lFOmChUh9af%2BX%2B0AdN99SglGLL5%2F1qSHgFZL5%2BMHbeaXZ8HJwjG2bIEBtZM5ydoJi%2BcKGpidhh9UJjwpzXBLsCVzPr%2FZYjozVhJYgpY8Rx9z4%2B80r2YslbByd8KphT%2BKV9LMFc06CW4%2Fyz91lyXpE19Iwyyrr3TRuJ1AYYuQWFs%3D%3C%2FX509Certificate%3E%3C%2FX509Data%3E%3C%2FKeyInfo%3E%3C%2FSignature%3E%3C%2Fsaml%3AAssertion%3E%3C%2Ft%3ARequestedSecurityToken%3E%3Ct%3ARequestedAttachedReference%3E%3Co%3ASecurityTokenReference+k%3ATokenType%3D%22http%3A%2F%2Fdocs.oasis-open.org%2Fwss%2Foasis-wss-saml-token-profile-1.1%23SAMLV1.1%22+xmlns%3Ak%3D%22http%3A%2F%2Fdocs.oasis-open.org%2Fwss%2Foasis-wss-wssecurity-secext-1.1.xsd%22+xmlns%3Ao%3D%22http%3A%2F%2Fdocs.oasis-open.org%2Fwss%2F2004%2F01%2Foasis-200401-wss-wssecurity-secext-1.0.xsd%22%3E%3Co%3AKeyIdentifier+ValueType%3D%22http%3A%2F%2Fdocs.oasis-open.org%2Fwss%2Foasis-wss-saml-token-profile-1.0%23SAMLAssertionID%22%3E_f2213857-b9ac-45db-8ba1-68450a8d2bd2%3C%2Fo%3AKeyIdentifier%3E%3C%2Fo%3ASecurityTokenReference%3E%3C%2Ft%3ARequestedAttachedReference%3E%3Ct%3ARequestedUnattachedReference%3E%3Co%3ASecurityTokenReference+k%3ATokenType%3D%22http%3A%2F%2Fdocs.oasis-open.org%2Fwss%2Foasis-wss-saml-token-profile-1.1%23SAMLV1.1%22+xmlns%3Ak%3D%22http%3A%2F%2Fdocs.oasis-open.org%2Fwss%2Foasis-wss-wssecurity-secext-1.1.xsd%22+xmlns%3Ao%3D%22http%3A%2F%2Fdocs.oasis-open.org%2Fwss%2F2004%2F01%2Foasis-200401-wss-wssecurity-secext-1.0.xsd%22%3E%3Co%3AKeyIdentifier+ValueType%3D%22http%3A%2F%2Fdocs.oasis-open.org%2Fwss%2Foasis-wss-saml-token-profile-1.0%23SAMLAssertionID%22%3E_f2213857-b9ac-45db-8ba1-68450a8d2bd2%3C%2Fo%3AKeyIdentifier%3E%3C%2Fo%3ASecurityTokenReference%3E%3C%2Ft%3ARequestedUnattachedReference%3E%3Ct%3ATokenType%3Eurn%3Aoasis%3Anames%3Atc%3ASAML%3A1.0%3Aassertion%3C%2Ft%3ATokenType%3E%3Ct%3ARequestType%3Ehttp%3A%2F%2Fschemas.xmlsoap.org%2Fws%2F2005%2F02%2Ftrust%2FIssue%3C%2Ft%3ARequestType%3E%3Ct%3AKeyType%3Ehttp%3A%2F%2Fschemas.xmlsoap.org%2Fws%2F2005%2F05%2Fidentity%2FNoProofKey%3C%2Ft%3AKeyType%3E%3C%2Ft%3ARequestSecurityTokenResponse%3E
				"&wctx=" + java.net.URLEncoder.encode(vWctx_2);		// recorded value = 02bc8c5b-9f24-4e1f-958e-6cf760be8678
		String requestHeader0033 = "POST " + requestFile0033 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: stsint.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"Upgrade-Insecure-Requests: 1\r\n" + 
				"Content-Type: application/x-www-form-urlencoded\r\n" + 
				"Content-Length: " + requestContent0033.length() + "\r\n" + 		// Content-Length: 9472
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0033, requestHost0033, requestPort0033, requestHeader0033, requestContent0033.getBytes(), requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		if (debugLoops)
		{
			if (Lib.isAsciiContent(testURL.getRequestContent(), 256))
				log(">>> " + new String(testURL.getRequestContent()));
			else
				log(">>> [binary data]");
		}

		testURL.execute(performanceData);
		requestHeader0033 = null;		// support garbage collector to reduce memory
		requestContent0033 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 8557
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, null);		// Test [33] <- Index 33
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// extract variable(s) from response
		htmlContentParser = new HtmlContentParser(testURL, this);
		try
		{
			// extract var 'vSAMLResponse_1'
			vSAMLResponse_1 = htmlContentParser.getFormTable().getForm("hiddenform").getFormItemValue("SAMLResponse");		// recorded value = PHNhbWxwOlJlc3BvbnNlIElEPSJfMDQ0YWU0MDMtYzdlNS00YmQ0LWFlN2ItM2MxMzJkZjA2M2RjIiBWZXJzaW9uPSIyLjAiIElzc3VlSW5zdGFudD0iMjAxNi0xMi0yMFQxMDoxNzoxNy43MzNaIiBEZXN0aW5hdGlvbj0iaHR0cHM6Ly9teXBvcnRhbC5hYmIuY29tLyIgQ29uc2VudD0idXJuOm9hc2lzOm5hbWVzOnRjOlNBTUw6Mi4wOmNvbnNlbnQ6dW5zcGVjaWZpZWQiIHhtbG5zOnNhbWxwPSJ1cm46b2FzaXM6bmFtZXM6dGM6U0FNTDoyLjA6cHJvdG9jb2wiPjxJc3N1ZXIgeG1sbnM9InVybjpvYXNpczpuYW1lczp0YzpTQU1MOjIuMDphc3NlcnRpb24iPmh0dHA6Ly9zdHNpbnQuYWJiLmNvbS9hZGZzL3NlcnZpY2VzL3RydXN0PC9Jc3N1ZXI+PHNhbWxwOlN0YXR1cz48c2FtbHA6U3RhdHVzQ29kZSBWYWx1ZT0idXJuOm9hc2lzOm5hbWVzOnRjOlNBTUw6Mi4wOnN0YXR1czpTdWNjZXNzIiAvPjwvc2FtbHA6U3RhdHVzPjxBc3NlcnRpb24gSUQ9Il8xZTU1MmZhZS1lY2QxLTQwZmMtOWMzMC0wYjdjNmRhZTFlZTYiIElzc3VlSW5zdGFudD0iMjAxNi0xMi0yMFQxMDoxNzoxNy43MzNaIiBWZXJzaW9uPSIyLjAiIHhtbG5zPSJ1cm46b2FzaXM6bmFtZXM6dGM6U0FNTDoyLjA6YXNzZXJ0aW9uIj48SXNzdWVyPmh0dHA6Ly9zdHNpbnQuYWJiLmNvbS9hZGZzL3NlcnZpY2VzL3RydXN0PC9Jc3N1ZXI+PGRzOlNpZ25hdHVyZSB4bWxuczpkcz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC8wOS94bWxkc2lnIyI+PGRzOlNpZ25lZEluZm8+PGRzOkNhbm9uaWNhbGl6YXRpb25NZXRob2QgQWxnb3JpdGhtPSJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzEwL3htbC1leGMtYzE0biMiIC8+PGRzOlNpZ25hdHVyZU1ldGhvZCBBbGdvcml0aG09Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvMDkveG1sZHNpZyNyc2Etc2hhMSIgLz48ZHM6UmVmZXJlbmNlIFVSST0iI18xZTU1MmZhZS1lY2QxLTQwZmMtOWMzMC0wYjdjNmRhZTFlZTYiPjxkczpUcmFuc2Zvcm1zPjxkczpUcmFuc2Zvcm0gQWxnb3JpdGhtPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwLzA5L3htbGRzaWcjZW52ZWxvcGVkLXNpZ25hdHVyZSIgLz48ZHM6VHJhbnNmb3JtIEFsZ29yaXRobT0iaHR0cDovL3d3dy53My5vcmcvMjAwMS8xMC94bWwtZXhjLWMxNG4jIiAvPjwvZHM6VHJhbnNmb3Jtcz48ZHM6RGlnZXN0TWV0aG9kIEFsZ29yaXRobT0iaHR0cDovL3d3dy53My5vcmcvMjAwMC8wOS94bWxkc2lnI3NoYTEiIC8+PGRzOkRpZ2VzdFZhbHVlPmozeE5HZC9QNHJzcUpIU2gwS3dQazBHTWxlVT08L2RzOkRpZ2VzdFZhbHVlPjwvZHM6UmVmZXJlbmNlPjwvZHM6U2lnbmVkSW5mbz48ZHM6U2lnbmF0dXJlVmFsdWU+TlVMWTdnTm9mbG4yUStJQ2VGT1lPWFM2RnJhQ0FXQXkrNWczZjMwUVVjV1JSdXR0cXJLZ1o2OHorNUo0NEhpNi92YzEvK1ZoMVpJU0lIWEhVbjBiYkFBalFLNG9pZVNkVkFHMEROZ0dUN1BPaHJCRDk5MzBaNWZ5VW9ZNFNzTHpCZ2FXQ2Frdm8wYmhwWUd5aVFCdVQ0UFo1NnEvbFZTcWV5bHU4cWwwM1Nxc2wwNHpxNXpXM3JXR3BYK3lTTVQrU3g2aTEzR0ZDOXJ6bDV4aDI0L1FKcjA1YVFzVTRQMndncFpGVk1oRmNSUUJYZU1mbHVHb0ZCYXM3ZXBYOC9RNW5veUsrSnZxMVppVE5oYnN6eHp3ZzFyOThRVG0zN1d2bGYxQTNuV0Y3VVV3d1FVcHo4WFQ4NVcxRDUyKzQzbW1pR3JCeXJPUHhJd1ZrWTRnNTRZVnJBPT08L2RzOlNpZ25hdHVyZVZhbHVlPjxLZXlJbmZvIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwLzA5L3htbGRzaWcjIj48ZHM6WDUwOURhdGE+PGRzOlg1MDlDZXJ0aWZpY2F0ZT5NSUlIcXpDQ0JwT2dBd0lCQWdJS09GYnZSUUFEQUFGNkxEQU5CZ2txaGtpRzl3MEJBUXNGQURCVE1STXdFUVlLQ1pJbWlaUHlMR1FCR1JZRFEwOU5NUk13RVFZS0NaSW1pWlB5TEdRQkdSWURRVUpDTVF3d0NnWURWUVFLRXdOQlFrSXhHVEFYQmdOVkJBTVRFRUZDUWlCSmMzTjFhVzVuSUVOQklETXdIaGNOTVRVd056QXhNakV5TnpBNVdoY05NakF3TlRFME1UWXdOalEyV2pCMU1Rc3dDUVlEVlFRR0V3SkRTREVPTUF3R0ExVUVCeE1GUW1Ga1pXNHhKVEFqQmdOVkJBb1RIRUZDUWlCSmJtWnZjbTFoZEdsdmJpQlRlWE4wWlcxeklFeDBaQzR4RmpBVUJnTlZCQXNURFVGRUlFWlRJRk5wWjI1cGJtY3hGekFWQmdOVkJBTVREbk4wYzJsdWRDNWhZbUl1WTI5dE1JSUJJakFOQmdrcWhraUc5dzBCQVFFRkFBT0NBUThBTUlJQkNnS0NBUUVBdUVSTEJTSDdYVlZWaWpzSVArWWN0SER4V1RtcGJmR2pvZVJGV3FieU1LS3hpRVZMZEFEVUdHRGljcndWNjFGYURsQ1poczlKdDIza0I1eVRSMjQ3NHdtYlg1TWY1Vk5CQzRzRWNvcExxUmUySUU3eWFBTmZTOFQ3Q2VCT1UvN0YyeXZvQUpTc21ZRjlQMWcySXF5cTBaL0JkQlUzeWdyRElhcXAvdm5BbTRUR0d4RDI5K2YwWEh5QXZMZ2VGd3NvUVZzQWxQSWtoMG5oaTV3UjYyYjdoTTQxaXkwcEs4aHUwZkJiVWwzU0N2OVdDZy9CajBUeElYTUFJT1MxVWFMRHB5enBORk5WMU1aS0dGOVlrU04vRnA0WC9XRWVweDdTd1d4dzUxV1laZUdnM2kya1NuR2tuaVdOVUxndk1NTEpLL3ZsWVJoeW1FWk1pL25UYUU5eTh3SURBUUFCbzRJRVhUQ0NCRmt3Q3dZRFZSMFBCQVFEQWdXZ01CMEdBMVVkRGdRV0JCVEhzbkhJUUtWaWFiMHkya2gydkxQdjZheDRPakFtQmdOVkhSRUVIekFkZ2h0QlJFWlRMVk5wWjI1cGJtY3RVMVJUU1U1VUxtRmlZaTVqYjIwd0h3WURWUjBqQkJnd0ZvQVVxNU02RVMyOVBaL296WXZGdE5wRUp2K0FEWWN3Z2dGckJnTlZIUjhFZ2dGaU1JSUJYakNDQVZxZ2dnRldvSUlCVW9ZcmFIUjBjRG92TDJOeWJDNXdhMmt1WVdKaUxtTnZiUzlCUWtKSmMzTjFhVzVuUTBFektETXBMbU55YklhQnFHeGtZWEE2THk4dlEwNDlRVUpDU1hOemRXbHVaME5CTXlnektTeERUajFEUkZBc1EwNDlVSFZpYkdsakpUSXdTMlY1SlRJd1UyVnlkbWxqWlhNc1EwNDlVMlZ5ZG1salpYTXNRMDQ5UTI5dVptbG5kWEpoZEdsdmJpeEVRejFoWW1Jc1JFTTlZMjl0UDJObGNuUnBabWxqWVhSbFVtVjJiMk5oZEdsdmJreHBjM1EvWW1GelpUOXZZbXBsWTNSRGJHRnpjejFqVWt4RWFYTjBjbWxpZFhScGIyNVFiMmx1ZElaNGJHUmhjRG92TDJOeWJDNXdhMmt1WVdKaUxtTnZiUzlEVGoxQlFrSkpjM04xYVc1blEwRXpLRE1wTEVOT1BVTkVVQ3hEVGoxUVMway9ZMlZ5ZEdsbWFXTmhkR1ZTWlhadlkyRjBhVzl1VEdsemREOWlZWE5sUDI5aWFtVmpkRU5zWVhOelBXTlNURVJwYzNSeWFXSjFkR2x2YmxCdmFXNTBNSUlCbUFZSUt3WUJCUVVIQVFFRWdnR0tNSUlCaGpBM0JnZ3JCZ0VGQlFjd0FvWXJhSFIwY0RvdkwyRnBZUzV3YTJrdVlXSmlMbU52YlM5QlFrSkpjM04xYVc1blEwRXpLRE1wTG1OeWREQ0JxQVlJS3dZQkJRVUhNQUtHZ1p0c1pHRndPaTh2TDBOT1BVRkNRa2x6YzNWcGJtZERRVE1zUTA0OVFVbEJMRU5PUFZCMVlteHBZeVV5TUV0bGVTVXlNRk5sY25acFkyVnpMRU5PUFZObGNuWnBZMlZ6TEVOT1BVTnZibVpwWjNWeVlYUnBiMjRzUkVNOVlXSmlMRVJEUFdOdmJUOWpRVU5sY25ScFptbGpZWFJsUDJKaGMyVS9iMkpxWldOMFEyeGhjM005WTJWeWRHbG1hV05oZEdsdmJrRjFkR2h2Y21sMGVUQjNCZ2dyQmdFRkJRY3dBb1pyYkdSaGNEb3ZMMkZwWVM1d2Eya3VZV0ppTG1OdmJTOURUajFCUWtKSmMzTjFhVzVuUTBFekxFTk9QVUZKUVN4RFRqMVFTMGsvWTBGRFpYSjBhV1pwWTJGMFpUOWlZWE5sUDI5aWFtVmpkRU5zWVhOelBXTmxjblJwWm1sallYUnBiMjVCZFhSb2IzSnBkSGt3SndZSUt3WUJCUVVITUFHR0cyaDBkSEE2THk5aGFXRXVjR3RwTG1GaVlpNWpiMjB2YjJOemNEQThCZ2tyQmdFRUFZSTNGUWNFTHpBdEJpVXJCZ0VFQVlJM0ZRakhxQ2FHc0lSNmhyV0xDb0xxaldxRWo2MGhLWUdOdDBpRDcrdFRBZ0ZrQWdFTk1CMEdBMVVkSlFRV01CUUdDQ3NHQVFVRkJ3TUNCZ2dyQmdFRkJRY0RBVEJSQmdOVkhTQUVTakJJTUVZR0RDc0dBUVFCZ2RjSEFSNEtBakEyTURRR0NDc0dBUVVGQndJQkZpaG9kSFJ3T2k4dlkzQXVjR3RwTG1GaVlpNWpiMjB2VTFOTVUyVnlkbVZ5U1c1MFpYSnVZV3d2TUNjR0NTc0dBUVFCZ2pjVkNnUWFNQmd3Q2dZSUt3WUJCUVVIQXdJd0NnWUlLd1lCQlFVSEF3RXdEUVlKS29aSWh2Y05BUUVMQlFBRGdnRUJBQm5hYUlTV0NRNXN0STlWVWErT3FaTlplRnZYeVR5YU0xVlN5cUlhRXQ1NUs4SDV0czdMdGU2QmNCZGRqVHhRdXhSclNZUkd6eEEyQW4wU0ZENzkvSWhGeTA3RXQwcHNQTmFjaVdxN3loa0lIV08yWGVCZktXaWV0SWI3OE9zZTk4c3UxamdkeXpmN1VxU2E4RVp1NnJyUHpHYWIyODVXQkVLQ1lhT1k5NzQ2bEZPbUNoVWg5YWYrWCswQWROOTlTZ2xHTEw1LzFxU0hnRlpMNStNSGJlYVhaOEhKd2pHMmJJRUJ0Wk01eWRvSmkrY0tHcGlkaGg5VUpqd3B6WEJMc0NWelByL1pZam96VmhKWWdwWThSeDl6NCs4MHIyWXNsYkJ5ZDhLcGhUK0tWOUxNRmMwNkNXNC95ejkxbHlYcEUxOUl3eXlycjNUUnVKMUFZWXVRV0ZzPTwvZHM6WDUwOUNlcnRpZmljYXRlPjwvZHM6WDUwOURhdGE+PC9LZXlJbmZvPjwvZHM6U2lnbmF0dXJlPjxTdWJqZWN0PjxOYW1lSUQgRm9ybWF0PSJ1cm46b2FzaXM6bmFtZXM6dGM6U0FNTDoyLjA6bmFtZWlkLWZvcm1hdDp0cmFuc2llbnQiPm1jcC50ZXN0LmFyaUBnbWFpbC5jb208L05hbWVJRD48U3ViamVjdENvbmZpcm1hdGlvbiBNZXRob2Q9InVybjpvYXNpczpuYW1lczp0YzpTQU1MOjIuMDpjbTpiZWFyZXIiPjxTdWJqZWN0Q29uZmlybWF0aW9uRGF0YSBOb3RPbk9yQWZ0ZXI9IjIwMTYtMTItMjBUMTA6MjI6MTcuNzMzWiIgUmVjaXBpZW50PSJodHRwczovL215cG9ydGFsLmFiYi5jb20vIiAvPjwvU3ViamVjdENvbmZpcm1hdGlvbj48L1N1YmplY3Q+PENvbmRpdGlvbnMgTm90QmVmb3JlPSIyMDE2LTEyLTIwVDEwOjE3OjE3LjY0MVoiIE5vdE9uT3JBZnRlcj0iMjAxNi0xMi0yMFQxMToxNzoxNy42NDFaIj48QXVkaWVuY2VSZXN0cmljdGlvbj48QXVkaWVuY2U+aHR0cHM6Ly9teXBvcnRhbC5hYmIuY29tPC9BdWRpZW5jZT48L0F1ZGllbmNlUmVzdHJpY3Rpb24+PC9Db25kaXRpb25zPjxBdHRyaWJ1dGVTdGF0ZW1lbnQ+PEF0dHJpYnV0ZSBOYW1lPSJodHRwOi8vc2NoZW1hcy54bWxzb2FwLm9yZy93cy8yMDA1LzA1L2lkZW50aXR5L2NsYWltcy9lbWFpbGFkZHJlc3MiPjxBdHRyaWJ1dGVWYWx1ZT5tY3AudGVzdC5hcmlAZ21haWwuY29tPC9BdHRyaWJ1dGVWYWx1ZT48L0F0dHJpYnV0ZT48QXR0cmlidXRlIE5hbWU9Imh0dHA6Ly9zY2hlbWFzLmFiYi5jb20vY2xhaW1zL3NuIj48QXR0cmlidXRlVmFsdWU+QXJpPC9BdHRyaWJ1dGVWYWx1ZT48L0F0dHJpYnV0ZT48QXR0cmlidXRlIE5hbWU9Imh0dHA6Ly9zY2hlbWFzLmFiYi5jb20vY2xhaW1zL2dpdmVubmFtZSI+PEF0dHJpYnV0ZVZhbHVlPk1jcDwvQXR0cmlidXRlVmFsdWU+PC9BdHRyaWJ1dGU+PEF0dHJpYnV0ZSBOYW1lPSJodHRwOi8vc2NoZW1hcy5hYmIuY29tL2NsYWltcy9ETiI+PEF0dHJpYnV0ZVZhbHVlPkNOPW1jcC50ZXN0LmFyaUBnbWFpbC5jb20sT1U9U2VsZi1yZWdpc3RlcmVkIFVzZXJzLERDPUVYVCxkYz1hYmIsZGM9Y29tPC9BdHRyaWJ1dGVWYWx1ZT48L0F0dHJpYnV0ZT48QXR0cmlidXRlIE5hbWU9Imh0dHA6Ly9zY2hlbWFzLmFiYi5jb20vY2xhaW1zL2NvbXBhbnkiPjxBdHRyaWJ1dGVWYWx1ZT5BQkI8L0F0dHJpYnV0ZVZhbHVlPjwvQXR0cmlidXRlPjxBdHRyaWJ1dGUgTmFtZT0iaHR0cDovL3NjaGVtYXMuYWJiLmNvbS9jbGFpbXMvbWlkZGxlbmFtZSI+PEF0dHJpYnV0ZVZhbHVlPlRlc3Q8L0F0dHJpYnV0ZVZhbHVlPjwvQXR0cmlidXRlPjxBdHRyaWJ1dGUgTmFtZT0iaHR0cDovL3NjaGVtYXMuYWJiLmNvbS9jbGFpbXMvY291bnRyeWNvZGUiPjxBdHRyaWJ1dGVWYWx1ZT42MTY8L0F0dHJpYnV0ZVZhbHVlPjwvQXR0cmlidXRlPjwvQXR0cmlidXRlU3RhdGVtZW50PjxBdXRoblN0YXRlbWVudCBBdXRobkluc3RhbnQ9IjIwMTYtMTItMjBUMTA6MTc6MTYuOTI4WiIgU2Vzc2lvbkluZGV4PSJfMWU1NTJmYWUtZWNkMS00MGZjLTljMzAtMGI3YzZkYWUxZWU2Ij48QXV0aG5Db250ZXh0PjxBdXRobkNvbnRleHRDbGFzc1JlZj51cm46ZmVkZXJhdGlvbjphdXRoZW50aWNhdGlvbjp3aW5kb3dzPC9BdXRobkNvbnRleHRDbGFzc1JlZj48L0F1dGhuQ29udGV4dD48L0F1dGhuU3RhdGVtZW50PjwvQXNzZXJ0aW9uPjwvc2FtbHA6UmVzcG9uc2U+
			log("<<< vSAMLResponse_1 = " + vSAMLResponse_1);
		}
		catch (Exception e) { vSAMLResponse_1 = null; log(e); }
		if (vSAMLResponse_1 == null)
		{
			// failure - dump wrong response content and abort current outer loop - after that start next loop
			String errorText = "*** error: unable to extract var 'vSAMLResponse_1' from html form parameter";
			log(errorText);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			threadStep = performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_USER_SPECIFIC_TEST_FAILED, errorText, testURL, this);
		
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [34] <- WEB ADMIN Index 34 ---
		log();
		log("# title: Home");
		String requestProt0034 = "https";
		String requestHost0034 = "myportal.abb.com";
		int    requestPort0034 = 443;
		String requestFile0034 = "/";
		String requestContent0034 = 
				"SAMLResponse=" + java.net.URLEncoder.encode(vSAMLResponse_1);		// recorded value = PHNhbWxwOlJlc3BvbnNlIElEPSJfMDQ0YWU0MDMtYzdlNS00YmQ0LWFlN2ItM2MxMzJkZjA2M2RjIiBWZXJzaW9uPSIyLjAiIElzc3VlSW5zdGFudD0iMjAxNi0xMi0yMFQxMDoxNzoxNy43MzNaIiBEZXN0aW5hdGlvbj0iaHR0cHM6Ly9teXBvcnRhbC5hYmIuY29tLyIgQ29uc2VudD0idXJuOm9hc2lzOm5hbWVzOnRjOlNBTUw6Mi4wOmNvbnNlbnQ6dW5zcGVjaWZpZWQiIHhtbG5zOnNhbWxwPSJ1cm46b2FzaXM6bmFtZXM6dGM6U0FNTDoyLjA6cHJvdG9jb2wiPjxJc3N1ZXIgeG1sbnM9InVybjpvYXNpczpuYW1lczp0YzpTQU1MOjIuMDphc3NlcnRpb24iPmh0dHA6Ly9zdHNpbnQuYWJiLmNvbS9hZGZzL3NlcnZpY2VzL3RydXN0PC9Jc3N1ZXI%2BPHNhbWxwOlN0YXR1cz48c2FtbHA6U3RhdHVzQ29kZSBWYWx1ZT0idXJuOm9hc2lzOm5hbWVzOnRjOlNBTUw6Mi4wOnN0YXR1czpTdWNjZXNzIiAvPjwvc2FtbHA6U3RhdHVzPjxBc3NlcnRpb24gSUQ9Il8xZTU1MmZhZS1lY2QxLTQwZmMtOWMzMC0wYjdjNmRhZTFlZTYiIElzc3VlSW5zdGFudD0iMjAxNi0xMi0yMFQxMDoxNzoxNy43MzNaIiBWZXJzaW9uPSIyLjAiIHhtbG5zPSJ1cm46b2FzaXM6bmFtZXM6dGM6U0FNTDoyLjA6YXNzZXJ0aW9uIj48SXNzdWVyPmh0dHA6Ly9zdHNpbnQuYWJiLmNvbS9hZGZzL3NlcnZpY2VzL3RydXN0PC9Jc3N1ZXI%2BPGRzOlNpZ25hdHVyZSB4bWxuczpkcz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC8wOS94bWxkc2lnIyI%2BPGRzOlNpZ25lZEluZm8%2BPGRzOkNhbm9uaWNhbGl6YXRpb25NZXRob2QgQWxnb3JpdGhtPSJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzEwL3htbC1leGMtYzE0biMiIC8%2BPGRzOlNpZ25hdHVyZU1ldGhvZCBBbGdvcml0aG09Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvMDkveG1sZHNpZyNyc2Etc2hhMSIgLz48ZHM6UmVmZXJlbmNlIFVSST0iI18xZTU1MmZhZS1lY2QxLTQwZmMtOWMzMC0wYjdjNmRhZTFlZTYiPjxkczpUcmFuc2Zvcm1zPjxkczpUcmFuc2Zvcm0gQWxnb3JpdGhtPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwLzA5L3htbGRzaWcjZW52ZWxvcGVkLXNpZ25hdHVyZSIgLz48ZHM6VHJhbnNmb3JtIEFsZ29yaXRobT0iaHR0cDovL3d3dy53My5vcmcvMjAwMS8xMC94bWwtZXhjLWMxNG4jIiAvPjwvZHM6VHJhbnNmb3Jtcz48ZHM6RGlnZXN0TWV0aG9kIEFsZ29yaXRobT0iaHR0cDovL3d3dy53My5vcmcvMjAwMC8wOS94bWxkc2lnI3NoYTEiIC8%2BPGRzOkRpZ2VzdFZhbHVlPmozeE5HZC9QNHJzcUpIU2gwS3dQazBHTWxlVT08L2RzOkRpZ2VzdFZhbHVlPjwvZHM6UmVmZXJlbmNlPjwvZHM6U2lnbmVkSW5mbz48ZHM6U2lnbmF0dXJlVmFsdWU%2BTlVMWTdnTm9mbG4yUStJQ2VGT1lPWFM2RnJhQ0FXQXkrNWczZjMwUVVjV1JSdXR0cXJLZ1o2OHorNUo0NEhpNi92YzEvK1ZoMVpJU0lIWEhVbjBiYkFBalFLNG9pZVNkVkFHMEROZ0dUN1BPaHJCRDk5MzBaNWZ5VW9ZNFNzTHpCZ2FXQ2Frdm8wYmhwWUd5aVFCdVQ0UFo1NnEvbFZTcWV5bHU4cWwwM1Nxc2wwNHpxNXpXM3JXR3BYK3lTTVQrU3g2aTEzR0ZDOXJ6bDV4aDI0L1FKcjA1YVFzVTRQMndncFpGVk1oRmNSUUJYZU1mbHVHb0ZCYXM3ZXBYOC9RNW5veUsrSnZxMVppVE5oYnN6eHp3ZzFyOThRVG0zN1d2bGYxQTNuV0Y3VVV3d1FVcHo4WFQ4NVcxRDUyKzQzbW1pR3JCeXJPUHhJd1ZrWTRnNTRZVnJBPT08L2RzOlNpZ25hdHVyZVZhbHVlPjxLZXlJbmZvIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwLzA5L3htbGRzaWcjIj48ZHM6WDUwOURhdGE%2BPGRzOlg1MDlDZXJ0aWZpY2F0ZT5NSUlIcXpDQ0JwT2dBd0lCQWdJS09GYnZSUUFEQUFGNkxEQU5CZ2txaGtpRzl3MEJBUXNGQURCVE1STXdFUVlLQ1pJbWlaUHlMR1FCR1JZRFEwOU5NUk13RVFZS0NaSW1pWlB5TEdRQkdSWURRVUpDTVF3d0NnWURWUVFLRXdOQlFrSXhHVEFYQmdOVkJBTVRFRUZDUWlCSmMzTjFhVzVuSUVOQklETXdIaGNOTVRVd056QXhNakV5TnpBNVdoY05NakF3TlRFME1UWXdOalEyV2pCMU1Rc3dDUVlEVlFRR0V3SkRTREVPTUF3R0ExVUVCeE1GUW1Ga1pXNHhKVEFqQmdOVkJBb1RIRUZDUWlCSmJtWnZjbTFoZEdsdmJpQlRlWE4wWlcxeklFeDBaQzR4RmpBVUJnTlZCQXNURFVGRUlFWlRJRk5wWjI1cGJtY3hGekFWQmdOVkJBTVREbk4wYzJsdWRDNWhZbUl1WTI5dE1JSUJJakFOQmdrcWhraUc5dzBCQVFFRkFBT0NBUThBTUlJQkNnS0NBUUVBdUVSTEJTSDdYVlZWaWpzSVArWWN0SER4V1RtcGJmR2pvZVJGV3FieU1LS3hpRVZMZEFEVUdHRGljcndWNjFGYURsQ1poczlKdDIza0I1eVRSMjQ3NHdtYlg1TWY1Vk5CQzRzRWNvcExxUmUySUU3eWFBTmZTOFQ3Q2VCT1UvN0YyeXZvQUpTc21ZRjlQMWcySXF5cTBaL0JkQlUzeWdyRElhcXAvdm5BbTRUR0d4RDI5K2YwWEh5QXZMZ2VGd3NvUVZzQWxQSWtoMG5oaTV3UjYyYjdoTTQxaXkwcEs4aHUwZkJiVWwzU0N2OVdDZy9CajBUeElYTUFJT1MxVWFMRHB5enBORk5WMU1aS0dGOVlrU04vRnA0WC9XRWVweDdTd1d4dzUxV1laZUdnM2kya1NuR2tuaVdOVUxndk1NTEpLL3ZsWVJoeW1FWk1pL25UYUU5eTh3SURBUUFCbzRJRVhUQ0NCRmt3Q3dZRFZSMFBCQVFEQWdXZ01CMEdBMVVkRGdRV0JCVEhzbkhJUUtWaWFiMHkya2gydkxQdjZheDRPakFtQmdOVkhSRUVIekFkZ2h0QlJFWlRMVk5wWjI1cGJtY3RVMVJUU1U1VUxtRmlZaTVqYjIwd0h3WURWUjBqQkJnd0ZvQVVxNU02RVMyOVBaL296WXZGdE5wRUp2K0FEWWN3Z2dGckJnTlZIUjhFZ2dGaU1JSUJYakNDQVZxZ2dnRldvSUlCVW9ZcmFIUjBjRG92TDJOeWJDNXdhMmt1WVdKaUxtTnZiUzlCUWtKSmMzTjFhVzVuUTBFektETXBMbU55YklhQnFHeGtZWEE2THk4dlEwNDlRVUpDU1hOemRXbHVaME5CTXlnektTeERUajFEUkZBc1EwNDlVSFZpYkdsakpUSXdTMlY1SlRJd1UyVnlkbWxqWlhNc1EwNDlVMlZ5ZG1salpYTXNRMDQ5UTI5dVptbG5kWEpoZEdsdmJpeEVRejFoWW1Jc1JFTTlZMjl0UDJObGNuUnBabWxqWVhSbFVtVjJiMk5oZEdsdmJreHBjM1EvWW1GelpUOXZZbXBsWTNSRGJHRnpjejFqVWt4RWFYTjBjbWxpZFhScGIyNVFiMmx1ZElaNGJHUmhjRG92TDJOeWJDNXdhMmt1WVdKaUxtTnZiUzlEVGoxQlFrSkpjM04xYVc1blEwRXpLRE1wTEVOT1BVTkVVQ3hEVGoxUVMway9ZMlZ5ZEdsbWFXTmhkR1ZTWlhadlkyRjBhVzl1VEdsemREOWlZWE5sUDI5aWFtVmpkRU5zWVhOelBXTlNURVJwYzNSeWFXSjFkR2x2YmxCdmFXNTBNSUlCbUFZSUt3WUJCUVVIQVFFRWdnR0tNSUlCaGpBM0JnZ3JCZ0VGQlFjd0FvWXJhSFIwY0RvdkwyRnBZUzV3YTJrdVlXSmlMbU52YlM5QlFrSkpjM04xYVc1blEwRXpLRE1wTG1OeWREQ0JxQVlJS3dZQkJRVUhNQUtHZ1p0c1pHRndPaTh2TDBOT1BVRkNRa2x6YzNWcGJtZERRVE1zUTA0OVFVbEJMRU5PUFZCMVlteHBZeVV5TUV0bGVTVXlNRk5sY25acFkyVnpMRU5PUFZObGNuWnBZMlZ6TEVOT1BVTnZibVpwWjNWeVlYUnBiMjRzUkVNOVlXSmlMRVJEUFdOdmJUOWpRVU5sY25ScFptbGpZWFJsUDJKaGMyVS9iMkpxWldOMFEyeGhjM005WTJWeWRHbG1hV05oZEdsdmJrRjFkR2h2Y21sMGVUQjNCZ2dyQmdFRkJRY3dBb1pyYkdSaGNEb3ZMMkZwWVM1d2Eya3VZV0ppTG1OdmJTOURUajFCUWtKSmMzTjFhVzVuUTBFekxFTk9QVUZKUVN4RFRqMVFTMGsvWTBGRFpYSjBhV1pwWTJGMFpUOWlZWE5sUDI5aWFtVmpkRU5zWVhOelBXTmxjblJwWm1sallYUnBiMjVCZFhSb2IzSnBkSGt3SndZSUt3WUJCUVVITUFHR0cyaDBkSEE2THk5aGFXRXVjR3RwTG1GaVlpNWpiMjB2YjJOemNEQThCZ2tyQmdFRUFZSTNGUWNFTHpBdEJpVXJCZ0VFQVlJM0ZRakhxQ2FHc0lSNmhyV0xDb0xxaldxRWo2MGhLWUdOdDBpRDcrdFRBZ0ZrQWdFTk1CMEdBMVVkSlFRV01CUUdDQ3NHQVFVRkJ3TUNCZ2dyQmdFRkJRY0RBVEJSQmdOVkhTQUVTakJJTUVZR0RDc0dBUVFCZ2RjSEFSNEtBakEyTURRR0NDc0dBUVVGQndJQkZpaG9kSFJ3T2k4dlkzQXVjR3RwTG1GaVlpNWpiMjB2VTFOTVUyVnlkbVZ5U1c1MFpYSnVZV3d2TUNjR0NTc0dBUVFCZ2pjVkNnUWFNQmd3Q2dZSUt3WUJCUVVIQXdJd0NnWUlLd1lCQlFVSEF3RXdEUVlKS29aSWh2Y05BUUVMQlFBRGdnRUJBQm5hYUlTV0NRNXN0STlWVWErT3FaTlplRnZYeVR5YU0xVlN5cUlhRXQ1NUs4SDV0czdMdGU2QmNCZGRqVHhRdXhSclNZUkd6eEEyQW4wU0ZENzkvSWhGeTA3RXQwcHNQTmFjaVdxN3loa0lIV08yWGVCZktXaWV0SWI3OE9zZTk4c3UxamdkeXpmN1VxU2E4RVp1NnJyUHpHYWIyODVXQkVLQ1lhT1k5NzQ2bEZPbUNoVWg5YWYrWCswQWROOTlTZ2xHTEw1LzFxU0hnRlpMNStNSGJlYVhaOEhKd2pHMmJJRUJ0Wk01eWRvSmkrY0tHcGlkaGg5VUpqd3B6WEJMc0NWelByL1pZam96VmhKWWdwWThSeDl6NCs4MHIyWXNsYkJ5ZDhLcGhUK0tWOUxNRmMwNkNXNC95ejkxbHlYcEUxOUl3eXlycjNUUnVKMUFZWXVRV0ZzPTwvZHM6WDUwOUNlcnRpZmljYXRlPjwvZHM6WDUwOURhdGE%2BPC9LZXlJbmZvPjwvZHM6U2lnbmF0dXJlPjxTdWJqZWN0PjxOYW1lSUQgRm9ybWF0PSJ1cm46b2FzaXM6bmFtZXM6dGM6U0FNTDoyLjA6bmFtZWlkLWZvcm1hdDp0cmFuc2llbnQiPm1jcC50ZXN0LmFyaUBnbWFpbC5jb208L05hbWVJRD48U3ViamVjdENvbmZpcm1hdGlvbiBNZXRob2Q9InVybjpvYXNpczpuYW1lczp0YzpTQU1MOjIuMDpjbTpiZWFyZXIiPjxTdWJqZWN0Q29uZmlybWF0aW9uRGF0YSBOb3RPbk9yQWZ0ZXI9IjIwMTYtMTItMjBUMTA6MjI6MTcuNzMzWiIgUmVjaXBpZW50PSJodHRwczovL215cG9ydGFsLmFiYi5jb20vIiAvPjwvU3ViamVjdENvbmZpcm1hdGlvbj48L1N1YmplY3Q%2BPENvbmRpdGlvbnMgTm90QmVmb3JlPSIyMDE2LTEyLTIwVDEwOjE3OjE3LjY0MVoiIE5vdE9uT3JBZnRlcj0iMjAxNi0xMi0yMFQxMToxNzoxNy42NDFaIj48QXVkaWVuY2VSZXN0cmljdGlvbj48QXVkaWVuY2U%2BaHR0cHM6Ly9teXBvcnRhbC5hYmIuY29tPC9BdWRpZW5jZT48L0F1ZGllbmNlUmVzdHJpY3Rpb24%2BPC9Db25kaXRpb25zPjxBdHRyaWJ1dGVTdGF0ZW1lbnQ%2BPEF0dHJpYnV0ZSBOYW1lPSJodHRwOi8vc2NoZW1hcy54bWxzb2FwLm9yZy93cy8yMDA1LzA1L2lkZW50aXR5L2NsYWltcy9lbWFpbGFkZHJlc3MiPjxBdHRyaWJ1dGVWYWx1ZT5tY3AudGVzdC5hcmlAZ21haWwuY29tPC9BdHRyaWJ1dGVWYWx1ZT48L0F0dHJpYnV0ZT48QXR0cmlidXRlIE5hbWU9Imh0dHA6Ly9zY2hlbWFzLmFiYi5jb20vY2xhaW1zL3NuIj48QXR0cmlidXRlVmFsdWU%2BQXJpPC9BdHRyaWJ1dGVWYWx1ZT48L0F0dHJpYnV0ZT48QXR0cmlidXRlIE5hbWU9Imh0dHA6Ly9zY2hlbWFzLmFiYi5jb20vY2xhaW1zL2dpdmVubmFtZSI%2BPEF0dHJpYnV0ZVZhbHVlPk1jcDwvQXR0cmlidXRlVmFsdWU%2BPC9BdHRyaWJ1dGU%2BPEF0dHJpYnV0ZSBOYW1lPSJodHRwOi8vc2NoZW1hcy5hYmIuY29tL2NsYWltcy9ETiI%2BPEF0dHJpYnV0ZVZhbHVlPkNOPW1jcC50ZXN0LmFyaUBnbWFpbC5jb20sT1U9U2VsZi1yZWdpc3RlcmVkIFVzZXJzLERDPUVYVCxkYz1hYmIsZGM9Y29tPC9BdHRyaWJ1dGVWYWx1ZT48L0F0dHJpYnV0ZT48QXR0cmlidXRlIE5hbWU9Imh0dHA6Ly9zY2hlbWFzLmFiYi5jb20vY2xhaW1zL2NvbXBhbnkiPjxBdHRyaWJ1dGVWYWx1ZT5BQkI8L0F0dHJpYnV0ZVZhbHVlPjwvQXR0cmlidXRlPjxBdHRyaWJ1dGUgTmFtZT0iaHR0cDovL3NjaGVtYXMuYWJiLmNvbS9jbGFpbXMvbWlkZGxlbmFtZSI%2BPEF0dHJpYnV0ZVZhbHVlPlRlc3Q8L0F0dHJpYnV0ZVZhbHVlPjwvQXR0cmlidXRlPjxBdHRyaWJ1dGUgTmFtZT0iaHR0cDovL3NjaGVtYXMuYWJiLmNvbS9jbGFpbXMvY291bnRyeWNvZGUiPjxBdHRyaWJ1dGVWYWx1ZT42MTY8L0F0dHJpYnV0ZVZhbHVlPjwvQXR0cmlidXRlPjwvQXR0cmlidXRlU3RhdGVtZW50PjxBdXRoblN0YXRlbWVudCBBdXRobkluc3RhbnQ9IjIwMTYtMTItMjBUMTA6MTc6MTYuOTI4WiIgU2Vzc2lvbkluZGV4PSJfMWU1NTJmYWUtZWNkMS00MGZjLTljMzAtMGI3YzZkYWUxZWU2Ij48QXV0aG5Db250ZXh0PjxBdXRobkNvbnRleHRDbGFzc1JlZj51cm46ZmVkZXJhdGlvbjphdXRoZW50aWNhdGlvbjp3aW5kb3dzPC9BdXRobkNvbnRleHRDbGFzc1JlZj48L0F1dGhuQ29udGV4dD48L0F1dGhuU3RhdGVtZW50PjwvQXNzZXJ0aW9uPjwvc2FtbHA6UmVzcG9uc2U%2B
		String requestHeader0034 = "POST " + requestFile0034 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: myportal.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"Upgrade-Insecure-Requests: 1\r\n" + 
				"Content-Type: application/x-www-form-urlencoded\r\n" + 
				"Content-Length: " + requestContent0034.length() + "\r\n" + 		// Content-Length: 8213
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0034, requestHost0034, requestPort0034, requestHeader0034, requestContent0034.getBytes(), requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		if (debugLoops)
		{
			if (Lib.isAsciiContent(testURL.getRequestContent(), 256))
				log(">>> " + new String(testURL.getRequestContent()));
			else
				log(">>> [binary data]");
		}

		testURL.execute(performanceData);
		requestHeader0034 = null;		// support garbage collector to reduce memory
		requestContent0034 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 371
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, null);		// Test [34] <- Index 34
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [35] <- WEB ADMIN Index 35 ---
		String requestProt0035 = "https";
		String requestHost0035 = "myportal.abb.com";
		int    requestPort0035 = 443;
		String requestFile0035 = "/dtagent6310_23bgjqr_1010.js";
		String requestHeader0035 = "GET " + requestFile0035 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: myportal.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0035, requestHost0035, requestPort0035, requestHeader0035, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0035 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [36] <- WEB ADMIN Index 36 ---
		String requestProt0036 = "https";
		String requestHost0036 = "myportal.abb.com";
		int    requestPort0036 = 443;
		String requestFile0036 = "/dynaTraceMonitor";
		String requestContent0036 = 
				"$a=1%7C1%7C_load_%7C_load_%7C-%7C1482229038452%7C1482229040256%7C7%7C-%7C-%7C-%7C-%7C-%7Chttps%3A%2F%2Fstsint.abb.com%2Fadfs%2Fls%2F%2C2%7C2%7C_onload_%7C_load_%7C-%7C1482229040242%7C1482229040256%7C7$v=63$fId=229040207_498$rId=RID_2418$rpId=184324185$domR=1482229040242$w=1280$h=597$nt=a0b1482229038452e13f13g13h13i13k210l117m1537n1540o1768p1770q1788r1790s1791t1791$url=https%3A%2F%2Fmyportal.abb.com%2F$title=Home$time=1482229040277";
		byte[] requestContentBinary0036 = requestContent0036.getBytes("UTF-8");
		String requestHeader0036 = "POST " + requestFile0036 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: myportal.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Content-Type: text/plain;charset=UTF-8\r\n" + 
				"Content-Length: " + requestContentBinary0036.length + "\r\n" + 		// Content-Length: 434
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0036, requestHost0036, requestPort0036, requestHeader0036, requestContentBinary0036, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		if (debugLoops)
		{
			if (Lib.isAsciiContent(testURL.getRequestContent(), 256))
				log(">>> " + new String(testURL.getRequestContent()));
			else
				log(">>> [binary data]");
		}

		testURL.execute(performanceData);
		requestHeader0036 = null;		// support garbage collector to reduce memory
		requestContent0036 = null;		// support garbage collector to reduce memory
		requestContentBinary0036 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/PLAIN", header text fragment = [verification disabled], recorded content size = 132
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/PLAIN", null, null);		// Test [36] <- Index 36
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [37] <- WEB ADMIN Index 37 ---
		String requestProt0037 = "https";
		String requestHost0037 = "myportal.abb.com";
		int    requestPort0037 = 443;
		String requestFile0037 = "/";
		String requestHeader0037 = "GET " + requestFile0037 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: myportal.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"Upgrade-Insecure-Requests: 1\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0037, requestHost0037, requestPort0037, requestHeader0037, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0037 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [38] <- WEB ADMIN Index 38 ---
		log();
		log("# title: myABB business portal Dashboard");
		String requestProt0038 = "https";
		String requestHost0038 = "myportal.abb.com";
		int    requestPort0038 = 443;
		String requestFile0038 = "/home";
		String requestHeader0038 = "GET " + requestFile0038 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: myportal.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"Upgrade-Insecure-Requests: 1\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0038, requestHost0038, requestPort0038, requestHeader0038, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0038 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [39] <- WEB ADMIN Index 39 ---
		String requestProt0039 = "https";
		String requestHost0039 = "myportal.abb.com";
		int    requestPort0039 = 443;
		String requestFile0039 = "/dtagent6310_23bgjqr_1010.js";
		String requestHeader0039 = "GET " + requestFile0039 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: myportal.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0039, requestHost0039, requestPort0039, requestHeader0039, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0039 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 304, content type = [verification disabled], header text fragment = [verification disabled], recorded content size = 0
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {304}, null, null, null);		// Test [39] <- Index 39
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [40] <- WEB ADMIN Index 40 ---
		String requestProt0040 = "https";
		String requestHost0040 = "myportal.abb.com";
		int    requestPort0040 = 443;
		String requestFile0040 = "/static/ver_5.5.1.1-2014-12-2300:23/mcp/resources/backbasePortalClientBundle.js";
		String requestHeader0040 = "GET " + requestFile0040 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: myportal.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0040, requestHost0040, requestPort0040, requestHeader0040, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0040 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;


		// all http requests of page #2 successful done
		return true;
	}


	/**
	 * Recorded http requests of page #2_1.
	 *
	 * @return  true:  method successful completed.
	 *          false: method/loop failed.
	 */
	boolean executePage_2_1(int totalLoopCounter, LoadtestPluginContext loopPluginContext, InnerLoopContext innerLoopContext, Object httpLogVectorObject) throws Exception
	{
		// ... continuing page #2 (fragment 2 of 5)
		// ----------------------------------------



		// --- HTTP REQUEST: Test [41] <- WEB ADMIN Index 41 ---
		String requestProt0041 = "https";
		String requestHost0041 = "myportal.abb.com";
		int    requestPort0041 = 443;
		String requestFile0041 = "/static/ver_5.5.1.1-2014-12-2300:23/portalclient/css/backbase-portal.css";
		String requestHeader0041 = "GET " + requestFile0041 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: myportal.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0041, requestHost0041, requestPort0041, requestHeader0041, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0041 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [42] <- WEB ADMIN Index 42 ---
		String requestProt0042 = "https";
		String requestHost0042 = "myportal.abb.com";
		int    requestPort0042 = 443;
		String requestFile0042 = "/static/ver_2.1-20161215_124256/mcp/resources/mcpSharedGlobalLibrariesBundle.js";
		String requestHeader0042 = "GET " + requestFile0042 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: myportal.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0042, requestHost0042, requestPort0042, requestHeader0042, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0042 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [43] <- WEB ADMIN Index 43 ---
		String requestProt0043 = "https";
		String requestHost0043 = "myportal.abb.com";
		int    requestPort0043 = 443;
		String requestFile0043 = "/theme/static/ver_2.1-20161215_124256/themes/mcp/backbase-base.css";
		String requestHeader0043 = "GET " + requestFile0043 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: myportal.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0043, requestHost0043, requestPort0043, requestHeader0043, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0043 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [44] <- WEB ADMIN Index 44 ---
		String requestProt0044 = "https";
		String requestHost0044 = "myportal.abb.com";
		int    requestPort0044 = 443;
		String requestFile0044 = "/theme/static/ver_2.1-20161215_124256/themes/mcp/backbase-base-2.css";
		String requestHeader0044 = "GET " + requestFile0044 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: myportal.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0044, requestHost0044, requestPort0044, requestHeader0044, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0044 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [45] <- WEB ADMIN Index 45 ---
		String requestProt0045 = "https";
		String requestHost0045 = "myportal.abb.com";
		int    requestPort0045 = 443;
		String requestFile0045 = "/static/ver_2.1-20161215_124256/mcp/resources/widgetsContainersMerged.css";
		String requestHeader0045 = "GET " + requestFile0045 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: myportal.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0045, requestHost0045, requestPort0045, requestHeader0045, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0045 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [46] <- WEB ADMIN Index 46 ---
		String requestProt0046 = "https";
		String requestHost0046 = "myportal.abb.com";
		int    requestPort0046 = 443;
		String requestFile0046 = "/mvc/user/getCurrentUserGlobalVariables";
		String requestHeader0046 = "GET " + requestFile0046 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: myportal.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0046, requestHost0046, requestPort0046, requestHeader0046, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0046 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [47] <- WEB ADMIN Index 47 ---
		String requestProt0047 = "https";
		String requestHost0047 = "myportal.abb.com";
		int    requestPort0047 = 443;
		String requestFile0047 = "/static/ver_2.1-20161215_124256/mcp/resources/backbaseLaunchpadBundle.js";
		String requestHeader0047 = "GET " + requestFile0047 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: myportal.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0047, requestHost0047, requestPort0047, requestHeader0047, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0047 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [48] <- WEB ADMIN Index 48 ---
		String requestProt0048 = "https";
		String requestHost0048 = "myportal.abb.com";
		int    requestPort0048 = 443;
		String requestFile0048 = "/static/ver_2.1-20161215_124256/mcp/libs/external/angular-base/1_4_8/angular.min.js";
		String requestHeader0048 = "GET " + requestFile0048 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: myportal.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0048, requestHost0048, requestPort0048, requestHeader0048, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0048 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [49] <- WEB ADMIN Index 49 ---
		String requestProt0049 = "https";
		String requestHost0049 = "myportal.abb.com";
		int    requestPort0049 = 443;
		String requestFile0049 = "/static/ver_2.1-20161215_124256_1481963650440/mcp/resources/mcpRequireModulesBundle.i18n.en.js";
		String requestHeader0049 = "GET " + requestFile0049 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: myportal.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0049, requestHost0049, requestPort0049, requestHeader0049, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0049 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [50] <- WEB ADMIN Index 50 ---
		String requestProt0050 = "https";
		String requestHost0050 = "myportal.abb.com";
		int    requestPort0050 = 443;
		String requestFile0050 = "/static/ver_2.1-20161215_124256/launchpad/lib/requirejs/noDup.js";
		String requestHeader0050 = "GET " + requestFile0050 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: myportal.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0050, requestHost0050, requestPort0050, requestHeader0050, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0050 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [51] <- WEB ADMIN Index 51 ---
		String requestProt0051 = "https";
		String requestHost0051 = "myportal.abb.com";
		int    requestPort0051 = 443;
		String requestFile0051 = "/static/ver_2.1-20161215_124256/mcp/resources/mcpExternalLibsBundle.min.js";
		String requestHeader0051 = "GET " + requestFile0051 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: myportal.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0051, requestHost0051, requestPort0051, requestHeader0051, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0051 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [52] <- WEB ADMIN Index 52 ---
		String requestProt0052 = "https";
		String requestHost0052 = "myportal.abb.com";
		int    requestPort0052 = 443;
		String requestFile0052 = "/theme/static/ver_2.1-20161215_124256/themes/mcp/css/img/06_magnify.png";
		String requestHeader0052 = "GET " + requestFile0052 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: myportal.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0052, requestHost0052, requestPort0052, requestHeader0052, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0052 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [53] <- WEB ADMIN Index 53 ---
		String requestProt0053 = "https";
		String requestHost0053 = "myportal.abb.com";
		int    requestPort0053 = 443;
		String requestFile0053 = "/theme/static/ver_2.1-20161215_124256/themes/mcp/css/abb/img/loader_wide.gif";
		String requestHeader0053 = "GET " + requestFile0053 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: myportal.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0053, requestHost0053, requestPort0053, requestHeader0053, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0053 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [54] <- WEB ADMIN Index 54 ---
		String requestProt0054 = "https";
		String requestHost0054 = "myportal.abb.com";
		int    requestPort0054 = 443;
		String requestFile0054 = "/theme/static/themes/mcp/css/abb/img/logo_new.png";
		String requestHeader0054 = "GET " + requestFile0054 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: myportal.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0054, requestHost0054, requestPort0054, requestHeader0054, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0054 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [55] <- WEB ADMIN Index 55 ---
		String requestProt0055 = "https";
		String requestHost0055 = "myportal.abb.com";
		int    requestPort0055 = 443;
		String requestFile0055 = "/theme/static/ver_2.1-20161215_124256/themes/mcp/css/abb/img/loader_spinner.gif";
		String requestHeader0055 = "GET " + requestFile0055 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: myportal.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0055, requestHost0055, requestPort0055, requestHeader0055, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0055 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [56] <- WEB ADMIN Index 56 ---
		String requestProt0056 = "https";
		String requestHost0056 = "myportal.abb.com";
		int    requestPort0056 = 443;
		String requestFile0056 = "/theme/static/ver_2.1-20161215_124256/themes/mcp/css/abb/img/loader_min.gif";
		String requestHeader0056 = "GET " + requestFile0056 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: myportal.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0056, requestHost0056, requestPort0056, requestHeader0056, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0056 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [57] <- WEB ADMIN Index 57 ---
		String requestProt0057 = "https";
		String requestHost0057 = "myportal.abb.com";
		int    requestPort0057 = 443;
		String requestFile0057 = "/theme/static/ver_2.1-20161215_124256/themes/mcp/css/abb/myabb/fonts/9a2e4855-380f-477f-950e-d98e8db54eac.woff";
		String requestHeader0057 = "GET " + requestFile0057 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: myportal.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: identity\r\n" + 
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0057, requestHost0057, requestPort0057, requestHeader0057, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0057 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [58] <- WEB ADMIN Index 58 ---
		String requestProt0058 = "https";
		String requestHost0058 = "myportal.abb.com";
		int    requestPort0058 = 443;
		String requestFile0058 = "/theme/static/ver_2.1-20161215_124256/themes/mcp/css/abb/myabb/font-icons-26102016/myABBfont.ttf";
		String requestHeader0058 = "GET " + requestFile0058 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: myportal.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0058, requestHost0058, requestPort0058, requestHeader0058, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0058 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [59] <- WEB ADMIN Index 59 ---
		String requestProt0059 = "https";
		String requestHost0059 = "myportal.abb.com";
		int    requestPort0059 = 443;
		String requestFile0059 = "/theme/static/ver_2.1-20161215_124256/themes/mcp/libs/bootstrap-3.20/fonts/glyphicons-halflings-regular.woff";
		String requestHeader0059 = "GET " + requestFile0059 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: myportal.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: identity\r\n" + 
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0059, requestHost0059, requestPort0059, requestHeader0059, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0059 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [60] <- WEB ADMIN Index 60 ---
		log();
		log("# title: Contacts");
		String requestProt0060 = "https";
		String requestHost0060 = "myportal.abb.com";
		int    requestPort0060 = 443;
		String requestFile0060 = "/static/ver_2.1-20161215_124256_1481963650440_lang_en/mcp/widgets/mcp/contact-overview/mcp-contact-overview.html";
		String requestHeader0060 = "GET " + requestFile0060 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: myportal.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0060, requestHost0060, requestPort0060, requestHeader0060, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0060 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;


		// all http requests of page #2_1 successful done
		return true;
	}


	/**
	 * Recorded http requests of page #2_2.
	 *
	 * @return  true:  method successful completed.
	 *          false: method/loop failed.
	 */
	boolean executePage_2_2(int totalLoopCounter, LoadtestPluginContext loopPluginContext, InnerLoopContext innerLoopContext, Object httpLogVectorObject) throws Exception
	{
		// ... continuing page #2 (fragment 3 of 5)
		// ----------------------------------------



		// --- HTTP REQUEST: Test [61] <- WEB ADMIN Index 61 ---
		log();
		log("# title: Contracts Overview");
		String requestProt0061 = "https";
		String requestHost0061 = "myportal.abb.com";
		int    requestPort0061 = 443;
		String requestFile0061 = "/static/ver_2.1-20161215_124256_1481963650440_lang_en/mcp/widgets/servis/contracts-overview/servis-contracts-overview.html";
		String requestHeader0061 = "GET " + requestFile0061 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: myportal.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0061, requestHost0061, requestPort0061, requestHeader0061, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0061 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [62] <- WEB ADMIN Index 62 ---
		log();
		log("# title: Installations Mini App");
		String requestProt0062 = "https";
		String requestHost0062 = "myportal.abb.com";
		int    requestPort0062 = 443;
		String requestFile0062 = "/static/ver_2.1-20161215_124256_1481963650440_lang_en/mcp/widgets/servis/installations-list-overview/servis-installations-list-overview.html";
		String requestHeader0062 = "GET " + requestFile0062 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: myportal.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0062, requestHost0062, requestPort0062, requestHeader0062, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0062 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [63] <- WEB ADMIN Index 63 ---
		log();
		log("# title: Product Registration");
		String requestProt0063 = "https";
		String requestHost0063 = "myportal.abb.com";
		int    requestPort0063 = 443;
		String requestFile0063 = "/static/ver_2.1-20161215_124256_1481963650440_lang_en/mcp/widgets/servis/product-registration/servis-product-registration.html";
		String requestHeader0063 = "GET " + requestFile0063 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: myportal.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0063, requestHost0063, requestPort0063, requestHeader0063, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0063 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [64] <- WEB ADMIN Index 64 ---
		log();
		log("# title: Search");
		String requestProt0064 = "https";
		String requestHost0064 = "myportal.abb.com";
		int    requestPort0064 = 443;
		String requestFile0064 = "/static/ver_2.1-20161215_124256_1481963650440_lang_en/mcp/widgets/mcp/spare-parts-search/mcp-spare-parts-search.html";
		String requestHeader0064 = "GET " + requestFile0064 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: myportal.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0064, requestHost0064, requestPort0064, requestHeader0064, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0064 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [65] <- WEB ADMIN Index 65 ---
		log();
		log("# title: Product Browser Categories");
		String requestProt0065 = "https";
		String requestHost0065 = "myportal.abb.com";
		int    requestPort0065 = 443;
		String requestFile0065 = "/static/ver_2.1-20161215_124256_1481963650440_lang_en/mcp/widgets/wfe/pis/product-browser-categories/wfe-pis-product-browser-categories.html";
		String requestHeader0065 = "GET " + requestFile0065 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: myportal.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0065, requestHost0065, requestPort0065, requestHeader0065, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0065 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [66] <- WEB ADMIN Index 66 ---
		log();
		log("# title: Other Services");
		String requestProt0066 = "https";
		String requestHost0066 = "myportal.abb.com";
		int    requestPort0066 = 443;
		String requestFile0066 = "/static/ver_2.1-20161215_124256_1481963650440_lang_en/mcp/widgets/mcp/other-services/mcp-other-services.html";
		String requestHeader0066 = "GET " + requestFile0066 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: myportal.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0066, requestHost0066, requestPort0066, requestHeader0066, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0066 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [67] <- WEB ADMIN Index 67 ---
		log();
		log("# title: Welcome Page");
		String requestProt0067 = "https";
		String requestHost0067 = "myportal.abb.com";
		int    requestPort0067 = 443;
		String requestFile0067 = "/static/ver_2.1-20161215_124256_1481963650440_lang_en/mcp/widgets/mcp/welcome-page/mcp-welcome-page.html";
		String requestHeader0067 = "GET " + requestFile0067 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: myportal.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0067, requestHost0067, requestPort0067, requestHeader0067, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0067 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [68] <- WEB ADMIN Index 68 ---
		log();
		log("# title: ServIS Dashboard App");
		String requestProt0068 = "https";
		String requestHost0068 = "myportal.abb.com";
		int    requestPort0068 = 443;
		String requestFile0068 = "/static/ver_2.1-20161215_124256_1481963650440_lang_en/mcp/widgets/servis/dashboard-app/servis-dashboard-app.html";
		String requestHeader0068 = "GET " + requestFile0068 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: myportal.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0068, requestHost0068, requestPort0068, requestHeader0068, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0068 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [69] <- WEB ADMIN Index 69 ---
		log();
		log("# title: CUX TEST");
		String requestProt0069 = "https";
		String requestHost0069 = "myportal.abb.com";
		int    requestPort0069 = 443;
		String requestFile0069 = "/static/ver_2.1-20161215_124256_1481963650440_lang_en/mcp/widgets/wfe/cux/past-orders-small/wfe-cux-past-orders-small.html";
		String requestHeader0069 = "GET " + requestFile0069 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: myportal.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0069, requestHost0069, requestPort0069, requestHeader0069, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0069 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [70] <- WEB ADMIN Index 70 ---
		log();
		log("# title: Site Information Overview");
		String requestProt0070 = "https";
		String requestHost0070 = "myportal.abb.com";
		int    requestPort0070 = 443;
		String requestFile0070 = "/static/ver_2.1-20161215_124256_1481963650440_lang_en/mcp/widgets/servis/site-information-overview/servis-site-information-overview.html";
		String requestHeader0070 = "GET " + requestFile0070 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: myportal.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0070, requestHost0070, requestPort0070, requestHeader0070, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0070 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [71] <- WEB ADMIN Index 71 ---
		log();
		log("# title: Contacts");
		String requestProt0071 = "https";
		String requestHost0071 = "myportal.abb.com";
		int    requestPort0071 = 443;
		String requestFile0071 = "/static/ver_2.1-20161215_124256_1481963650440_lang_en/mcp/widgets/mcp/contact/mcp-contact.html";
		String requestHeader0071 = "GET " + requestFile0071 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: myportal.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0071, requestHost0071, requestPort0071, requestHeader0071, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0071 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [72] <- WEB ADMIN Index 72 ---
		log();
		log("# title: Tour App");
		String requestProt0072 = "https";
		String requestHost0072 = "myportal.abb.com";
		int    requestPort0072 = 443;
		String requestFile0072 = "/static/ver_2.1-20161215_124256_1481963650440_lang_en/mcp/widgets/mcp/notifications/mcp-notifications.html";
		String requestHeader0072 = "GET " + requestFile0072 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: myportal.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0072, requestHost0072, requestPort0072, requestHeader0072, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0072 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [73] <- WEB ADMIN Index 73 ---
		log();
		log("# title: Advanced Page Navigation Widget");
		String requestProt0073 = "https";
		String requestHost0073 = "myportal.abb.com";
		int    requestPort0073 = 443;
		String requestFile0073 = "/static/backbase.com.2012.nexus/widgets/AdvancedNav/index.html";
		String requestHeader0073 = "GET " + requestFile0073 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: myportal.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0073, requestHost0073, requestPort0073, requestHeader0073, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0073 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [74] <- WEB ADMIN Index 74 ---
		log();
		log("# title: Tour App");
		String requestProt0074 = "https";
		String requestHost0074 = "myportal.abb.com";
		int    requestPort0074 = 443;
		String requestFile0074 = "/static/ver_2.1-20161215_124256_1481963650440_lang_en/mcp/widgets/mcp/system-message/mcp-system-message.html";
		String requestHeader0074 = "GET " + requestFile0074 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: myportal.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0074, requestHost0074, requestPort0074, requestHeader0074, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0074 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [75] <- WEB ADMIN Index 75 ---
		log();
		log("# title: CUX SMALL CART");
		String requestProt0075 = "https";
		String requestHost0075 = "myportal.abb.com";
		int    requestPort0075 = 443;
		String requestFile0075 = "/static/ver_2.1-20161215_124256_1481963650440_lang_en/mcp/widgets/wfe/cux/cart-small/wfe-cux-cart-small.html";
		String requestHeader0075 = "GET " + requestFile0075 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: myportal.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0075, requestHost0075, requestPort0075, requestHeader0075, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0075 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [76] <- WEB ADMIN Index 76 ---
		log();
		log("# title: Breadcrumb Navigation Widget");
		String requestProt0076 = "https";
		String requestHost0076 = "myportal.abb.com";
		int    requestPort0076 = 443;
		String requestFile0076 = "/static/backbase.com.2012.nexus/widgets/BreadcrumbNav/index.html";
		String requestHeader0076 = "GET " + requestFile0076 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: myportal.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0076, requestHost0076, requestPort0076, requestHeader0076, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0076 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [77] <- WEB ADMIN Index 77 ---
		String requestProt0077 = "https";
		String requestHost0077 = "myportal.abb.com";
		int    requestPort0077 = 443;
		String requestFile0077 = "/static/ver_2.1-20161215_124256/mcp/libs/external/angular-base/1_4_8/angular.min.js";
		String requestHeader0077 = "GET " + requestFile0077 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: myportal.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0077, requestHost0077, requestPort0077, requestHeader0077, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0077 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 304, content type = [verification disabled], header text fragment = [verification disabled], recorded content size = 0
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {304}, null, null, null);		// Test [77] <- Index 77
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [78] <- WEB ADMIN Index 78 ---
		String requestProt0078 = "https";
		String requestHost0078 = "myportal.abb.com";
		int    requestPort0078 = 443;
		String requestFile0078 = "/frontend/consolidated/ver_2.1-20161215_124256/cux_helper_library.js";
		String requestHeader0078 = "GET " + requestFile0078 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: myportal.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0078, requestHost0078, requestPort0078, requestHeader0078, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0078 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [79] <- WEB ADMIN Index 79 ---
		String requestProt0079 = "https";
		String requestHost0079 = "myportal.abb.com";
		int    requestPort0079 = 443;
		String requestFile0079 = "/dynaTraceMonitor" +
				"?bwstate=0" +
				"&unique=1482229043612";
		String requestHeader0079 = "GET " + requestFile0079 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: myportal.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0079, requestHost0079, requestPort0079, requestHeader0079, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0079 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [80] <- WEB ADMIN Index 80 ---
		String requestProt0080 = "https";
		String requestHost0080 = "myportal.abb.com";
		int    requestPort0080 = 443;
		String requestFile0080 = "/static/mcp/libs/external/amcharts/3_14_5/amcharts.js";
		String requestHeader0080 = "GET " + requestFile0080 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: myportal.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0080, requestHost0080, requestPort0080, requestHeader0080, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0080 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;


		// all http requests of page #2_2 successful done
		return true;
	}


	/**
	 * Recorded http requests of page #2_3.
	 *
	 * @return  true:  method successful completed.
	 *          false: method/loop failed.
	 */
	boolean executePage_2_3(int totalLoopCounter, LoadtestPluginContext loopPluginContext, InnerLoopContext innerLoopContext, Object httpLogVectorObject) throws Exception
	{
		// ... continuing page #2 (fragment 4 of 5)
		// ----------------------------------------



		// --- HTTP REQUEST: Test [81] <- WEB ADMIN Index 81 ---
		String requestProt0081 = "https";
		String requestHost0081 = "myportal.abb.com";
		int    requestPort0081 = 443;
		String requestFile0081 = "/static/ver_2.1-20161215_124256/launchpad/lib/util.js";
		String requestHeader0081 = "GET " + requestFile0081 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: myportal.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0081, requestHost0081, requestPort0081, requestHeader0081, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0081 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [82] <- WEB ADMIN Index 82 ---
		String requestProt0082 = "https";
		String requestHost0082 = "myportal.abb.com";
		int    requestPort0082 = 443;
		String requestFile0082 = "/static/ver_2.1-20161215_124256/launchpad/lib/responsive.js";
		String requestHeader0082 = "GET " + requestFile0082 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: myportal.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0082, requestHost0082, requestPort0082, requestHeader0082, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0082 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [83] <- WEB ADMIN Index 83 ---
		String requestProt0083 = "https";
		String requestHost0083 = "myportal.abb.com";
		int    requestPort0083 = 443;
		String requestFile0083 = "/proxy" +
				"?pipe=notifications" +
				"&url=%2Fget%3FpageSize%3D20%26pageNumber%3D0%26type%3Dsystem";
		String requestHeader0083 = "GET " + requestFile0083 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: myportal.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"X-Requested-With: XMLHttpRequest\r\n" + 
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0083, requestHost0083, requestPort0083, requestHeader0083, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0083 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [84] <- WEB ADMIN Index 84 ---
		String requestProt0084 = "https";
		String requestHost0084 = "myportal.abb.com";
		int    requestPort0084 = 443;
		String requestFile0084 = "/frontend/css/ver_2.1-20161215_124256/cux-myabb-small-cart.css";
		String requestHeader0084 = "GET " + requestFile0084 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: myportal.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0084, requestHost0084, requestPort0084, requestHeader0084, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0084 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [85] <- WEB ADMIN Index 85 ---
		String requestProt0085 = "https";
		String requestHost0085 = "myportal.abb.com";
		int    requestPort0085 = 443;
		String requestFile0085 = "/dynaTraceMonitor" +
				"?bwstate=1" +
				"&unique=1482229044036";
		String requestHeader0085 = "GET " + requestFile0085 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: myportal.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0085, requestHost0085, requestPort0085, requestHeader0085, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0085 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [86] <- WEB ADMIN Index 86 ---
		String requestProt0086 = "https";
		String requestHost0086 = "myportal.abb.com";
		int    requestPort0086 = 443;
		String requestFile0086 = "/static/mcp/libs/external/amcharts/3_14_5/pie.js";
		String requestHeader0086 = "GET " + requestFile0086 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: myportal.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0086, requestHost0086, requestPort0086, requestHeader0086, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0086 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [87] <- WEB ADMIN Index 87 ---
		String requestProt0087 = "https";
		String requestHost0087 = "myportal.abb.com";
		int    requestPort0087 = 443;
		String requestFile0087 = "/proxy" +
				"?pipe=wfeFrontendPipe" +
				"&url=/home/loadGlobalConfiguration.action";
		String requestHeader0087 = "GET " + requestFile0087 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: myportal.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"X-Requested-With: XMLHttpRequest\r\n" + 
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0087, requestHost0087, requestPort0087, requestHeader0087, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0087 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [88] <- WEB ADMIN Index 88 ---
		String requestProt0088 = "https";
		String requestHost0088 = "myportal.abb.com";
		int    requestPort0088 = 443;
		String requestFile0088 = "/frontend/css/img/arrow_down_green_ss.png";
		String requestHeader0088 = "GET " + requestFile0088 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: myportal.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0088, requestHost0088, requestPort0088, requestHeader0088, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0088 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [89] <- WEB ADMIN Index 89 ---
		String requestProt0089 = "https";
		String requestHost0089 = "myportal.abb.com";
		int    requestPort0089 = 443;
		String requestFile0089 = "/theme/static/themes/mcp/css/img/contact2.png";
		String requestHeader0089 = "GET " + requestFile0089 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: myportal.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0089, requestHost0089, requestPort0089, requestHeader0089, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0089 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [90] <- WEB ADMIN Index 90 ---
		String requestProt0090 = "https";
		String requestHost0090 = "myportal.abb.com";
		int    requestPort0090 = 443;
		String requestFile0090 = "/proxy" +
				"?pipe=otherServices";
		String requestHeader0090 = "GET " + requestFile0090 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: myportal.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"X-Requested-With: XMLHttpRequest\r\n" + 
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0090, requestHost0090, requestPort0090, requestHeader0090, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0090 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [91] <- WEB ADMIN Index 91 ---
		String requestProt0091 = "https";
		String requestHost0091 = "myportal.abb.com";
		int    requestPort0091 = 443;
		String requestFile0091 = "/frontend/commons/directives/implementation/loading/loadingTemplate.html";
		String requestHeader0091 = "GET " + requestFile0091 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: myportal.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0091, requestHost0091, requestPort0091, requestHeader0091, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0091 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [92] <- WEB ADMIN Index 92 ---
		String requestProt0092 = "https";
		String requestHost0092 = "myportal.abb.com";
		int    requestPort0092 = 443;
		String requestFile0092 = "/static/ver_2.1-20161215_124256_1481963650440_lang_en/mcp/widgets/mcp/notifications/partials/mcp-notifications-send-confirmation.html";
		String requestHeader0092 = "GET " + requestFile0092 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: myportal.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0092, requestHost0092, requestPort0092, requestHeader0092, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0092 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [93] <- WEB ADMIN Index 93 ---
		String requestProt0093 = "https";
		String requestHost0093 = "myportal.abb.com";
		int    requestPort0093 = 443;
		String requestFile0093 = "/static/ver_2.1-20161215_124256_1481963650440_lang_en/mcp/widgets/mcp/notifications/partials/mcp-notifications-list.html";
		String requestHeader0093 = "GET " + requestFile0093 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: myportal.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0093, requestHost0093, requestPort0093, requestHeader0093, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0093 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [94] <- WEB ADMIN Index 94 ---
		String requestProt0094 = "https";
		String requestHost0094 = "myportal.abb.com";
		int    requestPort0094 = 443;
		String requestFile0094 = "/static/ver_2.1-20161215_124256_1481963650440_lang_en/mcp/containers/abb-with-left-menu/partials/alertsTemplate.html";
		String requestHeader0094 = "GET " + requestFile0094 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: myportal.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0094, requestHost0094, requestPort0094, requestHeader0094, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0094 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [95] <- WEB ADMIN Index 95 ---
		String requestProt0095 = "https";
		String requestHost0095 = "myportal.abb.com";
		int    requestPort0095 = 443;
		String requestFile0095 = "/proxy" +
				"?pipe=notifications" +
				"&url=%2FgetMetadata";
		String requestHeader0095 = "GET " + requestFile0095 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: myportal.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"MyABB-SessionControl: DoNotExtend\r\n" + 
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0095, requestHost0095, requestPort0095, requestHeader0095, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0095 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [96] <- WEB ADMIN Index 96 ---
		String requestProt0096 = "https";
		String requestHost0096 = "myportal.abb.com";
		int    requestPort0096 = 443;
		String requestFile0096 = "/proxy" +
				"?pipe=site-app" +
				"&servis=all";
		String requestHeader0096 = "GET " + requestFile0096 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: myportal.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0096, requestHost0096, requestPort0096, requestHeader0096, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0096 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [97] <- WEB ADMIN Index 97 ---
		String requestProt0097 = "https";
		String requestHost0097 = "myportal.abb.com";
		int    requestPort0097 = 443;
		String requestFile0097 = "/proxy" +
				"?pipe=wfe_external" +
				"&url=%2Fpriceavailapi%2FretreiveMainCategories.action%3FspareParts%3Dtrue";
		String requestHeader0097 = "GET " + requestFile0097 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: myportal.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0097, requestHost0097, requestPort0097, requestHeader0097, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0097 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [98] <- WEB ADMIN Index 98 ---
		String requestProt0098 = "https";
		String requestHost0098 = "myportal.abb.com";
		int    requestPort0098 = 443;
		String requestFile0098 = "/proxy" +
				"?pipe=staticLocalResource" +
				"&url=%2Fwelcome%2Fwelcome-mini.html";
		String requestHeader0098 = "GET " + requestFile0098 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: myportal.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0098, requestHost0098, requestPort0098, requestHeader0098, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0098 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [99] <- WEB ADMIN Index 99 ---
		String requestProt0099 = "https";
		String requestHost0099 = "myportal.abb.com";
		int    requestPort0099 = 443;
		String requestFile0099 = "/proxy" +
				"?pipe=sites-app";
		String requestHeader0099 = "GET " + requestFile0099 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: myportal.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0099, requestHost0099, requestPort0099, requestHeader0099, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0099 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [100] <- WEB ADMIN Index 100 ---
		String requestProt0100 = "https";
		String requestHost0100 = "myportal.abb.com";
		int    requestPort0100 = 443;
		String requestFile0100 = "/theme/static/ver_2.1-20161215_124256/themes/mcp/css/img/184_warning_Y_s.png";
		String requestHeader0100 = "GET " + requestFile0100 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: myportal.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0100, requestHost0100, requestPort0100, requestHeader0100, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0100 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;


		// all http requests of page #2_3 successful done
		return true;
	}


	/**
	 * Recorded http requests of page #2_4.
	 *
	 * @return  true:  method successful completed.
	 *          false: method/loop failed.
	 */
	boolean executePage_2_4(int totalLoopCounter, LoadtestPluginContext loopPluginContext, InnerLoopContext innerLoopContext, Object httpLogVectorObject) throws Exception
	{
		// ... continuing page #2 (fragment 5 of 5)
		// ----------------------------------------



		// --- HTTP REQUEST: Test [101] <- WEB ADMIN Index 101 ---
		String requestProt0101 = "https";
		String requestHost0101 = "myportal.abb.com";
		int    requestPort0101 = 443;
		String requestFile0101 = "/dynaTraceMonitor" +
				"?bwstate=2" +
				"&unique=1482229049499";
		String requestHeader0101 = "GET " + requestFile0101 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: myportal.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0101, requestHost0101, requestPort0101, requestHeader0101, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0101 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [102] <- WEB ADMIN Index 102 ---
		String requestProt0102 = "https";
		String requestHost0102 = "myportal.abb.com";
		int    requestPort0102 = 443;
		String requestFile0102 = "/proxy" +
				"?pipe=installations-app-post";
		String requestContent0102 = 
				"Page=1" +
				"&PageSize=10" +
				"&SearchTxt=" +
				"&sort=%5B%7B%22COLUMN_NAME%22%3A%22SEP_DATE%22%2C%22IS_DESC%22%3A%22N%22%2C%22NULLS_FIRST%22%3A%22N%22%7D%5D" +
				"&filter=%5B%7B%22COLUMN_NAME%22%3A%22SEP_DATE%22%2C%22CONDITION_TYPE%22%3A%22Between%22%2C%22VALUES%22%3A%5B%222011-12-02%22%2C%222021-12-02%22%5D%7D%5D";
		String requestHeader0102 = "POST " + requestFile0102 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: myportal.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Content-Type: application/x-www-form-urlencoded\r\n" + 
				"Content-Length: " + requestContent0102.length() + "\r\n" + 		// Content-Length: 289
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0102, requestHost0102, requestPort0102, requestHeader0102, requestContent0102.getBytes(), requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		if (debugLoops)
		{
			if (Lib.isAsciiContent(testURL.getRequestContent(), 256))
				log(">>> " + new String(testURL.getRequestContent()));
			else
				log(">>> [binary data]");
		}

		testURL.execute(performanceData);
		requestHeader0102 = null;		// support garbage collector to reduce memory
		requestContent0102 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JSON", header text fragment = [verification disabled], recorded content size = 79
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JSON", null, null);		// Test [102] <- Index 102
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [103] <- WEB ADMIN Index 103 ---
		String requestProt0103 = "https";
		String requestHost0103 = "myportal.abb.com";
		int    requestPort0103 = 443;
		String requestFile0103 = "/dynaTraceMonitor";
		String requestContent0103 = 
				"$a=1%7C1%7C_load_%7C_load_%7C-%7C1482229040285%7C0%7C1835%2C2%7C2%7Cj1.8.3%7Cxhr%7C-%7C1482229043976%7C0%7C1835%7C-%7C-%7C%2Fproxy%3Fpipe%3Dnotifications%26url%3D%252Fget%253FpageSize%253D20%2526pageNumber%253D0%2526type%253Dsystem%2C3%7C3%7CjQuery%20reported%20%22error%22%7C_warning_%7C-%7C1482229049492%7C1482229049492%7C-1$v=63$fId=229041158_288$PV=1$rId=RID_1445031923$rpId=346068614$url=https%3A%2F%2Fmyportal.abb.com%2Fhome$title=myABB%20business%20portal%20Dashboard$time=1482229051912";
		byte[] requestContentBinary0103 = requestContent0103.getBytes("UTF-8");
		String requestHeader0103 = "POST " + requestFile0103 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: myportal.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Content-Type: text/plain;charset=UTF-8\r\n" + 
				"Content-Length: " + requestContentBinary0103.length + "\r\n" + 		// Content-Length: 493
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0103, requestHost0103, requestPort0103, requestHeader0103, requestContentBinary0103, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		if (debugLoops)
		{
			if (Lib.isAsciiContent(testURL.getRequestContent(), 256))
				log(">>> " + new String(testURL.getRequestContent()));
			else
				log(">>> [binary data]");
		}

		testURL.execute(performanceData);
		requestHeader0103 = null;		// support garbage collector to reduce memory
		requestContent0103 = null;		// support garbage collector to reduce memory
		requestContentBinary0103 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/PLAIN", header text fragment = [verification disabled], recorded content size = 132
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/PLAIN", null, null);		// Test [103] <- Index 103
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [104] <- WEB ADMIN Index 104 ---
		String requestProt0104 = "https";
		String requestHost0104 = "myportal.abb.com";
		int    requestPort0104 = 443;
		String requestFile0104 = "/proxy" +
				"?pipe=servis%2FSites%2Fdashboard%2Fpost";
		String requestContent0104 = 
				"siteId=all" +
				"&monthsForLastService=3" +
				"&monthsForNextService=3" +
				"&monthsToExpiration=3" +
				"&monthsForLifecycleChange=6" +
				"&categories=%5B%5D";
		byte[] requestContentBinary0104 = requestContent0104.getBytes("UTF-8");
		String requestHeader0104 = "POST " + requestFile0104 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: myportal.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Content-Type: application/x-www-form-urlencoded;charset=UTF-8\r\n" + 
				"Content-Length: " + requestContentBinary0104.length + "\r\n" + 		// Content-Length: 122
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0104, requestHost0104, requestPort0104, requestHeader0104, requestContentBinary0104, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		if (debugLoops)
		{
			if (Lib.isAsciiContent(testURL.getRequestContent(), 256))
				log(">>> " + new String(testURL.getRequestContent()));
			else
				log(">>> [binary data]");
		}

		testURL.execute(performanceData);
		requestHeader0104 = null;		// support garbage collector to reduce memory
		requestContent0104 = null;		// support garbage collector to reduce memory
		requestContentBinary0104 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JSON", header text fragment = [verification disabled], recorded content size = 299
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JSON", null, null);		// Test [104] <- Index 104
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [105] <- WEB ADMIN Index 105 ---
		String requestProt0105 = "https";
		String requestHost0105 = "myportal.abb.com";
		int    requestPort0105 = 443;
		String requestFile0105 = "/dynaTraceMonitor" +
				"?bwstate=3" +
				"&unique=1482229052612";
		String requestHeader0105 = "GET " + requestFile0105 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: myportal.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0105, requestHost0105, requestPort0105, requestHeader0105, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0105 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [106] <- WEB ADMIN Index 106 ---
		String requestProt0106 = "https";
		String requestHost0106 = "myportal.abb.com";
		int    requestPort0106 = 443;
		String requestFile0106 = "/dynaTraceMonitor" +
				"?bwstate=4" +
				"&unique=1482229053393";
		String requestHeader0106 = "GET " + requestFile0106 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: myportal.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0106, requestHost0106, requestPort0106, requestHeader0106, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0106 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [107] <- WEB ADMIN Index 107 ---
		String requestProt0107 = "https";
		String requestHost0107 = "myportal.abb.com";
		int    requestPort0107 = 443;
		String requestFile0107 = "/dynaTraceMonitor" +
				"?bwstate=5" +
				"&unique=1482229055655";
		String requestHeader0107 = "GET " + requestFile0107 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: myportal.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0107, requestHost0107, requestPort0107, requestHeader0107, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0107 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [108] <- WEB ADMIN Index 108 ---
		String requestProt0108 = "https";
		String requestHost0108 = "myportal.abb.com";
		int    requestPort0108 = 443;
		String requestFile0108 = "/dynaTraceMonitor" +
				"?bwstate=6" +
				"&unique=1482229056446";
		String requestHeader0108 = "GET " + requestFile0108 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: myportal.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0108, requestHost0108, requestPort0108, requestHeader0108, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0108 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [109] <- WEB ADMIN Index 109 ---
		String requestProt0109 = "https";
		String requestHost0109 = "myportal.abb.com";
		int    requestPort0109 = 443;
		String requestFile0109 = "/static/favicon.ico";
		String requestHeader0109 = "GET " + requestFile0109 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: myportal.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0109, requestHost0109, requestPort0109, requestHeader0109, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0109 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [110] <- WEB ADMIN Index 110 ---
		String requestProt0110 = "https";
		String requestHost0110 = "myportal.abb.com";
		int    requestPort0110 = 443;
		String requestFile0110 = "/dynaTraceMonitor";
		String requestContent0110 = 
				"$a=1%7C1%7C_load_%7C_load_%7C-%7C1482229040285%7C1482229056937%7C2063%2C2%7C2%7Cj1.8.3%7Cxhr%7C-%7C1482229043976%7C1482229052782%7C1879%7C-%7C-%7C%2Fproxy%3Fpipe%3Dnotifications%26url%3D%252Fget%253FpageSize%253D20%2526pageNumber%253D0%2526type%253Dsystem%2C3%7C3%7CjQuery%20reported%20%22error%22%7C_warning_%7C-%7C1482229049492%7C1482229049492%7C-1%2C2%7C4%7C_onload_%7C_load_%7C-%7C1482229056915%7C1482229056937%7C2063$v=63$fId=229041158_288$rId=RID_1445031923$rpId=346068614$domR=1482229056911$w=1280$h=597$nt=a255b1482229040285c21d318e320f320g320h320i320k327l324m713n718o2133p2265q2760r16626s16630t16652$bw=7_464$url=https%3A%2F%2Fmyportal.abb.com%2Fhome$title=myABB%20business%20portal%20Dashboard$time=1482229056958";
		byte[] requestContentBinary0110 = requestContent0110.getBytes("UTF-8");
		String requestHeader0110 = "POST " + requestFile0110 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: myportal.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Content-Type: text/plain;charset=UTF-8\r\n" + 
				"Content-Length: " + requestContentBinary0110.length + "\r\n" + 		// Content-Length: 722
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0110, requestHost0110, requestPort0110, requestHeader0110, requestContentBinary0110, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		if (debugLoops)
		{
			if (Lib.isAsciiContent(testURL.getRequestContent(), 256))
				log(">>> " + new String(testURL.getRequestContent()));
			else
				log(">>> [binary data]");
		}

		testURL.execute(performanceData);
		requestHeader0110 = null;		// support garbage collector to reduce memory
		requestContent0110 = null;		// support garbage collector to reduce memory
		requestContentBinary0110 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/PLAIN", header text fragment = [verification disabled], recorded content size = 132
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/PLAIN", null, null);		// Test [110] <- Index 110
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [111] <- WEB ADMIN Index 111 ---
		String requestProt0111 = "https";
		String requestHost0111 = "myportal.abb.com";
		int    requestPort0111 = 443;
		String requestFile0111 = "/dynaTraceMonitor";
		String requestContent0111 = 
				"$bw=7_464$fId=229041158_288$v=63$url=https%3A%2F%2Fmyportal.abb.com%2Fhome$title=myABB%20business%20portal%20Dashboard$time=1482229058960";
		byte[] requestContentBinary0111 = requestContent0111.getBytes("UTF-8");
		String requestHeader0111 = "POST " + requestFile0111 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: myportal.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Content-Type: text/plain;charset=UTF-8\r\n" + 
				"Content-Length: " + requestContentBinary0111.length + "\r\n" + 		// Content-Length: 137
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0111, requestHost0111, requestPort0111, requestHeader0111, requestContentBinary0111, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		if (debugLoops)
		{
			if (Lib.isAsciiContent(testURL.getRequestContent(), 256))
				log(">>> " + new String(testURL.getRequestContent()));
			else
				log(">>> [binary data]");
		}

		testURL.execute(performanceData);
		requestHeader0111 = null;		// support garbage collector to reduce memory
		requestContent0111 = null;		// support garbage collector to reduce memory
		requestContentBinary0111 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/PLAIN", header text fragment = [verification disabled], recorded content size = 132
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/PLAIN", null, null);		// Test [111] <- Index 111
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [112] <- WEB ADMIN Index 112 ---
		String requestProt0112 = "https";
		String requestHost0112 = "myportal.abb.com";
		int    requestPort0112 = 443;
		String requestFile0112 = "/dynaTraceMonitor";
		String requestContent0112 = 
				requestFileCache.readFile("LoginLogoutSingapore_RequestContent0112.txt").getFileDataAsString("UTF-8");		// note: consider duplicated definition of this file name near end of the load test program - used for ZIP-dialogue in Project Navigator
		byte[] requestContentBinary0112 = requestContent0112.getBytes("UTF-8");
		String requestHeader0112 = "POST " + requestFile0112 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: myportal.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Content-Type: text/plain;charset=UTF-8\r\n" + 
				"Content-Length: " + requestContentBinary0112.length + "\r\n" + 		// Content-Length: 17981
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0112, requestHost0112, requestPort0112, requestHeader0112, requestContentBinary0112, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		if (debugLoops)
		{
			if (Lib.isAsciiContent(testURL.getRequestContent(), 256))
				log(">>> " + new String(testURL.getRequestContent()));
			else
				log(">>> [binary data]");
		}

		testURL.execute(performanceData);
		requestHeader0112 = null;		// support garbage collector to reduce memory
		requestContent0112 = null;		// support garbage collector to reduce memory
		requestContentBinary0112 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/PLAIN", header text fragment = [verification disabled], recorded content size = 132
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/PLAIN", null, null);		// Test [112] <- Index 112
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated



		// all http requests of page #2_4 successful done
		return true;
	}


	/**
	 * Recorded http requests of page #3.
	 *
	 * @return  true:  method successful completed.
	 *          false: method/loop failed.
	 */
	boolean executePage_3(int totalLoopCounter, LoadtestPluginContext loopPluginContext, InnerLoopContext innerLoopContext, Object httpLogVectorObject) throws Exception
	{
		// # Page #3: Logout
		// # ---------------



		// --- HTTP REQUEST: Test [114] <- WEB ADMIN Index 114 ---
		String requestProt0114 = "https";
		String requestHost0114 = "myportal.abb.com";
		int    requestPort0114 = 443;
		String requestFile0114 = "/dynaTraceMonitor";
		String requestContent0114 = 
				"$bw=7_464$fId=229041158_288$v=63$url=https%3A%2F%2Fmyportal.abb.com%2Fhome$title=myABB%20business%20portal%20Dashboard$time=1482229089083";
		byte[] requestContentBinary0114 = requestContent0114.getBytes("UTF-8");
		String requestHeader0114 = "POST " + requestFile0114 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: myportal.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Content-Type: text/plain;charset=UTF-8\r\n" + 
				"Content-Length: " + requestContentBinary0114.length + "\r\n" + 		// Content-Length: 137
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0114, requestHost0114, requestPort0114, requestHeader0114, requestContentBinary0114, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		if (debugLoops)
		{
			if (Lib.isAsciiContent(testURL.getRequestContent(), 256))
				log(">>> " + new String(testURL.getRequestContent()));
			else
				log(">>> [binary data]");
		}

		testURL.execute(performanceData);
		requestHeader0114 = null;		// support garbage collector to reduce memory
		requestContent0114 = null;		// support garbage collector to reduce memory
		requestContentBinary0114 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/PLAIN", header text fragment = [verification disabled], recorded content size = 132
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/PLAIN", null, null);		// Test [114] <- Index 114
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [115] <- WEB ADMIN Index 115 ---
		String requestProt0115 = "https";
		String requestHost0115 = "myportal.abb.com";
		int    requestPort0115 = 443;
		String requestFile0115 = "/home" +
				"?GLO=true";
		String requestHeader0115 = "GET " + requestFile0115 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: myportal.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"Upgrade-Insecure-Requests: 1\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0115, requestHost0115, requestPort0115, requestHeader0115, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0115 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 302, content type = [verification disabled], header text fragment = [verification disabled], recorded content size = 0
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {302}, null, null, null);		// Test [115] <- Index 115
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [116] <- WEB ADMIN Index 116 ---
		log();
		log("# title: Working...");
		String requestProt0116 = "https";
		String requestHost0116 = "stsint.abb.com";
		int    requestPort0116 = 443;
		String requestFile0116 = "/adfs/ls/" +
				"?SAMLRequest=nVXbcqJKFH3PV1jk0UIaxBsVrWMkOojGBLy%2FTDXQKALd2N2I%2BvWDt5TJnDOVM48s1l577QubJwbjKNEGZEVSbqFtihgv7OMIM%2B38pimkFGsEsoBpGMaIadzV7PZwoCkloCWUcOKSSLiE%2FJkMGUOUBwQLBT3PEmB4emgKa84TpkkS4yzAvAQdp%2BSSWIKez6SISULB0JuCof8EKkSwVlNF2KjIolr1PLHhVGqiD%2BS6AqsNAOtOTmYsRQZmHGLeFBQgV0VZERUwloEm1zUZlMq12lIoTBFl5%2FS5NaH1dCpWO8fSu%2FK%2FW1DrVkN8SAjlMLpV8STdCbeePBasNDtY5aWnFF0TncBLF3KBLMtKWblE6EpSAAASaEg560R5FO7ikWdgn1yBDsQEBy6MguO5pUPE18QrtKMVoQFfx%2F8hLksyOImLaO%2BKrqzix1nO7pA4RpgzQfpq95uynzxTBkW2hvKHmoV8RBF2UWFiGU3h8btzvYaPKcTMJzRmX4H%2F5wvhHYpIgjyR3cr7sPh9yd87eBKR%2Ft2pHqzyrf%2BbJn5q4EVmCqMUteqs1g%2BVIu%2BMbO75jSys9Drt9iF%2BZmHzauOefoU%2BRnADfluoj5Ff4o7yaOpya70qzq3egO7aelxVwMyad6rpxKtEhr%2BvAxD2N2%2BjYvxCltSZqF237fTK5iKy5kY4lfs1S7fDkXd4IG6ElP3unavRRMmO40Xittvb%2BvJlmMgyjdqWRNVgsLKXtmNOuuVF33wF9txppNtt5bhxktdlOBqaJJSsaP3wEnh1loI0CfUfasfg5vL1EEVJd%2B6kZmAzHacYdJ1Eyib9OaVY9SbpgW%2BjrluJN6HpzBZ1%2FK7HB5NuVvJDrxvzxuLYex5KtXfXr1VJdz9XrOx5UqzXZ%2F6bMbZsfTrsh6oPjRkY4jLpSdvBvj3omcc3KPe628qGjaebl6LxMKiaxWQY%2FdjFS1yNj0ZnB986S2WTHczQik11916ZzbJm824Edx3%2Fil7v02t%2Bggz9L%2B5ToZsvIuR%2Fpp%2BQwBP9M1Xjp%2F0N8ksgtGI3KfF8i0qQBv%2BsYhhEd6ft4uliMNFsxE5X1cAe2rd%2ByqhSUXyIROR6%2BZcNfFdsuGUgAqfmVj2IZISqF5kvkTfw02%2Bp9Qs%3D" +
				"&SigAlg=http%3A%2F%2Fwww.w3.org%2F2000%2F09%2Fxmldsig%23rsa-sha1" +
				"&Signature=ZyhgA%2FEC8XzoaDTRbTRZbUDtGd075HzzZsKg2WcqKnUANhsv7quLNdnqr5rBgA%2FraJ8IfN2E8Owl75yZ4YBesi9n4gJBOwVsdCG%2B6xL1UtVIPBDxMCPu0ZBLTjzd%2BWN27fwByNDYXCEMGkE%2FpoHjANe1I1uRp2mdFs9kLi0jIix5KetPt6T4kxTYNLfP7GrxARgdJYpAia8VLSoB3fWpM9TWSeuqVWupp3KoDRLJQcTMMMDq%2Bgp9nGkOLoQbBW8ws1Cp7Hy9wZW1FqlyfG2RLcfL5FBfGec2uu2%2FjsNEc1lS8lziJ9uWVPYc6Mlsybf9i2X2B7Y8KUovLQ9dRuYisQ%3D%3D";
		String requestHeader0116 = "GET " + requestFile0116 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: stsint.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"Upgrade-Insecure-Requests: 1\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0116, requestHost0116, requestPort0116, requestHeader0116, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0116 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 6252
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, null);		// Test [116] <- Index 116
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// extract variable(s) from response
		htmlContentParser = new HtmlContentParser(testURL, this);
		try
		{
			// extract var 'vSAMLResponse'
			vSAMLResponse = htmlContentParser.getFormTable().getForm("hiddenform").getFormItemValue("SAMLResponse");		// recorded value = PHNhbWxwOkxvZ291dFJlc3BvbnNlIElEPSJfN2NkZmMwZjctOTBmMy00ZGJkLTk2NTAtYjNmZDI4ZjljMjkyIiBWZXJzaW9uPSIyLjAiIElzc3VlSW5zdGFudD0iMjAxNi0xMi0yMFQxMDoxODowOS43ODFaIiBEZXN0aW5hdGlvbj0iaHR0cHM6Ly9teXBvcnRhbC5hYmIuY29tLyIgQ29uc2VudD0idXJuOm9hc2lzOm5hbWVzOnRjOlNBTUw6Mi4wOmNvbnNlbnQ6dW5zcGVjaWZpZWQiIEluUmVzcG9uc2VUbz0iSURfMDRhZWE3NzQtYTk1MS00NmRkLTliNTctZjAxODJhNjkwYThiIiB4bWxuczpzYW1scD0idXJuOm9hc2lzOm5hbWVzOnRjOlNBTUw6Mi4wOnByb3RvY29sIj48SXNzdWVyIHhtbG5zPSJ1cm46b2FzaXM6bmFtZXM6dGM6U0FNTDoyLjA6YXNzZXJ0aW9uIj5odHRwOi8vc3RzaW50LmFiYi5jb20vYWRmcy9zZXJ2aWNlcy90cnVzdDwvSXNzdWVyPjxkczpTaWduYXR1cmUgeG1sbnM6ZHM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvMDkveG1sZHNpZyMiPjxkczpTaWduZWRJbmZvPjxkczpDYW5vbmljYWxpemF0aW9uTWV0aG9kIEFsZ29yaXRobT0iaHR0cDovL3d3dy53My5vcmcvMjAwMS8xMC94bWwtZXhjLWMxNG4jIiAvPjxkczpTaWduYXR1cmVNZXRob2QgQWxnb3JpdGhtPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwLzA5L3htbGRzaWcjcnNhLXNoYTEiIC8+PGRzOlJlZmVyZW5jZSBVUkk9IiNfN2NkZmMwZjctOTBmMy00ZGJkLTk2NTAtYjNmZDI4ZjljMjkyIj48ZHM6VHJhbnNmb3Jtcz48ZHM6VHJhbnNmb3JtIEFsZ29yaXRobT0iaHR0cDovL3d3dy53My5vcmcvMjAwMC8wOS94bWxkc2lnI2VudmVsb3BlZC1zaWduYXR1cmUiIC8+PGRzOlRyYW5zZm9ybSBBbGdvcml0aG09Imh0dHA6Ly93d3cudzMub3JnLzIwMDEvMTAveG1sLWV4Yy1jMTRuIyIgLz48L2RzOlRyYW5zZm9ybXM+PGRzOkRpZ2VzdE1ldGhvZCBBbGdvcml0aG09Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvMDkveG1sZHNpZyNzaGExIiAvPjxkczpEaWdlc3RWYWx1ZT5OQ096V2VvamIwVXB6bEc5NkRNd2ZrSnRuUHc9PC9kczpEaWdlc3RWYWx1ZT48L2RzOlJlZmVyZW5jZT48L2RzOlNpZ25lZEluZm8+PGRzOlNpZ25hdHVyZVZhbHVlPkcrRi95eWFtNW9aeEM5dU9iWnVQWjNNTFdxbEhLUlNuS2VrYkFlZ01FdE05QlpwUmN2WHB4V3FTZDlWQVlWcDRYbjgwdjFyYUQxa2RBUVlMeDFwQ0ZyTisrS3ZndThlUFdrclFJQ0FkMGpzdkkzLzl0cUVYbER4S1lNL1VMdmlxRnFTcjZRMS9WK0xSV29sVDY5Q1FvQkc2VGFIV1ZISWI0aWdHY3ZXMTNpcnh4N3JyUnZzdEhsWStDdjM1cFZhV25XT0RRRiszdFY5QXlka0tkY0NMTXdYL01FUFZoSEZ3RUVhSEtSdVYvNXVReHh5OEtZWDUxR2p4QW0yQS85b2xsUFVsWEtUYzhMQ0REVkU4UzU3MW80bzFvVmlOc3F3QkhPR3Z4ckRDajRqYjJ3ejdGRTFuWm1NOThvRGhlMVZQakVoRy81OE5WOWpNd3ZFVm9LRFZWdz09PC9kczpTaWduYXR1cmVWYWx1ZT48S2V5SW5mbyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC8wOS94bWxkc2lnIyI+PGRzOlg1MDlEYXRhPjxkczpYNTA5Q2VydGlmaWNhdGU+TUlJSHF6Q0NCcE9nQXdJQkFnSUtPRmJ2UlFBREFBRjZMREFOQmdrcWhraUc5dzBCQVFzRkFEQlRNUk13RVFZS0NaSW1pWlB5TEdRQkdSWURRMDlOTVJNd0VRWUtDWkltaVpQeUxHUUJHUllEUVVKQ01Rd3dDZ1lEVlFRS0V3TkJRa0l4R1RBWEJnTlZCQU1URUVGQ1FpQkpjM04xYVc1bklFTkJJRE13SGhjTk1UVXdOekF4TWpFeU56QTVXaGNOTWpBd05URTBNVFl3TmpRMldqQjFNUXN3Q1FZRFZRUUdFd0pEU0RFT01Bd0dBMVVFQnhNRlFtRmtaVzR4SlRBakJnTlZCQW9USEVGQ1FpQkpibVp2Y20xaGRHbHZiaUJUZVhOMFpXMXpJRXgwWkM0eEZqQVVCZ05WQkFzVERVRkVJRVpUSUZOcFoyNXBibWN4RnpBVkJnTlZCQU1URG5OMGMybHVkQzVoWW1JdVkyOXRNSUlCSWpBTkJna3Foa2lHOXcwQkFRRUZBQU9DQVE4QU1JSUJDZ0tDQVFFQXVFUkxCU0g3WFZWVmlqc0lQK1ljdEhEeFdUbXBiZkdqb2VSRldxYnlNS0t4aUVWTGRBRFVHR0RpY3J3VjYxRmFEbENaaHM5SnQyM2tCNXlUUjI0NzR3bWJYNU1mNVZOQkM0c0Vjb3BMcVJlMklFN3lhQU5mUzhUN0NlQk9VLzdGMnl2b0FKU3NtWUY5UDFnMklxeXEwWi9CZEJVM3lnckRJYXFwL3ZuQW00VEdHeEQyOStmMFhIeUF2TGdlRndzb1FWc0FsUElraDBuaGk1d1I2MmI3aE00MWl5MHBLOGh1MGZCYlVsM1NDdjlXQ2cvQmowVHhJWE1BSU9TMVVhTERweXpwTkZOVjFNWktHRjlZa1NOL0ZwNFgvV0VlcHg3U3dXeHc1MVdZWmVHZzNpMmtTbkdrbmlXTlVMZ3ZNTUxKSy92bFlSaHltRVpNaS9uVGFFOXk4d0lEQVFBQm80SUVYVENDQkZrd0N3WURWUjBQQkFRREFnV2dNQjBHQTFVZERnUVdCQlRIc25ISVFLVmlhYjB5MmtoMnZMUHY2YXg0T2pBbUJnTlZIUkVFSHpBZGdodEJSRVpUTFZOcFoyNXBibWN0VTFSVFNVNVVMbUZpWWk1amIyMHdId1lEVlIwakJCZ3dGb0FVcTVNNkVTMjlQWi9vell2RnROcEVKditBRFljd2dnRnJCZ05WSFI4RWdnRmlNSUlCWGpDQ0FWcWdnZ0ZXb0lJQlVvWXJhSFIwY0RvdkwyTnliQzV3YTJrdVlXSmlMbU52YlM5QlFrSkpjM04xYVc1blEwRXpLRE1wTG1OeWJJYUJxR3hrWVhBNkx5OHZRMDQ5UVVKQ1NYTnpkV2x1WjBOQk15Z3pLU3hEVGoxRFJGQXNRMDQ5VUhWaWJHbGpKVEl3UzJWNUpUSXdVMlZ5ZG1salpYTXNRMDQ5VTJWeWRtbGpaWE1zUTA0OVEyOXVabWxuZFhKaGRHbHZiaXhFUXoxaFltSXNSRU05WTI5dFAyTmxjblJwWm1sallYUmxVbVYyYjJOaGRHbHZia3hwYzNRL1ltRnpaVDl2WW1wbFkzUkRiR0Z6Y3oxalVreEVhWE4wY21saWRYUnBiMjVRYjJsdWRJWjRiR1JoY0RvdkwyTnliQzV3YTJrdVlXSmlMbU52YlM5RFRqMUJRa0pKYzNOMWFXNW5RMEV6S0RNcExFTk9QVU5FVUN4RFRqMVFTMGsvWTJWeWRHbG1hV05oZEdWU1pYWnZZMkYwYVc5dVRHbHpkRDlpWVhObFAyOWlhbVZqZEVOc1lYTnpQV05TVEVScGMzUnlhV0oxZEdsdmJsQnZhVzUwTUlJQm1BWUlLd1lCQlFVSEFRRUVnZ0dLTUlJQmhqQTNCZ2dyQmdFRkJRY3dBb1lyYUhSMGNEb3ZMMkZwWVM1d2Eya3VZV0ppTG1OdmJTOUJRa0pKYzNOMWFXNW5RMEV6S0RNcExtTnlkRENCcUFZSUt3WUJCUVVITUFLR2dadHNaR0Z3T2k4dkwwTk9QVUZDUWtsemMzVnBibWREUVRNc1EwNDlRVWxCTEVOT1BWQjFZbXhwWXlVeU1FdGxlU1V5TUZObGNuWnBZMlZ6TEVOT1BWTmxjblpwWTJWekxFTk9QVU52Ym1acFozVnlZWFJwYjI0c1JFTTlZV0ppTEVSRFBXTnZiVDlqUVVObGNuUnBabWxqWVhSbFAySmhjMlUvYjJKcVpXTjBRMnhoYzNNOVkyVnlkR2xtYVdOaGRHbHZia0YxZEdodmNtbDBlVEIzQmdnckJnRUZCUWN3QW9acmJHUmhjRG92TDJGcFlTNXdhMmt1WVdKaUxtTnZiUzlEVGoxQlFrSkpjM04xYVc1blEwRXpMRU5PUFVGSlFTeERUajFRUzBrL1kwRkRaWEowYVdacFkyRjBaVDlpWVhObFAyOWlhbVZqZEVOc1lYTnpQV05sY25ScFptbGpZWFJwYjI1QmRYUm9iM0pwZEhrd0p3WUlLd1lCQlFVSE1BR0dHMmgwZEhBNkx5OWhhV0V1Y0d0cExtRmlZaTVqYjIwdmIyTnpjREE4QmdrckJnRUVBWUkzRlFjRUx6QXRCaVVyQmdFRUFZSTNGUWpIcUNhR3NJUjZocldMQ29McWpXcUVqNjBoS1lHTnQwaUQ3K3RUQWdGa0FnRU5NQjBHQTFVZEpRUVdNQlFHQ0NzR0FRVUZCd01DQmdnckJnRUZCUWNEQVRCUkJnTlZIU0FFU2pCSU1FWUdEQ3NHQVFRQmdkY0hBUjRLQWpBMk1EUUdDQ3NHQVFVRkJ3SUJGaWhvZEhSd09pOHZZM0F1Y0d0cExtRmlZaTVqYjIwdlUxTk1VMlZ5ZG1WeVNXNTBaWEp1WVd3dk1DY0dDU3NHQVFRQmdqY1ZDZ1FhTUJnd0NnWUlLd1lCQlFVSEF3SXdDZ1lJS3dZQkJRVUhBd0V3RFFZSktvWklodmNOQVFFTEJRQURnZ0VCQUJuYWFJU1dDUTVzdEk5VlVhK09xWk5aZUZ2WHlUeWFNMVZTeXFJYUV0NTVLOEg1dHM3THRlNkJjQmRkalR4UXV4UnJTWVJHenhBMkFuMFNGRDc5L0loRnkwN0V0MHBzUE5hY2lXcTd5aGtJSFdPMlhlQmZLV2lldEliNzhPc2U5OHN1MWpnZHl6ZjdVcVNhOEVadTZyclB6R2FiMjg1V0JFS0NZYU9ZOTc0NmxGT21DaFVoOWFmK1grMEFkTjk5U2dsR0xMNS8xcVNIZ0ZaTDUrTUhiZWFYWjhISndqRzJiSUVCdFpNNXlkb0ppK2NLR3BpZGhoOVVKandwelhCTHNDVnpQci9aWWpvelZoSllncFk4Ung5ejQrODByMllzbGJCeWQ4S3BoVCtLVjlMTUZjMDZDVzQveXo5MWx5WHBFMTlJd3l5cnIzVFJ1SjFBWVl1UVdGcz08L2RzOlg1MDlDZXJ0aWZpY2F0ZT48L2RzOlg1MDlEYXRhPjwvS2V5SW5mbz48L2RzOlNpZ25hdHVyZT48c2FtbHA6U3RhdHVzPjxzYW1scDpTdGF0dXNDb2RlIFZhbHVlPSJ1cm46b2FzaXM6bmFtZXM6dGM6U0FNTDoyLjA6c3RhdHVzOlN1Y2Nlc3MiIC8+PC9zYW1scDpTdGF0dXM+PC9zYW1scDpMb2dvdXRSZXNwb25zZT4=
			log("<<< vSAMLResponse = " + vSAMLResponse);
		}
		catch (Exception e) { vSAMLResponse = null; log(e); }
		if (vSAMLResponse == null)
		{
			// failure - dump wrong response content and abort current outer loop - after that start next loop
			String errorText = "*** error: unable to extract var 'vSAMLResponse' from html form parameter";
			log(errorText);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			threadStep = performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_USER_SPECIFIC_TEST_FAILED, errorText, testURL, this);
		
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [117] <- WEB ADMIN Index 117 ---
		log();
		log("# title: Object moved");
		String requestProt0117 = "https";
		String requestHost0117 = "stsint.abb.com";
		int    requestPort0117 = 443;
		String requestFile0117 = "/adfs/ls/" +
				"?wa=wsignout1.0";
		String requestHeader0117 = "GET " + requestFile0117 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: stsint.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"Upgrade-Insecure-Requests: 1\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0117, requestHost0117, requestPort0117, requestHeader0117, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0117 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 302, content type = [verification disabled], header text fragment = [verification disabled], recorded content size = 171
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {302}, null, null, null);		// Test [117] <- Index 117
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [118] <- WEB ADMIN Index 118 ---
		log();
		log("# title: Object moved");
		String requestProt0118 = "https";
		String requestHost0118 = "stsint.abb.com";
		int    requestPort0118 = 443;
		String requestFile0118 = "/adfs/ls/Fwd.aspx" +
				"?wa=wsignout1.0";
		String requestHeader0118 = "GET " + requestFile0118 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: stsint.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"Upgrade-Insecure-Requests: 1\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0118, requestHost0118, requestPort0118, requestHeader0118, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0118 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 302, content type = [verification disabled], header text fragment = [verification disabled], recorded content size = 165
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {302}, null, null, null);		// Test [118] <- Index 118
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [119] <- WEB ADMIN Index 119 ---
		log();
		log("# title: Document Moved");
		String requestProt0119 = "https";
		String requestHost0119 = "stsint.abb.com";
		int    requestPort0119 = 443;
		String requestFile0119 = "/vissts" +
				"?wa=wsignout1.0";
		String requestHeader0119 = "GET " + requestFile0119 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: stsint.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"Upgrade-Insecure-Requests: 1\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0119, requestHost0119, requestPort0119, requestHeader0119, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0119 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [120] <- WEB ADMIN Index 120 ---
		log();
		log("# title: Object moved");
		String requestProt0120 = "https";
		String requestHost0120 = "stsint.abb.com";
		int    requestPort0120 = 443;
		String requestFile0120 = "/vissts/" +
				"?wa=wsignout1.0";
		String requestHeader0120 = "GET " + requestFile0120 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: stsint.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"Upgrade-Insecure-Requests: 1\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0120, requestHost0120, requestPort0120, requestHeader0120, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0120 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [121] <- WEB ADMIN Index 121 ---
		log();
		log("# title: Optimal IdM :: Federation SignOut");
		String requestProt0121 = "https";
		String requestHost0121 = "stsint.abb.com";
		int    requestPort0121 = 443;
		String requestFile0121 = "/vissts/public/Signout.aspx" +
				"?wa=wsignout1.0";
		String requestHeader0121 = "GET " + requestFile0121 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: stsint.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"Upgrade-Insecure-Requests: 1\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0121, requestHost0121, requestPort0121, requestHeader0121, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0121 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [122] <- WEB ADMIN Index 122 ---
		String requestProt0122 = "https";
		String requestHost0122 = "stsint.abb.com";
		int    requestPort0122 = 443;
		String requestFile0122 = "/vissts/WebResource.axd" +
				"?d=Z-4zMJaBfuT6SBRMvp48cNhBR_bGg-52daubIj44WkV_5JijaXJQRHvMK9YNU5nZyBgFsLI-i3IcjO6SVLzquZM1Vvmzp3WOmO1JvJvLa-MfgyakDiDXTXnNKs_fWb_WKwBvNw6eunI-FrS9YBwbzsRt22ezGZrS1tkgzq0jb9IQcgCt-gpp_BTxWBAdDjKz0" +
				"&t=634994703760000000";
		String requestHeader0122 = "GET " + requestFile0122 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: stsint.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0122, requestHost0122, requestPort0122, requestHeader0122, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0122 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [123] <- WEB ADMIN Index 123 ---
		String requestProt0123 = "https";
		String requestHost0123 = "stsint.abb.com";
		int    requestPort0123 = 443;
		String requestFile0123 = "/vissts/css/visext.css";
		String requestHeader0123 = "GET " + requestFile0123 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: stsint.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0123, requestHost0123, requestPort0123, requestHeader0123, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0123 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [124] <- WEB ADMIN Index 124 ---
		String requestProt0124 = "https";
		String requestHost0124 = "stsint.abb.com";
		int    requestPort0124 = 443;
		String requestFile0124 = "/vissts/WebResource.axd" +
				"?d=sUAx8KU3U2UFg_mwakx6K82V11EvhLhGmgM9d5ztO-4M8Fp_oP8syq3arnBe9NlmEJxN6QXIFfYtKJVEFk8uGL8PDaG7ZcEFQw7muFQBrLoiB0Q_Cml2fYKVMaSq4qDYxdjPBikdmpp64J4gC04OBw2" +
				"&t=634994703760000000";
		String requestHeader0124 = "GET " + requestFile0124 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: stsint.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0124, requestHost0124, requestPort0124, requestHeader0124, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0124 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [125] <- WEB ADMIN Index 125 ---
		String requestProt0125 = "https";
		String requestHost0125 = "stsint.abb.com";
		int    requestPort0125 = 443;
		String requestFile0125 = "/vissts/WebResource.axd" +
				"?d=WFqniwSU8-fvg9OYXIPMSkRBkgzc949S6_cQ6Foo4ofhs3KydIQAccz1hEgi8W2Y6cxZT-jQAnMXY4QBjfQKzo9LnOYUPqPINruBSMBXuwz82Tqq-4TKgkzXwjfH-o2BI7Hf5c-CKKTuX5aoYhfx5w2" +
				"&t=634994703760000000";
		String requestHeader0125 = "GET " + requestFile0125 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: stsint.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0125, requestHost0125, requestPort0125, requestHeader0125, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0125 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [126] <- WEB ADMIN Index 126 ---
		String requestProt0126 = "https";
		String requestHost0126 = "stsint.abb.com";
		int    requestPort0126 = 443;
		String requestFile0126 = "/vissts/WebResource.axd" +
				"?d=9rcSIWYOB5FjXt-JEDJOZAlBGjBW-7HPp7VglTeylvTXs7a8Frl92eCApghzRwYBkP5KAUtQTnuBI7TTdW5mGMBi7b0fTEIusuTpTrI5Hl9EaKB-VzAlKjlgAVYeXIBWiZXEQFo9m_nt_qRTd4HOXbTU9GEipt1a_cyBmCfdC1k1" +
				"&t=634994703760000000";
		String requestHeader0126 = "GET " + requestFile0126 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: stsint.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0126, requestHost0126, requestPort0126, requestHeader0126, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0126 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [127] <- WEB ADMIN Index 127 ---
		String requestProt0127 = "https";
		String requestHost0127 = "stsint.abb.com";
		int    requestPort0127 = 443;
		String requestFile0127 = "/vissts/images/optimal-logo-smaller2.jpg";
		String requestHeader0127 = "GET " + requestFile0127 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: stsint.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0127, requestHost0127, requestPort0127, requestHeader0127, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0127 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [128] <- WEB ADMIN Index 128 ---
		log();
		log("# title: Home");
		String requestProt0128 = "https";
		String requestHost0128 = "myportal.abb.com";
		int    requestPort0128 = 443;
		String requestFile0128 = "/";
		String requestContent0128 = 
				"SAMLResponse=" + java.net.URLEncoder.encode(vSAMLResponse);		// recorded value = PHNhbWxwOkxvZ291dFJlc3BvbnNlIElEPSJfN2NkZmMwZjctOTBmMy00ZGJkLTk2NTAtYjNmZDI4ZjljMjkyIiBWZXJzaW9uPSIyLjAiIElzc3VlSW5zdGFudD0iMjAxNi0xMi0yMFQxMDoxODowOS43ODFaIiBEZXN0aW5hdGlvbj0iaHR0cHM6Ly9teXBvcnRhbC5hYmIuY29tLyIgQ29uc2VudD0idXJuOm9hc2lzOm5hbWVzOnRjOlNBTUw6Mi4wOmNvbnNlbnQ6dW5zcGVjaWZpZWQiIEluUmVzcG9uc2VUbz0iSURfMDRhZWE3NzQtYTk1MS00NmRkLTliNTctZjAxODJhNjkwYThiIiB4bWxuczpzYW1scD0idXJuOm9hc2lzOm5hbWVzOnRjOlNBTUw6Mi4wOnByb3RvY29sIj48SXNzdWVyIHhtbG5zPSJ1cm46b2FzaXM6bmFtZXM6dGM6U0FNTDoyLjA6YXNzZXJ0aW9uIj5odHRwOi8vc3RzaW50LmFiYi5jb20vYWRmcy9zZXJ2aWNlcy90cnVzdDwvSXNzdWVyPjxkczpTaWduYXR1cmUgeG1sbnM6ZHM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvMDkveG1sZHNpZyMiPjxkczpTaWduZWRJbmZvPjxkczpDYW5vbmljYWxpemF0aW9uTWV0aG9kIEFsZ29yaXRobT0iaHR0cDovL3d3dy53My5vcmcvMjAwMS8xMC94bWwtZXhjLWMxNG4jIiAvPjxkczpTaWduYXR1cmVNZXRob2QgQWxnb3JpdGhtPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwLzA5L3htbGRzaWcjcnNhLXNoYTEiIC8%2BPGRzOlJlZmVyZW5jZSBVUkk9IiNfN2NkZmMwZjctOTBmMy00ZGJkLTk2NTAtYjNmZDI4ZjljMjkyIj48ZHM6VHJhbnNmb3Jtcz48ZHM6VHJhbnNmb3JtIEFsZ29yaXRobT0iaHR0cDovL3d3dy53My5vcmcvMjAwMC8wOS94bWxkc2lnI2VudmVsb3BlZC1zaWduYXR1cmUiIC8%2BPGRzOlRyYW5zZm9ybSBBbGdvcml0aG09Imh0dHA6Ly93d3cudzMub3JnLzIwMDEvMTAveG1sLWV4Yy1jMTRuIyIgLz48L2RzOlRyYW5zZm9ybXM%2BPGRzOkRpZ2VzdE1ldGhvZCBBbGdvcml0aG09Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvMDkveG1sZHNpZyNzaGExIiAvPjxkczpEaWdlc3RWYWx1ZT5OQ096V2VvamIwVXB6bEc5NkRNd2ZrSnRuUHc9PC9kczpEaWdlc3RWYWx1ZT48L2RzOlJlZmVyZW5jZT48L2RzOlNpZ25lZEluZm8%2BPGRzOlNpZ25hdHVyZVZhbHVlPkcrRi95eWFtNW9aeEM5dU9iWnVQWjNNTFdxbEhLUlNuS2VrYkFlZ01FdE05QlpwUmN2WHB4V3FTZDlWQVlWcDRYbjgwdjFyYUQxa2RBUVlMeDFwQ0ZyTisrS3ZndThlUFdrclFJQ0FkMGpzdkkzLzl0cUVYbER4S1lNL1VMdmlxRnFTcjZRMS9WK0xSV29sVDY5Q1FvQkc2VGFIV1ZISWI0aWdHY3ZXMTNpcnh4N3JyUnZzdEhsWStDdjM1cFZhV25XT0RRRiszdFY5QXlka0tkY0NMTXdYL01FUFZoSEZ3RUVhSEtSdVYvNXVReHh5OEtZWDUxR2p4QW0yQS85b2xsUFVsWEtUYzhMQ0REVkU4UzU3MW80bzFvVmlOc3F3QkhPR3Z4ckRDajRqYjJ3ejdGRTFuWm1NOThvRGhlMVZQakVoRy81OE5WOWpNd3ZFVm9LRFZWdz09PC9kczpTaWduYXR1cmVWYWx1ZT48S2V5SW5mbyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC8wOS94bWxkc2lnIyI%2BPGRzOlg1MDlEYXRhPjxkczpYNTA5Q2VydGlmaWNhdGU%2BTUlJSHF6Q0NCcE9nQXdJQkFnSUtPRmJ2UlFBREFBRjZMREFOQmdrcWhraUc5dzBCQVFzRkFEQlRNUk13RVFZS0NaSW1pWlB5TEdRQkdSWURRMDlOTVJNd0VRWUtDWkltaVpQeUxHUUJHUllEUVVKQ01Rd3dDZ1lEVlFRS0V3TkJRa0l4R1RBWEJnTlZCQU1URUVGQ1FpQkpjM04xYVc1bklFTkJJRE13SGhjTk1UVXdOekF4TWpFeU56QTVXaGNOTWpBd05URTBNVFl3TmpRMldqQjFNUXN3Q1FZRFZRUUdFd0pEU0RFT01Bd0dBMVVFQnhNRlFtRmtaVzR4SlRBakJnTlZCQW9USEVGQ1FpQkpibVp2Y20xaGRHbHZiaUJUZVhOMFpXMXpJRXgwWkM0eEZqQVVCZ05WQkFzVERVRkVJRVpUSUZOcFoyNXBibWN4RnpBVkJnTlZCQU1URG5OMGMybHVkQzVoWW1JdVkyOXRNSUlCSWpBTkJna3Foa2lHOXcwQkFRRUZBQU9DQVE4QU1JSUJDZ0tDQVFFQXVFUkxCU0g3WFZWVmlqc0lQK1ljdEhEeFdUbXBiZkdqb2VSRldxYnlNS0t4aUVWTGRBRFVHR0RpY3J3VjYxRmFEbENaaHM5SnQyM2tCNXlUUjI0NzR3bWJYNU1mNVZOQkM0c0Vjb3BMcVJlMklFN3lhQU5mUzhUN0NlQk9VLzdGMnl2b0FKU3NtWUY5UDFnMklxeXEwWi9CZEJVM3lnckRJYXFwL3ZuQW00VEdHeEQyOStmMFhIeUF2TGdlRndzb1FWc0FsUElraDBuaGk1d1I2MmI3aE00MWl5MHBLOGh1MGZCYlVsM1NDdjlXQ2cvQmowVHhJWE1BSU9TMVVhTERweXpwTkZOVjFNWktHRjlZa1NOL0ZwNFgvV0VlcHg3U3dXeHc1MVdZWmVHZzNpMmtTbkdrbmlXTlVMZ3ZNTUxKSy92bFlSaHltRVpNaS9uVGFFOXk4d0lEQVFBQm80SUVYVENDQkZrd0N3WURWUjBQQkFRREFnV2dNQjBHQTFVZERnUVdCQlRIc25ISVFLVmlhYjB5MmtoMnZMUHY2YXg0T2pBbUJnTlZIUkVFSHpBZGdodEJSRVpUTFZOcFoyNXBibWN0VTFSVFNVNVVMbUZpWWk1amIyMHdId1lEVlIwakJCZ3dGb0FVcTVNNkVTMjlQWi9vell2RnROcEVKditBRFljd2dnRnJCZ05WSFI4RWdnRmlNSUlCWGpDQ0FWcWdnZ0ZXb0lJQlVvWXJhSFIwY0RvdkwyTnliQzV3YTJrdVlXSmlMbU52YlM5QlFrSkpjM04xYVc1blEwRXpLRE1wTG1OeWJJYUJxR3hrWVhBNkx5OHZRMDQ5UVVKQ1NYTnpkV2x1WjBOQk15Z3pLU3hEVGoxRFJGQXNRMDQ5VUhWaWJHbGpKVEl3UzJWNUpUSXdVMlZ5ZG1salpYTXNRMDQ5VTJWeWRtbGpaWE1zUTA0OVEyOXVabWxuZFhKaGRHbHZiaXhFUXoxaFltSXNSRU05WTI5dFAyTmxjblJwWm1sallYUmxVbVYyYjJOaGRHbHZia3hwYzNRL1ltRnpaVDl2WW1wbFkzUkRiR0Z6Y3oxalVreEVhWE4wY21saWRYUnBiMjVRYjJsdWRJWjRiR1JoY0RvdkwyTnliQzV3YTJrdVlXSmlMbU52YlM5RFRqMUJRa0pKYzNOMWFXNW5RMEV6S0RNcExFTk9QVU5FVUN4RFRqMVFTMGsvWTJWeWRHbG1hV05oZEdWU1pYWnZZMkYwYVc5dVRHbHpkRDlpWVhObFAyOWlhbVZqZEVOc1lYTnpQV05TVEVScGMzUnlhV0oxZEdsdmJsQnZhVzUwTUlJQm1BWUlLd1lCQlFVSEFRRUVnZ0dLTUlJQmhqQTNCZ2dyQmdFRkJRY3dBb1lyYUhSMGNEb3ZMMkZwWVM1d2Eya3VZV0ppTG1OdmJTOUJRa0pKYzNOMWFXNW5RMEV6S0RNcExtTnlkRENCcUFZSUt3WUJCUVVITUFLR2dadHNaR0Z3T2k4dkwwTk9QVUZDUWtsemMzVnBibWREUVRNc1EwNDlRVWxCTEVOT1BWQjFZbXhwWXlVeU1FdGxlU1V5TUZObGNuWnBZMlZ6TEVOT1BWTmxjblpwWTJWekxFTk9QVU52Ym1acFozVnlZWFJwYjI0c1JFTTlZV0ppTEVSRFBXTnZiVDlqUVVObGNuUnBabWxqWVhSbFAySmhjMlUvYjJKcVpXTjBRMnhoYzNNOVkyVnlkR2xtYVdOaGRHbHZia0YxZEdodmNtbDBlVEIzQmdnckJnRUZCUWN3QW9acmJHUmhjRG92TDJGcFlTNXdhMmt1WVdKaUxtTnZiUzlEVGoxQlFrSkpjM04xYVc1blEwRXpMRU5PUFVGSlFTeERUajFRUzBrL1kwRkRaWEowYVdacFkyRjBaVDlpWVhObFAyOWlhbVZqZEVOc1lYTnpQV05sY25ScFptbGpZWFJwYjI1QmRYUm9iM0pwZEhrd0p3WUlLd1lCQlFVSE1BR0dHMmgwZEhBNkx5OWhhV0V1Y0d0cExtRmlZaTVqYjIwdmIyTnpjREE4QmdrckJnRUVBWUkzRlFjRUx6QXRCaVVyQmdFRUFZSTNGUWpIcUNhR3NJUjZocldMQ29McWpXcUVqNjBoS1lHTnQwaUQ3K3RUQWdGa0FnRU5NQjBHQTFVZEpRUVdNQlFHQ0NzR0FRVUZCd01DQmdnckJnRUZCUWNEQVRCUkJnTlZIU0FFU2pCSU1FWUdEQ3NHQVFRQmdkY0hBUjRLQWpBMk1EUUdDQ3NHQVFVRkJ3SUJGaWhvZEhSd09pOHZZM0F1Y0d0cExtRmlZaTVqYjIwdlUxTk1VMlZ5ZG1WeVNXNTBaWEp1WVd3dk1DY0dDU3NHQVFRQmdqY1ZDZ1FhTUJnd0NnWUlLd1lCQlFVSEF3SXdDZ1lJS3dZQkJRVUhBd0V3RFFZSktvWklodmNOQVFFTEJRQURnZ0VCQUJuYWFJU1dDUTVzdEk5VlVhK09xWk5aZUZ2WHlUeWFNMVZTeXFJYUV0NTVLOEg1dHM3THRlNkJjQmRkalR4UXV4UnJTWVJHenhBMkFuMFNGRDc5L0loRnkwN0V0MHBzUE5hY2lXcTd5aGtJSFdPMlhlQmZLV2lldEliNzhPc2U5OHN1MWpnZHl6ZjdVcVNhOEVadTZyclB6R2FiMjg1V0JFS0NZYU9ZOTc0NmxGT21DaFVoOWFmK1grMEFkTjk5U2dsR0xMNS8xcVNIZ0ZaTDUrTUhiZWFYWjhISndqRzJiSUVCdFpNNXlkb0ppK2NLR3BpZGhoOVVKandwelhCTHNDVnpQci9aWWpvelZoSllncFk4Ung5ejQrODByMllzbGJCeWQ4S3BoVCtLVjlMTUZjMDZDVzQveXo5MWx5WHBFMTlJd3l5cnIzVFJ1SjFBWVl1UVdGcz08L2RzOlg1MDlDZXJ0aWZpY2F0ZT48L2RzOlg1MDlEYXRhPjwvS2V5SW5mbz48L2RzOlNpZ25hdHVyZT48c2FtbHA6U3RhdHVzPjxzYW1scDpTdGF0dXNDb2RlIFZhbHVlPSJ1cm46b2FzaXM6bmFtZXM6dGM6U0FNTDoyLjA6c3RhdHVzOlN1Y2Nlc3MiIC8%2BPC9zYW1scDpTdGF0dXM%2BPC9zYW1scDpMb2dvdXRSZXNwb25zZT4%3D
		String requestHeader0128 = "POST " + requestFile0128 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: myportal.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"Upgrade-Insecure-Requests: 1\r\n" + 
				"Content-Type: application/x-www-form-urlencoded\r\n" + 
				"Content-Length: " + requestContent0128.length() + "\r\n" + 		// Content-Length: 5815
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0128, requestHost0128, requestPort0128, requestHeader0128, requestContent0128.getBytes(), requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		if (debugLoops)
		{
			if (Lib.isAsciiContent(testURL.getRequestContent(), 256))
				log(">>> " + new String(testURL.getRequestContent()));
			else
				log(">>> [binary data]");
		}

		testURL.execute(performanceData);
		requestHeader0128 = null;		// support garbage collector to reduce memory
		requestContent0128 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 373
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, null);		// Test [128] <- Index 128
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [129] <- WEB ADMIN Index 129 ---
		String requestProt0129 = "https";
		String requestHost0129 = "stsint.abb.com";
		int    requestPort0129 = 443;
		String requestFile0129 = "/vissts/WebResource.axd" +
				"?d=iNP6syzHxTbEKd7xyxRfPHkoe6dJ-AU9G5Fq5gHK0kn5RlGaXmNaXXfULeXjC2ip4kHuebSL09TPX6C5pCvRskzJ3EOM4LHk7If_SPm6AlIjrwcyW1_4pkB84qSWN3ncUM0Hk0kgtVqoLIBkofv2_s7U-KWBx6boCCxyXNTgPhT9grfIXTfm6HBhuGbYO4qefyj2ml1iyjsuRwwMd9YApA2" +
				"&t=634994703760000000";
		String requestHeader0129 = "GET " + requestFile0129 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: stsint.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0129, requestHost0129, requestPort0129, requestHeader0129, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0129 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [130] <- WEB ADMIN Index 130 ---
		String requestProt0130 = "https";
		String requestHost0130 = "stsint.abb.com";
		int    requestPort0130 = 443;
		String requestFile0130 = "/vissts/WebResource.axd" +
				"?d=ffdimmFoVyUVMXH4u-WKp8RRA4P4Q7F62jpIDBO3xJFg_FadyopRXHeezaIDhdhVitwjgMmX7fc_smfpQfqU5OlAb0aVP8xyRJzdJIWfTczR6hbbyc-3TlrhwNe0PRegqKXhsyR7xjmcPNvnDJc8wZtsAucy2A_ce-epFd9Tks41" +
				"&t=634994703760000000";
		String requestHeader0130 = "GET " + requestFile0130 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: stsint.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0130, requestHost0130, requestPort0130, requestHeader0130, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0130 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [131] <- WEB ADMIN Index 131 ---
		String requestProt0131 = "https";
		String requestHost0131 = "stsint.abb.com";
		int    requestPort0131 = 443;
		String requestFile0131 = "/vissts/WebResource.axd" +
				"?d=xKtacl2FQw6NTsHITMxBKqLWp3ouSDbrFS6IhD9V6lv3nYdKdYav6Qel71ovggOkMh1wgZHNbAzQJhOjSDmlUzCX55v3CxOEDMctuyRZ9_8JCE9JBgnymN726ejjayFoIapDxDHtEt6iC6d4S0G9FA2" +
				"&t=634994703760000000";
		String requestHeader0131 = "GET " + requestFile0131 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: stsint.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0131, requestHost0131, requestPort0131, requestHeader0131, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0131 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [132] <- WEB ADMIN Index 132 ---
		log();
		log("# title: Sign-Out Page");
		String requestProt0132 = "https";
		String requestHost0132 = "stsint.abb.com";
		int    requestPort0132 = 443;
		String requestFile0132 = "/adfs/ls/" +
				"?wa=wsignoutcleanup1.0";
		String requestHeader0132 = "GET " + requestFile0132 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: stsint.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"Upgrade-Insecure-Requests: 1\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0132, requestHost0132, requestPort0132, requestHeader0132, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0132 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [133] <- WEB ADMIN Index 133 ---
		String requestProt0133 = "https";
		String requestHost0133 = "stsint.abb.com";
		int    requestPort0133 = 443;
		String requestFile0133 = "/adfs/ls/MasterPages/StyleSheet.css";
		String requestHeader0133 = "GET " + requestFile0133 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: stsint.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0133, requestHost0133, requestPort0133, requestHeader0133, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0133 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;


		// all http requests of page #3 successful done
		return true;
	}


	/**
	 * Recorded http requests of page #3_1.
	 *
	 * @return  true:  method successful completed.
	 *          false: method/loop failed.
	 */
	boolean executePage_3_1(int totalLoopCounter, LoadtestPluginContext loopPluginContext, InnerLoopContext innerLoopContext, Object httpLogVectorObject) throws Exception
	{
		// ... continuing page #3 (fragment 2 of 3)
		// ----------------------------------------



		// --- HTTP REQUEST: Test [134] <- WEB ADMIN Index 134 ---
		String requestProt0134 = "https";
		String requestHost0134 = "stsint.abb.com";
		int    requestPort0134 = 443;
		String requestFile0134 = "/adfs/ls/App_Themes/Default/Spinner.gif";
		String requestHeader0134 = "GET " + requestFile0134 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: stsint.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0134, requestHost0134, requestPort0134, requestHeader0134, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0134 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [135] <- WEB ADMIN Index 135 ---
		String requestProt0135 = "https";
		String requestHost0135 = "myportal.abb.com";
		int    requestPort0135 = 443;
		String requestFile0135 = "/dynaTraceMonitor";
		String requestContent0135 = 
				"$a=1%7C1%7C_load_%7C_load_%7C-%7C1482229092763%7C1482229093662%7C7%7C-%7C-%7C-%7C-%7C-%7Chttps%3A%2F%2Fstsint.abb.com%2Fadfs%2Fls%2F%3FSAMLRequest%3DnVXbcqJKFH3PV1jk0UIaxBsVrWMkOojGBLy%252FTDXQKALd2N2I%252BvWDt5TJnDOVM48s1l577QubJwbjKNEGZEVSbqFtihgv7OMIM%252B38pimkFGsEsoBpGMaIadzV7PZwoCkloCWUcOKSSLiE%252FJkMGUOUBwQLBT3PEmB4emgKa84TpkkS4yzAvAQdp%252BSSWIKez6SISULB0JuCof8EKkSwVlNF2KjIolr1PLHhVGqiD%252BS6AqsNAOtOTmYsRQZmHGLeFBQgV0VZERUwloEm1zUZlMq12lIoTBFl5%252FS5NaH1dCpWO8fSu%252FK%252FW1DrVkN8SAjlMLpV8STdCbeePBasNDtY5aWnFF0TncBLF3KBLMtKWblE6EpSAAASaEg560R5FO7ikWdgn1yBDsQEBy6MguO5pUPE18QrtKMVoQFfx%252F8hLksyOImLaO%252BKrqzix1nO7pA4RpgzQfpq95uynzxTBkW2hvKHmoV8RBF2UWFiGU3h8btzvYaPKcTMJzRmX4H%252F5wvhHYpIgjyR3cr7sPh9yd87eBKR%252Ft2pHqzyrf%252BbJn5q4EVmCqMUteqs1g%252BVIu%252BMbO75jSys9Drt9iF%252BZmHzauOefoU%252BRnADfluoj5Ff4o7yaOpya70qzq3egO7aelxVwMyad6rpxKtEhr%252BvAxD2N2%252BjYvxCltSZqF237fTK5iKy5kY4lfs1S7fDkXd4IG6ElP3unavRRMmO40Xittvb%252BvJlmMgyjdqWRNVgsLKXtmNOuuVF33wF9txppNtt5bhxktdlOBqaJJSsaP3wEnh1loI0CfUfasfg5vL1EEVJd%252B6kZmAzHacYdJ1Eyib9OaVY9SbpgW%252BjrluJN6HpzBZ1%252FK7HB5NuVvJDrxvzxuLYex5KtXfXr1VJdz9XrOx5UqzXZ%252F6bMbZsfTrsh6oPjRkY4jLpSdvBvj3omcc3KPe628qGjaebl6LxMKiaxWQY%252FdjFS1yNj0ZnB986S2WTHczQik11916ZzbJm824Edx3%252Fil7v02t%252Bggz9L%252B5ToZsvIuR%252Fpp%252BQwBP9M1Xjp%252F0N8ksgtGI3KfF8i0qQBv%252BsYhhEd6ft4uliMNFsxE5X1cAe2rd%252ByqhSUXyIROR6%252BZcNfFdsuGUgAqfmVj2IZISqF5kvkTfw02%252Bp9Qs%253D%26SigAlg%3Dhttp%253A%252F%252Fwww.w3.org%252F2000%252F09%252Fxmldsig%2523rsa-sha1%26Signature%3DZyhgA%252FEC8XzoaDTRbTRZbUDtGd075HzzZsKg2WcqKnUANhsv7quLNdnqr5rBgA%252FraJ8IfN2E8Owl75yZ4YBesi9n4gJBOwVsdCG%252B6xL1UtVIPBDxMCPu0ZBLTjzd%252BWN27fwByNDYXCEMGkE%252FpoHjANe1I1uRp2mdFs9kLi0jIix5KetPt6T4kxTYNLfP7GrxARgdJYpAia8VLSoB3fWpM9TWSeuqVWupp3KoDRLJQcTMMMDq%252Bgp9nGkOLoQbBW8ws1Cp7Hy9wZW1FqlyfG2RLcfL5FBfGec2uu2%252FjsNEc1lS8lziJ9uWVPYc6Mlsybf9i2X2B7Y8KUovLQ9dRuYisQ%253D%253D%2C2%7C2%7C_onload_%7C_load_%7C-%7C1482229093661%7C1482229093662%7C7$v=63$fId=229093602_814$rId=RID_2418$rpId=962015059$domR=1482229093660$w=1280$h=597$nt=a0b1482229092763e6f6g6h6i6k9l7m87n780o859p860q896r897s898t899$bw=7_464$url=https%3A%2F%2Fmyportal.abb.com%2F$title=Home$time=1482229093712";
		byte[] requestContentBinary0135 = requestContent0135.getBytes("UTF-8");
		String requestHeader0135 = "POST " + requestFile0135 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: myportal.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Content-Type: text/plain;charset=UTF-8\r\n" + 
				"Content-Length: " + requestContentBinary0135.length + "\r\n" + 		// Content-Length: 2199
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0135, requestHost0135, requestPort0135, requestHeader0135, requestContentBinary0135, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		if (debugLoops)
		{
			if (Lib.isAsciiContent(testURL.getRequestContent(), 256))
				log(">>> " + new String(testURL.getRequestContent()));
			else
				log(">>> [binary data]");
		}

		testURL.execute(performanceData);
		requestHeader0135 = null;		// support garbage collector to reduce memory
		requestContent0135 = null;		// support garbage collector to reduce memory
		requestContentBinary0135 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/PLAIN", header text fragment = [verification disabled], recorded content size = 132
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/PLAIN", null, null);		// Test [135] <- Index 135
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [136] <- WEB ADMIN Index 136 ---
		String requestProt0136 = "https";
		String requestHost0136 = "myportal.abb.com";
		int    requestPort0136 = 443;
		String requestFile0136 = "/dynaTraceMonitor";
		String requestContent0136 = 
				"$bw=7_464$fId=229093602_814$v=63$url=https%3A%2F%2Fmyportal.abb.com%2F$title=Home$time=1482229093742";
		byte[] requestContentBinary0136 = requestContent0136.getBytes("UTF-8");
		String requestHeader0136 = "POST " + requestFile0136 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: myportal.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Content-Type: text/plain;charset=UTF-8\r\n" + 
				"Content-Length: " + requestContentBinary0136.length + "\r\n" + 		// Content-Length: 100
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0136, requestHost0136, requestPort0136, requestHeader0136, requestContentBinary0136, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		if (debugLoops)
		{
			if (Lib.isAsciiContent(testURL.getRequestContent(), 256))
				log(">>> " + new String(testURL.getRequestContent()));
			else
				log(">>> [binary data]");
		}

		testURL.execute(performanceData);
		requestHeader0136 = null;		// support garbage collector to reduce memory
		requestContent0136 = null;		// support garbage collector to reduce memory
		requestContentBinary0136 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/PLAIN", header text fragment = [verification disabled], recorded content size = 132
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/PLAIN", null, null);		// Test [136] <- Index 136
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [137] <- WEB ADMIN Index 137 ---
		String requestProt0137 = "https";
		String requestHost0137 = "myportal.abb.com";
		int    requestPort0137 = 443;
		String requestFile0137 = "/";
		String requestHeader0137 = "GET " + requestFile0137 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: myportal.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"Upgrade-Insecure-Requests: 1\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0137, requestHost0137, requestPort0137, requestHeader0137, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0137 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [138] <- WEB ADMIN Index 138 ---
		log();
		log("# title: Welcome Non-Logged");
		String requestProt0138 = "https";
		String requestHost0138 = "myportal.abb.com";
		int    requestPort0138 = 443;
		String requestFile0138 = "/welcome-non-logged";
		String requestHeader0138 = "GET " + requestFile0138 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: myportal.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"Upgrade-Insecure-Requests: 1\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0138, requestHost0138, requestPort0138, requestHeader0138, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0138 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [139] <- WEB ADMIN Index 139 ---
		String requestProt0139 = "https";
		String requestHost0139 = "myportal.abb.com";
		int    requestPort0139 = 443;
		String requestFile0139 = "/dtagent6310_23bgjqr_1010.js";
		String requestHeader0139 = "GET " + requestFile0139 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: myportal.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0139, requestHost0139, requestPort0139, requestHeader0139, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0139 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 304, content type = [verification disabled], header text fragment = [verification disabled], recorded content size = 0
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {304}, null, null, null);		// Test [139] <- Index 139
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [140] <- WEB ADMIN Index 140 ---
		String requestProt0140 = "https";
		String requestHost0140 = "myportal.abb.com";
		int    requestPort0140 = 443;
		String requestFile0140 = "/static/ver_2.1-20161215_124256/mcp/libs/external/angular-base/1_4_8/angular.min.js";
		String requestHeader0140 = "GET " + requestFile0140 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: myportal.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0140, requestHost0140, requestPort0140, requestHeader0140, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0140 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 304, content type = [verification disabled], header text fragment = [verification disabled], recorded content size = 0
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {304}, null, null, null);		// Test [140] <- Index 140
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [141] <- WEB ADMIN Index 141 ---
		String requestProt0141 = "https";
		String requestHost0141 = "myportal.abb.com";
		int    requestPort0141 = 443;
		String requestFile0141 = "/mvc/user/getCurrentUserGlobalVariables";
		String requestHeader0141 = "GET " + requestFile0141 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: myportal.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0141, requestHost0141, requestPort0141, requestHeader0141, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0141 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [142] <- WEB ADMIN Index 142 ---
		String requestProt0142 = "https";
		String requestHost0142 = "myportal.abb.com";
		int    requestPort0142 = 443;
		String requestFile0142 = "/static/ver_5.5.1.1-2014-12-2300:23/portalclient/css/backbase-portal.css";
		String requestHeader0142 = "GET " + requestFile0142 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: myportal.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0142, requestHost0142, requestPort0142, requestHeader0142, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0142 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 304, content type = [verification disabled], header text fragment = [verification disabled], recorded content size = 0
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {304}, null, null, null);		// Test [142] <- Index 142
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [143] <- WEB ADMIN Index 143 ---
		String requestProt0143 = "https";
		String requestHost0143 = "myportal.abb.com";
		int    requestPort0143 = 443;
		String requestFile0143 = "/static/ver_2.1-20161215_124256/mcp/resources/backbaseLaunchpadBundle.js";
		String requestHeader0143 = "GET " + requestFile0143 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: myportal.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0143, requestHost0143, requestPort0143, requestHeader0143, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0143 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 304, content type = [verification disabled], header text fragment = [verification disabled], recorded content size = 0
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {304}, null, null, null);		// Test [143] <- Index 143
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [144] <- WEB ADMIN Index 144 ---
		String requestProt0144 = "https";
		String requestHost0144 = "myportal.abb.com";
		int    requestPort0144 = 443;
		String requestFile0144 = "/static/ver_5.5.1.1-2014-12-2300:23/mcp/resources/backbasePortalClientBundle.js";
		String requestHeader0144 = "GET " + requestFile0144 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: myportal.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0144, requestHost0144, requestPort0144, requestHeader0144, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0144 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 304, content type = [verification disabled], header text fragment = [verification disabled], recorded content size = 0
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {304}, null, null, null);		// Test [144] <- Index 144
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [145] <- WEB ADMIN Index 145 ---
		String requestProt0145 = "https";
		String requestHost0145 = "myportal.abb.com";
		int    requestPort0145 = 443;
		String requestFile0145 = "/static/ver_2.1-20161215_124256/mcp/resources/mcpSharedGlobalLibrariesBundle.js";
		String requestHeader0145 = "GET " + requestFile0145 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: myportal.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0145, requestHost0145, requestPort0145, requestHeader0145, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0145 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 304, content type = [verification disabled], header text fragment = [verification disabled], recorded content size = 0
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {304}, null, null, null);		// Test [145] <- Index 145
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [146] <- WEB ADMIN Index 146 ---
		String requestProt0146 = "https";
		String requestHost0146 = "myportal.abb.com";
		int    requestPort0146 = 443;
		String requestFile0146 = "/theme/static/ver_2.1-20161215_124256/themes/mcp/backbase-base-2.css";
		String requestHeader0146 = "GET " + requestFile0146 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: myportal.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0146, requestHost0146, requestPort0146, requestHeader0146, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0146 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 304, content type = [verification disabled], header text fragment = [verification disabled], recorded content size = 0
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {304}, null, null, null);		// Test [146] <- Index 146
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [147] <- WEB ADMIN Index 147 ---
		String requestProt0147 = "https";
		String requestHost0147 = "myportal.abb.com";
		int    requestPort0147 = 443;
		String requestFile0147 = "/static/ver_2.1-20161215_124256/mcp/resources/widgetsContainersMerged.css";
		String requestHeader0147 = "GET " + requestFile0147 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: myportal.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0147, requestHost0147, requestPort0147, requestHeader0147, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0147 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 304, content type = [verification disabled], header text fragment = [verification disabled], recorded content size = 0
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {304}, null, null, null);		// Test [147] <- Index 147
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [148] <- WEB ADMIN Index 148 ---
		String requestProt0148 = "https";
		String requestHost0148 = "myportal.abb.com";
		int    requestPort0148 = 443;
		String requestFile0148 = "/theme/static/ver_2.1-20161215_124256/themes/mcp/backbase-base.css";
		String requestHeader0148 = "GET " + requestFile0148 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: myportal.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0148, requestHost0148, requestPort0148, requestHeader0148, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0148 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 304, content type = [verification disabled], header text fragment = [verification disabled], recorded content size = 0
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {304}, null, null, null);		// Test [148] <- Index 148
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [149] <- WEB ADMIN Index 149 ---
		String requestProt0149 = "https";
		String requestHost0149 = "myportal.abb.com";
		int    requestPort0149 = 443;
		String requestFile0149 = "/static/ver_2.1-20161215_124256_1481963650440/mcp/resources/mcpRequireModulesBundle.i18n.en.js";
		String requestHeader0149 = "GET " + requestFile0149 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: myportal.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0149, requestHost0149, requestPort0149, requestHeader0149, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0149 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 304, content type = [verification disabled], header text fragment = [verification disabled], recorded content size = 0
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {304}, null, null, null);		// Test [149] <- Index 149
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [150] <- WEB ADMIN Index 150 ---
		String requestProt0150 = "https";
		String requestHost0150 = "myportal.abb.com";
		int    requestPort0150 = 443;
		String requestFile0150 = "/static/ver_2.1-20161215_124256/launchpad/lib/requirejs/noDup.js";
		String requestHeader0150 = "GET " + requestFile0150 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: myportal.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0150, requestHost0150, requestPort0150, requestHeader0150, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0150 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 304, content type = [verification disabled], header text fragment = [verification disabled], recorded content size = 0
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {304}, null, null, null);		// Test [150] <- Index 150
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [151] <- WEB ADMIN Index 151 ---
		String requestProt0151 = "https";
		String requestHost0151 = "myportal.abb.com";
		int    requestPort0151 = 443;
		String requestFile0151 = "/static/ver_2.1-20161215_124256/mcp/resources/mcpExternalLibsBundle.min.js";
		String requestHeader0151 = "GET " + requestFile0151 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: myportal.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0151, requestHost0151, requestPort0151, requestHeader0151, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0151 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 304, content type = [verification disabled], header text fragment = [verification disabled], recorded content size = 0
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {304}, null, null, null);		// Test [151] <- Index 151
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [152] <- WEB ADMIN Index 152 ---
		String requestProt0152 = "https";
		String requestHost0152 = "myportal.abb.com";
		int    requestPort0152 = 443;
		String requestFile0152 = "/theme/static/themes/mcp/css/abb/img/logo_new.png";
		String requestHeader0152 = "GET " + requestFile0152 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: myportal.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0152, requestHost0152, requestPort0152, requestHeader0152, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0152 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 304, content type = [verification disabled], header text fragment = [verification disabled], recorded content size = 0
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {304}, null, null, null);		// Test [152] <- Index 152
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [153] <- WEB ADMIN Index 153 ---
		String requestProt0153 = "https";
		String requestHost0153 = "myportal.abb.com";
		int    requestPort0153 = 443;
		String requestFile0153 = "/theme/static/ver_2.1-20161215_124256/themes/mcp/css/abb/img/loader_min.gif";
		String requestHeader0153 = "GET " + requestFile0153 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: myportal.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0153, requestHost0153, requestPort0153, requestHeader0153, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0153 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 304, content type = [verification disabled], header text fragment = [verification disabled], recorded content size = 0
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {304}, null, null, null);		// Test [153] <- Index 153
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated



		// all http requests of page #3_1 successful done
		return true;
	}


	/**
	 * Recorded http requests of page #3_2.
	 *
	 * @return  true:  method successful completed.
	 *          false: method/loop failed.
	 */
	boolean executePage_3_2(int totalLoopCounter, LoadtestPluginContext loopPluginContext, InnerLoopContext innerLoopContext, Object httpLogVectorObject) throws Exception
	{
		// ... continuing page #3 (fragment 3 of 3)
		// ----------------------------------------



		// --- HTTP REQUEST: Test [154] <- WEB ADMIN Index 154 ---
		String requestProt0154 = "https";
		String requestHost0154 = "myportal.abb.com";
		int    requestPort0154 = 443;
		String requestFile0154 = "/static/ver_2.1-20161215_124256_1481963650440_lang_en/mcp/widgets/mcp/welcome-page/mcp-welcome-page.html";
		String requestHeader0154 = "GET " + requestFile0154 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: myportal.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0154, requestHost0154, requestPort0154, requestHeader0154, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0154 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 304, content type = [verification disabled], header text fragment = [verification disabled], recorded content size = 0
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {304}, null, null, null);		// Test [154] <- Index 154
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [155] <- WEB ADMIN Index 155 ---
		String requestProt0155 = "https";
		String requestHost0155 = "myportal.abb.com";
		int    requestPort0155 = 443;
		String requestFile0155 = "/static/ver_2.1-20161215_124256/mcp/libs/external/angular-base/1_4_8/angular.min.js";
		String requestHeader0155 = "GET " + requestFile0155 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: myportal.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0155, requestHost0155, requestPort0155, requestHeader0155, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0155 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 304, content type = [verification disabled], header text fragment = [verification disabled], recorded content size = 0
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {304}, null, null, null);		// Test [155] <- Index 155
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [156] <- WEB ADMIN Index 156 ---
		String requestProt0156 = "https";
		String requestHost0156 = "myportal.abb.com";
		int    requestPort0156 = 443;
		String requestFile0156 = "/static/ver_2.1-20161215_124256/launchpad/lib/util.js";
		String requestHeader0156 = "GET " + requestFile0156 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: myportal.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0156, requestHost0156, requestPort0156, requestHeader0156, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0156 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 304, content type = [verification disabled], header text fragment = [verification disabled], recorded content size = 0
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {304}, null, null, null);		// Test [156] <- Index 156
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [157] <- WEB ADMIN Index 157 ---
		String requestProt0157 = "https";
		String requestHost0157 = "myportal.abb.com";
		int    requestPort0157 = 443;
		String requestFile0157 = "/static/ver_2.1-20161215_124256/launchpad/lib/responsive.js";
		String requestHeader0157 = "GET " + requestFile0157 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: myportal.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0157, requestHost0157, requestPort0157, requestHeader0157, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0157 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 304, content type = [verification disabled], header text fragment = [verification disabled], recorded content size = 0
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {304}, null, null, null);		// Test [157] <- Index 157
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [158] <- WEB ADMIN Index 158 ---
		String requestProt0158 = "https";
		String requestHost0158 = "www.google-analytics.com";
		int    requestPort0158 = 443;
		String requestFile0158 = "/analytics.js";
		String requestHeader0158 = "GET " + requestFile0158 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www.google-analytics.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0158, requestHost0158, requestPort0158, requestHeader0158, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0158 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 304, content type = [verification disabled], header text fragment = [verification disabled], recorded content size = 0
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {304}, null, null, null);		// Test [158] <- Index 158
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [159] <- WEB ADMIN Index 159 ---
		String requestProt0159 = "https";
		String requestHost0159 = "myportal.abb.com";
		int    requestPort0159 = 443;
		String requestFile0159 = "/mvc/resources/getWelcomeNonLoggedStaticResource" +
				"?resourceUrl=welcome/welcome-non-logged.html";
		String requestHeader0159 = "GET " + requestFile0159 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: myportal.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0159, requestHost0159, requestPort0159, requestHeader0159, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0159 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [160] <- WEB ADMIN Index 160 ---
		String requestProt0160 = "https";
		String requestHost0160 = "myportal.abb.com";
		int    requestPort0160 = 443;
		String requestFile0160 = "/static/mcp/widgets/mcp/welcome-page/css/img/slide1.png";
		String requestHeader0160 = "GET " + requestFile0160 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: myportal.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0160, requestHost0160, requestPort0160, requestHeader0160, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0160 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [161] <- WEB ADMIN Index 161 ---
		String requestProt0161 = "https";
		String requestHost0161 = "myportal.abb.com";
		int    requestPort0161 = 443;
		String requestFile0161 = "/static/mcp/widgets/mcp/welcome-page/css/img/slide2.png";
		String requestHeader0161 = "GET " + requestFile0161 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: myportal.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0161, requestHost0161, requestPort0161, requestHeader0161, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0161 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [162] <- WEB ADMIN Index 162 ---
		String requestProt0162 = "https";
		String requestHost0162 = "myportal.abb.com";
		int    requestPort0162 = 443;
		String requestFile0162 = "/static/mcp/widgets/mcp/welcome-page/css/img/slide3.png";
		String requestHeader0162 = "GET " + requestFile0162 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: myportal.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0162, requestHost0162, requestPort0162, requestHeader0162, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0162 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [163] <- WEB ADMIN Index 163 ---
		String requestProt0163 = "https";
		String requestHost0163 = "myportal.abb.com";
		int    requestPort0163 = 443;
		String requestFile0163 = "/static/mcp/widgets/mcp/welcome-page/css/img/slide4.png";
		String requestHeader0163 = "GET " + requestFile0163 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: myportal.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0163, requestHost0163, requestPort0163, requestHeader0163, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0163 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [164] <- WEB ADMIN Index 164 ---
		String requestProt0164 = "https";
		String requestHost0164 = "myportal.abb.com";
		int    requestPort0164 = 443;
		String requestFile0164 = "/dynaTraceMonitor";
		String requestContent0164 = 
				"$a=1%7C1%7C_load_%7C_load_%7C-%7C1482229093737%7C1482229096354%7C164%2C2%7C2%7Cg1.4.8%7Cxhr%7C-%7C1482229095616%7C1482229096117%7C164%7C-%7C-%7C%2Fmvc%2Fresources%2FgetWelcomeNonLoggedStaticResource%3FresourceUrl%3Dwelcome%2Fwelcome-non-logged.html%2C2%7C3%7C_onload_%7C_load_%7C-%7C1482229096335%7C1482229096354%7C164$v=63$fId=229094389_832$rId=RID_2038969605$rpId=2065704978$domR=1482229096332$w=1280$h=597$nt=a255b1482229093737c339d412e415f415g415h415i415k420l418m519n520o1188p1188q1346r2595s2598t2617$bw=7_464$url=https%3A%2F%2Fmyportal.abb.com%2Fwelcome-non-logged$title=Welcome%20Non-Logged$time=1482229096372";
		byte[] requestContentBinary0164 = requestContent0164.getBytes("UTF-8");
		String requestHeader0164 = "POST " + requestFile0164 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: myportal.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Content-Type: text/plain;charset=UTF-8\r\n" + 
				"Content-Length: " + requestContentBinary0164.length + "\r\n" + 		// Content-Length: 615
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0164, requestHost0164, requestPort0164, requestHeader0164, requestContentBinary0164, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		if (debugLoops)
		{
			if (Lib.isAsciiContent(testURL.getRequestContent(), 256))
				log(">>> " + new String(testURL.getRequestContent()));
			else
				log(">>> [binary data]");
		}

		testURL.execute(performanceData);
		requestHeader0164 = null;		// support garbage collector to reduce memory
		requestContent0164 = null;		// support garbage collector to reduce memory
		requestContentBinary0164 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/PLAIN", header text fragment = [verification disabled], recorded content size = 132
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/PLAIN", null, null);		// Test [164] <- Index 164
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [165] <- WEB ADMIN Index 165 ---
		String requestProt0165 = "https";
		String requestHost0165 = "myportal.abb.com";
		int    requestPort0165 = 443;
		String requestFile0165 = "/dynaTraceMonitor";
		String requestContent0165 = 
				"$bw=7_464$fId=229094389_832$v=63$url=https%3A%2F%2Fmyportal.abb.com%2Fwelcome-non-logged$title=Welcome%20Non-Logged$time=1482229098376";
		byte[] requestContentBinary0165 = requestContent0165.getBytes("UTF-8");
		String requestHeader0165 = "POST " + requestFile0165 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: myportal.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Content-Type: text/plain;charset=UTF-8\r\n" + 
				"Content-Length: " + requestContentBinary0165.length + "\r\n" + 		// Content-Length: 134
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0165, requestHost0165, requestPort0165, requestHeader0165, requestContentBinary0165, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		if (debugLoops)
		{
			if (Lib.isAsciiContent(testURL.getRequestContent(), 256))
				log(">>> " + new String(testURL.getRequestContent()));
			else
				log(">>> [binary data]");
		}

		testURL.execute(performanceData);
		requestHeader0165 = null;		// support garbage collector to reduce memory
		requestContent0165 = null;		// support garbage collector to reduce memory
		requestContentBinary0165 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/PLAIN", header text fragment = [verification disabled], recorded content size = 132
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/PLAIN", null, null);		// Test [165] <- Index 165
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [166] <- WEB ADMIN Index 166 ---
		String requestProt0166 = "https";
		String requestHost0166 = "myportal.abb.com";
		int    requestPort0166 = 443;
		String requestFile0166 = "/dynaTraceMonitor";
		String requestContent0166 = 
				requestFileCache.readFile("LoginLogoutSingapore_RequestContent0166.txt").getFileDataAsString("UTF-8");		// note: consider duplicated definition of this file name near end of the load test program - used for ZIP-dialogue in Project Navigator
		byte[] requestContentBinary0166 = requestContent0166.getBytes("UTF-8");
		String requestHeader0166 = "POST " + requestFile0166 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: myportal.abb.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Content-Type: text/plain;charset=UTF-8\r\n" + 
				"Content-Length: " + requestContentBinary0166.length + "\r\n" + 		// Content-Length: 5949
				"Connection: close\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0166, requestHost0166, requestPort0166, requestHeader0166, requestContentBinary0166, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setStoreMaxReceivedContentSize(131072);
		testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		if (debugLoops)
		{
			if (Lib.isAsciiContent(testURL.getRequestContent(), 256))
				log(">>> " + new String(testURL.getRequestContent()));
			else
				log(">>> [binary data]");
		}

		testURL.execute(performanceData);
		requestHeader0166 = null;		// support garbage collector to reduce memory
		requestContent0166 = null;		// support garbage collector to reduce memory
		requestContentBinary0166 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/PLAIN", header text fragment = [verification disabled], recorded content size = 132
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/PLAIN", null, null);		// Test [166] <- Index 166
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated



		// all http requests of page #3_2 successful done
		return true;
	}


	/**
	 * Recorded http requests of page #4.
	 *
	 * @return  true:  method successful completed.
	 *          false: method/loop failed.
	 */
	boolean executePage_4(int totalLoopCounter, LoadtestPluginContext loopPluginContext, InnerLoopContext innerLoopContext, Object httpLogVectorObject) throws Exception
	{

		// all http requests of page #4 successful done
		return true;
	}



	boolean synchResponsesParallelRequestsPage_1(int totalLoopCounter, LoadtestPluginContext loopPluginContext, InnerLoopContext innerLoopContext, Object httpLogVectorObject) throws Exception
	{
		int lastThreadStepInMainThread = threadStep;		// save last executed thread step
		
		// wait for the response of all parallel requests
		threadStep = pageThreadHandler.getLastThreadStep();
		pageThreadHandler.waitForSynch();
		log("Page 1 Time = " + pageThreadHandler.getPageTime() + " ms");
		
		
		threadStep = pageThreadHandler.getFirstThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 7837
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, null);		// Test [9] <- Index 9
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/X-JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 22346
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/X-JAVASCRIPT", null, null);		// Test [10] <- Index 10
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 312
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, null);		// Test [11] <- Index 11
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/X-JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 37800
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/X-JAVASCRIPT", null, null);		// Test [12] <- Index 12
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/X-JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 26951
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/X-JAVASCRIPT", null, null);		// Test [13] <- Index 13
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		if (!writeHttpAsyncResponseTabOutput_1(loopPluginContext,lastThreadStepInMainThread))
			return false;
		
		// all done
		threadStep = lastThreadStepInMainThread;		// restore last executed thread step
		return true;		// end of asynch response checks for this page
	}
	
	
	private boolean writeHttpAsyncResponseTabOutput_1 (LoadtestPluginContext loopPluginContext, int lastThreadStepInMainThread ) throws Exception
	{
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/X-JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 3005
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/X-JAVASCRIPT", null, null);		// Test [14] <- Index 14
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/FONT-WOFF", header text fragment = [verification disabled], recorded content size = 38624
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/FONT-WOFF", null, null);		// Test [15] <- Index 15
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 510417
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, null);		// Test [17] <- Index 17
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/FONT-WOFF", header text fragment = [verification disabled], recorded content size = 37436
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/FONT-WOFF", null, null);		// Test [18] <- Index 18
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 497
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, null);		// Test [19] <- Index 19
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		return true;		// end of asynch response checks for this page
	}



	boolean synchResponsesParallelRequestsPage_2(int totalLoopCounter, LoadtestPluginContext loopPluginContext, InnerLoopContext innerLoopContext, Object httpLogVectorObject) throws Exception
	{
		int lastThreadStepInMainThread = threadStep;		// save last executed thread step
		
		// wait for the response of all parallel requests
		threadStep = pageThreadHandler.getLastThreadStep();
		pageThreadHandler.waitForSynch();
		log("Page 2 Time = " + pageThreadHandler.getPageTime() + " ms");
		
		
		threadStep = pageThreadHandler.getFirstThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 24985
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/JAVASCRIPT", null, null);		// Test [35] <- Index 35
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 302, content type = [verification disabled], header text fragment = [verification disabled], recorded content size = 0
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {302}, null, null, null);		// Test [37] <- Index 37
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 23446
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, null);		// Test [38] <- Index 38
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 172495
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/JAVASCRIPT", null, null);		// Test [40] <- Index 40
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 1450
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, null);		// Test [41] <- Index 41
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 18056
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/JAVASCRIPT", null, null);		// Test [42] <- Index 42
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 36520
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, null);		// Test [43] <- Index 43
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 14639
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, null);		// Test [44] <- Index 44
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 35006
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, null);		// Test [45] <- Index 45
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 633
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [46] <- Index 46
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 70587
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/JAVASCRIPT", null, null);		// Test [47] <- Index 47
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 52569
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/JAVASCRIPT", null, null);		// Test [48] <- Index 48
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 262857
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/JAVASCRIPT", null, null);		// Test [49] <- Index 49
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 796
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/JAVASCRIPT", null, null);		// Test [50] <- Index 50
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 218647
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/JAVASCRIPT", null, null);		// Test [51] <- Index 51
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 865
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, null);		// Test [52] <- Index 52
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/GIF", header text fragment = [verification disabled], recorded content size = 1358
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/GIF", null, null);		// Test [53] <- Index 53
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 714
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, null);		// Test [54] <- Index 54
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/GIF", header text fragment = [verification disabled], recorded content size = 1347
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/GIF", null, null);		// Test [55] <- Index 55
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/GIF", header text fragment = [verification disabled], recorded content size = 3257
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/GIF", null, null);		// Test [56] <- Index 56
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = [verification disabled], header text fragment = [verification disabled], recorded content size = 69564
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, null, null, null);		// Test [57] <- Index 57
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = [verification disabled], header text fragment = [verification disabled], recorded content size = 15029
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, null, null, null);		// Test [58] <- Index 58
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = [verification disabled], header text fragment = [verification disabled], recorded content size = 23292
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, null, null, null);		// Test [59] <- Index 59
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 655
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, null);		// Test [60] <- Index 60
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 1162
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, null);		// Test [61] <- Index 61
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 1571
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, null);		// Test [62] <- Index 62
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 1552
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, null);		// Test [63] <- Index 63
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 1861
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, null);		// Test [64] <- Index 64
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 1169
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, null);		// Test [65] <- Index 65
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 1518
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, null);		// Test [66] <- Index 66
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 1913
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, null);		// Test [67] <- Index 67
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 2012
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, null);		// Test [68] <- Index 68
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 1440
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, null);		// Test [69] <- Index 69
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 1033
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, null);		// Test [70] <- Index 70
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		if (!writeHttpAsyncResponseTabOutput_2(loopPluginContext,lastThreadStepInMainThread))
			return false;
		
		// all done
		threadStep = lastThreadStepInMainThread;		// restore last executed thread step
		return true;		// end of asynch response checks for this page
	}
	
	
	private boolean writeHttpAsyncResponseTabOutput_2 (LoadtestPluginContext loopPluginContext, int lastThreadStepInMainThread ) throws Exception
	{
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 457
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, null);		// Test [71] <- Index 71
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 1587
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, null);		// Test [72] <- Index 72
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 1245
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, null);		// Test [73] <- Index 73
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 551
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, null);		// Test [74] <- Index 74
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 1149
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, null);		// Test [75] <- Index 75
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 1015
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, null);		// Test [76] <- Index 76
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 109609
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/JAVASCRIPT", null, null);		// Test [78] <- Index 78
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/GIF", header text fragment = [verification disabled], recorded content size = 35
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/GIF", null, null);		// Test [79] <- Index 79
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 62357
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/JAVASCRIPT", null, null);		// Test [80] <- Index 80
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 2984
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/JAVASCRIPT", null, null);		// Test [81] <- Index 81
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 2306
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/JAVASCRIPT", null, null);		// Test [82] <- Index 82
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JSON", header text fragment = [verification disabled], recorded content size = 491
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JSON", null, null);		// Test [83] <- Index 83
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 2707
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, null);		// Test [84] <- Index 84
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/GIF", header text fragment = [verification disabled], recorded content size = 3107
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/GIF", null, null);		// Test [85] <- Index 85
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 2333
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/JAVASCRIPT", null, null);		// Test [86] <- Index 86
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 401, content type = [verification disabled], header text fragment = [verification disabled], recorded content size = 562
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {401}, null, null, null);		// Test [87] <- Index 87
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 421
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, null);		// Test [88] <- Index 88
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 4945
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, null);		// Test [89] <- Index 89
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JSON", header text fragment = [verification disabled], recorded content size = 2622
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JSON", null, null);		// Test [90] <- Index 90
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 104
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, null);		// Test [91] <- Index 91
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 499
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, null);		// Test [92] <- Index 92
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 580
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, null);		// Test [93] <- Index 93
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 585
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, null);		// Test [94] <- Index 94
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JSON", header text fragment = [verification disabled], recorded content size = 52
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JSON", null, null);		// Test [95] <- Index 95
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JSON", header text fragment = [verification disabled], recorded content size = 69
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JSON", null, null);		// Test [96] <- Index 96
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JSON", header text fragment = [verification disabled], recorded content size = 428
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JSON", null, null);		// Test [97] <- Index 97
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 737
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, null);		// Test [98] <- Index 98
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JSON", header text fragment = [verification disabled], recorded content size = 69
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JSON", null, null);		// Test [99] <- Index 99
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 557
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, null);		// Test [100] <- Index 100
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/BMP", header text fragment = [verification disabled], recorded content size = 10306
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/BMP", null, null);		// Test [101] <- Index 101
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/BMP", header text fragment = [verification disabled], recorded content size = 30786
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/BMP", null, null);		// Test [105] <- Index 105
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/BMP", header text fragment = [verification disabled], recorded content size = 102466
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/BMP", null, null);		// Test [106] <- Index 106
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/BMP", header text fragment = [verification disabled], recorded content size = 307266
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/BMP", null, null);		// Test [107] <- Index 107
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/BMP", header text fragment = [verification disabled], recorded content size = 1024066
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/BMP", null, null);		// Test [108] <- Index 108
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = [verification disabled], header text fragment = [verification disabled], recorded content size = 759
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, null, null, null);		// Test [109] <- Index 109
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		return true;		// end of asynch response checks for this page
	}



	boolean synchResponsesParallelRequestsPage_3(int totalLoopCounter, LoadtestPluginContext loopPluginContext, InnerLoopContext innerLoopContext, Object httpLogVectorObject) throws Exception
	{
		int lastThreadStepInMainThread = threadStep;		// save last executed thread step
		
		// wait for the response of all parallel requests
		threadStep = pageThreadHandler.getLastThreadStep();
		pageThreadHandler.waitForSynch();
		log("Page 3 Time = " + pageThreadHandler.getPageTime() + " ms");
		
		
		threadStep = pageThreadHandler.getFirstThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 301, content type = [verification disabled], header text fragment = [verification disabled], recorded content size = 168
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {301}, null, null, null);		// Test [119] <- Index 119
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 302, content type = [verification disabled], header text fragment = [verification disabled], recorded content size = 159
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {302}, null, null, null);		// Test [120] <- Index 120
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 6298
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, null);		// Test [121] <- Index 121
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 8019
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, null);		// Test [122] <- Index 122
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 3640
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, null);		// Test [123] <- Index 123
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 335612
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/JAVASCRIPT", null, null);		// Test [124] <- Index 124
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 1289686
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/JAVASCRIPT", null, null);		// Test [125] <- Index 125
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 315280
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, null);		// Test [126] <- Index 126
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 33343
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, null);		// Test [127] <- Index 127
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/GIF", header text fragment = [verification disabled], recorded content size = 996
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/GIF", null, null);		// Test [129] <- Index 129
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 685
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, null);		// Test [130] <- Index 130
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		if (!writeHttpAsyncResponseTabOutput_3(loopPluginContext,lastThreadStepInMainThread))
			return false;
		
		// all done
		threadStep = lastThreadStepInMainThread;		// restore last executed thread step
		return true;		// end of asynch response checks for this page
	}
	
	
	private boolean writeHttpAsyncResponseTabOutput_3 (LoadtestPluginContext loopPluginContext, int lastThreadStepInMainThread ) throws Exception
	{
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 806
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, null);		// Test [131] <- Index 131
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 2722
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, null);		// Test [132] <- Index 132
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 2588
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, null);		// Test [133] <- Index 133
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/GIF", header text fragment = [verification disabled], recorded content size = 644
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/GIF", null, null);		// Test [134] <- Index 134
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 302, content type = [verification disabled], header text fragment = [verification disabled], recorded content size = 0
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {302}, null, null, null);		// Test [137] <- Index 137
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 7870
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, null);		// Test [138] <- Index 138
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 586
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [141] <- Index 141
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 1331
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, null);		// Test [159] <- Index 159
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 116137
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, null);		// Test [160] <- Index 160
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 69721
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, null);		// Test [161] <- Index 161
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 108184
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, null);		// Test [162] <- Index 162
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 87147
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, null);		// Test [163] <- Index 163
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		return true;		// end of asynch response checks for this page
	}



	boolean synchResponsesParallelRequestsPage_4(int totalLoopCounter, LoadtestPluginContext loopPluginContext, InnerLoopContext innerLoopContext, Object httpLogVectorObject) throws Exception
	{
		int lastThreadStepInMainThread = threadStep;		// save last executed thread step
		
		// wait for the response of all parallel requests
		threadStep = pageThreadHandler.getLastThreadStep();
		pageThreadHandler.waitForSynch();
		log("Page 4 Time = " + pageThreadHandler.getPageTime() + " ms");
		
		if (!writeHttpAsyncResponseTabOutput_4(loopPluginContext,lastThreadStepInMainThread))
			return false;
		
		// all done
		threadStep = lastThreadStepInMainThread;		// restore last executed thread step
		return true;		// end of asynch response checks for this page
	}
	
	
	private boolean writeHttpAsyncResponseTabOutput_4 (LoadtestPluginContext loopPluginContext, int lastThreadStepInMainThread ) throws Exception
	{
		return true;		// end of asynch response checks for this page
	}



	/**
	 * implement GetRealTimeUserInputFieldsInterface: get the definition and the value of all real-time user input fields.
	 */
	public ArrayList<RealTimeUserInputField> getRealTimeUserInputFields()
	{
		try
		{
			ArrayList<RealTimeUserInputField> realTimeUserInputFieldList = new ArrayList<RealTimeUserInputField>();
			return realTimeUserInputFieldList;
		}
		catch (Exception e)
		{
			log(e);
			return null;
		}
	}



	/**
	 * implement ThreadStepInterface: get the current execution step (current URL call or page break) of a simulated user.
	 */
	public int getExecutionStep()
	{
		return threadStep;
	}



	/**
	 * implement SetThreadStepInterface: set the current execution step (current URL call or page break) of a simulated user.
	 */
	public void setExecutionStep(int threadStep)
	{
		this.threadStep = threadStep;
	}



	/**
	 * implement SSLSessionCacheStatisticInterface: get statistic data about the SSL session cache behavior of a simulated user.
	 */
	public SSLSessionCacheStatistic getSSLSessionCacheStatistic()
	{
		return sslStatistic;
	}



	/**
	 * implement VaryingTestDurationInterface: support to extend or to reduce the planned test duration.
	 */
	public int getPlannedTestDuration()
	{
		return plannedTestDuration;
	}
	
	public void setExtendTestDuration(int deltaSeconds)
	{
		if (plannedTestDuration == 0)
		{
			plannedTestDuration = deltaSeconds;		// the old planned test duration was unlimited but is now limited
			return;
		}
		if (deltaSeconds == 0)
		{
			plannedTestDuration = 0;		// the new planned test duration is now unlimited
			return;
		}
		plannedTestDuration = plannedTestDuration + deltaSeconds;
	}



	/**
	 * implement SuspendResumeInterface: support to suspend and to resume the test execution.
	 */
	public int getPlannedStartupDelay()
	{
		return plannedStartupDelay;
	}
	
	public void setUserResumeStartWaitDelay(int millis)
	{
		userResumeStartWaitDelay = millis;
	}



	/**
	 * implement VaryingLoadInterface: support to decrement the number of simulated users at runtime.
	 */
	public void setDecrementEndOfLoopFlag(boolean decrementEndOfLoopFlag)
	{
		this.decrementEndOfLoopFlag = decrementEndOfLoopFlag;
	}

	public boolean isDecrementEndOfLoopFlag()
	{
		return decrementEndOfLoopFlag;
	}



	/**
	 * internal method: execute the loops for one simulated user as a thread.
	 * controls the thread and displays the (thread-)log if one loop has been completed.
	 */
	public void run()
	{
		// user terminated by inline script, at start of user ?
		if (isTerminateUser())
		{
			System.out.println("# --- thread " + Thread.currentThread().getName() + " aborted --- " + ZoneTime.dateToShortString() + " ---");
			return;
		}
		try
		{
			while (true)
			{
				threadStep = ThreadStepInterface.THREAD_NO_STEP;
				clearLog();
				
				// execute loop
				log("--- loop started --- " + ZoneTime.dateToShortString() + " ---");
				boolean loopPassed = this.execute(totalLoopCounter.getAndIncrement());
				performanceData.addUserTransactionMeasuredSamples(transactionHandler.getPendingTransactions());
				performanceData.addUserTransactionNotExecutedSamples(transactionHandler.getNotExecutedTransactions());
				transactionHandler.resetTransactions();
				performanceData.addSocktPoolStatistic(socketPool);
				socketPool.closePool();
				performanceData.addSSLCacheStatistic(sslStatistic.getSSLSessionCacheStatisticResult());
				sslStatistic.reset();
				
				// eof of input file ?
				if (abortedByEofInputFile())
					return;		// endOfRun() not called in such a case
				
				// check loop result
				String remainingLoopInfo = "";
				if (checkLoopCount)
					remainingLoopInfo = " [remaining loops = " + (remainingLoops - 1) + "]";
				if (loopPassed)
				{
					performanceData.addPassedLoop();
					log("--- loop passed ---  " + ZoneTime.dateToShortString() + " ---" + remainingLoopInfo);
				}
				else
				{
					performanceData.addFailedLoop();
					log("--- loop failed ---  " + ZoneTime.dateToShortString() + " ---" + remainingLoopInfo);
				}
				threadStep = ThreadStepInterface.THREAD_NO_STEP;
				
				// display thread log to standard output
				if (debugLoops || (debugFailedLoops && (!loopPassed)))
				{
					synchronized (dumpLock)
					{
						dumpLog(System.out);				// full log
					}
				}
				
				// check if max loops reached
				if (checkLoopCount)
				{
					// all done ?
					remainingLoops--;
					if (remainingLoops <= 0)
					{
						endOfRun();
						return;
					}
				}
				
				// check if simulated user must be decremented
				if (decrementEndOfLoopFlag)
				{
					endOfRun();
					decrementEndOfLoopFlag = false; // reset flag for further use
					return;
				}
				
				// check if max test duration reached
				if ((plannedTestDuration > 0) && (((System.currentTimeMillis() - testDurationStart) / 1000) >= plannedTestDuration))
				{
					endOfRun();
					return;
				}
				
				// check if this specific user is terminated earlier than planned by a HTTP content verification or by a plug-in
				if (isTerminateUser())
				{
					endOfRun();
					System.out.println("# --- thread " + Thread.currentThread().getName() + " terminate failed user --- " + ZoneTime.dateToShortString() + " ---");
					return;
				}
				
				// check if load test execution is temporary suspended
				boolean wasSuspended = false;
				while (isSuspend())
				{
					wasSuspended = true;
					try { Thread.currentThread().sleep(20); } catch (InterruptedException ie) {}
					if (abortedByRemote() || abortedByEofInputFile())
					{
						endOfRun();
						return;
					}
					
					// check if max test duration reached during suspend
					if ((plannedTestDuration > 0) && (((System.currentTimeMillis() - testDurationStart) / 1000) >= plannedTestDuration))
					{
						endOfRun();
						return;
					}
				}
				// check if load test execution is resumed
				if (wasSuspended)
				{
					try { sleepRemoteInterruptable(userResumeStartWaitDelay); } catch (InterruptedException ie) {}
				}
				
				// wait 20 milliseconds if loop has failed
				if (!loopPassed)
					try { Thread.currentThread().sleep(loopErrorDelay); } catch (InterruptedException ie) {}
				
				// execute next loop
				threadLoopCounter++;
			}	// end: while (true)
		}
		catch (Throwable tex)
		{
			log("*** INTERNAL ERROR / LOAD TEST ABORTED ***");
			log(tex);
			log();
			synchronized (dumpLock)
			{
				dumpLog(System.out);				// full log
				System.err.println("*** INTERNAL ERROR / LOAD TEST ABORTED ***");
				tex.printStackTrace(System.err);
				System.exit(-2);
			}
		}
		finally
		{
			// remove the reference to this load test instance and the reference to the thread that runs this instance
			try
			{
				getUserContextTable().getWriteLock().lock();
				getOwnLoadTestUserContext().setLoadTestUserFinallyEnded();
				getUserContextTable().getWriteLock().unlock();
			}
			catch (Throwable texFinal)
			{
				System.err.println("*** INTERNAL FINALLY ERROR / LOAD TEST ABORTED ***");
				texFinal.printStackTrace(System.err);
				System.exit(-2);
			}
		}
	}



	/**
	 * internal method: called when a user has completed the test-run.
	 */
	public void endOfRun()
	{
		clearLog();
		
		if (debugLoops && (getLog().size() > 0))
		{
			synchronized (dumpLock)
			{
				dumpLog(System.out);		// dump log of inline scripts and load test plug-ins which are executed at end of user
			}
		}
	}



	/**
	 * Main program. Starts the test and waits until all have been done.
	 */
	public static void main(String[] args)
	{
		// check command line argument -h or -help
		if ((ParseArgs.hasOption(args, "-h")) || (ParseArgs.hasOption(args, "-help")))
		{
			System.out.println();
			System.out.println("Help - Proxy Sniffer Load Test Program:");
			System.out.println();
			System.out.println("-u <number>              ->> required argument: number of concurrent users");
			System.out.println("-d <seconds>             ->> required argument: planned test duration in seconds (default: 30, 0 = unlimited)");
			System.out.println("-t <seconds>             ->> required argument: request timeout per url in seconds");
			System.out.println();
			System.out.println("-sdelay <milliseconds>   ->> startup delay time between concurrent users in milliseconds (default: 200)");
			System.out.println("-mtpu <number>           ->> maximum number of parallel threads per user (default: " + MAX_PARALLEL_THREADS_PER_USER + ")");
			System.out.println("-maxloops <number>       ->> maximum number of loops per user (default: 0 = unlimited)");
			System.out.println("-downlink <kbps>         ->> maximum downlink network bandwidth per user in kilobits per second (default: 0 = unlimited)");
			System.out.println("-uplink <kbps>           ->> maximum uplink network bandwidth per user in kilobits per second (default: 0 = unlimited)");
			System.out.println("-multihomed <filename>   ->> use serveral client ip addresses - file format: <addr1>, <addr2>, ... (all on the same line)");
			System.out.println("-sampling <seconds>      ->> statistic sampling interval in seconds (default: 15)");
			System.out.println("-percpage <percent>      ->> additional sampling rate per web page call in percent (default: 100)");
			System.out.println("-percurl <percent>       ->> additional sampling rate per url call in percent (default: 0)");
			System.out.println("-percurlopt <level>      ->> extended sampling level per url call, see application reference manual (default: 0 = disabled)");
			System.out.println("-maxerrsnap <number>     ->> maximum number of error snapshots per url (default: 0 = unlimited)");
			System.out.println("-maxerrmem <megabytes>   ->> maximum size of memory in megabytes which can be used for error snapshots (default: 20, -1 = unlimited)");
			System.out.println("-nosdelayCluster         ->> apply startup delay time between concurrent users per exec agent, but not per cluster job (default: apply per cluster job)");
			System.out.println("-setuseragent \"<text>\"   ->> replace the recorded value of the HTTP request header field User-Agent with a new value");
			System.out.println("-collect <host>[:<port>] ->> collect additional data from external measuring agents (data collectors)");
			System.out.println("-res <filename>          ->> overrides the default name of the binary output file");
			System.out.println("-nores                   ->> disables to create the binary output file");
			System.out.println();
			System.out.println("-ssl <version>           ->> set SSL version: possible options are \"all\" (default), \"v3\", \"tls\", \"tls11\" or \"tls12\"");
			System.out.println("-sslcache <seconds>      ->> timeout of user-related SSL session cache (default: 300, 0 = cache disabled)");
			System.out.println("-sslrandom <type>        ->> set the type of the random generator used for SSL handshakes: possible options are \"fast\", \"iaik\" (default) or \"java\"");
			System.out.println("-sslcmode                ->> apply SSL/HTTPS compatibility workarounds for deficient SSL servers");
			System.out.println("-ecc                     ->> enable support of elliptic curve cryptography (ECC)");
			System.out.println("-nosni                   ->> disable support of server name indication (SNI)");
			System.out.println("-snicritical             ->> set the TLS SNI extension as critical (default: non-critical)");
			System.out.println();
			System.out.println("-dnssrv <IP-1>[,IP-N])   ->> use specific DNS server(s) to resolve DNS host names (default: use OS to resolve host names)");
			System.out.println("-dnshosts <filename>     ->> use specific DNS hosts file (default: use OS to resolve host names)");
			System.out.println("-dnstranslation <filename> ->> use a DNS translation file that converts DNS names. It might be needed to disable TLS SNI if this option is used");
			System.out.println("-dnsenattl               ->> enable consideration of DNS TTL by using the received TTL-values from the DNS Server(s) (default: TTL disabled)");
			System.out.println("-dnsfixttl <seconds>     ->> enable DNS TTL by using a fixed TTL-value of seconds for all DNS resolves");
			System.out.println("-dnsperloop              ->> perform new DNS resolves for each executed loop. All resolves are stable within the same loop (no consideration of DNS TTL within a loop)");
			System.out.println("-dnsstatistic            ->> collect statistical data about DNS resolutions. Note: use this option only if not any other, more specific DNS option is enabled");
			System.out.println("-dnsdebug                ->> debug DNS resolves and the DNS cache");
			System.out.println();
			System.out.println("-dfl                     ->> debug execution steps of all failed loops to standard output");
			System.out.println("-dl                      ->> debug execution steps of all loops to standard output");
			System.out.println("-dh                      ->> debug HTTP protocol headers to standard output, includes the -dl option");
			System.out.println("-dc                      ->> debug HTTP content data to standard output, includes the -dl option");
			System.out.println("-dhc                     ->> debug HTTP protocol headers and HTTP content data to standard output, includes the -dl option");
			System.out.println("-dC                      ->> debug cookies to standard output, includes the -dl option");
			System.out.println("-dK                      ->> debug keep-alive (socket pool) to standard output, includes the -dl option");
			System.out.println("-dssl                    ->> debug SSL handshake (https) to standard output, includes the -dl and the -dK option");
			System.out.println();
			System.out.println("-tz <timezone>           ->> set time zone (see Application Reference Manual: supported time zones)");
			System.out.println("-dgs a|c                 ->> set number format (decimal group separator) a = '  c = ,");
			System.out.println("-annotation <text>       ->> adds an annotation for this test run");
			System.out.println();
			System.out.println("-execAgentHost <ip address or dns name>      ->> set the ip address or the dns name of the exec agent from which the license is used (default: 127.0.0.1)");
			System.out.println("-execAgentPort <port>                        ->> set the tcp/ip port of the exec agent (default: 7993)");
			System.out.println("-execAgentProtocol <plain | http | https>    ->> set the protocol of the exec agent (default: plain)");
			System.out.println("-execAgentUsername <string>                  ->> set the auth. username for the exec agent (default: [no username])");
			System.out.println("-execAgentPassword <string>                  ->> set the auth. password for the exec agent (default: [no password])");
			System.out.println();
			System.out.println("-h                       ->> display this help text");
			System.out.println("-help                    ->> display this help text");
			System.out.println();
			System.exit(-1);
		}
		
		System.out.println("+----------------------------------------------------------------+");
		System.out.println("| Welcome to the ZebraTester Load Test Program.                  |");
		System.out.println("| Additional help available with program argument \"-help\"        |");
		System.out.println("| Procedure Copyright by Ingenieurbuero David Fischer AG,        |");
		System.out.println("| a company of the Apica group. All rights reserved.             |");
		System.out.println("+----------------------------------------------------------------+");
		
		
		System.out.println();
		System.out.println("*** Warning: Loadtest over HTTP(S) Proxy ***");
		
		
		System.out.println();
		System.out.println("*** Warning: Url content test disabled ***");
		
		// check command line argument -ecc
		sslECC = (ParseArgs.hasOption(args, "-ecc"));       // enable ssl ecc ?
		
		// initialize ssl/https support
		SSLInit.execute();
		if (sslECC)
			SSLInit.enableECC();
		
		// check command line argument -nosni
		if (ParseArgs.hasOption(args, "-nosni"))            // disable ssl sni ?
			sslSNI = false;
		
		// check command line argument -snicritical
		if (ParseArgs.hasOption(args, "-snicritical"))      // set ssl sni as critical tls extension ?
			sslSNICirical = true;
		
		// set default character set for response content tests
		setCharEncoding(prxCharEncoding);
		
		// check command line argument -tz <timezone>
		String timeZoneString = ParseArgs.getString(args, "-tz");
		if (timeZoneString != null)
			defaultTimeZone = timeZoneString.toUpperCase(); // set time zone?
		ZoneTime.setDefaultTimeZone(defaultTimeZone);
		
		// check command line argument -dgs a|c
		String dgs = ParseArgs.getString(args, "-dgs");
		if (dgs != null)
		{
			if (dgs.equalsIgnoreCase("a"))
				defaultNumberGroupingSeparator = '\'';
			if (dgs.equalsIgnoreCase("c"))
				defaultNumberGroupingSeparator = ',';
		}
		Lib.setDefaultNumberGroupingSeparator(defaultNumberGroupingSeparator);
		
		// check command line argument -annotation <text>
		String testRunAnnotation = ParseArgs.getString(args, "-annotation");
		if (testRunAnnotation != null)
		{
			if (testRunAnnotation.startsWith("\"") && testRunAnnotation.endsWith("\""))
				testRunAnnotation = testRunAnnotation.substring(1, testRunAnnotation.length() - 1);
		}
		
		// check command line argument -ssl
		String newSslProtocolVersion = ParseArgs.getString(args, "-ssl");
		if (newSslProtocolVersion != null)
		{
			if (newSslProtocolVersion.equalsIgnoreCase("v2"))
				sslProtocolVersion = "v2";
			if (newSslProtocolVersion.equalsIgnoreCase("v3"))
				sslProtocolVersion = "v3";
			if (newSslProtocolVersion.equalsIgnoreCase("tls"))
				sslProtocolVersion = "tls";
			if (newSslProtocolVersion.equalsIgnoreCase("tls11"))
				sslProtocolVersion = "tls11";
			if (newSslProtocolVersion.equalsIgnoreCase("tls12"))
				sslProtocolVersion = "tls12";
		}
		
		// check command line argument -sslcache <seconds>
		Integer newSslSessionCacheTimeout = ParseArgs.getInteger(args, "-sslcache");
		if (newSslSessionCacheTimeout != null)
			sslSessionCacheTimeout = newSslSessionCacheTimeout.intValue();
		
		// check command line argument -sslrandom
		String sslHandshakeRandomGeneratorTypeStr = ParseArgs.getString(args, "-sslrandom");
		if (sslHandshakeRandomGeneratorTypeStr != null)
		{
			if (sslHandshakeRandomGeneratorTypeStr.equalsIgnoreCase("java"))
				sslHandshakeRandomGeneratorType = HttpSocketPool.SSL_HANDSHAKE_RANDOM_GENERATOR_TYPE_JAVA_DEFAULT;
			if (sslHandshakeRandomGeneratorTypeStr.equalsIgnoreCase("iaik"))
				sslHandshakeRandomGeneratorType = HttpSocketPool.SSL_HANDSHAKE_RANDOM_GENERATOR_TYPE_IAIK_DEFAULT;
			if (sslHandshakeRandomGeneratorTypeStr.equalsIgnoreCase("fast"))
				sslHandshakeRandomGeneratorType = HttpSocketPool.SSL_HANDSHAKE_RANDOM_GENERATOR_TYPE_FAST;
		}
		
		// check command line argument -sslcmode
		sslcmode = ParseArgs.hasOption(args, "-sslcmode");  // enable ssl/https compatibility workarounds?
		
		// check command line argument -dfl
		debugFailedLoops = ParseArgs.hasOption(args, "-dfl"); // debug failed loops?
		
		// check command line argument -dl
		debugLoops = ParseArgs.hasOption(args, "-dl");      // debug loops?
		
		// check command line argument -dh
		debugHttp = ParseArgs.hasOption(args, "-dh");       // debug http?
		if (debugHttp)
			debugLoops = true;
		
		// check command line argument -dc
		debugContent = ParseArgs.hasOption(args, "-dc");    // debug content?
		if (debugContent)
			debugLoops = true;
		
		// check command line argument -dhc
		if (ParseArgs.hasOption(args, "-dhc"))				// debug http and content
		{
			debugLoops = true;
			debugHttp = true;
			debugContent = true;
		}
		
		// check command line argument -dC
		debugCookies = ParseArgs.hasOption(args, "-dC");    // debug cookies?
		if (debugCookies)
			debugLoops = true;
		
		// check command line argument -dK
		debugKeepAlive = ParseArgs.hasOption(args, "-dK");  // debug keep.alive (socket pool)?
		if (debugKeepAlive)
			debugLoops = true;
		
		// check command line argument -dssl
		debugSsl = ParseArgs.hasOption(args, "-dssl");      // debug keep.alive (socket pool)?
		if (debugSsl)
		{
			debugLoops = true;
			debugKeepAlive = true;
		}
		
		// get startup delay
		Integer newStartupDelay = ParseArgs.getInteger(args, "-sdelay");
		if (newStartupDelay != null)
			plannedStartupDelay = newStartupDelay.intValue();
		
		// get max. parallel threads per user - note: only valid if CONTAINS_PARALLEL_EXECUTED_URLS = true
		Integer newMaxParallelThreadsPerUser = ParseArgs.getInteger(args, "-mtpu");
		if (newMaxParallelThreadsPerUser != null)
		{
			if (newMaxParallelThreadsPerUser.intValue() > 0)
				maxParallelThreadsPerUser = newMaxParallelThreadsPerUser.intValue();
		}
		// get maximum number of loops per user
		maxPlannedLoops = 0;  // maximum loops per user, 0 = unlimited
		Integer newLoops = ParseArgs.getInteger(args, "-maxloops");
		if (newLoops != null)
			maxPlannedLoops = newLoops.intValue();
		
		// get maximum downlink network bandwidth per user (default = unlimited)
		Integer newDownlinkBandwidth = ParseArgs.getInteger(args, "-downlink");
		if (newDownlinkBandwidth != null)
			downlinkBandwidth = newDownlinkBandwidth.intValue();
		
		// get maximum uplink network bandwidth per user (default = unlimited)
		Integer newUplinkBandwidth = ParseArgs.getInteger(args, "-uplink");
		if (newUplinkBandwidth != null)
			uplinkBandwidth = newUplinkBandwidth.intValue();
		
		// use test-specific DNS hosts file (optional) ?
		String dnsHostsFile = ParseArgs.getIgnoreCaseString(args, "-dnshosts");
		if (dnsHostsFile != null)
		{
			try
			{
				dnsCache = new DNSCache(dnsHostsFile);
			}
			catch (IOException ie)
			{
				System.out.println("*** ERROR: unable to read DNS hosts file " + dnsHostsFile + " ***");
				System.out.println("*** Hint: you have to ZIP " + dnsHostsFile + " together with the compiled class of the load test program ***");
				ie.printStackTrace();
				System.exit(-1);
			}
		}
		
		// use test-specific DNS translation table (optional) ?
		String dnsTranslationTableFile = ParseArgs.getIgnoreCaseString(args, "-dnstranslation");
		if (dnsTranslationTableFile != null)
		{
			try
			{
				DNSTranslationTable dnsTranslationTable = new DNSTranslationTable(new File(dnsTranslationTableFile));
				if (dnsCache == null)
					dnsCache = new DNSCache();
				dnsCache.setDNSTranslationTable(dnsTranslationTable);
			}
			catch (IOException ie)
			{
				System.out.println("*** ERROR: unable to read DNS translation table file " + dnsTranslationTableFile + " ***");
				System.out.println("*** Hint: you have to ZIP " + dnsTranslationTableFile + " together with the compiled class of the load test program ***");
				ie.printStackTrace();
				System.exit(-1);
			}
		}
		
		// use test-specific DNS servers (optional) ?
		String dnsSrvStr = ParseArgs.getIgnoreCaseString(args, "-dnssrv");
		if (dnsSrvStr != null)
		{
			ArrayList<String> dnsSrvList = new ArrayList<String>();
			StringTokenizer dnsTok = new StringTokenizer(dnsSrvStr, ",;");
			while (dnsTok.hasMoreTokens())
				dnsSrvList.add(dnsTok.nextToken());
			if (dnsCache == null)
				dnsCache = new DNSCache(dnsSrvList);
			else
				dnsCache.setDnsServers(dnsSrvList);
		}
		
		// enable DNS TTL ?
		if (ParseArgs.hasOption(args, "-dnsenattl"))
		{
			if (dnsCache == null)
				dnsCache = new DNSCache();
			dnsCache.enableTTL();
		}
		
		// set fixed DNS TTL ?
		Integer dnsFixTTL = ParseArgs.getInteger(args, "-dnsfixttl");
		{
			if (dnsFixTTL != null)
			{
				if (dnsCache == null)
					dnsCache = new DNSCache();
				dnsCache.setFixedTTL(dnsFixTTL.intValue());
			}
		}
		
		// enable DNS resolves per loop ?
		if (ParseArgs.hasOption(args, "-dnsperloop"))
		{
			if (dnsCache == null)
				dnsCache = new DNSCache();
			dnsPerLoop = true;
		}
		
		// enable DNS statistic ?   // note: use this option only if not any other, more specific DNS option is enabled.
		if (ParseArgs.hasOption(args, "-dnsstatistic"))
		{
			if (dnsCache == null)
				dnsCache = new DNSCache();
		}
		
		// debug DNS resolver ?
		if (ParseArgs.hasOption(args, "-dnsdebug"))
		{
			if (dnsCache == null)
				dnsCache = new DNSCache();
			dnsCache.setDebugToStdout(true);
		}
		
		// get statistic sampling interval
		int samplingInterval = 15;  // statistic sampling interval in seconds
		Integer newSamplingInterval = ParseArgs.getInteger(args, "-sampling");
		if (newSamplingInterval != null)
			samplingInterval = newSamplingInterval.intValue();
		
		// get additional sampling rate per web page call
		int percentilePageSampling = 100;  // additional sampling rate per web page call in percent
		Integer newPercentilePageSampling = ParseArgs.getInteger(args, "-percpage");
		if (newPercentilePageSampling != null)
			percentilePageSampling = newPercentilePageSampling.intValue();
		
		// get additional sampling rate per url call
		int percentileUrlSampling = 0;  // additional sampling rate per url call in percent
		Integer newPercentileUrlSampling = ParseArgs.getInteger(args, "-percurl");
		if (newPercentileUrlSampling != null)
			percentileUrlSampling = newPercentileUrlSampling.intValue();
		
		// get extended sampling level per url call
		int percentileUrlSamplingAddOption = 0;  // extended sampling level per url call, 0 = disabled
		Integer newPercentileUrlSamplingAddOption = ParseArgs.getInteger(args, "-percurlopt");
		if (newPercentileUrlSamplingAddOption != null)
			percentileUrlSamplingAddOption = newPercentileUrlSamplingAddOption.intValue();
		
		// get maximum number of error snapshots per URL (0 = unlimited)
		int maxErrorSnapshots = 0;
		Integer newMaxErrorSnapshots = ParseArgs.getInteger(args, "-maxerrsnap");
		if (newMaxErrorSnapshots != null)
			maxErrorSnapshots = newMaxErrorSnapshots.intValue();
		
		// get maximum memory in megabytes which can be used for error snapshots (-1 = unlimited, default = 10)
		long maxErrorSnapshotMemory = 20;
		Long newMaxErrorSnapshotMemory = ParseArgs.getLong(args, "-maxerrmem");
		if (newMaxErrorSnapshotMemory != null)
			maxErrorSnapshotMemory = newMaxErrorSnapshotMemory.longValue();
		
		// single user mode ?
		boolean singleUserMode = ParseArgs.hasOption(args, "-singleuser");
		
		// override value for http user agent field ?
		String setUserAgentStr = ParseArgs.getIgnoreCaseString(args, "-setuseragent");
		if (setUserAgentStr != null)
		{
			USER_AGENT_1 = setUserAgentStr;
		}
		// get required input arguments
		int concurrentUsers = 0;     // number of concurrent users
		plannedRequestTimeout = 0;   // request timeout in seconds
		
		System.out.println();
		
		// parse -u argument or ask --> <number of concurrent users>
		Integer i = ParseArgs.getIntegerOrAsk(args, "-u", "Concurrent Users, <RETURN>=1 : ", new Integer(1));
		if (i == null)
			System.exit(-1);
		else
			concurrentUsers = i.intValue();
		
		// parse -d argument or ask --> <test duration in seconds>
		i = ParseArgs.getIntegerOrAsk(args, "-d", "Test Duration in Seconds, <RETURN>=30 : ", new Integer(30));
		if (i == null)
			System.exit(-1);
		else
			plannedTestDuration = i.intValue();
		
		// parse -t argument or ask --> <request timeout in seconds>
		i = ParseArgs.getIntegerOrAsk(args, "-t", "HTTP Request Timeout per URL in Seconds, <RETURN>=60 : ", new Integer(60));
		if (i == null)
			System.exit(-1);
		else
			plannedRequestTimeout = i.intValue();
		
		String genericFileName = PerformanceData.proposeFileName("LoginLogoutSingapore", concurrentUsers);
		
		// auto-configure binary result file
		if (!ParseArgs.hasOption(args, "-nores"))
		{
			String newResultFile = ParseArgs.getString(args, "-res");
			if (newResultFile == null)
				resultFile = genericFileName + ".prxres";
			else
				resultFile = newResultFile;
			System.out.println("Result File : " + resultFile);
		}
		
		// initialize file cache for large XML, SOAP and ASCII requests
		try
		{
			requestFileCache.readFile(REQUEST_FILE_CACHE_FILE_1);		// LoginLogoutSingapore_RequestContent0112.txt
			requestFileCache.readFile(REQUEST_FILE_CACHE_FILE_2);		// LoginLogoutSingapore_RequestContent0166.txt
		}
		catch (IOException ie)
		{
			System.out.println("*** ERROR: UNABLE TO OPEN DATA FILE FOR LARGE ASCII OR XML REQUEST ***");
			ie.printStackTrace();
			System.exit(-2);
		}
		
		// display common arguments at console output
		System.out.println();
		System.out.println("# concurrent users = " + concurrentUsers);
		System.out.println("# max. parallel threads per user = " + maxParallelThreadsPerUser);
		System.out.print("# planned test duration = ");
		if (plannedTestDuration == 0)
			System.out.println("unlimited");
		else
			System.out.println("" + plannedTestDuration + " seconds");
		System.out.println("# http request timeout = " + plannedRequestTimeout + " seconds");
		System.out.println("# startup delay = " + plannedStartupDelay + " milliseconds");
		System.out.println("# statistic sampling interval = " + samplingInterval + " seconds");
		System.out.println("# additional sampling rate per web page call = " + percentilePageSampling + " %");
		System.out.println("# additional sampling rate per url call = " + percentileUrlSampling + " %");
		System.out.println("# extended sampling per url call = " + PerformanceDataTickExtension.extTypeToString(percentileUrlSamplingAddOption).toLowerCase());
		System.out.print("# max loops per user = ");
		if (maxPlannedLoops == 0)
			System.out.println("unlimited");
		else
			System.out.println("" + maxPlannedLoops + " loops");
		if (downlinkBandwidth > 0)
			System.out.println("# max downlink bandwidth per user = " + downlinkBandwidth + " kbps");
		if (uplinkBandwidth > 0)
			System.out.println("# max uplink bandwidth per user = " + uplinkBandwidth + " kbps");
		System.out.println("# http protocol version = v" + httpProtocolVersion);
		System.out.println("# ssl protocol version = " + sslProtocolVersion);
		if (sslSessionCacheTimeout != 0)
			System.out.println("# ssl session cache timeout = " + sslSessionCacheTimeout + " seconds");
		else
			System.out.println("# ssl session cache disabled");
		if (dnsCache != null)
		{
			System.out.println("# OS-independent DNS access enabled. " + dnsCache.getConfigInfoText());
			if (dnsPerLoop)
				System.out.println("# DNS option -dnsperloop enabled");
		}
		if (resultFile != null)
			System.out.println("# result file = " + resultFile);
		else
			System.out.println("# no result file");
		if (debugFailedLoops)
			System.out.println("# debug failed loops");
		if (debugLoops)
			System.out.println("# debug loops");
		if (debugHttp)
			System.out.println("# debug http protocol headers");
		if (debugContent)
			System.out.println("# debug http content data");
		if (debugCookies)
			System.out.println("# debug cookies");
		if (debugKeepAlive)
			System.out.println("# debug keep-alive (socket pool)");
		if (debugSsl)
			System.out.println("# debug ssl (https)");
		if (debugLoops || debugFailedLoops)
		{
		}
		System.out.println();
		
		
		
		// --------------------------
		// *** start of load test ***
		// --------------------------
		
		
		// initialize performance data
		// ---------------------------
		final int PAGE_BREAKS = 4;  // number of page breaks in execute()  - modify this value if you add or delete some page breaks
		final int MAX_THREAD_STEPS = 164;  // number of URL requests in execute() - modify this value if you add or delete some requests
		performanceData = new PerformanceData(PAGE_BREAKS, MAX_THREAD_STEPS, concurrentUsers, maxParallelThreadsPerUser, plannedTestDuration, maxPlannedLoops, httpProtocolVersion, plannedStartupDelay, plannedRequestTimeout, samplingInterval, percentilePageSampling, percentileUrlSampling, percentileUrlSamplingAddOption);
		performanceData.setInfoText("LoginLogoutSingapore");
		performanceData.setExecutorsAnnotation(testRunAnnotation);
		performanceData.setProxyInfo(proxyHttpHost, proxyHttpPort, proxyHttpsHost, proxyHttpsPort);
		performanceData.addTestDescription("*** Warning: Load test executed via outbound proxy ***");
		performanceData.addTestDescription("*** Warning: Url content test disabled ***");
		performanceData.setResultFileName(resultFile);
		performanceData.setDumpStream(System.out, "# ");
		performanceData.setMaxErrorSnapshots(maxErrorSnapshots);		// 0 = unlimited
		if (maxErrorSnapshotMemory >= 0)
			performanceData.setMaxErrorSnapshotsMemory(maxErrorSnapshotMemory * 1048576l);		// value in bytes
		
		if (dnsCache != null)
		{
			performanceData.addDNSCacheStatistic(dnsCache.getCacheStatistic());
			performanceData.addTestDescription("*** Warning: OS-independent DNS access enabled. " + dnsCache.getConfigInfoText() + " ***");
			if (dnsPerLoop)
				performanceData.addTestDescription("*** Warning: DNS option -dnsperloop enabled ***");
		}
		
		if (sslECC)
			performanceData.addTestDescription("*** Warning: SSL/TLS option -ecc enabled ***");
		
		if ((downlinkBandwidth != 0) || (uplinkBandwidth != 0))
		{
			String downlinkBandwidthStr = "unlimited";
			String uplinkBandwidthStr = "unlimited";
			
			if (downlinkBandwidth != 0)
				downlinkBandwidthStr = "" + downlinkBandwidth + " kbps";
			if (uplinkBandwidth != 0)
				uplinkBandwidthStr = "" + uplinkBandwidth + " kbps";
			
			performanceData.addTestDescription("*** Warning: Max. network bandwidth per user limited. downlink = " + downlinkBandwidthStr + ", uplink = " + uplinkBandwidthStr + " ***");
		}
		
		if ((percentileUrlSamplingAddOption != PerformanceDataTickExtension.EXT_TYPE_NOTYPE) && (percentileUrlSampling > 0))
			performanceData.addTestDescription("*** Warning: Option \"" + PerformanceDataTickExtension.extTypeToString(percentileUrlSamplingAddOption).toLowerCase() + "\" enabled for additional sampling rate per URL call ***");
		if (debugFailedLoops)
			performanceData.addTestDescription("*** Warning: Debug failed loops enabled ***");
		if (debugLoops)
			performanceData.addTestDescription("*** Warning: Debug loops enabled ***");
		if (debugHttp)
			performanceData.addTestDescription("*** Warning: Debug HTTP protocol headers enabled ***");
		if (debugContent)
			performanceData.addTestDescription("*** Warning: Debug HTTP content data enabled ***");
		if (debugCookies)
			performanceData.addTestDescription("*** Warning: Debug cookies enabled ***");
		if (debugKeepAlive)
			performanceData.addTestDescription("*** Warning: Debug keep-alive enabled ***");
		if (debugSsl)
			performanceData.addTestDescription("*** Warning: Debug SSL/TLS enabled ***");
		if (!sslProtocolVersion.equalsIgnoreCase("all"))
			performanceData.addTestDescription("*** Warning: SSL/TLS protocol version fixed to " + sslProtocolVersion.toUpperCase() + " ***");
		if (sslSessionCacheTimeout == 0)
			performanceData.addTestDescription("*** Warning: SSL/TLS session cache disabled ***");
		if (singleUserMode)
		{
			String singleUserModeWarning = "*** Warning: Single user mode enabled ***";
			System.out.println(singleUserModeWarning);
			performanceData.addTestDescription(singleUserModeWarning);
		}
		if (setUserAgentStr != null)
		{
			String overrideUserAgentWarning = "*** Warning: User agent set to \"" + setUserAgentStr + "\" ***";
			System.out.println(overrideUserAgentWarning);
			performanceData.addTestDescription(overrideUserAgentWarning);
		}
		
		
		// ready to start load test...
		initNull(concurrentUsers);
		performanceData.setUserContextTable(getUserContextTable());
		
		// ... but init first remote interface ...
		initRemote(args);
		
		// ... and check multihomed option ...
		initMultihomed(args);
		
		// ... and add dynaTrace session ID to load test result - if available ...
		initDynaTrace();
		
		
		// calculate sampling offset and virtual user startup offset for cluster jobs (time shift per cluster member)
		int samplingTimeshift = 0;	// value in seconds
		if (!ParseArgs.hasOption(args, "-nosdelayCluster"))
		{
			if ((getClusterTotalMemberCount() > 1) && (getClusterMemberLocalId() > 0))
			{
				samplingTimeshift = Math.round(((float) samplingInterval / (float) getClusterTotalMemberCount()) * (float) getClusterMemberLocalId());
				System.out.println("# samplingTimeshift = " + samplingTimeshift + " seconds");
				
				long startupDelayOffset = (plannedStartupDelay / ((long) getClusterTotalMemberCount())) * ((long) getClusterMemberLocalId());
				System.out.println("# startupDelayTimeshift = " + startupDelayOffset + " milliseconds");
				System.out.println();
				if (startupDelayOffset > 0)
				{
					try { sleepRemoteInterruptable(startupDelayOffset); } catch (InterruptedException ie) {}
				}
			}
		}
		
		
		// start virtual users as threads
		// ------------------------------
		testDurationStart = System.currentTimeMillis();
		performanceData.setStartDate();
		performanceData.addSnapshot(getCpuUsagePercent());
		performanceData.setSnapshotsTimeshift(samplingTimeshift);
		performanceData.setEndDate();
		for (int x = 0; x < concurrentUsers; x++)
		{
			// start load test thread
			// ----------------------
			Thread t = null;
			try
			{
				getUserContextTable().getWriteLock().lock();
				
				LoginLogoutSingapore simulatedUser = new LoginLogoutSingapore(maxPlannedLoops, plannedRequestTimeout, getUserContextTable().getUserContextList().size());
				t = new Thread(simulatedUser);
				String threadName = "" + getUserContextTable().getUserContextList().size();
				threadName = THREAD_NAME.substring(0, 7 - threadName.length()) + threadName;
				t.setName(threadName);
				if (debugLoops && (simulatedUser.getLog().size() > 0))
				{
					synchronized (dumpLock)
					{
						simulatedUser.dumpLog(threadName + " ", System.out);		// dump log of constructor
					}
				}
				HttpLoadTestUserContext userContext = new HttpLoadTestUserContext(simulatedUser, t);
				getUserContextTable().getUserContextList().add(userContext);
				simulatedUser.setOwnLoadTestUserContext(userContext);
			}
			finally
			{
				getUserContextTable().getWriteLock().unlock();
			}
			t.start();
			System.out.println("# --- thread " + t.getName() + " created --- " + ZoneTime.dateToShortString() + " ---");
			
			while (isSuspend())
			{
				try { Thread.currentThread().sleep(100); } catch (InterruptedException ie) { break; }
				if (abortedByRemote() || abortedByEofInputFile())
					break;
				
				// check if max test duration reached during suspend
				if ((plannedTestDuration > 0) && (((System.currentTimeMillis() - testDurationStart) / 1000) >= plannedTestDuration))
					break;
				
				// display and sample temporary performance data all "sampling interval" seconds - also during suspend
				if (((System.currentTimeMillis() - performanceData.getLastSnapshotTime()) / 1000) >= samplingInterval)
				{
					performanceData.addSnapshot(getCpuUsagePercent());
					performanceData.setEndDate();
				}
			}
			
			if (abortedByRemote() || abortedByEofInputFile())
				break;
			
			if ((plannedTestDuration > 0) && (((System.currentTimeMillis() - testDurationStart) / 1000) >= plannedTestDuration))
				break;
			
			// startup delay for next thread
			// -----------------------------
			try
			{
				if (!singleUserMode)   // create concurrent users
				{
					if (plannedStartupDelay <= 3000)
						sleepRemoteInterruptable(plannedStartupDelay);
					else
					{
						long startupDelayStartTime = System.currentTimeMillis();
						while (true)
						{
							if (abortedByRemote() || abortedByEofInputFile())
								break;
							if ((System.currentTimeMillis() - startupDelayStartTime) >= plannedStartupDelay)
								break;
							
							Thread.currentThread().sleep(100);
							
							// display and sample temporary performance data all "sampling interval" seconds
							if (((System.currentTimeMillis() - performanceData.getLastSnapshotTime()) / 1000) >= samplingInterval)
							{
								performanceData.addSnapshot(getCpuUsagePercent());
								performanceData.setEndDate();
							}
						}
					}
				}
				else
					t.join();   // single user mode
			}
			catch (InterruptedException ie) { break; }
			if (abortedByRemote() || abortedByEofInputFile())
				break;
			
			
			// display and sample temporary performance data all "sampling interval" seconds
			if (((System.currentTimeMillis() - performanceData.getLastSnapshotTime()) / 1000) >= samplingInterval)
			{
				performanceData.addSnapshot(getCpuUsagePercent());
				performanceData.setEndDate();
				if (!isRemote())
				{
					synchronized (dumpLock)
					{
						performanceData.dump(false);
					}
				}
			}
		}
		
		
		// wait for test-end in a loop
		// ---------------------------
		boolean allDone = false;
		while (!allDone)
		{
			// test aborted ?
			if (abortedByRemote() || abortedByEofInputFile())
			{
				nearRemoteEnd();
				String abort = "";
				if (abortedByRemote())
					abort = "*** test aborted by remote command ***";
				if (abortedByEofInputFile())
				{
					abort = "*** test aborted at eof of input file ***";
					performanceData.addTestDescription(abort);
				}
				synchronized (dumpLock)
				{
					addSSLCacheStatistic();
					performanceData.addSnapshot(getCpuUsagePercent());
					performanceData.setEndDate();
					
					if (!isRemote())
						performanceData.dump(false);
					if (resultFile != null)
						try { performanceData.writeObjectToFile(resultFile); } catch (IOException ie) { ie.printStackTrace(); }
					
					System.out.println();
					System.out.println(abort);
					System.out.println();
					System.out.flush();
					try { Thread.currentThread().sleep(10000); } catch (InterruptedException ie) {}
					System.exit(0);
				}
			}
			
			// display and sample temporary performance data all "sampling interval" seconds
			if (((System.currentTimeMillis() - performanceData.getLastSnapshotTime()) / 1000) >= samplingInterval)
			{
				performanceData.addSnapshot(getCpuUsagePercent());
				performanceData.setEndDate();
				if (!isRemote())
				{
					synchronized (dumpLock)
					{
						performanceData.dump(false);
					}
				}
			}
			
			// check if test has been done
			allDone = isTestDone();
			
			// if not all is done: sleep one second
			if (!allDone)
				try { sleepRemoteInterruptable(1000); } catch (InterruptedException ie) { break; }
		} // end of wait loop
		
		
		// mark near end of test - only if a remote interface has been used
		nearRemoteEnd();
		
		
		
		// final test result - test completed
		// ----------------------------------
		performanceData.addSnapshot(getCpuUsagePercent());
		performanceData.setEndDate();
		
		// save test result
		performanceData.dump(true);
		if (resultFile != null)
			try { performanceData.writeObjectToFile(resultFile); } catch (IOException ie) { ie.printStackTrace(); }
		
		// all done
		System.out.flush();
		
		// wait for official end of test - only if a remote interface has been used
		waitRemoteEnd();
		
		System.out.println();
		System.out.println("Result File: " + resultFile);
		
		// now dead
		System.exit(0);
	}


	/**
	 * implement VaryingLoadInterface: support to increment the number of simulated users at runtime.
	 */
	public void setIncrementUser(long startTime)
	{
		incrementUserStartTime = startTime;
		incrementUserFlag = true;
	}

	public boolean isIncrementUser()
	{
		return incrementUserFlag;
	}

	public long getIncrementUserStartTime()
	{
		return incrementUserStartTime;
	}

	public void setIncrementUserStartTime(long startTime)
	{
		incrementUserStartTime = startTime;
	}

	public void clearIncrementUser()
	{
		incrementUserFlag = false;
	}

	public int incrementUsers(int numAddUsers, long startupDelay)
	{
		if (startupDelay < 0)
			startupDelay = plannedStartupDelay;
		return incrementUsersImplementation(numAddUsers, startupDelay, this);
	}

	static int incrementUsersImplementation(int numAddUsers, long startupDelay, HttpLoadTest httpLoadTest)
	{
		long startupDelayOffset = 0;
		if ((getClusterTotalMemberCount() > 1) && (getClusterMemberLocalId() > 0))
			startupDelayOffset = (startupDelay / ((long) getClusterTotalMemberCount())) * ((long) getClusterMemberLocalId());
		
		ArrayList<HttpLoadTestUserContext> addUserContextList = new ArrayList<HttpLoadTestUserContext>(numAddUsers);
		for (int x = 0; x < numAddUsers; x++)
		{
			if (abortedByRemote() || abortedByEofInputFile())
				return x;
			
			// initialize load test thread
			// ---------------------------
			try
			{
				getUserContextTable().getWriteLock().lock();
				
				LoginLogoutSingapore simulatedUser = new LoginLogoutSingapore(maxPlannedLoops, plannedRequestTimeout, getUserContextTable().getUserContextList().size());
				HttpLoadTestUserContext userContext = prepareIncrementUser(simulatedUser, System.currentTimeMillis() + startupDelayOffset + (x * startupDelay));
				addUserContextList.add(userContext);
				simulatedUser.setOwnLoadTestUserContext(userContext);
				if (debugLoops && (simulatedUser.getLog().size() > 0))
				{
					synchronized (dumpLock)
					{
						simulatedUser.dumpLog(userContext.getLoadTestThread().getName() + " ", System.out);		// dump log of constructor
					}
				}
			}
			finally
			{
				getUserContextTable().getWriteLock().unlock();
			}
		}
		
		// start load test threads by a thread
		// -----------------------------------
		HttpLoadTestIncrementUserThread incrementUserThread = new HttpLoadTestIncrementUserThread(httpLoadTest, addUserContextList);
		incrementUserThread.start();
		return numAddUsers;
	}



	// definition for external files used to support large XML, SOAP and ASCII requests
	// --------------------------------------------------------------------------------
	public static final String REQUEST_FILE_CACHE_FILE_1 = "LoginLogoutSingapore_RequestContent0112.txt";		// must be zipped together with the compiled class of this load test program
	public static final String REQUEST_FILE_CACHE_FILE_2 = "LoginLogoutSingapore_RequestContent0166.txt";		// must be zipped together with the compiled class of this load test program
	

}	// end of class

