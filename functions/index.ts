 const admin = require('firebase-admin');
const functions = require('firebase-functions');

admin.initializeApp({
	credential: admin.credential.applicationDefault(),
	databaseURL: 'https://freezdge.firebaseio.com'
  });

exports.deletePost = functions.firestore
    .document('posts/{postId}')
    .onDelete((snap, context) => {
      // Get an object representing the document prior to deletion
      // e.g. {'name': 'Marie', 'age': 66}
      const deletedValue = snap.data();

      const { postId } = context.params;
    const bucket = firebase.storage().bucket();

    return bucket.deleteFiles({
      prefix: `posts/${postId}`
    });



