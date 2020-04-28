package com.inved.freezdge.socialmedia.firebase

import java.util.*

class Post (var postId: String?=null,
            var timestamp: Date?=null,
            var titleAstuce: String? = null,
            var descriptionAstuce: String?=null,
            var urlPhoto: String? = null,
            var userUid: String?=null,
            var postType: String?=null,
            var likeNumber: Int?=0)