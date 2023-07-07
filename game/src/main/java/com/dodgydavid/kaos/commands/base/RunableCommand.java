package com.dodgydavid.kaos.commands.base;

public abstract class RunableCommand implements CommandBase {
	
	private String command;
	
	public RunableCommand(String command) {
		
		super();
		this.command = command;
		
	}

	public void useCommand(String text) {
		
		this.run(text);
		
	}



	public String getCommand() {
		return this.command;
	}



	public void setCommand(String command) {
		this.command = command;
	}

}
