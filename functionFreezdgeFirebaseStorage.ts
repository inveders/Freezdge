import * as functions from "firebase-functions";
import * as admin from "firebase-admin";
const firebase = admin.initializeApp();

export const deletePhotos = functions.firestore
  .document("posts/{postId}")
  .onDelete((snap, context) => {
    const { postId } = context.params;
    const bucket = firebase.storage().bucket();

    return bucket.deleteFiles({
      prefix: `${postId}`
    });
  });