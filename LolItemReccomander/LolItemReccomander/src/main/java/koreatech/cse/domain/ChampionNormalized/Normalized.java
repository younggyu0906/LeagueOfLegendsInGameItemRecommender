
package koreatech.cse.domain.ChampionNormalized;

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
    "winRate",
    "neutralMinionsKilledEnemyJungle",
    "neutralMinionsKilledTeamJungle",
    "minionsKilled",
    "goldEarned",
    "playRate",
    "banRate",
    "killingSprees",
    "averageGameScore",
    "totalDamageTaken",
    "totalDamageDealt",
    "totalHeal",
    "kills",
    "assists",
    "deaths"
})
public class Normalized {

    @JsonProperty("winRate")
    private Double winRate;
    @JsonProperty("neutralMinionsKilledEnemyJungle")
    private Double neutralMinionsKilledEnemyJungle;
    @JsonProperty("neutralMinionsKilledTeamJungle")
    private Double neutralMinionsKilledTeamJungle;
    @JsonProperty("minionsKilled")
    private Double minionsKilled;
    @JsonProperty("goldEarned")
    private Double goldEarned;
    @JsonProperty("playRate")
    private Double playRate;
    @JsonProperty("banRate")
    private Double banRate;
    @JsonProperty("killingSprees")
    private Double killingSprees;
    @JsonProperty("averageGameScore")
    private Double averageGameScore;
    @JsonProperty("totalDamageTaken")
    private Double totalDamageTaken;
    @JsonProperty("totalDamageDealt")
    private Double totalDamageDealt;
    @JsonProperty("totalHeal")
    private Double totalHeal;
    @JsonProperty("kills")
    private Double kills;
    @JsonProperty("assists")
    private Double assists;
    @JsonProperty("deaths")
    private Double deaths;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("winRate")
    public Double getWinRate() {
        return winRate;
    }

    @JsonProperty("winRate")
    public void setWinRate(Double winRate) {
        this.winRate = winRate;
    }

    @JsonProperty("neutralMinionsKilledEnemyJungle")
    public Double getNeutralMinionsKilledEnemyJungle() {
        return neutralMinionsKilledEnemyJungle;
    }

    @JsonProperty("neutralMinionsKilledEnemyJungle")
    public void setNeutralMinionsKilledEnemyJungle(Double neutralMinionsKilledEnemyJungle) {
        this.neutralMinionsKilledEnemyJungle = neutralMinionsKilledEnemyJungle;
    }

    @JsonProperty("neutralMinionsKilledTeamJungle")
    public Double getNeutralMinionsKilledTeamJungle() {
        return neutralMinionsKilledTeamJungle;
    }

    @JsonProperty("neutralMinionsKilledTeamJungle")
    public void setNeutralMinionsKilledTeamJungle(Double neutralMinionsKilledTeamJungle) {
        this.neutralMinionsKilledTeamJungle = neutralMinionsKilledTeamJungle;
    }

    @JsonProperty("minionsKilled")
    public Double getMinionsKilled() {
        return minionsKilled;
    }

    @JsonProperty("minionsKilled")
    public void setMinionsKilled(Double minionsKilled) {
        this.minionsKilled = minionsKilled;
    }

    @JsonProperty("goldEarned")
    public Double getGoldEarned() {
        return goldEarned;
    }

    @JsonProperty("goldEarned")
    public void setGoldEarned(Double goldEarned) {
        this.goldEarned = goldEarned;
    }

    @JsonProperty("playRate")
    public Double getPlayRate() {
        return playRate;
    }

    @JsonProperty("playRate")
    public void setPlayRate(Double playRate) {
        this.playRate = playRate;
    }

    @JsonProperty("banRate")
    public Double getBanRate() {
        return banRate;
    }

    @JsonProperty("banRate")
    public void setBanRate(Double banRate) {
        this.banRate = banRate;
    }

    @JsonProperty("killingSprees")
    public Double getKillingSprees() {
        return killingSprees;
    }

    @JsonProperty("killingSprees")
    public void setKillingSprees(Double killingSprees) {
        this.killingSprees = killingSprees;
    }

    @JsonProperty("averageGameScore")
    public Double getAverageGameScore() {
        return averageGameScore;
    }

    @JsonProperty("averageGameScore")
    public void setAverageGameScore(Double averageGameScore) {
        this.averageGameScore = averageGameScore;
    }

    @JsonProperty("totalDamageTaken")
    public Double getTotalDamageTaken() {
        return totalDamageTaken;
    }

    @JsonProperty("totalDamageTaken")
    public void setTotalDamageTaken(Double totalDamageTaken) {
        this.totalDamageTaken = totalDamageTaken;
    }

    @JsonProperty("totalDamageDealt")
    public Double getTotalDamageDealt() {
        return totalDamageDealt;
    }

    @JsonProperty("totalDamageDealt")
    public void setTotalDamageDealt(Double totalDamageDealt) {
        this.totalDamageDealt = totalDamageDealt;
    }

    @JsonProperty("totalHeal")
    public Double getTotalHeal() {
        return totalHeal;
    }

    @JsonProperty("totalHeal")
    public void setTotalHeal(Double totalHeal) {
        this.totalHeal = totalHeal;
    }

    @JsonProperty("kills")
    public Double getKills() {
        return kills;
    }

    @JsonProperty("kills")
    public void setKills(Double kills) {
        this.kills = kills;
    }

    @JsonProperty("assists")
    public Double getAssists() {
        return assists;
    }

    @JsonProperty("assists")
    public void setAssists(Double assists) {
        this.assists = assists;
    }

    @JsonProperty("deaths")
    public Double getDeaths() {
        return deaths;
    }

    @JsonProperty("deaths")
    public void setDeaths(Double deaths) {
        this.deaths = deaths;
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
