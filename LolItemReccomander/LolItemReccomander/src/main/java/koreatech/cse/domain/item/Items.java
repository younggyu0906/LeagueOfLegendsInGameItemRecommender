
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
    "type",
    "version",
    "basic",
    "data",
    "groups",
    "tree"
})
public class Items {

    @JsonProperty("type")
    private String type;
    @JsonProperty("version")
    private String version;
    @JsonProperty("basic")
    private Basic basic;
    @JsonProperty("data")
    private Map<Integer,Data> data;
    @JsonProperty("groups")
    private List<Group> groups = null;
    @JsonProperty("tree")
    private List<Tree> tree = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    public Items withType(String type) {
        this.type = type;
        return this;
    }

    @JsonProperty("version")
    public String getVersion() {
        return version;
    }

    @JsonProperty("version")
    public void setVersion(String version) {
        this.version = version;
    }

    public Items withVersion(String version) {
        this.version = version;
        return this;
    }

    @JsonProperty("basic")
    public Basic getBasic() {
        return basic;
    }

    @JsonProperty("basic")
    public void setBasic(Basic basic) {
        this.basic = basic;
    }

    public Items withBasic(Basic basic) {
        this.basic = basic;
        return this;
    }

    @JsonProperty("data")
    public Map<Integer,Data> getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(Map<Integer,Data> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Items{" +
                "data=" + data +
                '}';
    }

    public Items withData(Map<Integer,Data> data) {
        this.data = data;
        return this;
    }

    @JsonProperty("groups")
    public List<Group> getGroups() {
        return groups;
    }

    @JsonProperty("groups")
    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public Items withGroups(List<Group> groups) {
        this.groups = groups;
        return this;
    }

    @JsonProperty("tree")
    public List<Tree> getTree() {
        return tree;
    }

    @JsonProperty("tree")
    public void setTree(List<Tree> tree) {
        this.tree = tree;
    }

    public Items withTree(List<Tree> tree) {
        this.tree = tree;
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

    public Items withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
