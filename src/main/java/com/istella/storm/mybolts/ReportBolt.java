package com.istella.storm.mybolts;

import org.apache.storm.task.OutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichBolt;
import org.apache.storm.tuple.Tuple;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liunan13
 * @date 2020/3/8
 * @description
 */
public class ReportBolt extends BaseRichBolt {
//    private Logger logger=LoggerFactory.getLogger(ReportBolt.class);
    private OutputCollector outputCollector;
    private Map<String,Integer> counter;
    public void prepare(Map<String, Object> map, TopologyContext topologyContext, OutputCollector outputCollector) {
        this.outputCollector=outputCollector;
        counter=new HashMap<String, Integer>();
    }

    public void execute(Tuple tuple) {
        String w= tuple.getStringByField("word");
        Integer c=tuple.getIntegerByField("count");
        counter.put(w,c);
    }

    public void cleanup(){
//        logger.info("final summary");
        System.out.println("----- Final -----");
        for(Map.Entry<String,Integer> entry:counter.entrySet()){
            System.out.println("word "+entry.getKey()+", total"+entry.getValue());
//            logger.info("word {},count {}",entry.getKey(),entry.getValue());
        }
        System.out.println("----- Final Over ");
//        logger.info("final summary over");
    }

    public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {

    }
}
