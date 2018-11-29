
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
    "FlatHPPoolMod",
    "rFlatHPModPerLevel",
    "FlatMPPoolMod",
    "rFlatMPModPerLevel",
    "PercentHPPoolMod",
    "PercentMPPoolMod",
    "FlatHPRegenMod",
    "rFlatHPRegenModPerLevel",
    "PercentHPRegenMod",
    "FlatMPRegenMod",
    "rFlatMPRegenModPerLevel",
    "PercentMPRegenMod",
    "FlatArmorMod",
    "rFlatArmorModPerLevel",
    "PercentArmorMod",
    "rFlatArmorPenetrationMod",
    "rFlatArmorPenetrationModPerLevel",
    "rPercentArmorPenetrationMod",
    "rPercentArmorPenetrationModPerLevel",
    "FlatPhysicalDamageMod",
    "rFlatPhysicalDamageModPerLevel",
    "PercentPhysicalDamageMod",
    "FlatMagicDamageMod",
    "rFlatMagicDamageModPerLevel",
    "PercentMagicDamageMod",
    "FlatMovementSpeedMod",
    "rFlatMovementSpeedModPerLevel",
    "PercentMovementSpeedMod",
    "rPercentMovementSpeedModPerLevel",
    "FlatAttackSpeedMod",
    "PercentAttackSpeedMod",
    "rPercentAttackSpeedModPerLevel",
    "rFlatDodgeMod",
    "rFlatDodgeModPerLevel",
    "PercentDodgeMod",
    "FlatCritChanceMod",
    "rFlatCritChanceModPerLevel",
    "PercentCritChanceMod",
    "FlatCritDamageMod",
    "rFlatCritDamageModPerLevel",
    "PercentCritDamageMod",
    "FlatBlockMod",
    "PercentBlockMod",
    "FlatSpellBlockMod",
    "rFlatSpellBlockModPerLevel",
    "PercentSpellBlockMod",
    "FlatEXPBonus",
    "PercentEXPBonus",
    "rPercentCooldownMod",
    "rPercentCooldownModPerLevel",
    "rFlatTimeDeadMod",
    "rFlatTimeDeadModPerLevel",
    "rPercentTimeDeadMod",
    "rPercentTimeDeadModPerLevel",
    "rFlatGoldPer10Mod",
    "rFlatMagicPenetrationMod",
    "rFlatMagicPenetrationModPerLevel",
    "rPercentMagicPenetrationMod",
    "rPercentMagicPenetrationModPerLevel",
    "FlatEnergyRegenMod",
    "rFlatEnergyRegenModPerLevel",
    "FlatEnergyPoolMod",
    "rFlatEnergyModPerLevel",
    "PercentLifeStealMod",
    "PercentSpellVampMod"
})
public class Stats {

