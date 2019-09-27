package org.superbiz.struts;

import com.opensymphony.sitemesh.webapp.SiteMeshFilter;
import org.apache.struts2.dispatcher.filter.StrutsPrepareAndExecuteFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public FilterRegistrationBean<SiteMeshFilter> siteMeshFilter() {
        FilterRegistrationBean<SiteMeshFilter> meshFilter = new FilterRegistrationBean<SiteMeshFilter>();
        meshFilter.setFilter(new SiteMeshFilter());
        meshFilter.addUrlPatterns("/*");
        meshFilter.setOrder(100);
        return meshFilter;
    }
    @Bean
    public FilterRegistrationBean<StrutsPrepareAndExecuteFilter> filterFilterRegistrationBean() {
        FilterRegistrationBean<StrutsPrepareAndExecuteFilter> filter = new FilterRegistrationBean<StrutsPrepareAndExecuteFilter>();
        filter.setFilter(new StrutsPrepareAndExecuteFilter());
        filter.addUrlPatterns("/", "/addUserForm.action", "/addUser.action", "/findUserForm.action", "/findUser.action", "/listAllUsers.action");
        filter.setOrder(109);
        return filter;
    }
}
