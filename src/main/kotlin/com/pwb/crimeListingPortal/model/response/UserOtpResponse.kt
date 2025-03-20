//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-20T02:34:20.527361300
package com.pwb.crimeListingPortal.model.response

import com.pwb.crimeListingPortal.model.entity.UserOtp


data class UserOtpReadListResponse(
   	var responseCode: String,
	var responseMessage: String,
	var data: MutableList<UserOtp>
)

data class UserOtpReadSingleResponse(
   	var responseCode: String,
	var responseMessage: String,
	var data: UserOtp
)
