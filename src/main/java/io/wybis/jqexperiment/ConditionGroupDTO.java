package io.wybis.jqexperiment;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ConditionGroupDTO {

	List<ConditionDTO> conditions;
	Operator conditionWithPrecedingGroup;
	Integer group;
}
