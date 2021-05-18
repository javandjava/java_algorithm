package com.istella.storm.mybolts;

import org.apache.storm.task.OutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichBolt;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Tuple;
import org.apache.storm.tuple.Values;

import java.util.Map;

/**
 * @author liunan13
 * @date 2020/3/8
 * @description
 */
public class SplitTextBolt extends BaseRichBolt {
    private OutputCollector outputCollector;
    public void prepare(Map<String, Object> map, TopologyContext topologyContext, OutputCollector outputCollector) {
        this.outputCollector=outputCollector;
    }

    public void execute(Tuple tuple) {
        String t=tuple.getStringByField("text");
        String[] words=t.split("[ ]");
        for (String word:words){
            this.outputCollector.emit(new Values(word));
        }
    }

    public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {
        outputFieldsDeclarer.declare(new Fields("word"));
    }
}
