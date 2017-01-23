import dfischer.femtowebserver.httpd.*;
import dfischer.proxysniffer.*;
import dfischer.webadmininterface.DirectoryNavigatorStoreContext;
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

    PrxdatMirror mirror;



    public PrxdatWorker(){
        String fileName = "LoginLogoutSingapore.prxdat";
        prxdat = new ProxyDataDump();
        mirror = new PrxdatMirror(prxdat);

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
        fileName = fileName.replace(".prxdat","");

        prxdat.setProjectName(fileName);
        System.out.println(prxdat.getProjectName());
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
        fileName= fileName.replace(".prxdat","");

        prxdat.setProjectName(fileName);

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

    public Collection fetchProxyData() {
        return prxdat.getProxyData();
    }



    public void fetchAllData(){
    }

    //Fetches a list containing only pageBreaks
    public Vector<ProxyDataRecord> fetchPageBreaks (){
        Vector pageBreakVector = new Vector<ProxyDataRecord>();

        for (Object record : prxdat.getProxyData()){
            if (((ProxyDataRecord) record).isDataTypePageBreak()){
                pageBreakVector.add(record);
            }
        }
        return pageBreakVector;
    }

    //Fetches a list containing only HTTP Data
    public Vector<ProxyDataRecord> fetchUrlData() {
        Vector urlVector = new Vector<ProxyDataRecord>();

        for (Object record : prxdat.getProxyData()){
            if (((ProxyDataRecord) record).isDataTypeHttpData()){
                urlVector.add(record);
            }
        }
        return urlVector;
    }

    public Vector fetchUrlDetails (){
       return mirror.returnEntireList();
    }



}
