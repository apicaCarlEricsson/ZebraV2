import dfischer.proxysniffer.*;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by carlericsson on 30/12/16.
 */
public class PrxdatWorker {

    ProxyDataDump prxdat;

    public PrxdatWorker(){
        prxdat = new ProxyDataDump();
        try {
            prxdat.readObject(new DataInputStream(new FileInputStream("LoginLoagoutSingapore.prxdat")));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ProxySnifferVarHandlerDupScopeException e) {
            e.printStackTrace();
        } catch (ProxySnifferVarHandlerInvNameException e) {
            e.printStackTrace();
        } catch (ProxySnifferVarHandlerKeywordException e) {
            e.printStackTrace();
        }
    }

    public PrxdatWorker(String fileName){
        prxdat = new ProxyDataDump();
        try {
            prxdat.readObject(new DataInputStream(new FileInputStream(fileName)));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ProxySnifferVarHandlerDupScopeException e) {
            e.printStackTrace();
        } catch (ProxySnifferVarHandlerInvNameException e) {
            e.printStackTrace();
        } catch (ProxySnifferVarHandlerKeywordException e) {
            e.printStackTrace();
        }
    }

    public void fetchRecordInfo () {

    }

    public void fetchMetaData () {

    }

}
