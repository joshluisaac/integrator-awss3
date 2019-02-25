package com.avantsystems.integrator.security;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public class RoleDao {


}
