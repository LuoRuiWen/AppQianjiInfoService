package com.qianjitec.informations.utils;

import com.qianjitec.common.security.ErrorCode;
import com.qianjitec.common.utils.ResultData;

import java.util.List;

public class ControllerRepeateUtil {
    public static ResultData getResultData(String msg,Object obj){
        ResultData resultData = new ResultData();
        if (obj instanceof List) {
            List list = (List) obj;
            if (list == null && list.size() == 0) {
                resultData.setCode(ErrorCode.SERVICE_ERROR);
                resultData.setMsg("暂无" + msg);
            } else {
                resultData.setCode(ErrorCode.SUCCESS);
                resultData.setMsg("获取" + msg + "成功!");
            }
            resultData.setData(list);
        } else {
            if (obj == null) {
                resultData.setCode(ErrorCode.SERVICE_ERROR);
                resultData.setMsg("获取" + msg + "失败");
            } else {
                resultData.setCode(ErrorCode.SUCCESS);
                resultData.setMsg("获取" + msg + "成功!");
            }
            resultData.setData(obj);
        }
        return resultData;
    }

    public static ResultData getResultData(String msg,int count){
        ResultData resultData = new ResultData();
        if (count<=0){
            resultData.setCode(ErrorCode.SERVICE_ERROR);
            resultData.setMsg(msg + "失败");
        }else{
            resultData.setCode(ErrorCode.SUCCESS);
            resultData.setMsg(msg + "成功");
        }
        resultData.setData(count);
        return resultData;
    }
}
