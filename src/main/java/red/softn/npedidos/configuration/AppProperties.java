package red.softn.npedidos.configuration;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class AppProperties {
    
    @Value("${app.http.path.prefix}")
    private String pathPrefix;
    
    @Value("${app.security.jwt.secret}")
    private String secretKey;
    
    @Value("${app.name}")
    private String appName;
    
    @Value("${app.description}")
    private String appDescription;
    
    @Value("${app.version:0}")
    private String appVersion;
    
    @Value("${app.licenses.name}")
    private String appLicensesName;
    
    @Value("${app.licenses.url:}")
    private String appLicensesUrl;
    
    @Value("${app.http.paths.permit-all:}")
    private String[] permitAllPaths;
    
    @Value("${app.pageable.size:10}")
    private int pageableSize;
    
    @Value("${app.jwt.expires-at:36000}")
    private long jwtExpiresAt;
    
    @Value("${app.jwt.issuer:self}")
    private String jwtIssuer;
    
}
