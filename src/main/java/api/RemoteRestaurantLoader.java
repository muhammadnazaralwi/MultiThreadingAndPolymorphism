package api;

import feature.HTTPClient;
import feature.RestaurantLoader;

import java.net.URL;

public class RemoteRestaurantLoader implements RestaurantLoader {
    URL url;
    HTTPClient client;

    public RemoteRestaurantLoader(URL url, HTTPClient client) {
        this.url = url;
        this.client = client;
    }

    public void load() {
        client.get(url);
        System.out.println("Load from database");
    }
}
