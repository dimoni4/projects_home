package com.project.home.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CheckerConnector {
    public Response send(String url) throws Exception{
        HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
        con.setRequestMethod("GET");

        int responseCode = con.getResponseCode();

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        return new Response(response.toString(), responseCode);
    }

    public static class Response {
        private String body;
        private int code;

        public Response(String responseBody, int responseCode) {
            body = responseBody;
            code = responseCode;
        }

        public String getResponseBody() {
            return body;
        }

        public int getResponseCode() {
            return code;
        }
    }
}