    @JsonProperty("FlatHPPoolMod")
    private Long flatHPPoolMod;
    @JsonProperty("rFlatHPModPerLevel")
    private Long rFlatHPModPerLevel;
    @JsonProperty("FlatMPPoolMod")
    private Long flatMPPoolMod;
    @JsonProperty("rFlatMPModPerLevel")
    private Long rFlatMPModPerLevel;
    @JsonProperty("PercentHPPoolMod")
    private Long percentHPPoolMod;
    @JsonProperty("PercentMPPoolMod")
    private Long percentMPPoolMod;
    @JsonProperty("FlatHPRegenMod")
    private Long flatHPRegenMod;
    @JsonProperty("rFlatHPRegenModPerLevel")
    private Long rFlatHPRegenModPerLevel;
    @JsonProperty("PercentHPRegenMod")
    private Long percentHPRegenMod;
    @JsonProperty("FlatMPRegenMod")
    private Long flatMPRegenMod;
    @JsonProperty("rFlatMPRegenModPerLevel")
    private Long rFlatMPRegenModPerLevel;
    @JsonProperty("PercentMPRegenMod")
    private Long percentMPRegenMod;
    @JsonProperty("FlatArmorMod")
    private Long flatArmorMod;
    @JsonProperty("rFlatArmorModPerLevel")
    private Long rFlatArmorModPerLevel;
    @JsonProperty("PercentArmorMod")
    private Long percentArmorMod;
    @JsonProperty("rFlatArmorPenetrationMod")
    private Long rFlatArmorPenetrationMod;
    @JsonProperty("rFlatArmorPenetrationModPerLevel")
    private Long rFlatArmorPenetrationModPerLevel;
    @JsonProperty("rPercentArmorPenetrationMod")
    private Long rPercentArmorPenetrationMod;
    @JsonProperty("rPercentArmorPenetrationModPerLevel")
    private Long rPercentArmorPenetrationModPerLevel;
    @JsonProperty("FlatPhysicalDamageMod")
    private Long flatPhysicalDamageMod;
    @JsonProperty("rFlatPhysicalDamageModPerLevel")
    private Long rFlatPhysicalDamageModPerLevel;
    @JsonProperty("PercentPhysicalDamageMod")
    private Long percentPhysicalDamageMod;
    @JsonProperty("FlatMagicDamageMod")
    private Long flatMagicDamageMod;
    @JsonProperty("rFlatMagicDamageModPerLevel")
    private Long rFlatMagicDamageModPerLevel;
    @JsonProperty("PercentMagicDamageMod")
    private Long percentMagicDamageMod;
    @JsonProperty("FlatMovementSpeedMod")
    private Long flatMovementSpeedMod;
    @JsonProperty("rFlatMovementSpeedModPerLevel")
    private Long rFlatMovementSpeedModPerLevel;
    @JsonProperty("PercentMovementSpeedMod")
    private Long percentMovementSpeedMod;
    @JsonProperty("rPercentMovementSpeedModPerLevel")
    private Long rPercentMovementSpeedModPerLevel;
    @JsonProperty("FlatAttackSpeedMod")
    private Long flatAttackSpeedMod;
    @JsonProperty("PercentAttackSpeedMod")
    private Long percentAttackSpeedMod;
    @JsonProperty("rPercentAttackSpeedModPerLevel")
    private Long rPercentAttackSpeedModPerLevel;
    @JsonProperty("rFlatDodgeMod")
    private Long rFlatDodgeMod;
    @JsonProperty("rFlatDodgeModPerLevel")
    private Long rFlatDodgeModPerLevel;
    @JsonProperty("PercentDodgeMod")
    private Long percentDodgeMod;
    @JsonProperty("FlatCritChanceMod")
    private Long flatCritChanceMod;
    @JsonProperty("rFlatCritChanceModPerLevel")
    private Long rFlatCritChanceModPerLevel;
    @JsonProperty("PercentCritChanceMod")
    private Long percentCritChanceMod;
    @JsonProperty("FlatCritDamageMod")
    private Long flatCritDamageMod;
    @JsonProperty("rFlatCritDamageModPerLevel")
    private Long rFlatCritDamageModPerLevel;
    @JsonProperty("PercentCritDamageMod")
    private Long percentCritDamageMod;
    @JsonProperty("FlatBlockMod")
    private Long flatBlockMod;
    @JsonProperty("PercentBlockMod")
    private Long percentBlockMod;
    @JsonProperty("FlatSpellBlockMod")
    private Long flatSpellBlockMod;
    @JsonProperty("rFlatSpellBlockModPerLevel")
    private Long rFlatSpellBlockModPerLevel;
    @JsonProperty("PercentSpellBlockMod")
    private Long percentSpellBlockMod;
    @JsonProperty("FlatEXPBonus")
    private Long flatEXPBonus;
    @JsonProperty("PercentEXPBonus")
    private Long percentEXPBonus;
    @JsonProperty("rPercentCooldownMod")
    private Long rPercentCooldownMod;
    @JsonProperty("rPercentCooldownModPerLevel")
    private Long rPercentCooldownModPerLevel;
    @JsonProperty("rFlatTimeDeadMod")
    private Long rFlatTimeDeadMod;
    @JsonProperty("rFlatTimeDeadModPerLevel")
    private Long rFlatTimeDeadModPerLevel;
    @JsonProperty("rPercentTimeDeadMod")
    private Long rPercentTimeDeadMod;
    @JsonProperty("rPercentTimeDeadModPerLevel")
    private Long rPercentTimeDeadModPerLevel;
    @JsonProperty("rFlatGoldPer10Mod")
    private Long rFlatGoldPer10Mod;
    @JsonProperty("rFlatMagicPenetrationMod")
    private Long rFlatMagicPenetrationMod;
    @JsonProperty("rFlatMagicPenetrationModPerLevel")
    private Long rFlatMagicPenetrationModPerLevel;
    @JsonProperty("rPercentMagicPenetrationMod")
    private Long rPercentMagicPenetrationMod;
    @JsonProperty("rPercentMagicPenetrationModPerLevel")
    private Long rPercentMagicPenetrationModPerLevel;
    @JsonProperty("FlatEnergyRegenMod")
    private Long flatEnergyRegenMod;
    @JsonProperty("rFlatEnergyRegenModPerLevel")
    private Long rFlatEnergyRegenModPerLevel;
    @JsonProperty("FlatEnergyPoolMod")
    private Long flatEnergyPoolMod;
    @JsonProperty("rFlatEnergyModPerLevel")
    private Long rFlatEnergyModPerLevel;
    @JsonProperty("PercentLifeStealMod")
    private Long percentLifeStealMod;
    @JsonProperty("PercentSpellVampMod")
    private Long percentSpellVampMod;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("FlatHPPoolMod")
    public Long getFlatHPPoolMod() {
        return flatHPPoolMod;
    }

    @JsonProperty("FlatHPPoolMod")
    public void setFlatHPPoolMod(Long flatHPPoolMod) {
        this.flatHPPoolMod = flatHPPoolMod;
    }

    public Stats withFlatHPPoolMod(Long flatHPPoolMod) {
        this.flatHPPoolMod = flatHPPoolMod;
        return this;
    }

    @JsonProperty("rFlatHPModPerLevel")
    public Long getRFlatHPModPerLevel() {
        return rFlatHPModPerLevel;
    }

    @JsonProperty("rFlatHPModPerLevel")
    public void setRFlatHPModPerLevel(Long rFlatHPModPerLevel) {
        this.rFlatHPModPerLevel = rFlatHPModPerLevel;
    }

    public Stats withRFlatHPModPerLevel(Long rFlatHPModPerLevel) {
        this.rFlatHPModPerLevel = rFlatHPModPerLevel;
        return this;
    }

    @JsonProperty("FlatMPPoolMod")
    public Long getFlatMPPoolMod() {
        return flatMPPoolMod;
    }

    @JsonProperty("FlatMPPoolMod")
    public void setFlatMPPoolMod(Long flatMPPoolMod) {
        this.flatMPPoolMod = flatMPPoolMod;
    }

    public Stats withFlatMPPoolMod(Long flatMPPoolMod) {
        this.flatMPPoolMod = flatMPPoolMod;
        return this;
    }

    @JsonProperty("rFlatMPModPerLevel")
    public Long getRFlatMPModPerLevel() {
        return rFlatMPModPerLevel;
    }

    @JsonProperty("rFlatMPModPerLevel")
    public void setRFlatMPModPerLevel(Long rFlatMPModPerLevel) {
        this.rFlatMPModPerLevel = rFlatMPModPerLevel;
    }

    public Stats withRFlatMPModPerLevel(Long rFlatMPModPerLevel) {
        this.rFlatMPModPerLevel = rFlatMPModPerLevel;
        return this;
    }

    @JsonProperty("PercentHPPoolMod")
    public Long getPercentHPPoolMod() {
        return percentHPPoolMod;
    }

