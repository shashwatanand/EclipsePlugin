
package de.shashwat.eclipse.rxjava.sample.service.ui;

import javax.inject.Inject;

import java.util.List;

import javax.annotation.PostConstruct;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

import de.shashwat.eclipse.rxjava.sample.service.IStudentService;
import de.shashwat.eclipse.rxjava.sample.service.StudentModel;

import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.swt.schedulers.SwtSchedulers;

public class RxPart {
	private CompositeDisposable compositeDisposable;
	private TableViewer viewer;

	@Inject
	public RxPart() {
		this.compositeDisposable = new CompositeDisposable();
	}

	@PostConstruct
	public void postConstruct(Composite parent, IStudentService service) {
		Single<List<StudentModel>> students = service.getStudents().subscribeOn(Schedulers.io())
				.observeOn(SwtSchedulers.defaultDisplayThread()).cache();
		
		Button btnLoad = new Button(parent, SWT.PUSH);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.CENTER).grab(true, false).applyTo(btnLoad);
		
		btnLoad.setText("Load Data");
	}
}