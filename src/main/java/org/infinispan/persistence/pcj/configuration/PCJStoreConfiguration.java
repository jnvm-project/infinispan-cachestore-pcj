package org.infinispan.persistence.pcj.configuration;

import org.infinispan.commons.configuration.BuiltBy;
import org.infinispan.commons.configuration.ConfigurationFor;
import org.infinispan.commons.configuration.attributes.AttributeDefinition;
import org.infinispan.commons.configuration.attributes.AttributeSet;
import org.infinispan.configuration.cache.AbstractStoreConfiguration;
import org.infinispan.configuration.cache.AsyncStoreConfiguration;
import org.infinispan.configuration.cache.SingletonStoreConfiguration;

import org.infinispan.persistence.pcj.PCJStore;

@BuiltBy(PCJStoreConfigurationBuilder.class)
@ConfigurationFor(PCJStore.class)
public class PCJStoreConfiguration extends AbstractStoreConfiguration {

    static final AttributeDefinition<String> SAMPLE_ATTRIBUTE = AttributeDefinition.builder("sampleAttribute", null, String.class).immutable().build();

    public static AttributeSet attributeDefinitionSet() {
        return new AttributeSet(PCJStoreConfiguration.class, AbstractStoreConfiguration.attributeDefinitionSet(), SAMPLE_ATTRIBUTE);
    }

    public PCJStoreConfiguration(AttributeSet attributes, AsyncStoreConfiguration async, SingletonStoreConfiguration singletonStore) {
        super(attributes, async, singletonStore);
        // TODO Auto-generated constructor stub
    }

}
