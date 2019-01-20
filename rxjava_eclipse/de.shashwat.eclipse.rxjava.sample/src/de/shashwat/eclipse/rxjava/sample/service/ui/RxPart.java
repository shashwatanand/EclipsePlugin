
package de.shashwat.eclipse.rxjava.sample.service.ui;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
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
	//private Text text;
	
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
		btnLoad.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				compositeDisposable.add(students.subscribe(viewer::setInput, Throwable::printStackTrace));
				btnLoad.setText("Data is loaded");
			}
		});
		
		
		Button uiNotFrozen = new Button(parent, SWT.CHECK);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.CENTER).grab(true, false).applyTo(uiNotFrozen);
		uiNotFrozen.setText("Check UI is froozen or not");
		uiNotFrozen.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.out.println("UI is not frozen!");
			}
		});
		
		
		createTableViewer(parent);
		//createText(parent);
		GridLayoutFactory.fillDefaults().numColumns(2).applyTo(parent);
	}
	
	private void createTableViewer(Composite parent) {
		viewer = new TableViewer(parent);
		GridDataFactory.fillDefaults().grab(true, true).span(2, 1).applyTo(viewer.getControl());

		viewer.setContentProvider(ArrayContentProvider.getInstance());

		TableViewerColumn summaryColumn = new TableViewerColumn(viewer, SWT.NONE);
		summaryColumn.getColumn().setWidth(300);
		summaryColumn.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				if (element instanceof StudentModel) {
					return ((StudentModel) element).getName();
				}
				return super.getText(element);
			}
		});

		TableViewerColumn descriptionColumn = new TableViewerColumn(viewer, SWT.NONE);
		descriptionColumn.getColumn().setWidth(300);
		descriptionColumn.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				if (element instanceof StudentModel) {
					return ((StudentModel) element).getCollegeName();
				}
				return super.getText(element);
			}
		});
	}

	/*private void createText(Composite parent) {
		Label label = new Label(parent, SWT.NONE);
		label.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		label.setText("First Student department: ");

		text = new Text(parent, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		text.setMessage("Shows the student summary");
	}*/

	@PreDestroy
	public void dispose() {
		this.compositeDisposable.dispose();
	}
}