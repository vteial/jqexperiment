package io.wybis.jqexperiment;

import java.util.Date;

//import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
//@Getter
//@Setter
//@NoArgsConstructor
public class ConditionDTO {

	String uuid;
	
	Integer order;
	
	Operator conditionWithPrecedingSibling;
	
	String conditionKeyId;
	
	String conditionOperator;
	
	String conditionOnType;
	
	FieldType conditionType;
	
//	@JsonInclude(JsonInclude.Include.NON_NULL)
	String conditionValue;
	
	FieldType conditionFieldType;
	
//	@JsonInclude(JsonInclude.Include.NON_NULL)
	String conditionFieldId;
	
//	@JsonInclude(JsonInclude.Include.NON_NULL)
	String conditionKeyStepId;
	
//	@JsonInclude(JsonInclude.Include.NON_NULL)
	String conditionFieldStepId;
	
	String conditionConfigurationId;
	
//	@JsonInclude(JsonInclude.Include.NON_NULL)
	Integer createdBy;
	
//	@JsonInclude(JsonInclude.Include.NON_NULL)
	Integer updatedBy;
	
//	@JsonInclude(JsonInclude.Include.NON_NULL)
	Date createdAt;
	
//	@JsonInclude(JsonInclude.Include.NON_NULL)
	Date updatedAt;

}
