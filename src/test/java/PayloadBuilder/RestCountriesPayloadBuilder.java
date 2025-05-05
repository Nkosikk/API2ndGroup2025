package PayloadBuilder;

public class RestCountriesPayloadBuilder  {
    public static String getAllCountries() {
        return "{\n" +
                "  \"name\": \"India\",\n" +
                "  \"alpha2Code\": \"IN\",\n" +
                "  \"alpha3Code\": \"IND\",\n" +
                "  \"capital\": \"New Delhi\",\n" +
                "  \"region\": \"Asia\",\n" +
                "  \"subregion\": \"Southern Asia\",\n" +
                "  \"population\": 1393409038,\n" +
                "  \"area\": 3287263,\n" +
                "  \"languages\": [\n" +
                "    {\n" +
                "      \"iso639_1\": \"hi\",\n" +
                "      \"iso639_2\": \"hin\",\n" +
                "      \"name\": \"Hindi\",\n" +
                "      \"nativeName\": \"हिन्दी\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";

    }


}