    @JsonProperty("PercentHPPoolMod")
    public void setPercentHPPoolMod(Long percentHPPoolMod) {
        this.percentHPPoolMod = percentHPPoolMod;
    }

    public Stats withPercentHPPoolMod(Long percentHPPoolMod) {
        this.percentHPPoolMod = percentHPPoolMod;
        return this;
    }

    @JsonProperty("PercentMPPoolMod")
    public Long getPercentMPPoolMod() {
        return percentMPPoolMod;
    }

    @JsonProperty("PercentMPPoolMod")
    public void setPercentMPPoolMod(Long percentMPPoolMod) {
        this.percentMPPoolMod = percentMPPoolMod;
    }

    public Stats withPercentMPPoolMod(Long percentMPPoolMod) {
        this.percentMPPoolMod = percentMPPoolMod;
        return this;
    }

    @JsonProperty("FlatHPRegenMod")
    public Long getFlatHPRegenMod() {
        return flatHPRegenMod;
    }

    @JsonProperty("FlatHPRegenMod")
    public void setFlatHPRegenMod(Long flatHPRegenMod) {
        this.flatHPRegenMod = flatHPRegenMod;
    }

    public Stats withFlatHPRegenMod(Long flatHPRegenMod) {
        this.flatHPRegenMod = flatHPRegenMod;
        return this;
    }

    @JsonProperty("rFlatHPRegenModPerLevel")
    public Long getRFlatHPRegenModPerLevel() {
        return rFlatHPRegenModPerLevel;
    }

    @JsonProperty("rFlatHPRegenModPerLevel")
    public void setRFlatHPRegenModPerLevel(Long rFlatHPRegenModPerLevel) {
        this.rFlatHPRegenModPerLevel = rFlatHPRegenModPerLevel;
    }

    public Stats withRFlatHPRegenModPerLevel(Long rFlatHPRegenModPerLevel) {
        this.rFlatHPRegenModPerLevel = rFlatHPRegenModPerLevel;
        return this;
    }

    @JsonProperty("PercentHPRegenMod")
    public Long getPercentHPRegenMod() {
        return percentHPRegenMod;
    }

    @JsonProperty("PercentHPRegenMod")
    public void setPercentHPRegenMod(Long percentHPRegenMod) {
        this.percentHPRegenMod = percentHPRegenMod;
    }

    public Stats withPercentHPRegenMod(Long percentHPRegenMod) {
        this.percentHPRegenMod = percentHPRegenMod;
        return this;
    }

    @JsonProperty("FlatMPRegenMod")
    public Long getFlatMPRegenMod() {
        return flatMPRegenMod;
    }

    @JsonProperty("FlatMPRegenMod")
    public void setFlatMPRegenMod(Long flatMPRegenMod) {
        this.flatMPRegenMod = flatMPRegenMod;
    }

    public Stats withFlatMPRegenMod(Long flatMPRegenMod) {
        this.flatMPRegenMod = flatMPRegenMod;
        return this;
    }

    @JsonProperty("rFlatMPRegenModPerLevel")
    public Long getRFlatMPRegenModPerLevel() {
        return rFlatMPRegenModPerLevel;
    }

    @JsonProperty("rFlatMPRegenModPerLevel")
    public void setRFlatMPRegenModPerLevel(Long rFlatMPRegenModPerLevel) {
        this.rFlatMPRegenModPerLevel = rFlatMPRegenModPerLevel;
    }

    public Stats withRFlatMPRegenModPerLevel(Long rFlatMPRegenModPerLevel) {
        this.rFlatMPRegenModPerLevel = rFlatMPRegenModPerLevel;
        return this;
    }

    @JsonProperty("PercentMPRegenMod")
    public Long getPercentMPRegenMod() {
        return percentMPRegenMod;
    }

    @JsonProperty("PercentMPRegenMod")
    public void setPercentMPRegenMod(Long percentMPRegenMod) {
        this.percentMPRegenMod = percentMPRegenMod;
    }

    public Stats withPercentMPRegenMod(Long percentMPRegenMod) {
        this.percentMPRegenMod = percentMPRegenMod;
        return this;
    }

    @JsonProperty("FlatArmorMod")
    public Long getFlatArmorMod() {
        return flatArmorMod;
    }

    @JsonProperty("FlatArmorMod")
    public void setFlatArmorMod(Long flatArmorMod) {
        this.flatArmorMod = flatArmorMod;
    }

    public Stats withFlatArmorMod(Long flatArmorMod) {
        this.flatArmorMod = flatArmorMod;
        return this;
    }

    @JsonProperty("rFlatArmorModPerLevel")
    public Long getRFlatArmorModPerLevel() {
        return rFlatArmorModPerLevel;
    }

    @JsonProperty("rFlatArmorModPerLevel")
    public void setRFlatArmorModPerLevel(Long rFlatArmorModPerLevel) {
        this.rFlatArmorModPerLevel = rFlatArmorModPerLevel;
    }

    public Stats withRFlatArmorModPerLevel(Long rFlatArmorModPerLevel) {
        this.rFlatArmorModPerLevel = rFlatArmorModPerLevel;
        return this;
    }

    @JsonProperty("PercentArmorMod")
    public Long getPercentArmorMod() {
        return percentArmorMod;
    }

    @JsonProperty("PercentArmorMod")
    public void setPercentArmorMod(Long percentArmorMod) {
        this.percentArmorMod = percentArmorMod;
    }

    public Stats withPercentArmorMod(Long percentArmorMod) {
        this.percentArmorMod = percentArmorMod;
        return this;
    }

    @JsonProperty("rFlatArmorPenetrationMod")
    public Long getRFlatArmorPenetrationMod() {
        return rFlatArmorPenetrationMod;
    }

