package jdbc.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.servlet.Servlet;
import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DruidCondig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource(){
        return  new DruidDataSource();
    }
    //配置监控
    //配置一个管理后台的servlet
    @Bean
    public ServletRegistrationBean<Servlet> druidServlet(){
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
        Map<String, String> initParameters = new HashMap<>();
         /*public static final String PARAM_NAME_USERNAME = "loginUsername";
        public static final String PARAM_NAME_PASSWORD = "loginPassword";
        public static final String PARAM_NAME_ALLOW = "allow";
        public static final String PARAM_NAME_DENY = "deny";
        public static final String PARAM_REMOTE_ADDR = "remoteAddress";
        */
        initParameters.put("loginUsername","root");
        initParameters.put("loginPassword","admin");
        initParameters.put("allow","127.0.0.1");//默认允许全部访问
        //initParameters.put("deny","");
        bean.setInitParameters(initParameters);
        return bean;
    }
    //配置一个监控filter
    @Bean
    public FilterRegistrationBean<Filter> druidFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());
        Map<String, String> initParameters = new HashMap<>();
        initParameters.put("exclusions","*.css,*.js,/druid/*");
        bean.setInitParameters(initParameters);
        bean.setUrlPatterns(Arrays.asList("/*"));
        return bean;
    }
}
