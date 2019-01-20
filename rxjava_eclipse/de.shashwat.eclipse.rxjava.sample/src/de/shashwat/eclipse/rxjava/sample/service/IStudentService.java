package de.shashwat.eclipse.rxjava.sample.service;

import java.util.List;

import io.reactivex.Maybe;
import io.reactivex.Single;

/**
 * The Interface IStudentService.
 */
public interface IStudentService {
	
	/**
	 * Gets the students.
	 *
	 * @return the students
	 */
	Single<List<StudentModel>> getStudents();
	
	/**
	 * Gets the student.
	 *
	 * @param id the id
	 * @return the student
	 */
	Maybe<StudentModel> getStudent(String id);
}
