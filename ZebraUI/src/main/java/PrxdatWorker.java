import dfischer.femtowebserver.httpd.*;
import dfischer.proxysniffer.*;
import dfischer.webadmininterface.DirectoryNavigatorStoreContext;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import java.util.Collection;

/**
 * Created by carlericsson on 30/12/16.
 */
public class PrxdatWorker {

    ProxyDataDump prxdat;

    PrxdatMirror mirror;

    public PrxdatWorker(){
        prxdat = new ProxyDataDump();

        prxdat.setProjectName("-1");
    }


    /*public PrxdatWorker(){
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
    }*/

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

    public void clearPrxDat (){
        prxdat = new ProxyDataDump();

        prxdat.setProjectName("-1");
    }


    public void reloadPrxDat (String name, InputStream stream) {
        prxdat = new ProxyDataDump();
        try {
            prxdat.readObject(new DataInputStream(stream));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO Exception");
        } catch (ProxySnifferVarHandlerDupScopeException e) {
            e.printStackTrace();
            System.out.println("PrxVarDup Exception");
        } catch (ProxySnifferVarHandlerInvNameException e) {
            e.printStackTrace();
            System.out.println("PrxVarInv Exception");
        } catch (ProxySnifferVarHandlerKeywordException e) {
            e.printStackTrace();
            System.out.println("PrxVarKey Exception");
        }
        prxdat.setProjectName(name);
    }

    /*public void reloadPrxDat (String fileName) {
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
    }*/

    public void deleteTempDat () throws IOException {
        Path fileToDeletePath = Paths.get("tempNull.prxdat");
        Files.deleteIfExists(fileToDeletePath);
    }


    public ProxyDataDump fetchPrxDat () {
        return prxdat;
    }

    public byte[] fetchResponseContent(int index){
        ProxyDataRecord record = (ProxyDataRecord) prxdat.getProxyData().get(index);
        return record.getHttpResponse().getContent();
    }



    public Collection fetchProxyData() {
        return prxdat.getProxyData();
    }

    public boolean isProjectSaved(){
        if (prxdat.getProjectName().equalsIgnoreCase("tempNull")||(prxdat.getProjectName().equalsIgnoreCase("-1"))){
            return false;
        }else{
            return true;
        }
    }

    public String saveProject(String name) throws Exception {

        File prx = new File(name+".prxdat");
        prxdat.setProjectName(name);

        prxdat.writeObject(new DataOutputStream(new FileOutputStream(prx)));
        return "{isSaved: true}";
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
