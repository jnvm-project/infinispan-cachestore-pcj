package org.infinispan.persistence.pcj;

import java.util.concurrent.Executor;

import org.infinispan.commons.configuration.ConfiguredBy;
import org.infinispan.commons.persistence.Store;
import org.infinispan.filter.KeyFilter;
import org.infinispan.marshall.core.MarshalledEntry;
import org.infinispan.marshall.core.MarshalledEntryFactory;
import org.infinispan.persistence.spi.AdvancedLoadWriteStore;
import org.infinispan.persistence.spi.InitializationContext;
import org.kohsuke.MetaInfServices;

import org.infinispan.persistence.pcj.configuration.PCJStoreConfiguration;

@Store
@MetaInfServices
@ConfiguredBy(PCJStoreConfiguration.class)
public class PCJStore<K, V> implements AdvancedLoadWriteStore<K, V> {

    private InitializationContext ctx;
    private MarshalledEntryFactory marshalledEntryFactory;
    private PCJStoreConfiguration configuration;

    @Override
    public boolean contains(Object o) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void init(InitializationContext initializationContext) {
        ctx = initializationContext;
        marshalledEntryFactory = ctx.getMarshalledEntryFactory();
        configuration = ctx.getConfiguration();
    }

    @Override
    public MarshalledEntry<K, V> load(Object o) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void start() {
        // TODO Auto-generated method stub

    }

    @Override
    public void stop() {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean delete(Object o) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void write(MarshalledEntry<? extends K, ? extends V> marshalledEntry) {
        // TODO Auto-generated method stub

    }

    @Override
    public void process(
            KeyFilter<? super K> arg0,
            org.infinispan.persistence.spi.AdvancedCacheLoader.CacheLoaderTask<K, V> arg1,
            Executor arg2, boolean arg3, boolean arg4) {
        // TODO Auto-generated method stub

    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub

    }

    @Override
    public void purge(
            Executor arg0,
            org.infinispan.persistence.spi.AdvancedCacheWriter.PurgeListener<? super K> arg1) {
        // TODO Auto-generated method stub

    }

}
