package com.hulahoopblue.blue.model.service;

import com.hulahoopblue.blue.model.dto.AddressDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Service
public class AddressService {

    @Value("${address.api-key}")
    private String apiKey;

    @Value("${address.api-url}")
    private String apiUrl;

    public List<AddressDTO> searchAddress(String keyword) throws Exception {
        String encodedKeyword = URLEncoder.encode(keyword, StandardCharsets.UTF_8);

        URI uri = UriComponentsBuilder.fromUriString(apiUrl)
                .queryParam("confmKey", apiKey)
                .queryParam("currentPage", 1)
                .queryParam("countPerPage", 10)
                .queryParam("keyword", encodedKeyword)
                .queryParam("resultType", "xml")
                .build()
                .toUri();

        RestTemplate restTemplate = new RestTemplate();
        String xmlResponse = restTemplate.getForObject(uri, String.class);

        // XML 파싱
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new java.io.ByteArrayInputStream(xmlResponse.getBytes(StandardCharsets.UTF_8)));

        NodeList jusoList = doc.getElementsByTagName("juso");
        List<AddressDTO> result = new ArrayList<>();

        for (int i = 0; i < jusoList.getLength(); i++) {
            String roadAddr = jusoList.item(i).getChildNodes().item(7).getTextContent(); // roadAddr 요소
            String jibunAddr = jusoList.item(i).getChildNodes().item(5).getTextContent(); // jibunAddr 요소
            result.add(new AddressDTO(roadAddr, jibunAddr));
        }

        return result;
    }
}
