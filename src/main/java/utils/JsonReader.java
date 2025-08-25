package utils;

import java.io.IOException;
import java.io.File;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonReader {
	
	public static boolean  compareJsonfiles(String sourcepath, String destpath) throws IOException{
		
		ObjectMapper mapper = new ObjectMapper();
		
JsonNode sourcejson		= mapper.readTree(new File(sourcepath));

JsonNode destjson = mapper.readTree(new File(destpath));

return sourcejson.equals(destjson);

		
		
		
	}

}
