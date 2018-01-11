package com.incture.im.services;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.incture.im.dao.IncidentInfoDao;
import com.incture.im.dao.UserInfoDao;
import com.incture.im.dao.WorkOrderDao;
import com.incture.im.dto.ApprovalMasterDto;
import com.incture.im.dto.CreationMasterDto;
import com.incture.im.dto.IncidentInfoDto;
import com.incture.im.dto.IncidentTableMasterDto;
import com.incture.im.dto.SearchIncidentMasterDto;
import com.incture.im.dto.UserInfoDto;
import com.incture.im.dto.WorkOrderDto;
import com.incture.im.entity.GroupInfo;
import com.incture.im.entity.IncidentInfo;
import com.incture.im.entity.RoleInfo;
import com.incture.im.entity.UserInfo;
import com.incture.im.entity.WorkOrder;
import com.incture.im.keygen.IncidentIdGenerator;
import com.incture.im.keygen.WorkOrderIdGenerator;

public class IncidentManagementServiceImp implements IncidentManagementService {

	@Override
	public String createRecord(CreationMasterDto createIncident) {

		IncidentInfoDto incidentDto = new IncidentInfoDto();
		incidentDto = createIncident.getIncident();

		IncidentInfo incidentDo = new IncidentInfo();
		IncidentInfoDao incidentDao = new IncidentInfoDao();
		incidentDo = incidentDao.importIncidentInfo(incidentDto);

		WorkOrderDto workOrderDto = new WorkOrderDto();
		workOrderDto = createIncident.getWo();

		WorkOrder workOrderDo = new WorkOrder();
		WorkOrderDao workOrderDao = new WorkOrderDao();
		workOrderDo = workOrderDao.importWorkOrder(workOrderDto);

		Configuration config = new Configuration().configure().addAnnotatedClass(WorkOrder.class)
				.addAnnotatedClass(GroupInfo.class).addAnnotatedClass(IncidentInfo.class)
				.addAnnotatedClass(UserInfo.class).addAnnotatedClass(RoleInfo.class)
				.addAnnotatedClass(WorkOrderIdGenerator.class).addAnnotatedClass(IncidentIdGenerator.class);

		ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		SessionFactory sf = config.buildSessionFactory(reg);
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		Query q = session.createQuery("from UserInfo where userId =:uid");
		String id = createIncident.getUserId();
		q.setParameter("uid", id);

		@SuppressWarnings("rawtypes")
		UserInfo userDo = (UserInfo) ((org.hibernate.query.Query) q).uniqueResult();

		incidentDo.setWorkOrder(workOrderDo);
		userDo.getIncidents().add(incidentDo);
		incidentDo.getUsers().add(userDo);

		session.save(workOrderDo);
		session.save(incidentDo);
		session.save(userDo);

		tx.commit();

		return "Success";

	}

	@Override
	public UserInfoDto getUserById(String userId) {

		Configuration config = new Configuration().configure().addAnnotatedClass(WorkOrder.class)
				.addAnnotatedClass(GroupInfo.class).addAnnotatedClass(IncidentInfo.class)
				.addAnnotatedClass(UserInfo.class).addAnnotatedClass(RoleInfo.class);

		ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		SessionFactory sf = config.buildSessionFactory(reg);
		Session session = sf.openSession();

		Query query = session.createQuery("from UserInfo where userId =:uid");
		query.setParameter("uid", userId);

		@SuppressWarnings("rawtypes")
		UserInfo userDo = (UserInfo) ((org.hibernate.query.Query) query).uniqueResult();

		UserInfoDao userDao = new UserInfoDao();
		UserInfoDto userDto = new UserInfoDto();
		userDto = userDao.exportUserInfo(userDo);

		return userDto;

	}

