import com.google.gson.*;
import dfischer.femtowebserver.httpd.HttpRequest;
import dfischer.femtowebserver.httpd.HttpResponse;
import dfischer.proxysniffer.ProxyDataRecord;

import java.lang.reflect.Type;

/**
 * Created by carlericsson on 16/01/17.
 */
public class PageBreakSerializer implements JsonSerializer<ProxyDataRecord> {

    @Override
    public JsonElement serialize(ProxyDataRecord proxyDataRecord, Type type, JsonSerializationContext context) {
        JsonObject root = new JsonObject();

        if (proxyDataRecord.isDataTypePageBreak()){
            root.add("pageBreak",context.serialize(proxyDataRecord.getHttpPageBreak()));
        }else{
             root.add("pageBreak",context.serialize(null));
        }
        return root;
    }

}
