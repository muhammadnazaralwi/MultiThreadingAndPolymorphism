package api;

import feature.HTTPClient;

import java.net.URL;

public class RemoteRestaurantImageDownloader {
    URL url;
    HTTPClient client;

    public RemoteRestaurantImageDownloader(URL url, HTTPClient client) {
        this.url = url;
        this.client = client;
    }

    public void load(URL url) {
        client.get(url);
        System.out.println("Download restaurant image from database");
    }
}
