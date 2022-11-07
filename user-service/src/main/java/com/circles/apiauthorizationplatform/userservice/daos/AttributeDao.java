package com.circles.apiauthorizationplatform.userservice.daos;

import com.circles.apiauthorizationplatform.userservice.models.Attribute;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

public interface AttributeDao {
    @SqlQuery("SELECT * FROM attributes WHERE id = :id")
    @RegisterBeanMapper(Attribute.class)
    Attribute getById(@Bind("id") String id);

    @SqlUpdate("INSERT INTO attributes (id, user_id, meta_attribute_id, value, status, created_by, updated_by) VALUES (:attribute.id, :attribute.userId, :attribute.metaAttributeId, :attribute.value, :attribute.status, :attribute.createdBy, :attribute.updatedBy)")
    int create(@Bind("attribute") Attribute Attribute);

    @SqlUpdate("UPDATE attributes SET user_id = :attribute.userId, meta_attribute_id = :attribute.metaAttributeId, value = :attribute.value, status = :attribute.status, created_by = :attribute.createdBy, updated_by = :attribute.updatedBy WHERE id = :attribute.id")
    int update(@Bind("attribute") Attribute Attribute);
}
