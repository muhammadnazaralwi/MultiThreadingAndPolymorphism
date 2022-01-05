import java.net.URL;

public class LocalRestaurantLoader {
    URL storeUrl;
    HTTPClient client;

    public LocalRestaurantLoader(URL storeUrl, HTTPClient client) {
        this.storeUrl = storeUrl;
        this.client = client;
    }

    public void load(URL url) {
        client.get(url);
    }
}
