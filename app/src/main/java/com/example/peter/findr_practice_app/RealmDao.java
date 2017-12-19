package com.example.peter.findr_practice_app;

import com.example.peter.findr_practice_app.callbacks.AppCallback;
import com.example.peter.findr_practice_app.models.Admin;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by peter on 12/18/17.
 */

public class RealmDao {

    private Realm realm;

    public RealmDao(Realm realm) {
        this.realm = realm;
    }

    public void saveRealmAdminList(final List<Admin> adminList) {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.delete(Admin.class);
                List<Admin> admins = new ArrayList<>();
                for (Admin admin : adminList) {
                    Admin realmAdmin = realm.createObject(Admin.class);
                    realmAdmin.setName(admin.getName());
                    realmAdmin.setEmail(admin.getEmail());
                    admins.add(realmAdmin);
                }
                realm.copyToRealm(admins);
            }
        });
    }

    public void findAdminList(final AppCallback<List<Admin>> callback) {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                RealmResults<Admin> results = realm.where(Admin.class).findAll();
                if (results == null) {
                    callback.onError("error");
                } else {
                    callback.onSuccess(results);
                }
            }
        });
    }
}
