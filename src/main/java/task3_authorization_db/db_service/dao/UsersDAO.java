package task3_authorization_db.db_service.dao;

import task3_authorization_db.db_service.data_sets.UsersDataSet;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class UsersDAO {

    private Session session;

    public UsersDAO(Session session) {
        this.session = session;
    }

    public UsersDataSet getUserById(long id) throws HibernateException {
        return (UsersDataSet) session.get(UsersDataSet.class, id);
    }

    public long getUserId(String login) throws HibernateException {
        Criteria criteria = session.createCriteria(UsersDataSet.class);
        return ((UsersDataSet) criteria.add(Restrictions.eq("login", login)).uniqueResult()).getId();
    }

    public UsersDataSet getUserByLogin(String login) throws HibernateException {
        Criteria criteria = session.createCriteria(UsersDataSet.class);
        return ((UsersDataSet) criteria.add(Restrictions.eq("login", login)).uniqueResult());
    }

    public long insertUser(String login, String password) throws HibernateException {
        UsersDataSet usersDataSet = getUserByLogin(login);
        if (usersDataSet == null) {
            return (Long) session.save(new UsersDataSet(login, password));
        } else {
            return 0;
        }

    }

}
