package com.project.home.service;

import com.project.home.models.entity.*;
import com.project.home.repository.ViolationRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Service
public class ViolationsService {

    @Autowired
    private ViolationRepository violationRepository;

    public List<ViolationsEntry> violationsChartData(long projectId) {
        List<ViolationsEntry> violationsEntryList = new ArrayList<ViolationsEntry>();
        for (Violation violation : violationRepository.findByProjectId(projectId)) {
            violationsEntryList.add(new ViolationsEntry(violation.getDateTime()));
        }
        return violationsEntryList;
    }

    public List<ViolationsEntry> violationsChartData() {
        List<ViolationsEntry> violationsEntryList = new ArrayList<ViolationsEntry>();
        for (Violation violation : violationRepository.findAll()) {
            violationsEntryList.add(new ViolationsEntry(violation.getDateTime()));
        }
        return violationsEntryList;
    }
}
