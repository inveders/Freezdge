package com.inved.freezdge.favourites.database

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id

@Entity
class DaySelected (
    @Id
    var id: Long = 0,
    var lunch: Long? = null,
    var dinner: Long? = null
)
