package Main;

import java.util.Scanner;

public class PTTController {
	private PTTModel model;
	private PTTView view;
	private Scanner input;
	
	public PTTController(PTTModel model,PTTView view) {
		this.model=model;
		this.view=view;

	}
	
	public void login() {
		input = new Scanner(System.in);
		view.enterUsername();
		String username=input.nextLine();
		view.enterPassword();
		String password=input.nextLine();
		
		int role=model.login(username, password);			
		if(role==0) {
			view.loginFailed();
			this.login();

		}else{
			mainMenu(role);			
		};

	}
	public void mainMenu(int role) {
		input= new Scanner(System.in);
		view.menu(role);
		int menuNo= input.nextInt();
		if( menuNo==1) {
			view.listRequests();
			mainMenu(role);
		}else if(menuNo==2 && role==1) {		
			if(!createReq()) {
				mainMenu(role);
			};
					
			
		}else if(menuNo==2 && role==2) {
			view.approval_menu();
			model.approval(input.nextInt());
			mainMenu(role);
			
		}else if(menuNo==3) {
			view.logout();
			this.login();
		}
	}
	
	
	public boolean createReq() {
		boolean flag=true;
		input = new Scanner(System.in);
		view.createReqTitle();
		String title=input.nextLine();
		view.createReqDetails();
		String detail=input.nextLine();
		
		model.creatRequest(title, detail);
		view.submitteReq();
		
		if(input.nextInt()==1) {
			this.createReq();
		}else {
			flag=false;
		}
		
		return flag;
	}

}
