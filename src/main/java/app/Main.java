package app;

import API.HTTPClientImplementation;
import API.RemoteRestaurantImageDownloader;
import API.RemoteRestaurantLoader;
import Store.LocalRestaurantLoader;

import java.net.URL;

public class Main {
    public static void main(String[] args) {
        URL storeURL = null;
        URL remoteURL = null;
        HTTPClientImplementation client = new HTTPClientImplementation();

        try {
            storeURL = new URL("/Users/alwi/Nazar/caches");
            remoteURL = new URL("https://any-url.com");
        } catch (Exception e) {
            System.err.println(e);
        }

        LocalRestaurantLoader localLoader = new LocalRestaurantLoader(storeURL);
        RemoteRestaurantLoader remoteLoader = new RemoteRestaurantLoader(remoteURL, client);
        RemoteRestaurantImageDownloader imageDownloader = new RemoteRestaurantImageDownloader(remoteURL, client);

        remoteLoader.load();
    }
}
