package io.wybis.jqexperiment;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RuleDTO {

	String type;
	Integer order;
	ActionDTO actions;
	List<ConditionGroupDTO> conditionGroups;

}