    @JsonProperty("rFlatArmorPenetrationMod")
    public void setRFlatArmorPenetrationMod(Long rFlatArmorPenetrationMod) {
        this.rFlatArmorPenetrationMod = rFlatArmorPenetrationMod;
    }

    public Stats withRFlatArmorPenetrationMod(Long rFlatArmorPenetrationMod) {
        this.rFlatArmorPenetrationMod = rFlatArmorPenetrationMod;
        return this;
    }

    @JsonProperty("rFlatArmorPenetrationModPerLevel")
    public Long getRFlatArmorPenetrationModPerLevel() {
        return rFlatArmorPenetrationModPerLevel;
    }

    @JsonProperty("rFlatArmorPenetrationModPerLevel")
    public void setRFlatArmorPenetrationModPerLevel(Long rFlatArmorPenetrationModPerLevel) {
        this.rFlatArmorPenetrationModPerLevel = rFlatArmorPenetrationModPerLevel;
    }

    public Stats withRFlatArmorPenetrationModPerLevel(Long rFlatArmorPenetrationModPerLevel) {
        this.rFlatArmorPenetrationModPerLevel = rFlatArmorPenetrationModPerLevel;
        return this;
    }

    @JsonProperty("rPercentArmorPenetrationMod")
    public Long getRPercentArmorPenetrationMod() {
        return rPercentArmorPenetrationMod;
    }

    @JsonProperty("rPercentArmorPenetrationMod")
    public void setRPercentArmorPenetrationMod(Long rPercentArmorPenetrationMod) {
        this.rPercentArmorPenetrationMod = rPercentArmorPenetrationMod;
    }

    public Stats withRPercentArmorPenetrationMod(Long rPercentArmorPenetrationMod) {
        this.rPercentArmorPenetrationMod = rPercentArmorPenetrationMod;
        return this;
    }

    @JsonProperty("rPercentArmorPenetrationModPerLevel")
    public Long getRPercentArmorPenetrationModPerLevel() {
        return rPercentArmorPenetrationModPerLevel;
    }

    @JsonProperty("rPercentArmorPenetrationModPerLevel")
    public void setRPercentArmorPenetrationModPerLevel(Long rPercentArmorPenetrationModPerLevel) {
        this.rPercentArmorPenetrationModPerLevel = rPercentArmorPenetrationModPerLevel;
    }

    public Stats withRPercentArmorPenetrationModPerLevel(Long rPercentArmorPenetrationModPerLevel) {
        this.rPercentArmorPenetrationModPerLevel = rPercentArmorPenetrationModPerLevel;
        return this;
    }

    @JsonProperty("FlatPhysicalDamageMod")
    public Long getFlatPhysicalDamageMod() {
        return flatPhysicalDamageMod;
    }

    @JsonProperty("FlatPhysicalDamageMod")
    public void setFlatPhysicalDamageMod(Long flatPhysicalDamageMod) {
        this.flatPhysicalDamageMod = flatPhysicalDamageMod;
    }

    public Stats withFlatPhysicalDamageMod(Long flatPhysicalDamageMod) {
        this.flatPhysicalDamageMod = flatPhysicalDamageMod;
        return this;
    }

    @JsonProperty("rFlatPhysicalDamageModPerLevel")
    public Long getRFlatPhysicalDamageModPerLevel() {
        return rFlatPhysicalDamageModPerLevel;
    }

    @JsonProperty("rFlatPhysicalDamageModPerLevel")
    public void setRFlatPhysicalDamageModPerLevel(Long rFlatPhysicalDamageModPerLevel) {
        this.rFlatPhysicalDamageModPerLevel = rFlatPhysicalDamageModPerLevel;
    }

    public Stats withRFlatPhysicalDamageModPerLevel(Long rFlatPhysicalDamageModPerLevel) {
        this.rFlatPhysicalDamageModPerLevel = rFlatPhysicalDamageModPerLevel;
        return this;
    }

    @JsonProperty("PercentPhysicalDamageMod")
    public Long getPercentPhysicalDamageMod() {
        return percentPhysicalDamageMod;
    }

    @JsonProperty("PercentPhysicalDamageMod")
    public void setPercentPhysicalDamageMod(Long percentPhysicalDamageMod) {
        this.percentPhysicalDamageMod = percentPhysicalDamageMod;
    }

    public Stats withPercentPhysicalDamageMod(Long percentPhysicalDamageMod) {
        this.percentPhysicalDamageMod = percentPhysicalDamageMod;
        return this;
    }

    @JsonProperty("FlatMagicDamageMod")
    public Long getFlatMagicDamageMod() {
        return flatMagicDamageMod;
    }

    @JsonProperty("FlatMagicDamageMod")
    public void setFlatMagicDamageMod(Long flatMagicDamageMod) {
        this.flatMagicDamageMod = flatMagicDamageMod;
    }

    public Stats withFlatMagicDamageMod(Long flatMagicDamageMod) {
        this.flatMagicDamageMod = flatMagicDamageMod;
        return this;
    }

    @JsonProperty("rFlatMagicDamageModPerLevel")
    public Long getRFlatMagicDamageModPerLevel() {
        return rFlatMagicDamageModPerLevel;
    }

    @JsonProperty("rFlatMagicDamageModPerLevel")
    public void setRFlatMagicDamageModPerLevel(Long rFlatMagicDamageModPerLevel) {
        this.rFlatMagicDamageModPerLevel = rFlatMagicDamageModPerLevel;
    }

    public Stats withRFlatMagicDamageModPerLevel(Long rFlatMagicDamageModPerLevel) {
        this.rFlatMagicDamageModPerLevel = rFlatMagicDamageModPerLevel;
        return this;
    }

    @JsonProperty("PercentMagicDamageMod")
    public Long getPercentMagicDamageMod() {
        return percentMagicDamageMod;
    }

