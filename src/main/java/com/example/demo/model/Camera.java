package com.example.demo.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "camera")
public class Camera {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idcamera;

	@Column(name = "cameraName")
	private String cameraName;

	@Column(name = "lat")
	private String lat;

	@Column(name = "longit")
	private String longit;
	@Column(name = "createdOn")
	private Date createdOn;
	@Column(name = "modifiedOn")
	private Date modifiedOn;
	
	@Column(name = "poleId")
	private int poleId;

	
	public long getIdcamera() {
		return idcamera;
	}


	public void setIdcamera(int idcamera) {
		this.idcamera = idcamera;
	}


	public String getCameraName() {
		return cameraName;
	}


	public void setCameraName(String cameraName) {
		this.cameraName = cameraName;
	}


	public String getLat() {
		return lat;
	}


	public void setLat(String lat) {
		this.lat = lat;
	}


	public String getLongit() {
		return longit;
	}


	public void setLongit(String longit) {
		this.longit = longit;
	}


	public Date getCreatedOn() {
		return createdOn;
	}


	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}


	public Date getModifiedOn() {
		return modifiedOn;
	}


	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}


	public int getPoleId() {
		return poleId;
	}


	public void setPoleId(int poleId) {
		this.poleId = poleId;
	}


	public Camera() {

	}
}