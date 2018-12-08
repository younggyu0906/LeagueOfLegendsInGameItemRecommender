package koreatech.cse.service;

import koreatech.cse.domain.match.CurrentMatch;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.HashMap;

// Recommend item in progress game and DB
@Service
public class ItemAnalysisService {

    @Inject
    DaoService daoService;

    public HashMap<Integer,Integer> getItemsFromCurrentMatch(CurrentMatch currentMatch) {
        // map to save the frequency of items. key is itemCode and value is frequency.
        HashMap<Integer,Integer> itemFreq = new HashMap<>();


        // Bring the champion information currently playing to the list.
        daoService.getFinishedMatches(currentMatch.getMyChampion().getId()).stream().forEach(e->{
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
}
