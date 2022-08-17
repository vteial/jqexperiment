package io.wybis.jqexperiment;

//import com.fasterxml.jackson.annotation.JsonProperty;

public class FieldType {
//	@JsonProperty("RequestHeader")
//	REQUEST_HEADER("RequestHeader"), @JsonProperty("ResponseHeader")
//	RESPONSE_HEADER("ResponseHeader"), @JsonProperty("QueryParam")
//	QUERY_PARAM("QueryParam"), @JsonProperty("PathParam")
//	PATH_PARAM("PathParam"), @JsonProperty("RequestBody")
//	REQUEST_BODY("RequestBody"), @JsonProperty("Response")
//	RESPONSE("Response");

	private String displayName;

	FieldType(String displayName) {
		this.displayName = displayName;
	}

	public String getDisplayName() {
		return displayName;
	}

}
