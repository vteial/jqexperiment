package io.wybis.jqexperiment;

// import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ActionDTO {

//	@JsonProperty("continue")
	private Boolean isContinue;

//	@JsonProperty("invokeStep")
	private String invokeStepConfigurationUuid;
	
}
