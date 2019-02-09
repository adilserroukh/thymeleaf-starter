package com.jahnelgroup.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class SettingsController {

    @GetMapping("/settings")
    fun user() = "layouts/settings/account"

    @GetMapping("/settings/preferences")
    fun preferences() = "layouts/settings/preferences"

    @GetMapping("/settings/users")
    fun users() = "layouts/settings/users"

    @GetMapping("/settings/groups")
    fun groups() = "layouts/settings/groups"
}