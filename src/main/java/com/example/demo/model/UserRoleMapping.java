package com.example.demo.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_user_role_mapping")
public class UserRoleMapping {

	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int user_role_id;
	
	
	@Column(name = "createdOn")
	private Date createdOn;
	@Column(name = "modifiedOn")
	private Date modifiedOn;
	
	//bi-directional many-to-one association to TbRoleMaster
		@ManyToOne
		@JoinColumn(name="roleid")
		public TbRoleMaster tbRoleMaster;

		//bi-directional many-to-one association to TbUserMaster
		@ManyToOne
		@JoinColumn(name="iduser")
		private TbUserMaster tbUserMaster;

		public int getUser_role_id() {
			return user_role_id;
		}

		public void setUser_role_id(int user_role_id) {
			this.user_role_id = user_role_id;
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

		public TbRoleMaster getTbRoleMaster() {
			return tbRoleMaster;
		}

		public void setTbRoleMaster(TbRoleMaster tbRoleMaster) {
			this.tbRoleMaster = tbRoleMaster;
		}

		public TbUserMaster getTbUserMaster() {
			return tbUserMaster;
		}

		public void setTbUserMaster(TbUserMaster tbUserMaster) {
			this.tbUserMaster = tbUserMaster;
		}

	
	
}
