package com.jahnelgroup.service

import com.jahnelgroup.config.loggerFor
import com.jahnelgroup.domain.user.User
import com.jahnelgroup.domain.user.UserAuthorityRepo
import com.jahnelgroup.domain.user.UserRepo
import com.jahnelgroup.domain.user.group.GroupMember
import com.jahnelgroup.domain.user.group.GroupMemberRepo
import com.jahnelgroup.domain.user.group.GroupRepo
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserService(
        private var userRepo: UserRepo,
        private var groupMemberRepo: GroupMemberRepo,
        private var groupRepo: GroupRepo,
        private var passwordEncoder: PasswordEncoder) {

    val logger = loggerFor(UserService::class.java)

    // TODO: only Admin should be able to call this
    fun createUser(user: User){
        user.password = passwordEncoder.encode(user.password)
        groupMemberRepo.save(GroupMember(username = user.username, group = groupRepo.findByGroupName("Users").get()))
        logger.info("createUser: {}", user)
        userRepo.save(user)
    }

    fun updatePassword(user: User){
        user.password = passwordEncoder.encode(user.password)
        logger.info("updatePassword: {}", user)
        userRepo.save(user)
    }

}