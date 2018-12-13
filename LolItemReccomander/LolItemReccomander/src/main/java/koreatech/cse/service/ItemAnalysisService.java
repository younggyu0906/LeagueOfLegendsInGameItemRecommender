package koreatech.cse.service;

import koreatech.cse.domain.match.CurrentMatch;
import koreatech.cse.domain.match.FinishedMatch;
import koreatech.cse.domain.staticData.ChampionDAO;
import koreatech.cse.domain.staticData.ItemDAO;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.HashMap;

// Recommend item in progress game and DB
@Service
public class ItemAnalysisService {

    @Inject
    DaoService daoService;

    public HashMap<Integer,Integer> getItemsFromCurrentMatch(CurrentMatch currentMatch) {
        // map to save the frequency of items. key is itemCode and value is frequency.
        HashMap<Integer,Integer> itemFreq = new HashMap<>();
        ArrayList<FinishedMatch> finishedMatches = daoService.getFinishedMatches(currentMatch.getMyChampion().getId());
        // Bring the champion information currently playing to the list.
        finishedMatches.stream().forEach(e->{
            int itemCode;
            // 아이템이 존재하지 않으면 빈도수가 0? 1?
            // 0번 아이템이 hashmap에 존재하지 않는다면 빈도수 1로 새로 넣고, 존재한다면 1을 추가하여 변경한다.

            // If the item is not in the hash map, the frequency is 1, else +1.
            // 6th item is ward ornament. Don't use.
            itemCode = e.getItem0Id();
            updateHashMap(itemFreq,itemCode);
            itemCode = e.getItem1Id();
            updateHashMap(itemFreq,itemCode);
            itemCode = e.getItem2Id();
            updateHashMap(itemFreq,itemCode);
            itemCode = e.getItem3Id();
            updateHashMap(itemFreq,itemCode);
            itemCode = e.getItem4Id();
            updateHashMap(itemFreq,itemCode);
            itemCode = e.getItem5Id();
            updateHashMap(itemFreq,itemCode);
//            //6번 아이템은 보통 와드니까 넣지말자.
//            itemCode = e.getItem6Id();
//            updateHashMap(itemFreq,itemCode);
        });
        //print log
        System.out.println(itemFreq);

        return itemFreq;
    }

    // If the item is not in the hash map, the frequency is 1, else +1.
    private void updateHashMap(HashMap<Integer,Integer> itemFreq, int itemCode) {
        // If item code is 0, there is no item.
        if (itemCode == 0) { return; }
        else if (itemFreq.get(itemCode) == null) {
            itemFreq.put(itemCode,1);
        }
        else if(itemFreq.get(itemCode) != null) {
            itemFreq.replace(itemCode,itemFreq.get(itemCode)+1);
        }
    }

    //스탯 업데이트 함수.
    private void updateHashMap(HashMap<String,Integer> stats, String statName, int stat) {

        if (stats.get(statName) == null) {
            stats.put(statName,stat);
        }
        else if(stats.get(statName) != null) {
            stats.replace(statName,stats.get(statName)+stat);
        }
    }


    //아이템 추천 하자.. ArrayList로 추천 아이템들을 반환한다.
    //currentMatch를 매개변수로 받자.
    public HashMap<ItemDAO, Double> recommendItemCurrentMatch(CurrentMatch currentMatch) {
        //반환할때 사용할 빈 ArrayList
        HashMap<ItemDAO, Double> returnVal = new HashMap<>();
        //일단 내 챔피언이 갔던 아이템 목록을 반환받아 온다.
        HashMap<Integer, Integer> itemFreq = getItemsFromCurrentMatch(currentMatch);

        //아이템 코드를 빼 오고 해당 코드에 대한 DAO 를 가져와서 저장할 코드
        int maxFreqItem;
        ItemDAO maxFreqItemDAO;
        //추천할 아이템이 6개가 넘었거나 itemFreq가 빌 때까지 while문 돌린다.
        while(returnVal.size() < 7 && !itemFreq.isEmpty()) {
            //일단 가장 많이 갔던 아이템을 하나 빼 온다.
            maxFreqItem = returnMaxValue(itemFreq);
            maxFreqItemDAO = daoService.getItemDAO(maxFreqItem);

//          빼 온 아이템이 현재 상황에 적절한지 검사할 코드를

            //팀 스탯, 적 팀 스탯 전부 더함.
            HashMap<String,Integer> elloStat = calcTeamStats(currentMatch);
            HashMap<String,Integer> enemyStat = calcEnemyStats(currentMatch);

            //팀 스텟, 나의 태그 등 비교해서 참이면 returnVal에 넣는다.
            returnVal.put(maxFreqItemDAO,maxFreqItem * judgeItem(maxFreqItemDAO, currentMatch.getMyChampion(),elloStat,enemyStat));
        }
        System.out.println(returnVal);
        return returnVal;
    }

