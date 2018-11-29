
package koreatech.cse.domain.item;

import java.util.HashMap;
import java.util.List;
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
    "rune",
    "gold",
    "group",
    "description",
    "colloq",
    "plaintext",
    "consumed",
    "stacks",
    "depth",
    "consumeOnFull",
    "from",
    "into",
    "specialRecipe",
    "inStore",
    "hideFromAll",
    "requiredChampion",
    "stats",
    "tags",
    "maps"
})
public class Basic {

    @JsonProperty("name")
    private String name;
    @JsonProperty("rune")
    private Rune rune;
    @JsonProperty("gold")
    private Gold gold;
    @JsonProperty("group")
    private String group;
    @JsonProperty("description")
    private String description;
    @JsonProperty("colloq")
    private String colloq;
    @JsonProperty("plaintext")
    private String plaintext;
    @JsonProperty("consumed")
    private Boolean consumed;
    @JsonProperty("stacks")
    private Long stacks;
    @JsonProperty("depth")
    private Long depth;
    @JsonProperty("consumeOnFull")
    private Boolean consumeOnFull;
    @JsonProperty("from")
    private List<Object> from = null;
    @JsonProperty("into")
    private List<Object> into = null;
    @JsonProperty("specialRecipe")
    private Long specialRecipe;
    @JsonProperty("inStore")
    private Boolean inStore;
    @JsonProperty("hideFromAll")
    private Boolean hideFromAll;
    @JsonProperty("requiredChampion")
    private String requiredChampion;
    @JsonProperty("stats")
    private Stats stats;
    @JsonProperty("tags")
    private List<Object> tags = null;
    @JsonProperty("maps")
    private Maps maps;
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

    public Basic withName(String name) {
        this.name = name;
        return this;
    }

    @JsonProperty("rune")
    public Rune getRune() {
        return rune;
    }

    @JsonProperty("rune")
    public void setRune(Rune rune) {
        this.rune = rune;
    }

    public Basic withRune(Rune rune) {
        this.rune = rune;
        return this;
    }

    @JsonProperty("gold")
    public Gold getGold() {
        return gold;
    }

    @JsonProperty("gold")
    public void setGold(Gold gold) {
        this.gold = gold;
    }

    public Basic withGold(Gold gold) {
        this.gold = gold;
        return this;
    }

    @JsonProperty("group")
    public String getGroup() {
        return group;
    }

    @JsonProperty("group")
    public void setGroup(String group) {
        this.group = group;
    }

    public Basic withGroup(String group) {
        this.group = group;
        return this;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    public Basic withDescription(String description) {
        this.description = description;
        return this;
    }

    @JsonProperty("colloq")
    public String getColloq() {
        return colloq;
    }

    @JsonProperty("colloq")
    public void setColloq(String colloq) {
        this.colloq = colloq;
    }

    public Basic withColloq(String colloq) {
        this.colloq = colloq;
        return this;
    }

    @JsonProperty("plaintext")
    public String getPlaintext() {
        return plaintext;
    }

    @JsonProperty("plaintext")
    public void setPlaintext(String plaintext) {
        this.plaintext = plaintext;
    }

    public Basic withPlaintext(String plaintext) {
        this.plaintext = plaintext;
        return this;
    }

    @JsonProperty("consumed")
    public Boolean getConsumed() {
        return consumed;
    }

    @JsonProperty("consumed")
    public void setConsumed(Boolean consumed) {
        this.consumed = consumed;
    }

    public Basic withConsumed(Boolean consumed) {
        this.consumed = consumed;
        return this;
    }

    @JsonProperty("stacks")
    public Long getStacks() {
        return stacks;
    }

    @JsonProperty("stacks")
    public void setStacks(Long stacks) {
        this.stacks = stacks;
    }

    public Basic withStacks(Long stacks) {
        this.stacks = stacks;
        return this;
    }

    @JsonProperty("depth")
    public Long getDepth() {
        return depth;
    }

    @JsonProperty("depth")
    public void setDepth(Long depth) {
        this.depth = depth;
    }

    public Basic withDepth(Long depth) {
        this.depth = depth;
        return this;
    }

    @JsonProperty("consumeOnFull")
    public Boolean getConsumeOnFull() {
        return consumeOnFull;
    }

    @JsonProperty("consumeOnFull")
    public void setConsumeOnFull(Boolean consumeOnFull) {
        this.consumeOnFull = consumeOnFull;
    }

    public Basic withConsumeOnFull(Boolean consumeOnFull) {
        this.consumeOnFull = consumeOnFull;
        return this;
    }

    @JsonProperty("from")
    public List<Object> getFrom() {
        return from;
    }

    @JsonProperty("from")
    public void setFrom(List<Object> from) {
        this.from = from;
    }

    public Basic withFrom(List<Object> from) {
        this.from = from;
        return this;
    }

    @JsonProperty("into")
    public List<Object> getInto() {
        return into;
    }

    @JsonProperty("into")
    public void setInto(List<Object> into) {
        this.into = into;
    }

    public Basic withInto(List<Object> into) {
        this.into = into;
        return this;
    }

    @JsonProperty("specialRecipe")
    public Long getSpecialRecipe() {
        return specialRecipe;
    }

    @JsonProperty("specialRecipe")
    public void setSpecialRecipe(Long specialRecipe) {
        this.specialRecipe = specialRecipe;
    }

    public Basic withSpecialRecipe(Long specialRecipe) {
        this.specialRecipe = specialRecipe;
        return this;
    }

    @JsonProperty("inStore")
    public Boolean getInStore() {
        return inStore;
    }

    @JsonProperty("inStore")
    public void setInStore(Boolean inStore) {
        this.inStore = inStore;
    }

    public Basic withInStore(Boolean inStore) {
        this.inStore = inStore;
        return this;
    }

    @JsonProperty("hideFromAll")
    public Boolean getHideFromAll() {
        return hideFromAll;
    }

    @JsonProperty("hideFromAll")
    public void setHideFromAll(Boolean hideFromAll) {
        this.hideFromAll = hideFromAll;
    }

    public Basic withHideFromAll(Boolean hideFromAll) {
        this.hideFromAll = hideFromAll;
        return this;
    }

    @JsonProperty("requiredChampion")
    public String getRequiredChampion() {
        return requiredChampion;
    }

    @JsonProperty("requiredChampion")
    public void setRequiredChampion(String requiredChampion) {
        this.requiredChampion = requiredChampion;
    }

    public Basic withRequiredChampion(String requiredChampion) {
        this.requiredChampion = requiredChampion;
        return this;
    }

    @JsonProperty("stats")
    public Stats getStats() {
        return stats;
    }

    @JsonProperty("stats")
    public void setStats(Stats stats) {
        this.stats = stats;
    }

    public Basic withStats(Stats stats) {
        this.stats = stats;
        return this;
    }

    @JsonProperty("tags")
    public List<Object> getTags() {
        return tags;
    }

    @JsonProperty("tags")
    public void setTags(List<Object> tags) {
        this.tags = tags;
    }

    public Basic withTags(List<Object> tags) {
        this.tags = tags;
        return this;
    }

    @JsonProperty("maps")
    public Maps getMaps() {
        return maps;
    }

    @JsonProperty("maps")
    public void setMaps(Maps maps) {
        this.maps = maps;
    }

    public Basic withMaps(Maps maps) {
        this.maps = maps;
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

    public Basic withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }
}
