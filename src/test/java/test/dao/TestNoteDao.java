package test.dao;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

import com.tedu.cloudnote.dao.NoteDao;
import com.tedu.cloudnote.entity.Note;

import test.TestBase;

public class TestNoteDao extends TestBase{
	private NoteDao noteDao;
	@Before
	public void init(){
		noteDao = super.getContext().getBean(
			"noteDao",NoteDao.class);
	}
	@Test
	public void test1(){
		List<Map> list = 
			noteDao.findByBookId(
		"fa8d3d9d-2de5-4cfe-845f-951041bcc461");
		for(Map note:list){
			System.out.println(
			  note.get("cn_note_id")+" "+
			  note.get("cn_note_title"));
		}
	}
	@Test
	public void test2(){
//		List<Note> list = noteDao.findNotes();
//		for(Note note : list){
//			System.out.println(note.getCn_note_title());
//		}
	}
	
	@Test
	public void test3(){
		String[] ids = {"01da5d69-89d5-4140-9585-b559a97f9cb0","003ec2a1-f975-4322-8e4d-dfd206d6ac0c"};
		int delRows = noteDao.deleteNotes(ids);
		System.out.println(delRows);
	}
	
}
