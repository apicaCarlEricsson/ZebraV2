import com.google.gson.*;
import dfischer.femtowebserver.httpd.HttpRequest;

import java.lang.reflect.Type;

/**
 * Created by carlericsson on 16/01/17.
 */
public class HttpRequestSerializer implements JsonSerializer<HttpRequest> {

    @Override
    public JsonElement serialize(HttpRequest httpRequest, Type type, JsonSerializationContext context) {
        Gson gson = new Gson();

        JsonObject root = new JsonObject();
        root.addProperty("protocol", httpRequest.getProtocol());
        root.addProperty("clientAddress", httpRequest.getRemoteAddress());
        root.addProperty("httpdSession", gson.toJson(httpRequest.getSession()));
        root.addProperty("headerVector", gson.toJson(httpRequest.getHeader()));
        root.addProperty("fieldNameVector", gson.toJson(httpRequest.getHeaderFieldNames()));
        root.addProperty("cookieVector", gson.toJson(httpRequest.getReceivedCookies()));
        root.addProperty("requestMethod", httpRequest.getMethod());
        root.addProperty("userAgent", httpRequest.getProtocol());
        root.addProperty("contentType", httpRequest.getContentType());
        root.addProperty("contentSubtype", httpRequest.getContentSubtype());
        root.addProperty("requestContent", httpRequest.getContent().toString());
        root.addProperty("requestFile", httpRequest.getRequestFile());
        root.addProperty("originalRequestFile", httpRequest.getOriginalRequest());
        root.addProperty("paramNameVector", gson.toJson(httpRequest.getParameterNames()));
        return root;
    }

}
