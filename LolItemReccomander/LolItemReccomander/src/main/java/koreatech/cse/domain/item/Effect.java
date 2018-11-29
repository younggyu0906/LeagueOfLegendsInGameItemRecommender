
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
    "Effect1Amount",
    "Effect2Amount",
    "Effect3Amount",
    "Effect4Amount",
    "Effect5Amount",
    "Effect6Amount",
    "Effect7Amount"
})
public class Effect {

    @JsonProperty("Effect1Amount")
    private String effect1Amount;
    @JsonProperty("Effect2Amount")
    private String effect2Amount;
    @JsonProperty("Effect3Amount")
    private String effect3Amount;
    @JsonProperty("Effect4Amount")
    private String effect4Amount;
    @JsonProperty("Effect5Amount")
    private String effect5Amount;
    @JsonProperty("Effect6Amount")
    private String effect6Amount;
    @JsonProperty("Effect7Amount")
    private String effect7Amount;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("Effect1Amount")
    public String getEffect1Amount() {
        return effect1Amount;
    }

    @JsonProperty("Effect1Amount")
    public void setEffect1Amount(String effect1Amount) {
        this.effect1Amount = effect1Amount;
    }

    public Effect withEffect1Amount(String effect1Amount) {
        this.effect1Amount = effect1Amount;
        return this;
    }

    @JsonProperty("Effect2Amount")
    public String getEffect2Amount() {
        return effect2Amount;
    }

    @JsonProperty("Effect2Amount")
    public void setEffect2Amount(String effect2Amount) {
        this.effect2Amount = effect2Amount;
    }

    public Effect withEffect2Amount(String effect2Amount) {
        this.effect2Amount = effect2Amount;
        return this;
    }

    @JsonProperty("Effect3Amount")
    public String getEffect3Amount() {
        return effect3Amount;
    }

    @JsonProperty("Effect3Amount")
    public void setEffect3Amount(String effect3Amount) {
        this.effect3Amount = effect3Amount;
    }

    public Effect withEffect3Amount(String effect3Amount) {
        this.effect3Amount = effect3Amount;
        return this;
    }

    @JsonProperty("Effect4Amount")
    public String getEffect4Amount() {
        return effect4Amount;
    }

    @JsonProperty("Effect4Amount")
    public void setEffect4Amount(String effect4Amount) {
        this.effect4Amount = effect4Amount;
    }

    public Effect withEffect4Amount(String effect4Amount) {
        this.effect4Amount = effect4Amount;
        return this;
    }

    @JsonProperty("Effect5Amount")
    public String getEffect5Amount() {
        return effect5Amount;
    }

    @JsonProperty("Effect5Amount")
    public void setEffect5Amount(String effect5Amount) {
        this.effect5Amount = effect5Amount;
    }

    public Effect withEffect5Amount(String effect5Amount) {
        this.effect5Amount = effect5Amount;
        return this;
    }

    @JsonProperty("Effect6Amount")
    public String getEffect6Amount() {
        return effect6Amount;
    }

    @JsonProperty("Effect6Amount")
    public void setEffect6Amount(String effect6Amount) {
        this.effect6Amount = effect6Amount;
    }

    public Effect withEffect6Amount(String effect6Amount) {
        this.effect6Amount = effect6Amount;
        return this;
    }

    @JsonProperty("Effect7Amount")
    public String getEffect7Amount() {
        return effect7Amount;
    }

    @JsonProperty("Effect7Amount")
    public void setEffect7Amount(String effect7Amount) {
        this.effect7Amount = effect7Amount;
    }

    public Effect withEffect7Amount(String effect7Amount) {
        this.effect7Amount = effect7Amount;
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

    public Effect withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
