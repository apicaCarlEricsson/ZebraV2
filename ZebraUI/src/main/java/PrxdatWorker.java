import dfischer.proxysniffer.*;
import dfischer.webadmininterface.DirectoryNavigatorStoreContext;
import org.jfree.data.xy.Vector;
import java.util.*;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;

/**
 * Created by carlericsson on 30/12/16.
 */
public class PrxdatWorker {

    ProxyDataDump prxdat;

    public PrxdatWorker(){
        prxdat = new ProxyDataDump();
        try {
            prxdat.readObject(new DataInputStream(new FileInputStream("LoginLogoutSingapore.prxdat")));
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

        //DirectoryNavigatorStoreContext
    }


    public ProxyDataDump fetchPrxDat () {
        return prxdat;
    }

    public byte[] fetchResponseContent(int index){
        ProxyDataRecord record = (ProxyDataRecord) prxdat.getProxyData().get(index);
        return record.getHttpResponse().getContent();
    }

    private String getProjectName() {
        return prxdat.getProjectName();
    }

    private Collection getScriptList() {
        return prxdat.getProxyData();
    }



    public void fetchAllData(){

    }

}
