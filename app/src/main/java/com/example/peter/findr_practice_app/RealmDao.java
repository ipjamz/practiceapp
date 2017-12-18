package com.example.peter.findr_practice_app;

import com.example.peter.findr_practice_app.models.Admin;

import io.realm.Realm;

/**
 * Created by peter on 12/18/17.
 */

public class RealmDao {

    private Realm realm = Realm.getDefaultInstance();

    public void saveRealmAdminList(final Admin admin) {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.delete(Admin.class);
                Admin realmAdmin = realm.createObject(Admin.class);
                realmAdmin.setEmail(admin.getEmail());
                realm.copyToRealm(realmAdmin);
            }
        });
    }
}
