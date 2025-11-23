package org.masouras.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

@Configuration
@Order(Ordered.HIGHEST_PRECEDENCE)
@SuppressWarnings("unused")
public class InstancesConfig {
    private final DbFieldInstances dbFieldInstances;
    private final DbTableInstances dbTableInstances;

    @Autowired
    public InstancesConfig(DbFieldInstances dbFieldInstances, DbTableInstances dbTableInstances) {
        this.dbFieldInstances = dbFieldInstances;
        this.dbTableInstances = dbTableInstances;
    }
}
