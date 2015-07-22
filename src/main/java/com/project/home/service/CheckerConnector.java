package com.project.home.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CheckerConnector {
    public Response send(String url) {
        Response checkerConnectorResponse = new Response();
        try {
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

            checkerConnectorResponse.setResponseBody(response.toString());
            checkerConnectorResponse.setResponseCode(responseCode);
            checkerConnectorResponse.setSuccess();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return checkerConnectorResponse;
    }

    public static class Response {
        private String body;
        private int code;
        private Boolean isSuccess;

        public Response() {
            body = "";
            code = 0;
            isSuccess = false;
        }

        public String getResponseBody() {
            return body;
        }

        public void setResponseBody(String responseBody) {
            this.body = responseBody;
        }

        public int getResponseCode() {
            return code;
        }

        public void setResponseCode(int responseCode) {
            this.code = responseCode;
        }

        public Boolean isSuccess() {
            return isSuccess;
        }

        public void setSuccess() {
            this.isSuccess = true;
        }
    }
}
