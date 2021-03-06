package com.hcl.cqrs.aggregates;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.spring.stereotype.Aggregate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import com.hcl.cqrs.commands.AddProductToCatalogCommand;
import com.hcl.cqrs.events.ProductAddedEvent;

@Aggregate
public class ProductAggregate {

    private static final Logger LOG = LoggerFactory.getLogger(ProductAggregate.class);

    @AggregateIdentifier
    private String id;
    private String name;

    public ProductAggregate() {
    }

    @CommandHandler
    public ProductAggregate(AddProductToCatalogCommand cmd) {
        LOG.info("Handling {} command: {}, {}", cmd.getClass().getSimpleName(), cmd.getId(), cmd.getName());
        Assert.hasLength(cmd.getId(), "ID should NOT be empty or null.");
        Assert.hasLength(cmd.getName(), "Name should NOT be empty or null.");
        apply(new ProductAddedEvent(cmd.getId(), cmd.getName()));
        LOG.info("Done handling {} command: {}, {}", cmd.getClass().getSimpleName(), cmd.getId(), cmd.getName());
    }

    @EventSourcingHandler
    public void on(ProductAddedEvent evnt) {
        LOG.info("Handling {} event: {}, {}", evnt.getClass().getSimpleName(), evnt.getId(), evnt.getName());
        this.id = evnt.getId();
        this.name = evnt.getName();
        LOG.info("Done handling {} event: {}, {}", evnt.getClass().getSimpleName(), evnt.getId(), evnt.getName());
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
