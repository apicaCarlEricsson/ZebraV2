import dfischer.proxysniffer.*;
import dfischer.utils.LoadtestExternalResources;

import java.util.List;
import java.util.Vector;

/**
 * Created by carlericsson on 11/01/17.
 */
public class PrxdatMirror {

    ProxyDataDump prxdat;

    public PrxdatMirror(ProxyDataDump dump){
        prxdat=dump;
    }

    //Returns
    public Vector<Tuple> returnEntireList (){
        Vector prxDatListing = new Vector<Tuple>();

        Tuple projectName = new Tuple("projectName",prxdat.getProjectName());

        prxDatListing.add(projectName);

        return prxDatListing;
    }

}
