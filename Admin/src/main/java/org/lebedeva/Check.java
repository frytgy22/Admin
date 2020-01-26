package org.lebedeva;

public interface Check {
    static boolean checkParameter(String data) {
        return data != null && !data.isEmpty() && data.trim().length() > 0;
    }
}
