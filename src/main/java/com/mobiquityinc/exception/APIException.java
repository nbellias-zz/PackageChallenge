/*
 * Mobiquity INC
 * This is an Assignment Challenge
 * Written by Nikolaos Bellias
 *
 */
package com.mobiquityinc.exception;

/**
 *
 * @author nikolaos
 */
public class APIException extends Exception {

    private String filePath;

    public APIException(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }

    @Override
    public void printStackTrace() {
        System.out.println(filePath + ": Not Found!");
        super.printStackTrace();
    }

}