    @JsonProperty("PercentMagicDamageMod")
    public void setPercentMagicDamageMod(Long percentMagicDamageMod) {
        this.percentMagicDamageMod = percentMagicDamageMod;
    }

    public Stats withPercentMagicDamageMod(Long percentMagicDamageMod) {
        this.percentMagicDamageMod = percentMagicDamageMod;
        return this;
    }

    @JsonProperty("FlatMovementSpeedMod")
    public Long getFlatMovementSpeedMod() {
        return flatMovementSpeedMod;
    }

    @JsonProperty("FlatMovementSpeedMod")
    public void setFlatMovementSpeedMod(Long flatMovementSpeedMod) {
        this.flatMovementSpeedMod = flatMovementSpeedMod;
    }

    public Stats withFlatMovementSpeedMod(Long flatMovementSpeedMod) {
        this.flatMovementSpeedMod = flatMovementSpeedMod;
        return this;
    }

    @JsonProperty("rFlatMovementSpeedModPerLevel")
    public Long getRFlatMovementSpeedModPerLevel() {
        return rFlatMovementSpeedModPerLevel;
    }

    @JsonProperty("rFlatMovementSpeedModPerLevel")
    public void setRFlatMovementSpeedModPerLevel(Long rFlatMovementSpeedModPerLevel) {
        this.rFlatMovementSpeedModPerLevel = rFlatMovementSpeedModPerLevel;
    }

    public Stats withRFlatMovementSpeedModPerLevel(Long rFlatMovementSpeedModPerLevel) {
        this.rFlatMovementSpeedModPerLevel = rFlatMovementSpeedModPerLevel;
        return this;
    }

    @JsonProperty("PercentMovementSpeedMod")
    public Long getPercentMovementSpeedMod() {
        return percentMovementSpeedMod;
    }

    @JsonProperty("PercentMovementSpeedMod")
    public void setPercentMovementSpeedMod(Long percentMovementSpeedMod) {
        this.percentMovementSpeedMod = percentMovementSpeedMod;
    }

    public Stats withPercentMovementSpeedMod(Long percentMovementSpeedMod) {
        this.percentMovementSpeedMod = percentMovementSpeedMod;
        return this;
    }

    @JsonProperty("rPercentMovementSpeedModPerLevel")
    public Long getRPercentMovementSpeedModPerLevel() {
        return rPercentMovementSpeedModPerLevel;
    }

    @JsonProperty("rPercentMovementSpeedModPerLevel")
    public void setRPercentMovementSpeedModPerLevel(Long rPercentMovementSpeedModPerLevel) {
        this.rPercentMovementSpeedModPerLevel = rPercentMovementSpeedModPerLevel;
    }

    public Stats withRPercentMovementSpeedModPerLevel(Long rPercentMovementSpeedModPerLevel) {
        this.rPercentMovementSpeedModPerLevel = rPercentMovementSpeedModPerLevel;
        return this;
    }

    @JsonProperty("FlatAttackSpeedMod")
    public Long getFlatAttackSpeedMod() {
        return flatAttackSpeedMod;
    }

    @JsonProperty("FlatAttackSpeedMod")
    public void setFlatAttackSpeedMod(Long flatAttackSpeedMod) {
        this.flatAttackSpeedMod = flatAttackSpeedMod;
    }

    public Stats withFlatAttackSpeedMod(Long flatAttackSpeedMod) {
        this.flatAttackSpeedMod = flatAttackSpeedMod;
        return this;
    }

    @JsonProperty("PercentAttackSpeedMod")
    public Long getPercentAttackSpeedMod() {
        return percentAttackSpeedMod;
    }

    @JsonProperty("PercentAttackSpeedMod")
    public void setPercentAttackSpeedMod(Long percentAttackSpeedMod) {
        this.percentAttackSpeedMod = percentAttackSpeedMod;
    }

    public Stats withPercentAttackSpeedMod(Long percentAttackSpeedMod) {
        this.percentAttackSpeedMod = percentAttackSpeedMod;
        return this;
    }

    @JsonProperty("rPercentAttackSpeedModPerLevel")
    public Long getRPercentAttackSpeedModPerLevel() {
        return rPercentAttackSpeedModPerLevel;
    }

    @JsonProperty("rPercentAttackSpeedModPerLevel")
    public void setRPercentAttackSpeedModPerLevel(Long rPercentAttackSpeedModPerLevel) {
        this.rPercentAttackSpeedModPerLevel = rPercentAttackSpeedModPerLevel;
    }

    public Stats withRPercentAttackSpeedModPerLevel(Long rPercentAttackSpeedModPerLevel) {
        this.rPercentAttackSpeedModPerLevel = rPercentAttackSpeedModPerLevel;
        return this;
    }

    @JsonProperty("rFlatDodgeMod")
    public Long getRFlatDodgeMod() {
        return rFlatDodgeMod;
    }

    @JsonProperty("rFlatDodgeMod")
    public void setRFlatDodgeMod(Long rFlatDodgeMod) {
        this.rFlatDodgeMod = rFlatDodgeMod;
    }

    public Stats withRFlatDodgeMod(Long rFlatDodgeMod) {
        this.rFlatDodgeMod = rFlatDodgeMod;
        return this;
    }

    @JsonProperty("rFlatDodgeModPerLevel")
    public Long getRFlatDodgeModPerLevel() {
        return rFlatDodgeModPerLevel;
    }

    @JsonProperty("rFlatDodgeModPerLevel")
    public void setRFlatDodgeModPerLevel(Long rFlatDodgeModPerLevel) {
        this.rFlatDodgeModPerLevel = rFlatDodgeModPerLevel;
    }

    public Stats withRFlatDodgeModPerLevel(Long rFlatDodgeModPerLevel) {
        this.rFlatDodgeModPerLevel = rFlatDodgeModPerLevel;
        return this;
    }

    @JsonProperty("PercentDodgeMod")
    public Long getPercentDodgeMod() {
        return percentDodgeMod;
    }

