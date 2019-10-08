package com.epam.spring.util;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

//the bean has a conventional name: <prefix>-<fqn>
@ConfigurationProperties(prefix = "root")
@PropertySource("root.properties")
@Component
@Getter
@Setter
public class RootProperties {

    private Boolean enabled;
    private String text;
    private Integer number;
    private Child child;

    @Getter
    @Setter
    private static class Child {
        private List<String> textCollection;
        private List<String> indexedTextCollection;
        private Map<String, Integer> numberMap;
    }

}
