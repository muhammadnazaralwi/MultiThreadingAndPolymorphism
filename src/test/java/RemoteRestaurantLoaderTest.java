import org.junit.jupiter.api.Test;

import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

class RemoteRestaurantLoaderTest {
    @Test
    void constructor_doesNotPerformAnyRequest() {
        HTTPClientSpy client = new HTTPClientSpy();
        RemoteRestaurantLoader sut = new RemoteRestaurantLoader(client);

        assertEquals(client.loadCallCount, 0);
    }
}

class HTTPClientSpy implements HTTPClient {
    int loadCallCount = 0;

    @Override
    public void get(URL url) {
        loadCallCount++;
    }
}