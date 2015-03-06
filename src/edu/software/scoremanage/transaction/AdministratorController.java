package edu.software.scoremanage.transaction;

import edu.software.scoremanage.model.Course;
import edu.software.scoremanage.model.Curriculum;
import edu.software.scoremanage.model.Student;
import edu.software.scoremanage.model.Teacher;
import edu.software.scoremanage.model.User;
/* ����:AdministratorController
 * ������:Ŀǰ������User��İ�װ�������ֿ��ǹ���Ա��ʹ�ýӿ�
 * @author:Sissel
 * @version:2015-02-16 21:49:13
 */
import edu.software.scoremanage.util.DataHelper;

public class AdministratorController {
	User user = User.getInstance();
	Curriculum curriculum = Curriculum.getInstance();
	
	/* �û����*/
	// ����
	public Student searchStudent(String loginName){
		return user.searchStudent(loginName);
	}
	public Teacher searchTeacher(String loginName){
		return user.searchTeacher(loginName);
	}
	// ɾ��
	public boolean deleteStudent(String loginName){
		return user.deleteStudent(loginName);
	}
	public boolean deleteTeacher(String loginName){
		return user.deleteTeacher(loginName);
	}
	// ����
	public boolean addGraduate(String loginName,String password,String userName){
		return user.addGraduate(loginName, userName, password);
	}
	public boolean addUndergraduate(String loginName,String password,String userName){
		return user.addUndergraduate(loginName, userName, password);
	}
	public boolean addTeacher(String loginName,String password,String userName){
		return user.addTeacher(loginName, userName, password);
	}
	// �޸�
	public boolean editStudentName(String loginName,String newName){
		return user.editStudentName(loginName, newName);
	}
	public boolean editStudentPassword(String loginName,String newPassword){
		return user.editStudentPassword(loginName, newPassword);
	}
	public boolean editTeacherName(String loginName,String newName){
		return user.editTeacherName(loginName, newName);
	}
	public boolean editTeacherPassword(String loginName,String newPassword){
		return user.editTeacherPassword(loginName, newPassword);
	}
	public void editAdminName(String newName){
		user.editAdminName(newName);
	}
	public void editAdminPassword(String newPassword){
		user.editAdminPassword(newPassword);
	}
	
	/* Course���*/
	// ����
	public boolean addCourse(int courseID,String name,String teacherLoginName,int year){
		Teacher teacher = user.searchTeacher(teacherLoginName);
		if(teacher == null){
			return false;
		}
		return curriculum.addCourse(courseID, name, teacher, year);
	}
    // ɾ��
	public boolean deleteCourse(int courseID){
		return curriculum.deleteCourse(courseID);
	}
	// ����
	public Course searchCourse(int courseID){
		return curriculum.searchCourse(courseID);
	}
	// �޸�
    public boolean editCourseName(Course course,String newName){
		return curriculum.editCourseName(course, newName);
	}
    public boolean editCourseTeacher(Course course,String loginName){
    	Teacher teacher = this.searchTeacher(loginName);
    	if(teacher != null){
    		return curriculum.editCourseTeacher(course,teacher);
    	}
    	return false;
	}
    public boolean editCourseYear(Course course,int year){
    	return curriculum.editCourseYear(course,year);
	}
	
	public void saveData(){
		DataHelper.saveData();
	}
}
