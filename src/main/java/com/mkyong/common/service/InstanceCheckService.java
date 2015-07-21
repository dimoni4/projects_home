package com.mkyong.common.service;

import com.mkyong.common.entity.Project;
import com.mkyong.common.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class InstanceCheckService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private EmailSenderService emailSenderService;

    public void checkInstances() {
        for (Project project : projectRepository.getAllProjects()) {
            String url = project.getUrl();
            try {
                URL obj = new URL(url);

                HttpURLConnection con = (HttpURLConnection) obj.openConnection();

                con.setRequestMethod("GET");

                int responseCode = con.getResponseCode();
                System.out.println("\nSending 'GET' request to URL : " + url);
                System.out.println("Response Code : " + responseCode);

                BufferedReader in = new BufferedReader(
                        new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                System.out.println(response.toString());

                emailSenderService.send(project.getAuthor().getEmail(), "Проект "+project.getName(), "Проект не работает");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
