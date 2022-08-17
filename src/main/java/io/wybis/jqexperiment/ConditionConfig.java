package io.wybis.jqexperiment;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Builder
@Data
public class ConditionConfig implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String uuid;

    private Integer status;

    private String conditionConfigurationId;

    private Integer ruleType;

    private Integer ruleOrder;

    private Integer group;

    private Operator conditionWithPrecedingGroup;

    private Integer order;

    private Operator conditionWithPrecedingSibling;

    private Integer conditionOperator;

    private Integer conditionKeyId;

    private FieldType conditionType;

    private Integer conditionOnType;

    private String conditionValue;

    private FieldType conditionFieldType;

    private Integer conditionFieldId;

    private String conditionKeyStepId;

    private String conditionFieldStepId;

    private Integer createdBy;

    private Date createdDate;

    private Integer updatedBy;

    private Date updatedDate;

    public String toString() {
        return ruleType + ":" + ruleOrder + ":" + group + ":" + order;
    }

}
