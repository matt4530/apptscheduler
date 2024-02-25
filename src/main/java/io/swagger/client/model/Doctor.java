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
import com.google.gson.annotations.SerializedName;
import java.io.IOException;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

/**
 * Gets or Sets Doctor
 */
@JsonAdapter(Doctor.Adapter.class)
public enum Doctor {
  @SerializedName("1")
  NUMBER_1(1),
  @SerializedName("2")
  NUMBER_2(2),
  @SerializedName("3")
  NUMBER_3(3);

  private Integer value;

  Doctor(Integer value) {
    this.value = value;
  }

  public Integer getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  public static Doctor fromValue(Integer input) {
    for (Doctor b : Doctor.values()) {
      if (b.value.equals(input)) {
        return b;
      }
    }
    return null;
  }

  public static class Adapter extends TypeAdapter<Doctor> {
    @Override
    public void write(final JsonWriter jsonWriter, final Doctor enumeration) throws IOException {
      jsonWriter.value(String.valueOf(enumeration.getValue()));
    }

    @Override
    public Doctor read(final JsonReader jsonReader) throws IOException {
      Object value = jsonReader.nextInt();
      return Doctor.fromValue((Integer)(value));
    }
  }
}