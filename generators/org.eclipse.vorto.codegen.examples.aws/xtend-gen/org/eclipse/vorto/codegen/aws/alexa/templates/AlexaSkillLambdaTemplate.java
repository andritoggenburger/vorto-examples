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
package org.eclipse.vorto.codegen.aws.alexa.templates;

import com.google.common.base.Objects;
import java.util.Map;
import org.eclipse.emf.common.util.EList;
import org.eclipse.vorto.codegen.api.InvocationContext;
import org.eclipse.vorto.codegen.aws.alexa.templates.AbstractAlexaTemplate;
import org.eclipse.vorto.core.api.model.datatype.Property;
import org.eclipse.vorto.core.api.model.functionblock.FunctionBlock;
import org.eclipse.vorto.core.api.model.functionblock.FunctionblockModel;
import org.eclipse.vorto.core.api.model.functionblock.Status;
import org.eclipse.vorto.core.api.model.informationmodel.FunctionblockProperty;
import org.eclipse.vorto.core.api.model.informationmodel.InformationModel;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class AlexaSkillLambdaTemplate extends AbstractAlexaTemplate {
  @Override
  public String getFileName(final InformationModel context) {
    return "alexa-skillset-lambda.js";
  }
  
  @Override
  public String getContent(final InformationModel element, final InvocationContext context) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\'use strict\';");
    _builder.newLine();
    _builder.newLine();
    _builder.append(" ");
    _builder.append("var speechOutput;");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("var reprompt;");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("var welcomeOutput = \"Let\'s ask the ");
    String _name = element.getName();
    _builder.append(_name, " ");
    _builder.append(". What do you want to know?\";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    {
      Map<String, String> _configurationProperties = context.getConfigurationProperties();
      String _orDefault = _configurationProperties.getOrDefault("cloud", "");
      boolean _equalsIgnoreCase = _orDefault.equalsIgnoreCase("bosch");
      if (_equalsIgnoreCase) {
        _builder.append(" ");
        _builder.append("var thingsApiToken = \"INSERT API TOKEN OF BOSCH IOT THINGS HERE\";");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("var thingId = \"");
        Map<String, String> _configurationProperties_1 = context.getConfigurationProperties();
        String _orDefault_1 = _configurationProperties_1.getOrDefault("thingId", "INSERT THING ID HERE");
        _builder.append(_orDefault_1, " ");
        _builder.append("\";");
        _builder.newLineIfNotEmpty();
        _builder.append(" ");
        _builder.append("var username= \"INSERT USERNAME HERE\"; // escape special characters here example: \'\\\' ");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("var password= \"INSERT PASSWORD HERE\";");
        _builder.newLine();
        _builder.append(" ");
        _builder.newLine();
        _builder.append(" ");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("var http = require(\'https\');");
        _builder.newLine();
      }
    }
    {
      Map<String, String> _configurationProperties_2 = context.getConfigurationProperties();
      String _orDefault_2 = _configurationProperties_2.getOrDefault("cloud", "");
      boolean _equalsIgnoreCase_1 = _orDefault_2.equalsIgnoreCase("aws");
      if (_equalsIgnoreCase_1) {
        _builder.append(" ");
        _builder.append("var config = {");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("\t");
        _builder.append("\"thingName\": \"<PUT THING NAME HERE>\",");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("\t");
        _builder.append("\"endpointAddress\": \"<PUT YOUR ENDPOINT URL HERE>\"");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("}");
        _builder.newLine();
        _builder.append(" ");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("var AWS = require(\'aws-sdk\');");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("var iotdata = new AWS.IotData({endpoint: config.endpointAddress});");
        _builder.newLine();
      }
    }
    _builder.newLine();
    _builder.append("// --------------- Helpers that build all of the responses -----------------------");
    _builder.newLine();
    _builder.newLine();
    _builder.append("function buildSpeechletResponse(title, output, repromptText, shouldEndSession) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("outputSpeech: {");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("type: \'PlainText\',");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("text: output,");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("},");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("card: {");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("type: \'Simple\',");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("title: `SessionSpeechlet - ${title}`,");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("content: `SessionSpeechlet - ${output}`,");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("},");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("reprompt: {");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("outputSpeech: {");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("type: \'PlainText\',");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("text: repromptText,");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("},");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("},");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("shouldEndSession,");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("};");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("function buildResponse(sessionAttributes, speechletResponse) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("console.log(\"Responding with \" + JSON.stringify(speechletResponse));");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("version: \'1.0\',");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("sessionAttributes,");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("response: speechletResponse,");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("};");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append(" ");
    _builder.append("function buildSpeechletResponseDelegate(shouldEndSession) {");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("return {");
    _builder.newLine();
    _builder.append("          ");
    _builder.append("outputSpeech:null,");
    _builder.newLine();
    _builder.append("          ");
    _builder.append("directives: [");
    _builder.newLine();
    _builder.append("                  ");
    _builder.append("{");
    _builder.newLine();
    _builder.append("                      ");
    _builder.append("\"type\": \"Dialog.Delegate\",");
    _builder.newLine();
    _builder.append("                      ");
    _builder.append("\"updatedIntent\": null");
    _builder.newLine();
    _builder.append("                  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("              ");
    _builder.append("],");
    _builder.newLine();
    _builder.append("         ");
    _builder.append("reprompt: null,");
    _builder.newLine();
    _builder.append("          ");
    _builder.append("shouldEndSession: shouldEndSession");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    _builder.append("// --------------- Functions that control the skill\'s behavior -----------------------");
    _builder.newLine();
    _builder.newLine();
    _builder.append("function getWelcomeResponse(callback) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("console.log(\"in welcomeResponse\");");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("// If we wanted to initialize the session to have some attributes we could add those here.");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("const sessionAttributes = {};");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("const cardTitle = \'Welcome\';");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("const speechOutput = \'what do you want to do?\';");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("const repromptText = \"\";");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("const shouldEndSession = false;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("callback(sessionAttributes,");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("buildSpeechletResponse(cardTitle, speechOutput, repromptText, shouldEndSession));");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    {
      EList<FunctionblockProperty> _properties = element.getProperties();
      for(final FunctionblockProperty fbProperty : _properties) {
        {
          FunctionblockModel _type = fbProperty.getType();
          FunctionBlock _functionblock = _type.getFunctionblock();
          Status _status = _functionblock.getStatus();
          boolean _notEquals = (!Objects.equal(_status, null));
          if (_notEquals) {
            {
              FunctionblockModel _type_1 = fbProperty.getType();
              FunctionBlock _functionblock_1 = _type_1.getFunctionblock();
              Status _status_1 = _functionblock_1.getStatus();
              EList<Property> _properties_1 = _status_1.getProperties();
              for(final Property statusProperty : _properties_1) {
                _builder.append("function fetch");
                String _name_1 = fbProperty.getName();
                String _firstUpper = StringExtensions.toFirstUpper(_name_1);
                _builder.append(_firstUpper, "");
                String _name_2 = statusProperty.getName();
                String _firstUpper_1 = StringExtensions.toFirstUpper(_name_2);
                _builder.append(_firstUpper_1, "");
                _builder.append("(request, session, callback){");
                _builder.newLineIfNotEmpty();
                _builder.append("\t ");
                _builder.append("console.log(\"in fetch");
                String _name_3 = fbProperty.getName();
                String _firstUpper_2 = StringExtensions.toFirstUpper(_name_3);
                _builder.append(_firstUpper_2, "\t ");
                String _name_4 = statusProperty.getName();
                String _firstUpper_3 = StringExtensions.toFirstUpper(_name_4);
                _builder.append(_firstUpper_3, "\t ");
                _builder.append("\");");
                _builder.newLineIfNotEmpty();
                _builder.append("\t ");
                _builder.newLine();
                _builder.append("\t  ");
                _builder.append("var sessionAttributes = {};");
                _builder.newLine();
                {
                  Map<String, String> _configurationProperties_3 = context.getConfigurationProperties();
                  String _orDefault_3 = _configurationProperties_3.getOrDefault("cloud", "");
                  boolean _equalsIgnoreCase_2 = _orDefault_3.equalsIgnoreCase("bosch");
                  if (_equalsIgnoreCase_2) {
                    _builder.append("\t ");
                    _builder.append(" ");
                    _builder.append("var httpRequest = {");
                    _builder.newLine();
                    _builder.append("\t ");
                    _builder.append("\t ");
                    _builder.append("host : \"things.apps.bosch-iot-cloud.com\",");
                    _builder.newLine();
                    _builder.append("\t ");
                    _builder.append("\t ");
                    _builder.append("path: \"/api/2/things/\"+thingId,");
                    _builder.newLine();
                    _builder.append("\t ");
                    _builder.append("\t ");
                    _builder.append("method: \'GET\',");
                    _builder.newLine();
                    _builder.append("\t ");
                    _builder.append("\t ");
                    _builder.append("headers: {");
                    _builder.newLine();
                    _builder.append("\t ");
                    _builder.append("\t \t");
                    _builder.append("\'Content-Type\': \'application/json\',");
                    _builder.newLine();
                    _builder.append("\t ");
                    _builder.append("\t\t");
                    _builder.append("\'x-cr-api-token\': thingsApiToken,");
                    _builder.newLine();
                    _builder.append("\t ");
                    _builder.append("\t\t");
                    _builder.append("\'Authorization\' : \"Basic \" + new Buffer(username + \":\" + password).toString(\"base64\")");
                    _builder.newLine();
                    _builder.append("\t ");
                    _builder.append("\t ");
                    _builder.append("}");
                    _builder.newLine();
                    _builder.append("\t ");
                    _builder.append(" ");
                    _builder.append("};");
                    _builder.newLine();
                    _builder.append("\t ");
                    _builder.newLine();
                    _builder.append("\t ");
                    _builder.append("console.log(\"url: \"+JSON.stringify(httpRequest));");
                    _builder.newLine();
                    _builder.append("\t ");
                    _builder.append("http.get(httpRequest, function(response) {");
                    _builder.newLine();
                    _builder.append("\t ");
                    _builder.append("\t");
                    _builder.append("var bufferedData = [];");
                    _builder.newLine();
                    _builder.append("\t ");
                    _builder.append("   ");
                    _builder.append("response.on(\'data\', function(data) {");
                    _builder.newLine();
                    _builder.append("\t ");
                    _builder.append("      ");
                    _builder.append("bufferedData.push(data);");
                    _builder.newLine();
                    _builder.append("\t ");
                    _builder.append("   ");
                    _builder.append("});");
                    _builder.newLine();
                    _builder.append("\t ");
                    _builder.append("   ");
                    _builder.append("response.on(\'end\', function() {");
                    _builder.newLine();
                    _builder.append("\t ");
                    _builder.append("      ");
                    _builder.append("let buf = Buffer.concat(bufferedData);");
                    _builder.newLine();
                    _builder.append("\t ");
                    _builder.append("      ");
                    _builder.append("var result = JSON.parse(buf.toString(\'utf8\'));");
                    _builder.newLine();
                    _builder.append("\t ");
                    _builder.append("      ");
                    _builder.append("speechOutput = result.features.");
                    String _name_5 = fbProperty.getName();
                    _builder.append(_name_5, "\t       ");
                    _builder.append(".properties.status.");
                    String _name_6 = statusProperty.getName();
                    _builder.append(_name_6, "\t       ");
                    _builder.append(";");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t ");
                    _builder.append("      ");
                    _builder.append("//say the results");
                    _builder.newLine();
                    _builder.append("\t ");
                    _builder.append("      ");
                    _builder.append("callback(sessionAttributes, buildSpeechletResponse(\"");
                    String _name_7 = fbProperty.getName();
                    _builder.append(_name_7, "\t       ");
                    _builder.append("\", speechOutput, \"\", true));");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t ");
                    _builder.append("   ");
                    _builder.append("});");
                    _builder.newLine();
                    _builder.append("\t ");
                    _builder.append("});");
                    _builder.newLine();
                  }
                }
                {
                  Map<String, String> _configurationProperties_4 = context.getConfigurationProperties();
                  String _orDefault_4 = _configurationProperties_4.getOrDefault("cloud", "");
                  boolean _equalsIgnoreCase_3 = _orDefault_4.equalsIgnoreCase("aws");
                  if (_equalsIgnoreCase_3) {
                    _builder.append("\t ");
                    _builder.append("iotdata.getThingShadow({");
                    _builder.newLine();
                    _builder.append("\t ");
                    _builder.append("\t");
                    _builder.append("thingName: config.thingName");
                    _builder.newLine();
                    _builder.append("\t ");
                    _builder.append("},function(err, data) {");
                    _builder.newLine();
                    _builder.append("\t ");
                    _builder.append("\t");
                    _builder.append("if (err) {");
                    _builder.newLine();
                    _builder.append("\t ");
                    _builder.append("\t\t");
                    _builder.append("callback(err);");
                    _builder.newLine();
                    _builder.append("\t ");
                    _builder.append("\t");
                    _builder.append("} else {          ");
                    _builder.newLine();
                    _builder.append("\t ");
                    _builder.append("\t\t");
                    _builder.append("var jsonPayload = JSON.parse(data.payload);");
                    _builder.newLine();
                    _builder.append("\t ");
                    _builder.append("\t\t");
                    _builder.append("speechOutput = jsonPayload.state.reported[\"");
                    String _name_8 = element.getName();
                    _builder.append(_name_8, "\t \t\t");
                    _builder.append("\"];");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t ");
                    _builder.append("\t\t");
                    _builder.append("callback(sessionAttributes, buildSpeechletResponse(\"");
                    String _name_9 = fbProperty.getName();
                    _builder.append(_name_9, "\t \t\t");
                    _builder.append("\", speechOutput, \"\", true));");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t ");
                    _builder.append("\t");
                    _builder.append("}");
                    _builder.newLine();
                    _builder.append("\t ");
                    _builder.append("});");
                    _builder.newLine();
                  }
                }
                _builder.append("}");
                _builder.newLine();
              }
            }
          }
        }
      }
    }
    _builder.newLine();
    _builder.append("function handleSessionEndRequest(callback) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("const cardTitle = \'Session Ended\';");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("const speechOutput = \'Have a nice day!\';");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("// Setting this to true ends the session and exits the skill.");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("const shouldEndSession = true;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("callback({}, buildSpeechletResponse(cardTitle, speechOutput, null, shouldEndSession));");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("// --------------- Events -----------------------");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* Called when the session starts.");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("function onSessionStarted(sessionStartedRequest, session) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("console.log(`onSessionStarted requestId=${sessionStartedRequest.requestId}, sessionId=${session.sessionId}`);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* Called when the user launches the skill without specifying what they want.");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("function onLaunch(request, session, callback) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("//console.log(`onLaunch requestId=${launchRequest.requestId}, sessionId=${session.sessionId}`);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("console.log(\"in launchRequest\");");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("console.log(\"  request: \"+JSON.stringify(request));");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("// Dispatch to your skill\'s launch.");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("getWelcomeResponse(callback);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* Called when the user specifies an intent for this skill.");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("function onIntent(request, session, callback) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("//console.log(`onIntent requestId=${intentRequest.requestId}, sessionId=${session.sessionId}`);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("console.log(\"in onIntent\");");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("console.log(\"  request: \"+JSON.stringify(request));");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("const intent = request.intent;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("const intentName = request.intent.name;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("// Dispatch to your skill\'s intent handlers");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("if (intentName === \'AMAZON.HelpIntent\') {");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("getWelcomeResponse(callback);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("} else if (intentName === \'AMAZON.StopIntent\' || intentName === \'AMAZON.CancelIntent\') {");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("handleSessionEndRequest(callback);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("} ");
    _builder.newLine();
    {
      EList<FunctionblockProperty> _properties_2 = element.getProperties();
      for(final FunctionblockProperty fbProperty_1 : _properties_2) {
        {
          FunctionblockModel _type_2 = fbProperty_1.getType();
          FunctionBlock _functionblock_2 = _type_2.getFunctionblock();
          Status _status_2 = _functionblock_2.getStatus();
          boolean _notEquals_1 = (!Objects.equal(_status_2, null));
          if (_notEquals_1) {
            {
              FunctionblockModel _type_3 = fbProperty_1.getType();
              FunctionBlock _functionblock_3 = _type_3.getFunctionblock();
              Status _status_3 = _functionblock_3.getStatus();
              EList<Property> _properties_3 = _status_3.getProperties();
              for(final Property statusProperty_1 : _properties_3) {
                _builder.append("    ");
                _builder.append("else if (intentName === \'");
                String _name_10 = fbProperty_1.getName();
                String _replace = _name_10.replace("_", "");
                _builder.append(_replace, "    ");
                String _name_11 = statusProperty_1.getName();
                String _firstUpper_4 = StringExtensions.toFirstUpper(_name_11);
                String _replace_1 = _firstUpper_4.replace("_", "");
                _builder.append(_replace_1, "    ");
                _builder.append("\') {");
                _builder.newLineIfNotEmpty();
                _builder.append("    ");
                _builder.append("\t");
                _builder.append("fetch");
                String _name_12 = fbProperty_1.getName();
                String _firstUpper_5 = StringExtensions.toFirstUpper(_name_12);
                _builder.append(_firstUpper_5, "    \t");
                String _name_13 = statusProperty_1.getName();
                String _firstUpper_6 = StringExtensions.toFirstUpper(_name_13);
                _builder.append(_firstUpper_6, "    \t");
                _builder.append("(request, session, callback);");
                _builder.newLineIfNotEmpty();
                _builder.append("    ");
                _builder.append("}");
                _builder.newLine();
              }
            }
          }
        }
      }
    }
    _builder.append("   \t ");
    _builder.append("else {");
    _builder.newLine();
    _builder.append("   \t \t");
    _builder.append("throw new Error(\'Invalid intent\');");
    _builder.newLine();
    _builder.append("   \t ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* Called when the user ends the session.");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* Is not called when the skill returns shouldEndSession=true.");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("function onSessionEnded(sessionEndedRequest, session) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("console.log(`onSessionEnded requestId=${sessionEndedRequest.requestId}, sessionId=${session.sessionId}`);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("// Add cleanup logic here");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    _builder.append("// --------------- Main handler -----------------------");
    _builder.newLine();
    _builder.newLine();
    _builder.append("// Route the incoming request based on type (LaunchRequest, IntentRequest,");
    _builder.newLine();
    _builder.append("// etc.) The JSON body of the request is provided in the event parameter.");
    _builder.newLine();
    _builder.append("exports.handler = (event, context, callback) => {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("try {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("// console.log(`event.session.application.applicationId=${event.session.application.applicationId}`);");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("console.log(\"EVENT=====\" + JSON.stringify(event));");
    _builder.newLine();
    _builder.newLine();
    _builder.append("        ");
    _builder.append("/**");
    _builder.newLine();
    _builder.append("         ");
    _builder.append("* Uncomment this if statement and populate with your skill\'s application ID to");
    _builder.newLine();
    _builder.append("         ");
    _builder.append("* prevent someone else from configuring a skill that sends requests to this function.");
    _builder.newLine();
    _builder.append("         ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("/*");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("if (event.session.application.applicationId !== \'amzn1.echo-sdk-ams.app.[unique-value-here]\') {");
    _builder.newLine();
    _builder.append("             ");
    _builder.append("callback(\'Invalid Application ID\');");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("*/");
    _builder.newLine();
    _builder.newLine();
    _builder.append("        ");
    _builder.append("if (event.session.new) {");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("onSessionStarted({ requestId: event.request.requestId }, event.session);");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("        ");
    _builder.append("if (event.request.type === \'LaunchRequest\') {");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("onLaunch(event.request,");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("event.session,");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("(sessionAttributes, speechletResponse) => {");
    _builder.newLine();
    _builder.append("                    ");
    _builder.append("callback(null, buildResponse(sessionAttributes, speechletResponse));");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("});");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("} else if (event.request.type === \'IntentRequest\') {");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("onIntent(event.request,");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("event.session,");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("(sessionAttributes, speechletResponse) => {");
    _builder.newLine();
    _builder.append("                    ");
    _builder.append("callback(null, buildResponse(sessionAttributes, speechletResponse));");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("});");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("} else if (event.request.type === \'SessionEndedRequest\') {");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("onSessionEnded(event.request, event.session);");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("callback();");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("} catch (err) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("callback(err);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("};");
    _builder.newLine();
    return _builder.toString();
  }
}