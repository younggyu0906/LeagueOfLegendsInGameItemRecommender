
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
    "description",
    "colloq",
    "plaintext",
    "into",
    "image",
    "gold",
    "tags",
    "maps",
    "stats"
})
public class Data {

    @JsonProperty("name")
    private String name;

    @Override
    public String toString() {
        return "Data{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", plaintext='" + plaintext + '\'' +
                ", gold=" + gold +
                ", tags=" + tags +
                ", stats=" + stats +
                '}';
    }

    @JsonProperty("description")
    private String description;
    @JsonProperty("colloq")
    private String colloq;
    @JsonProperty("plaintext")
    private String plaintext;
    @JsonProperty("into")
    private List<String> into = null;
    @JsonProperty("image")
    private Image image;
    @JsonProperty("gold")
    private Gold gold;
    @JsonProperty("tags")
    private List<String> tags = null;
    @JsonProperty("maps")
    private Maps maps;
    @JsonProperty("stats")
    private Stats stats;
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

    public Data withName(String name) {
        this.name = name;
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

    public Data withDescription(String description) {
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

    public Data withColloq(String colloq) {
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

    public Data withPlaintext(String plaintext) {
        this.plaintext = plaintext;
        return this;
    }

    @JsonProperty("into")
    public List<String> getInto() {
        return into;
    }

    @JsonProperty("into")
    public void setInto(List<String> into) {
        this.into = into;
    }

    public Data withInto(List<String> into) {
        this.into = into;
        return this;
    }

    @JsonProperty("image")
    public Image getImage() {
        return image;
    }

    @JsonProperty("image")
    public void setImage(Image image) {
        this.image = image;
    }

    public Data withImage(Image image) {
        this.image = image;
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

    public Data withGold(Gold gold) {
        this.gold = gold;
        return this;
    }

    @JsonProperty("tags")
    public List<String> getTags() {
        return tags;
    }

    @JsonProperty("tags")
    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public Data withTags(List<String> tags) {
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

    public Data withMaps(Maps maps) {
        this.maps = maps;
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

    public Data withStats(Stats stats) {
        this.stats = stats;
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

    public Data withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }
}
