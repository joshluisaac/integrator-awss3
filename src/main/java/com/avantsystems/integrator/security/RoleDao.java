package com.avantsystems.integrator.security;


import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class RoleDao extends JdbcDaoSupport {

    public RoleDao(DataSource dataSource){
       super.setDataSource(dataSource);
    }

    public List<String> getUserRoles(final Long userId){
        String getUserRolesQuery = "\n" +
                "select role.role_name \n" +
                "from \n" +
                "avant_user_role userrole\n" +
                "inner join avant_role role on userrole.role_id = role.role_id\n" +
                "where userrole.user_id = ?";
        return this.getJdbcTemplate().queryForList(getUserRolesQuery,new Object[]{userId}, String.class);

    }


}
