package store;

import java.net.URL;

public class LocalRestaurantLoader {
    URL storeUrl;

    public LocalRestaurantLoader(URL storeUrl) {
        this.storeUrl = storeUrl;
    }

    public void load() {
        System.out.println("Load from cache");
    }
}
