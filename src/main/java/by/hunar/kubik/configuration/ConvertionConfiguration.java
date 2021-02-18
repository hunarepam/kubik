package by.hunar.kubik.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.core.convert.support.GenericConversionService;

@Configuration
public class ConvertionConfiguration {

    @Bean
    public GenericConversionService conversionService() {
        return new DefaultConversionService();
    }
}
