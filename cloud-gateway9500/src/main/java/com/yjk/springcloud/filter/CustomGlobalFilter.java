package com.yjk.springcloud.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author: yujikuan
 * @Description: 自定义过滤器
 */
@Component
@Slf4j
public class CustomGlobalFilter implements GlobalFilter, Ordered {


    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        // pre start 前置处理
        MultiValueMap<String, String> queryParams = exchange.getRequest().getQueryParams();
        Set<Map.Entry<String, List<String>>> entries = queryParams.entrySet();

        entries.forEach(item -> {

            log.info(item.getKey() + "=" + item.getValue().toString());
        });


        // 如果没有传递假如auth，不让其通过。
        String auth = queryParams.getFirst("auth");
        if (auth == null) {
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }

        //pre  end

        return chain.filter(exchange).then(Mono.fromRunnable(()-> {

                    //post 后置处理，我假如把auth的参数，假如header之中了。
                    if (!exchange.getResponse().isCommitted()) {
                        exchange.getResponse().getHeaders().add("auth", auth);

                    }
                }

        ));
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
