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
 * Field Type enum
 * 
 * @author A Kamil Khan
 * @version 1.0
 * @since 01/20/2022
 */

public enum FieldType {
	@JsonProperty("RequestHeader")
	REQUEST_HEADER("RequestHeader"), @JsonProperty("ResponseHeader")
	RESPONSE_HEADER("ResponseHeader"), @JsonProperty("QueryParam")
	QUERY_PARAM("QueryParam"), @JsonProperty("PathParam")
	PATH_PARAM("PathParam"), @JsonProperty("RequestBody")
	REQUEST_BODY("RequestBody"), @JsonProperty("Response")
	RESPONSE("Response");

	private String displayName;

	FieldType(String displayName) {
		this.displayName = displayName;
	}

	public String getDisplayName() {
		return displayName;
	}

}
