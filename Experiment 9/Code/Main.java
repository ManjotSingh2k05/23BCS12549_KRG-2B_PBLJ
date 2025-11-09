import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Student s = new Student();
        s.setName("Alice");
        s.setAge(21);
        session.save(s);

        Student st = session.get(Student.class, 1);
        if (st != null) {
            st.setAge(24);
            st.setName("Alice Johnson");
            session.update(st);
            session.delete(st);
        }

        tx.commit();
        session.close();

        System.out.println("CRUD operations completed successfully.");
    }
}