    @JsonProperty("PercentDodgeMod")
    public void setPercentDodgeMod(Long percentDodgeMod) {
        this.percentDodgeMod = percentDodgeMod;
    }

    public Stats withPercentDodgeMod(Long percentDodgeMod) {
        this.percentDodgeMod = percentDodgeMod;
        return this;
    }

    @JsonProperty("FlatCritChanceMod")
    public Long getFlatCritChanceMod() {
        return flatCritChanceMod;
    }

    @JsonProperty("FlatCritChanceMod")
    public void setFlatCritChanceMod(Long flatCritChanceMod) {
        this.flatCritChanceMod = flatCritChanceMod;
    }

    public Stats withFlatCritChanceMod(Long flatCritChanceMod) {
        this.flatCritChanceMod = flatCritChanceMod;
        return this;
    }

    @JsonProperty("rFlatCritChanceModPerLevel")
    public Long getRFlatCritChanceModPerLevel() {
        return rFlatCritChanceModPerLevel;
    }

    @JsonProperty("rFlatCritChanceModPerLevel")
    public void setRFlatCritChanceModPerLevel(Long rFlatCritChanceModPerLevel) {
        this.rFlatCritChanceModPerLevel = rFlatCritChanceModPerLevel;
    }

    public Stats withRFlatCritChanceModPerLevel(Long rFlatCritChanceModPerLevel) {
        this.rFlatCritChanceModPerLevel = rFlatCritChanceModPerLevel;
        return this;
    }

    @JsonProperty("PercentCritChanceMod")
    public Long getPercentCritChanceMod() {
        return percentCritChanceMod;
    }

    @JsonProperty("PercentCritChanceMod")
    public void setPercentCritChanceMod(Long percentCritChanceMod) {
        this.percentCritChanceMod = percentCritChanceMod;
    }

    public Stats withPercentCritChanceMod(Long percentCritChanceMod) {
        this.percentCritChanceMod = percentCritChanceMod;
        return this;
    }

    @JsonProperty("FlatCritDamageMod")
    public Long getFlatCritDamageMod() {
        return flatCritDamageMod;
    }

    @JsonProperty("FlatCritDamageMod")
    public void setFlatCritDamageMod(Long flatCritDamageMod) {
        this.flatCritDamageMod = flatCritDamageMod;
    }

    public Stats withFlatCritDamageMod(Long flatCritDamageMod) {
        this.flatCritDamageMod = flatCritDamageMod;
        return this;
    }

    @JsonProperty("rFlatCritDamageModPerLevel")
    public Long getRFlatCritDamageModPerLevel() {
        return rFlatCritDamageModPerLevel;
    }

    @JsonProperty("rFlatCritDamageModPerLevel")
    public void setRFlatCritDamageModPerLevel(Long rFlatCritDamageModPerLevel) {
        this.rFlatCritDamageModPerLevel = rFlatCritDamageModPerLevel;
    }

    public Stats withRFlatCritDamageModPerLevel(Long rFlatCritDamageModPerLevel) {
        this.rFlatCritDamageModPerLevel = rFlatCritDamageModPerLevel;
        return this;
    }

    @JsonProperty("PercentCritDamageMod")
    public Long getPercentCritDamageMod() {
        return percentCritDamageMod;
    }

    @JsonProperty("PercentCritDamageMod")
    public void setPercentCritDamageMod(Long percentCritDamageMod) {
        this.percentCritDamageMod = percentCritDamageMod;
    }

    public Stats withPercentCritDamageMod(Long percentCritDamageMod) {
        this.percentCritDamageMod = percentCritDamageMod;
        return this;
    }

    @JsonProperty("FlatBlockMod")
    public Long getFlatBlockMod() {
        return flatBlockMod;
    }

    @JsonProperty("FlatBlockMod")
    public void setFlatBlockMod(Long flatBlockMod) {
        this.flatBlockMod = flatBlockMod;
    }

    public Stats withFlatBlockMod(Long flatBlockMod) {
        this.flatBlockMod = flatBlockMod;
        return this;
    }

    @JsonProperty("PercentBlockMod")
    public Long getPercentBlockMod() {
        return percentBlockMod;
    }

    @JsonProperty("PercentBlockMod")
    public void setPercentBlockMod(Long percentBlockMod) {
        this.percentBlockMod = percentBlockMod;
    }

    public Stats withPercentBlockMod(Long percentBlockMod) {
        this.percentBlockMod = percentBlockMod;
        return this;
    }

    @JsonProperty("FlatSpellBlockMod")
    public Long getFlatSpellBlockMod() {
        return flatSpellBlockMod;
    }

    @JsonProperty("FlatSpellBlockMod")
    public void setFlatSpellBlockMod(Long flatSpellBlockMod) {
        this.flatSpellBlockMod = flatSpellBlockMod;
    }

    public Stats withFlatSpellBlockMod(Long flatSpellBlockMod) {
        this.flatSpellBlockMod = flatSpellBlockMod;
        return this;
    }

    @JsonProperty("rFlatSpellBlockModPerLevel")
    public Long getRFlatSpellBlockModPerLevel() {
        return rFlatSpellBlockModPerLevel;
    }

    @JsonProperty("rFlatSpellBlockModPerLevel")
    public void setRFlatSpellBlockModPerLevel(Long rFlatSpellBlockModPerLevel) {
        this.rFlatSpellBlockModPerLevel = rFlatSpellBlockModPerLevel;
    }

    public Stats withRFlatSpellBlockModPerLevel(Long rFlatSpellBlockModPerLevel) {
        this.rFlatSpellBlockModPerLevel = rFlatSpellBlockModPerLevel;
        return this;
    }

    @JsonProperty("PercentSpellBlockMod")
    public Long getPercentSpellBlockMod() {
        return percentSpellBlockMod;
    }

