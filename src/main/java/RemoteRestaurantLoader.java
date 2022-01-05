import feature.HTTPClient;

import java.net.URL;

public class RemoteRestaurantLoader {
    URL url;
    HTTPClient client;

    public RemoteRestaurantLoader(URL url, HTTPClient client) {
        this.url = url;
        this.client = client;
    }

    public void load(URL url) {
        client.get(url);
        System.out.println("Load from database");
    }
}
