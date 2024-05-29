package com.example.fitstreak.database_utils;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import androidx.annotation.NonNull;

import com.example.fitstreak.MainActivity;
import com.example.fitstreak.activities.SignIn;
import com.example.fitstreak.database_utils.callbacks.DataCallback;
import com.example.fitstreak.database_utils.callbacks.UpdateCallback;
import com.example.fitstreak.database_utils.callbacks.UserCallback;
import com.example.fitstreak.database_utils.callbacks.WaterCallback;
import com.example.fitstreak.database_utils.classes.Exercise;
import com.example.fitstreak.database_utils.classes.Medicine;
import com.example.fitstreak.database_utils.classes.Sleep;
import com.example.fitstreak.database_utils.classes.UserData;
import com.example.fitstreak.database_utils.classes.Water;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class FireStore {

    public FirebaseFirestore db = FirebaseFirestore.getInstance();

    public void checkUserInFirestore(String userId, Context context) {

        db.collection("users").document(userId).get()
                .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        if (task.isSuccessful()) {
                            DocumentSnapshot document = task.getResult();

                            Intent intent = new Intent(context, MainActivity.class);
                            context.startActivity(intent);

                            if (document != null && document.exists()) {
                                Log.e("FIRESTORE", "USER EXISTS");
                            } else {
                                Log.e("FIRESTORE", "USER DOES NOT EXIST");
                                initUser(userId);
                            }
                            context.startActivity(intent);
                        } else {
                            Log.e("FIRESTORE", "ERROR");
                        }
                    }
                });
    }

    public void initUser(String UID) {
        Water water = new Water(
                3, 8, 1200, "7:30"
        );
        Sleep sleep = new Sleep("_");
        Exercise exercise = new Exercise("_");
        Medicine medicine = new Medicine("_");

        Map<String, Object> d = new HashMap<>();

        d.put("water", water);
        d.put("sleep", sleep);
        d.put("exercise", exercise);
//        d.put("medicine", medicine);

        db.collection("users").document(UID).set(d);
    }

    public void getData(String uid, DataCallback callback) {

        db.collection("users").document(uid).get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {

                        DocumentSnapshot document = task.getResult();
                        if (document != null && document.exists()) {

                            UserData data = document.toObject(UserData.class);
                            callback.dataOnCallback(data);

                        }
                    }
                });
    }

    public void updateUserData(String uid, UserData userData, UpdateCallback callback) {
        db.collection("users").document(uid).set(userData)
                .addOnSuccessListener(aVoid -> callback.onUpdate())
                .addOnFailureListener(e -> Log.e("FireStore", "Error updating document", e));
    }

    public void increaseWaterGlassDrankCount(String UID, int count) {
        DocumentReference ref = db.collection("users").document(UID);

        ref.update(
                "water.glass_drank_count", count
        );
    }
}
