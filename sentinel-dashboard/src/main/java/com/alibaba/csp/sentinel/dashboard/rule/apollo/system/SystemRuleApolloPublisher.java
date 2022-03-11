package com.alibaba.csp.sentinel.dashboard.rule.apollo.system;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.SystemRuleEntity;
import com.alibaba.csp.sentinel.dashboard.rule.DynamicRulePublisher;
import com.alibaba.csp.sentinel.dashboard.rule.apollo.ApolloCommonService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author chunming.ygy@gmail.com
 * @date 2022/1/11 10:57
 */
@Component("systemRuleApolloPublisher")
public class SystemRuleApolloPublisher implements DynamicRulePublisher<List<SystemRuleEntity>> {

    @Resource
    private ApolloCommonService apolloCommonService;
    @Value("${system.key.suffix:system}")
    private String systemDataIdSuffix;

    @Override
    public void publish(String app, List<SystemRuleEntity> rules) throws Exception {
        apolloCommonService.publishRules(app, systemDataIdSuffix, JSON.toJSONString(rules));
    }
}
