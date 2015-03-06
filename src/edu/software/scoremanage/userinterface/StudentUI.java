package edu.software.scoremanage.userinterface;

import java.util.List;

import edu.software.scoremanage.model.Request;
import edu.software.scoremanage.model.Student;
import edu.software.scoremanage.transaction.StudentController;
import static edu.software.scoremanage.util.MyIO.*;
import static edu.software.scoremanage.util.GenerateCode.*;

public class StudentUI {
	StudentController sc;
	
	public StudentUI(Student student){
		sc = new StudentController(student);
	}
	
	public void mainMenu(){
		loop:while(true){
			println("Please enter number to choose:\n"
					+"1:Dule With Requests\n"
					+"2:Check Scores\n"
					+"3:Edit Personal Info\n"
					+"4:Log Out");
			switch(scanInt()){
			case 1:
				this.duleWithRequests();
				break;
			case 2:
				this.checkScores();
				break;
			case 3:
				this.editPersonalInfo();
				break;
			case 4:
				sc.saveData();
				break loop;
			default:
				println("Wrong input.Please choose a number between 1,2,3,4");
			}
		}
	}
	
	void duleWithRequests(){
		loop:while(true){
			println("Please enter number to choose:\n"
					+"1:Make Requests\n"
					+"2:List all Requests\n"
					+"3:Search Request\n"
					+"4:Back");
			switch(scanInt()){
			case 1:
				println("Please enter the courseID:");
				int courseID = scanInt();
				println("Please write down your reason:");
				String reason = scanString();
				if(sc.applyRequest(courseID, reason)){
					println("Success");
				}else{
					println("Fail");
				}
				break;
			case 2:
				List<Request> requests = sc.checkRequest();
				print(generateListFromSI(requests));
				println();
				break;
			case 3:
				println("Please enter the courseID:");
				int courseID3 = scanInt();
				Request rq = sc.searchRequest(courseID3);
				if(rq == null){
					println("No such a request");
				}else{
					println(rq.toItem());
				}
				println();
				break;
			case 4:
				sc.saveData();
				break loop;
			default:
				println("Wrong input.Please choose a number between 1,2,3,4");
			}
		}
	}
	
	void checkScores(){
		loop:while(true){
			println("Please enter number to choose:\n"
					+"1:List all Scores\n"
					+"2:Check Average Scores\n"
					+"3:Check Scores Distribution\n"
					+"4:Back");
			switch(scanInt()){
			case 1:
				print(generateListFromSI(sc.getScores()));
				println();
				break;
			case 2:
				println("Average score:"+sc.getAverageScore());
				println();
				break;
			case 3:
				print(generateList(sc.getStatistics()));
				println();
				break;
			case 4:
				break loop;
			default:
				println("Wrong input.Please choose a number between 1,2,3,4");
			}
		}
	}
	
	void editPersonalInfo(){
		loop:while(true){
			println("Do you want to edit user name or password?\n"
					+"1:user name\n"
					+"2:password\n"
					+"3:neither");
			switch(scanInt()){
			case 1:
				println("Please enter the new user name:");
				//!!!!!!!!!!!!应该检查是否有效的!!!!!!!!!!!!!!
				sc.editUserName(scanString());
				println("Success!");
				break;
			case 2:
				println("Please enter the new password:");
				//!!!!!!!!!!!!!应该验证旧密码！！！！！！！！
				sc.editPassword(scanString());
				println("Success!");
				break;
			case 3:
				sc.saveData();
				break loop;
			default:
				println("Wrong input!Please enter a number between 1,2,3");
			}
		}
	}

}
