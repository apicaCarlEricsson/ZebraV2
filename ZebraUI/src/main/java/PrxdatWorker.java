import dfischer.femtowebserver.httpd.*;
import dfischer.generator.CreateLoadtestProgram;
import dfischer.proxysniffer.*;
import dfischer.utils.NextProxyConfig;
import dfischer.webadmininterface.DirectoryNavigatorStoreContext;
import dfischer.webadmininterface.DisplayListCache;


import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
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

    DisplayListCache cache = new DisplayListCache();

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

    public void generateLoadTest() throws Exception {
        DisplayListCache cache = new DisplayListCache();

        Vector dataRecord = prxdat.getProxyData();

        for (int i = 0; i <dataRecord.size();i++ ){
            cache.add((ProxyDataRecord) dataRecord.get(i),i,i);
        }

        ProxyAdminNetCmd admin = new ProxyAdminNetCmd("localhost",7998);

        CreateLoadtestProgram generator = new CreateLoadtestProgram(new NextProxyConfig(), 2,prxdat.getProjectName()+".prxdat");

        generator.write(cache,admin,prxdat.getVarSourceHandler(),prxdat.getVarHandler(),prxdat.getTransactionHandler(),prxdat.getExternalResources()
                ,new PrintWriter(new FileOutputStream(prxdat.getProjectName()+".java")));

        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager sfm = compiler.getStandardFileManager(null, null, null);
        String superPath = System.getProperty("user.dir");
        List<String> optionList = new ArrayList<String>();
        optionList.add("-classpath");
        optionList.add(System.getProperty("user.dir")+"/iaik_eccelerate.jar");
        optionList.add(System.getProperty("user.dir")+"/iaik_eccelerate_ssl.jar");
        optionList.add(System.getProperty("user.dir")+"/iaik_jce_full.jar");
        optionList.add(System.getProperty("user.dir")+"/iaik_ssl.jar");
        optionList.add(System.getProperty("user.dir")+"/iaikPkcs11Provider.jar");
        optionList.add(System.getProperty("user.dir")+"/iaikPkcs11Wrapper.jar");
        optionList.add(System.getProperty("user.dir")+"/prxsniff.jar");

        File javaFile = new File(prxdat.getProjectName()+".java");

        //compiler.getTask(null, sfm, null, optionList, null, sfm.getJavaFileObjects(new File[]{javaFile})).call();

        //compiler.run(null, null, null, "-classpath "+System.getProperty("user.dir")+"/iaik_eccelerate.jar;"+System.getProperty("user.dir")+"/iaik_eccelerate_ssl.jar;"+System.getProperty("user.dir")+"/iaik_jce_full.jar;"+System.getProperty("user.dir")+"/iaik_ssl.jar;"+System.getProperty("user.dir")+"/iaikPkcs11Provider.jar;"+System.getProperty("user.dir")+"/iaikPkcs11Wrapper.jar;"+System.getProperty("user.dir")+"/prxsniff.jar "+System.getProperty("user.dir")+"/"+javaFile.getPath());

        compiler.run(null, null, null, javaFile.getPath());
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
