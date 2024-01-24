package io.github.andreatp.kroxylicious.wasm;

import io.kroxylicious.proxy.filter.FilterFactory;
import io.kroxylicious.proxy.filter.FilterFactoryContext;
import io.kroxylicious.proxy.plugin.Plugin;
import io.kroxylicious.proxy.plugin.Plugins;
import io.github.andreatp.kroxylicious.wasm.config.SampleFilterConfig;

@Plugin(configType = SampleFilterConfig.class)
public class SampleProduceRequestFilterFactory implements FilterFactory<SampleFilterConfig, SampleFilterConfig> {
    @Override
    public SampleFilterConfig initialize(FilterFactoryContext context, SampleFilterConfig config) {
        return Plugins.requireConfig(this, config);
    }

    @Override
    public SampleProduceRequestFilter createFilter(FilterFactoryContext context, SampleFilterConfig configuration) {
        return new SampleProduceRequestFilter(configuration);
    }

}
