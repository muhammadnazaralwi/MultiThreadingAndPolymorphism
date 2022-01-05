import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

class RemoteRestaurantLoaderTest {
    @Test
    void constructor_doesNotPerformAnyRequest() throws MalformedURLException {
        URL url = new URL("https://any-url.com");
        HTTPClientSpy client = new HTTPClientSpy();
        RemoteRestaurantLoader sut = new RemoteRestaurantLoader(url, client);

        assertEquals(client.loadCallCount, 0);
    }

    @Test
    void load_requestsDataFromURL() throws MalformedURLException {
        URL url = new URL("https://any-url.com");
        HTTPClientSpy client = new HTTPClientSpy();
        RemoteRestaurantLoader sut = new RemoteRestaurantLoader(url, client);

        sut.load(url);

        assertEquals(client.requestedURL, url);
    }
}

class HTTPClientSpy implements HTTPClient {
    int loadCallCount = 0;
    URL requestedURL;

    @Override
    public void get(URL url) {
        loadCallCount++;
        requestedURL = url;
    }
}