	@Override
	public List<IncidentTableMasterDto> getIncidentTableInfo(SearchIncidentMasterDto searchIncidentTable) {

		/*
		 * SearchIncidentMaster search = new SearchIncidentMaster();
		 * 
		 * search.setLineOfBusiness("Transportation"); search.setPriority("M");
		 * search.setStatus(null);
		 */

		Configuration config = new Configuration().configure().addAnnotatedClass(WorkOrder.class)
				.addAnnotatedClass(GroupInfo.class).addAnnotatedClass(IncidentInfo.class)
				.addAnnotatedClass(UserInfo.class).addAnnotatedClass(RoleInfo.class)
				.addAnnotatedClass(SearchIncidentMasterDto.class);

		ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();

		SessionFactory sf = config.buildSessionFactory(reg);

		Session session = sf.openSession();

		/*
		 * String queryString =
		 * "select incident from IncidentInfo incident where incident.incidentLob = :lob or incident.incidentPriority = :prio or incident.incidentStatus = :status"
		 * ;
		 */

		String lineOfBusiness = searchIncidentTable.getLineOfBusiness();
		String priority = searchIncidentTable.getPriority();
		String stat = searchIncidentTable.getStatus();

		int count1 = 0, count2 = 0, count3 = 0;

		String queryString = "select incident from IncidentInfo incident where incident.incidentId IS NOT NULL ";

		if (lineOfBusiness != null && lineOfBusiness != "") {
			queryString += " and incident.incidentLob =:lob";

			++count1;

		}

		if (priority != null && priority != "") {
			queryString += " and incident.incidentPriority =:prio";

			++count2;

		}

		if (stat != null && stat != "") {
			queryString += " and incident.incidentStatus =:status";

			++count3;
		}

		Query query = session.createQuery(queryString);

		if (count1 != 0)
			query.setParameter("lob", lineOfBusiness);
		if (count2 != 0)
			query.setParameter("prio", priority);
		if (count3 != 0)
			query.setParameter("status", stat);

		@SuppressWarnings({ "unchecked", "rawtypes" })
		List<IncidentInfo> incidentInfoList = ((org.hibernate.query.Query) query).list();
		List<IncidentTableMasterDto> incidentInfoDto = new ArrayList<IncidentTableMasterDto>();

		for (IncidentInfo in : incidentInfoList) {

			IncidentTableMasterDto inDto = new IncidentTableMasterDto();

			inDto.setIncidentId(in.getIncidentId());
			inDto.setIncidentLob(in.getIncidentLob());
			inDto.setIncidentPriority(in.getIncidentPriority());
			inDto.setIncidentStatus(in.getIncidentStatus());
			inDto.setCreatedDate(in.getCreatedDate());
			inDto.setFinishDate(in.getFinishDate());

			incidentInfoDto.add(inDto);

		}

		return incidentInfoDto;

	}

	@Override

	public IncidentInfoDto getIncidentById(String id) {

		Configuration config = new Configuration().configure().addAnnotatedClass(WorkOrder.class)
				.addAnnotatedClass(GroupInfo.class).addAnnotatedClass(IncidentInfo.class)
				.addAnnotatedClass(UserInfo.class).addAnnotatedClass(RoleInfo.class);

		ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		SessionFactory sf = config.buildSessionFactory(reg);
		Session session = sf.openSession();

		Query q = session.createQuery("from IncidentInfo where incidentId =:inid");
		q.setParameter("inid", id);

		@SuppressWarnings("rawtypes")
		IncidentInfo incidentDo = (IncidentInfo) ((org.hibernate.query.Query) q).uniqueResult();

		IncidentInfoDao incidentDao = new IncidentInfoDao();
		IncidentInfoDto incidentDto = new IncidentInfoDto();
		incidentDto = incidentDao.exportIncidentInfo(incidentDo);

		return incidentDto;

	}

	public SearchIncidentMasterDto testreturnDto() {

		SearchIncidentMasterDto test = new SearchIncidentMasterDto();

		test.setLineOfBusiness("Transportation");
		test.setPriority("M");
		test.setStatus("OPEN");

		return test;

	}

	@Override

