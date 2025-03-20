//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-20T02:34:20.432733300
package com.pwb.crimeListingPortal.model.response

import com.pwb.crimeListingPortal.model.entity.user


data class UserReadListResponse(
   	var responseCode: String,
	var responseMessage: String,
	var data: MutableList<user>
)

data class UserReadSingleResponse(
   	var responseCode: String,
	var responseMessage: String,
	var data: user
)
