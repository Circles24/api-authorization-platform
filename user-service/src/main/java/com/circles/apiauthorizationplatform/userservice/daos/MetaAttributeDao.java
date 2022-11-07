package com.circles.apiauthorizationplatform.userservice.daos;

import com.circles.apiauthorizationplatform.userservice.models.MetaAttribute;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

public interface MetaAttributeDao {
    @SqlQuery("SELECT * FROM meta_attributes WHERE id := :id")
    @RegisterBeanMapper(MetaAttribute.class)
    MetaAttribute getById(@Bind("id") String id);

    @SqlUpdate("INSERT INTO meta_attributes (id, name, description, schema, status, created_by, updated_by) VALUES (:metaAttribute.id, :metaAttribute.name, :metaAttribute.description, :metaAttribute.schema, :metaAttribute.status, :metaAttribute.createdBy, :metaAttribute.updatedBy)")
    int create(@Bind("metaAttribute") MetaAttribute metaAttribute);

    @SqlUpdate("UPDATE meta_attributes SET name = :metaAttribute.name, description = :metaAttribute.description, schema = :metaAttribute.schema, status = :metaAttribute.status, created_by = :metaAttribute.createdBy, updated_by = :metaAttribute.updatedBy WHERE id = :metaAttribute.id")
    int update(@Bind("metaAttribute") MetaAttribute metaAttribute);
}
