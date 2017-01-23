import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

/**
 * Created by calle on 2017-01-23.
 */
public class Dispatcher {

    public int startRecording() throws UnirestException {
        HttpResponse<JsonNode> response = Unirest.get("http://127.0.0.1:7996/?cmd=startRecording").asJson();

        return response.getStatus();
    }

    public int stopRecording() throws UnirestException {
        HttpResponse<JsonNode> response = Unirest.get("http://127.0.0.1:7996/?cmd=stopRecording").asJson();

        return response.getStatus();
    }

    public int clearRecording() throws UnirestException {
        HttpResponse<JsonNode> response = Unirest.get("http://127.0.0.1:7996/?cmd=clearRecording").asJson();

        return response.getStatus();
    }

    public int insertPageBreak(String comment, int delaySeconds, int randomization) throws UnirestException {
        HttpResponse<JsonNode> response = Unirest.get("http://127.0.0.1:7996/?cmd=insertPageBreak")
                .queryString("comment", comment)
                .queryString("delaySeconds", delaySeconds)
                .queryString("randomization", randomization)
                .asJson();

        return response.getStatus();
    }

    public String getNumberOfItems() throws UnirestException {
        HttpResponse<JsonNode> response = Unirest.get("http://127.0.0.1:7996/?cmd=getNumRecordedItems").asJson();
        return response.getBody().toString();
    }
}
