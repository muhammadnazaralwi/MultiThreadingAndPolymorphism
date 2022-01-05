package API;

import feature.HTTPClient;

import java.net.URL;

public class HTTPClientImplementation implements HTTPClient {
    @Override
    public void get(URL url) {
        System.out.println("Get json data");
    }
}
