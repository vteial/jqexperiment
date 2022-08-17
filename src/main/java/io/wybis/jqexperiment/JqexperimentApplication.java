package io.wybis.jqexperiment;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@SpringBootApplication
public class JqexperimentApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(JqexperimentApplication.class, args);
    }

    @Override
    public void run(String... args) {
        log.info("-----------------------------------------------");

		List<ConditionConfig> ccs = new ArrayList<>();
		ConditionConfig cc = ConditionConfig.builder()
				.conditionKeyId("gender")
				.conditionOperator("=")
				.conditionValue("male")
				.build();
		ccs.add(cc);
		String jqQuery = this.computeJQ(ccs);
		log.info("JQ Query : {}", jqQuery);

        log.info("-----------------------------------------------");
    }

	String computeJQ(List<ConditionConfig> ccs) {
		StringBuilder jqQuery = new StringBuilder("jq '");

		for(ConditionConfig cc : ccs) {

		}

		jqQuery.append("'");
		return jqQuery.toString();
	}
}
