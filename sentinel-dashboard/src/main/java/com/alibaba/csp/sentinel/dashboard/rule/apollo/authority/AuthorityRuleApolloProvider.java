package com.alibaba.csp.sentinel.dashboard.rule.apollo.authority;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.AuthorityRuleEntity;
import com.alibaba.csp.sentinel.dashboard.rule.DynamicRuleProvider;
import com.alibaba.csp.sentinel.dashboard.rule.apollo.ApolloCommonService;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityRule;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author chunming.ygy@gmail.com
 * @date 2022/1/14 22:26
 */
@Component("authorityRuleApolloProvider")
public class AuthorityRuleApolloProvider implements DynamicRuleProvider<List<AuthorityRuleEntity>> {

    @Resource
    private ApolloCommonService apolloCommonService;
    @Value("${authority.key.suffix:authority}")
    private String authorityDataIdSuffix;

    @Override
    public List<AuthorityRuleEntity> getRules(String appName) throws Exception {
        List<AuthorityRule> flow = apolloCommonService.getRules(appName, authorityDataIdSuffix, AuthorityRule.class);
        return flow.stream().map(AuthorityRuleEntity::new).collect(Collectors.toList());
    }
}
