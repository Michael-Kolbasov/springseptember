package com.epam.spring.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.util.Collection;

/**
 * Works for servlet 3.0 environment;
 * If lower, use web.xml
 *
 * AbstractAnnotationConfigDispatcherServletInitializer contains all basic configuration.
 * see AbstractAnnotationConfigDispatcherServletInitializer.onStartup() - WebApplicationContext and Dispatcher servlet created there.
 */
public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext);

        System.out.println("servletContext.getContextPath() = " + servletContext.getContextPath());
        System.out.println("servletContext.getServerInfo() = " + servletContext.getServerInfo());
        servletContext.getServletRegistrations().forEach((servletName, servletRegistration) -> {
            System.out.print(servletName + " === ");
            Collection<String> mappings = servletRegistration.getMappings();
            mappings.forEach(element -> System.out.print(element + " ::: "));
        });
        System.out.println();
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null;
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
