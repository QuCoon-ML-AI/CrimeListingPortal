//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-20T02:34:20.510834900
package com.pwb.crimeListingPortal.model.entity

import org.pwb.utility.annotation.Column
import org.pwb.utility.annotation.Table

@Table
data class crime(
   	@Column(type="INT", primaryKey=true,autoIncrement=true,startValue=100,step=1,defaultValue="100")
	var crimeId: Int?=null,
	@Column(type="VARCHAR(n)", nullable=true,length=100)
	var crimeType: String?=null,
	@Column(type="VARCHAR(n)", nullable=true,length=100)
	var crimeDescription: String?=null,
	@Column(type="VARCHAR(n)", nullable=true,length=100)
	var crimeLocation: String?=null,
	@Column(type="DATETIME", nullable=true)
	var crimeDate: String?=null,
	@Column(type="VARCHAR(n)", nullable=true,defaultValue="'ACTIVE'",length=100)
	var crimeStatus: String?=null,
	@Column(type="INT", nullable=true,foreignKey=true,reference="USER(userId)")
	var crimeReportedBy: Int?=null,
	@Column(type="DATETIME", nullable=true,defaultValue="getdate()")
	var crimeCreatedAt: String?=null,
	@Column(type="DATETIME", nullable=true,defaultValue="getdate()")
	var crimeUpdatedAt: String?=null
)
