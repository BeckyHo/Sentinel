package com.alibaba.csp.sentinel.dashboard.rule.apollo.flow;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.FlowRuleEntity;
import com.alibaba.csp.sentinel.dashboard.rule.DynamicRulePublisher;
import com.alibaba.csp.sentinel.dashboard.rule.apollo.ApolloCommonService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author chunming.ygy@gmail.com
 * @date 2022/1/14 22:01
 */
@Component("flowRuleApolloPublisher")
public class FlowRuleApolloPublisher implements DynamicRulePublisher<List<FlowRuleEntity>> {

    @Resource
    private ApolloCommonService apolloCommonService;
    @Value("${flow.key.suffix:flow}")
    private String flowDataIdSuffix;

    @Override
    public void publish(String app, List<FlowRuleEntity> rules) throws Exception {
        apolloCommonService.publishRules(app, flowDataIdSuffix, JSON.toJSONString(rules));
    }
}
