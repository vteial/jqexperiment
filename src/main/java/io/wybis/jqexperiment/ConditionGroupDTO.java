package io.wybis.jqexperiment;

import java.util.List;

import lombok.*;

@Data
@Builder
public class ConditionGroupDTO {

	List<ConditionDTO> conditions;

	Operator conditionWithPrecedingGroup;

	Integer group;
}
