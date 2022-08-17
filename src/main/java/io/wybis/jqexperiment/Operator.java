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

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Operator Enum.
 * 
 * @author A Kamil Khan
 * @version 1.0
 * @since 01/20/2022
 */
public enum Operator {
	@JsonProperty("OR")
	OR("OR"), @JsonProperty("AND")
	AND("AND");

	private String displayName;

	Operator(String displayName) {
		this.displayName = displayName;
	}

	public String getDisplayName() {
		return displayName;
	}

}
