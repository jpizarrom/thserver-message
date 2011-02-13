package com.jpizarro.th.server.message.model.persistence.accessor;

import com.jpizarro.th.server.generic.model.persistence.accessor.GenericAccessorHibernate;
import com.jpizarro.th.server.message.model.entity.User;

public class UserAccessorHibernate 
extends GenericAccessorHibernate<User, Long> 
implements UserAccessor {

}
