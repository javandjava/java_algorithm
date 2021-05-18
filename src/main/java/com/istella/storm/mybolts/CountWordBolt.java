package com.istella.storm.mybolts;

import org.apache.storm.task.OutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichBolt;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Tuple;
import org.apache.storm.tuple.Values;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liunan13
 * @date 2020/3/8
 * @description
 */
public class CountWordBolt extends BaseRichBolt {
    private Map<String,Integer> counter;
    private OutputCollector outputCollector;
    public void prepare(Map<String, Object> map, TopologyContext topologyContext, OutputCollector outputCollector) {
        this.outputCollector=outputCollector;
        counter=new HashMap<String, Integer>();
    }

    public void execute(Tuple tuple) {
        String word=tuple.getStringByField("word");
        Integer c=counter.get(word);
        if(c==null){
            c=1;
            counter.put(word,1);
        }else {
            counter.put(word,c+1);
        }
        System.out.println("word "+word+",c "+c);
        this.outputCollector.emit(new Values(word,c));
    }

    public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {
        outputFieldsDeclarer.declare(new Fields("word","count"));
    }
}
