package app;

import api.HTTPClientImplementation;
import api.RemoteRestaurantImageDownloader;
import api.RemoteRestaurantLoader;
import store.LocalRestaurantLoader;

import java.net.URL;

public class Main {
    public static void main(String[] args) {
        URL storeURL = null;
        URL remoteURL = null;
        HTTPClientImplementation client = new HTTPClientImplementation();
        Runnable runnable;
        Thread thread;

        try {
            storeURL = new URL("file:///Users/alwi/Nazar/caches");
            remoteURL = new URL("https://any-url.com");
        } catch (Exception e) {
            System.err.println(e);
        }

        LocalRestaurantLoader localLoader = new LocalRestaurantLoader(storeURL);
        RemoteRestaurantLoader remoteLoader = new RemoteRestaurantLoader(remoteURL, client);
        RemoteRestaurantImageDownloader imageDownloader = new RemoteRestaurantImageDownloader(remoteURL, client);

        runnable = () -> {
            System.out.println("Downloading...");
            imageDownloader.load();

            try {
                Thread.sleep(10000);
                System.out.println("Downloaded");
            } catch (Exception e) {
                System.err.println(e);
            }
        };

        thread = new Thread(runnable);
        thread.start();

        remoteLoader.load();
        localLoader.load();
    }
}
