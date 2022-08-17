package io.wybis.jqexperiment;

// import com.fasterxml.jackson.annotation.JsonProperty;

public class Operator {
//	@JsonProperty("OR")
//	OR("OR"), @JsonProperty("AND")
//	AND("AND");

	private String displayName;

	Operator(String displayName) {
		this.displayName = displayName;
	}

	public String getDisplayName() {
		return displayName;
	}

}
