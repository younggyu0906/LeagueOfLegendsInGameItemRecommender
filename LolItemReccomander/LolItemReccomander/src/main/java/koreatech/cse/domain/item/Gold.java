
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
    "base",
    "total",
    "sell",
    "purchasable"
})
public class Gold {

    @JsonProperty("base")
    private Long base;
    @JsonProperty("total")
    private Long total;
    @JsonProperty("sell")
    private Long sell;
    @JsonProperty("purchasable")
    private Boolean purchasable;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("base")
    public Long getBase() {
        return base;
    }

    @JsonProperty("base")
    public void setBase(Long base) {
        this.base = base;
    }

    public Gold withBase(Long base) {
        this.base = base;
        return this;
    }

    @JsonProperty("total")
    public Long getTotal() {
        return total;
    }

    @JsonProperty("total")
    public void setTotal(Long total) {
        this.total = total;
    }

    public Gold withTotal(Long total) {
        this.total = total;
        return this;
    }

    @JsonProperty("sell")
    public Long getSell() {
        return sell;
    }

    @JsonProperty("sell")
    public void setSell(Long sell) {
        this.sell = sell;
    }

    public Gold withSell(Long sell) {
        this.sell = sell;
        return this;
    }

    @JsonProperty("purchasable")
    public Boolean getPurchasable() {
        return purchasable;
    }

    @JsonProperty("purchasable")
    public void setPurchasable(Boolean purchasable) {
        this.purchasable = purchasable;
    }

    public Gold withPurchasable(Boolean purchasable) {
        this.purchasable = purchasable;
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

    public Gold withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
