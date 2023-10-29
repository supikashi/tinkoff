package edu.hw2.Task4;

public record CallingInfo(String className, String methodName) {
    public static CallingInfo callingInfo() {
        StackTraceElement[] methods = Thread.currentThread().getStackTrace();
        return new CallingInfo(methods[2].getClassName(), methods[2].getMethodName());
    }
}
