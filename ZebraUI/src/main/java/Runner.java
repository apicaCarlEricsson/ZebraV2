import dfischer.jobcontroller.JobControllerNetCmd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by carlericsson on 30/01/17.
 */
public class Runner {

    public int runJob (String jobName, int userNumber, int maxLoops, int startUpDelay, int duration, int execAgentID, String sslSettings) throws Exception{
        Runtime rt = Runtime.getRuntime();
        //System.out.println("java -classpath .:/Users/carlericsson/Desktop/New Zebra/New Design/ZebraV2/ZebraUI/prxsniff.jar:/Users/carlericsson/Desktop/New Zebra/New Design/ZebraV2/ZebraUI:/Users/carlericsson/Desktop/New Zebra/New Design/ZebraV2/ZebraUI/iaik_jce_full.jar:/Users/carlericsson/Desktop/New Zebra/New Design/ZebraV2/ZebraUI/iaik_ssl.jar:/Users/carlericsson/Desktop/New Zebra/New Design/ZebraV2/ZebraUI/iaik_eccelerate.jar:/Users/carlericsson/Desktop/New Zebra/New Design/ZebraV2/ZebraUI/iaikPkcs11Provider.jar "+jobName+" -u "+userNumber+" -d "+duration+" -t 60 -sdelay "+startUpDelay+" -maxloops "+maxLoops+" -ssl "+sslSettings+" -sampling 15 -percpage 100 -percurl 20 -maxerrmem 20 -nolog -execAgentJobId "+execAgentID);
        //Process pr = rt.exec("java -classpath .:/Users/carlericsson/Desktop/NewZebra/NewDesign/ZebraV2/ZebraUI/prxsniff.jar:/Users/carlericsson/Desktop/NewZebra/NewDesign/ZebraV2/ZebraUI:/Users/carlericsson/Desktop/NewZebra/NewDesign/ZebraV2/ZebraUI/iaik_jce_full.jar:/Users/carlericsson/Desktop/NewZebra/NewDesign/ZebraV2/ZebraUI/iaik_ssl.jar:/Users/carlericsson/Desktop/NewZebra/NewDesign/ZebraV2/ZebraUI/iaik_eccelerate.jar:/Users/carlericsson/Desktop/NewZebra/NewDesign/ZebraV2/ZebraUI/iaikPkcs11Provider.jar "+jobName+" -u "+userNumber+" -d "+duration+" -t 60 -sdelay "+startUpDelay+" -maxloops "+maxLoops+" -ssl "+sslSettings+" -sampling 15 -percpage 100 -percurl 20 -maxerrmem 20 -nolog -execAgentJobId "+execAgentID);


        String[] CommandX = {"java", "-classpath", ".:/Users/carlericsson/Desktop/NewZebra/NewDesign/ZebraV2/ZebraUI/prxsniff.jar:/Users/carlericsson/Desktop/NewZebra/NewDesign/ZebraV2/ZebraUI:/Users/carlericsson/Desktop/NewZebra/NewDesign/ZebraV2/ZebraUI/iaik_jce_full.jar:/Users/carlericsson/Desktop/NewZebra/NewDesign/ZebraV2/ZebraUI/iaik_ssl.jar:/Users/carlericsson/Desktop/NewZebra/NewDesign/ZebraV2/ZebraUI/iaik_eccelerate.jar:/Users/carlericsson/Desktop/NewZebra/NewDesign/ZebraV2/ZebraUI/iaikPkcs11Provider.jar", jobName, "-u", Integer.toString(userNumber), "-d", Integer.toString(duration), "-t", "60" ,"-maxloops", Integer.toString(maxLoops), "-sampling", "15", "-percpage", "100", "-percurl", "20", "-maxerrmem", "20", "-nolog"};
        ProcessBuilder builder = new ProcessBuilder(CommandX);
        Process pr = builder.start();
        //System.out.println("java -classpath .:/Users/carlericsson/Desktop/NewZebra/NewDesign/ZebraV2/ZebraUI/prxsniff.jar:/Users/carlericsson/Desktop/NewZebra/NewDesign/ZebraV2/ZebraUI:/Users/carlericsson/Desktop/NewZebra/NewDesign/ZebraV2/ZebraUI/iaik_jce_full.jar:/Users/carlericsson/Desktop/NewZebra/NewDesign/ZebraV2/ZebraUI/iaik_ssl.jar:/Users/carlericsson/Desktop/NewZebra/NewDesign/ZebraV2/ZebraUI/iaik_eccelerate.jar:/Users/carlericsson/Desktop/NewZebra/NewDesign/ZebraV2/ZebraUI/iaikPkcs11Provider.jar "+jobName+" -u "+userNumber+" -d "+duration+" -t 60 -sdelay "+startUpDelay+" -maxloops "+maxLoops+" -ssl "+sslSettings+" -sampling 15 -percpage 100 -percurl 20 -maxerrmem 20 -nolog -execAgentJobId "+execAgentID);
        run(pr);
        Thread.sleep(1000*duration);

        return pr.exitValue();
    }

    public void run(Process pr)
    {
        BufferedReader bin;

        try
        {
            bin = new BufferedReader(new InputStreamReader(pr.getInputStream()));
            String line = bin.readLine();
            System.out.println(line);

            while (line != null)
            {
                //System.out.println(line);
            }

            bin.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}
