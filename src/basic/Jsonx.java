package basic;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Jsonx {
	String     jsonName = null;
	JsonObject json     = null;
	String     jsonStr  = null;
	public Jsonx(String jsonName) {
		this.jsonName=jsonName;
	}
	public String get(String key) {
		String jsonStr=Lister.readFile(jsonName);
        JsonObject json = JsonParser.parseString(jsonStr).getAsJsonObject();
        return json.get(key).getAsString();
	}
}
