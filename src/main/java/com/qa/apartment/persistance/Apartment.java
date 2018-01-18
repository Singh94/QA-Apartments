package com.qa.apartment.persistance;
//
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Apartment {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column
	@NotNull	
	private String buildingName;
	@Column
	@NotNull
	private String apartmentNo;
	@Column
	@NotNull
	private String agency;
	@Column
	private String landlord;
	@Column
	@NotNull
	private String tenant;
	
	@Column
	@NotNull
	@Temporal(TemporalType.DATE)
	private Date leaseStart;
	
	@Column
	@NotNull
	private String leaseEnd;
	@Column
	@NotNull
	private String breakClause;
	@Column
	@NotNull
	private String agencyPhoneNo;
	@Column
	private Integer noRooms;
	@Column
	@NotNull
	private Double rent;
	@Column
	private String notes;
	@Column
	@NotNull
	private String address;
	@Column
	@NotNull
	private Double deposit;
	
	
	public Apartment() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public String getApartmentNo() {
		return apartmentNo;
	}

	public void setApartmentNo(String apartmentNo) {
		this.apartmentNo = apartmentNo;
	}

	public String getAgency() {
		return agency;
	}

	public void setAgency(String agency) {
		this.agency = agency;
	}

	public String getLandlord() {
		return landlord;
	}

	public void setLandlord(String landlord) {
		this.landlord = landlord;
	}

	public String getTenant() {
		return tenant;
	}

	public void setTenant(String tenant) {
		this.tenant = tenant;
	}
	
	public Date getLeaseStart() {
		return leaseStart;
	}

	public void setLeaseStart(Date leaseStart) {
		this.leaseStart = leaseStart;
	}
	
	public String getLeaseEnd() {
		return leaseEnd;
	}

	public void setLeaseEnd(String leaseEnd) {
		this.leaseEnd = leaseEnd;
	}

	public String getBreakClause() {
		return breakClause;
	}

	public void setBreakClause(String breakClause) {
		this.breakClause = breakClause;
	}

	public String getAgencyPhoneNo() {
		return agencyPhoneNo;
	}

	public void setAgencyPhoneNo(String agencyPhoneNo) {
		this.agencyPhoneNo = agencyPhoneNo;
	}
	
	public Integer getNoRooms() {
		return noRooms;
	}

	public void setNoRooms(Integer noRooms) {
		this.noRooms = noRooms;
	}

	public Double getRent() {
		return rent;
	}

	public void setRent(Double rent) {
		this.rent = rent;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Double getDeposit() {
		return deposit;
	}

	public void setDeposit(Double deposit) {
		this.deposit = deposit;
	}

}
