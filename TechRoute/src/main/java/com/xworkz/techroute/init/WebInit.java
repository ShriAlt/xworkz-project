package com.xworkz.techroute.init;

import com.xworkz.techroute.configuration.SwaggerConfiguration;
import com.xworkz.techroute.configuration.WebAppConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

@Slf4j
public class WebInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    public WebInit(){
        log.info("no args of WebInit");
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[0];
    }
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{WebAppConfiguration.class, SwaggerConfiguration.class};
    }
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
