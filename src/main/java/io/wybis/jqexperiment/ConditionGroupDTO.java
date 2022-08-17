/*
 * N2N Services Inc. CONFIDENTIAL
 *
 * All Rights Reserved.
 *
 * NOTICE:  All information contained here in is, and remains the property of N2N Services Inc.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained from N2N Services Inc.
 *
 */
package io.wybis.jqexperiment;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
/**
 * DTO Class for Conditional Configuration Group.
 * 
 * @author A Kamil Khan
 * @version 1.0
 * @since 01/20/2022
 */
public class ConditionGroupDTO {

	List<ConditionDTO> conditions;
	Operator conditionWithPrecedingGroup;
	Integer group;
}
