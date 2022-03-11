package com.alibaba.csp.sentinel.dashboard.rule.apollo.system;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.SystemRuleEntity;
import com.alibaba.csp.sentinel.dashboard.rule.DynamicRuleProvider;
import com.alibaba.csp.sentinel.dashboard.rule.apollo.ApolloCommonService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author chunming.ygy@gmail.com
 * @date 2022/1/12 21:56
 */
@Component("systemRuleApolloProvider")
public class SystemRuleApolloProvider implements DynamicRuleProvider<List<SystemRuleEntity>> {

    @Resource
    private ApolloCommonService apolloCommonService;
    @Value("${system.key.suffix:system}")
    private String systemDataIdSuffix;

    @Override
    public List<SystemRuleEntity> getRules(String appName) throws Exception {
        return apolloCommonService.getRules(appName, systemDataIdSuffix, SystemRuleEntity.class);
    }
}
