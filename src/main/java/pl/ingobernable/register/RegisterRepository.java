package pl.ingobernable.register;

import org.h2.engine.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.ingobernable.domain.UserSnapshot;
import pl.ingobernable.util.HibernateUtil;

import java.util.Optional;

class RegisterRepository {

    void registerUser(UserDto userDto){

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.save(new UserSnapshot(userDto.getEmail(), userDto.getPassword()));

        transaction.commit();
        session.close();
    }

    Optional<UserSnapshot> findByEmail(String email){

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Optional<UserSnapshot> tmp = Optional.ofNullable(session.get(UserSnapshot.class, email));

        transaction.commit();
        session.close();

        return tmp;
    }

}
