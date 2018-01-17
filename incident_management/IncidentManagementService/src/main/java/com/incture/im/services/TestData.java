package com.incture.im.services;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.incture.im.entity.GroupInfoDo;
import com.incture.im.entity.IncidentInfoDo;
import com.incture.im.entity.RoleInfoDo;
import com.incture.im.entity.UserInfoDo;
import com.incture.im.entity.WorkOrderDo;

public class TestData {

	public static void main(String args[]) {

		/*** HardCoded Data to test entries ***/

		/*Configuration config = new Configuration().configure().addAnnotatedClass(WorkOrderDo.class)
				.addAnnotatedClass(GroupInfoDo.class).addAnnotatedClass(IncidentInfoDo.class)
				.addAnnotatedClass(UserInfoDo.class).addAnnotatedClass(RoleInfoDo.class);

		ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();

		SessionFactory sf = config.buildSessionFactory(reg);

		Session session = sf.openSession();

		UserInfoDo user1 = new UserInfoDo();
		user1.setUserId("USR0002");
		user1.setFirstName("FName2");
		user1.setLastName("LName2");
		user1.setUserMobile("9999999992");
		user1.setUserEmail("name2@abc.com");
		user1.setUserCostctr("CostCtr2");
		user1.setUserGroup("Group2");*/

		/*IncidentInfoDo in1 = new IncidentInfoDo();
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		in1.setIncidentLob("Transportation");
		in1.setIncidentType("Tyre Burst");
		in1.setIncidentDescription("Some Description");
		in1.setIncidentPriority("Medium");
		in1.setIncidentAction("M");
		in1.setCreatedDate(timestamp);
		in1.setFinishDate(timestamp);
		in1.setAssignedTo("SomePerson");
		in1.setIncidentStatus("OPEN");
		in1.setReportedDate(timestamp);
		in1.setAssignedGroup("Group1");
		in1.setAssignedDate(timestamp);*/

		/*WorkOrderDo wo1 = new WorkOrderDo();

		wo1.setWorkType("W12");
		wo1.setWorkEquipment("EQP1");
		wo1.setWorkCenter("BLR");
		wo1.setFuncLoc("FUNC LOC1");
		wo1.setAssembly("Assembly1");
		wo1.setControlKey("K01");
		wo1.setActivityType("TypeB");
		wo1.setPlanningGroup("G01");
		wo1.setPlanningPlant("Pt1");
		wo1.setBusArea("BLR");
		wo1.setWorkDescription("This is Test Description");
		wo1.setWorkorderId("W01");*/

		/*RoleInfoDo role1 = new RoleInfoDo();
		role1.setRoleId("R0002");
		role1.setRoleName("Reporter");

		GroupInfoDo group1 = new GroupInfoDo();
		group1.setGroupId("GRP0002");
		group1.setGroupName("Group2");

		//in1.setWorkOrder(wo1);
		user1.setGroup(group1);
		//user1.getIncidents().add(in1);
		//in1.getUsers().add(user1);
		user1.getRoles().add(role1);
		role1.getRoleusers().add(user1);

		Transaction tx = session.beginTransaction();

		//session.save(wo1);
		//session.save(in1);
		session.save(group1);
		session.save(user1);
		session.save(role1);

		tx.commit();*/

	}

}