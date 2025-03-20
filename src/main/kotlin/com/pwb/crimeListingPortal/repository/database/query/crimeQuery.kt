//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-20T02:34:20.527361300
package com.pwb.crimeListingPortal.repository.database.query

import com.pwb.crimeListingPortal.utility.constant.PrefixConstant


object crimeQuery{
   	const val INSERT = """
		INSERT INTO ${PrefixConstant.ENTITY}CRIME(
			crimeType,
			crimeDescription,
			crimeLocation,
			crimeDate,
			crimeStatus,
			crimeReportedBy,
			crimeCreatedAt,
			crimeUpdatedAt
		) VALUES (
			:crimeType,
			:crimeDescription,
			:crimeLocation,
			:crimeDate,
			COALESCE(:crimeStatus,'ACTIVE'),
			:crimeReportedBy,
			COALESCE(:crimeCreatedAt,getdate()),
			COALESCE(:crimeUpdatedAt,getdate())
		)
	"""

	const val UPDATE = """
		UPDATE ${PrefixConstant.ENTITY}CRIME SET
			crimeType=:crimeType,
			crimeDescription=:crimeDescription,
			crimeLocation=:crimeLocation,
			crimeDate=:crimeDate,
			crimeStatus=:crimeStatus,
			crimeReportedBy=:crimeReportedBy,
			crimeCreatedAt=:crimeCreatedAt,
			crimeUpdatedAt=GETDATE()
		WHERE crimeId=:crimeId
	"""

	const val DELETE = """
		UPDATE ${PrefixConstant.ENTITY}CRIME SET crimeStatus = 'DELETED', crimeUpdatedAt = GETDATE()
		WHERE crimeId=:crimeId
	"""

	const val TRUNCATE = """
		TRUNCATE TABLE ${PrefixConstant.ENTITY}CRIME 
	"""

	const val READ = """
		SELECT * FROM ${PrefixConstant.ENTITY}CRIME WHERE crimeStatus<>'DELETED'
	"""

	const val READ_BY_CRIME_ID = """
		SELECT * FROM ${PrefixConstant.ENTITY}CRIME WHERE crimeId=:crimeId AND crimeStatus<>'DELETED'
	"""

	const val READ_BY_CRIME_TYPE = """
		SELECT * FROM ${PrefixConstant.ENTITY}CRIME WHERE crimeType=:crimeType AND crimeStatus<>'DELETED'
	"""

	const val READ_BY_CRIME_DESCRIPTION = """
		SELECT * FROM ${PrefixConstant.ENTITY}CRIME WHERE crimeDescription=:crimeDescription AND crimeStatus<>'DELETED'
	"""

	const val READ_BY_CRIME_LOCATION = """
		SELECT * FROM ${PrefixConstant.ENTITY}CRIME WHERE crimeLocation=:crimeLocation AND crimeStatus<>'DELETED'
	"""

	const val READ_BY_CRIME_DATE = """
		SELECT * FROM ${PrefixConstant.ENTITY}CRIME WHERE crimeDate=:crimeDate AND crimeStatus<>'DELETED'
	"""

	const val READ_BY_CRIME_STATUS = """
		SELECT * FROM ${PrefixConstant.ENTITY}CRIME WHERE crimeStatus=:crimeStatus AND crimeStatus<>'DELETED'
	"""

	const val READ_BY_CRIME_REPORTED_BY = """
		SELECT * FROM ${PrefixConstant.ENTITY}CRIME WHERE crimeReportedBy=:crimeReportedBy AND crimeStatus<>'DELETED'
	"""

	const val READ_BY_CRIME_CREATED_AT = """
		SELECT * FROM ${PrefixConstant.ENTITY}CRIME WHERE crimeCreatedAt=:crimeCreatedAt AND crimeStatus<>'DELETED'
	"""

	const val READ_BY_CRIME_UPDATED_AT = """
		SELECT * FROM ${PrefixConstant.ENTITY}CRIME WHERE crimeUpdatedAt=:crimeUpdatedAt AND crimeStatus<>'DELETED'
	"""
}
