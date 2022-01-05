package api;

import feature.HTTPClient;
import feature.RestaurantLoader;

import java.net.URL;

public class RemoteRestaurantImageDownloader implements RestaurantLoader {
    URL url;
    HTTPClient client;

    public RemoteRestaurantImageDownloader(URL url, HTTPClient client) {
        this.url = url;
        this.client = client;
    }

    public void load() {
        client.get(url);
        System.out.println("Download restaurant image from database");
    }
}
