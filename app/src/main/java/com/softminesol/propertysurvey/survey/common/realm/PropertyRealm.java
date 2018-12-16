package com.softminesol.propertysurvey.survey.common.realm;

import io.realm.Case;
import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.RealmQuery;
import io.realm.RealmResults;
import io.realm.Sort;

/**
 * Created by madhurigupta on 26/05/18.
 */

public class PropertyRealm<T> {
    private Realm realm;

    public PropertyRealm(Realm realm) {
        this.realm = realm;
    }

    public <T extends RealmObject> void saveData(final T t) {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.insertOrUpdate(t);
            }
        });
    }

    public <T extends RealmObject> void saveDataAsync(final T t, Realm.Transaction.OnSuccess onSuccess) {
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.insertOrUpdate(t);
            }
        }, onSuccess);
    }

    public <T extends RealmList<? extends RealmObject>> void saveList(final T t) {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.insertOrUpdate(t);
            }
        });
    }

    public void clearRealmDb() {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.deleteAll();
            }
        });
    }

    public <T extends RealmObject> RealmResults<T> getData(final Class<T> tClass, final String key, final String keyValue) {
        realm.refresh();
        return realm.where(tClass).equalTo(key, keyValue).findAll();
    }

    public <T extends RealmObject> T getDataObject(final Class<T> tClass, final String key, final String keyValue) {
        realm.refresh();
        return realm.where(tClass).equalTo(key, keyValue).findFirst();
    }

    public <T extends RealmObject> RealmResults<T> getAllData(final Class<T> tClass) {
        realm.refresh();
        return realm.where(tClass).findAll();
    }

    public <T extends RealmObject> void clearAllData(final Class<T> tClass) {

        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.delete(tClass);
            }
        });
    }

    public <T extends RealmObject> RealmResults<T> getSortedData(final Class<T> tClass, final String key, final Sort sortOrder) {
        realm.refresh();
        return realm.where(tClass).sort(key, sortOrder).findAll();
    }

    public <T extends RealmObject> RealmResults<T> getSortedDataAsync(final Class<T> tClass, final String key, final Sort sortOrder) {
        realm.refresh();
        return realm.where(tClass).sort(key, sortOrder).findAllAsync();
    }

    public <T extends RealmObject> RealmQuery<T> getSortedDataQuery(final Class<T> tClass, final String key, final Sort sortOrder) {
        realm.refresh();
        return realm.where(tClass).sort(key, sortOrder);
    }

    public <T extends RealmObject> RealmResults<T> getSortedData(final Class<T> tClass, final String key1, final Sort sortOrder1,
                                                                 final String key2, final Sort sortOrder2) {
        realm.refresh();
        return realm.where(tClass).sort(key1, sortOrder1, key2, sortOrder2).findAll();
    }

    public <T extends RealmObject> RealmResults<T> getSortedData(final Class<T> tClass, final String matchKey, final String matchValue, final String sortingKey, final Sort sortOrder) {
        realm.refresh();
        return realm.where(tClass).equalTo(matchKey, matchValue).sort(sortingKey, sortOrder).findAll();
    }

    public <T extends RealmObject> RealmResults<T> getData(final Class<T> tClass, final String key, String[] list) {
        realm.refresh();
        return realm.where(tClass).in(key, list, Case.INSENSITIVE).findAll();
    }

    public <T extends RealmObject> void delete(final String key, final String value, final Class<T> tClass) {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                RealmResults<T> results = realm.where(tClass).equalTo(key, value).findAll();
                if (results != null) {
                    results.deleteAllFromRealm();
                }
            }
        });
    }


    public  <T extends RealmObject> RealmResults<T>  contains(final String key, final String value, final Class<T> tClass) {
         realm.refresh();
         return realm.where(tClass).contains(key, value).findAll();
    }
    public void closeRealm() {
        if (realm != null) {
            realm.close();
        }
    }
}
