/**
 * 	Licensed to the Apache Software Foundation (ASF) under one
 * 	or more contributor license agreements.  See the NOTICE file
 * 	distributed with this work for additional information
 * 	regarding copyright ownership.  The ASF licenses this file
 * 	to you under the Apache License, Version 2.0 (the
 * 	"License"); you may not use this file except in compliance
 * 	with the License.  You may obtain a copy of the License at
 *
 * 	http://www.apache.org/licenses/LICENSE-2.0
 *
 * 	Unless required by applicable law or agreed to in writing,
 * 	software distributed under the License is distributed on an
 * 	"AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * 	KIND, either express or implied.  See the License for the
 * 	specific language governing permissions and limitations
 * 	under the License.
 */
package org.apache.uima.alchemy.digester.categorization;

import org.apache.commons.digester.Digester;
import org.apache.uima.alchemy.digester.OutputDigester;
import org.apache.uima.alchemy.digester.domain.CategorizationResults;
import org.apache.uima.alchemy.digester.domain.Results;
import org.apache.uima.alchemy.digester.json.JsonDigester;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;

public class JsonTextCategorizationDigester implements OutputDigester {

  public Results parseAlchemyXML(InputStream stream) throws IOException, SAXException,
          URISyntaxException {

    Digester digester = new JsonDigester();
    digester.setValidating(false);
    digester.addObjectCreate("$", CategorizationResults.class);
    digester.addBeanPropertySetter("$/status", "status");
    digester.addBeanPropertySetter("$/statusInfo", "statusInfo");
    digester.addBeanPropertySetter("$/url", "url");
    digester.addBeanPropertySetter("$/language", "language");
    digester.addBeanPropertySetter("$/category", "category");
    digester.addBeanPropertySetter("$/score", "score");
    return (Results) digester.parse(stream);
  }

}
