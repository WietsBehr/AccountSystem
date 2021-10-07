package za.ac.nwu.translator.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import za.ac.nwu.repo.RepoConfig.RepoConfig;
import za.ac.nwu.repo.persistence.BalanceRepo;

@Import({RepoConfig.class})
@Configuration
@ComponentScan(basePackages = {"za.ac.nwu.translator"})
public class TranslatorConfig {
}
