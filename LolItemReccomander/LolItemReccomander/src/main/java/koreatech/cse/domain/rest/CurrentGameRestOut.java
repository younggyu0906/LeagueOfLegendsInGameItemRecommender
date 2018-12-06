package koreatech.cse.domain.rest;

import koreatech.cse.domain.match.CurrentMatch;

import java.util.HashMap;

//REST로 Json을 보내는 것 테스트용도. currentMatch랑 HashMap보낸다.
public class CurrentGameRestOut {
    CurrentMatch currentMatch;
    HashMap<Integer,Integer> itemFeq;

    public CurrentMatch getCurrentMatch() {
        return currentMatch;
    }

    public void setCurrentMatch(CurrentMatch currentMatch) {
        this.currentMatch = currentMatch;
    }

    public HashMap<Integer, Integer> getItemFeq() {
        return itemFeq;
    }

    public void setItemFeq(HashMap<Integer, Integer> itemFeq) {
        this.itemFeq = itemFeq;
    }
}
