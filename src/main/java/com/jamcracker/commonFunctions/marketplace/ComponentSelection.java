package com.jamcracker.commonFunctions.marketplace;

import com.jamcracker.objectRepository.marketplace.DesignerConsolePage;
import com.jamcracker.utilities.MouseActions;
import com.jamcracker.utilities.TestBase;

public class ComponentSelection extends TestBase {
	
	DesignerConsolePage dConsole = new DesignerConsolePage();
	
	//Method to drag only Linux OS
		public void onlyLinux() {		
			MouseActions.opDragDrop(dConsole.getlinuxOS, dConsole.canvasSpace);		
		}
		
	//Method to drag only Linux OS
		public void onlyWindows() {			
			MouseActions.opDragDrop(dConsole.getWindowsOS, dConsole.canvasSpace);			
		}

	//Method to drag Linux OS along with Shell Script
		public void linuxWithShell() {		
			MouseActions.opDragDrop(dConsole.getlinuxOS, dConsole.canvasSpace);
			dConsole.getScritpsLink.click();
			explicitWait(dConsole.getShellScript);
			MouseActions.opDragDrop(dConsole.getShellScript, dConsole.getScriptContainer);		
		}
		
	//Method to drag Linux OS along with Chef Script
		public void linuxWithChef() {			
			MouseActions.opDragDrop(dConsole.getlinuxOS, dConsole.canvasSpace);
			dConsole.getScritpsLink.click();
			explicitWait(dConsole.getChefScript);
			MouseActions.opDragDrop(dConsole.getChefScript, dConsole.getScriptContainer);			
		}
		
	//Method to drag Linux OS along with Chef and Shell Scripts
		public void linuxWithChefAndShell() {		
			MouseActions.opDragDrop(dConsole.getlinuxOS, dConsole.canvasSpace);
			dConsole.getScritpsLink.click();
			explicitWait(dConsole.getShellScript);
			MouseActions.opDragDrop(dConsole.getShellScript, dConsole.getScriptContainer);
			explicitWait(dConsole.getChefScript);
			MouseActions.opDragDrop(dConsole.getChefScript, dConsole.getScriptContainer);		
		}
}
