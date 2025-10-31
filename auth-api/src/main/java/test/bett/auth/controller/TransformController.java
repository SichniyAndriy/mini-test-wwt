package test.bett.auth.controller;

import jakarta.validation.constraints.NotNull;
import java.net.URI;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
public class TransformController {

    @Value("${INTERNAL_TOKEN}")
    private String internalToken;

    @PostMapping({ "/transform", "/transform/"})
    public ResponseEntity<Map<String, String>> transform(
            @NotNull @RequestBody final Map<String, String> data
    ) {
        final String KEY  = "text";
        String s = data.get(KEY);

        RestTemplate restTemplate = new RestTemplate();
        RequestEntity<String> request = RequestEntity
                .post(URI.create("http://localhost:8081/api/transform/"))
                .contentType(MediaType.APPLICATION_JSON)
                .header("X-Internal-Token", internalToken)
                .body(s);
        ResponseEntity<String> exchanged = restTemplate.exchange(request, String.class);
        data.put(KEY, exchanged.getBody());
        return ResponseEntity.ok(data);
    }

}
