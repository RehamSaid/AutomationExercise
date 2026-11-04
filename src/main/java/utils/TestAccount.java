package utils;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Makes sure the account in config.properties exists on automationexercise.com
 * before the tests run, using the site's public API (API 11: POST /api/createAccount).
 * If the account already exists the API answers "Email already exists!" and nothing changes.
 */
public class TestAccount {

    private static boolean ensured = false;

    private TestAccount() {
    }

    public static synchronized void ensureExists() {
        if (ensured) {
            return;
        }

        Map<String, String> form = new LinkedHashMap<>();
        form.put("name", ConfigReader.getUserName());
        form.put("email", ConfigReader.getUserEmail());
        form.put("password", ConfigReader.getUserPassword());
        form.put("title", "Mrs");
        form.put("birth_date", "15");
        form.put("birth_month", "June");
        form.put("birth_year", "2001");
        form.put("firstname", "Reham");
        form.put("lastname", "Elshakra");
        form.put("company", "QA Testing");
        form.put("address1", "Smouha, Alexandria");
        form.put("address2", "");
        form.put("country", "Canada");
        form.put("zipcode", "21500");
        form.put("state", "Alexandria");
        form.put("city", "Alexandria");
        form.put("mobile_number", "01012345678");

        String body = form.entrySet().stream()
                .map(e -> encode(e.getKey()) + "=" + encode(e.getValue()))
                .collect(Collectors.joining("&"));

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(ConfigReader.getBaseUrl() + "/api/createAccount"))
                .timeout(Duration.ofSeconds(30))
                .header("Content-Type", "application/x-www-form-urlencoded")
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .build();

        try {
            HttpResponse<String> response = HttpClient.newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("[TestAccount] " + ConfigReader.getUserEmail() + " -> " + response.body());
        } catch (Exception e) {
            System.out.println("[TestAccount] Could not create test account: " + e.getMessage());
        }
        ensured = true;
    }

    private static String encode(String value) {
        return URLEncoder.encode(value, StandardCharsets.UTF_8);
    }
}
