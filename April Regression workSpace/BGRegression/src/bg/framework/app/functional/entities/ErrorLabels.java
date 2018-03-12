package bg.framework.app.functional.entities;

import java.util.Arrays;
import java.util.List;

public class ErrorLabels {

    private static final String ERROR_404 = "Page Not Found";
    private static final String INTERNAL_ERROR = "Internal Server Error";
    private static final String ERROR_500 = "500 Error";

    public static final List<String> CRITICAL_ERROR_MESSAGES = Arrays.asList(ERROR_404, INTERNAL_ERROR, ERROR_500);
}
