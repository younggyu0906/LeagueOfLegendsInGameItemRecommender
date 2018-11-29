
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
    "1",
    "8",
    "10",
    "12"
})
public class Maps {

    @JsonProperty("1")
    private Boolean _1;
    @JsonProperty("8")
    private Boolean _8;
    @JsonProperty("10")
    private Boolean _10;
    @JsonProperty("12")
    private Boolean _12;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("1")
    public Boolean get1() {
        return _1;
    }

    @JsonProperty("1")
    public void set1(Boolean _1) {
        this._1 = _1;
    }

    public Maps with1(Boolean _1) {
        this._1 = _1;
        return this;
    }

    @JsonProperty("8")
    public Boolean get8() {
        return _8;
    }

    @JsonProperty("8")
    public void set8(Boolean _8) {
        this._8 = _8;
    }

    public Maps with8(Boolean _8) {
        this._8 = _8;
        return this;
    }

    @JsonProperty("10")
    public Boolean get10() {
        return _10;
    }

    @JsonProperty("10")
    public void set10(Boolean _10) {
        this._10 = _10;
    }

    public Maps with10(Boolean _10) {
        this._10 = _10;
        return this;
    }

    @JsonProperty("12")
    public Boolean get12() {
        return _12;
    }

    @JsonProperty("12")
    public void set12(Boolean _12) {
        this._12 = _12;
    }

    public Maps with12(Boolean _12) {
        this._12 = _12;
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

    public Maps withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
