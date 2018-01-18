package com.qa.apartment.business;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;
import com.qa.apartment.persistance.Room;
import com.qa.apartment.util.JSONUtil;

@Default
@Transactional(Transactional.TxType.SUPPORTS)
public class RoomDBImple implements RoomService{

	@PersistenceContext(unitName = "primary")
	private EntityManager em;
	
	@Inject
	private JSONUtil util;

	@Override
	@Transactional(Transactional.TxType.REQUIRED)
	public String createRoomFromString(String roomJson) {
		Room aRoom = util.getObjectForJSON(roomJson, Room.class);
		createRoomFromRoom(aRoom);
		return "{\"message\": \"room sucessfully added\"}";
	}
	
	@Override
	@Transactional(Transactional.TxType.REQUIRED)
	public String createRoomFromRoom(Room room) {
		em.persist(room);
		return "{\"message\": \"room sucessfully added\"}";
	}

	@Override
	@Transactional(Transactional.TxType.REQUIRED)
	public String updateRoomFromString(String newDetailsJson) {
		Room aRoom = util.getObjectForJSON(newDetailsJson, Room.class);
		return updateRoomFromRoom(aRoom);
	}
	
	@Override
	@Transactional(Transactional.TxType.REQUIRED)
	public String updateRoomFromRoom(Room room) {
		em.merge(room);
		return "{\"message\": \"room sucessfully updated\"}";
	}
	
	@Override
	@Transactional(Transactional.TxType.REQUIRED)
	public String deleteRoom(long id) {
		em.remove(findRoom(id));
		return "{\"message\": \"room sucessfully removed\"}";
	}
	
	@Override
	public List<Room> findAllRooms() {
		TypedQuery<Room> query = em.createQuery("SELECT r FROM Room r ORDER BY r.id", Room.class);
		return query.getResultList();
	}
	
	@Override
	public Room findRoom(long id) {
		return em.find(Room.class, id);
	}
	
	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	public JSONUtil getUtil() {
		return util;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}


}
