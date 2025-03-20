//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-20T02:34:20.527361300
package com.pwb.crimeListingPortal.controller

import com.pwb.crimeListingPortal.service.*
import org.pwb.utility.model.response.BaseResponse
import org.springframework.web.bind.annotation.*
import javax.validation.Valid
import com.pwb.crimeListingPortal.model.response.*
import com.pwb.crimeListingPortal.model.request.*
import org.pwb.utility.exception.BadRequestException
import org.pwb.utility.exception.ActivityAlreadyPerformedException
import org.pwb.utility.general.camelToSnakeCase
import org.pwb.utility.constant.*
import com.pwb.crimeListingPortal.utility.constant.*
import com.pwb.crimeListingPortal.utility.*
import org.pwb.utility.model.request.ModulePrivilege


@RestController
@RequestMapping("/{stage}/crime")
class CrimeController(
	private val crimeService: CrimeService,
	private val environment: Environment
){
   	@PostMapping("/create")
	fun create(@RequestHeader("Authorization") authorization:String, @Valid @RequestBody request:CrimeCreateRequest, @PathVariable stage: String):BaseResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.CREATE),
			authorization)
		return crimeService.create(request)
	}

	@PostMapping("/bulk-create")
	fun bulkCreate(@RequestHeader("Authorization") authorization:String, @Valid @RequestBody request:List<CrimeCreateRequest>, @PathVariable stage: String):BaseResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.CREATE),
			authorization)
		return crimeService.bulkCreate(request)
	}

	@PostMapping("/update")
	fun update(@RequestHeader("Authorization") authorization:String, @Valid @RequestBody request:CrimeUpdateRequest, @PathVariable stage: String):BaseResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.UPDATE),
			authorization)
		return crimeService.update(request)
	}

	@PostMapping("/delete")
	fun delete(@RequestHeader("Authorization") authorization:String, @Valid @RequestBody request:CrimeDeleteRequest, @PathVariable stage: String):BaseResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.DELETE),
			authorization)
		return crimeService.delete(request)
	}

	@GetMapping("/read")
	fun read(@RequestHeader("Authorization") authorization:String, @PathVariable stage: String):crimeReadListResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.READ),
			authorization)
		return crimeService.read()
	}

	@GetMapping("/read-by-crime-id/{crimeId}")
	fun readByCrimeId(@RequestHeader("Authorization") authorization:String, @PathVariable crimeId:Int, @PathVariable stage: String):CrimeReadSingleResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.READ),
			authorization)
		return crimeService.readByCrimeId(crimeId)
	}

	@GetMapping("/read-by-crime-type/{crimeType}")
	fun readByCrimeType(@RequestHeader("Authorization") authorization:String, @PathVariable crimeType:String, @PathVariable stage: String):CrimeReadListResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.READ),
			authorization)
		return crimeService.readByCrimeType(crimeType)
	}

	@GetMapping("/read-by-crime-description/{crimeDescription}")
	fun readByCrimeDescription(@RequestHeader("Authorization") authorization:String, @PathVariable crimeDescription:String, @PathVariable stage: String):CrimeReadListResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.READ),
			authorization)
		return crimeService.readByCrimeDescription(crimeDescription)
	}

	@GetMapping("/read-by-crime-location/{crimeLocation}")
	fun readByCrimeLocation(@RequestHeader("Authorization") authorization:String, @PathVariable crimeLocation:String, @PathVariable stage: String):CrimeReadListResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.READ),
			authorization)
		return crimeService.readByCrimeLocation(crimeLocation)
	}

	@GetMapping("/read-by-crime-date/{crimeDate}")
	fun readByCrimeDate(@RequestHeader("Authorization") authorization:String, @PathVariable crimeDate:String, @PathVariable stage: String):CrimeReadListResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.READ),
			authorization)
		return crimeService.readByCrimeDate(crimeDate)
	}

	@GetMapping("/read-by-crime-status/{crimeStatus}")
	fun readByCrimeStatus(@RequestHeader("Authorization") authorization:String, @PathVariable crimeStatus:String, @PathVariable stage: String):CrimeReadListResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.READ),
			authorization)
		return crimeService.readByCrimeStatus(crimeStatus)
	}

	@GetMapping("/read-by-crime-reported-by/{crimeReportedBy}")
	fun readByCrimeReportedBy(@RequestHeader("Authorization") authorization:String, @PathVariable crimeReportedBy:Int, @PathVariable stage: String):CrimeReadListResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.READ),
			authorization)
		return crimeService.readByCrimeReportedBy(crimeReportedBy)
	}

	@GetMapping("/read-by-crime-created-at/{crimeCreatedAt}")
	fun readByCrimeCreatedAt(@RequestHeader("Authorization") authorization:String, @PathVariable crimeCreatedAt:String, @PathVariable stage: String):CrimeReadListResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.READ),
			authorization)
		return crimeService.readByCrimeCreatedAt(crimeCreatedAt)
	}

	@GetMapping("/read-by-crime-updated-at/{crimeUpdatedAt}")
	fun readByCrimeUpdatedAt(@RequestHeader("Authorization") authorization:String, @PathVariable crimeUpdatedAt:String, @PathVariable stage: String):CrimeReadListResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.READ),
			authorization)
		return crimeService.readByCrimeUpdatedAt(crimeUpdatedAt)
	}

}
