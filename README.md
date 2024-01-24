# Kroxylicious WASM Filter Sample

This sample filter project provides an example usage of [custom filters](https://kroxylicious.io/kroxylicious/#_custom_filters) in Kroxylicious.
Here we leverage a pure Java Wasm interpreter called [Chicory](https://github.com/dylibso/chicory) to build a filter that can be dynamically reconfigured with arbitrary "compiled to Wasm" programs.

To learn more about Kroxylicious, visit the [docs](https://kroxylicious.io/kroxylicious).
To learn more about Chicory, visit the [docs](https://github.com/dylibso/chicory?tab=readme-ov-file#chicory-runtime).

## Getting started

### Build

Building the sample project is easy!

```shell
mvn verify
```

### Configure

Filters can be added and removed by altering the `filters` list in the `sample-proxy-config.yml` file. You can also reconfigure the sample filters by changing the configuration values in this file.

The **SampleFetchResponseFilter** and **SampleProduceRequestFilter** each have two configuration values that must be specified for them to work:

 - `replacerModule` - the string represent the wasm module to be loaded

#### Default Configuration


The default configuration for **SampleProduceRequestFilter** is:

```yaml
filters:
  - type: SampleProduceRequestFilterFactory
    config:
      replacerModule: foobar.wasm
```

This means that it will execute the `foobar.wasm` module compiled from the Rust program `foobar.wasm`. 

The default configuration for **SampleFetchResponseFilter** is:

```yaml
filters:
  - type: SampleFetchResponseFilterFactory
    config:
      replacerModule: barbaz.wasm
```

This means that it will execute the `barbaz.wasm` module compiled from the Rust program `barbaz.wasm`.
