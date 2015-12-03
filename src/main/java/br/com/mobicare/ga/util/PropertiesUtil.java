package br.com.mobicare.ga.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class PropertiesUtil extends PropertyPlaceholderConfigurer {

    @Autowired
    ApplicationContext applicationContext;

    public boolean containsProperty(String propertyName) {
        return applicationContext.getEnvironment().containsProperty(propertyName);
    }

    public String getProperty(String propertyName) {
        if (!containsProperty(propertyName)) {
            return null;
        }

        return applicationContext.getEnvironment().getProperty(propertyName);
    }

}
