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
				.conditions(new ArrayList<>())
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

		gcount++;
		cg = ConditionGroupDTO.builder()
				.conditionWithPrecedingGroup(new Operator("AND"))
				.group(gcount)
				.conditions(new ArrayList<>())
				.build();
		ccount = 1;
		c = ConditionDTO.builder()
				.order(ccount)
				.conditionOperator("=")
				.conditionKeyType("QUERYPARAMETERS")
				.conditionKey("degree")
				.conditionOnType("value")
				.conditionValue("bsc")
				.build();
		cg.conditions.add(c);
		ccount++;
		c = ConditionDTO.builder()
				.order(ccount)
				.conditionWithPrecedingSibling(new Operator("OR"))
				.conditionOperator("=")
				.conditionKeyType("QUERYPARAMETERS")
				.conditionKey("age")
				.conditionOnType("value")
				.conditionValue("45")
				.build();
		cg.conditions.add(c);
		cgs.add(cg);

		gcount++;
		cg = ConditionGroupDTO.builder()
				.conditionWithPrecedingGroup(new Operator("AND"))
				.group(gcount)
				.conditions(new ArrayList<>())
				.build();
		ccount = 1;
		c = ConditionDTO.builder()
				.order(ccount)
				.conditionOperator("=")
				.conditionKeyType("REQUESTBODY")
				.conditionKey("author.following_url")
				.conditionOnType("value")
				.conditionValue("a.com")
				.build();
		cg.conditions.add(c);
		cgs.add(cg);

		String jqQuery = this.computeJQFromGroups(cgs);
//		log.info("JQ Query : {}", jqQuery);
		System.out.println("JQ Query : " + jqQuery);

        log.info("-------------------------------------");
    }
/*
	EXPECTED
	map(select((.requestHeaders.gender == "male" and .requestHeaders.name == "john") and (.queryParameters.degree == "bsc" or .aueryParameters.age == "45") and .requestBody.author.following_url == "a.com"))
	ARRIVED
	map(select((.REQUESTHEADERS.gender == "male" AND .REQUESTHEADERS.name == "john") AND (.QUERYPARAMETERS.degree == "bsc" OR .QUERYPARAMETERS.age == "45") AND .REQUESTBODY.author.following_url == "a.com"))
*/
	String computeJQFromGroups(List<ConditionGroupDTO> cgs) {
		StringBuilder jq = new StringBuilder("jq '");

		jq.append("map(select(");
		for(ConditionGroupDTO cg : cgs) {
			if(cg.conditionWithPrecedingGroup != null) {
				jq.append(" ");
				jq.append(cg.conditionWithPrecedingGroup.getDisplayName());
				jq.append(" ");
			}
			jq.append(this.computeJQFromConditions(cg.conditions));
		}
		jq.append("))");

		jq.append("'");
		return jq.toString();
	}
	// exepected = map(select(.requestHeaders.gender == "male" and .requestHeaders.name == "john"))
	// arrived   = map(select(.REQUESTHEADERS.gender == "male" AND .REQUESTHEADERS.name == "john"))
	String computeJQFromConditions(List<ConditionDTO> cs) {
		StringBuilder jq = new StringBuilder();
		if(cs.size() > 1) jq.append("(");
		for(ConditionDTO c : cs) {
			if(c.conditionWithPrecedingSibling != null) {
				jq.append(" ");
				jq.append(c.conditionWithPrecedingSibling.getDisplayName());
				jq.append(" ");
			}
			jq.append(".");
			jq.append(c.conditionKeyType);
			jq.append(".");
			jq.append(c.conditionKey);
			if(c.conditionOperator.equals("=")) jq.append(" == ");
			jq.append("\"");
			jq.append(c.conditionValue);
			jq.append("\"");
		}
		if(cs.size() > 1) jq.append(")");

		return jq.toString();
	}

}
