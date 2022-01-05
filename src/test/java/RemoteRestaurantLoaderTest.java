import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.Remote;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RemoteRestaurantLoaderTest {
    @Test
    void constructor_doesNotPerformAnyRequest() throws MalformedURLException {
        URL url = new URL("https://any-url.com");
        HTTPClientSpy client = new HTTPClientSpy();
        RemoteRestaurantLoader sut = new RemoteRestaurantLoader(url, client);

        assertTrue(client.requestedURLs.isEmpty());
    }

    @Test
    void load_requestsDataFromURL() throws MalformedURLException {
        URL url = new URL("https://any-url.com");
        HTTPClientSpy client = new HTTPClientSpy();
        RemoteRestaurantLoader sut = new RemoteRestaurantLoader(url, client);

        sut.load(url);

        assertEquals(client.requestedURLs, List.of(url));
    }

    @Test
    void loadTwice_requestsDataFromURLTwice() throws MalformedURLException {
        URL url = new URL("https://any-url.com");
        HTTPClientSpy client = new HTTPClientSpy();
        RemoteRestaurantLoader sut = new RemoteRestaurantLoader(url, client);

        sut.load(url);
        sut.load(url);

        assertEquals(client.requestedURLs, List.of(url, url));
    }
}

class HTTPClientSpy implements HTTPClient {
    List<URL> requestedURLs = new ArrayList<>();

    @Override
    public void get(URL url) {
        requestedURLs.add(url);
    }
}