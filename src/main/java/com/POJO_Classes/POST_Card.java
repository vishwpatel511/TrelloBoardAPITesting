package com.POJO_Classes;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"name",
"defaultLabels",
"defaultLists",
"desc"
})

public class POST_Card {

@JsonProperty("name")
private String name;
@JsonProperty("defaultLabels")
private Boolean defaultLabels;
@JsonProperty("defaultLists")
private Boolean defaultLists;
@JsonProperty("desc")
private String desc;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("name")
public String getName() {
return name;
}

@JsonProperty("name")
public void setName(String name) {
this.name = name;
}

@JsonProperty("defaultLabels")
public Boolean getDefaultLabels() {
return defaultLabels;
}

@JsonProperty("defaultLabels")
public void setDefaultLabels(Boolean defaultLabels) {
this.defaultLabels = defaultLabels;
}

@JsonProperty("defaultLists")
public Boolean getDefaultLists() {
return defaultLists;
}

@JsonProperty("defaultLists")
public void setDefaultLists(Boolean defaultLists) {
this.defaultLists = defaultLists;
}

@JsonProperty("desc")
public String getDesc() {
return desc;
}

@JsonProperty("desc")
public void setDesc(String desc) {
this.desc = desc;
}

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}