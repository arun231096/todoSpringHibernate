package com.todo.list.util;

public enum ErrorCodes {

    TITLE_FILED_EMPTY(400, "Title filed is empty"),
    MESSAGE_ERROR (400, "message is empty"),
    ESTIMATION_ERROR (400, "estimation is empty"),
    STATUS_ERROR (400, "status is empty"),
    START_DATE_ERROR (400, "start should be present date"),
    DATE_ERROR (400, "date not valid"),
    DUE_DATE_ERROR(400, "Due should be present date or above"),
    ID_ERROR(400, "id Filed is empty"),
    INTERNAL_SERVER_ERROR(500, "Server Error"),
    DUPLICATE_ENTRY(400, "Entry is duplicate"),
    SEARCH_NOT_FOUND(204, "no content found"),
    NOT_FOUND(204, "no data found");

    private final String errorMessage;
    private final int code;
    private ErrorCodes(int code, String errorMessage) {
        this.errorMessage = errorMessage;
        this.code = code;
    }

    public String getErrorMeggage() {
        return errorMessage;
    }
    public int getCode() {
    	return this.code;
    }
}
