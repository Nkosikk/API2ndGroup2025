package PayloadBuilder;

import java.io.InputStream;

public class RestCountSchemaPayloadBuilder {

    public static InputStream getSchemaPayload() {
        return RestCountSchemaPayloadBuilder
                .class
                .getResourceAsStream("/RestCountriesSchema.json");

    }


//    @Test
//    public void testGetSchemaPayload() {
//        InputStream payload = getSchemaPayload();
//        if (payload != null) {
//            System.out.println("Payload loaded successfully.");
//        } else {
//            System.out.println("Failed to load payload.");
//        }
//    }
}
