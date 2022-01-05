import feature.HTTPClient;

import java.net.URL;

public class LocalRestaurantLoader {
    URL storeUrl;

    public LocalRestaurantLoader(URL storeUrl) {
        this.storeUrl = storeUrl;
    }

    public void load(URL url) {
        System.out.println("Load from cache");
    }
}
