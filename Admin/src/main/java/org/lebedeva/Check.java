package org.lebedeva;

public interface Check {
    static boolean checkParameter(String data) {
        return data != null && data.trim().length() > 0;
    }

    static String getTegError(String error) {
        error = (error == null) ? "" : error;
        return "<p style= 'color:red; top: 100px; left: 100px; position: absolute'>" + error + "</p>";
    }
}
