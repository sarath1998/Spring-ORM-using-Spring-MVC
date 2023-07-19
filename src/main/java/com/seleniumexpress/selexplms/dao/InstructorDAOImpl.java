package com.seleniumexpress.selexplms.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.seleniumexpress.selexplms.entity.Instructor;

@Repository
public class InstructorDAOImpl implements InstructorDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	
	/**
	 * Fetches all the Available Instructor details.
	 */
	@Override
	public List<Instructor> findAllInstructors() {
		
		// open a session	
		Session session = sessionFactory.openSession();
		
		// begin transaction
		session.beginTransaction();
		
		// write query for fetching the instructors from the table
		Query<Instructor> qry = session.createQuery("from Instructor", Instructor.class);
		List<Instructor> instructorList = qry.list();
		
		// commit transaction
		session.getTransaction().commit();
		// finally return the instructor list 
		
		return instructorList;
	}

	/**
	 *  Saves the Instructor details into the table.
	 *  @Transactional --> Using this, No need to manually begin and commit the transaction
	 */
	@Override
	@Transactional 
	public void saveInstructor(Instructor instructor) {
		
		//Session session = sessionFactory.openSession();
		Session session = sessionFactory.getCurrentSession(); // Simply fetch the current open session
		session.persist(instructor); // Peform the DB operation
		System.out.println("Instructor saved");
	}

	/**
	 * Fetches the Instructor details for the given Instructor Id.
	 */
	@Override
	@Transactional
	public Instructor findInstructor(int id) 
	{
		Session session = sessionFactory.getCurrentSession();
		Instructor instructor = session.get(Instructor.class, id);
		return instructor;
	}
	
	@Transactional
	@Override
	public void deleteInstructor(int id) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.remove(findInstructor(id));
	}
}
