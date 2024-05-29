package com.example.fitstreak.database_utils;

import com.google.firebase.auth.FirebaseUser;

public class FitStreakUser {

    FirebaseUser currentUser;



    public void setUser(FirebaseUser user) {
        currentUser = user;

        user.getEmail();
    }
}
