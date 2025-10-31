package test.bett.data.service.impl;

import org.springframework.stereotype.Service;
import test.bett.data.service.TransformService;


@Service
public class TransformServiceImpl implements TransformService {

    @Override
    public String transform(String data) {
        if (data == null) {
            return null;
        }
        return data.replaceAll("(?i)[aeiou]", "*");
    }

}
