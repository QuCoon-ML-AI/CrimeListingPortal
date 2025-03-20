//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-20T02:34:20.527361300
package com.pwb.crimeListingPortal.service

import com.pwb.crimeListingPortal.repository.database.crimeRepository
import com.pwb.crimeListingPortal.model.entity.crime
import org.pwb.utility.constant.ResponseConstant
import org.pwb.utility.model.response.BaseResponse
import org.springframework.stereotype.Service
import org.pwb.utility.constant.GSON
import com.pwb.crimeListingPortal.model.response.*
import com.pwb.crimeListingPortal.model.request.*
import org.pwb.utility.exception.*


@Service
class CrimeService(
   private val crimeRepository: CrimeRepository
){
   	fun create(request:CrimeCreateRequest):BaseResponse{
		val crime = GSON.fromJson(GSON.toJson(request), Crime::class.java).apply { crimeStatus = crimeStatus?:"ACTIVE" }
		crimeRepository.create(crime)
		return ResponseConstant.SUCCESS 
	}

	fun bulkCreate(request:List<CrimeCreateRequest>):BaseResponse{
		val crimes = GSON.fromJson(GSON.toJson(request), Array<Crime>::class.java).toList()
		crimeRepository.bulkCreate(crimes)
		return ResponseConstant.SUCCESS
	}

	fun update(request:CrimeUpdateRequest):BaseResponse{
		var crime = crimeRepository.readByCrimeId(request.crimeId!!)
			?:throw UnableToLocateRecordException()
		crime = crime.apply{
				crimeId = request.crimeId?:crimeId
				crimeType = request.crimeType?:crimeType
				crimeDescription = request.crimeDescription?:crimeDescription
				crimeLocation = request.crimeLocation?:crimeLocation
				crimeDate = request.crimeDate?:crimeDate
				crimeStatus = request.crimeStatus?:crimeStatus
				crimeReportedBy = request.crimeReportedBy?:crimeReportedBy
			}
		crimeRepository.update(crime)
		return ResponseConstant.SUCCESS
	}

	fun delete(request:CrimeDeleteRequest):BaseResponse{
		var updateResponse = crimeRepository.delete(request.crimeId!!)
		if(updateResponse < 1) throw FailedToUpdateRecord()
		return ResponseConstant.SUCCESS
	}

	fun read():crimeReadListResponse{
		var crime = crimeRepository.read()
		return crimeReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = crime
		)
	}

	fun readByCrimeId(crimeId:Int): CrimeReadSingleResponse{
		var crime = crimeRepository.readByCrimeId(crimeId) 
			?: throw UnableToLocateRecordException()
		return CrimeReadSingleResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = crime
		)
	}

	fun readByCrimeType(crimeType:String): CrimeReadListResponse{
		var crime = crimeRepository.readByCrimeType(crimeType) 
		return CrimeReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = crime
		)
	}

	fun readByCrimeDescription(crimeDescription:String): CrimeReadListResponse{
		var crime = crimeRepository.readByCrimeDescription(crimeDescription) 
		return CrimeReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = crime
		)
	}

	fun readByCrimeLocation(crimeLocation:String): CrimeReadListResponse{
		var crime = crimeRepository.readByCrimeLocation(crimeLocation) 
		return CrimeReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = crime
		)
	}

	fun readByCrimeDate(crimeDate:String): CrimeReadListResponse{
		var crime = crimeRepository.readByCrimeDate(crimeDate) 
		return CrimeReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = crime
		)
	}

	fun readByCrimeStatus(crimeStatus:String): CrimeReadListResponse{
		var crime = crimeRepository.readByCrimeStatus(crimeStatus) 
		return CrimeReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = crime
		)
	}

	fun readByCrimeReportedBy(crimeReportedBy:Int): CrimeReadListResponse{
		var crime = crimeRepository.readByCrimeReportedBy(crimeReportedBy) 
		return CrimeReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = crime
		)
	}

	fun readByCrimeCreatedAt(crimeCreatedAt:String): CrimeReadListResponse{
		var crime = crimeRepository.readByCrimeCreatedAt(crimeCreatedAt) 
		return CrimeReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = crime
		)
	}

	fun readByCrimeUpdatedAt(crimeUpdatedAt:String): CrimeReadListResponse{
		var crime = crimeRepository.readByCrimeUpdatedAt(crimeUpdatedAt) 
		return CrimeReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = crime
		)
	}

}
