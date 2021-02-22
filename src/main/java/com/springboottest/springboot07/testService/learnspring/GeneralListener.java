package com.springboottest.springboot07.testService.learnspring;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import org.apache.poi.ss.formula.functions.T;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @date: 2021/2/22
 **/
public class GeneralListener extends AnalysisEventListener<T> {

    //批处理数量
    private final int BAT_COUNT = 2;

    //集合批处理数据
    List<T> list = new ArrayList<>(BAT_COUNT);

    @Override
    public void invoke(T t, AnalysisContext analysisContext) {
        System.out.println("处理一条数据："+t.toString());

        list.add(t);
        if (list.size()>=BAT_COUNT){
            //存储数据
            saveData(list);

            list.clear();
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

        saveData(list);

        System.out.println("所有数据解析完成");

    }

    private void saveData(List list){

        System.out.println("存储 "+list.size()+" 条数据。");
    }
}
