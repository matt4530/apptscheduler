/*
 * Brevium Interview 2021 API
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: v1
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package io.swagger.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.client.model.Doctor;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.IOException;
import org.threeten.bp.OffsetDateTime;
/**
 * AppointmentInfo
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2024-02-24T19:59:02.572704900-07:00[America/Denver]")

public class AppointmentInfo {
  @SerializedName("doctorId")
  private Doctor doctorId = null;

  @SerializedName("personId")
  private Integer personId = null;

  @SerializedName("appointmentTime")
  private OffsetDateTime appointmentTime = null;

  @SerializedName("isNewPatientAppointment")
  private Boolean isNewPatientAppointment = null;

  public AppointmentInfo doctorId(Doctor doctorId) {
    this.doctorId = doctorId;
    return this;
  }

   /**
   * Get doctorId
   * @return doctorId
  **/
  @Schema(description = "")
  public Doctor getDoctorId() {
    return doctorId;
  }

  public void setDoctorId(Doctor doctorId) {
    this.doctorId = doctorId;
  }

  public AppointmentInfo personId(Integer personId) {
    this.personId = personId;
    return this;
  }

   /**
   * Get personId
   * @return personId
  **/
  @Schema(description = "")
  public Integer getPersonId() {
    return personId;
  }

  public void setPersonId(Integer personId) {
    this.personId = personId;
  }

  public AppointmentInfo appointmentTime(OffsetDateTime appointmentTime) {
    this.appointmentTime = appointmentTime;
    return this;
  }

   /**
   * Get appointmentTime
   * @return appointmentTime
  **/
  @Schema(description = "")
  public OffsetDateTime getAppointmentTime() {
    return appointmentTime;
  }

  public void setAppointmentTime(OffsetDateTime appointmentTime) {
    this.appointmentTime = appointmentTime;
  }

  public AppointmentInfo isNewPatientAppointment(Boolean isNewPatientAppointment) {
    this.isNewPatientAppointment = isNewPatientAppointment;
    return this;
  }

   /**
   * Get isNewPatientAppointment
   * @return isNewPatientAppointment
  **/
  @Schema(description = "")
  public Boolean isIsNewPatientAppointment() {
    return isNewPatientAppointment;
  }

  public void setIsNewPatientAppointment(Boolean isNewPatientAppointment) {
    this.isNewPatientAppointment = isNewPatientAppointment;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AppointmentInfo appointmentInfo = (AppointmentInfo) o;
    return Objects.equals(this.doctorId, appointmentInfo.doctorId) &&
        Objects.equals(this.personId, appointmentInfo.personId) &&
        Objects.equals(this.appointmentTime, appointmentInfo.appointmentTime) &&
        Objects.equals(this.isNewPatientAppointment, appointmentInfo.isNewPatientAppointment);
  }

  @Override
  public int hashCode() {
    return Objects.hash(doctorId, personId, appointmentTime, isNewPatientAppointment);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AppointmentInfo {\n");
    
    sb.append("    doctorId: ").append(toIndentedString(doctorId)).append("\n");
    sb.append("    personId: ").append(toIndentedString(personId)).append("\n");
    sb.append("    appointmentTime: ").append(toIndentedString(appointmentTime)).append("\n");
    sb.append("    isNewPatientAppointment: ").append(toIndentedString(isNewPatientAppointment)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}