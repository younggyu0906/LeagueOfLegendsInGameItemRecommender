package koreatech.cse.service;

import koreatech.cse.domain.match.CurrentMatch;
import koreatech.cse.domain.match.FinishedMatch;
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

    //아이템 추천 하자.. ArrayList로 추천 아이템들을 반환한다.
    //currentMatch를 매개변수로 받자.
    public ArrayList<String> recommendItemCurrentMatch(CurrentMatch currentMatch) {
        //반환할때 사용할 빈 ArrayList
        ArrayList<String> returnVal = new ArrayList<>();
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

//        *****************************************************************
//        빼 온 아이템이 현재 상황에 적절한지 검사할 코드를 만들어야 합니다.
//        *****************************************************************

        }
        System.out.println(returnVal);
        return returnVal;
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
}
