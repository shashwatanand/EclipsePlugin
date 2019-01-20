package de.shashwat.eclipse.rxjava.sample.service;

import java.util.List;

import io.reactivex.Maybe;
import io.reactivex.Single;

/**
 * The Class StudentServiceImpl.
 */
public class StudentServiceImpl implements IStudentService {

	/* (non-Javadoc)
	 * @see de.shashwat.eclipse.rxjava.sample.service.IStudentService#getStudents()
	 */
	@Override
	public Single<List<StudentModel>> getStudents() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see de.shashwat.eclipse.rxjava.sample.service.IStudentService#getStudent(java.lang.String)
	 */
	@Override
	public Maybe<StudentModel> getStudent(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
