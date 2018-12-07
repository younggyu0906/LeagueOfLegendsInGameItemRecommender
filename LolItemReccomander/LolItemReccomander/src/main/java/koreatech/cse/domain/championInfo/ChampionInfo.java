
package koreatech.cse.domain.championInfo;

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
    "_id",
    "elo",
    "patch",
    "championId",
    "normalized",
    "winRate",
    "playRate",
    "gamesPlayed",
    "percentRolePlayed",
    "banRate",
    "role"
})
public class ChampionInfo {

    @JsonProperty("_id")
    private Id id;
    @JsonProperty("elo")
    private String elo;
    @JsonProperty("patch")
    private String patch;
    @JsonProperty("championId")
    private Long championId;
    @JsonProperty("normalized")
    private Normalized normalized;
    @JsonProperty("winRate")
    private Double winRate;
    @JsonProperty("playRate")
    private Double playRate;
    @JsonProperty("gamesPlayed")
    private Long gamesPlayed;
    @JsonProperty("percentRolePlayed")
    private Double percentRolePlayed;
    @JsonProperty("banRate")
    private Double banRate;
    @JsonProperty("role")
    private String role;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("_id")
    public Id getId() {
        return id;
    }

    @JsonProperty("_id")
    public void setId(Id id) {
        this.id = id;
    }

    @JsonProperty("elo")
    public String getElo() {
        return elo;
    }

    @JsonProperty("elo")
    public void setElo(String elo) {
        this.elo = elo;
    }

    @JsonProperty("patch")
    public String getPatch() {
        return patch;
    }

    @JsonProperty("patch")
    public void setPatch(String patch) {
        this.patch = patch;
    }

    @JsonProperty("championId")
    public Long getChampionId() {
        return championId;
    }

    @JsonProperty("championId")
    public void setChampionId(Long championId) {
        this.championId = championId;
    }

    @JsonProperty("normalized")
    public Normalized getNormalized() {
        return normalized;
    }

    @JsonProperty("normalized")
    public void setNormalized(Normalized normalized) {
        this.normalized = normalized;
    }

    @JsonProperty("winRate")
    public Double getWinRate() {
        return winRate;
    }

    @JsonProperty("winRate")
    public void setWinRate(Double winRate) {
        this.winRate = winRate;
    }

    @JsonProperty("playRate")
    public Double getPlayRate() {
        return playRate;
    }

    @JsonProperty("playRate")
    public void setPlayRate(Double playRate) {
        this.playRate = playRate;
    }

    @JsonProperty("gamesPlayed")
    public Long getGamesPlayed() {
        return gamesPlayed;
    }

    @JsonProperty("gamesPlayed")
    public void setGamesPlayed(Long gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    @JsonProperty("percentRolePlayed")
    public Double getPercentRolePlayed() {
        return percentRolePlayed;
    }

    @JsonProperty("percentRolePlayed")
    public void setPercentRolePlayed(Double percentRolePlayed) {
        this.percentRolePlayed = percentRolePlayed;
    }

    @JsonProperty("banRate")
    public Double getBanRate() {
        return banRate;
    }

    @JsonProperty("banRate")
    public void setBanRate(Double banRate) {
        this.banRate = banRate;
    }

    @JsonProperty("role")
    public String getRole() {
        return role;
    }

    @JsonProperty("role")
    public void setRole(String role) {
        this.role = role;
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