    @JsonProperty("PercentSpellBlockMod")
    public void setPercentSpellBlockMod(Long percentSpellBlockMod) {
        this.percentSpellBlockMod = percentSpellBlockMod;
    }

    public Stats withPercentSpellBlockMod(Long percentSpellBlockMod) {
        this.percentSpellBlockMod = percentSpellBlockMod;
        return this;
    }

    @JsonProperty("FlatEXPBonus")
    public Long getFlatEXPBonus() {
        return flatEXPBonus;
    }

    @JsonProperty("FlatEXPBonus")
    public void setFlatEXPBonus(Long flatEXPBonus) {
        this.flatEXPBonus = flatEXPBonus;
    }

    public Stats withFlatEXPBonus(Long flatEXPBonus) {
        this.flatEXPBonus = flatEXPBonus;
        return this;
    }

    @JsonProperty("PercentEXPBonus")
    public Long getPercentEXPBonus() {
        return percentEXPBonus;
    }

    @JsonProperty("PercentEXPBonus")
    public void setPercentEXPBonus(Long percentEXPBonus) {
        this.percentEXPBonus = percentEXPBonus;
    }

    public Stats withPercentEXPBonus(Long percentEXPBonus) {
        this.percentEXPBonus = percentEXPBonus;
        return this;
    }

    @JsonProperty("rPercentCooldownMod")
    public Long getRPercentCooldownMod() {
        return rPercentCooldownMod;
    }

    @JsonProperty("rPercentCooldownMod")
    public void setRPercentCooldownMod(Long rPercentCooldownMod) {
        this.rPercentCooldownMod = rPercentCooldownMod;
    }

    public Stats withRPercentCooldownMod(Long rPercentCooldownMod) {
        this.rPercentCooldownMod = rPercentCooldownMod;
        return this;
    }

    @JsonProperty("rPercentCooldownModPerLevel")
    public Long getRPercentCooldownModPerLevel() {
        return rPercentCooldownModPerLevel;
    }

    @JsonProperty("rPercentCooldownModPerLevel")
    public void setRPercentCooldownModPerLevel(Long rPercentCooldownModPerLevel) {
        this.rPercentCooldownModPerLevel = rPercentCooldownModPerLevel;
    }

    public Stats withRPercentCooldownModPerLevel(Long rPercentCooldownModPerLevel) {
        this.rPercentCooldownModPerLevel = rPercentCooldownModPerLevel;
        return this;
    }

    @JsonProperty("rFlatTimeDeadMod")
    public Long getRFlatTimeDeadMod() {
        return rFlatTimeDeadMod;
    }

    @JsonProperty("rFlatTimeDeadMod")
    public void setRFlatTimeDeadMod(Long rFlatTimeDeadMod) {
        this.rFlatTimeDeadMod = rFlatTimeDeadMod;
    }

    public Stats withRFlatTimeDeadMod(Long rFlatTimeDeadMod) {
        this.rFlatTimeDeadMod = rFlatTimeDeadMod;
        return this;
    }

    @JsonProperty("rFlatTimeDeadModPerLevel")
    public Long getRFlatTimeDeadModPerLevel() {
        return rFlatTimeDeadModPerLevel;
    }

    @JsonProperty("rFlatTimeDeadModPerLevel")
    public void setRFlatTimeDeadModPerLevel(Long rFlatTimeDeadModPerLevel) {
        this.rFlatTimeDeadModPerLevel = rFlatTimeDeadModPerLevel;
    }

    public Stats withRFlatTimeDeadModPerLevel(Long rFlatTimeDeadModPerLevel) {
        this.rFlatTimeDeadModPerLevel = rFlatTimeDeadModPerLevel;
        return this;
    }

    @JsonProperty("rPercentTimeDeadMod")
    public Long getRPercentTimeDeadMod() {
        return rPercentTimeDeadMod;
    }

    @JsonProperty("rPercentTimeDeadMod")
    public void setRPercentTimeDeadMod(Long rPercentTimeDeadMod) {
        this.rPercentTimeDeadMod = rPercentTimeDeadMod;
    }

    public Stats withRPercentTimeDeadMod(Long rPercentTimeDeadMod) {
        this.rPercentTimeDeadMod = rPercentTimeDeadMod;
        return this;
    }

    @JsonProperty("rPercentTimeDeadModPerLevel")
    public Long getRPercentTimeDeadModPerLevel() {
        return rPercentTimeDeadModPerLevel;
    }

    @JsonProperty("rPercentTimeDeadModPerLevel")
    public void setRPercentTimeDeadModPerLevel(Long rPercentTimeDeadModPerLevel) {
        this.rPercentTimeDeadModPerLevel = rPercentTimeDeadModPerLevel;
    }

    public Stats withRPercentTimeDeadModPerLevel(Long rPercentTimeDeadModPerLevel) {
        this.rPercentTimeDeadModPerLevel = rPercentTimeDeadModPerLevel;
        return this;
    }

    @JsonProperty("rFlatGoldPer10Mod")
    public Long getRFlatGoldPer10Mod() {
        return rFlatGoldPer10Mod;
    }

    @JsonProperty("rFlatGoldPer10Mod")
    public void setRFlatGoldPer10Mod(Long rFlatGoldPer10Mod) {
        this.rFlatGoldPer10Mod = rFlatGoldPer10Mod;
    }

    public Stats withRFlatGoldPer10Mod(Long rFlatGoldPer10Mod) {
        this.rFlatGoldPer10Mod = rFlatGoldPer10Mod;
        return this;
    }

    @JsonProperty("rFlatMagicPenetrationMod")
    public Long getRFlatMagicPenetrationMod() {
        return rFlatMagicPenetrationMod;
    }

    @JsonProperty("rFlatMagicPenetrationMod")
    public void setRFlatMagicPenetrationMod(Long rFlatMagicPenetrationMod) {
        this.rFlatMagicPenetrationMod = rFlatMagicPenetrationMod;
    }

