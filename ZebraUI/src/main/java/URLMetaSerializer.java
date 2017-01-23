import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import dfischer.proxysniffer.ProxyDataRecord;

import java.lang.reflect.Type;

/**
 * Created by carlericsson on 16/01/17.
 */
public class URLMetaSerializer implements JsonSerializer<ProxyDataRecord> {

    @Override
    public JsonElement serialize(ProxyDataRecord proxyDataRecord, Type type, JsonSerializationContext context) {
        JsonObject root = new JsonObject();

        if (proxyDataRecord.isDataTypeHttpData()){
            root.add("httpRequest",context.serialize(proxyDataRecord.getHttpRequest()));
            root.add("httpResponse",context.serialize(proxyDataRecord.getHttpResponse()));
        }else{
             root.add("pageBreak",context.serialize(proxyDataRecord.getHttpPageBreak().getComment()));
        }
        return root;
    }

}
