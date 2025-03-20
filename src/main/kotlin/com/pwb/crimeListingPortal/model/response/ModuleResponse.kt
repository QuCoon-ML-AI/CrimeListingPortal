//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-20T02:34:20.589460800
package com.pwb.crimeListingPortal.model.response

import com.pwb.crimeListingPortal.model.entity.Module


data class ModuleReadListResponse(
   	var responseCode: String,
	var responseMessage: String,
	var data: MutableList<Module>
)

data class ModuleReadSingleResponse(
   	var responseCode: String,
	var responseMessage: String,
	var data: Module
)
