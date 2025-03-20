//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-20T02:34:20.448314300
package com.pwb.crimeListingPortal.service

import com.pwb.crimeListingPortal.repository.database.userRepository
import com.pwb.crimeListingPortal.model.entity.user
import org.pwb.utility.constant.ResponseConstant
import org.pwb.utility.model.response.BaseResponse
import org.springframework.stereotype.Service
import org.pwb.utility.constant.GSON
import com.pwb.crimeListingPortal.model.response.*
import com.pwb.crimeListingPortal.model.request.*
import org.pwb.utility.exception.*


@Service
class UserService(
   private val userRepository: UserRepository
){
   	fun create(request:UserCreateRequest):BaseResponse{
		val user = GSON.fromJson(GSON.toJson(request), User::class.java).apply { userStatus = userStatus?:"ACTIVE" }
		userRepository.create(user)
		return ResponseConstant.SUCCESS 
	}

	fun bulkCreate(request:List<UserCreateRequest>):BaseResponse{
		val users = GSON.fromJson(GSON.toJson(request), Array<User>::class.java).toList()
		userRepository.bulkCreate(users)
		return ResponseConstant.SUCCESS
	}

	fun update(request:UserUpdateRequest):BaseResponse{
		var user = userRepository.readByUserId(request.userId!!)
			?:throw UnableToLocateRecordException()
		user = user.apply{
				userId = request.userId?:userId
				userEmail = request.userEmail?:userEmail
				userName = request.userName?:userName
				userRole = request.userRole?:userRole
				userStatus = request.userStatus?:userStatus
				userPassword = request.userPassword?:userPassword
			}
		userRepository.update(user)
		return ResponseConstant.SUCCESS
	}

	fun delete(request:UserDeleteRequest):BaseResponse{
		var updateResponse = userRepository.delete(request.userId!!)
		if(updateResponse < 1) throw FailedToUpdateRecord()
		return ResponseConstant.SUCCESS
	}

	fun read():userReadListResponse{
		var user = userRepository.read()
		return userReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = user
		)
	}

	fun readByUserId(userId:Int): UserReadSingleResponse{
		var user = userRepository.readByUserId(userId) 
			?: throw UnableToLocateRecordException()
		return UserReadSingleResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = user
		)
	}

	fun readByUserEmail(userEmail:String): UserReadListResponse{
		var user = userRepository.readByUserEmail(userEmail) 
		return UserReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = user
		)
	}

	fun readByUserName(userName:String): UserReadListResponse{
		var user = userRepository.readByUserName(userName) 
		return UserReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = user
		)
	}

	fun readByUserRole(userRole:String): UserReadListResponse{
		var user = userRepository.readByUserRole(userRole) 
		return UserReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = user
		)
	}

	fun readByUserStatus(userStatus:String): UserReadListResponse{
		var user = userRepository.readByUserStatus(userStatus) 
		return UserReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = user
		)
	}

	fun readByUserCreatedAt(userCreatedAt:String): UserReadListResponse{
		var user = userRepository.readByUserCreatedAt(userCreatedAt) 
		return UserReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = user
		)
	}

	fun readByUserUpdatedAt(userUpdatedAt:String): UserReadListResponse{
		var user = userRepository.readByUserUpdatedAt(userUpdatedAt) 
		return UserReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = user
		)
	}

	fun readByUserPassword(userPassword:String): UserReadListResponse{
		var user = userRepository.readByUserPassword(userPassword) 
		return UserReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = user
		)
	}

}
