public class ExCourseControl extends Exception {
    public ExCourseControl(String message) {
        super(message);
    }
    public ExCourseControl() {
        super("Course Controller Exception!");
    }
}