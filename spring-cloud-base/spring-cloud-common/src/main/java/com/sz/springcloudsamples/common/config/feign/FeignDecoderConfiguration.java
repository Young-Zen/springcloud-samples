package com.sz.springcloudsamples.common.config.feign;

import com.sz.springcloudsamples.common.mvc.constant.ConstantForHttpHeader;
import com.sz.springcloudsamples.common.thread.threadlocal.LogHolder;
import feign.FeignException;
import feign.Response;
import feign.codec.Decoder;
import feign.codec.ErrorDecoder;
import feign.optionals.OptionalDecoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.ResponseEntityDecoder;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Map;

/**
 * @author Yanghj
 * @date 2023/7/18 14:53
 */
@Configuration
public class FeignDecoderConfiguration {

    @Autowired
    private ObjectFactory<HttpMessageConverters> messageConverters;

    @Bean
    public Decoder feignDecoder() {
        return new OptionalDecoder(
                new ResponseEntityDecoder(new FeignDecoder(this.messageConverters)));
    }

    @Bean
    public ErrorDecoder feignErrorDecoder() {
        return new FeignErrorDecoder();
    }

    public class FeignDecoder extends SpringDecoder {
        public FeignDecoder(ObjectFactory<HttpMessageConverters> messageConverters) {
            super(messageConverters);
        }

        @Override
        public Object decode(Response response, Type type) throws IOException, FeignException {
            setLogStep(response);
            return super.decode(response, type);
        }
    }

    public class FeignErrorDecoder extends ErrorDecoder.Default {

        @Override
        public Exception decode(String methodKey, Response response) {
            setLogStep(response);
            return super.decode(methodKey, response);
        }
    }

    private void setLogStep(Response response) {
        Map<String, Collection<String>> headers = response.headers();
        Collection<String> logSteps = headers.get(ConstantForHttpHeader.LOG_STEP);
        if (!CollectionUtils.isEmpty(logSteps)) {
            LogHolder.getLogDto().setLogStep(Integer.parseInt(logSteps.stream().findFirst().get()));
        }
    }
}
