package com.veev.veev_demo.schedule;

import com.veev.veev_demo.dto.MembersDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Slf4j
@AllArgsConstructor
public class LogScheduler {

    private final String url;

    private final RestTemplate restTemplate;

    @Scheduled(fixedRate = 10, timeUnit = TimeUnit.SECONDS)
    public void reportLog() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<MembersDTO> membersResponse = restTemplate.exchange(url, HttpMethod.GET, entity, MembersDTO.class);
        log.info("Got statuses {}", membersResponse.getBody());
    }
}
