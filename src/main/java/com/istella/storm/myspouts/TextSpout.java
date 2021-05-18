package com.istella.storm.myspouts;

import org.apache.storm.spout.SpoutOutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.IRichSpout;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Values;
import org.apache.storm.utils.Utils;
import java.util.Map;

/**
 * @author liunan13
 * @date 2020/3/8
 * @description
 */
public class TextSpout implements IRichSpout {
    private SpoutOutputCollector spoutOutputCollector;
    private int index=0;
    private String[] text={"my name is soul",
            "im a boy",
            "i have a dog",
            "my dog has fleas",
            "my girl friend is beautiful"};

    public void open(Map<String, Object> map, TopologyContext topologyContext, SpoutOutputCollector spoutOutputCollector) {
        this.spoutOutputCollector=spoutOutputCollector;
    }

    public void close() {

    }

    public void activate() {

    }

    public void deactivate() {

    }

    public void nextTuple() {
        if (index>=text.length){
            index=0;
        }else {
            this.spoutOutputCollector.emit(new Values(text[index]));
        }
        index++;
        Utils.sleep(100);

    }

    public void ack(Object o) {

    }

    public void fail(Object o) {

    }

    public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {
        outputFieldsDeclarer.declare(new Fields("text"));
    }

    public Map<String, Object> getComponentConfiguration() {
        return null;
    }
}
