package de.shashwat.eclipse.rxjava.sample.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.eclipse.core.runtime.jobs.Job;

import io.reactivex.Maybe;
import io.reactivex.Single;

/**
 * The Class StudentServiceImpl.
 */
public class StudentServiceImpl implements IStudentService {
	private List<StudentModel> students;

	public StudentServiceImpl() {
		this.students = createStudents();
	}
	
	private List<StudentModel> createStudents() {
		List<StudentModel> returnList = new ArrayList<>();
		
		returnList.add(createStudent("1", "Shashwat", "CSE", "MIT"));
		returnList.add(createStudent("2", "Shubhangi", "MBA", "Manage"));
		returnList.add(createStudent("3", "Manish", "CSE", "BCET"));
		returnList.add(createStudent("4", "Santosh", "CSE", "UVCE"));
		returnList.add(createStudent("5", "Rajan", "ECE", "BCET"));
		returnList.add(createStudent("6", "Nikesh", "ECE", "BCET"));
		returnList.add(createStudent("7", "Sanjay", "ECE", "BCET"));
		returnList.add(createStudent("8", "Vinay", "CSE", "MIT"));
		returnList.add(createStudent("9", "Shradha", "MCA", "PuneU"));
		returnList.add(createStudent("10", "Shivshankar", "CSE", "MIT"));
		return returnList;
	}

	private StudentModel createStudent(String id, String name, String department, String collegeName) {
		return new StudentModel(id, name, department, collegeName);
	}

	/* (non-Javadoc)
	 * @see de.shashwat.eclipse.rxjava.sample.service.IStudentService#getStudents()
	 */
	@Override
	public Single<List<StudentModel>> getStudents() {
		return Single.create(e -> {
			try {
				TimeUnit.SECONDS.sleep(4);
			} catch (Exception ex) {
				e.onError(ex);
			}
			e.onSuccess(this.students);
		});
	}

	/* (non-Javadoc)
	 * @see de.shashwat.eclipse.rxjava.sample.service.IStudentService#getStudent(java.lang.String)
	 */
	@Override
	public Maybe<StudentModel> getStudent(String id) {
		Optional<StudentModel> optionalStudent = this.students.stream().filter(s -> s.getId().equals(id)).findAny();
		return Maybe.create(e -> {
			Job.create("Getting Student with id " + id, runnable -> {
				try {
					TimeUnit.SECONDS.sleep(2);
				} catch (InterruptedException ex) {
					e.onError(ex);
				}
				if (optionalStudent.isPresent()) {
					e.onSuccess(optionalStudent.get());
				} else {
					e.onComplete();
				}
			});
		});
	}

}
