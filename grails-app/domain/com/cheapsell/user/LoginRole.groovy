package com.cheapsell.user

import grails.gorm.DetachedCriteria
import groovy.transform.ToString

import org.codehaus.groovy.util.HashCodeHelper
import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
@ToString(cache=true, includeNames=true, includePackage=false)
class LoginRole implements Serializable {

	private static final long serialVersionUID = 1

	Login login
	Role role

	@Override
	boolean equals(other) {
		if (other instanceof LoginRole) {
			other.loginId == login?.id && other.roleId == role?.id
		}
	}

    @Override
	int hashCode() {
	    int hashCode = HashCodeHelper.initHash()
        if (login) {
            hashCode = HashCodeHelper.updateHash(hashCode, login.id)
		}
		if (role) {
		    hashCode = HashCodeHelper.updateHash(hashCode, role.id)
		}
		hashCode
	}

	static LoginRole get(long loginId, long roleId) {
		criteriaFor(loginId, roleId).get()
	}

	static boolean exists(long loginId, long roleId) {
		criteriaFor(loginId, roleId).count()
	}

	private static DetachedCriteria criteriaFor(long loginId, long roleId) {
		LoginRole.where {
			login == Login.load(loginId) &&
			role == Role.load(roleId)
		}
	}

	static LoginRole create(Login login, Role role, boolean flush = false) {
		def instance = new LoginRole(login: login, role: role)
		instance.save(flush: flush)
		instance
	}

	static boolean remove(Login u, Role r) {
		if (u != null && r != null) {
			LoginRole.where { login == u && role == r }.deleteAll()
		}
	}

	static int removeAll(Login u) {
		u == null ? 0 : LoginRole.where { login == u }.deleteAll() as int
	}

	static int removeAll(Role r) {
		r == null ? 0 : LoginRole.where { role == r }.deleteAll() as int
	}

	static constraints = {
	    login nullable: false
		role nullable: false, validator: { Role r, LoginRole ur ->
			if (ur.login?.id) {
				if (LoginRole.exists(ur.login.id, r.id)) {
				    return ['userRole.exists']
				}
			}
		}
	}

	static mapping = {
		id composite: ['login', 'role']
		version false
	}
}
