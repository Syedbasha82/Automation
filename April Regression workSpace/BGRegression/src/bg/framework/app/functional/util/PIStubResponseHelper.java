package bg.framework.app.functional.util;

import bg.framework.app.functional.common.ApplicationConfig;
import org.apache.commons.lang.StringUtils;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;

import static org.apache.commons.lang.StringUtils.isNotEmpty;
import static org.testng.Assert.fail;

public class PIStubResponseHelper {

    private static Properties commonProperties = new PropertyLoader("resources/common/common.properties").load();

    public void changeStubResponse(String stubService, String stubResponse) {
        DefaultHttpClient httpclient = new DefaultHttpClient();
        HttpGet httpget = new HttpGet(ApplicationConfig.STUB_URL + stubService + "/" + stubResponse);
        try {
            httpclient.execute(httpget);
        } catch (IOException e) {
            fail("Error Setting up stub responses");
        } finally {
            httpclient.getConnectionManager().shutdown();
        }
    }

    public void stubReset() {
        DefaultHttpClient httpclient = new DefaultHttpClient();
        HttpGet httpget = new HttpGet(ApplicationConfig.STUB_URL);
        try {
            httpclient.execute(httpget);
        } catch (IOException e) {
            fail("Error resetting stub response");
        } finally {
            httpclient.getConnectionManager().shutdown();
        }
    }

    public void setupStubResposesTo(Map<String, String> stubResponseMap) {
        if (isStubModeOn()) {
            for (String serviceName : stubResponseMap.keySet()) {
                changeStubResponse(serviceName, stubResponseMap.get(serviceName));
            }
        }
    }

    public static boolean isStubModeOn() {
        if (StringUtils.equals("true", getPiStubMode())) {
            return true;
        }
        return false;
    }

    private static String getPiStubMode() {
        if (isNotEmpty(System.getProperty("piStubMode"))) {
            return System.getProperty("piStubMode");
        }
        return commonProperties.getProperty("piStubMode");
    }
}
