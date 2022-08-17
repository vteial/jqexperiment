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

		List<ConditionDTO> ccs = new ArrayList<>();
		ConditionDTO conditionDTO = ConditionDTO.builder()
				.conditionKeyId("gender")
				.conditionOperator("=")
				.conditionValue("male")
				.build();
		ccs.add(conditionDTO);
		String jqQuery = this.computeJQ(ccs);
		log.info("JQ Query : {}", jqQuery);

        log.info("-----------------------------------------------");
    }

	String computeJQ(List<ConditionDTO> conditions) {
		StringBuilder jqQuery = new StringBuilder("jq '");

		for(ConditionDTO condition : conditions) {

		}

		jqQuery.append("'");
		return jqQuery.toString();
	}
}
