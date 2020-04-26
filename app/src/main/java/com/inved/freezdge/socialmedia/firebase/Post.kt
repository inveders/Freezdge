package com.inved.freezdge.socialmedia.firebase

import java.sql.Timestamp

class Post (var postId: String,
            var timestamp: Timestamp,
            var titleAstuce: String? = null,
            var descriptionAstuce: String?=null,
            var urlPhoto: String? = null,
            var userUid: String?=null,
            var postType: String?=null,
            var likeNumber: Int?=0)