    //팀 스탯을 전부 더하여 HashMap으로 반환해주는 함수
    private HashMap<String,Integer> calcTeamStats(CurrentMatch currentMatch) {
        HashMap<String,Integer> teamStats = new HashMap<>();
        for (ChampionDAO e : currentMatch.getTeamChampions()) {
            calcStats(teamStats, e);
        }
        return teamStats;
    }

    //안에 for문 함수로 내뺌
    private void calcStats(HashMap<String,Integer> maps, ChampionDAO championDAO) {
        updateHashMap(maps,"Attack",championDAO.getAttack());
        updateHashMap(maps,"Magic",championDAO.getMagic());
        updateHashMap(maps,"Defense",championDAO.getDefense());
        updateHashMap(maps,"Difficulty",championDAO.getDifficulty());

        //일단 디폴트 0으로 넣어준다.
        maps.put("Assassin",0);
        maps.put("Fighter",0);
        maps.put("Mage",0);
        maps.put("Marksman",0);
        maps.put("Support",0);
        maps.put("Tank",0);

        //태그 빈도 수 체크
        if (championDAO.isAssassin()) updateHashMap(maps,"Assassin",1);
        if (championDAO.isFighter())  updateHashMap(maps,"Fighter",1);
        if (championDAO.isMage())     updateHashMap(maps,"Mage",1);
        if (championDAO.isMarksman()) updateHashMap(maps,"Marksman",1);
        if (championDAO.isSupport())  updateHashMap(maps,"Support",1);
        if (championDAO.isTank())     updateHashMap(maps,"Tank",1);
    }

    //적팀 스탯을 전부 더하여 HashMap으로 반환해주는 함수
    private HashMap<String,Integer> calcEnemyStats(CurrentMatch currentMatch) {
        HashMap<String,Integer> enemyStats = new HashMap<>();
        for (ChampionDAO e : currentMatch.getEnemyChampions()) {
            calcStats(enemyStats, e);
        }
        return enemyStats;
    }

    //HashMap에서 Value중에 제일 큰 아이템(KEY) 빼오는 함수
    //뻬고 그 키 값과 value는 삭제한다. stack pop처럼
    private Integer returnMaxValue(HashMap<Integer, Integer> hashMap) {
        //비었으면 null반환. 실행안해
        if (hashMap.isEmpty()) return null;

        int maxValKey = 0;
        int maxValue = 0;
        //hashMap을 쭉 훑으면서 큰 놈을 저장.
        for (Integer e : hashMap.keySet()) {
            if (hashMap.get(e) > maxValue) {
                maxValKey = e;
                maxValue = hashMap.get(e);
            }
        }
        //제일 많았던 아이템 Map에서 빼버림 그리고 반환
        hashMap.remove(maxValKey);
        return maxValKey;
    }

    //**************************************************************************************************************
    //아이템이 적팀, 우리팀 상황에 지금 적절한지를 판단한다. 추추추추추천하는 알고리즘이 여기
    private Double judgeItem(ItemDAO item, ChampionDAO myChampion, HashMap<String, Integer> teamStats, HashMap<String,Integer> enemyStats) {


        return 1.0;
    }

    //아이템의 가중치계산
    private Double calcWeight(ItemDAO item, ItemClass itemClass) {
        double weight = 0;

        //itemClass에 맞게 가중치를 계산합니다.
        if (itemClass == ItemClass.PHYSICAL_ATTACK) {
            weight += 100*item.getAttackSpeed(); // 공속 소수점이라서 100곱함.
            weight += 100*item.getCritChance(); // 크리티컬
            weight += 1*item.getPhysicalDamage(); // 공격력
        }
        else if (itemClass == ItemClass.MAGIC_ATTACK) {
            weight += 1*item.getMagicDamage();  //AP
        }
        else if (itemClass == ItemClass.PHYSICAL_DEFENCE) {
            weight += 0.7*item.getHealth(); //체력
            weight += 1*item.getArmor();    //방어력
        }
        else if (itemClass == ItemClass.MAGIC_DEFENCE) {
            weight += 0.7*item.getHealth();
            weight += 1*item.getSpellBlock();
        }
        //print log
        System.out.println(itemClass);
        System.out.println(item);
        System.out.println(" ");
        return weight;
    }

    //
    private enum ItemClass {
        PHYSICAL_ATTACK, MAGIC_ATTACK, PHYSICAL_DEFENCE, MAGIC_DEFENCE
        @Override
        public String toString() {
            return this.name();
        }
    }
}
