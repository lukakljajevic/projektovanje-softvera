/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import db.DBBroker;

/**
 *
 * @author Luka
 */
public abstract class OpstaSO {
    protected Object object;
    protected DBBroker db;

    public OpstaSO(Object object, DBBroker db)
    {
        this.object = object;
        this.db = db;
    }


    public Object getObject()
    {
        return object;
    }

    public void setObject(Object object)
    {
        this.object = object;
    }

    public DBBroker getDb()
    {
        return db;
    }

    public void setDb(DBBroker db)
    {
        this.db = db;
    }

    private void uspostaviKonekciju() throws Exception
    {
        db.uspostaviKonekciju();
    }

    private void prekiniKonekciju() throws Exception
    {
        db.prekiniKonekciju();
    }

    private void commit() throws Exception
    {
        db.commit();
    }

    private void rollback() throws Exception
    {
        db.rollBack();
    }

    protected abstract void izvrsiOperaciju(Object object) throws Exception;

    public final void izvrsenjeSO() throws Exception {
        try {
            uspostaviKonekciju();
            izvrsiOperaciju(object);
            commit();
        } catch (Exception e) {
            rollback();
            throw e;
        } finally {
            prekiniKonekciju();
        }
    }
}
