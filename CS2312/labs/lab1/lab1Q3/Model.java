public class Model {
	
    private Day day;
    
    public Model(){
        day = null;
    }
    
    public Model(int yearValue, int monthValue, int dayValue){
    	day = new Day(yearValue, monthValue, dayValue);
    }

	public boolean isLeapYear(){
    	return Day.isLeapYear(day.getYear());
    }
	
    public boolean valid(){
    	return Day.valid(day.getYear(), day.getMonth(), day.getDay());
    } 
    
    public boolean isEndOfAMonth(){
    	return day.isEndOfAMonth();
    }     
}