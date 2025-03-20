//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-20T02:34:20.558194500
package com.pwb.crimeListingPortal.model.response

import com.pwb.crimeListingPortal.model.entity.Role


data class RoleReadListResponse(
   	var responseCode: String,
	var responseMessage: String,
	var data: MutableList<Role>
)

data class RoleReadSingleResponse(
   	var responseCode: String,
	var responseMessage: String,
	var data: Role
)
