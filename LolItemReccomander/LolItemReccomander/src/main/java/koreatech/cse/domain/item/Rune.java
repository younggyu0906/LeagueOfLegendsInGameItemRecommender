
package koreatech.cse.domain.item;

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
    "isrune",
    "tier",
    "type"
})
public class Rune {

    @JsonProperty("isrune")
    private Boolean isrune;
    @JsonProperty("tier")
    private Long tier;
    @JsonProperty("type")
    private String type;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("isrune")
    public Boolean getIsrune() {
        return isrune;
    }

    @JsonProperty("isrune")
    public void setIsrune(Boolean isrune) {
        this.isrune = isrune;
    }

    public Rune withIsrune(Boolean isrune) {
        this.isrune = isrune;
        return this;
    }

    @JsonProperty("tier")
    public Long getTier() {
        return tier;
    }

    @JsonProperty("tier")
    public void setTier(Long tier) {
        this.tier = tier;
    }

    public Rune withTier(Long tier) {
        this.tier = tier;
        return this;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    public Rune withType(String type) {
        this.type = type;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public Rune withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
