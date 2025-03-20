//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-20T02:34:20.605094400
package com.pwb.crimeListingPortal.model.response

import com.pwb.crimeListingPortal.model.entity.AuditLog


data class AuditLogReadListResponse(
   	var responseCode: String,
	var responseMessage: String,
	var data: MutableList<AuditLog>
)

data class AuditLogReadSingleResponse(
   	var responseCode: String,
	var responseMessage: String,
	var data: AuditLog
)
