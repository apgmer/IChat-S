package me.xiaotian.ichat.web.common;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by guoxiaotian on 2017/5/4.
 */
public class ResultMap {

    private Map<String, Object> resMap;

    public ResultMap() {
        this.resMap = new HashMap<String, Object>();
    }

    public void setStatus(boolean status){
        this.resMap.put("success",status);
    }

    public void setData(Object obj){
        this.resMap.put("data",obj);
    }

    public Map<String ,Object> getResMap(){
        return this.resMap;
    }
}
