//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-20T02:34:20.526795500
package com.pwb.crimeListingPortal.model.request

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull


data class CrimeCreateRequest(
   	@get: NotEmpty(message = "crimeType is required")
	var crimeType: String?=null,
	@get: NotEmpty(message = "crimeDescription is required")
	var crimeDescription: String?=null,
	@get: NotEmpty(message = "crimeLocation is required")
	var crimeLocation: String?=null,
	@get: NotEmpty(message = "crimeDate is required")
	var crimeDate: String?=null,
	@get: NotNull(message = "crimeReportedBy is required")
	var crimeReportedBy: Int?=null
)

data class CrimeUpdateRequest(
   	@get: NotNull(message = "crimeId is required")
	var crimeId: Int?=null,
	var crimeType: String?=null,
	var crimeDescription: String?=null,
	var crimeLocation: String?=null,
	var crimeDate: String?=null,
	var crimeStatus: String?=null,
	var crimeReportedBy: Int?=null
)

data class CrimeReadRequest(
   	var crimeId: Int?=null,
	var crimeType: String?=null,
	var crimeDescription: String?=null,
	var crimeLocation: String?=null,
	var crimeDate: String?=null,
	var crimeStatus: String?=null,
	var crimeReportedBy: Int?=null,
	var crimeCreatedAt: String?=null,
	var crimeUpdatedAt: String?=null
)

data class CrimeDeleteRequest(
   	@get: NotNull(message = "crimeId is required")
	var crimeId: Int?=null
)
