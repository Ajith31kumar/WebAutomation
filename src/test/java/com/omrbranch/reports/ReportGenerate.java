package com.omrbranch.reports;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class ReportGenerate {
    
    public static void genetateJvmReport(String jsonFile) {
        
        File file = new File("target");

        Configuration configuration = new Configuration(file, "OMR Branch");
        configuration.addClassifications("OS", "Windows 11");
        configuration.addClassifications("Browser", "Chrome");
        configuration.addClassifications("Browser Version", "135");
        configuration.addClassifications("Sprint", "34");
        configuration.addClassifications("Test Type", "Regression");

        List<String> jsonFiles = new ArrayList<>();
        jsonFiles.add(jsonFile);

        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);

        reportBuilder.generateReports();
    }
}
