package br.com.treinaweb.cleancodesolid.dtos.outputs;

import java.time.LocalDateTime;

public class ErrorResponse {
  private LocalDateTime timestamp;
  private String status;
  private String message;

  public ErrorResponse(){}
  
  public ErrorResponse(LocalDateTime timestamp, String status, String message) {
    this.timestamp = timestamp;
    this.status = status;
    this.message = message;
  }

  public LocalDateTime getTimestamp() {
    return timestamp;
  }
  public void setTimestamp(LocalDateTime timestamp) {
    this.timestamp = timestamp;
  }
  public String getStatus() {
    return status;
  }
  public void setStatus(String status) {
    this.status = status;
  }
  public String getMessage() {
    return message;
  }
  public void setMessage(String message) {
    this.message = message;
  }
}
