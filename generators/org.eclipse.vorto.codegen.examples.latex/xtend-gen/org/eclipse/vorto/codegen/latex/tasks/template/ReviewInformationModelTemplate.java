/**
 * Copyright (c) 2015 Bosch Software Innovations GmbH and others.
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
package org.eclipse.vorto.codegen.latex.tasks.template;

import org.eclipse.emf.common.util.EList;
import org.eclipse.vorto.codegen.api.ITemplate;
import org.eclipse.vorto.codegen.api.InvocationContext;
import org.eclipse.vorto.codegen.latex.tasks.template.LatexEntityTemplate;
import org.eclipse.vorto.codegen.latex.tasks.template.LatexEnumTemplate;
import org.eclipse.vorto.codegen.latex.tasks.template.LatexFBPropertyTemplate;
import org.eclipse.vorto.codegen.latex.tasks.template.LatexFunctionBlockTemplate;
import org.eclipse.vorto.codegen.utils.Utils;
import org.eclipse.vorto.core.api.model.datatype.Entity;
import org.eclipse.vorto.core.api.model.functionblock.FunctionBlock;
import org.eclipse.vorto.core.api.model.functionblock.FunctionblockModel;
import org.eclipse.vorto.core.api.model.informationmodel.FunctionblockProperty;
import org.eclipse.vorto.core.api.model.informationmodel.InformationModel;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class ReviewInformationModelTemplate implements ITemplate<InformationModel> {
  private LatexFunctionBlockTemplate fbTemplate;
  
  private LatexEntityTemplate entityTemplate;
  
  private LatexEnumTemplate enumTemplate;
  
  private LatexFBPropertyTemplate fbPropertyTemplate;
  
  public ReviewInformationModelTemplate(final LatexFBPropertyTemplate fbPropertyTemplate, final LatexFunctionBlockTemplate fbTemplate, final LatexEntityTemplate entityTemplate, final LatexEnumTemplate enumTemplate) {
    this.fbTemplate = fbTemplate;
    this.entityTemplate = entityTemplate;
    this.enumTemplate = enumTemplate;
    this.fbPropertyTemplate = fbPropertyTemplate;
  }
  
  @Override
  public String getContent(final InformationModel im, final InvocationContext invocationContext) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\\documentclass[10pt]{article}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\\setlength{\\textwidth}{16,5cm}");
    _builder.newLine();
    _builder.append("\\setlength{\\textheight}{23cm}");
    _builder.newLine();
    _builder.append("\\setlength{\\oddsidemargin}{-1cm}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\\begin{document}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\\title{\\textbf{");
    String _displayname = im.getDisplayname();
    String _replace = _displayname.replace("_", "\\_");
    _builder.append(_replace, "\t");
    _builder.append("}}");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("\\author{Generated by Eclipse Vorto}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\\maketitle");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("This document has been created by Eclipse Vorto based on the Information Model ");
    _builder.newLine();
    _builder.append("\t");
    String _displayname_1 = im.getDisplayname();
    String _replace_1 = _displayname_1.replace("_", "\\_");
    _builder.append(_replace_1, "\t");
    _builder.append("\\footnote{Name: ");
    String _name = im.getName();
    String _replace_2 = _name.replace("_", "\\_");
    _builder.append(_replace_2, "\t");
    _builder.append(", Namespace: ");
    String _namespace = im.getNamespace();
    _builder.append(_namespace, "\t");
    _builder.append(", Version: ");
    String _version = im.getVersion();
    _builder.append(_version, "\t");
    _builder.append(".} which is");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("described in the section below:");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\\section{Information Model Specification}");
    _builder.newLine();
    _builder.append("\t");
    String _description = im.getDescription();
    _builder.append(_description, "\t");
    _builder.append("\\\\\\\\");
    _builder.newLineIfNotEmpty();
    {
      EList<FunctionblockProperty> _properties = im.getProperties();
      for(final FunctionblockProperty fbProperty : _properties) {
        _builder.append("\t");
        String _content = this.fbPropertyTemplate.getContent(fbProperty, invocationContext);
        _builder.append(_content, "\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\\section{Functionblock Specification}");
    _builder.newLine();
    {
      EList<FunctionblockProperty> _properties_1 = im.getProperties();
      for(final FunctionblockProperty fbProperty_1 : _properties_1) {
        _builder.append("\t");
        FunctionblockModel _type = fbProperty_1.getType();
        String _content_1 = this.fbTemplate.getContent(_type, invocationContext);
        _builder.append(_content_1, "\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\\section{Datatype Specification}");
    _builder.newLine();
    {
      EList<FunctionblockProperty> _properties_2 = im.getProperties();
      for(final FunctionblockProperty fbProperty_2 : _properties_2) {
        {
          FunctionblockModel _type_1 = fbProperty_2.getType();
          FunctionBlock _functionblock = _type_1.getFunctionblock();
          EList<Entity> _referencedEntities = Utils.getReferencedEntities(_functionblock);
          for(final Entity type : _referencedEntities) {
            _builder.append("\t");
            String _content_2 = this.entityTemplate.getContent(type, invocationContext);
            _builder.append(_content_2, "\t");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    _builder.append("\\end{document}");
    _builder.newLine();
    return _builder.toString();
  }
}