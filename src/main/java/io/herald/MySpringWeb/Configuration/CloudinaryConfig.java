package io.herald.MySpringWeb.Configuration;


import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudinaryConfig {
    @Bean
    public Cloudinary cloudinary() {

        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "ur6hep2o",
                "api_key", "351176364628562",
                "api_secret", "Afl6jNtwPVZdr91MH3rk9BsnuJQ",
                "secure", true));
    }

}
