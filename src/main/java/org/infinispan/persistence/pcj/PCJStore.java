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

import lib.util.persistent.AnyPersistent;
import lib.util.persistent.ObjectDirectory;
import lib.util.persistent.PersistentHashMap;

import org.infinispan.persistence.pcj.configuration.PCJStoreConfiguration;

@Store
@MetaInfServices
@ConfiguredBy(PCJStoreConfiguration.class)
public class PCJStore<K extends AnyPersistent, V extends AnyPersistent> implements AdvancedLoadWriteStore<K, V> {

    String DATA_KEY = "PCJStore";
    PersistentHashMap<K, V> map = ObjectDirectory.get(DATA_KEY, PersistentHashMap.class);

    private InitializationContext ctx;
    private MarshalledEntryFactory marshalledEntryFactory;
    private PCJStoreConfiguration configuration;

    @Override
    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    @Override
    public void init(InitializationContext initializationContext) {
        ctx = initializationContext;
        marshalledEntryFactory = ctx.getMarshalledEntryFactory();
        configuration = ctx.getConfiguration();
    }

    @Override
    public MarshalledEntry<K, V> load(Object o) {
        return marshalledEntryFactory.newMarshalledEntry(o, map.get(o), null);
    }

    @Override
    public void start() {
        // empty
    }

    @Override
    public void stop() {
        // empty

    }

    @Override
    public boolean delete(Object o) {
        if (map.remove(o) != null)
            return true;
        return false;
    }

    @Override
    public void write(MarshalledEntry<? extends K, ? extends V> marshalledEntry) {
        map.put(marshalledEntry.getKey(), marshalledEntry.getValue());
    }

    @Override
    public void process(
            KeyFilter<? super K> arg0,
            org.infinispan.persistence.spi.AdvancedCacheLoader.CacheLoaderTask<K, V> arg1,
            Executor arg2, boolean arg3, boolean arg4) {
        throw new RuntimeException();
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public void clear() {
        map.entrySet().clear();
    }

    @Override
    public void purge(
            Executor arg0,
            org.infinispan.persistence.spi.AdvancedCacheWriter.PurgeListener<? super K> arg1) {
        throw new RuntimeException();
    }

}
