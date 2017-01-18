import com.google.gson.*;
import dfischer.proxysniffer.HttpResponse;

import java.lang.reflect.Type;

/**
 * Created by carlericsson on 16/01/17.
 */
public class HttpResponseSerializer implements JsonSerializer<HttpResponse> {

    @Override
    public JsonElement serialize(final HttpResponse httpResponse, final Type type, final JsonSerializationContext context) {
        final JsonObject jsonObj = new JsonObject();
        jsonObj.add("content", context.serialize(httpResponse.getContent()));
        jsonObj.add("header", context.serialize(httpResponse.getHeader()));
        jsonObj.add("headerContentType", context.serialize(httpResponse.getContentType()));
        jsonObj.add("headerServerStatus", context.serialize(httpResponse.getStatus()));
        jsonObj.add("headerServerStatusText", context.serialize(httpResponse.getStatusText()));
        jsonObj.add("headerContentLength", context.serialize(httpResponse.getContentLength()));
        return jsonObj;

    }

}
