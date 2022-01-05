package store;

import feature.RestaurantLoader;

import java.net.URL;

public class LocalRestaurantLoader implements RestaurantLoader {
    URL storeUrl;

    public LocalRestaurantLoader(URL storeUrl) {
        this.storeUrl = storeUrl;
    }

    public void load() {
        System.out.println("Load from cache");
    }
}
