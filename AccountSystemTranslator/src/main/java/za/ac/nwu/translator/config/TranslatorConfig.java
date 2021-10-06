package za.ac.nwu.translator.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import za.ac.nwu.repo.RepoConfig.RepoConfig;

@Import({RepoConfig.class})
@Configuration
@ComponentScan(basePackages = {"za.ac.nwu.translator"})
public class TranslatorConfig {
}
