package com.alibaba.csp.sentinel.dashboard.rule.apollo.authority;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.AbstractRuleEntity;
import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.AuthorityRuleEntity;
import com.alibaba.csp.sentinel.dashboard.rule.DynamicRulePublisher;
import com.alibaba.csp.sentinel.dashboard.rule.apollo.ApolloCommonService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author chunming.ygy@gmail.com
 * @date 2022/1/13 20:38
 */
@Component("authorityRuleApolloPublisher")
public class AuthorityRuleApolloPublisher implements DynamicRulePublisher<List<AuthorityRuleEntity>> {

    @Resource
    private ApolloCommonService apolloCommonService;
    @Value("${authority.key.suffix:authority}")
    private String authorityDataIdSuffix;

    @Override
    public void publish(String app, List<AuthorityRuleEntity> rules) throws Exception {
        apolloCommonService.publishRules(app, authorityDataIdSuffix, JSON.toJSONString(rules.stream().map(AbstractRuleEntity::getRule).collect(Collectors.toList())));
    }
}
