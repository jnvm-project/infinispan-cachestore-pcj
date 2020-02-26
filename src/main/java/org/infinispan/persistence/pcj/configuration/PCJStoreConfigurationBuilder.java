package org.infinispan.persistence.pcj.configuration;

import static org.infinispan.persistence.pcj.configuration.PCJStoreConfiguration.SAMPLE_ATTRIBUTE;

import org.infinispan.configuration.cache.AbstractStoreConfigurationBuilder;
import org.infinispan.configuration.cache.PersistenceConfigurationBuilder;

public class PCJStoreConfigurationBuilder extends AbstractStoreConfigurationBuilder<PCJStoreConfiguration, PCJStoreConfigurationBuilder>{

    public PCJStoreConfigurationBuilder(
          PersistenceConfigurationBuilder builder) {
        super(builder, PCJStoreConfiguration.attributeDefinitionSet());
        // TODO Auto-generated constructor stub
    }

    public PCJStoreConfigurationBuilder sampleAttribute(String sampleAttribute) {
        // TODO Auto-generated method stub
        attributes.attribute(SAMPLE_ATTRIBUTE).set(sampleAttribute);
        return this;
    }

    @Override
    public PCJStoreConfiguration create() {
        // TODO Auto-generated method stub
        return new PCJStoreConfiguration(attributes.protect(), async.create(), singletonStore.create());
    }

    @Override
    public PCJStoreConfigurationBuilder self() {
        // TODO Auto-generated method stub
        return this;
    }
}