	public ApprovalMasterDto searchApprovalIncident(String incidentId) {

		Configuration config = new Configuration().configure().addAnnotatedClass(WorkOrder.class)
				.addAnnotatedClass(GroupInfo.class).addAnnotatedClass(IncidentInfo.class)
				.addAnnotatedClass(UserInfo.class).addAnnotatedClass(RoleInfo.class)
				.addAnnotatedClass(SearchIncidentMasterDto.class);

		ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		SessionFactory sf = config.buildSessionFactory(reg);
		Session session = sf.openSession();

		String queryString = "select incident from IncidentInfo incident where incident.incidentId =:id ";
		Query query = session.createQuery(queryString);
		query.setParameter("id", incidentId);

		@SuppressWarnings("rawtypes")
		IncidentInfo incidentDo = (IncidentInfo) ((org.hibernate.query.Query) query).uniqueResult();

		List<UserInfo> userDoList = incidentDo.getUsers();

		UserInfoDao userDao = new UserInfoDao();
		UserInfoDto userDto = new UserInfoDto();

		for (UserInfo userDo : userDoList) {

			userDto = userDao.exportUserInfo(userDo);

		}

		IncidentInfoDao incidentDao = new IncidentInfoDao();
		IncidentInfoDto incidentDto = new IncidentInfoDto();

		incidentDto = incidentDao.exportIncidentInfo(incidentDo);

		WorkOrder workOrderDo = incidentDo.getWorkOrder();
		WorkOrderDao workOrderDao = new WorkOrderDao();
		WorkOrderDto workOrderDto = new WorkOrderDto();

		workOrderDto = workOrderDao.exportWorkOrder(workOrderDo);

		ApprovalMasterDto approve = new ApprovalMasterDto();

		approve.setUser(userDto);
		approve.setIncident(incidentDto);
		approve.setWo(workOrderDto);

		return approve;

	}

	@Override

	public List<IncidentInfoDto> getAllIncidents() {

		Configuration config = new Configuration().configure().addAnnotatedClass(WorkOrder.class)
				.addAnnotatedClass(GroupInfo.class).addAnnotatedClass(IncidentInfo.class)
				.addAnnotatedClass(UserInfo.class).addAnnotatedClass(RoleInfo.class);

		ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		SessionFactory sf = config.buildSessionFactory(reg);
		Session session = sf.openSession();

		Query query = session.createQuery("from IncidentInfo");

		@SuppressWarnings({ "unchecked", "rawtypes" })
		List<IncidentInfo> incidentDoList = ((org.hibernate.query.Query) query).list();

		List<IncidentInfoDto> incidentDtoList = new ArrayList<IncidentInfoDto>();

		IncidentInfoDao incidentDao = new IncidentInfoDao();

		for (IncidentInfo incidentDo : incidentDoList) {

			IncidentInfoDto incidentDto = new IncidentInfoDto();

			incidentDto = incidentDao.exportIncidentInfo(incidentDo);

			incidentDtoList.add(incidentDto);

		}

		return incidentDtoList;

	}

	public static void main(String args[]) {

		/*** HardCoded Data to test entries ***/

		Configuration config = new Configuration().configure().addAnnotatedClass(WorkOrder.class)
				.addAnnotatedClass(GroupInfo.class).addAnnotatedClass(IncidentInfo.class)
				.addAnnotatedClass(UserInfo.class).addAnnotatedClass(RoleInfo.class);

		ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();

		SessionFactory sf = config.buildSessionFactory(reg);

		Session session = sf.openSession();

		UserInfo user1 = new UserInfo();
		user1.setUserId("USR0001");
		user1.setFirstName("FName1");
		user1.setLastName("LName1");
		user1.setUserMobile("9999999991");
		user1.setUserEmail("name1@abc.com");
		user1.setUserCostctr("CostCtr1");
		user1.setUserGroup("Group2");

		IncidentInfo in1 = new IncidentInfo();
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
		in1.setAssignedDate(timestamp);

		WorkOrder wo1 = new WorkOrder();

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
		wo1.setWorkorderId("W01");

		RoleInfo role1 = new RoleInfo();
		role1.setRoleId("R0001");
		role1.setRoleName("Manager");

		GroupInfo group1 = new GroupInfo();
		group1.setGroupId("GRP0001");
		group1.setGroupName("Group1");

		in1.setWorkOrder(wo1);
		user1.setGroup(group1);
		user1.getIncidents().add(in1);
		in1.getUsers().add(user1);
		user1.getRoles().add(role1);
		role1.getRoleusers().add(user1);

		Transaction tx = session.beginTransaction();

		session.save(wo1);
		session.save(in1);
		session.save(group1);
		session.save(user1);
		session.save(role1);

		tx.commit();

	}

}