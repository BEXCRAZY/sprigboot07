package com.springboottest.springboot07.testService.learnspring;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.function.Consumer;

/**
 * @description: excel工具   获取listener 可自定义批处理数据量
 * @date: 2021/2/22
 **/
@Slf4j
public class ExcelUtils<T> {


    //获取读取excel所需的listener
    public static <T> AnalysisEventListener<T> getListener(Consumer<List<T>> consumer, Integer batchNum) {

        log.debug("批处理数据量：", batchNum);

        return new AnalysisEventListener<T>() {

            private LinkedList<T> list = new LinkedList<>();

            @Override
            public void invoke(T t, AnalysisContext analysisContext) {
                log.debug("处理一条数据：{}", t.toString());

                list.add(t);
                if (list.size() >= batchNum) {
                    consumer.accept(list);
                    list.clear();
                }
            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext analysisContext) {
                if (list.size() > 0) {
                    consumer.accept(list);
                }

                log.debug("数据处理完成！");
            }
        };

    }

    //默认批处理数据10条
    public static <T> AnalysisEventListener<T> getListener(Consumer<List<T>> consumer) {

        return ExcelUtils.getListener(consumer, 10);

    }


    /**
     * excel文件上传
     *
     * @param file          文件
     * @param target        model类型
     * @param bathNum       批处理数据量
     * @param headRowNumber excel文件  表头行数
     * @param <T>
     * @return
     */
    public  <T> List<T> readValue(MultipartFile file, T target, Integer bathNum, Integer headRowNumber) {

        ArrayList<T> resultList = new ArrayList<>();

        log.debug("开始上传excel文件，Model类型：{}--批处理量：{}", target.getClass().getSimpleName(), bathNum);

        AnalysisEventListener<Object> listener = ExcelUtils.getListener(list -> resultList.addAll((Collection<? extends T>) list), bathNum);

        try {
            EasyExcel.read(file.getInputStream(), target.getClass(), listener).sheet().headRowNumber(headRowNumber).doRead();
        } catch (IOException e) {
            log.debug("读取文件发生异常");
            e.printStackTrace();
        }

        log.debug("文件读取成功");
        return resultList;
    }


    /**
     *   文件下载
     * @param list 待下载文件
     * @param file  文件
     * @param target model类型
     * @return
     */
    public  String writeValue(List<T> list, File file,T target) {

        HashMap<String, Object> result = new HashMap<>();
        result.put("code", "0");
        result.put("message", "fail!");

        log.debug("写入文件数量：{}", list.size());

        if (list.size() == 0) {

            result.put("message", "写入数据量为0！");
            return JSON.toJSONString(result);
        }

        if (file.exists()) {
            result.put("message","文件已存在");
            return JSON.toJSONString(result);
        }

        EasyExcel.write(file,target.getClass()).sheet().doWrite(list);

        result.put("code", "1");
        result.put("message", "success!");
        return JSON.toJSONString(result);
    }


}
