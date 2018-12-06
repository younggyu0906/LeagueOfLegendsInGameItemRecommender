package koreatech.cse.service;

import koreatech.cse.domain.match.CurrentMatch;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.HashMap;

//진행 중인 게임 아이템 추천 + DB에 쌓인 아이템 추천.
@Service
public class ItemAnalysisService {

    @Inject
    DaoService daoService;

    public HashMap<Integer,Integer> getItemsFromCurrentMatch(CurrentMatch currentMatch) {
        //아이템의 빈도수를 저장할 Map 키는 itemCode, 빈도수가 value
        HashMap<Integer,Integer> itemFreq = new HashMap<>();

        //list로 현재 내가 플레이하고있는 챔피언 정보를 가져온다.
        daoService.getFinishedMatches(currentMatch.getMyChampion().getId()).stream().forEach(e->{
            //0번 아이템이 hashmap에 존재하지 않는다면 빈도수 1로 새로 넣고, 존재한다면 1을 추가하여 변경한다.
            int itemCode = e.getItem0Id();
            updateHashMap(itemFreq,itemCode);
            //1번 아이템이 hashmap에 존재하지 않는다면 빈도수 1로 새로 넣고, 존재한다면 1을 추가하여 변경한다.
            itemCode = e.getItem1Id();
            updateHashMap(itemFreq,itemCode);
            //2번 아이템이 hashmap에 존재하지 않는다면 빈도수 1로 새로 넣고, 존재한다면 1을 추가하여 변경한다.
            itemCode = e.getItem2Id();
            updateHashMap(itemFreq,itemCode);
            //3번 아이템이 hashmap에 존재하지 않는다면 빈도수 1로 새로 넣고, 존재한다면 1을 추가하여 변경한다.
            itemCode = e.getItem3Id();
            updateHashMap(itemFreq,itemCode);
            //4번 아이템이 hashmap에 존재하지 않는다면 빈도수 1로 새로 넣고, 존재한다면 1을 추가하여 변경한다.
            itemCode = e.getItem4Id();
            updateHashMap(itemFreq,itemCode);
            //5번 아이템이 hashmap에 존재하지 않는다면 빈도수 1로 새로 넣고, 존재한다면 1을 추가하여 변경한다.
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

    //반복되는 문장 함수로 뺏따리 map에서 빈도수 체크해서 있으면 +1 없으면 새로넣기
    private void updateHashMap(HashMap<Integer,Integer> itemFreq, int itemCode) {
        //itemCode0이면 none이니까 넣지말자.
        if (itemCode == 0) { return; }
        else if (itemFreq.get(itemCode) == null) {
            itemFreq.put(itemCode,1);
        }
        else if(itemFreq.get(itemCode) != null) {
            itemFreq.replace(itemCode,itemFreq.get(itemCode)+1);
        }
    }
}
