/**
 * Copyright (c) 2015-2016 Bosch Software Innovations GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v1.0 which accompany this distribution.
 * 
 * The Eclipse Public License is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 * 
 * Contributors:
 * Bosch Software Innovations GmbH - Please refer to git log
 */
package org.eclipse.vorto.codegen.webui.templates;

import java.util.Map;
import org.eclipse.vorto.codegen.api.IFileTemplate;
import org.eclipse.vorto.codegen.api.InvocationContext;
import org.eclipse.vorto.core.api.model.informationmodel.InformationModel;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class PomTemplate implements IFileTemplate<InformationModel> {
  @Override
  public String getFileName(final InformationModel context) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("pom.xml");
    return _builder.toString();
  }
  
  @Override
  public String getPath(final InformationModel context) {
    StringConcatenation _builder = new StringConcatenation();
    String _name = context.getName();
    String _lowerCase = _name.toLowerCase();
    _builder.append(_lowerCase, "");
    _builder.append("-solution");
    return _builder.toString();
  }
  
  @Override
  public String getContent(final InformationModel element, final InvocationContext context) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
    _builder.newLine();
    _builder.append("<project xmlns=\"http://maven.apache.org/POM/4.0.0\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("xsi:schemaLocation=\"http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd\">");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<modelVersion>4.0.0</modelVersion>");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<groupId>com.example.iot.");
    String _name = element.getName();
    String _lowerCase = _name.toLowerCase();
    _builder.append(_lowerCase, "\t");
    _builder.append("</groupId>");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("<artifactId>");
    String _name_1 = element.getName();
    String _lowerCase_1 = _name_1.toLowerCase();
    _builder.append(_lowerCase_1, "\t");
    _builder.append("-solution</artifactId>");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("<version>0.0.1-SNAPSHOT</version>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<packaging>jar</packaging>");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<name>");
    String _name_2 = element.getName();
    _builder.append(_name_2, "\t");
    _builder.append(" Solution</name>");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("<description>Generated dashboard application for ");
    String _name_3 = element.getName();
    _builder.append(_name_3, "\t");
    _builder.append(" devices</description>");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<parent>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<groupId>org.springframework.boot</groupId>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<artifactId>spring-boot-starter-parent</artifactId>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<version>1.4.6.RELEASE</version>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("</parent>");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<repositories>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<repository>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<id>bosch-releases</id>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<name>bosch-releases</name>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<url>https://maven.bosch-si.com/content/repositories/bosch-releases/</url>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("</repository>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("</repositories>");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<properties>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<java.version>1.8</java.version>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<vorto.version>0.10.0.M1</vorto.version>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("</properties>");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<dependencies>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<dependency>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<groupId>org.springframework.boot</groupId>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<artifactId>spring-boot-starter-security</artifactId>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("</dependency>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<dependency>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<groupId>org.springframework.boot</groupId>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<artifactId>spring-boot-starter-web</artifactId>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("</dependency>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    {
      Map<String, String> _configurationProperties = context.getConfigurationProperties();
      String _orDefault = _configurationProperties.getOrDefault("history", "true");
      boolean _equalsIgnoreCase = _orDefault.equalsIgnoreCase("true");
      if (_equalsIgnoreCase) {
        _builder.append("\t\t");
        _builder.append("<dependency>");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("<groupId>org.springframework.boot</groupId>");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("<artifactId>spring-boot-starter-data-jpa</artifactId>");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("</dependency>");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("<dependency>");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("<groupId>com.h2database</groupId>");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("<artifactId>h2</artifactId>");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("</dependency>");
        _builder.newLine();
      }
    }
    _builder.append("\t\t");
    _builder.append("<dependency>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<groupId>org.springframework.boot</groupId>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<artifactId>spring-boot-starter-websocket</artifactId>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("</dependency>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<dependency>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<groupId>org.springframework.security.oauth</groupId>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<artifactId>spring-security-oauth2</artifactId>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("</dependency>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<dependency>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<groupId>org.springframework.boot</groupId>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<artifactId>spring-boot-starter-test</artifactId>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<scope>test</scope>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("</dependency>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<dependency>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<groupId>org.eclipse.vorto</groupId>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<artifactId>repository-java-client</artifactId>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<version>${vorto.version}</version>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("</dependency>");
    _builder.newLine();
    {
      Map<String, String> _configurationProperties_1 = context.getConfigurationProperties();
      String _orDefault_1 = _configurationProperties_1.getOrDefault("boschcloud", "false");
      boolean _equalsIgnoreCase_1 = _orDefault_1.equalsIgnoreCase("true");
      if (_equalsIgnoreCase_1) {
        _builder.append("\t\t");
        _builder.append("<dependency>");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("<groupId>com.bosch.cr</groupId>");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("<artifactId>cr-integration-client</artifactId>");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("<version>2.4.1</version>");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("</dependency>");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("<dependency>");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("<groupId>com.bosch.im</groupId>");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("<artifactId>im-api2-client</artifactId>");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("<version>1.0-beta2</version>");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("</dependency>");
        _builder.newLine();
      }
    }
    _builder.append("\t\t");
    _builder.append("<dependency>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<groupId>org.webjars</groupId>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<artifactId>webjars-locator</artifactId>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("</dependency>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<dependency>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<groupId>org.webjars</groupId>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<artifactId>jquery</artifactId>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<version>2.1.1</version>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("</dependency>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<dependency>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<groupId>org.webjars</groupId>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<artifactId>angularjs</artifactId>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<version>1.5.9</version>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("</dependency>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<dependency>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<groupId>org.webjars.bower</groupId>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<artifactId>angular-ui-router</artifactId>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<version>0.3.2</version>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("</dependency>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<dependency>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<groupId>org.webjars</groupId>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<artifactId>angular-ui-bootstrap</artifactId>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<version>0.14.3</version>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("</dependency>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<dependency>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<groupId>org.webjars</groupId>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<artifactId>angular-leaflet-directive</artifactId>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<version>0.8.2</version>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("</dependency>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<dependency>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<groupId>org.webjars</groupId>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<artifactId>leaflet</artifactId>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<version>1.0.0</version>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("</dependency>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<dependency>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<groupId>org.webjars</groupId>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<artifactId>angular-nvd3</artifactId>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<version>1.0.5</version>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("</dependency>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<dependency>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<groupId>org.webjars</groupId>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<artifactId>justgage</artifactId>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<version>1.1.0</version>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("</dependency>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<dependency>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<groupId>org.webjars</groupId>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<artifactId>sockjs-client</artifactId>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<version>0.3.4</version>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("</dependency>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<dependency>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<groupId>org.webjars</groupId>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<artifactId>stomp-websocket</artifactId>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<version>2.3.3</version>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("</dependency>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<dependency>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<groupId>org.webjars.bower</groupId>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<artifactId>adminlte</artifactId>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<version>2.3.11</version>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("</dependency>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<dependency>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<groupId>org.webjars</groupId>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<artifactId>font-awesome</artifactId>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<version>4.2.0</version>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("</dependency>");
    _builder.newLine();
    {
      Map<String, String> _configurationProperties_2 = context.getConfigurationProperties();
      String _orDefault_2 = _configurationProperties_2.getOrDefault("swagger", "true");
      boolean _equalsIgnoreCase_2 = _orDefault_2.equalsIgnoreCase("true");
      if (_equalsIgnoreCase_2) {
        _builder.append("\t\t");
        _builder.append("<!-- Swagger -->");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("<dependency>");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("<groupId>io.swagger</groupId>");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("<artifactId>swagger-annotations</artifactId>");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("<version>1.5.6</version>");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("</dependency>");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("<dependency>");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("<groupId>io.swagger</groupId>");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("<artifactId>swagger-models</artifactId>");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("<version>1.5.6</version>");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("</dependency>");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("<dependency>");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("<groupId>io.springfox</groupId>");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("<artifactId>springfox-swagger2</artifactId>");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("<version>2.3.0</version>");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("<exclusions>");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t\t");
        _builder.append("<exclusion>");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t\t\t");
        _builder.append("<groupId>io.swagger</groupId>");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t\t\t");
        _builder.append("<artifactId>swagger-annotations</artifactId>");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t\t");
        _builder.append("</exclusion>");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t\t");
        _builder.append("<exclusion>");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t\t\t");
        _builder.append("<groupId>io.swagger</groupId>");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t\t\t");
        _builder.append("<artifactId>swagger-models</artifactId>");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t\t");
        _builder.append("</exclusion>");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("</exclusions>");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("</dependency>");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("<dependency>");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("<groupId>org.webjars.bower</groupId>");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("<artifactId>angular-swagger-ui</artifactId>");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("<version>0.2.7</version>");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("<exclusions>");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t\t");
        _builder.append("<exclusion>");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t\t\t");
        _builder.append("<groupId>org.webjars.bower</groupId>");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t\t\t");
        _builder.append("<artifactId>jquery</artifactId>");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t\t");
        _builder.append("</exclusion>");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t\t");
        _builder.append("<exclusion>");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t\t\t");
        _builder.append("<groupId>org.webjars.bower</groupId>");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t\t\t");
        _builder.append("<artifactId>bootstrap-less-only</artifactId>");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t\t");
        _builder.append("</exclusion>");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t\t");
        _builder.append("<exclusion>");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t\t\t");
        _builder.append("<groupId>org.webjars.bower</groupId>");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t\t\t");
        _builder.append("<artifactId>angular</artifactId>");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t\t");
        _builder.append("</exclusion>");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("</exclusions>");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("</dependency>");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.append("</dependencies>");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<build>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<plugins>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<plugin>");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("<groupId>org.springframework.boot</groupId>");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("<artifactId>spring-boot-maven-plugin</artifactId>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("</plugin>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("</plugins>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<pluginManagement>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<plugins>");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("<!--This plugin\'s configuration is used to store Eclipse m2e settings ");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("only. It has no influence on the Maven build itself. -->");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("<plugin>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("<groupId>org.eclipse.m2e</groupId>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("<artifactId>lifecycle-mapping</artifactId>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("<version>1.0.0</version>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("<configuration>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("<lifecycleMappingMetadata>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t");
    _builder.append("<pluginExecutions>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t");
    _builder.append("<pluginExecution>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t\t");
    _builder.append("<pluginExecutionFilter>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t\t\t");
    _builder.append("<groupId>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t\t\t\t");
    _builder.append("org.apache.maven.plugins");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t\t\t");
    _builder.append("</groupId>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t\t\t");
    _builder.append("<artifactId>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t\t\t\t");
    _builder.append("maven-antrun-plugin");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t\t\t");
    _builder.append("</artifactId>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t\t\t");
    _builder.append("<versionRange>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t\t\t\t");
    _builder.append("[1.7,)");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t\t\t");
    _builder.append("</versionRange>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t\t\t");
    _builder.append("<goals>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t\t\t\t");
    _builder.append("<goal>run</goal>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t\t\t");
    _builder.append("</goals>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t\t");
    _builder.append("</pluginExecutionFilter>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t\t");
    _builder.append("<action>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t\t\t");
    _builder.append("<ignore></ignore>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t\t");
    _builder.append("</action>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t");
    _builder.append("</pluginExecution>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t");
    _builder.append("</pluginExecutions>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("</lifecycleMappingMetadata>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("</configuration>");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("</plugin>");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("<plugin>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("<groupId>org.springframework.boot</groupId>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("<artifactId>spring-boot-maven-plugin</artifactId>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("<executions>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("<execution>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t");
    _builder.append("<goals>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t");
    _builder.append("<goal>repackage</goal>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t");
    _builder.append("</goals>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("</execution>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("</executions>");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("</plugin>");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("<plugin>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("<groupId>org.apache.maven.plugins</groupId>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("<artifactId>maven-jar-plugin</artifactId>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("<configuration>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("<archive>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t");
    _builder.append("<manifest>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t");
    _builder.append("<mainClass>com.example.iot.");
    String _name_4 = element.getName();
    String _lowerCase_2 = _name_4.toLowerCase();
    _builder.append(_lowerCase_2, "\t\t\t\t\t\t\t\t");
    _builder.append(".");
    String _name_5 = element.getName();
    _builder.append(_name_5, "\t\t\t\t\t\t\t\t");
    _builder.append("Application</mainClass>");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t\t\t\t\t");
    _builder.append("</manifest>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("</archive>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("</configuration>");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("</plugin>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("</plugins>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("</pluginManagement>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("</build>");
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    _builder.append("</project>");
    _builder.newLine();
    return _builder.toString();
  }
}