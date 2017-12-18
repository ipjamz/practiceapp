package com.example.peter.findr_practice_app;

import com.example.peter.findr_practice_app.callbacks.AppCallback;
import com.example.peter.findr_practice_app.models.Admin;

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

    public void saveRealmAdminList(final Admin admin, final AppCallback<String> callback) {
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.delete(Admin.class);
                Admin realmAdmin = realm.createObject(Admin.class);
                realmAdmin.setName(admin.getName());
                realmAdmin.setEmail(admin.getEmail());
                realm.copyToRealm(realmAdmin);
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                callback.onSuccess("success");
            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
                callback.onSuccess(error.getMessage());
            }
        });
    }

    public void findAdminList(final AppCallback<List<Admin>> callback) {
        realm.executeTransactionAsync(new Realm.Transaction() {
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
