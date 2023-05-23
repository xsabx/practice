package com.visma.testtask;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.visma.testtask.dto.InstitutionDto;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class TestTaskApplicationTests {

    private final String baseUrl = "http://localhost:8080/institutions";

    List<String> typesLV = Arrays.asList("Fiziska persona", "Ministrija", "Pašvaldības iestāde",
            "Universitāte (akadēmija)", "Valsts iestāde", "Ārvalsts filiāle");
    List<String> typesEN = Arrays.asList("Natural person", "Ministry", "Local Government Institution",
            "University (Academy)", "State Institution", "Foreign branch");

    @Test
    public void all_institutions_are_returned_lv() throws IOException {
        String url = String.join("", baseUrl, "?language=LV");
        List<InstitutionDto> list = executeRequest(url);
        Assertions.assertEquals(6, list.size(), "Nepareizs iestāžu skaits");
        list.forEach(l -> {
            Optional<String> o = typesLV.stream().filter(t -> t.equals(l.getType())).findFirst();
            Assertions.assertTrue(o.isPresent(), "Nepareizs LV tulkojums iestādei " + l.getName());
        });
    }

    @Test
    public void all_institutions_are_returned_en() throws IOException {
        String url = String.join("", baseUrl, "?language=EN");
        List<InstitutionDto> list = executeRequest(url);
        Assertions.assertEquals(6, list.size(), "Nepareizs iestāžu skaits");
        list.forEach(l -> {
            Optional<String> o = typesEN.stream().filter(t -> t.equals(l.getType())).findFirst();
            Assertions.assertTrue(o.isPresent(), "Nepareizs EN tulkojums iestādei " + l.getName());
        });
    }

    @Test
    public void all_active_are_returned_lv() throws IOException {
        String url = String.join("", baseUrl, "?language=LV", "&status=ACTIVE");
        List<InstitutionDto> list = executeRequest(url);
        Assertions.assertEquals(5, list.size(), "Nepareizs iestāžu skaits");
        list.forEach(l -> {
            Optional<String> o = typesLV.stream().filter(t -> t.equals(l.getType())).findFirst();
            Assertions.assertTrue(o.isPresent(), "Nepareizs LV tulkojums iestādei " + l.getName());
        });
    }

    @Test
    public void all_active_are_returned_en() throws IOException {
        String url = String.join("", baseUrl, "?language=EN", "&status=ACTIVE");
        List<InstitutionDto> list = executeRequest(url);
        Assertions.assertEquals(5, list.size(), "Nepareizs iestāžu skaits");
        list.forEach(l -> {
            Optional<String> o = typesEN.stream().filter(t -> t.equals(l.getType())).findFirst();
            Assertions.assertTrue(o.isPresent(), "Nepareizs EN tulkojums iestādei " + l.getName());
        });
    }


    @Test
    public void all_inactive_are_returned_lv() throws IOException {
        String url = String.join("", baseUrl, "?language=LV", "&status=INACTIVE");
        List<InstitutionDto> list = executeRequest(url);
        Assertions.assertEquals(1, list.size(), "Nepareizs iestāžu skaits");
        InstitutionDto institution = list.get(0);
        Assertions.assertEquals(institution.getName(), "Neaktīva filiāle");
        Assertions.assertEquals(institution.getRegNum(), "40000000006");
        Assertions.assertNotNull(institution.getRegDate());
        Assertions.assertEquals(institution.getRegDate().toLocalDate(), LocalDate.of(2011, 9, 23));
        Assertions.assertEquals(institution.getType(), "Ārvalsts filiāle");
    }

    @Test
    public void all_inactive_are_returned_en() throws IOException {
        String url = String.join("", baseUrl, "?language=EN", "&status=INACTIVE");
        List<InstitutionDto> list = executeRequest(url);
        Assertions.assertEquals(1, list.size(), "Nepareizs iestāžu skaits");
        InstitutionDto institution = list.get(0);
        Assertions.assertEquals(institution.getName(), "Neaktīva filiāle");
        Assertions.assertEquals(institution.getRegNum(), "40000000006");
        Assertions.assertNotNull(institution.getRegDate());
        Assertions.assertEquals(institution.getRegDate().toLocalDate(), LocalDate.of(2011, 9, 23));
        Assertions.assertEquals(institution.getType(), "Foreign branch");
    }


    private List<InstitutionDto> executeRequest(String url) throws IOException {
        HttpUriRequest request = new HttpGet(url);
        HttpResponse response = HttpClientBuilder.create().build().execute(request);
        String json = EntityUtils.toString(response.getEntity());
        ObjectMapper mapper = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper.readValue(json, new TypeReference<List<InstitutionDto>>() {
        });
    }
}
