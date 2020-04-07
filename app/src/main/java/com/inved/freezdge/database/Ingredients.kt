package com.inved.freezdge.database

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id

@Entity
data class Ingredients (@Id var id: Long = 0,
                        var name: String? = null,
                        var type: String? = null,
                        var photoUrl: String? = null,
                        var isSelected: Boolean = false)