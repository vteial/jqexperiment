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
        log.info("-------------------------------------");

		List<ConditionGroupDTO> cgs = new ArrayList<>();

		int gcount = 1;
		ConditionGroupDTO cg = ConditionGroupDTO.builder()
				.group(gcount)
				.build();
		int ccount = 1;
		ConditionDTO c = ConditionDTO.builder()
				.order(ccount)
				.conditionOperator("=")
				.conditionKeyType("REQUESTHEADERS")
				.conditionKey("gender")
				.conditionOnType("value")
				.conditionValue("male")
				.build();
		cg.conditions.add(c);
		ccount++;
		c = ConditionDTO.builder()
				.order(ccount)
				.conditionWithPrecedingSibling(new Operator("AND"))
				.conditionOperator("=")
				.conditionKeyType("REQUESTHEADERS")
				.conditionKey("name")
				.conditionOnType("value")
				.conditionValue("john")
				.build();
		cg.conditions.add(c);
		cgs.add(cg);

//		gcount++;
//		cg = ConditionGroupDTO.builder()
//				.conditionWithPrecedingGroup(new Operator("AND"))
//				.group(gcount)
//				.build();
//		ccount = 1;
//		ConditionDTO c = ConditionDTO.builder()
//				.order(ccount)
//				.conditionOperator("=")
//				.conditionKeyType("REQUESTHEADERS")
//				.conditionKey("gender")
//				.conditionOnType("value")
//				.conditionValue("male")
//				.build();
//		cg.conditions.add(c);
//		ccount++;
//		c = ConditionDTO.builder()
//				.order(ccount)
//				.conditionWithPrecedingSibling(new Operator("AND"))
//				.conditionOperator("=")
//				.conditionKeyType("REQUESTHEADERS")
//				.conditionKey("name")
//				.conditionOnType("value")
//				.conditionValue("john")
//				.build();
//		cg.conditions.add(c);
//		cgs.add(cg);



		String jqQuery = this.computeJQ(cgs);
		log.info("JQ Query : {}", jqQuery);

        log.info("-------------------------------------");
    }

	String computeJQ(List<ConditionGroupDTO> cgs) {
		StringBuilder jqQuery = new StringBuilder("jq '");

		for(ConditionGroupDTO cg : cgs) {

		}

		jqQuery.append("'");
		return jqQuery.toString();
	}
}
