package test.bett.data.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.bett.data.service.TransformService;

@RestController
@RequestMapping("/api")
public class TransformController {

    @Value("${INTERNAL_TOKEN}")
    private String internalToken;

    private final TransformService transformService;

    public TransformController(
            @Autowired TransformService transformService
    ) {
        this.transformService = transformService;
    }

    @PostMapping({ "/transform", "/transform/" })
    public ResponseEntity<String> transform(
            @RequestBody String text,
            HttpServletRequest request
    ) {
        if (request.getHeader("X-Internal-Token").equals(internalToken)) {
            String transformed = transformService.transform(text);
            return ResponseEntity.ok().body(transformed);
        }
        return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }

}
