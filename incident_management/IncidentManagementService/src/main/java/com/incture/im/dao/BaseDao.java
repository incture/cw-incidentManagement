package com.incture.im.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.incture.im.entity.GroupInfoDo;
import com.incture.im.entity.IncidentInfoDo;
import com.incture.im.entity.RoleInfoDo;
import com.incture.im.entity.SeqNumberDo;
import com.incture.im.entity.UserInfoDo;
import com.incture.im.entity.WorkOrderDo;

public abstract class BaseDao {

	protected Session getSession() {

		Configuration config = new Configuration().configure().addAnnotatedClass(WorkOrderDo.class)
				.addAnnotatedClass(GroupInfoDo.class).addAnnotatedClass(IncidentInfoDo.class)
				.addAnnotatedClass(UserInfoDo.class).addAnnotatedClass(RoleInfoDo.class)
				.addAnnotatedClass(SeqNumberDo.class);

		ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		SessionFactory sf = config.buildSessionFactory(reg);
		Session session = sf.openSession();

		return session;
	}

}
