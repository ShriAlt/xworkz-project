package com.xworkz.techRoute.init;

import com.xworkz.techRoute.configuration.SwaggerConfiguration;
import com.xworkz.techRoute.configuration.WebAppConfiguration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    public WebInit(){
        System.out.println("no args of WebInit");
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
