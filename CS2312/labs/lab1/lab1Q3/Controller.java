import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {

	private Model model;
	private View view;
	private ActionListener confirmListener;
	private ActionListener clearListener;

	public Controller(Model model, View view) {
		this.model = model;
		this.view = view;
	}

	/*
	 * The control method will handle the button event 
	 */
	public void contol() {
		//Confirm Button Listener
		confirmListener = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				
				//Get the year, month and day from View
				String year = view.getYearField().getText().trim();
				String month = view.getMonthField().getText().trim();
				String day = view.getDayField().getText().trim();
				
				// Check the string of year, month, day
				// 	if it's valid, call getResult(year, month, day) method to produce the output
				if(validText(year, month, day))
					getResult(year, month, day);
			}
		};
		
		view.getConfirmButton().addActionListener(confirmListener);

		//Clear Button Listener
		clearListener = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				clearDate();
			}
		};
		view.getClearButton().addActionListener(clearListener);
	}

	private void getResult(String year, String month, String day) {
		// Create the model object
		model = new Model(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
	
		if(!model.valid())
			view.getWarning().setVisible(true);
		else{
			//Get the result from model object, so the view can show the output			
			view.getLeapYearResultLabel().setText(String.valueOf(model.isLeapYear()));
			view.getIsEndOfAMonthResultLabel().setText(String.valueOf(model.isEndOfAMonth()));
		}
	}
	
	private void clearDate(){
		//Clear the text field
		view.getYearField().setText(null);
		view.getMonthField().setText(null);
		view.getDayField().setText(null);
		
		//Clear the label
		view.getLeapYearResultLabel().setText(null);
		view.getIsEndOfAMonthResultLabel().setText(null);
		
		//Invisible the warning
		view.getWarning().setVisible(false);
	}
	
	/*
	 *  Handle the validation of input string of year, month, day 
	 */
	private boolean validText(String year, String month, String day){
		// Empty string checking
		if(year.equals("") || month.equals("") || day.equals("")){
			view.getWarning().setVisible(true);
			return false;
		}
		
		//Check every string is digit or not
		if(!isNumeric(year) || !isNumeric(month) || !isNumeric(day)){
			view.getWarning().setVisible(true);
			return false;
		}
		
		return true;
	}
	
	private boolean isNumeric(String str)
	{
		// Check every character of the string isDigit or not
	    for (char c : str.toCharArray())
	    {
	        if (!Character.isDigit(c)) 
	        	return false;
	    }
	    return true;
	}

}