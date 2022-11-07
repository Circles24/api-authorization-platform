package com.circles.apiauthorizationplatform.userservice.daos;

import com.circles.apiauthorizationplatform.userservice.models.Identity;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

public interface IdentityDao {
    @SqlQuery("SELECT * FROM identities WHERE id = :id")
    @RegisterBeanMapper(Identity.class)
    Identity getById(@Bind("id") String id);

    @SqlUpdate("INSERT INTO identities (id, type, value, user_id, status, created_by, updated_by) VALUES (:id, :type, :value, :userId, :status, :createdBy, :updatedBy)")
    int create(@BindBean Identity identity);

    @SqlUpdate("UPDATE identities SET type = :type, value = :value, user_id = :userId, status = :status, created_by = :createdBy, updated_by = :updatedBy WHERE id = :id")
    int update(@BindBean Identity identity);
}
