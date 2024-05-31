package com.zhaojj11.jam.user.configuration;


import java.util.Optional;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;

@Configuration
public class UserAuditor implements AuditorAware<Long> {

    /**
     * 默认的创建人.
     *
     * @return
     */
    @Override
    public Optional<Long> getCurrentAuditor() {
        return Optional.of(0L);
    }
}

