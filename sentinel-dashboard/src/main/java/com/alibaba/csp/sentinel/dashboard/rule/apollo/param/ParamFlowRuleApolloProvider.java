package com.alibaba.csp.sentinel.dashboard.rule.apollo.param;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.ParamFlowRuleEntity;
import com.alibaba.csp.sentinel.dashboard.rule.DynamicRuleProvider;
import com.alibaba.csp.sentinel.dashboard.rule.apollo.ApolloCommonService;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowRule;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author chunming.ygy@gmail.com
 * @date 2022/1/14 10:53
 */
@Component("paramFlowRuleApolloProvider")
public class ParamFlowRuleApolloProvider implements DynamicRuleProvider<List<ParamFlowRuleEntity>> {

    @Resource
    private ApolloCommonService apolloCommonService;
    @Value("${param.key.suffix:param_flow}")
    private String paramDataIdSuffix;

    @Override
    public List<ParamFlowRuleEntity> getRules(String appName) throws Exception {
        List<ParamFlowRule> flow = apolloCommonService.getRules(appName, paramDataIdSuffix, ParamFlowRule.class);
        return flow.stream().map(ParamFlowRuleEntity::new).collect(Collectors.toList());
    }
}