    public Stats withRFlatMagicPenetrationMod(Long rFlatMagicPenetrationMod) {
        this.rFlatMagicPenetrationMod = rFlatMagicPenetrationMod;
        return this;
    }

    @JsonProperty("rFlatMagicPenetrationModPerLevel")
    public Long getRFlatMagicPenetrationModPerLevel() {
        return rFlatMagicPenetrationModPerLevel;
    }

    @JsonProperty("rFlatMagicPenetrationModPerLevel")
    public void setRFlatMagicPenetrationModPerLevel(Long rFlatMagicPenetrationModPerLevel) {
        this.rFlatMagicPenetrationModPerLevel = rFlatMagicPenetrationModPerLevel;
    }

    public Stats withRFlatMagicPenetrationModPerLevel(Long rFlatMagicPenetrationModPerLevel) {
        this.rFlatMagicPenetrationModPerLevel = rFlatMagicPenetrationModPerLevel;
        return this;
    }

    @JsonProperty("rPercentMagicPenetrationMod")
    public Long getRPercentMagicPenetrationMod() {
        return rPercentMagicPenetrationMod;
    }

    @JsonProperty("rPercentMagicPenetrationMod")
    public void setRPercentMagicPenetrationMod(Long rPercentMagicPenetrationMod) {
        this.rPercentMagicPenetrationMod = rPercentMagicPenetrationMod;
    }

    public Stats withRPercentMagicPenetrationMod(Long rPercentMagicPenetrationMod) {
        this.rPercentMagicPenetrationMod = rPercentMagicPenetrationMod;
        return this;
    }

    @JsonProperty("rPercentMagicPenetrationModPerLevel")
    public Long getRPercentMagicPenetrationModPerLevel() {
        return rPercentMagicPenetrationModPerLevel;
    }

    @JsonProperty("rPercentMagicPenetrationModPerLevel")
    public void setRPercentMagicPenetrationModPerLevel(Long rPercentMagicPenetrationModPerLevel) {
        this.rPercentMagicPenetrationModPerLevel = rPercentMagicPenetrationModPerLevel;
    }

    public Stats withRPercentMagicPenetrationModPerLevel(Long rPercentMagicPenetrationModPerLevel) {
        this.rPercentMagicPenetrationModPerLevel = rPercentMagicPenetrationModPerLevel;
        return this;
    }

    @JsonProperty("FlatEnergyRegenMod")
    public Long getFlatEnergyRegenMod() {
        return flatEnergyRegenMod;
    }

    @JsonProperty("FlatEnergyRegenMod")
    public void setFlatEnergyRegenMod(Long flatEnergyRegenMod) {
        this.flatEnergyRegenMod = flatEnergyRegenMod;
    }

    public Stats withFlatEnergyRegenMod(Long flatEnergyRegenMod) {
        this.flatEnergyRegenMod = flatEnergyRegenMod;
        return this;
    }

    @JsonProperty("rFlatEnergyRegenModPerLevel")
    public Long getRFlatEnergyRegenModPerLevel() {
        return rFlatEnergyRegenModPerLevel;
    }

    @JsonProperty("rFlatEnergyRegenModPerLevel")
    public void setRFlatEnergyRegenModPerLevel(Long rFlatEnergyRegenModPerLevel) {
        this.rFlatEnergyRegenModPerLevel = rFlatEnergyRegenModPerLevel;
    }

    public Stats withRFlatEnergyRegenModPerLevel(Long rFlatEnergyRegenModPerLevel) {
        this.rFlatEnergyRegenModPerLevel = rFlatEnergyRegenModPerLevel;
        return this;
    }

    @JsonProperty("FlatEnergyPoolMod")
    public Long getFlatEnergyPoolMod() {
        return flatEnergyPoolMod;
    }

    @JsonProperty("FlatEnergyPoolMod")
    public void setFlatEnergyPoolMod(Long flatEnergyPoolMod) {
        this.flatEnergyPoolMod = flatEnergyPoolMod;
    }

    public Stats withFlatEnergyPoolMod(Long flatEnergyPoolMod) {
        this.flatEnergyPoolMod = flatEnergyPoolMod;
        return this;
    }

    @JsonProperty("rFlatEnergyModPerLevel")
    public Long getRFlatEnergyModPerLevel() {
        return rFlatEnergyModPerLevel;
    }

    @JsonProperty("rFlatEnergyModPerLevel")
    public void setRFlatEnergyModPerLevel(Long rFlatEnergyModPerLevel) {
        this.rFlatEnergyModPerLevel = rFlatEnergyModPerLevel;
    }

    public Stats withRFlatEnergyModPerLevel(Long rFlatEnergyModPerLevel) {
        this.rFlatEnergyModPerLevel = rFlatEnergyModPerLevel;
        return this;
    }

    @JsonProperty("PercentLifeStealMod")
    public Long getPercentLifeStealMod() {
        return percentLifeStealMod;
    }

    @JsonProperty("PercentLifeStealMod")
    public void setPercentLifeStealMod(Long percentLifeStealMod) {
        this.percentLifeStealMod = percentLifeStealMod;
    }

    public Stats withPercentLifeStealMod(Long percentLifeStealMod) {
        this.percentLifeStealMod = percentLifeStealMod;
        return this;
    }

    @JsonProperty("PercentSpellVampMod")
    public Long getPercentSpellVampMod() {
        return percentSpellVampMod;
    }

    @JsonProperty("PercentSpellVampMod")
    public void setPercentSpellVampMod(Long percentSpellVampMod) {
        this.percentSpellVampMod = percentSpellVampMod;
    }

    public Stats withPercentSpellVampMod(Long percentSpellVampMod) {
        this.percentSpellVampMod = percentSpellVampMod;
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

    public Stats withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
