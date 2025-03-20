//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-20T02:34:20.527361300
package com.pwb.crimeListingPortal.repository.database

import com.pwb.crimeListingPortal.model.entity.crime
import com.pwb.crimeListingPortal.utility.Environment
import org.pwb.utility.general.createQueryWithoutOnMappingFailure
import com.pwb.crimeListingPortal.repository.database.query.CrimeQuery
import org.springframework.stereotype.Repository



@Repository
interface CrimeRepository{
   	fun create(crime:crime):Long
	fun bulkCreate(crimes:List<crime>)
	fun update(crime:crime):Int
	fun delete(crimeId:Int):Int
	fun truncate(): Boolean
	fun read():MutableList<crime>
	fun readByCrimeId(crimeId: Int):Crime?
	fun readByCrimeType(crimeType: String):MutableList<Crime>
	fun readByCrimeDescription(crimeDescription: String):MutableList<Crime>
	fun readByCrimeLocation(crimeLocation: String):MutableList<Crime>
	fun readByCrimeDate(crimeDate: String):MutableList<Crime>
	fun readByCrimeStatus(crimeStatus: String):MutableList<Crime>
	fun readByCrimeReportedBy(crimeReportedBy: Int):MutableList<Crime>
	fun readByCrimeCreatedAt(crimeCreatedAt: String):MutableList<Crime>
	fun readByCrimeUpdatedAt(crimeUpdatedAt: String):MutableList<Crime>
}

@Repository
class CrimeRepositoryImpl(private val environment: Environment): CrimeRepository{
   	override fun create(crime:Crime):Long{
		return environment.databaseUtil?.sql2oConnection!!.createQueryWithoutOnMappingFailure(CrimeQuery.INSERT)
			.bind(crime)
			.executeUpdate().getKey(Long::class.java)
	}

	override fun bulkCreate(crimes:List<crime>){
		environment.databaseUtil?.getSql2o()?.beginTransaction().use { connection ->
			val query = connection?.createQueryWithoutOnMappingFailure(CrimeQuery.INSERT, false)
			for (crime in crimes)
				query?.bind(crime)?.addToBatch()
			query?.executeBatch()
			connection?.commit()
		}
	}

	override fun update(crime:Crime):Int{
		return environment.databaseUtil?.sql2oConnection!!.createQueryWithoutOnMappingFailure(CrimeQuery.UPDATE)
		.bind(crime)
		.executeUpdate().result
	}

	override fun delete(crimeId:Int):Int{
		return environment.databaseUtil?.sql2oConnection!!.createQueryWithoutOnMappingFailure(CrimeQuery.DELETE)
		.addParameter("crimeId", crimeId)
		.executeUpdate().result
	}

	override fun truncate(): Boolean{
		return environment.databaseUtil?.sql2oConnection!!.jdbcConnection.createStatement().execute(CrimeQuery.TRUNCATE)
	}

	override fun read():MutableList<crime>{
		return environment.databaseUtil?.sql2oConnection!!.createQueryWithoutOnMappingFailure(CrimeQuery.READ)
		.executeAndFetch(crime::class.java)
	}

	override fun readByCrimeId(crimeId: Int):Crime?{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(CrimeQuery.READ_BY_CRIME_ID)
				.addParameter("crimeId", crimeId)
				.executeAndFetch(Crime::class.java).firstOrNull()
	}

	override fun readByCrimeType(crimeType: String):MutableList<Crime>{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(CrimeQuery.READ_BY_CRIME_TYPE)
				.addParameter("crimeType", crimeType)
				.executeAndFetch(Crime::class.java)
	}

	override fun readByCrimeDescription(crimeDescription: String):MutableList<Crime>{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(CrimeQuery.READ_BY_CRIME_DESCRIPTION)
				.addParameter("crimeDescription", crimeDescription)
				.executeAndFetch(Crime::class.java)
	}

	override fun readByCrimeLocation(crimeLocation: String):MutableList<Crime>{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(CrimeQuery.READ_BY_CRIME_LOCATION)
				.addParameter("crimeLocation", crimeLocation)
				.executeAndFetch(Crime::class.java)
	}

	override fun readByCrimeDate(crimeDate: String):MutableList<Crime>{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(CrimeQuery.READ_BY_CRIME_DATE)
				.addParameter("crimeDate", crimeDate)
				.executeAndFetch(Crime::class.java)
	}

	override fun readByCrimeStatus(crimeStatus: String):MutableList<Crime>{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(CrimeQuery.READ_BY_CRIME_STATUS)
				.addParameter("crimeStatus", crimeStatus)
				.executeAndFetch(Crime::class.java)
	}

	override fun readByCrimeReportedBy(crimeReportedBy: Int):MutableList<Crime>{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(CrimeQuery.READ_BY_CRIME_REPORTED_BY)
				.addParameter("crimeReportedBy", crimeReportedBy)
				.executeAndFetch(Crime::class.java)
	}

	override fun readByCrimeCreatedAt(crimeCreatedAt: String):MutableList<Crime>{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(CrimeQuery.READ_BY_CRIME_CREATED_AT)
				.addParameter("crimeCreatedAt", crimeCreatedAt)
				.executeAndFetch(Crime::class.java)
	}

	override fun readByCrimeUpdatedAt(crimeUpdatedAt: String):MutableList<Crime>{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(CrimeQuery.READ_BY_CRIME_UPDATED_AT)
				.addParameter("crimeUpdatedAt", crimeUpdatedAt)
				.executeAndFetch(Crime::class.java)
	}
}
