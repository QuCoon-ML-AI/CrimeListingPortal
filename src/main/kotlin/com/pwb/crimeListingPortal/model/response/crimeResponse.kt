//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-20T02:34:20.527361300
package com.pwb.crimeListingPortal.model.response

import com.pwb.crimeListingPortal.model.entity.crime


data class CrimeReadListResponse(
   	var responseCode: String,
	var responseMessage: String,
	var data: MutableList<crime>
)

data class CrimeReadSingleResponse(
   	var responseCode: String,
	var responseMessage: String,
	var data: crime
)
