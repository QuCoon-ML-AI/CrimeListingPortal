//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-20T02:34:20.432733300
package com.pwb.crimeListingPortal.model.entity

import org.pwb.utility.annotation.Column
import org.pwb.utility.annotation.Table

@Table
data class user(
   	@Column(type="INT", primaryKey=true,autoIncrement=true,startValue=100,step=1,defaultValue="100")
	var userId: Int?=null,
	@Column(type="VARCHAR(n)", nullable=true,length=100)
	var userEmail: String?=null,
	@Column(type="VARCHAR(n)", nullable=true,length=100)
	var userName: String?=null,
	@Column(type="VARCHAR(n)", nullable=true,length=100)
	var userRole: String?=null,
	@Column(type="VARCHAR(n)", nullable=true,defaultValue="'ACTIVE'",length=100)
	var userStatus: String?=null,
	@Column(type="DATETIME", nullable=true,defaultValue="getdate()")
	var userCreatedAt: String?=null,
	@Column(type="DATETIME", nullable=true,defaultValue="getdate()")
	var userUpdatedAt: String?=null,
	@Column(type="VARCHAR(n)", nullable=true,length=100)
	var userPassword: String?=null
)
